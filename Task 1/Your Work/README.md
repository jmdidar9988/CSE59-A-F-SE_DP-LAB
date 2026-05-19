
# Software Requirements Specification (SRS)

## Preface

This document provides the Software Requirements Specification (SRS) for ShopNow. It defines the system’s functionalities, performance criteria, security requirements, and overall system architecture necessary for development.

---

## Version History

* **Version 1.0** – Initial Draft.
* **Version 1.1** – Added non-functional requirements and database schema breakdown.
* **Version 1.2** – Refined system evolution, tech stack mapping, and glossary.

---                

## 1. Introduction

### Purpose

ShopNow is a technology-focused e-commerce web application designed to simulate a real-world online shopping experience. The system streamlines product browsing, cart operations, secure checkouts, and inventory tracking to provide an optimized electronic retail platform for both customers and administrators.

### Document Conventions

This document follows the IEEE SRS standard, using:

* **Must** – Indicates mandatory requirements.
* **Should** – Indicates recommended features.
* **May** – Indicates optional enhancements.

### Intended Audience and Reading Suggestions

* **Project Managers & Developers** – For database implementation and Flask route handling guidance.
* **Stakeholders & Business Analysts** – To review business workflows like checkout and stock validation.
* **Testers & QA Teams** – To validate user roles, authentication safety, and CRUD functionality.

### Scope

The system provides:

* Secure customer and administrator authentication
* Product browsing, categorization, and live inventory management
* Persistent shopping cart operations
* Order creation, payment simulation, and historical tracking
* Relational database integrity managed via SQLAlchemy ORM
* Dedicated administrator dashboard for inventory control

### References

* IEEE Standard 830-1998 (Software Requirements Specification)
* Flask Framework Documentation (v3.x)
* MySQL Relational Database Design Standards

---

## 2. Overall Description

### Product Perspective

ShopNow is a standalone web application built using a monolithic architecture powered by Python (Flask). It manages persistent data using a centralized MySQL database engine deployed via local or cloud server environments (XAMPP / phpMyAdmin).

### Product Functions

* **Authentication:** Secure user registration, credential hashing, and session management.
* **Catalog Management:** Categorized item display with support for multi-image product arrays.
* **Cart Operations:** Dynamic allocation, volume correction, and item removal mechanisms.
* **Transaction Execution:** Automated checkout processing, stock volume deduction, and simulated payment logging.
* **Inventory Control:** Full administrative authorization to perform Create, Read, Update, and Delete (CRUD) operations on platform assets.

### User Classes and Characteristics

* **Admin:** Privileged operator with access to metrics, financial order logs, and full catalog control.
* **Customer:** Public consumer authorized to manage personal profiles, carts, and view active order histories.

### Operating Environment

* Web-based application (accessible via Chrome, Firefox, Safari, Edge).
* **Backend Runtime:** Python 3.10+ / Flask.
* **Database Engine:** MySQL Server (managed via XAMPP / phpMyAdmin).

### Design and Implementation Constraints

* **CSRF Protection:** Mandatory compliance using Flask-WTF tokens on all data submittal forms.
* **Data Normalization:** Relational database structures must maintain high data integrity to prevent orphaned transaction logs.

### Assumptions and Dependencies

* Active connection to the database server is mandatory for catalog rendering.
* System states rely on server-side session cookies managed via Flask-Login.

---

## 3. System Requirements Specification

### Functional Requirements

* **User Authentication**
* The system must allow guest users to register accounts safely.
* The system must validate roles during session initialization (Customer vs. Admin).
* The system must encrypt passwords prior to database storage.


* **Product Discovery**
* The system must display active product catalogs sorted by predefined Categories.
* The system must reflect stock availability flags dynamically on the product page.


* **Cart & Checkout Management**
* Customers must be able to alter individual quantities inside the shopping cart.
* The system must preserve cart states across separate user sessions.
* The checkout routine must verify real-time inventory limits before solidifying an order.


* **Order & Payment Simulation**
* The system must record unique transaction entries in the Orders map upon checkout completion.
* The system must simulate payment authorization processes and generate transactional status updates.


* **Administrative Content Control**
* Administrators must be granted absolute access to add, update, or remove products and attached item photos.
* Administrators should be presented with a structural dashboard summarizing system-wide sales volumes.



### Non-Functional Requirements

* **Performance Requirements**
* Page render times across typical browsing pathways should not exceed 2.0 seconds.
* Relational inventory balances must update instantly upon transaction execution.


* **Security Requirements**
* Cross-Site Request Forgery (CSRF) defenses must protect all transactional endpoints.
* Unauthenticated web traffic requesting protected routes must be redirected back to the login interface.


* **Usability Requirements**
* The user interface must deploy fluid grids (Bootstrap) to support smartphones, tablets, and desktop displays seamlessly.


* **Reliability and Availability**
* The system database layout must incorporate Foreign Key cascading to protect structural data connections from breaking during deletes.


* **Maintainability and Support**
* The application layer should use an Object-Relational Mapper (SQLAlchemy ORM) to simplify ongoing table migrations.


* **Portability**
* The code framework must run across Windows, macOS, and Linux servers capable of hosting Python environments.


## 5. System Evolution

### Assumptions

* Future system variations will swap simulated transaction routines for live third-party financial application programming interfaces (APIs) such as Stripe or SSLCommerz.
* Machine Learning models could be introduced later to construct tailored product recommendation systems.

### Expected Changes

* Structural transition from single-server setups (XAMPP) to containerized cloud orchestration microservices (Docker + AWS RDS).

---

## 6. Appendices

### Hardware Requirements

* **Development Node:** Minimum 4GB RAM, dual-core CPU processing architecture, and local hosting capability.

### Database Requirements

The MySQL database must enforce strict relational schemas across the following table entities:

| Table Name | Primary Purpose | Key Structural Dependencies |
| :--- | :--- | :--- |
| **Users** | Holds client profiles and administrator records. | Unique indexing on credentials. |
| **Categories** | Collects thematic groupings for technical goods. | Self-contained lookup structure. |
| **Products** | Retains core technical details, standard pricing, and inventory depth. | Bound to **Categories** via foreign key elements. |
| **Product_Images**| Holds alternative display asset references per unit. | Many-to-One connection mapping back to **Products**. |
| **Carts** | Tracks active consumer selection sessions. | Paired uniquely directly to an established record in **Users**. |
| **Cart_Items** | Counts unique items assigned to specific buyers. | Links **Carts** seamlessly alongside **Products**. |
| **Orders** | Solidifies formal purchase logs and fulfillment tracking flags. | References historical buyer indicators from **Users**. |
| **Order_Items** | Archives structural snapshots of historically purchased line items. | Links historic items directly from **Orders** to **Products**. |
| **Payments** | Logs simulation tokens and settlement verification values. | Maps one-to-one transformations targeting verified **Orders**. |


## 4. System Models

> * **CONTEXT DIAGRAM**
<img src="images/Shop now .png" alt="ShopNow Context Model">
