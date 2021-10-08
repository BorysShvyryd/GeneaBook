<%@ page import="com.borman.geneobook.service.LocaleService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<!DOCTYPE HTML>
<html>
<head>
    <title>Main</title>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>--%>
<%--    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">--%>
</head>
<body>

<select id="lang">
    <option>Choose language</option>
    <option value="/en/">English</option>
    <option value="/ua/">Українська</option>
    <option value="/ru/">Русский</option>
    <option value="/pl/">Polski</option>
    <option value="/cz/">Czeski</option>
</select>

<%--<% LocaleService.setLo() %>--%>
<%--<script>--%>
<%--    let lang = document.getElementById('lang');--%>
<%--    let ff =Geolocation.name;--%>
<%--    lang.onchange = function () {--%>

<%--        // window.location = lang.options[lang.options.selectedIndex].value + 'index.jsp';--%>
<%--        // console.log(lang.options[lang.options.selectedIndex].value)--%>
<%--    }--%>
<%--</script>--%>

<%--<p:commandLink value="English" action="#LocaleController.setLocale()" rendered="#{localeController.ru}"/>--%>

<%--<select id="lang">--%>
<%--    <c:forEach var="lang" items="langs">--%>
<%--        <option value="/cz/">Czeski</option>--%>
<%--    </c:forEach>--%>
<%--</select>--%>

<%--<script>--%>
<%--    let lang = document.getElementById('lang');--%>
<%--    lang.onchange = function () {--%>
<%--        window.location = contex + lang.options[lang.options.selectedIndex].value + 'index.html'--%>
<%--    }--%>
<%--</script>--%>

<%--<button type="button" class="header-button header_locales-dropdown" data-toggle-ref="{&quot;ref&quot;: &quot;header_locales&quot;}">--%>
<%--&lt;%&ndash;    <img class="header_locales-flag ls-is-cached lazyloaded" data-src="https://s3l.tmimgcdn.com/locale-24-image.svg" alt="UA" src="./11_files/locale-24-image.svg">&ndash;%&gt;--%>
<%--    <img src="../../resources/img/flags/ua.svg">--%>
<%--    <span class="header_locales-label">UA</span>--%>
<%--&lt;%&ndash;    <span class="header-button-arrow header-button-arrow_locales"></span>&ndash;%&gt;--%>
<%--</button>--%>
<%--<script src="../../resources/js/flag.js" />--%>
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