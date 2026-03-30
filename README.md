# EmployeePulse
---

## Overview

A Java-based software project for managing employee records, including features for updating data, searching by SSN, and applying salary raises. Built as a collaborative group assignment for **CSC 3350** with UML design, test cases, and database integration using MySQL.

## Features

- **Add Employee** — Insert a new employee record with ID, name, SSN, job title, division, salary, and pay statement.
- **Update Employee** — Modify all fields for an existing employee by ID.
- **Search Employee** — Look up an employee by name, SSN, or employee ID.
- **Update Salary by Range** — Apply a percentage raise to every employee whose salary falls within a specified min/max range.
- **Show All Employees** — Display every employee record in the database.

## Tech Stack

- **Language:** Java
- **Database:** MySQL 8.x
- **JDBC Driver:** MySQL Connector/J (`com.mysql.cj.jdbc.Driver`)

## Project Structure

```
├── Main.java                    # Entry point — console menu and user input
├── Employee.java                # Data model with getters, setters, and toString
├── DatabaseHandler.java         # JDBC operations (insert, update, search, salary range update)
├── Part_A_UML.pdf               # Class, use case, and sequence diagrams
├── Part_B_Test_Cases.pdf        # Test case documentation
├── SabirinMohamed_13_SWDD.pdf   # Software Design Description Document
└── README.md
```

## Architecture

The system follows a simple three-class architecture with clear separation of concerns:

- **Main** — Console-based UI that displays the menu, captures user input, and delegates to DatabaseHandler.
- **Employee** — Pure data model encapsulating employee attributes (empId, name, SSN, jobTitle, division, salary, payStatement) with getters and setters.
- **DatabaseHandler** — Encapsulates all JDBC database operations including connections and SQL queries.

## Prerequisites

- Java JDK 8 or higher
- MySQL Server 8.x running on `localhost:3306`
- MySQL Connector/J JAR on the classpath

## Database Setup

1. Start your MySQL server.

2. Create the database and table:

```sql
CREATE DATABASE IF NOT EXISTS employeedata;
USE employeedata;

CREATE TABLE employee (
    empid        INT PRIMARY KEY,
    name         VARCHAR(100),
    ssn          VARCHAR(20),
    job_title    VARCHAR(100),
    division     VARCHAR(100),
    salary       DOUBLE,
    pay_statement VARCHAR(255)
);
```

3. Update the credentials in `DatabaseHandler.java` if your MySQL username or password differs from the defaults in the source.

## How to Compile & Run

```bash
# Compile (adjust the path to your Connector/J JAR)
javac -cp .:mysql-connector-j-8.x.x.jar Main.java Employee.java DatabaseHandler.java

# Run
java -cp .:mysql-connector-j-8.x.x.jar Main
```

On Windows, replace `:` with `;` in the classpath.

## Usage

When the application starts you will see the following menu:

```
--- Employee Management System ---
1. Add Employee
2. Update Employee
3. Search Employee
4. Update Salary by Range
5. Show All Employees
6. Exit
Choose an option:
```

Select an option by entering the corresponding number and follow the prompts.

## Testing

Three primary test cases have been defined for this project:

1. **Update Employee Data** — Confirms that updating an employee's fields by ID persists correctly to the database.
2. **Search Employee** — Verifies that searching by SSN returns the correct and complete employee record.
3. **Update Salary by Range** — Ensures all employees within a salary range receive the specified percentage raise and that the affected row count is accurate.

Refer to `Part_B_Test_Cases.pdf` for full test inputs, expected outputs, dependencies, and teardown steps.

## UML Documentation

Class diagrams, use case diagrams, and sequence diagrams are available in `Part_A_UML.pdf`.

## Software Design Document

The full Software Design Description (SWDD) is available in `SabirinMohamed_13_SWDD.pdf`. It covers system architecture, data design, data dictionary, component pseudocode, human interface design, and the requirements traceability matrix.
