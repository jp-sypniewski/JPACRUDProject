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
  <form action="performUpdate.do" method="POST">
  	<input type="hidden" value="${book.id }" name="bid" />
  	
  	Name: <input type="text" value="${book.name }" name="name" /><br>
  	
  	Completion Status:<br>
  	Completed:<input type="radio" name="completed" value="true" 
  	<c:if test="${book.completed }" >checked</c:if>
  	/><br>
  	Incomplete:<input type="radio" name="completed" value="false" 
  	<c:if test="${not book.completed }" >checked</c:if>
  	/><br>
  	
  	
  	<input type="submit" value="Perform Update" />
  </form>

</body>
</html>