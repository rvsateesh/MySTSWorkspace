<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="spring-form"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav>
	<jsp:include page="${pageContext.request.contextPath}/header" />
</nav>
<div class="col-sm-4">	
	<spring-form:form  class="form" action="${pageContext.request.contextPath}/admin/product-save" method="POST" modelAttribute="product">
		<div class="form-group">
			<spring-form:label path="productName">Product Name</spring-form:label>
			<spring-form:input type="text" path="productName" minlength="2" class="form-control"/>
			<spring-form:errors path="productName" class="alert alert-danger"/>
		</div>
		<div class="form-group">
			<spring-form:label path="cost">Product Cost</spring-form:label>
			<spring-form:input type="number" path="cost" min="10" class="form-control"/>
			<spring-form:errors path="cost" class="alert alert-danger"/>
		</div>
		<div class="form-group">
			<spring-form:label path="productDescription">Product Description</spring-form:label>
			<spring-form:input type="text" path="productDescription" minlength="5" class="form-control"/>
			<spring-form:errors path="productDescription" class="alert alert-danger"/>
		</div>
		<div class="form-group text-right">
		<button class="btn btn-primary" >Save Product</button>
		</div>
	</spring-form:form>
	</div>
</body>
</html>