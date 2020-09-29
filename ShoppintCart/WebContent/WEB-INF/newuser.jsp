<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-New User(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<form action="showproductstoadd.jsp?action=list" method="POST">
	<div>
		<label>Name</label> <input type="text" name="Name" required/>
		<p></p>
		<label>Email</label> <input type="text" name="Email" required/>
		<p></p>
		<label>Contact</label> <input type="text" name="Contact" required/>		
		<p></p>
		<button name="list" value="list">Go to Products</button>
	</div>
</form>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>