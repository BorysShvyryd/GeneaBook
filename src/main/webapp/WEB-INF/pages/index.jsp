<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Главная</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>

<div>
    <h3>${pageContext.request.userPrincipal.name}</h3>
    <sec:authorize access="!isAuthenticated()">
        <h4><a href="/login">Login</a></h4>
        <h4><a href="/registration">Registration</a></h4>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <h4><a href="/geneo/profile">Profile</a></h4>
        <h4><a href="/logout">Logout</a></h4>
    </sec:authorize>
    <h4><a href="/about">About</a></h4>
    <h4><a href="/admin">Admin</a></h4>
    <h4><a href="/feedback">Feedback from our users</a></h4>

    <%--<select name="${langs}"></select>language<br>--%>

</div>
</body>
</html>


<%--<!DOCTYPE HTML>--%>
<%--<html xmlns:th="http://www.thymeleaf.org">--%>
<%--<head>--%>
<%--    <title>Spring Boot Thymeleaf + Spring Security</title>--%>

<%--    <div th:replace="fragments/header :: header-css"/>--%>

<%--</head>--%>
<%--<body>--%>

<%--<div th:replace="fragments/header :: header"/>--%>

<%--<div class="container">--%>

<%--    <div class="starter-template">--%>
<%--        <h1>Spring Boot Web Thymeleaf + Spring Security</h1>--%>
<%--        <h2>1. Посетите <a th:href="@{/admin}">страницу Admin (Защищено с помошью Spring Security, нужны права Администратора(Admin Role))</a></h2>--%>
<%--        <h2>2. Посетите <a th:href="@{/user}">страницу User (Защищено с помошью Spring Security, нужны права пользователя(User Role))</a></h2>--%>
<%--        <h2>3. Посетите <a th:href="@{/about}">Открытую страницу(доступна всем)</a></h2>--%>
<%--    </div>--%>

<%--</div>--%>
<%--<!-- /.container -->--%>

<%--<div th:replace="fragments/footer :: footer"/>--%>

<%--</body>--%>
<%--</html>--%>