# 🏠 PG Flat Finder

A full-stack web application developed using **Spring Boot**, **Thymeleaf**, and **MySQL** that helps students and working professionals find PG accommodations and rental flats. The application provides an easy way to browse available properties, search based on requirements, view complete property details, locate properties using Google Maps, and contact property owners. It also includes an administrator panel for managing properties and viewing customer enquiries.

---

# 📖 Table of Contents

- Project Overview
- Objectives
- Features
- Technology Stack
- Project Architecture
- Project Structure
- Database Design
- Database Relationships
- Installation & Setup
- Configuration
- Running the Application
- API Endpoints
- Repository Layer
- Future Enhancements
- Learning Outcomes
- Author

---

# 📌 Project Overview

Finding suitable PGs and rental flats near colleges or workplaces is often difficult because information is scattered across multiple platforms. This project aims to provide a centralized platform where users can easily browse, search, and explore available accommodations.

The application allows administrators to efficiently manage property listings while enabling users to contact property owners directly.

---

# 🎯 Objectives

- Simplify the process of finding PGs and flats.
- Provide complete property information.
- Allow users to search and filter properties.
- Display property locations using Google Maps.
- Enable direct communication with property owners.
- Provide administrators with complete control over property management.

---

# ✨ Features

## User Module

- Responsive Landing Page
- Browse Available Properties
- Search Properties
- Filter Properties
- View Detailed Property Information
- Google Maps Integration
- Contact Property Owner
- Property Availability Status

## Admin Module

- Secure Admin Login
- Dashboard
- Add New Property
- Update Existing Property
- Delete Property
- Manage Property Availability
- View Customer Contact Requests

---

# 🛠 Technology Stack

## Backend

- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- Maven

## Frontend

- HTML5
- CSS3
- Bootstrap 5
- JavaScript
- Thymeleaf

## Database

- MySQL

## Development Tools

- IntelliJ IDEA
- MySQL Workbench
- Git
- GitHub
- Postman

---

# 🏗 Project Architecture

```
                User
                  │
                  ▼
          Spring MVC Controller
                  │
                  ▼
             Service Layer
                  │
                  ▼
      Spring Data JPA Repository
                  │
                  ▼
             MySQL Database
```

---

# 📂 Project Structure

```
pg-flat-finder
│
├── src
│   ├── main
│   │
│   ├── java
│   │   ├── controller
│   │   ├── service
│   │   ├── repository
│   │   ├── entity
│   │   ├── config
│   │   └── PgFlatFinderApplication.java
│   │
│   ├── resources
│   │   ├── static
│   │   │   ├── css
│   │   │   ├── js
│   │   │   └── images
│   │   │
│   │   ├── templates
│   │   │   ├── welcome.html
│   │   │   ├── home.html
│   │   │   ├── property-detail.html
│   │   │   ├── admin-login.html
│   │   │   ├── admin-dashboard.html
│   │   │   └── ...
│   │   │
│   │   └── application.properties
│
├── pom.xml
└── README.md
```

---

# 🗄 Database Design

The application uses **MySQL** to store property information, administrator data, and customer contact requests.

## Database Name

```
pgflatfinder
```

---

## Entity Relationship Diagram

```
                   +------------------+
                   |      Admin       |
                   +------------------+
                   | admin_id (PK)    |
                   | username         |
                   | password         |
                   +------------------+
                           |
                           | manages
                           |
                           ▼
                 +-----------------------+
                 |      Property         |
                 +-----------------------+
                 | id (PK)               |
                 | title                 |
                 | type                  |
                 | location              |
                 | rent                  |
                 | rooms                 |
                 | description           |
                 | owner_name            |
                 | contact_number        |
                 | available             |
                 +-----------------------+
                           ▲
                           |
                           | selected by
                           |
                 +-------------------------+
                 |   Contact_Request       |
                 +-------------------------+
                 | request_id (PK)         |
                 | customer_name           |
                 | email                   |
                 | phone                   |
                 | message                 |
                 | property_id (FK)        |
                 +-------------------------+
```

