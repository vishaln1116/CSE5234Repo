<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shipping Entry</title>
</head>
<body>

<form:form modelAttribute="shipping" method="post" action="purchase/submitShipping">
    <table>
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
	  	<tr>
			<td colspan="2"><input type="submit" value="Submit"></td>
		</tr>
		
    </table>
</form:form>

</body>
</html>