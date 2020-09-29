<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Add New Product(Admin)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<a href="listproducts.jsp" >Back</a>
<hr/>

<form action="newproduct?action=newproduct" method="POST">	
		<div>
			<label>Product Id</label>
			<input type="number" name="pid" value="${product.pid }" required/>
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