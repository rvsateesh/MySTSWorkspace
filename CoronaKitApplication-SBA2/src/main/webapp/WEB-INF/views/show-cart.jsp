<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring-form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<title>Corona Kit Application</title>
</head>
<body>
	<div class="well p-2">
		<div class="container text-center p-4">
			<h3>Your Order List!</h3>
		</div>
		<nav class="navbar navbar-light" style="background-color: #e3f2fd">
			<div class="btn-group btn-group-toggle">
				<nav>
					<div class="btn btn-outline-primary">
						<jsp:include page="${pageContext.request.contextPath}/header" />
					</div>
				</nav>
			</div>
			<div>
				<spring-form:form action="${pageContext.request.contextPath}/logout"
					method="POST">
					<input class="btn btn-danger float-md-right" type="submit"
						value="Logout">
				</spring-form:form>
			</div>
		</nav>
		<div class="container well p-4">
			<section class="container-fluid p-4">
				<c:choose>
					<c:when test="${kit == null || kit.isEmpty() }">
						<p class="container well well-info">You Kit is still empty.
							Please add products to the cart!</p>
					</c:when>
					<c:otherwise>
						<div class="container-fluid well p-3">
							<spring-form:form class="form"
								action="${pageContext.request.contextPath}/user/finalize"
								method="POST">
								<table class="table table-striped table-hover table-bordered">
									<tr class="table-warning">
										<th class="text-center">KitId</th>
										<th class="text-center">ProductId</th>
										<th class="text-center">Price</th>
										<th class="text-center">Quantity</th>
										<th class="text-center">Remove</th>
									</tr>
									<c:forEach items="${kit }" var="kit">
										<tr>
											<td class="text-center">${kit.id }</td>
											<td class="text-center">${kit.productId }</td>
											<td class="text-center">${kit.amount}</td>
											<td class="text-center"><input class="text-center"
												type="number" id="quant" name="quantity"
												value="${kit.quantity }" min="1"></td>
											<td class="text-center"><a
												class="btn btn-sm btn-outline-danger"
												href="${pageContext.request.contextPath}/user/delete?itemId=${kit.id }">Delete</a>
											</td>
										</tr>
									</c:forEach>
								</table>
								<label class="col-form-label">Delivery Address:</label>
								<br />
								<textarea name="deliveryAddress" required></textarea>
								<br />
								<button class="btn btn-sm btn-success">Checkout</button>
							</spring-form:form>
						</div>
					</c:otherwise>
				</c:choose>
			</section>
		</div>
		<nav>
			<jsp:include page="${pageContext.request.contextPath}/footer" />
		</nav>
	</div>
</body>
</html>