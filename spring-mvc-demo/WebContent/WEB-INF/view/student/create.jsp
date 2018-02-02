<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new Student</title>
</head>
<body>
	<h1>Formulário de Criação de Estudante</h1>
	<form:form action="new" modelAttribute="student">
		<p>
			<label>First name: </label>
			<form:input path="firstname" />
		</p>
		<p>
			<label>Last name: </label>
			<form:input path="lastname" />
		</p>
		<p>
			<form:select path="country">
				<form:option value="Brazil"></form:option>
				<form:option value="France"></form:option>
				<form:option value="Germany"></form:option>
				<form:option value="India"></form:option>
			</form:select>
		</p>
		<p>
			<form:select path="ocupation">
				<form:options items="${student.ocupations}" />
			</form:select>
		</p>
		<p>
			<form:radiobutton path="favoriteLanguage" label="Java" value="Java" />
			<form:radiobutton path="favoriteLanguage" label="PHP" value="PHP" />
			<form:radiobutton path="favoriteLanguage" label="Scala" value="Scala" />
			<form:radiobutton path="favoriteLanguage" label="Python" value="Python" />
		</p>

		<p>
			<form:checkbox path="operationSystems" label="MS Windows" value="MS Windows" />
			<form:checkbox path="operationSystems" label="Mac OS" value="Mac OS" />
			<form:checkbox path="operationSystems" label="Linux Distros" value="Linux Distros" />
		</p>
		<input type="submit" value="Submit"></input>
	</form:form>
</body>
</html>