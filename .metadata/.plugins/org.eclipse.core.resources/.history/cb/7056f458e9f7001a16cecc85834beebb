<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CMS</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<h3>${isNew?"New Contact":"Edit Contact" }</h3>
	
	<form:form action='${isNew?"addContact":"saveContact"}' method="POST" modelAttribute="contact">
		<div>
			<form:label path="contactId">Contact Id</form:label>
			<form:input type="number" path="contactId" readonly="${!isNew }" />
			<form:errors path="contactId"/>
		</div>
		<p/>
		<div>
			<form:label path="fullName">Full Name</form:label>
			<form:input type="text" path="fullName"/>
			<form:errors path="fullName"/>
		</div>
		<p/>
		<div>
			<form:label path="mobile">Mobile</form:label>
			<form:input type="text" path="mobile"/>
			<form:errors path="mobile"/>
		</div>
		<p/>
		<div>
			<form:label path="dateOfBirth">Date Of Birth</form:label>
			<form:input type="date" path="dateOfBirth"/>
			<form:errors path="dateOfBirth"/>
		</div>
		<p/>
		<div>
			<form:label path="married">I am Married</form:label>
			<form:checkbox path="married"/>
			<form:errors path="married"/>
		</div>
		<p/>
		<div>
			<form:label path="group">Group</form:label>
			<form:select path="group" items="${allGroups }"/>
			<form:errors path="group"/>
		</div>
		<p/>
		
		<button>SAVE</button>
	</form:form>
</body>
</html>