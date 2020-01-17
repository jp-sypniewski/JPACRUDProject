<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Not a public library</title>
</head>
<body>
<div>

  <h5>${book.name}</h5>
  <p>Current status: ${book.checkinStatus }</p>
  <p>Completion: ${book.completed }</p>
  
  <form action="displayUpdate.do" method="GET">
  	<input type="hidden" value="${book.id }" name="bid" />
  	<input type="submit" value="Update This Book" />
  </form>
  <br>
  <form action="deleteBook.do" method="GET">
  	<input type="hidden" value="${book.id }" name="bid" />
  	<input type="submit" value="Delete This Book" />
  </form>
  
</div>
</body>
</html>