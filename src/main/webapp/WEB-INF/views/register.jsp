<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
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

input[type="text"], input[type="email"], input[type="password"], input[type="number"]
	{
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border-radius: 5px;
	border: 1px solid #ccc;
	box-sizing: border-box;
	font-size: 16px;
}

input[type="submit"] , .btn {
	background-color: #4caf50;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
	width:100%;
	margin:10px 0;
}

input[type="submit"]:hover{
	background-color: #45a049;
}

.one {
	background-color: #45a049;
	padding: 10px;
	margin-left: 150px;
	border-radius: 7px;
	color: white;
	text-decoration: none;
}
.btn{
	background:orange;
	transition:all 0.3s ease;
}
.btn:hover {
	background:orangered;
}
</style>
</head>
<body> 
	<div class="container">
		<h4 style="color: red;">${message}</h4>
		<h1>Register</h1>
		<form method="post" action="reg">
			<input type="text" name="name" placeholder="Name" required> <input
				type="email" name="email" placeholder="Email" required> <input
				type="password" name="password" placeholder="Password" required>
			<input type="password" name="confirmPassword"
				placeholder="Confirm Password" required> <input
				type="number" name="phoneNumber" placeholder="Phone Number" required>
			<input type="submit" value="Register"> <input type="hidden"
				value="register" name="action">
	
			
			</form>
			<form action="login" method="post">
					<button class="btn" type="submit">Already Registered</button>
			</form>
			
	</div>
</body>
</html>