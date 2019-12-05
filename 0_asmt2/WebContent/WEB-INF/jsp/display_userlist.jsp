<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import ="java.util.*" %>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="com.prog.User" %>
    
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>
	<div class="flex-container">
		<div>
			<img src="img/users.jpg" alt="users" />
		</div>

		<div class="inputBox">

			<h1>User List</h1>
			<p>choose an option</p>

			<form action="CROMServlet" method="post">
				<table>
					<tr>
						<td><input type="radio" name="crom" value="add"
							checked="checked">Add</td>
						<td><input type="radio" name="crom" value="delete">Delete</td>
						<td><input type="radio" name="crom" value="update">Update</td>
						<td><input type="radio" name="crom" value="retrieve">View</td>
					<tr>
						<td><input type="submit" name="sutbmit" value="submit" /></td>
					</tr>
				</table>
				<a href="#" onclick="history.go(-1)">Go Back</a>

			</form>

		</div>
	<div>
			<table border="1">
				<thead>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Password</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.users}" var="current">
						<tr>
							<td><c:out value="${current.uid}" /></td>
							<td><c:out value="${current.fname}" /></td>
							<td><c:out value="${current.lname}" /></td>
							<td><c:out value="${current.pass}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>


		</div>
	</div>

</body>
</html>