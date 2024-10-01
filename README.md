# Customer Management API

## Project Overview
This project implements a RESTful API for managing customers, providing basic CRUD (Create, Read, Update, Delete) operations for the Customer entity. The API is built using Spring Boot and connects to a relational database (MySQL). The design focuses on soft deletion, meaning that customers are marked as inactive instead of being permanently removed from the database.

## Features
The project includes the following endpoints:

- **Create a Customer**
  - **POST** `/api/customers`

- **Get All Customers**
  - **GET** `/api/customers`

- **Get a Customer by ID**
  - **GET** `/api/customers/{id}`

- **Update a Customer**
  - **PUT** `/api/customers/{id}`

- **Delete a Customer**
  - **DELETE** `/api/customers/{id}`

## Technologies Used
- **Java** 17
- **Spring Boot** 2.x
- **Hibernate** for ORM
- **MySQL** as the relational database
- **Maven** for dependency management

## Requirements
To run this project, you will need:
- JDK 17 or higher
- MySQL database server
- Maven

## How to run project:
To have or install MySQL and Apache Tomcat 9.0.50
Clone this project
Configure application.properties file from resources directory to create connection to db:
db.driver=com.mysql.cj.jdbc.Driver
db.url=YOUR_URL
db.user=YOUR_LOGIN
db.password=YOUR_PASSWORD
