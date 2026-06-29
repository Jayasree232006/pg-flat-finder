# 🏠 PG Flat Finder

A full stack web application to help students find PGs, flats and hostels near their college.

## 🚀 Tech Stack

- **Backend:** Java, Spring Boot 4.0.7
- **Database:** MySQL 8.0
- **Frontend:** HTML, CSS, Bootstrap 5, Thymeleaf
- **Tools:** Maven, Git, IntelliJ IDEA

## ✨ Features

- View all available PG and flat listings
- REST APIs for property management
- Auto table creation using Hibernate JPA
- Responsive UI with Bootstrap 5

## 🛠️ How to Run

### Step 1 - Clone the repository
git clone https://github.com/Jayasree232006/pg-flat-finder

### Step 2 - Create MySQL database
CREATE DATABASE pg_flat_finder;

### Step 3 - Update application.properties
spring.datasource.username=root
spring.datasource.password=yourpassword

### Step 4 - Run the application
mvn spring-boot:run

### Step 5 - Open browser
http://localhost:8080/home

## 📡 API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | /api/properties | Get all properties |
| POST | /api/properties | Add new property |
| GET | /api/properties/{id} | Get property by ID |
| PUT | /api/properties/{id} | Update property |
| DELETE | /api/properties/{id} | Delete property |

## 👩‍💻 Developer

Jayasree - Java Full Stack Developer (Learning)

## 📌 Project Status

🟢 Active - Currently under development