---

# Database Tables

## 1. Admin

Stores administrator credentials.

| Column | Type | Constraint |
|--------|------|------------|
| admin_id | BIGINT | Primary Key |
| username | VARCHAR | Unique |
| password | VARCHAR | Not Null |

---

## 2. Property

Stores complete property information.

| Column | Type | Constraint |
|--------|------|------------|
| id | BIGINT | Primary Key |
| title | VARCHAR | Not Null |
| type | VARCHAR | Not Null |
| location | VARCHAR | Not Null |
| rent | DOUBLE | Not Null |
| rooms | INTEGER | Not Null |
| description | TEXT | Nullable |
| owner_name | VARCHAR | Not Null |
| contact_number | VARCHAR | Not Null |
| available | BOOLEAN | Default TRUE |

---

## 3. Contact_Request

Stores enquiries submitted by users.

| Column | Type | Constraint |
|--------|------|------------|
| request_id | BIGINT | Primary Key |
| customer_name | VARCHAR | Not Null |
| email | VARCHAR | Not Null |
| phone | VARCHAR | Not Null |
| message | TEXT | Nullable |
| property_id | BIGINT | Foreign Key |

---

# 🔗 Database Relationships

## Admin → Property

**Relationship:** One-to-Many (1:N)

One administrator can manage multiple properties.

```
Admin (1)
     │
     └──────────► Property (N)
```

---

## Property → Contact_Request

**Relationship:** One-to-Many (1:N)

One property can receive multiple enquiries.

```
Property (1)
      │
      └──────────► Contact_Request (N)
```

---

# 🔒 Database Constraints

- Primary Keys uniquely identify each record.
- Foreign Keys maintain referential integrity.
- NOT NULL constraints ensure mandatory fields are filled.
- UNIQUE constraint prevents duplicate administrator usernames.
- BOOLEAN field tracks property availability.

---

# ⚙ Installation & Setup

## Clone Repository

```bash
git clone https://github.com/Jayasree232006/pg-flat-finder.git
```

Navigate to the project:

```bash
cd pg-flat-finder
```

---

## Configure Database

Create the database:

```sql
CREATE DATABASE pgflatfinder;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/pgflatfinder
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# ▶ Running the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or run the main application class directly from IntelliJ IDEA.

Open:

```
http://localhost:8080
```

---

# 🌐 API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | / | Landing Page |
| GET | /properties | Display Properties |
| GET | /property/{id} | Property Details |
| POST | /contact-request | Submit Contact Request |
| GET | /admin | Admin Dashboard |
| POST | /properties/add | Add Property |
| POST | /properties/update | Update Property |
| POST | /properties/delete | Delete Property |

---

# 📦 Repository Layer

The application uses **Spring Data JPA** repositories:

- AdminRepository
- PropertyRepository
- ContactRequestRepository

These repositories simplify CRUD operations without writing SQL queries manually.

---

# 🚀 Future Enhancements

- User Registration & Login
- Favorite Properties
- Property Reviews and Ratings
- Email Notifications
- Image Gallery
- Advanced Search Filters
- Payment Integration
- OTP Verification
- Chat Between Owner and User
- Nearby Colleges and Offices
- AI-based Property Recommendations

---

# 📚 Learning Outcomes

Through this project, I gained practical experience in:

- Spring Boot Application Development
- MVC Architecture
- Spring Data JPA & Hibernate
- CRUD Operations
- MySQL Database Design
- Thymeleaf Templating
- Bootstrap Responsive UI
- Form Validation
- Google Maps Integration
- Git & GitHub Version Control
- Full-Stack Web Development

---

# 👨‍💻 Author

**Jaya Sree Katta**

GitHub: https://github.com/Jayasree232006

---

# 📄 License

This project is intended for educational and learning purposes.
