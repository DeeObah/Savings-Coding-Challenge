# Medical Records-Savics Medical 
This is a single page application that uses angular 8 and a simple rest service built via spring boot.
##Structure of system
The system is split into two concerns, web app and the server.
1. The server is a simple spring boot application that exposes rest services for updating and retrieving medical records.
2. The front end / web application is written in angular and provides the interface for saving and retrieving medical records using 
the rest services exposed by the backend.
##Prerequisites
1. Java 8 should be installed on the machine
2. Node v 12.x.x should be installed
3. The app was tested on a machine with node version v12.16.1 and java version "1.8.0_231"
##Assumptions
1. It was assumed that all fields are required, hence the system doesn't save if any of the fields is missing.
2. It was also assumed that no two  persons from same country and city can have the 
same first name and last name. Duplicate won't save a new record. 

##Design decisions
1. Records are being saved into a mongodb. Medical records are generally unstructured/semi-structured, hence NoSQl database is a good fit. 
A fake database in the form of embedded MongoDb was used to save record to memory.
2. The application was split into backend and frontend to achieve good separation of concerns. 
This allows the two to evolve independently and also enables independent teams to work on each. 
Also makes maintenance easier and focused.
3. Spring boot was used to allow rapid development since a lot of features are provide out of the box.
4. Angular was used to decouple front end and backend and laos to benefit from its inherent asynchronous processing power. 

##How to run
1. Clone the repo

####### Running server
1. Navigate to the server-folder but running command "cd server" from the root folder
2. Run ./mvnw spring-boot:run
3. Server will run on port 8080

####### Running web application
1. Navigate to the web app folder by running command "cd client" from the root folder
2. Run command npm install && npm start
3. Open the application at http://localhost:4200

##Areas of improvement
1. With more time, unit tests are required to verify that individuals components work as required.
2. Integration tests required to verify that individuals components work as required.
3. Given more time, the interface can be made nicer
4. In a proper system ,security would be re

