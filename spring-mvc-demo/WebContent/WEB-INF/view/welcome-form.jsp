<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page!</title>
</head>
<body>
	<h1>Hello user, please enter your name!</h1>
	<form action="processForm" method="GET" >
		<input type="text" name="name" placeholder="What is your name?"/>
		<input type="submit"/>
	</form>

	<form action="processFormVersionTwo" method="GET" >
		<input type="text" name="name" placeholder="What is your name?"/>
		<input type="submit"/>
	</form>

	<form action="processFormVersionThree" method="GET" >
		<input type="text" name="name" placeholder="What is your name?"/>
		<input type="submit"/>
	</form>
</body>
</html>