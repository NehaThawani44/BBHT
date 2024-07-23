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
- Java 21 
- IntelliJ or Eclipse


### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/NehaThawani44/BBHT
   cd insurance
   

2.Build the project:
``````
mvn clean install

`````````
3.Run the application:

```
mvn spring-boot:run
`````
### Usage
#### Endpoints
##### Authentication
````
Login: /api/authenticate (POST)
`````
##### Claims
* Create Claim: /customer-claims (POST)
* Get Claim by ID: /customer-claims/{id} (GET)
* Get All Claims: /customer-claims (GET)
* Update Claim Status: /customer-claims/{id} (PUT)
* Delete Claim: /customer-claims/{id} (DELETE)
* Bulk Create Claims: /customer-claims/multiple (POST)
#### Example Request

###### Create a Claim
```
POST /customer-claims
Content-Type: application/json

{
    "claimantName": "Neha Thawani",
    "policyNumber": "PN123456",
    "description": "Accident damage",
    "status": "Pending"
} 

```
##### Authentication
The application uses JWT for authentication. After logging in, you will receive a token that you need to include in the Authorization header for all subsequent requests.

Example Login Request
```
POST  /customer-claims/authenticate
Content-Type: application/json

{
    "username": "test",
    "password": "password"
}
```
##### Example Authenticated Request
```
GET /customer-claims
Authorization: Bearer your.jwt.token.here
````
Testing
##### Run tests using Maven:
```
mvn test
````
#### License
This project is licensed under the MIT License - see the LICENSE file for details.

##### Contact
For questions or suggestions, please contact neha.thawani92@gmail.com

