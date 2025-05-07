# Book Management System

## Description
A web-based **Book Management System** built using **Spring Boot** and **Thymeleaf**. This system allows users to register, log in, manage books, and view book details. Features include CRUD operations for books, filtering by status (Active/Inactive), and user authentication and authorization.

## Features
- User authentication with **register** and **login** functionality.
- Manage books with **Create**, **Read**, **Update**, and **Delete** operations.

- View detailed information about each book.

## Technologies
- **Backend**: Spring Boot, Spring Security, Spring Data JPA
- **Frontend**: Thymeleaf, Bootstrap
- **Database**: MySQL
- **Authentication**: Spring Security

## Installation

### Prerequisites
- JDK 11 or higher
- Maven

### Steps to Run the Application
1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/book-management-system.git
    cd book-management-system
    ```

2. Build the project using Maven:
    ```bash
    mvn clean install
    ```

3. Run the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ```

4. Access the application in your browser at:  
   `http://localhost:8080`

## Endpoints
- **/login** - User login page.
- **/register** - User registration page.
- **/admin/book** - List all books.
- **/admin/book/{id}** - View details of a specific book.
- **/admin/book/add** - Add a new book.
- **/admin/book/status/{id}/{status}** - Edit status of specific book.