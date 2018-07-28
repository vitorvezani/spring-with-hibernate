<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<title>Customer List</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<input type="button" value="Add Customer" onclick="window.location.href='customers/showFormForAdd'; return false;" class="add-button" />
			<form:form action="search" method="POST">
                Search customer: <input type="text" name="theSearchName" />
                <input type="submit" value="Search" class="add-button" />
            </form:form>
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="cust" items="${customers}">
					<c:url var="updateLink" value="/customers/showFormForUpdate">
						<c:param name="customerId" value="${cust.id}" />
					</c:url>
					<c:url var="deleteLink" value="/customers/delete">
						<c:param name="customerId" value="${cust.id}" />
					</c:url>
					<tr>
						<td>${cust.firstName}</td>
						<td>${cust.lastName}</td>
						<td>${cust.email}</td>
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer?')))">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>