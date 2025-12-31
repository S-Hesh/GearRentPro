# Equipment Rental Management System (Coursework 2)

## Project Description
This is a comprehensive Java Swing application designed to manage equipment rentals across multiple branches. It utilizes a Layered Architecture (MVC + DAO) to handle customers, inventory (equipment), rentals, reservations, and system user management with role-based access control.

## Key Features
* **User Management:** Role-based access (Admin, Branch Manager, Staff).
* **Branch Management:** Manage multiple branch locations.
* **Customer Management:** Register and update customer details.
* **Inventory/Equipment:** Track items available for rent.
* **Rentals & Returns:** Process rentals and handle return settlements.
* **Security:** Password hashing (SHA-256) and secure login sessions.

## Technology Stack
* **Language:** Java (JDK 17+)
* **GUI Framework:** Java Swing
* **Database:** MySQL
* **IDE:** NetBeans IDE
* **Architecture:** Layered (Controller, Service, DAO, Entity, DTO)

---

##⚙️ Database Configuration

1.  **Install MySQL Server** and ensure it is running on port `3306`.
2.  **Create the Database:**
    Open your SQL Client (HeidiSQL, MySQL Workbench) and run:
    ```sql
    CREATE DATABASE coursework_db;
    USE coursework_db;
    ```
    *(Note: Check your `DBConnection.java` file to ensure the database name matches `coursework_db`)*

3.  **Run the Schema Scripts:**
    Execute the following SQL scripts to create the necessary tables:

    ```sql
    -- Create Branch Table
    CREATE TABLE branch (
      branch_id VARCHAR(10) PRIMARY KEY,
      name VARCHAR(100) NOT NULL,
      address VARCHAR(255) NOT NULL,
      contact_no VARCHAR(20) NOT NULL
    ) ENGINE=InnoDB;

    -- Create System User Table
    CREATE TABLE system_user (
      user_id VARCHAR(10) PRIMARY KEY,
      full_name VARCHAR(120) NOT NULL,
      username VARCHAR(60) NOT NULL,
      password_hash VARCHAR(255) NOT NULL,
      role VARCHAR(20) NOT NULL,
      branch_id VARCHAR(10) NULL,
      is_active TINYINT(1) NOT NULL DEFAULT 1,
      UNIQUE KEY uq_user_username (username),
      CONSTRAINT fk_user_branch FOREIGN KEY (branch_id) REFERENCES branch(branch_id)
    ) ENGINE=InnoDB;
    ```

4.  **Insert Default Data:**
    Run this script to populate the system with initial branches and users:

    ```sql
    -- Insert Branches
    INSERT INTO branch VALUES 
    ('B001', 'Colombo Main', '123 Galle Rd, Colombo', '0112345678'),
    ('B002', 'Galle City', '45 Matara Rd, Galle', '0912345678');

    -- Insert Users (Passwords are hashed)
    INSERT INTO system_user VALUES
    ('U001', 'System Admin', 'admin', SHA2('admin123', 256), 'ADMIN', NULL, 1),
    ('U002', 'Colombo Manager', 'cmgr', SHA2('cmgr123', 256), 'BRANCH_MANAGER', 'B001', 1),
    ('U003', 'Colombo Staff', 'cstaff', SHA2('cstaff123', 256), 'STAFF', 'B001', 1);
    ```

---

##  How to Run the Application

1.  **Open in NetBeans:**
    * Launch NetBeans IDE.
    * Go to `File` -> `Open Project` and select the `Coursework2` folder.
2.  **Check Database Connection:**
    * Open `src/edu/ijse/coursework2/db/DBConnection.java`.
    * Ensure the `URL`, `USER`, and `PASSWORD` match your local MySQL configuration.
3.  **Build Project:**
    * Right-click the project -> `Clean and Build`.
4.  **Run:**
    * Right-click `LoginView.java` -> `Run File` (or press `Shift + F6`).

---

##  Default Login Credentials

Use the following credentials to test the different access levels:

| Role | Username | Password | Access Level |
| :--- | :--- | :--- | :--- |
| **System Admin** | `admin` | `admin123` | **Full Access** (Users, Branches, Reports, Settings) |
| **Branch Manager** | `cmgr` | `cmgr123` | **Branch Operations** (Rentals, Inventory, Customers) |
| **Staff Member** | `cstaff` | `cstaff123` | **Limited Access** (Rentals, Returns only) |

> **Note:** For security, you can change these passwords using the "Settings" -> "Change Password" feature in the dashboard.