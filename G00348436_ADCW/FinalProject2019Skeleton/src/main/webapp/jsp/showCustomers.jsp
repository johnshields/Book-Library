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
<title>List of Customers</title>
</head>
<body>
	<h1>1 John</h1>	
	<tr>
	<th>Loan Period = 10 days<th>
	</tr>
		<h1>John's Loans</h1>
	<table>
		<tr>
			<th>Loan ID</th>
			<th>Book ID</th>
			<th>Title</th>
			<th>Author</th>
		</tr>
		<br>
		<br>
			<c:forEach items="${books}" var="book">
			<tr> 
		    	<td>${book.bid}</td>
		    	<td>${book.title}</td>
		    	<td>${book.author}</td>
    		</tr>
		</c:forEach>
		</table>
		
		<table>
			<tr>
				<th>Customer ID</th>
				<th>Customer Name</th>
				<th>Loan Period</th>
			</tr>
			<c:forEach items="${customers}" var="customer">
			<tr> 
		    	<td>${customer.cId}</td>
		    	<td>${customer.cName}</td>
		    	<td>${customer.loanPeriod}</td>
    		</tr>
		</c:forEach>
		</table>
 </body>
</html>