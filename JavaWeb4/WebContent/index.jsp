<%@ page import= "java.time.LocalDateTime" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>JavaWeb4 Application</title>
	</head>
	<body>
		<h1>Welcome to MyBank</h1>
		<h3> <%=LocalDateTime.now() %></h3>
		<nav>
			<a href="EmiCalculator.jsp"> EMI Calculator</a>
		</nav>
	
	</body>
</html>