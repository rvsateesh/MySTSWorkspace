<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="spring-form"%>
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
<section class="container-fluid p-4">
	<c:choose>
		<c:when test="${kit == null || kit.isEmpty() }">
			<p class="well well-info">You Kit is still empty. Please add products to the cart!</p>
		</c:when>
		<c:otherwise>
		<spring-form:form  class="form" action="${pageContext.request.contextPath}/user/finalize" method="POST">
			<h3>Your Order List!</h3>
			<table class="table table-striped table-hover table-border">
				<tr>
					<th>KitId</th>
					<th>CoronaKitId</th>
					<th>ProductId</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Remove</th>
				</tr>
				<c:forEach items="${kit }" var="kit">
					<tr>
						<td>${kit.id }</td>
						<td>${kit.coronaKitId }</td>
						<td>${kit.productId }</td>
						<td>${kit.amount}</td>
						<td><input type="number" id="quant" name="quantity" value="${kit.quantity }"></td>
						<td><a class="btn btn-sm btn-danger" href="${pageContext.request.contextPath}/user/delete?itemId=${kit.id }">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
			<hr/>
			<label>Delivery Address: </label><br/>
			<textarea name = "deliveryAddress" required></textarea><br/>
			<button class="btn btn-sm btn-danger">Checkout</button>
		</spring-form:form>
		</c:otherwise>
	</c:choose>
	</section>
</body>
</html>