# Gym Management System

A full-stack Gym Management System built with Spring Boot and React.  
This project demonstrates a clean backend architecture, JWT-based authentication, role-based authorization, and frontend-backend integration using REST APIs.

The system is designed as a junior-level portfolio project that reflects real-world backend development practices.

---

## Project Overview

The Gym Management System allows administrators to manage users, trainers, and courses, while authenticated members can view available courses and trainers.

The main goals of this project are:
- Demonstrate layered backend architecture (Controller / Service / Repository)
- Implement secure authentication and authorization using JWT
- Apply role-based access control (Admin / Member / Trainer)
- Integrate a React frontend with a secured Spring Boot backend

---

## Features

### Authentication and Security
- JWT-based login system
- Stateless authentication
- Password encryption using BCrypt
- Role-based authorization using Spring Security

### User Management
- Admin can create users with different roles
- Users are stored securely with encrypted passwords
- Role information is embedded inside JWT tokens

### Trainer and Course Management
- Trainers are represented as users with a TRAINER role
- Courses are associated with trainers
- Admin can create courses and assign trainers
- Authenticated users can view available courses

### Frontend
- Login page with JWT handling
- Protected routes for authenticated users
- Admin dashboard layout with header and sidebar
- User and course management pages

---

## Tech Stack

### Backend
- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA (Hibernate)
- JSON Web Token (JWT)
- MySQL
- Maven

### Frontend
- React (Vite)
- React Router
- Axios
- CSS (custom layout and styling)

---

## System Architecture

The backend follows a layered architecture:

Controller -> Service -> Repository -> Database

```

- Controllers handle HTTP requests and responses
- Services contain business logic
- Repositories interact with the database
- DTOs are used to separate API contracts from entities

---

## API and Security Design

- Stateless REST APIs secured with JWT
- JWT tokens contain user role information
- Custom JWT authentication filter
- Spring Security filter chain configuration
- Role-based endpoint access control

Example access rules:
- `/auth/login` is publicly accessible
- `/users/**` is restricted to ADMIN role
- `/courses/**` requires authentication

---

## How to Run the Project

### Backend Setup
1. Create a MySQL database
2. Configure database credentials in `application.yml`
3. Run the Spring Boot application
4. Backend server runs on `http://localhost:8080`

### Frontend Setup
​```bash
cd frontend
npm install
npm run dev

```

The frontend runs on `http://localhost:5173`

------

## Future Improvements

- Course booking system for members
- User profile management
- Membership and payment tracking
- Enhanced UI and user experience

------

## Author

Jay Zhang