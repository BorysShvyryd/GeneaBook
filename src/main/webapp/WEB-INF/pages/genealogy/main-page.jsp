<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

MAIN PAGE
<%--<div id="sidebar">--%>
<%--    <div class="inner">--%>
<%--        <!-- Search -->--%>
<%--        <section id="search" class="alt">--%>
<%--            <form method="post" action="#">--%>
<%--                <input type="text" name="query" id="query" placeholder="Search"/>--%>
<%--            </form>--%>
<%--        </section>--%>
<%--    </div>--%>
<%--</div>--%>

<%--Menu <br>--%>

<%--<a href="/profile" >Profile</a> <br>--%>
<%--<a href="/logout" >Logout</a> <br>--%>
<%--<a href="/register" >Registration</a> <br>--%>

<%--<sec:authorize access="isAuthenticated()">--%>
<%--    <h4><a href="/genealogy/profile">Profile</a></h4>--%>
<%--    <h4><a href="/genealogy/family">My family tree</a></h4>--%>
<%--</sec:authorize>--%>


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

<jsp:include page="../../fragments/footer.jsp" flush="true"/>