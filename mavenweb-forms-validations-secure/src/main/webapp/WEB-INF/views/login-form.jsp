<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<core:if test="${param.error != null}">
	<i>Invalid Credentials!!!</i>
</core:if>
<%-- textfield username/password --%>
<spring:form action="${pageContext.request.contextPath}/validate" method="POST">
	<div>
		<div><label>Enter login Id</label></div>
		<div><input type="text" name="username"></div>
	</div>
	<br/><br/>
	<div>
		<div><label>Enter Password</label></div>
		<div><input type="password" name="password"></div>
	</div>
	<br/>
	<input type="submit" value="Login">
</spring:form>
<core:if test="${param.logout != null}">
	<i>You have been logged out successfully!!!</i>
</core:if>
</body>
</html>