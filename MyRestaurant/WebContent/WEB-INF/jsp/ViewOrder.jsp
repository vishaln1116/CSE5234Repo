<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Order</title>
</head>
<body>

<form:form method="post" action="/purchase/accept">
    <table>
		<c:forEach items="${order.items}" var="item" varStatus="loop">
			<tr>
				<td><c:out value="${item.name}"></c:out></td>
				<td><c:out value="$${item.price}"></c:out></td>
				<td><c:out value="${item.quantity}"></c:out></td>
			</tr>
		</c:forEach>
		
		<tr>
			<td><c:out value="Name"></c:out></td>
			<td><c:out value="${shipping.name}"></c:out></td>
		</tr>

	  	<tr>
			<td colspan="2"><input type="submit" value="Next"></td>
		</tr>
		
    </table>
</form:form>

</body>
</html>