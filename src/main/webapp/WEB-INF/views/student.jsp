<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.shabbir.springMVC.project.Controller.RegisterController"%>
<%@page import="com.shabbir.springMVC.project.Model.Service.RegisterService"%>
<%@page import="com.shabbir.springMVC.project.Model.Entity.RegisterBean"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Student Detail</title>
	<style>
	@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800&display=swap');
		*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: "Poppins", sans-serif;
}

body {
	
	padding:20px;
    min-height: 100vh;
    width: 100%;
    display: flex;
    flex-direction:column;
    justify-content: center;
    align-items: center;
    background: #f2f2f2;

}

.form {

    box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
    background: white;
    border-radius: 5px;
    padding: 20px;
    width: 700px;
    max-width: 100%;
    
}

.form h1 {

    text-align: center;
    margin-bottom:10px;
    font-size: 30px;
    font-weight: 600;

}

.form :where(input, select) {

    height: 40px;
    width: 100%;
    margin: 5px 0;
    border-radius: 3px;
    padding-inline: 10px;
    font-size: 14px;
    border: 1px solid lightgreen;
    outline: none;
    color: black;

}

.form input[type=submit]{
    
    border-color:lime;
    background:lime;
    cursor:pointer;
    color:white;
    font-size:16px;
    font-weight:400;
    transition:all 0.3s ease;

}

.form input[type=submit]:hover{

    background:green;

}

.form input:focus , form select:focus {

    border-color:lightgreen;
    box-shadow:inset 0 0 10px 2px lightgreen;

}

.form input[type=submit]:focus{

   background:green;

}
label{
	
	display:block;

}
	</style>
</head>

<body>
	
	<jsp:include page="navbar.jsp"/>
	
	<%
	RegisterBean r =(RegisterBean) session.getAttribute("ses");
	System.out.println(r);
	if(r == null){
		System.out.println("hiii");
		request.setAttribute("mes", "Your Session Has expired");
		request.getRequestDispatcher("login.jsp").forward(request, response);	
	}
	%>
	
    <form action="student" class="form" method="post">

        <h1>Fill Detail</h1>

        <input type="text" name="name" required placeholder="Enter your full name" value="<%=r.getName()%>">
        <input type="text" name="address" required placeholder="Enter your full address">
        <select name="gender" id="">

            <option value="none" selected disabled>Enter your gender</option>
            <option value="male">Male</option>
            <option value="female">Female</option>

        </select>
		<select name="marritualStatus" id="">

            <option value="none" selected disabled>Enter your Marritual status</option>
            <option value="married">Married</option>
            <option value="unmarried">Unmarried</option>

        </select>
		<label>Enter your DOB :</label>
		<input type="date" pattern="\d{4}-\d{2}-\d{2}" name="dateOfBirth" placeholder="Enter your dob">
		<input type="text" name="panCardNumber" placeholder="Enter your pan no">
		<input type="text" name="aadharNumber" placeholder="Enter your aadhar no">
        <input type="number" name="phoneNumber" required placeholder="Enter your number" value="<%=r.getPhoneNumber()%>">
        <input type="email"  name="email" required placeholder="Enter your email" value="<%=r.getEmail()%>">
        <button type="submit">Submit</button>
    </form>
</body>
</html>