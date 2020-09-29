<%@ page import = "java.time.LocalDateTime" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My JSP page</title>
</head>
<body>
<%! LocalDateTime dt = LocalDateTime.now(); %>
	<h2><%=dt %></h2>
	<p>
	<% for (int i=0; i<100; i++) {%>
	<%=i %>,
	<%} %>
	</p>
</body>
</html>