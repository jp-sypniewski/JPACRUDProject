<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Not a public library</title>
</head>
<body>

<div>
<%@ include file="nav.jsp" %>
</div>
<div>
<c:if test="${deleted }">
<h2>Film Deleted!</h2>

</c:if>


<form action="getBook.do" method="GET">
  Film ID: <input type="text" name="bid" />
  <input type="submit" value="Show Book" />
</form>
<br>
<a href="displayNew.do">Create New Book</a>
</div>
</body>
</html>