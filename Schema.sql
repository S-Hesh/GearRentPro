-- ==========================================================
-- GearRent Pro - BASIC MySQL Schema (Simplified)
-- MySQL Server: 8.0.43
-- Database: gearrentpro
-- Base package (Java): edu.ijse.coursework2
--
-- Notes:
-- 1) No CHECK constraints (validate in Java Service layer)
-- 2) Status/Role/Level are VARCHAR (validate in Java)
-- 3) Overlap rules (reservations/rentals) are enforced in Service layer,
--    not by DB constraints.
-- ==========================================================

CREATE DATABASE IF NOT EXISTS gearrentpro
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci;

USE gearrentpro;

-- ---------- DROP TABLES (development convenience) ----------
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS rental;
DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS equipment;
DROP TABLE IF EXISTS system_user;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS membership_level;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS branch;
DROP TABLE IF EXISTS app_settings;

SET FOREIGN_KEY_CHECKS = 1;

-- ==========================================================
-- 1) App Settings (single-row table)
-- ==========================================================
CREATE TABLE app_settings (
  settings_id TINYINT PRIMARY KEY,          -- always keep 1 row with id=1
  deposit_limit DECIMAL(12,2) NOT NULL,     -- e.g. 500000.00
  max_rental_days INT NOT NULL,             -- e.g. 30
  long_rental_min_days INT NOT NULL,        -- e.g. 7
  long_rental_discount_percent DECIMAL(5,2) NOT NULL, -- e.g. 5.00
  global_late_fee_per_day DECIMAL(10,2) NULL
) ENGINE=InnoDB;

-- Insert the single settings row (edit values as you like)
INSERT INTO app_settings (
  settings_id, deposit_limit, max_rental_days, long_rental_min_days,
  long_rental_discount_percent, global_late_fee_per_day
) VALUES (1, 500000.00, 30, 7, 0.00, NULL);

-- ==========================================================
-- 2) Branch
-- ==========================================================
CREATE TABLE branch (
  branch_id VARCHAR(10) PRIMARY KEY,   -- e.g. B001
  name VARCHAR(100) NOT NULL,
  address VARCHAR(255) NOT NULL,
  contact_no VARCHAR(20) NOT NULL
) ENGINE=InnoDB;

-- ==========================================================
-- 3) Category (pricing rules)
-- ==========================================================
CREATE TABLE category (
  category_id VARCHAR(10) PRIMARY KEY, -- e.g. CAT001
  name VARCHAR(50) NOT NULL,
  description VARCHAR(255) NULL,
  base_price_factor DECIMAL(6,2) NOT NULL,     -- e.g. 1.20
  weekend_multiplier DECIMAL(6,2) NOT NULL,    -- e.g. 1.30
  late_fee_per_day DECIMAL(10,2) NULL,         -- optional, can fallback to settings/global
  is_active TINYINT(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB;

-- ==========================================================
-- 4) Membership Level (discount % per level)
-- ==========================================================
CREATE TABLE membership_level (
  level_code VARCHAR(10) PRIMARY KEY,         -- REGULAR / SILVER / GOLD
  discount_percent DECIMAL(5,2) NOT NULL      -- e.g. 0.00, 5.00, 10.00
) ENGINE=InnoDB;

INSERT INTO membership_level(level_code, discount_percent) VALUES
('REGULAR', 0.00),
('SILVER',  5.00),
('GOLD',   10.00);

-- ==========================================================
-- 5) Customer
-- ==========================================================
CREATE TABLE customer (
  customer_id VARCHAR(10) PRIMARY KEY,        -- e.g. C001
  full_name VARCHAR(120) NOT NULL,
  nic_passport VARCHAR(20) NOT NULL,
  contact_no VARCHAR(20) NOT NULL,
  email VARCHAR(120) NULL,
  address VARCHAR(255) NULL,
  membership_level_code VARCHAR(10) NOT NULL DEFAULT 'REGULAR',
  UNIQUE KEY uq_customer_nic (nic_passport),
  CONSTRAINT fk_customer_membership
    FOREIGN KEY (membership_level_code)
    REFERENCES membership_level(level_code)
) ENGINE=InnoDB;

-- ==========================================================
-- 6) System Users (role-based access + branch scope)
-- ==========================================================
CREATE TABLE system_user (
  user_id VARCHAR(10) PRIMARY KEY,            -- e.g. U001
  full_name VARCHAR(120) NOT NULL,
  username VARCHAR(60) NOT NULL,
  password_hash VARCHAR(255) NOT NULL,        -- recommended: store a hash (not plain text)
  role VARCHAR(20) NOT NULL,                  -- ADMIN / BRANCH_MANAGER / STAFF
  branch_id VARCHAR(10) NULL,                 -- NULL for admin
  is_active TINYINT(1) NOT NULL DEFAULT 1,
  UNIQUE KEY uq_user_username (username),
  CONSTRAINT fk_user_branch
    FOREIGN KEY (branch_id) REFERENCES branch(branch_id)
) ENGINE=InnoDB;

