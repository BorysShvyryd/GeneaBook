<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>--%>
<%--<fmt:setBundle basename="app" var="messageLang"/>--%>
<%--<fmt:message key="app.title" bundle="${messageLang}"/>--%>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Registration</title>
</head>

<body>

<div>
<h3>Your email address has been successfully verified.
    Continue registration.</h3>
</div>

<div>
    <form:form method="POST" modelAttribute="user">
            <form:hidden path="id"/>
            <form:hidden path="dateRegisterLogin"/>
            <form:hidden path="dateUpdateLogin"/>
            <form:hidden path="nicName"/>
            <form:hidden path="email"/>
<%--            <form:hidden path="roleSet.id"/>--%>
        <%--    &lt;%&ndash;    <form:select path="userProfile"/>&ndash;%&gt;--%>

        <h2>Registration</h2>
        <div>
            <form:input path="nicName" disabled="true"/>
        </div>
        <div>
            <form:input path="email" disabled="true"/>
        </div>
        <div>
            <form:input type="password" path="password" placeholder="Password"/>
            <form:errors path="password"/>
        </div>
        <div>
            <form:input type="password" path="confirmPassword"
                        placeholder="Confirm your password"/>
<%--            <form:errors path="password"></form:errors>--%>
<%--                ${passwordError}--%>
        </div>
        <button type="submit">Registration</button>
    </form:form>
    <a href="/">Home</a>
</div>
</body>
</html>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>