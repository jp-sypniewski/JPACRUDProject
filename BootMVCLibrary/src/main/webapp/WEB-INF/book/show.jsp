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

  <h5>${book.name}</h5>
  <p>Current status: ${book.checkinStatus }
  <c:if test="${book.checkinStatus == 'avail' }">
  	  	<form action="reserveBook.do" method="GET">
  			<input type="submit" value="Reserve Book" />
  		</form>
  		
  	  	<form action="checkBookOut.do" method="GET">
  			<input type="submit" value="Check Book Out" />
  		</form>
  </c:if>
  
  <c:if test="${book.checkinStatus == 'reserved' }">
  	  	<form action="makeBookAvail.do" method="GET">
  			<input type="submit" value="Cancel Reservation" />
  		</form>
  		
  	  	<form action="checkBookOut.do" method="GET">
  			<input type="submit" value="Retrieve Reservation" />
  		</form>
  </c:if>
  <c:if test="${book.checkinStatus == 'out' }">
  	  	<form action="makeBookAvail.do" method="GET">
  			<input type="submit" value="Return Book" />
  		</form>

  </c:if>
  
  
  
  </p>
  
  
  <p>Completion: ${book.completed } 
  
  <form action="switchCompletionStatus.do" method="GET">
  	<input type="submit" value="Mark ${book.name } as 
  	<c:if test="${book.completed }">Incomplete</c:if>
  	<c:if test="${not book.completed }">Complete</c:if>
  	" />
  </form>
  </p>
  
  
  <form action="displayUpdate.do" method="GET">
  	<input type="submit" value="Update All Attributes" />
  </form>
  <br>
  
  <form action="deleteBook.do" method="GET">
  	<input type="hidden" value="${book.id }" name="bid" />
  	<input type="submit" value="Delete This Book" />
  </form>
  
</div>
</body>
</html>