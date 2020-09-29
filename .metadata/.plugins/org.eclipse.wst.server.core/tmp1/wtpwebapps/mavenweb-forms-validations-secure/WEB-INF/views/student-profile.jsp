<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<style type="text/css">
			.error{
				color : red;
			}
		</style>
	</head>
	<body>
		<h1>Provide you profile info</h1>
		<hr/>
		<%-- 
			modelAttribute : Map the model object with spring form
			When form loads :
			 calls the getter methods of fields	 
			When form is submitted :
			 calls the setter methods of fields	  
		--%>
		<spring:form action="save" method="post" modelAttribute="student">
			<div>
				<div><spring:label path="name">Enter name</spring:label></div>
				<div>
					<spring:input path="name"/>
					<spring:errors path="name" cssClass="error"/>
				</div>
			</div>
			</br></br>
			<div>
				<div><spring:label path="email">Enter Email</spring:label></div>
				<div><spring:input path="email"/></div>
			</div>
			
			</br></br>
			<div>
				<div><spring:label path="freePasses">Enter Free Passes</spring:label></div>
				<div>
					<spring:input path="freePasses"/>
					<spring:errors path="freePasses" cssClass="error"/>
				</div>
			</div>
			</br></br>
			<div>
				<div><spring:label path="courseCode">Enter Course Code</spring:label></div>
				<div>
					<spring:input path="courseCode"/>
					<spring:errors path="courseCode" cssClass="error"/>
				</div>
			</div>
			</br></br>
			<div>
				<div><spring:label path="country">Enter Country</spring:label></div>
				<div>
					<spring:select path="country">
						<spring:options items="${student.countries}"/>
					<%-- 
						hard coded
						<spring:option value="FR" label="France"/>
						<spring:option value="IN" label="India"/>
						<spring:option value="GR" label="Germany"/>
						<spring:option value="US" label="USA"/>
					 --%>	
					</spring:select>
				</div>
			</div>
			</br></br>
			<div>
				<div><spring:label path="email">Select Favorite Language</spring:label></div>
				<div>
					<spring:radiobutton path="favoriteLanguage" value="Python"/> Python
					<br/>
					<spring:radiobutton path="favoriteLanguage" value="Java"/> Java
					<br/>
					<spring:radiobutton path="favoriteLanguage" value="C#"/> C#
					<br/>
					<spring:radiobutton path="favoriteLanguage" value="Javascript"/> Javascript
				</div>
			</div>
			</br></br>
			<div>
				<div><spring:label path="email">Select your experiences in :</spring:label></div>
				<div>
					<spring:checkbox path="operatingSystems" value="Linux"/> Linux
					<br/>
					<spring:checkbox path="operatingSystems" value="Alpine"/> Alpine
					<br/>
					<spring:checkbox path="operatingSystems" value="Mac"/> Mac
					<br/>
					<spring:checkbox path="operatingSystems" value="Windows"/> Windows
					
				</div>
			</div>
			</br>
			<div>
				<div><input type="submit" value="Submit" /></div>
			</div>
		</spring:form>
	</body>
</html>







