<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="i" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="/css/style.css"> 
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>showCustomers</title>
</head>
<body>
    <h1>List of Customers</h1>
        <i:forEach items="${customers}" var="customer">
                <h2>${customer.cId} ${customer.cName}</h2>
             	<h3>Loan Period = ${customer.loanPeriod} days</h3>          	
             	<h3>${customer.cName}'s Loans</h3>
           <table>
         	<tr>
         		<th>Loan ID</th>
         		<th>Book ID</th>
         		<th>Title</th>
         		<th>Author</th>
         	</tr>
        		<j:forEach items="${customer.loans}" var="loan">
				<tr>
					<td>${loan.lid}</td>
					<td>${loan.book.bid}</td>
					<td>${loan.book.title}</td>
					<td>${loan.book.author}</td>
				</tr>
        		</j:forEach>
       	</table>
        </i:forEach>
</body>
<a href="/">Home</a> <a href="/addCustomer">Add Customer</a>
<a href="/showBooks">List Book</a> 
<a href="showLoans">List Loans</a>
</html>