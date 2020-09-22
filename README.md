Springbook

Small API with CRUD operations to get started with Spring Boot and get that Java blood running in the veins again, after almost 6 Python years.

This is a first step towards a set of endpoints who will simulate a Social Media. The name comes from a word play using the name of the framework and the end of the word Facebook.

The application currently has a /users endpoint to list, add, update and delete users from database.

*Tech Stack*

- MySQL 8 installed on local machine.
- Java 11
- Spring Boot 2.3.4
- Docker
- Maven

IDE: Eclipse

*Project Structure*

- com.springbook.model: JPA entities, currently only with the model User.
- com.springbook.controller: A welcome controller to serve the main page and a User controller to handle the CRUD of users.
- com.springbook.controller.dto: Data transfer objects designed to send data from the server to final user.
- com.springbook.controller.form: Work the reverse path of dtos, forms are beans designed to send data from the client to the server.
- com.springbook.controller.validation: Exception handler for validation errors (400).
- com.springbook.controller.repository: JPA Repositories.

*Next Steps*

- Add tests to cover the entire code. With limited time, and some issues initially found when trying to run tests from the IDE, I ran out of time to write the proper tests to cover the entire app, so this would be an example of a software not ready for release. Definitely next and most important step.

- Run the application dockerized. Although there is a Dockerfile, I'm still having a conflict of versions from Java, since the app was built in a Windows environment, and I only have Docker installed in my Linux VM (not blaming on the difference of OS, but on the different Java versions I have running on them)
