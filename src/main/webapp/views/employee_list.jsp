<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
<link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
	<center>
		<table br border="2">
			<div class="container">
				<h2 style="color: green";>Employee List</h2>

				<thead>
					<tr>
						<th scope="row">User_Id</th>
						<th scope="row">First_Name</th>
						<th scope="row">Last_Name</th>
						<th scope="row">User_Email</th>
						<th scope="row">User_Password</th>

						<th scope="row">Edit</th>
						<th scope="row">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${employee_list }" var="employee">
						<tr>
							<td>${employee.empid}</td>
							<td>${employee.firstname }</td>
							<td>${employee.lastname }</td>
							<td>${employee.useremail }</td>
							<td>${employee.userpassword }</td>

							<td><spring:url value="/update/${employee.empid }"
									var="updateURL" /> <a class="btn btn-primary"
								href="${updateURL }" role="button">Update</a></td>
							<td><spring:url value="/delete/${employee.empid }"
									var="deleteURL" /> <a class="btn btn-primary"
								href="${deleteURL }" role="button">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
		<spring:url value = "/add" var="addURL" />
		<br> <br>
		<hr>
		<a class="btn btn-primary" href="${addURL }" role="button">Add New
			Employee</a>
		</div>
	</center>
</body>
</html>