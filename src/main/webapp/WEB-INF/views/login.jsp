<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
}

.container {
	max-width: 400px;
	margin: 0 auto;
	padding: 20px;
	background-color: #ffffff;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
	text-align: center;
}

input[type="email"], input[type="password"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border-radius: 5px;
	border: 1px solid #ccc;
	box-sizing: border-box;
	font-size: 16px;
}

input[type="submit"] {
	background-color: #4caf50;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
<h1>${mes}</h1>
	<div class="container">
	<h3 style="color:red;" align="center">${fail}</h3>
	<h2 style="color:green;" align="center">${secess}</h2>
		<h1>Login</h1>
		<form method="post" action="log">
			<input type="email" name="email" placeholder="Email" required>
			<input type="password" name="password" placeholder="Password"
				required> <input type="submit" value="Login">
				<input type="hidden" value="login" name="action">
		</form>
	</div>
</body>
</html>