<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit Application</title>
</head>
<body>
<security:authorize access="hasRole('ADMIN')">
	<hr/>
	<a href="${pageContext.request.contextPath}/admin/home">ADMIN HOME</a>
	<hr/>
</security:authorize>

<security:authorize access="hasRole('USER')">
	<hr/>
	<a href="${pageContext.request.contextPath}/user/home">USER HOME</a>
	<hr/>
</security:authorize>
</body>
</html>