<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="spring-form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/header" />
<spring-form:form action="${pageContext.request.contextPath}/logout" method="POST">
<input type="submit" value="Logout">
</spring-form:form>
<h1>This is Admin dashboard</h1>
 <a class="nav-link" href="${pageContext.request.contextPath}/admin/product-list">Products List</a>
 <span> | </span>
 <a class="nav-link" href="${pageContext.request.contextPath}/admin/product-entry">Add New Product</a>
</body>
</html>