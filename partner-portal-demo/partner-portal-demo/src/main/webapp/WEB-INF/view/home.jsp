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
	
	<hr>
	
	<!-- logout -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" />
	</form:form>
	
</body>
</html>