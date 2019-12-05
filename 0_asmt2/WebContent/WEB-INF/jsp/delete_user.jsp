<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Delete User</title>
</head>
<body>
	<div class="flex-container">
		<div>
			<img src="img/process.jpg" alt="process" />
		</div>

		<div class="inputBox">

			<h1>Delete User</h1>

			<form action="DeleteUserServlet" method="post">
				<table>
					<tr>
						<th>UserID</th>
						<td><input type="text" name="uid_" /></td>
					</tr>

					<tr>
						<th>First Name</th>
						<td><input type="text" name="fname_" /></td>
					</tr>

					<tr>
						<td><input type="submit" name="delete" value="delete" /></td>
						<td><input type="reset" name="reset" value="reset" /></td>
		
					</tr>
				</table>
				<a href="#" onclick="history.go(-1)">Go Back</a>

			</form>
		</div>
	</div>	
</body>
</html>