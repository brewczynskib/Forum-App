<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<body>

<%--@elvariable id="forumForm" type="ForumForm"--%>
<form:form method="POST" modelAttribute="forumForm">
    <h3 >Subject</h3>
    <form:input type="text" path="subject"/><c:if test="${pageContext.request.method=='POST'}"><form:errors path="subject"/></c:if>
    <h3>Text</h3>
    <form:input type="text" path="text"/><c:if test="${pageContext.request.method=='POST'}"><form:errors path="text"/></c:if>
    <input type="submit" value="Share your topic">

</form:form>

</body>
</head>
</html>