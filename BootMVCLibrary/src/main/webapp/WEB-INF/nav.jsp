<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav>


	<a href="index.do">Home</a>
	 
	<c:choose>
		<c:when test="${user.id == 0 or user == null}">
			<a href="login.do">Log In</a>
		</c:when>
		<c:otherwise>
			<c:out value="Welcome, ${user.username }"/>
		</c:otherwise>
	</c:choose>
	
	
	
</nav>