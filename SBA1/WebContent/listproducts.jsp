<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-All Products(Admin)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
<div>
	<form action="listproducts?action=list" method="post">
		<button name="list" value="list">List Of Products</button>
	</form>
</div>
<c:choose>
	<c:when test="${products == null || products.isEmpty()}"> 
		<%-- <p>No products found! Try <a href="newProduct">adding</a> one</p>  --%>
	</c:when>
	<c:otherwise>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Product Cost</th>
					<th>Product Description</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${products }" var="product">
					<tr>
						<td>${product.id }</td>
						<td>${product.productName }</td>
						<td>${product.cost }</td>
						<td>${product.productDescription }</td>
						<td>
							<a href="editProduct?pid=${product.id }">EDIT</a>
							<span>|</span>
							<a href="deleteProduct?pid=${product.id }">DELETE</a>							
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
</c:choose>

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>