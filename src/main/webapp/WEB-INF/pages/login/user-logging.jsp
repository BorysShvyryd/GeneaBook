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
<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("/"); %>
</sec:authorize>
<div>
    <div style="margin-top:20px">

        <form modelAttribute="loginUser" method="post">

            <h1>Please Sign In</h1>

            <c:if test="${errorLogIn}">
                <spring:message code="login.errorLogIn"/>
            </c:if>
            <c:if test="${param.logout}">
                <spring:message code="login.logout"/>
            </c:if>

            <p>
                <label><spring:message code="login.email"/>:
                    <input type="text" name="email" placeholder="nicName"/>
                </label>
            </p>
            <p>
                <label><spring:message code="login.pas"/>:
                    <input type="password" name="password" placeholder="Password"/>
                </label>
            </p>

            <input type="submit" value="<spring:message code="login.btn" />">

            <div>
                Forgot password? <a href="/login/forgot">Send new password</a>
            </div>

        </form>
    </div>
</div>


</body>
</html>
