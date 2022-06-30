<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Employees</title>
 <link href="http://localhost:8080/webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="http://localhost:8080/webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>

</head>
<body>
<center>
 <div class="container">
  <spring:url value="/save" var="saveURL" />
  <h2 style="color:blue">Registration form </h2>
  <form:form modelAttribute="employeeForm" method="post" action="${saveURL }" cssClass="form">
   <form:hidden path="empid"/>
   <div class="form-group">
   <div class="form-group">
    <lable for="firstname">First_Name</lable>
    <form:input path="firstname" cssClass="form-control" id="firstname" />
   </div>
   
   
   <div class="form-group">
    <lable for="lastname">Last_Name</lable>
    <form:input path="lastname" cssClass="form-control" id="lastname" />
   </div>
   
   
    <lable for="useremail">User_Email</lable>
    <form:input path="useremail" cssClass="form-control" id="useremail" />
   </div>
   <div class="form-group">
    <lable for="userpassword">User_Password</lable>
    <form:input path="userpassword" cssClass="form-control" id="userpassword" />
   </div>
  
  
   
   <button type="submit" class="btn btn-primary">Sign-Up</button>
  </form:form>
 </div>
 </center>
</body>
</html>