<%-- 
    Document   : admin
    Created on : Jun 24, 2022, 12:29:31 AM
    Author     : hungp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dto.UserDto"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
    <c:set var="user" value="${sessionScope.LOGIN_USER}"/>
    <c:if test="${user.getRoleId() != 'AD'}">
        <c:redirect url="403.html"/>
    </c:if>
    Hello Admin: <h1>${sessionScope.LOGIN_USER.fullName}</h1>
    <form action="MainController">
        Year <input type="number" name="year" value="year" placeholder="yyyy" > </br>
        Month <input type="number" name="month" value="month" placeholder="mm" > </br>
        Day <input type="number" name="day" value="day" placeholder="dd" > </br>       
        <input type="submit" name="action" value="Check date">
        <input type="reset" name="Reset" />
    </form>
    <c:if test="${not empty requestScope.ERROR}">
        <h1 style="color: red">${requestScope.ERROR}</h1>
    </c:if>
</body>
</html>
