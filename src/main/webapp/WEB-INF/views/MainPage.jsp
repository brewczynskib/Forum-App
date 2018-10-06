<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML>

<html>

<head>
    <spring:url value="/resources/css/Mainpage.css" var="Mainpage"/>
    <link href="${Mainpage}" rel="stylesheet"/>
<%--<spring:url value="/resources/js/try.js" var="try"/>--%>
    <%--<script src="${try}"></script>--%>

</head>

<div class="core">
    <body>
    <h1>
        <b>
            Welcome User
        </b>
    </h1>
    <p><b>Sign-in</b> or <b>Sign-up</b></p>
    <a href="Login">Sign-in</a>
    <a href="Register">Sign-up</a>

    </body>
</div>
</html>