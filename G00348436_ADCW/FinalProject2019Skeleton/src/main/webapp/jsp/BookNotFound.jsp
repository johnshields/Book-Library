<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error - Book Not Found</title>
</head>
<body>
	<h1>Could not delete Book, book does not Exist!</h1>
	
	<c:forEach items="${books}" var="book"> 
	<h3>Book: ${book.bid} ( ${book.title} )</h3> 
 	</c:forEach> 
	
	<h1>${error.message}</h1>
	
	
</body>
<a href="/showBooks">List Books</a>
<a href="/showCustomers">List Customers</a>
<a href="/showLoans">List Loans</a>
<a href="/addBook">Add Book</a>
<a href="/addCustomer">Add Customers</a>
<a href="/newLoan">New Loan</a>
<a href="/deleteLoan">Delete Loan</a>
<a href="/login">Login</a>
<a href="/logout">Logout</a>
</html>