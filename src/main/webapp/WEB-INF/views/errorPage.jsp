<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Sorry ! something went wrong....</title>
</head>
<body>
	<div class="container p-3 text-center ">

		<img alt="my image"
			src="<c:url value="resources/image/image_processing20191002-16695-d2kk1m.jpg"/>"
			class="img-fluid">

		<h1 align="center" class="display-3">Sorry ! something went wrong</h1>
		<a class="btn btn-outline-primary" href="register">Register Page</a><br>
		<%=exception%>
	</div>
</body>
</html>