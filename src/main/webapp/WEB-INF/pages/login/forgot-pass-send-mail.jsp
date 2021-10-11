<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<div>
    <section id="forgot-form">
        <div>
            <form method="post">

                <h2>Please enter you email</h2>

<%--                <c:set var="${attributeVal}" value="validate"/>--%>

                <c:if test="${errorConfirmToken}">
                    <p>
                    <h4><spring:message code="forgot-form.token.error"/></h4>
                    </p
                </c:if>

                <label><spring:message code="login.email"/>:
                    <input type="text" name="email" placeholder="Email"/>
                </label>

                <input type="submit" value="<spring:message code="login.btn" />">

            </form>
        </div>
    </section>
</div>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>
