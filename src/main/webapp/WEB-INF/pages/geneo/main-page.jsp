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

HOME PAGE <br>

<h3>${pageContext.request.userPrincipal.name}</h3>

Menu <br>

<%--<a href="/profile" >Profile</a> <br>--%>
<%--<a href="/logout" >Logout</a> <br>--%>
<%--<a href="/register" >Registration</a> <br>--%>

<sec:authorize access="isAuthenticated()">
    <h4><a href="/geneo/profile">Profile</a></h4>
    <h4><a href="/logout">Logout</a></h4>
</sec:authorize>


<%--<object data = "video.mp4" name = "videoObject"> <!--внедряем в страницу мультимедийный контент (видео)-->--%>
<%--    <param name = "autoplay" value = "1"> <!--параметр 1-->--%>
<%--    <param name = "allowFullScreen" value = "true"> <!--параметр 2-->--%>
<%--</object>--%>
<%--<object data =  "video.swf" name = "flashVideoObject" type = "application/x-shockwave-flash"> <!--добавляем флэш видео с параметром-->--%>
<%--    <param name = "loop" value = "true"> <!--параметр -->--%>
<%--</object>--%>

<%--<div class="error" th:if="${param.error[0] == 'badCredentialsException'}" th:with="errorMsg=#{login.badCredentials}">--%>
<%--    <p class="errorMsg"><span th:text="${errorMsg}"></span></p>--%>
<%--</div>--%>

<%--$ {param.containsKey ('error')}--%>

<%--<div class="error" th:if="${#httpServletRequest.getParameter('error') == 'badCredentialsException'}" th:with="errorMsg=#{login.badCredentials}">--%>
<%--    <p class="errorMsg"><span th:text="${errorMsg}"></span></p>--%>
<%--</div>--%>

</body>
</html>