# Task Management System - Spring Boot REST API

A simple and scalable Task Management Backend System built using Java Spring Boot. The project supports Users, Projects, and Tasks management with full CRUD operations, pagination, filtering, validation, and global error handling.

---

## 🛠️ Tech Stack

- **Java** 17+
- **Spring Boot** Framework
- **Spring Data JPA** with Hibernate ORM
- **MySQL** (Production Database)
- **H2 Database** (Development/Testing)
- **Swagger/OpenAPI** Documentation
- **Maven** Build Tool
- **Lombok** Library

---

## ✨ Features

- ✅ Full CRUD operations for Users, Projects, and Tasks
- ✅ Pagination & Sorting
- ✅ Advanced Filtering (Projects & Tasks)
- ✅ DTOs + Mappers (Clean Architecture)
- ✅ Global Exception Handling
- ✅ Bean Validation
- ✅ Swagger API Documentation
- ✅ MySQL + H2 Profiles (Dev/Prod)
- ✅ Seed Data for Development
- ✅ RESTful API with JSON responses

---

## 📁 Project Structure

```
com.example.demo
├── controller/
├── service/
├── repository/
├── entity/
├── dto/
├── mapper/
├── enums/
├── exception/
├── specifications/
└── config/
```

---

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+ (for production)

### Run with DEV Profile (H2 Database)

**Step 1:** Configure application.yml
```yaml
spring:
  profiles:
    active: dev
```

**Step 2:** Run the application
```bash
mvn spring-boot:run
```

**Step 3:** Access H2 Console
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`

---

### Run with PROD Profile (MySQL)

**Step 1:** Create MySQL Database
```bash
CREATE DATABASE task_db;
```

**Step 2:** Update application-prod.yml
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/task_db
    username: root
    password: your_password
  jpa:
    hibernate:
      ddl-auto: update
```

**Step 3:** Run the application with PROD profile
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

---

## 📊 Database Setup

### Seed Data (DEV Only)
Automatically loaded from: `src/main/resources/data.sql`

---

## 🔍 API Endpoints

### Filtering Examples

**Projects:**
```
GET /api/v1/projects?status=ACTIVE
```

**Tasks:**
```
GET /api/v1/tasks?status=TODO&priority=HIGH&projectId=1
```

---

## 📝 API Response Format

### Success Response
```json
{
  "success": true,
  "message": "Operation successful",
  "data": {},
  "timestamp": "2026-04-30T22:00:00"
}
```

### Error Response
```json
{
  "errorCode": "NOT_FOUND",
  "message": "Resource not found",
  "details": [],
  "timestamp": "2026-04-30T22:00:00"
}
```

---

## 📚 API Documentation

After running the project, access the Swagger UI:
- **URL:** `http://localhost:8080/swagger-ui.html`

---

## 📝 License

This project is open source and available under the MIT License.
