<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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