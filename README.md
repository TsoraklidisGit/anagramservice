# Anagram Service

This project provides a service to check if two words are anagrams. It includes a RESTful API endpoint that accepts two words and determines if they are anagrams.

## Features

- Accepts two words and checks if they are anagrams.
- Handles words with spaces and case-insensitive comparisons.
- Provides a simple and lightweight solution.

## Technologies Used

- Java
- Spring Boot
- Maven

## Getting Started

Follow the instructions below to get started with the project:

### Prerequisites

- Java Development Kit (JDK) 8 or later
- Apache Maven

### Installation

1. Clone the repository:

   ```shell
   git clone https://github.com/your-username/anagram-service.git

2. Navigate to the project directory:
   cd anagram-service
3. Build the project using Maven:
   mvn clean install

Usage:

1. Run the application in the shell:

   java -jar anagramservice/build/libs/anagramservice.jar

2. Access the Anagram API endpoint using an HTTP client, such as cURL or Postman:

POST /anagrams HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 58

{
 "firstWord": "listen",
 "secondWord": "silent"
}

in curl format:

curl -X POST \
-H "Content-Type: application/json" \
-d '{
"firstWord": "listen",
"secondWord": "silent"
}' \
http://localhost:8080/anagrams

The response will indicate if the provided words are anagrams.

