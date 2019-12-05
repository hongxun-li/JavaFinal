<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.prog.Item"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<script>
var mF = function() {
  var gP = 15;
  var sP = 5;
  var y = document.getElementById("gNum1").value;
  var z = document.getElementById("sNum1").value;
  var x = parseInt(y) + parseInt(z);
  document.getElementById("gsSum1").innerHTML = x;
  
  var subT1 = parseInt(y) * gP + parseInt(z) * sP;
  document.getElementById("subT1").innerHTML = subT1;
   
  var b = document.getElementById("gNum2").value;
  var c = document.getElementById("sNum2").value;
  var a = parseInt(b) + parseInt(c);
  document.getElementById("gsSum2").innerHTML = a;
  
  var subT2 = parseInt(b) * gP + parseInt(c) * sP;
  document.getElementById("subT2").innerHTML = subT2;
  
  var gT = subT1 +subT2;
  document.getElementById("gT").innerHTML = gT;
  
}
</script>

<title>Item List</title>
</head>
<body>
	<div class="flex-container">

		<div class="inputBox">
			<h1>Purchase</h1>
			<p>Enter a number of Tickets</p>


			<table border="1">
				<tr>
					<th>Item ID</th>
					<th>Item Name</th>
					<th>Seats Available</th>

				</tr>
				<c:forEach items="${requestScope.items}" var="current">
					<tr>
						<td><c:out value="${current.iid}" /></td>
						<td><c:out value="${current.iname}" /></td>
						<td><c:out value="${current.stock}" /></td>
					</tr>
				</c:forEach>


			</table>

		</div>

		<div class="inputBox">
			<form action="PurchaseServlet" method="post">
				<input type="hidden" name="gP" value="15" /> 
				<input type="hidden" name="sP" value="5" /> 
	
				<table>
					<tr>
						<th>Item ID</th>
						<th>Adult</th>
						<th>Senior and Child</th>
						<th>Ticket SubTotal</th>

					</tr>
					<tr>
						<td><input type="text" name="itemID"></td>
						<td><input type="text" name="gNum" id="gNum1" /></td>
						<td><input type="text" name="sNum" id="sNum1" /></td>
						<td class="td_gsSum" id="gsSum1"></td>
					</tr>
					<tr>
						<td><input type="text" name="itemID"></td>
						<td><input type="text" name="gNum" id="gNum2" /></td>
						<td><input type="text" name="sNum" id="sNum2" /></td>
						<td class="td_gsSum" id="gsSum2"></td>
					</tr>

					<tr>
						<td>Movie #1 SubTotal:</td>
						<td>$</td>
						<td id=subT1></td>
					</tr>
					<tr>
						<td>Movie #2 SubTotal:</td>
						<td>$</td>
						<td id=subT2></td>
					</tr>
					<tr>
						<td>Grand Total:</td>
						<td>$</td>
						<td id=gT></td>
					</tr>

				</table>

				<button type="button" onclick="mF();">calculate</button>

				<input type="submit" value="submit" /> 
				<input type="reset" value="reset" />

			</form>
			<a href="index.jsp">return</a>
		</div>


	</div>

</body>
</html>