<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Entry</title>
</head>
<body>

<form:form modelAttribute="order" method="post" action="/purchase/submitItems">
    <table>
        <tr>
	     <td>Quantity:</td>
            <td><form:input path="quantity"/></td>
	     <td>Number 3 Wood </td>
        </tr>

    </table>
</form:form>



</body>
</html>