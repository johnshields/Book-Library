<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error - Book Occupied</title>
</head>
<body>
	<h1>Could not add new Loan. Book Occupied</h1>

	<h1>${error.message}</h1>
	
	<c:forEach items="${loans}" var="loan">
	<h3>Book: ${loan.book.bid} ( ${loan.book.title} )</h3>
	<h3> already on loan to Customer ${loan.cust.cId} ${loan.cust.cName}</h3>
	</c:forEach>
</body>
<a href="/showBooks">List Books</a>
<a href="/showCustomers">List Customers</a>
<a href="/showLoans">List Loans</a>
<a href="/adds/addBook">Add Book</a>
<a href="/addCustomer">Add Customers</a>
<a href="/newLoan">New Loan</a>
<a href="/deleteLoan">Delete Loan</a>
<a href="/login">Login</a>
<a href="/logout">Logout</a>
</html>