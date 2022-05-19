<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
    <%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order page</title>
</head>
<body style="background-color: #F8D0F8;">
<div align="center">
<h2>Order Burger</h2>
<br>
<table>
<sf:form action="orderBurger" method="post" modelAttribute="burger">
<tr>
<td>Burger Name: </td><td><sf:select path="burgerName">
<core:forEach items="${burgerList}" var="bl">
<sf:option value="${bl}"></sf:option>
</core:forEach>
</sf:select>
</td>
</tr>
<tr>
<td>Topping Name: </td><td><sf:select path="toppingName">
<core:forEach items="${toppingList}" var="bl">
<sf:option value="${bl}"></sf:option>
</core:forEach>
</sf:select>
</td>
</tr>
<tr>
<td>
Number of Burger: </td><td><sf:input path="noOfBurgers"/>
</td>
<td><sf:errors path="noOfBurgers" value=""></sf:errors></td>
</tr><tr align="center">
<td colspan="2">
<input type="submit" value="Order">
</td>
</tr>
</sf:form>
</table>
</div>
</body>
</html>