<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Edit Product(Admin)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<form action="editproduct" method="POST">
		<div>
			<label>Product Id</label>
			<input type="number" name="pid" value="${product.pid }" ${"readonly" } required/>
			<p></p>
		</div>
		<div>
			<label>Product Name</label>
			<input type="text" name="pname" value="${product.pname }" required/>
			<p></p>
		</div>
		<div>
			<label>Product Cost</label>
			<input type="number" name="pcost" value="${product.pcost }" required/>
			<p></p>
		</div>
		<div>
			<label>Product Description</label>
			<input type="text" name="pdesc" value="${product.pdesc }" />
			<p></p>
		</div>
		<button>SAVE</button>
	</form>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>