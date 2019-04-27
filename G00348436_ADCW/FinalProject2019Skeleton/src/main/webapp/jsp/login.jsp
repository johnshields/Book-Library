<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
  <h1>Login</h1>
     <table>
      <tr>
        <td>User: </td>
        <td><input></input></td>

      </tr>
      <tr>
        <td>Password:</td>
        <td><input></input></td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" value="Login"/>
        </td>
      </tr>
    </table> 

</body>
<a href="/addBook">Add Book</a>
<a href="/addCustomer">Add Customers</a>
<a href="/newLoan">New Loan</a>
<a href="/deleteLoan">Delete Loan</a>
<a href="/logout">Logout</a>
</html>