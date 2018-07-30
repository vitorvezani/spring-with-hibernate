<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new Student</title>
</head>
<body>
	<p>Estudante ${student.firstname} ${student.lastname} (idade: ${student.age}) criado com sucesso!</p>
	<p>${student.firstname} é do ${student.country}</p>
	<p>${student.firstname} prefere a linguagem ${student.favoriteLanguage}</p>

	<p>Course Code: ${student.courseCode}</p>

	<ul>
		<c:forEach var="os" items="${student.operationSystems}">
			<li>${os}</li>
		</c:forEach>
	</ul>
</body>
</html>