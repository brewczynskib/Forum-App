<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
</head>
<h1>
    Users :
</h1>
<body>
<c:forEach var="element" items="${user}"> User ${element.login}<br />
<a href = "UserInfo${element.login}">Delete User</a><br />
</c:forEach>

<a href="MainPage">Log-Out</a>

</body>
</html>