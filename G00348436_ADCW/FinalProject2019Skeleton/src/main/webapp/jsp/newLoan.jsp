<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a Loan</title>
</head>
<body>
  <h1>Add Loan</h1>
  
  <form:form modelAttribute="loan">
     <table>
      <tr>
        <td>Customer ID:</td>
        <td><form:input path="cust"></form:input></td>
        <td><form:errors path="cust"></form:errors></td>
      </tr>
      <tr>
        <td>Book ID:</td>
        <td><form:input path="book"></form:input></td>
        <td><form:errors path="book"></form:errors></td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" value="Add"/>
        </td>
      </tr>
    </table> 
  </form:form>
    <a href="/">Home</a>
</body>
</html>