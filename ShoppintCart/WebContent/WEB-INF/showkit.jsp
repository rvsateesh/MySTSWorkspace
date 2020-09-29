<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-My Kit(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<% String[] quantities = request.getParameterValues("quantity"); %>
	<c:choose>
			<c:when test="${quantities == null || quantities.isEmpty()}"> 
			</c:when>
			<c:otherwise>
					<table border="1" cellspacing="5px" cellpadding="5px">
						<tr>
							<th>Product ID</th>
							<th>Product Name</th>
							<th>Product Cost</th>
							<th>Product Description</th>
							<th>Quantity</th>
							<th>Product Price</th>
						</tr>
						<c:forEach items="${products }" var="product">
							<c:forEach items="${quantities }" var="quantity">
								<tr>
									<% int cost =  Integer.parseInt("${product.cost }")*Integer.parseInt("quantity"); %>
									<td>${product.id }</td>
									<td>${product.productName }</td>
									<td>${product.cost }</td>
									<td>${product.productDescription }</td>
									<td><label>quantity</label></td>
									<td><label><%= cost %></label></td>
								</tr>
							</c:forEach>
						</c:forEach>				
					</table>
				</c:otherwise>
	</c:choose>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>