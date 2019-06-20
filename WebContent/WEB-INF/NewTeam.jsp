<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New Team</title>
</head>
<body>
	<h1>Create a new Team</h1>
	<form action="Home" method="post">
		<p>Team Name: <input type="text" name="team_name"></p>
		<input type="submit" value="submit">
	</form>	
</body>
</html>