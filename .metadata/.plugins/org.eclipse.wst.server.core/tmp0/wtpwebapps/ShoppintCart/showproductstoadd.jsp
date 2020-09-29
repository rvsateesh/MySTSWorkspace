<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-All Products(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<a href="newuser.jsp">Back</a>
<hr/>
<h3>Products chart for your shopping!</h3>
<form action="showkit.jsp">
	<c:choose>
		<c:when test="${products == null || products.isEmpty()}"> 
		</c:when>
		<c:otherwise>
				<table border="1" cellspacing="5px" cellpadding="5px">
					<tr>
						<th>Product ID</th>
						<th>Product Name</th>
						<th>Product Cost</th>
						<th>Product Description</th>
						<th>Quantity</th>
					</tr>
					<c:forEach items="${products }" var="product">
						<tr>
							<td>${product.id }</td>
							<td>${product.productName }</td>
							<td>${product.cost }</td>
							<td>${product.productDescription }</td>
							<td>
								<input type="number" name="quantity" value="0" min="0" />						
							</td>
						</tr>
					</c:forEach>				
				</table>
			</c:otherwise>
	</c:choose>
	<p></p>
	<button>Order Summary</button>
</form>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>