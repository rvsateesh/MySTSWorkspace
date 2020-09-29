<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<title>Corona Kit Application</title>
 <script type="text/javascript">
        function Validate() {
            var password = document.getElementById("password").value;
            var confirmPassword = document.getElementById("confirmPassword").value;
            if (password != confirmPassword) {
                alert("Passwords did not match!");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
	<h2>New User Registration</h2>
	<hr/>
	
	<spring:form action="${pageContext.request.contextPath}/register-save" method="POST" modelAttribute="userDetails">
		<br/>
		<br/>
		<spring:label path ="username">Enter user name</spring:label>
		<spring:input path="username"/>
		<br/>
		<br/>
		<spring:label id="password" path="password">Enter password</spring:label>
		<spring:password id="password" path="password"/>
		<br/>
		<br/>
		<spring:label id="confirmPassword" path="password">Confirm Password</spring:label>
		<spring:password id="confirmPassword" path="password" onChange="return Validate()"/>
		<br/>
		<br/>
		<spring:label path="email">Enter email</spring:label>
		<spring:input path="email"/>
		<br/>
		<br/>
		<spring:label path="contact">Enter Contact number</spring:label>
		<spring:input path="contact"/>
		<br/>
		<br/>
		<p>Select Role</p>
		<ul style="list-style-type:none">
			<li><input type="radio" name="roles" value="ADMIN"/>ADMIN</li>
			<li><input type="radio" name="roles" value="USER"/>USER</li>
		</ul>
		<br/>
		<br/>
		<input type="submit" value="Register">

	</spring:form>
<nav>
	<jsp:include page="${pageContext.request.contextPath}/footer" />
</nav>	
</body>
</html>