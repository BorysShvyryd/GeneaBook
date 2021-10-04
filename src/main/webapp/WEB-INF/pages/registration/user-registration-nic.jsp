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

<c:if test="${nullToken}">
    <spring:message code="registration.nullToken" />
</c:if>

<c:if test="${errorToken}">
    <spring:message code="registration.errorToken" />
</c:if>

<form modelAttribute="loginUser" method="post">
    <h1>Register please</h1>

    <c:if test="${notCorrectNic}">
        <spring:message code="registration.notCorrectNic" />
    </c:if>

    <c:if test="${notCorrectEmail}">
        <spring:message code="registration.notCorrectEmail" />
    </c:if>

    <c:if test="${alreadyRegistered}">
        <spring:message code="registration.alreadyregistered" />
    </c:if>

    <p>
            <input type="text" name="nicName" placeholder="Nic name"/>
    </p>
    <p>
            <input type="text" name="email" placeholder="Email"/>
    </p>

    <input type="submit" value="<spring:message code="login.btn" />">
    <c:if test="${alreadyRegistered}">
        <a href="/login"> <spring:message code="registration.loginLink" /> </a>
    </c:if>
</form>

</body>
</html>