# URL Shortener (Java + Spring Boot)

This project is a simple **RESTful API** application that converts long URLs into short and user-friendly links.  
It is built using Spring Boot, Spring Data JPA, and H2 in-memory database.  

## Features
- Shorten a long URL (`/api/shorten`)
- Redirect to the original URL using the short code (`/{shortCode}`)
- In-memory H2 database support
- Random short code generation using UUID
- RESTful API design

## Technologies Used
- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database (in-memory)
- Maven

## Project Structure
src/main/java/com/example/urlshortener
├── controller -> REST API endpoints
├── model -> Entity classes
├── repository -> JPA repository interface
└── service -> Business logic

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/username/url-shortener.git
   cd url-shortener
Run the application:

mvn spring-boot:run
or run DemoApplication class from IntelliJ IDEA.

The application will start on:

http://localhost:8080

API Usage
1. Shorten URL

Request

GET http://localhost:8080/api/shorten?url=https://www.google.com


Response

http://localhost:8080/abc123

2. Redirect to Original URL

Request

GET http://localhost:8080/abc123

Response
The browser will be redirected to:

https://www.google.com

H2 Database Console

After running the application, you can access the H2 console at:

http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (leave empty)

You can query the URL_MAPPING table to see all stored URL mappings.
