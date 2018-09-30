<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Entry</title>
</head>
<body>

<form:form modelAttribute="payment" method="post" action="purchase/submitPayment">
    <table>
			<tr>
				<td><c:out value="Credit Card"></c:out></td>
				<td><form:input path="creditCard" /></td>											
			</tr>
			
			<tr>
				<td><c:out value="Expiration Date"></c:out></td>
				<td><form:input path="expirationDate" /></td>									
			</tr>
			
			<tr>
				<td><c:out value="CVV Code"></c:out></td>
				<td><form:input path="cvvCode" /></td>										
			</tr>
			
			<tr>
				<td><c:out value="Holder Name"></c:out></td>
				<td><form:input path="holderName" /></td>											
			</tr>	
	  	<tr>
			<td colspan="2"><input type="submit" value="Submit"></td>
		</tr>
		
    </table>
</form:form>

</body>
</html>