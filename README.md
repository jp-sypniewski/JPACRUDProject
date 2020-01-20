## JPA Crud Project

### Week 9 Skill Distillery Homework

#### Overview

This project contains a Spring Boot framework connected to a JPA project such that the user can perform CRUD on a single table MySQL database.

The database consists of two tables, with all users able to perform CRUD on only Book objects. A Book has a title (String), completion status (boolean complete, incomplete), and inventory status (avail, reserved, out).  The user is presented with the index screen where a film can be searched by ID, or the user can go to a page with a form to create a new book.  If the user locates a film by searching for ID, then the film title, completion status, and inventory status are all shown.  On that page, the user can update both inventory status and completion status.  The user can also delete the film, or opt to edit all fields of that particular film.

#### Concepts

- MySQL database creation
- JPA with JUnit testing
- Spring Boot framework
- Gradle dependency management

#### Technologies Used

- Java
- JPA
- Spring Boot
- AWS EC2
- Tomcat
- MySQL
- Gradle
- Bootstrap CSS

#### Lessons Learned

- Readability throughout project improves ability to troubleshoot issues
  - This project illustrates the potential connection depth of issues within an application.  For example, the an object passed into a Model or HttpSession for a .jsp file can reference the field of the object.  The name of that field is determined within Entity declaration, which must then correctly reference the column name within the database.
- Controller management
  - Upon adding buttons specific to updating single fields in an object, the single controller was quickly becoming crowded with methods.  These could be split into more appropriate controllers (e.g. all updates together, other functions in a separate controller class).
- Use of JSTL in conjunction with Object design
  - When providing a method for users to update objects, populating information about the existing object may change how the user should see the update method.  In this project, the book object has a boolean taken from a tinyint within the database.  By using this as a boolean, I provided JSTL logic to add specific html, or not.
