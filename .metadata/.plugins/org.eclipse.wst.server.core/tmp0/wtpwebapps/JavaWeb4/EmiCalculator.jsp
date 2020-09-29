<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>MyBank EMI Calculator</title>
	</head>
	
	<body>
		<nav>
			<a href="index.jsp">Back to Home</a>
			<br />
		</nav>
		
		<h3> Dear Customer, Enter the below details to calculate your EMI</h3>
		<br />
		
		<form action="EmiCalc">
			<label> Principle Amount <input type="number" name="principle" required/> </label>
			<p> </p>
			<label> Rate Of Interest <input type="number" name="roi" step=".01" required/> </label>
			<p> </p>
			<label> Term Required <input type="number" name="term" required/> </label>
			<p> </p>
			<button>Calculate EMI</button>			
		</form>		
		
		<% if(request.getAttribute("emi")!= null) { %>
		<p><strong><%=request.getAttribute("emi") %></em></strong></p>
		<%} %>
		
	</body>
</html>