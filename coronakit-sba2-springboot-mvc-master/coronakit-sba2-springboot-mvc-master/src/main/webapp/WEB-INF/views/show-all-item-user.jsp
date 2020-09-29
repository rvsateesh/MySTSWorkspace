<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="spring-form"%>
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
<spring-form:form  class="form">
<section class="container-fluid p-4">
	<c:choose>
		<c:when test="${products == null || products.isEmpty() }">
			<p class="well well-info">No products Found!</p>
		</c:when>
		<c:otherwise>
			<table class="table table-striped table-hover table-border">
				<tr>
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Product Cost</th>
					<th>Product Description</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${products }" var="product">
				<spring-form:form  class="form" action="${pageContext.request.contextPath}/user/add-to-cart">
					<tr>
						<td><input type="number" name="productId" value="${product.id }" ${"readonly" }></td>
						<td><input type="text" name="productName" value="${product.productName }" ${"readonly" }></td>
						<td><input type="number" name="pcost" value="${product.cost }" ${"readonly" }></td>
						<td><input type="text" name="productDescription" value="${product.productDescription }" ${"readonly" }></td>
						<td><button type="submit">Add Item</button></td>						
					</tr>
				</spring-form:form>
				</c:forEach>
			</table>
			<a class="btn btn-sm btn-danger" href="${pageContext.request.contextPath}/user/show-kit">Add To Cart</a>
		</c:otherwise>
	</c:choose>
	</section>
</spring-form:form>
</body>
</html>