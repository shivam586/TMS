# TMS
CRUD API for task management system


Task Management System is built using 
Java 
Maven
MySQL


Steps to Setup
1. Clone the application

git clone https://github.com/shivam586/TMS.git

2. Create Mysql database

create database task_manager

3. Change mysql username and password as per your installation

open src/main/resources/application.properties

change spring.datasource.username and spring.datasource.password as per your mysql installation

4. Build and run the app using maven

mvn spring-boot:run

The app will start running at http://localhost:8080.

Explore Rest APIs
The app defines following CRUD APIs.

GET /api/tasks

POST /api/tasks

GET /api/task/{taskId}

PUT /api/task/{taskId}

DELETE /api/task/{taskId}
You can test them using postman or any other rest client.