<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Custom Login Page</title>
	<style type="text/css">
		.invalid {
			color: red;
		}
	</style>
</head>
<body>
	<h3>My Custom Login Page</h3>
	<f:form action="${pageContext.request.contextPath}/authenticate-the-user" method="POST">
	
		<c:if test="${param.error != null}">
			<i class="invalid">Sorry, you entered invalid username/password</i>
		</c:if>
	
		<p>User: <input type="text" name="username"/></p>
		<p>Password <input type="password" name="password"/></p>
		
		<input type="submit" name="Login"/>
	</f:form>
</body>
</html>