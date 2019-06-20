<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Roster</title>	
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<c:set var = "teams" value = "${roster.getTeams()}"/>
	<h1>Prototype Roster</h1>
	<a href="Teams">Add New Team</a>
	<br>
	<c:if test = "${not empty teams}">
		<table>
			<tr>
				<td>
					Team
				</td>
				<td>
					Players
				</td>
				<td>
					Action
				</td>
			</tr>
			<c:forEach var="team" items="${teams}" varStatus="loop">
				<tr>
					<td>
						<c:out value = "${team.getTeam_name()}"/>
					</td>
					<td>
						<c:out value = "${team.getPlayers().size()}"/>
					</td>
					<td>
						<form action="Teams" method="POST">
							<input type="hidden" id="id" name="id" value="${loop.index}">
							<input type="submit" class="lnk-btn" value="Details">
						</form>
						<form action="DeleteTeam" method="POST">
							<input type="hidden" id="id" name="id" value="${loop.index}">
							<input type="submit" class="lnk-btn" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>