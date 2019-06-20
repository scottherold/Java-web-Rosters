<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title><c:out value = "${team.getTeam_name()}"/>: New Player</title>
</head>
<body>
	<h1>Add a player to team <c:out value = "${team.getTeam_name()}"/></h1>
	<form action="Players" method="post">
		<input type="hidden" id="id" name="id" value="<c:out value = "${index}"/>">
		<p>First Name: <input type="text" name="first_name"></p>
		<p>Last Name: <input type="text" name="last_name"></p>
		<p>Age: <select name="age">
			<c:forEach begin="18" end="30" varStatus="loop">
				<option value="${loop.index}">${loop.index}</option>
			</c:forEach>
			</select>
		</p>
		<input type="submit" value="Add">
	</form>
</body>
</html>