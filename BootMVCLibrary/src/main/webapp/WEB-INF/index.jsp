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

<c:if test="${deleted }">
<h2>Film Deleted!</h2>

</c:if>
<form action="getBook.do" method="GET">
  Film ID: <input type="text" name="bid" />
  <input type="submit" value="Show Book" />
</form>
<br>
<a href="displayNew.do">Create New Book</a>

</body>
</html>