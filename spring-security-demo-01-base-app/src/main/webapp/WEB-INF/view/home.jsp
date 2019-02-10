<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Luv2Code</title>
</head>
<body>
  <h2>luv2Code Company Home Page</h2>
  <p>Welcome to luv2code Company Site</p>
  <p>
    User:
    <s:authentication property="principal.username" />
  </p>
  <p>
    Roles:
    <s:authentication property="principal.authorities" />
  </p>
  <s:authorize access="hasRole('MANAGER')">
    <a href="${pageContext.request.contextPath}/leaders">Leaders</a>
  </s:authorize>
  <s:authorize access="hasRole('ADMIN')">
    <a href="${pageContext.request.contextPath}/systems">Systems</a>
  </s:authorize>
  <!-- Logout Form -->
  <form:form action="${pageContext.request.contextPath}/logout" method="POST" class="form-horizontal">
    <!-- Login/Submit Button -->
    <div style="margin-top: 10px" class="form-group">
      <div class="col-sm-6 controls">
        <button type="submit" class="btn btn-success">Logout</button>
      </div>
    </div>
  </form:form>
</body>
</html>