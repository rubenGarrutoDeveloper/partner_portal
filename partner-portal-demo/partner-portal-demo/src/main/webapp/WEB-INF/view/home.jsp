<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>partner-portal</title>
</head>
<body>
	<h1>Partner Portal Home</h1> Role(s): <security:authentication property="principal.authorities"/>
	
	<hr>
	<p>
	Welcome <security:authentication property="principal.username"/>, to the partner portal!
	<br>
	</p>
	
	
	<security:authorize access="hasRole('PARTNER')">
	<hr>
	<p>
		<a href="${pageContext.request.contextPath}/projects">go to Projects</a>
	</p>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
	<hr>
	<p>
		<a href="${pageContext.request.contextPath}/admin/systems">go to Systems</a>
	</p>
	</security:authorize>
	
	
	
	<!-- logout -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" />
	</form:form>
	
</body>
</html>