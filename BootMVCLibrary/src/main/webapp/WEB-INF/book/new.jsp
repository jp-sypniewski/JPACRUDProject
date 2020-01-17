<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Not a public library</title>
</head>
<body>
  <form action="createNewBook.do" method="POST">  	
  	Name: <input type="text" value="${book.name }" name="name" /><br>
  	
  	Completion Status:<br>
  	Completed:<input type="radio" name="completed" value="true"/><br>
  	Incomplete:<input type="radio" name="completed" value="false"/><br>
  	
  	Check-In Status:<br>
  	Available:<input type="radio" name="checkinStatus" value="avail"/><br>
  	Reserved:<input type="radio" name="checkinStatus" value="reserved"/><br>
  	Checked Out:<input type="radio" name="checkinStatus" value="out"/><br>
  	
  	
  	<input type="submit" value="Create New Book" />
  </form>

</body>
</html>