-- ==========================================================
-- 7) Equipment (inventory per branch)
-- ==========================================================
CREATE TABLE equipment (
  equipment_id VARCHAR(10) PRIMARY KEY,       -- e.g. E001
  category_id VARCHAR(10) NOT NULL,
  branch_id VARCHAR(10) NOT NULL,
  brand VARCHAR(60) NOT NULL,
  model VARCHAR(80) NOT NULL,
  purchase_year SMALLINT NOT NULL,
  base_price_per_day DECIMAL(10,2) NOT NULL,
  security_deposit DECIMAL(12,2) NOT NULL,
  status VARCHAR(20) NOT NULL DEFAULT 'AVAILABLE', -- AVAILABLE/RESERVED/RENTED/MAINTENANCE
  is_active TINYINT(1) NOT NULL DEFAULT 1,
  CONSTRAINT fk_equipment_category
    FOREIGN KEY (category_id) REFERENCES category(category_id),
  CONSTRAINT fk_equipment_branch
    FOREIGN KEY (branch_id) REFERENCES branch(branch_id)
) ENGINE=InnoDB;

-- Helpful basic indexes
CREATE INDEX idx_equipment_branch_status ON equipment(branch_id, status);
CREATE INDEX idx_equipment_category ON equipment(category_id);

-- ==========================================================
-- 8) Reservation (blocks equipment for date range)
-- ==========================================================
CREATE TABLE reservation (
  reservation_id VARCHAR(12) PRIMARY KEY,     -- e.g. R00000000001
  equipment_id VARCHAR(10) NOT NULL,
  customer_id VARCHAR(10) NOT NULL,
  branch_id VARCHAR(10) NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',  -- ACTIVE/CANCELLED/CONVERTED
  created_by VARCHAR(10) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

  CONSTRAINT fk_res_equipment
    FOREIGN KEY (equipment_id) REFERENCES equipment(equipment_id),
  CONSTRAINT fk_res_customer
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
  CONSTRAINT fk_res_branch
    FOREIGN KEY (branch_id) REFERENCES branch(branch_id),
  CONSTRAINT fk_res_created_by
    FOREIGN KEY (created_by) REFERENCES system_user(user_id)
) ENGINE=InnoDB;

CREATE INDEX idx_res_equipment_dates ON reservation(equipment_id, start_date, end_date, status);

-- ==========================================================
-- 9) Rental (stores pricing/discount/payment/status + return settlement)
-- ==========================================================
CREATE TABLE rental (
  rental_id VARCHAR(12) PRIMARY KEY,          -- e.g. L00000000001
  reservation_id VARCHAR(12) NULL,            -- if created from reservation
  equipment_id VARCHAR(10) NOT NULL,
  customer_id VARCHAR(10) NOT NULL,
  branch_id VARCHAR(10) NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,

  calculated_rental_amount DECIMAL(12,2) NOT NULL, -- before discounts (deposit excluded)
  membership_discount_amount DECIMAL(12,2) NOT NULL DEFAULT 0.00,
  long_rental_discount_amount DECIMAL(12,2) NOT NULL DEFAULT 0.00,
  final_payable_amount DECIMAL(12,2) NOT NULL,     -- after discounts (deposit excluded)
  security_deposit DECIMAL(12,2) NOT NULL,

  amount_paid DECIMAL(12,2) NOT NULL DEFAULT 0.00,
  payment_status VARCHAR(20) NOT NULL DEFAULT 'UNPAID', -- PAID/PARTIALLY_PAID/UNPAID

  rental_status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',  -- ACTIVE/RETURNED/OVERDUE/CANCELLED

  -- Return / settlement fields
  actual_return_date DATE NULL,
  late_days INT NOT NULL DEFAULT 0,
  late_fee_amount DECIMAL(12,2) NOT NULL DEFAULT 0.00,
  damage_description TEXT NULL,
  damage_charge DECIMAL(12,2) NOT NULL DEFAULT 0.00,
  total_charges DECIMAL(12,2) NOT NULL DEFAULT 0.00,       -- late + damage
  refund_amount DECIMAL(12,2) NOT NULL DEFAULT 0.00,
  additional_payment_amount DECIMAL(12,2) NOT NULL DEFAULT 0.00,
  settled_at TIMESTAMP NULL,

  issued_by VARCHAR(10) NOT NULL,
  issued_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

  UNIQUE KEY uq_rental_reservation (reservation_id),

  CONSTRAINT fk_rental_reservation
    FOREIGN KEY (reservation_id) REFERENCES reservation(reservation_id),
  CONSTRAINT fk_rental_equipment
    FOREIGN KEY (equipment_id) REFERENCES equipment(equipment_id),
  CONSTRAINT fk_rental_customer
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
  CONSTRAINT fk_rental_branch
    FOREIGN KEY (branch_id) REFERENCES branch(branch_id),
  CONSTRAINT fk_rental_issued_by
    FOREIGN KEY (issued_by) REFERENCES system_user(user_id)
) ENGINE=InnoDB;

CREATE INDEX idx_rental_equipment_dates ON rental(equipment_id, start_date, end_date, rental_status);
CREATE INDEX idx_rental_enddate_status ON rental(end_date, rental_status);

-- ==========================================================
-- End of schema
-- ==========================================================
