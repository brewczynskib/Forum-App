<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
</head>

<body>
<c:forEach var="element" items="${user.getLogin()}"> Welcome ${element}<br /> </c:forEach>

<%--@elvariable id="forumForm" type="forumForm"--%>



<a href="MainPage">Log-Out</a><br />
<a href="ChangePassword">Change Your Password</a><br />
<a href="Forum">Forum (Make your own topic)</a><br />
<a href="WelcomeForum">WelcomeForum(See all topics)</a><br />
<br />
</body>
</html>