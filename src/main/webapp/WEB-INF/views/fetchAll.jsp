<%@page import="com.shabbir.springMVC.project.Model.Entity.RegisterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	<style>
		
		table{
			max-width:98%;
			overflow-x:auto;
		}
	
	</style>
</head>
<body>

	<h1>${dele}</h1>
<%
	RegisterBean r =(RegisterBean) session.getAttribute("ses");
	if(r == null){
		System.out.println("hiii");
		request.setAttribute("mes", "Your Session Has expired");
		request.getRequestDispatcher("login.jsp").forward(request, response);	
	}
%>
	<jsp:include page="navbar.jsp"/>
	<sql:setDataSource driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/springjdbc" user="root"
		password="root" var="ds" />

	<sql:query var="st" dataSource="${ds}">select * from students</sql:query>

	<table class="table">
		<tr>
			<th>Students Id</th>
			<th>Students Name</th>
			<th>Students Address</th>
			<th>Students Aadhar No</th>
			<th>Students Pan No</th>
			<th>Students Gender</th>
			<th>Students Marcial States</th>
			<th>Students Email</th>
			<th>Students Date Of Birth</th>
			<th>Students Phone No</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:forEach items="${st.rows}" var="row">
			<tr>
				<td><c:out value="${row.id}"/></td>
				<td><c:out value="${row.name}"/></td>
				<td><c:out value="${row.address}"/></td>
				<td><c:out value="${row.Aadhar_number}"/></td>
				<td><c:out value="${row.Pancard_ID}"/></td>
				<td><c:out value="${row.gender}"/></td>
				<td><c:out value="${row.Marritual_Status}"/></td>
				<td><c:out value="${row.email}"/></td>
				<td><c:out value="${row.Date_Of_Birth}"/></td>
				<td><c:out value="${row.phone_Number}"/></td>
				<td><form action="edit"method="post">
				<input type="hidden" name="id" value="${row.id}">
				<button type="submit">Edit</button></form></td>
				<td><a href="delete/${row.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>