<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<body>

<%--@elvariable id="userForm" type="userForm"--%>
<form:form method="POST" modelAttribute="userForm">
    <form:input type="text" path="password"/>new password<c:if test="${pageContext.request.method=='POST'}"><form:errors path="password"/></c:if>
    <input type="submit" value="Change">

</form:form>

</body>
</head>
</html>