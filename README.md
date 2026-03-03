# 🔐 User Authentication System with JWT

### Spring Boot 3 + Java 21 + Spring Security 7

---

## 📌 Project Overview

This project is a **JWT-based authentication and authorization system** built using **Java 21** and **Spring Boot 3**.

It allows users to:

* ✅ Register an account
* ✅ Login securely
* ✅ Receive a JWT token
* ✅ Access protected endpoints
* ✅ Use stateless authentication (no server sessions)

This project demonstrates how modern backend authentication works in real-world applications.

---

## 🏗️ Tech Stack

| Technology        | Purpose                          |
| ----------------- | -------------------------------- |
| Java 21           | Core programming language        |
| Spring Boot 3     | Backend framework                |
| Spring Security 7 | Authentication & Authorization   |
| JWT (jjwt 0.11.5) | Token-based authentication       |
| Spring Data JPA   | Database interaction             |
| H2 Database       | In-memory database (development) |
| BCrypt            | Secure password hashing          |
| Maven             | Dependency management            |

---

## 📂 Project Structure

```
com.example.user_auth_jwt
│
├── controller
│   └── AuthController.java
│
├── service
│   └── UserService.java
│
├── repository
│   └── UserRepository.java
│
├── model
│   └── User.java
│
├── dto
│   ├── LoginRequest.java
│   └── RegisterRequest.java
│
├── security
│   ├── JwtUtil.java
│   ├── JwtAuthFilter.java
│   └── SecurityConfig.java
│
└── UserAuthJwtApplication.java
```

---

## 🔄 How the System Works

### 1️⃣ Registration Flow

**Endpoint:**

```
POST /api/auth/register
```

**Request Body:**

```json
{
  "username": "user1",
  "password": "password123"
}
```

**Process:**

* Checks if username already exists
* Encrypts password using BCrypt
* Saves user to database

---

### 2️⃣ Login Flow

**Endpoint:**

```
POST /api/auth/login
```

**Request Body:**

```json
{
  "username": "user1",
  "password": "password123"
}
```

**Process:**

* Validates credentials
* Generates JWT token
* Returns token to client

**Response Example:**

```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

---

### 3️⃣ Access Protected Endpoint

To access any secured endpoint:

**Header:**

```
Authorization: Bearer <your-token>
```

If token is:

* ✅ Valid → Request proceeds
* ❌ Invalid/Expired → 403 Forbidden

---

## 🔐 Security Features

* Password hashing using BCrypt
* Stateless authentication (no sessions)
* JWT signature verification
* Token expiration validation
* Protected endpoints
* Role-based structure ready (ROLE_USER)

---

## 🧠 Key Concepts Implemented

* REST API architecture
* Dependency Injection
* Service & Repository pattern
* Spring Security Filter Chain
* JWT token creation & validation
* Stateless authentication
* Exception handling
* Bean configuration

---

## 🛠️ How to Run the Project

### 1️⃣ Clone the Repository

```
git clone <your-repo-url>
```

### 2️⃣ Open in IntelliJ / VS Code

### 3️⃣ Run Application

Run:

```
UserAuthJwtApplication.java
```

Application starts at:

```
http://localhost:8080
```

---

## 🧪 Testing with Postman

### Register

```
POST http://localhost:8080/api/auth/register
```

### Login

```
POST http://localhost:8080/api/auth/login
```

### Access Secured Endpoint

```
GET http://localhost:8080/api/your-protected-endpoint
```

Add header:

```
Authorization: Bearer <token>
```

---

## 🗄️ Database

This project uses:

* **H2 In-Memory Database**

H2 Console (if enabled):

```
http://localhost:8080/h2-console
```

JDBC URL:

```
jdbc:h2:mem:testdb
```

Note: Data resets when application restarts.

---

## 🌍 Real-World Use Cases

This authentication structure is used in:

* Banking applications
* E-commerce platforms
* SaaS products
* Mobile app backends
* Enterprise systems
* Microservices architecture

---

## 🚀 Possible Improvements

* Add Refresh Token mechanism
* Implement Role-Based Access Control (ADMIN / USER)
* Switch to PostgreSQL or MySQL
* Add Swagger documentation
* Deploy to cloud (AWS / Render / Railway)
* Store JWT secret in environment variables

---

## 📈 Resume Description

> Built a secure JWT-based authentication system using Spring Boot 3 and Java 21 with password hashing, stateless authorization, and protected REST endpoints.

---

## 👨‍💻 Author

Developed as a backend authentication system project to demonstrate modern Spring Security implementation with JWT.

---

## 📜 License

This project is for educational and demonstration purposes.
