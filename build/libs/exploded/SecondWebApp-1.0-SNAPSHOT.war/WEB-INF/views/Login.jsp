<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<body>

<%--@elvariable id="userForm" type="UserForm"--%>
<form:form method="POST" modelAttribute="userForm">
    <h1><b>Sign-In</b></h1>
    Login
    <form:input type="text" path="login"/><c:if test="${pageContext.request.method=='POST'}"><form:errors path="login"/></c:if>
    Password
    <form:input type="password" path="password"/><c:if test="${pageContext.request.method=='POST'}"><form:errors path="password"/></c:if>
    <input type="submit" value="SIGN-IN">

</form:form>

</body>
</head>
</html>