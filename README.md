Task Management System - Spring Boot REST API

A simple and scalable Task Management Backend System built using Java Spring Boot.
The project supports Users, Projects, and Tasks management with full CRUD operations, pagination, filtering, validation, and global error handling.

Tech Stack

Java 17+

Spring Boot

Spring Data JPA

Hibernate

MySQL (Production)

H2 Database (Development)

Swagger / OpenAPI

Maven

Lombok

Features


Full CRUD for Users, Projects, Tasks

 Pagination & Sorting
 
 Filtering (Projects & Tasks)
 
 DTOs + Mappers (Clean Architecture)
 
 Global Exception Handling
 
 Validation (Bean Validation)
 
 Swagger API Documentation
 
 MySQL + H2 Profiles
 
 Seed Data for Development
 
 RESTful API with JSON responses




com.example.demo

 ┣ controller
 
 ┣ service
 
 ┣ repository
 
 ┣ entity
 
 ┣ DTO
 
 ┣ mapper
 
 ┣ Enum
 
 ┣ ExceptionHandling
 
 ┣ Specifications
 
 ┣ config




Run with DEV profile (H2 Database)
Option 1: Using application.yml    
spring:
  profiles:
    active: dev

Run:  mvn spring-boot:run
H2 Console:http://localhost:8080/h2-console
JDBC URL:jdbc:h2:mem:testdb


Run with PROD profile (MySQL)
1-Create MySQL Database
2-Update application-prod.yml

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/task_db
    username: root
    password: your_password

  jpa:
    hibernate:
      ddl-auto: update

3-Run:mvn spring-boot:run -Dspring-boot.run.profiles=prod


Seed Data (DEV only):Automatically loaded from:
src/main/resources/data.sql


Filtering Examples:
Projects
GET /api/v1/projects?status=ACTIVE
Tasks:
GET /api/v1/tasks?status=TODO&priority=HIGH&projectId=1

Standard API Response:
{
  "success": true,
  "message": "Operation successful",
  "data": {},
  "timestamp": "2026-04-30T22:00:00"
}

Error Response:
{
  "errorCode": "NOT_FOUND",
  "message": "Resource not found",
  "details": [],
  "timestamp": "2026-04-30T22:00:00"
}

Swagger Documentation
After running the project:http://localhost:8080/swagger-ui.html
