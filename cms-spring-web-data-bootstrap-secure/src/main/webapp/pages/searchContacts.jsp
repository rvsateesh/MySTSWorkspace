<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CMS</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="${pageContext.request.contextPath}/header" />
	<section class="d-inline container-fluid p-10 w-50 float-center">
		<div class="d-inline-block p-5 float-left">
			<form class="form" action = "searchbyMobile">
				<label>Search by Mobile </label>
				<input class = "form-control" type="text" name="mobile" placeholder ="Mobile #" />
				<button class="btn btn-primary" type="submit">Search</button>
			</form>
		</div>
		<div class="d-inline-block p-5 float-left">
			<form class="form" action = "searchbyGroup">
				<label>Search by Group </label>
				<input class = "form-control" type="text" name="grp" placeholder  = "Group Name"/>
				<button class="btn btn-primary" type="submit">Search</button>
			</form>
		</div>
		<div class="d-inline-block p-5 float-left">
			<form class="form" action = "searchbyDobRange">
				<label>Search by DOB Range </label><p/>
				<div class="d-inline-block float-left">
					<label>Start Date: </label>
					<input class = "form-control" type="date" name="start" />
					<label> End Date: </label>
					<input class = "form-control" type="date" name="end" />
					<button class="btn btn-primary" type="submit">Search</button>
				</div>
			</form>
		</div>
	</section>
	<section class="container-fluid p-4">
		<c:choose>
			<c:when test="${contacts == null || contacts.isEmpty() }">
				<p><strong>${msg }</strong></p>
			</c:when>	
			<c:otherwise>
				<table  class="table table-striped table-hover">
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
	</section>
</body>
</html>