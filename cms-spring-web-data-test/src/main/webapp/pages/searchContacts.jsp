<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CMS</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div>
		<form action = "searchbyMobile">
		Search by Mobile: <input type="text" name="mobile" placeholder ="Mobile #" /><span> </span><button type="submit">Search</button><p/>
		</form>
		<form action = "searchbyGroup">
		Search by Group: <input type="text" name="grp" placeholder  = "Group Name"/><span> </span><button type="submit">Search</button><p/>
		</form>
		<form action = "searchbyDobRange">
		Search by DOB Range: <p/>Start Date <input type="date" name="start" /><span> End Date: </span><input type="date" name="end" /><span> </span><button type="submit">Search</button><p/>
		</form>
	</div>
	<c:choose>
		<c:when test="${contacts == null || contacts.isEmpty() }">
			<p><strong>${msg }</strong></p>
		</c:when>	
		<c:otherwise>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>Contact#</th>
					<th>Full Name</th>
					<th>Date Of Birth</th>
					<th>Group</th>
					<th>Married?</th>					
					<th>Mobile</th>
				</tr>
				<c:forEach items="${contacts }" var="contact">
					<tr>
						<td>${contact.contactId }</td>
						<td>${contact.fullName }</td>
						<td>${contact.dateOfBirth }</td>
						<td>${contact.group }</td>
						<td>${contact.married }</td>
						<td>${contact.mobile }</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>