<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title><spring:message code="login.title"/></title>
    <%--    Log in with your account--%>
</head>

<body>
<%--<sec:authorize access="isAuthenticated()">--%>
<%--    <% response.sendRedirect("/"); %>--%>
<%--</sec:authorize>--%>

<sec:authorize access="isAuthenticated()">
    <p>Zalogowany jako: <sec:authentication property="username"/></p>
    <p>Posiada role: <sec:authentication property="authorities"/></p>
</sec:authorize>
<div>
    <div style="margin-top:20px">

        <form method="post">
<%--        <form modelAttribute="user" method="post">--%>

            <h1>Please Sign In</h1>

            <%--            <c:if test="${errorLogIn}">--%>
            <%--                <spring:message code="login.errorLogIn"/>--%>
            <%--            </c:if>--%>
            <%--            <c:if test="${param.logout}">--%>
            <%--                <spring:message code="login.logout"/>--%>
            <%--            </c:if>--%>
            <%--            <c:if test="${param.auth eq 'failure'}">--%>
            <%--&lt;%&ndash;                <div class="error">&ndash;%&gt;--%>
            <%--                <spring:message code="login.errorLogIn"/>--%>
            <%--&lt;%&ndash;                    <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />&ndash;%&gt;--%>
            <%--&lt;%&ndash;                </div>&ndash;%&gt;--%>
            <%--            </c:if>--%>
            <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION.message}">
                <spring:message code="login.errorLogIn"/>
            </c:if>
    ${param.error}
            <p>
                <label><spring:message code="login.email"/>:
                    <input type="text" name="username" placeholder="Email"/>
                </label>
            </p>
            <p>
                <label><spring:message code="login.pas"/>:
                    <input type="password" name="password" placeholder="Password"/>
                </label>
            </p>

            <input type="submit" value="<spring:message code="login.btn" />">

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION.message}">
                Forgot password? <a href="/login/forgot">Send new password</a>
            </c:if>

        </form>
    </div>
</div>


</body>
</html>
