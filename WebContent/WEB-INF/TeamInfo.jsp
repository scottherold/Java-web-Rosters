<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Team</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<c:set var = "players" value = "${team.getPlayers()}"/>
	<h1><c:out value = "${team.getTeam_name()}"/></h1>
	<form action="Players" method="GET">
		<input type="hidden" id="id" name="id" value="<c:out value = "${index}"/>">
		<input type="submit" class="lnk-btn" value="Add New Player">
	</form>
	
	<c:if test = "${not empty players}">
		<table>
			<tr>
				<td>
					First Name
				</td>
				<td>
					Last Name
				</td>
				<td>
					Age
				</td>
				<td>
					Action
				</td>
			</tr>
			<c:forEach var="player" items="${players}" varStatus="loop">
					<tr>
						<td>
							<c:out value = "${player.getFirst_name()}"/>
						</td>
						<td>
							<c:out value = "${player.getLast_name()}"/>
						</td>
						<td>
							<c:out value = "${player.getAge()}"/>
						</td>
						<td>						
							<form action="DeletePlayer" method="POST">
								<input type="hidden" id="id" name="id" value="<c:out value = "${index}"/>">
								<input type="hidden" id="player_id" name="player_id" value="${loop.index}">
								<input type="submit" class="lnk-btn" value="Delete">
							</form>
						</td>
					</tr>
				</c:forEach>
		</table>
	</c:if>
</body>
</html>