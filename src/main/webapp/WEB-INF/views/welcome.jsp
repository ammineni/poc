<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WELCOME TO SECURE AREA</title>
</head>
<body>
 <%-- <h1>Message : ${message}</h1> 
 <h1>Author : ${author}</h1> 
 <h2>Spring3MVC with Hibernate3 CRUD Example using Annotations</h2>   --%>  
    <h2>1. <a href="employees.html">List of Employees</a></h2>
    <h2>2. <a href="add.html">Add Employee</a></h2> 
    <a href='<c:url value="/j_spring_security_logout" />' > Logout</a>
</body>
</html>
