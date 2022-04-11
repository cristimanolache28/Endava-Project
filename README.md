# Endava-Project!

I made a Health Care System web application using Spring Boot.

## About project

### Technologies used
  * **IntelliJ** - development environment (IDE)
  * **Spring Boot** - Back-End and Front-End (Thymeleaf)
  * **PostgreSQL** - database

### Spring components used:
  * **Spring Core** - spring context for manageaning all beans by IoC 
  * **Spring MVC** - module, view and controller
  * **Spring Data Access and Integration** - Hibernate and JPA
  * **Spring Web** - scalable web application.
  * **Spring Security** - authentication and authorization


## App Architecture - Behind the scenes!
The application uses a MVC architecture made of more processes.

![Arhitecture MVC diagrama (5)](https://user-images.githubusercontent.com/49694359/162645001-638e7413-7911-41e0-ab1f-9d32fa2f9c63.jpg)

**Steps:**
  * 1 => The user uses a web application.
  * 2 => He does a Rest Api request and sends a method verbs over HTTP protocol to server.
  * 3 => Dispatcher Servlet analyzes the endpoint from URI and forwards the request to Controller Layer for processing.
  * 4 => Controller Layer takes the request from the user to get or set information. For this it has need of Service Layer. 
  * 5 => Service Layer has responsibility to do any logic required with the data received by the Controller.
  * 6 => Repository Layer (Data access object) is implemented to access the database and helps to extend the CRUD operations.
  * 7 => Finally, the user gets back a view with the content.

## The web application contains the following UI's:
![login](https://user-images.githubusercontent.com/49694359/162643877-569c7046-90fa-46d5-915a-349a19bb4a77.JPG)

![index](https://user-images.githubusercontent.com/49694359/162645505-07b65a3f-053f-4e1e-9ae5-6fbda139c39f.JPG)

![users](https://user-images.githubusercontent.com/49694359/162645508-cadf0de6-052a-45cc-b70e-4b183fe99044.JPG)

![usersManagement](https://user-images.githubusercontent.com/49694359/162645511-52d8121a-2af6-4cad-8753-83e17e26f43a.JPG)

![usersInfo](https://user-images.githubusercontent.com/49694359/162645520-3c193d27-38f5-4c7e-8013-10ad7098ed87.JPG)

![usersNew](https://user-images.githubusercontent.com/49694359/162645523-455e8741-df29-457b-9456-e9060dc7691e.JPG)

![updateUsers](https://user-images.githubusercontent.com/49694359/162645526-aaf8dad1-595c-4d14-8d8b-750f9a60fe38.JPG)

![newDoctors](https://user-images.githubusercontent.com/49694359/162645531-63ab27b5-0c0f-46fb-8cc3-41551e225006.JPG)

![MedicalServices](https://user-images.githubusercontent.com/49694359/162645546-ee547014-137e-4984-b6fd-61000f86c323.JPG)

![addNewSpecialization](https://user-images.githubusercontent.com/49694359/162645553-7f46cf29-9aed-4da6-9975-4b9806a6a73d.JPG)

![updateSpecialization](https://user-images.githubusercontent.com/49694359/162645557-d705dc92-5bd2-463a-b0da-5acd92caafc4.JPG)

![MedicalService2s](https://user-images.githubusercontent.com/49694359/162645608-19ab0f3f-ed43-4e27-9508-895d77d9417d.JPG)









