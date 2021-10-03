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

<%--<c:if test="${nullToken}">--%>
<%--    <<spring:message code="registration.nullToken" />--%>
<%--</c:if>--%>

<%--<c:if test="${errorToken}">--%>
<%--    <<spring:message code="registration.errorToken" />--%>
<%--</c:if>--%>

<form modelAttribute="loginUser" method="post">

    <c:if test="${notCorrectNic}">
        <<spring:message code="registration.notCorrectNic" />
    </c:if>

    <c:if test="${notCorrectEmail}">
        <<spring:message code="registration.notCorrectEmail" />
    </c:if>

    <c:if test="${alreadyRegistered}">
        <<spring:message code="registration.alreadyregistered" />
    </c:if>

    <p>
        <label><spring:message code="registration.nicName" />:<br>
            <input type="text" name="nicName" />
            <%--            <errors path="nicName"/>--%>
        </label>
    </p>
    <p>
        <label><spring:message code="registration.email" />:<br>
            <input type="text" name="email" />
            <%--            <errors path="email"/>--%>
        </label>
    </p>

    <input type="submit" value="<spring:message code="login.btn" />">
</form>

</body>
</html>