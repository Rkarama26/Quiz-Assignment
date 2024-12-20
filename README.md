# Quiz Assingment - Spring Boot

## Overview

This is a simple quiz application built using **Spring Boot** and **H2 in-memory database**. The application allows users to:
1. Start a new quiz session.
2. Get random questions from the database.
3. Submit answers and receive feedback.

The backend uses Java 17 and Spring Boot version 3.3.7.

## Features

- ``` /api/quiz/start?userId=1 ``` **Start a New Quiz**: Initiates a new quiz session for the user. 
- ``` /api/quiz/question?userId=1 ``` **Get a Random Question**: Returns a random question that the user hasn't answered yet.
- ``` /api/quiz/answer?userId=1&questionId=2&answer=4 ```   **Submit an Answer**: Accepts a user's answer and provides feedback (correct or incorrect).

## Tech Stack

- **Backend**: Java 17, Spring Boot 3.3.7
- **Database**: H2 (in-memory database)

### Prerequisites
To run this application, ensure that you have the following installed:
- **Java 17** or later
- **Backend**: Java 17, Spring Boot 3.3.7
- **Database**: H2 (in-memory database)
- **Maven** (for building the project)
- **IDE**: You can use any IDE like IntelliJ IDEA or Eclipse.
  
### Clone the Repository
Clone the repository to your local machine:
```bash
git clone https://github.com/yourusername/quiz-application.git
cd quiz-application

spring.datasource.url=jdbc:h2:mem:quizdb
```


### ScreenShot
```bash /h2-console ``` ![H2 DataBase](https://github.com/user-attachments/assets/3b1ef63f-2adf-494f-a5ed-388d21621710)




