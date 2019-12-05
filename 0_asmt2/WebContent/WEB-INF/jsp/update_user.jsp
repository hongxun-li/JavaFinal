<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Update User</title>
</head>
<body>
	<div class="flex-container">
		<div>
			<img src="img/process.jpg" alt="process" />
		</div>

		<div class="inputBox">

			<h1>Update User</h1>

			<form action="UpdateUserServlet" method="post">
				<table>
					<tr>
						<td>User ID</td>
						<td><input type="text" name="uid_" /></td>
					</tr>

					<tr>
						<td>First Name</td>
						<td><input type="text" name="fname_" /></td>
					</tr>

					<tr>
						<td>Last Name</td>
						<td><input type="text" name="lname_" /></td>
					</tr>

					<tr>
						<td>Password</td>
						<td><input type="password" name="pass_" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Update" /></td>
						<td><input type="reset" value="reset" /></td>

					</tr>

				</table>
				<a href="#" onclick="history.go(-1)">Go Back</a>

			</form>
		</div>
	</div>	
</body>
</html>