<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shipping Entry</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 15px;
    text-align: left;
}
table#t01 {
    width: 100%;    
    background-color:  #F2F2F0;
}
</style>
</head>
<body>

<h2>Choose Your Shipment address</h2>

<form:form modelAttribute="shipping" method="post" action="purchase/submitShipping">
    <table id="t01">
    		<tr>
    			<th colspan="2">Shipment info</th>
  			</tr>
			<tr>
				<td><c:out value="Name"></c:out></td>
				<td><form:input path="name" /></td>											
			</tr>
			
			<tr>
				<td><c:out value="Address Line 1"></c:out></td>
				<td><form:input path="addressLine1" /></td>									
			</tr>
			
			<tr>
				<td><c:out value="Address Line 2"></c:out></td>
				<td><form:input path="addressLine2" /></td>									
			</tr>
			
			<tr>
				<td><c:out value="City"></c:out></td>
				<td><form:input path="city" /></td>										
			</tr>
			
			<tr>
				<td><c:out value="State"></c:out></td>
				<td><form:input path="state" /></td>											
			</tr>	
			
			<tr>
				<td><c:out value="Zip"></c:out></td>
				<td><form:input path="zip" /></td>									
			</tr>
    </table>
    <br> </br>
    <td colspan="2"><input type="submit" value="Submit"></td>
</form:form>

</body>
</html>