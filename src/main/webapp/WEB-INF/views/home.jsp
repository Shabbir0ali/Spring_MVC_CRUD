<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style>
* {
	margin: 0;
	padding: 0;
}

.home {
	min-height: 100vh;
	background: url('resources/image/stud.avif') rgba(0,0,0,0.5);
	background-blend-mode:multiply;
	display:flex;
	justify-content:center;
	align-items:center;
	text-align:center;
}
.content{
width:500px;
background:rgba(255,255,255,0.2);
box-shadow:0 4px 5px rgba(255,255,255,0.3);
border-radius:5px;
padding:15px;}

h1{
color:white;
}
.mess{
color:red;}
</style>
</head>
<body>
	<jsp:include page="navbar.jsp" />

	<div class="home">
		<div class="content">
		<h1>Welcome to home page</h1>
			<h1>${messa}</h1>
			<h1 class="mess">${up}</h1>
			<h2 class="mess">${message}</h2>
			<h3 class="mess">${save}</h3>
			
		</div>
	</div>

</body>
</html>
