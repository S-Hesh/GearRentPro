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
    *(Note: Check your `DBConnection.java` file to ensure the database name matches `gearretnpro`)*

3.  **Run the Schema Scripts in the coursework zip file:**    
4.  **Insert Data from the sample data script in coursework zip file**
   
##  How to Run the Application

1.  **Open in NetBeans:**
    * Launch NetBeans IDE.
    * Go to `File` -> `Open Project` and select the `Coursework2` folder.
2.  **Check Database Connection:**
    * Open `src/edu/ijse/coursework2/db/DBConnection.java`.
    * Ensure the `URL`, `USER`, and `PASSWORD` match your local MySQL configuration.
3.  **Build Project:**
    * Right-click the project -> `Clean and Build`.
4.  **Run:*

---

##  Default Login Credentials

Use the following credentials to test the different access levels:

| Role | Username | Password | Access Level |
| :--- | :--- | :--- | :--- |
| **System Admin** | `admin` | `admin123` | **Full Access** (Users, Branches, Reports, Settings) |
| **Branch Manager** | `cmgr` | `cmgr123` | **Branch Operations** (Rentals, Inventory, Customers) |
| **Staff Member** | `cstaff` | `cstaff123` | **Limited Access** (Rentals, Returns only) |
