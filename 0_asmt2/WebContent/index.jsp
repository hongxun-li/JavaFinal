<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Login</title>
</head>

<body style="overflow:hidden;">
		<div class="flex-container">
			<div>
				<img src="img/home.jpg" alt="home" />
			</div>
			
			<div class="inputBox">
				<h1>Sheridan Movie Theatre</h1>
				
				
				<form action="LoginServlet" method="post">
				<p>Login for purchasing tickets</p>
					<table>
							<tr>
								<%-- display id if logged in already --%>
								<th>UserID</th>
								<td><input type="text" name="uid_" /></td>
							</tr>
	
							<tr>
								<th>Password</th>
								<td><input type="password" name="pass_" /></td>
							</tr>
	
							<tr>
								<td></td>
								<td><input type="submit" name="submit" value="login" /> <%-- display logout button if logged in already --%>
									<%
										if ("login".equals(session.getAttribute("login_state"))) {
									%> <input
									type="submit" name="submit" value="logout" /> <%}%>
								</td>
							</tr>
					</table>

					<p><a href="ItemListServlet">Login as Guest</a></p>
					<p><a href="Registration.html">No Account? Sign Up HERE!</a></p>
	
				</form>
	
			</div>
		</div>	
</body>

</html>