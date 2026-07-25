# 🏠 PG Flat Finder

A full-stack web application built using **Java 21**, **Spring Boot**, **Thymeleaf**, and **MySQL** that helps students and working professionals find PG accommodations and rental flats. Users can browse available properties, view detailed information, locate properties using Google Maps, and submit contact requests. Administrators can securely manage property listings through a dedicated dashboard.

The application is deployed on **Render** with **Aiven MySQL** as the cloud database.

---

# 🌐 Live Demo

**Live Application:** https://pg-flat-finder.onrender.com

---

# ✨ Features

## 👤 User Features

- Browse available PGs and Flats
- View detailed property information
- Google Maps integration
- View amenities and weekly food menu
- Check property availability
- Submit contact requests to property owners
- Responsive user interface

## 🔐 Admin Features

- Secure Admin Login
- Admin Dashboard
- Add New Property
- Edit Existing Property
- Delete Property
- Manage Property Availability
- View Customer Contact Requests

---

# 🛠 Tech Stack

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
- Aiven MySQL (Cloud Database)

## Deployment
- Docker
- Render

## Tools
- IntelliJ IDEA
- Git
- GitHub
- Postman

---

# 🏗 Architecture

```
                User
                  │
                  ▼
        Spring MVC Controllers
                  │
                  ▼
            Service Layer
                  │
                  ▼
     Spring Data JPA Repository
                  │
                  ▼
        MySQL (Aiven Cloud)
```

---

# 📂 Project Structure

```
pg-flat-finder
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── controller
│   │   │   ├── service
│   │   │   ├── repository
│   │   │   ├── entity
│   │   │   └── config
│   │   │
│   │   └── resources
│   │       ├── static
│   │       ├── templates
│   │       └── application.properties
│
├── pom.xml
└── README.md
```

---

# 🗄 Database Design

The application consists of three main entities:

### Admin
- Admin ID
- Username
- Password

### Property
- Property ID
- Title
- Type
- Location
- Rent
- Number of Rooms
- Description
- Owner Name
- Contact Number
- Weekly Food Menu
- Amenities
- Availability

### Contact Request
- Request ID
- Customer Name
- Email
- Phone Number
- Message
- Property ID

---

# 🔗 Entity Relationships

```
Admin (1)
     │
     └────────────► Property (N)

Property (1)
      │
      └────────────► Contact Request (N)
```

---

# ⚙ Installation

Clone the repository:

```bash
git clone https://github.com/Jayasree232006/pg-flat-finder.git
```

Navigate to the project folder:

```bash
cd pg-flat-finder
```

---

# 🔧 Configuration

Configure the following environment variables:

```properties
SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD
```

For local development, update `application.properties` with your local MySQL credentials.

---

# ▶ Running the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or run the `PgFlatFinderApplication` class directly from IntelliJ IDEA.

Open:

```
http://localhost:8080
```

---

# 📦 Repository Layer

The project uses Spring Data JPA repositories for database operations:

- AdminRepository
- PropertyRepository
- ContactRequestRepository

---

# 📚 Learning Outcomes

Through this project, I gained practical experience in:

- Spring Boot Development
- MVC Architecture
- Spring Data JPA & Hibernate
- CRUD Operations
- MySQL Database Design
- Thymeleaf Templating
- Bootstrap Responsive UI
- Google Maps Integration
- Docker Containerization
- Cloud Deployment using Render
- Cloud Database Integration using Aiven MySQL
- Git & GitHub Version Control
- Full-Stack Web Application Development

---

# 🚀 Project Status

✅ Successfully Completed and Deployed

This project demonstrates a complete full-stack web application built using Spring Boot, Thymeleaf, MySQL, Docker, Render, and Aiven Cloud Database.

---

# 👨‍💻 Author

**Jaya Sree Katta**

- GitHub: https://github.com/Jayasree232006
- Repository: https://github.com/Jayasree232006/pg-flat-finder
- Live Demo: https://pg-flat-finder.onrender.com

---

# 📄 License

This project is developed for educational and learning purposes.
