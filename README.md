# SpringBoot-Hibernate-library
Pet Project
Web application for electronic accounting of books and users who want to take these books.
## Technologies used:
Spring MVC, Spring Security, Spring Boot, Hibernate,
PostgreSQL, Maven, ThymeLeaf.

Configured authentication and authorization using BCryptPasswordEncoder. Admin can visit all pages.
The user can only create a new account and log in to his account and view page for seeing all the books.
## All pages are displayed with a ThymeLeaf:
  http://localhost:8080/auth/login    Page for logging
  
  http://localhost:8080/auth/registration   Page for registration
  
  http://localhost:8080/book         Page for seeing all the books that are in the database
  
  http://localhost:8080/book?page=2&books_per_page=2&sort_by_year=true   we can implement sorting and output of books
  
  http://localhost:8080/book/{id}    Page for seeing information about book and which user has this book now
  http://localhost:8080/book/{id}/edit?   Page for changing book information
  
  http://localhost:8080/book/{id}/release   We can delete the book from the user
  
  http://localhost:8080/book/{id}/assign    We can assign the book from the user
  
  http://localhost:8080/book/{id}/delete    We can delete book from DB
  
  http://localhost:8080/book/search       Page to search book by title
  
  http://localhost:8080/people      Page for seeing all the users that are in the database
  
  http://localhost:8080/people/{id}    Page for seeing information about user and which user has this book now
  
  http://localhost:8080/people/{id}/edit?   Page for changing user information and all the books that the user currently has,
if the book is overdue, then it is displayed in red

  http://localhost:8080/people/{id}/delete    We can delete user from DB
