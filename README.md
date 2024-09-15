# Spring Boot Application with JWT Authentication

This project demonstrates the implementation of **JWT (JSON Web Token)** based authentication and authorization using **Spring Security** in a Spring Boot application.

## Features

- JWT Authentication and Authorization
- Secure API Endpoints
- Stateless Authentication using JWT
- Password encoding with BCrypt
- JWT Token validation

## Technologies Used

- **Java 17**
- **Spring Boot 3.3.3**
- **Spring Security**
- **JWT (JSON Web Token)**
- **BCrypt Password Encoder**
- **H2 Database** (for testing purposes)
- **Lombok**
- **Maven**


## Endpoints

| HTTP Method | Endpoint           | Description                     | Access Level        |
|-------------|--------------------|---------------------------------|---------------------|
| POST        | `/api/auth/login`  | Authenticates and returns JWT   | Public              |
| POST        | `/api/auth//register` | Registers a new user         | Public              |
| GET         | `/resource/secure` | Secure Endpoint                 | Role: ALL           |

## JWT Workflow

1. **Login**: User sends a request to `/api/auth/login` with valid credentials.
2. **Token Generation**: On successful authentication, a JWT is generated and returned in the response.
3. **Token Usage**: The client sends this token in the `Authorization` header for subsequent requests.
4. **Token Validation**: The JWT is validated in each request using JWT filters.

## Setup Instructions

1. **Clone the repository**:
  git clone https://github.com/eramanmalhi/LazyProgrammer-SpringSecurity-JWT.git
  cd spring-boot-jwt-security

3. **Build and Run**:
  mvn clean install
  mvn spring-boot:run



