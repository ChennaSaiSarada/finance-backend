# Finance Backend System

A Spring Boot-based backend system for managing financial operations such as users, roles, and transactions. The application provides REST APIs with role-based access control and secure data handling.

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Docker

## Features
- User and Role management
- Transaction processing APIs
- RESTful architecture
- In-memory database (H2)
- Dockerized deployment

## Run Locally
```bash
mvn clean install
java -jar target/finance-backend-0.0.1-SNAPSHOT.jar