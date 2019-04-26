<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/css/style.css" rel="stylesheet"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>showLoans</title>
</head>
<body>
	<h1>showLoans</h1>
		<table>
			<tr>
				<th>Loan ID</th>
				<th>Due Date</th>
				<th>bid</th>
				<th>cid</th>
			</tr>
			<c:forEach items="${loans}" var="loan">
			<tr> 
		    	<td>${loan.lid}</td>
		    	<td>${loan.dueDate}</td>
		    	<td>${loan.book}</td>
		    	<td>${loan.cust}</td>
    		</tr>
		</c:forEach>
		</table>
 </body>
</html>