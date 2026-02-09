# Diet & Lifestyle Tracker – Backend
## Project ID

dietandlifestyle

### Overview

The Diet & Lifestyle Tracker Backend is a RESTful API built to support tracking of daily meals, calorie intake, and exercise activities. It provides secure, scalable endpoints for managing user diet and lifestyle data, enabling seamless integration with the frontend application.

The backend is designed following clean architecture principles, ensuring maintainability, performance, and security.

### Tech Stack

Java 17

Spring Boot

Spring Web (REST APIs)

Spring Data JPA

Hibernate

MySQL (or H2 for development)

Maven

Docker

SonarQube / SonarCloud (code quality & security analysis)

### Key Features

CRUD operations for Meals and Exercises

Daily calorie tracking

RESTful API design

Input validation and error handling

Centralized exception management

Clean separation of Controller, Service, and Repository layers

Dockerized backend for easy deployment

Code quality enforced using SonarQube Quality Gates

### API Modules

Diet Management

Add, update, delete, and view meal records

Exercise Management

Track exercise activities and duration

Reports

Daily calorie summary (diet vs exercise)

### Docker Support

The backend is containerized using Docker, allowing consistent deployment across environments.

docker build -t dietandlifestyle-backend .
docker run -p 8080:8080 dietandlifestyle-backend

### Code Quality & Security

Static code analysis using SonarCloud

Enforced Quality Gate for:

Code smells

Bugs

Security hotspots

Maintainability

CI/CD integration with GitHub Actions

### Deployment

Runs on port 8080

Supports environment-based configuration

Easily deployable to cloud platforms or container orchestration tools

###<img width="1920" height="1080" alt="Screenshot 2026-02-09 123744" src="https://github.com/user-attachments/assets/0d96daf0-fe9d-4db4-931f-0c6456386876" /><img width="1500" height="330" alt="Screenshot 2026-02-09 124117" src="https://github.com/user-attachments/assets/b699cb6a-d268-4bb2-85e4-c8c0ba275f3c" />


 Future Enhancements

User authentication & authorization (JWT)

Nutrition analytics and charts

Role-based access control

Cloud database integration

API documentation using Swagger/OpenAPI
