<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Hello <security:authentication property="principal.username"/></h2>
<h2>Roles : <security:authentication property="principal.authorities"/></h2>

<%-- Absolute path --%>
<spring:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout" />
</spring:form>
<hr/>
<h1>Welcome All to Maven Tool</h1>
<hr/>
<security:authorize access="hasRole('STUDENT')">

	<a href="${pageContext.request.contextPath}/student/home">Student Dashboard</a>

</security:authorize>
<br/><br/>

<security:authorize access="hasRole('MENTOR')">
<a href="${pageContext.request.contextPath}/mentor/home">Mentor Dashboard</a>
</security:authorize>

</body>
</html>













