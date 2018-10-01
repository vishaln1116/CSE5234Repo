<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Entry</title>
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

<h2>Shopping Cart</h2>

<form:form modelAttribute="order" method="post" action="purchase/submitItems">
    <table id="t01">
    	<tr>
    		<th>Item name</th>
    		<th>Price</th>
    		<th>Quantity</th>
  		</tr>
		<c:forEach items="${order.items}" var="item" varStatus="loop">
			<tr>
				<td><c:out value="${item.name}"></c:out></td>
				<td><c:out value="$${item.price}"></c:out></td>
				<td><form:input path="items[${loop.index}].quantity" /></td>
				<form:hidden path="items[${loop.index}].name" value="${item.name}"/>
   				<form:hidden path="items[${loop.index}].price" value="${item.price}"/>
			</tr>
		</c:forEach>
    </table>
    <br> </br>
    <td colspan="2"><input type="submit" value="Purchase"></td>
</form:form>



</body>
</html>