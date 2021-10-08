<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<%--    <title><spring:message code="login.title" /></title>--%>

<div class="content">
    <section id="login-form">
        <div style="max-width: 300px; position: center">
            <c:if test="${nullToken}">
                <spring:message code="registration.nullToken"/>
            </c:if>

            <c:if test="${errorToken}">
                <spring:message code="registration.errorToken"/>
            </c:if>

            <form modelAttribute="loginUser" method="post">
                <h2>Register please</h2>

                <c:if test="${notCorrectNic}">
                    <spring:message code="registration.notCorrectNic"/>
                </c:if>

                <c:if test="${notCorrectEmail}">
                    <spring:message code="registration.notCorrectEmail"/>
                </c:if>

                <c:if test="${alreadyRegistered}">
                    <spring:message code="registration.alreadyregistered"/>
                </c:if>

                <label>
                    <spring:message code="registration.label.nickname"/>:
                    <input type="text" name="nickname" placeholder="Nickname"/>
                </label>
                <label>
                    <spring:message code="registration.label.email"/>:
                    <input type="text" name="email" placeholder="Email"/>
                </label>

                <input type="submit" value="<spring:message code="login.btn" />">
                <c:if test="${alreadyRegistered}">
                    <a href="/login"> <spring:message code="registration.loginLink"/> </a>
                </c:if>
            </form>
        </div>
    </section>
</div>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>