# Claim Service

## Overview
The Claim Service is a Spring Boot application designed to manage insurance claims. It provides RESTful APIs for creating, retrieving, updating, and deleting claims. Additionally, it supports bulk insertion of claims and JWT-based authentication for secure access.

## Features
- Create a new claim
- Retrieve a claim by ID
- Retrieve all claims
- Update the status of a claim
- Delete a claim
- Bulk insertion of claims
- JWT-based authentication

## Technologies
- Spring Boot
- Spring Data JPA
- Spring Security
- H2 Database
- JWT (JSON Web Token)
- Maven

## Setup

### Prerequisites
- Java 11 or higher
- Maven 3.6.3 or higher

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/claim-service.git
   cd claim-service
   ´´´´´´´´´´´

2.Build the project:
    ```
mvn clean install
```
3.Run the application:

```
mvn spring-boot:run




### Usage
#### Endpoints
##### Authentication
Login: /api/authenticate (POST)
##### Claims
Create Claim: /api/claims (POST)
Get Claim by ID: /api/claims/{id} (GET)
Get All Claims: /api/claims (GET)
Update Claim Status: /api/claims/{id} (PUT)
Delete Claim: /api/claims/{id} (DELETE)
Bulk Create Claims: /api/claims/bulk (POST)
#### Example Request
######Create a Claim
```
POST /api/claims
Content-Type: application/json

{
    "claimantName": "John Doe",
    "policyNumber": "PN123456",
    "description": "Accident damage",
    "status": "Pending"
} 

```
##### Authentication
The application uses JWT for authentication. After logging in, you will receive a token that you need to include in the Authorization header for all subsequent requests.

Example Login Request
```
POST /api/authenticate
Content-Type: application/json

{
    "username": "yourusername",
    "password": "yourpassword"
}
##### Example Authenticated Request
```
GET /api/claims
Authorization: Bearer your.jwt.token.here
Testing
##### Run tests using Maven:

bash
```
mvn test

#### License
This project is licensed under the MIT License - see the LICENSE file for details.

##### Contact
For questions or suggestions, please contact neha.thawani92@gmail.com

