<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <spring:url value="/resources/css/ForumFile.css" var="ForumFile"/>
    <link href="${ForumFile}" rel="stylesheet"/>

</head>
<div class="core">
<h1>
    <div class="forum">Forum</div>
</h1>
<body>
<c:forEach var="element2" items="${forum}">
<div class = "user"><b>${element2.user}</b></div>
    <div class = "subject">${element2.subject}</div>
    <div class = "text">${element2.text}</div>
    <br/>
    <br/>
</c:forEach>
</div>
<div class = "footer">
<a href="Welcome">Back to Welcome Page</a>
<a href="MainPage">Log-Out</a>
</div>
</body>
</html>