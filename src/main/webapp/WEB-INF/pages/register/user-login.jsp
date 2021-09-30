<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="login.title" /></title>
</head>
<body>

<form modelAttribute="loginUser" method="post">
    <%--    <form:errors />--%>
    <p>
        <label><spring:message code="login.nicName" />:<br>
            <input type="text" name="nicName" />
            <%--            <errors path="nicName"/>--%>
        </label>
    </p>
    <p>
        <label><spring:message code="login.email" />:<br>
            <input type="text" name="email" />
            <%--            <errors path="email"/>--%>
        </label>
    </p>

    <input type="submit" value="<spring:message code="login.btn" />">
</form>
</body>
</html>