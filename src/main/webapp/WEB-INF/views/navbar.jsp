<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

	.navbar{
	
		background:white;
		width:100%;
		position:fixed;
		top:0;
		left:0;
		display:flex;
		justify-content:space-between;
		align-items:center;
		height:45px !important;
		padding:0 20px !important;
		box-shadow:0 4px 5px rgba(0,0,0,0.2);
	
	}
	body{
	
		margin-top:50px;
	
	}
	
	.navbar .logo{
	
		font-size:22px;
	
	}
	
	.navbar .logo span{
	
		color:lime;
	
	}
	.navbar nav{
		display:flex;
		align-items:center;
	}
	.navbar nav a{
	
		text-decoration:none;
		margin-inline:10px;
		text-transform:uppercase;
		cursor:pointer;
		position:relative;
		display:inline-block;
		transition:all 0.3s ease;
	
	}
	
	.navbar nav a:before{
		content:'';
		position:absolute;
		display:block;
		width:0;
		height:2px;
		background:lime;
		left:0;
		top:calc(100% + 2px);
		transition:all 0.3s ease;
	}
	
	.navbar nav a:hover:before{
	
		width:100%;
	
	}
	
	.navbar nav a:hover{
	
		color:lime;
	
	}
	
</style>
</head>
<body>

	<div class="navbar">
		<div class="logo">
		
			Shabbir<span>.ali</span>
		
		</div>
		<nav>
			<a href="home">Home</a>
			<a  href="fetch">Student Detail</a>
			<a href="main">Profile</a>
			<form action="student" method="get"></form>
			<a class="btn" href="logout">Logout</a>
		</nav>
	</div>
</body>
</html>