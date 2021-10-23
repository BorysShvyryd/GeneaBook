<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="../fragments/header.jsp" flush="true"/>

<div class="row gtr-200">
    <section>
        <hr class="major"/>
<%--        <div class="row gtr-200">--%>
<%--            <div class="col-6 col-12-medium">--%>
                <c:if test="${errorToken}">
                    <h3><spring:message code="login-error-registration.errorToken"/></h3>
                </c:if>
                <c:if test="${nullToken}">
                    <h3><spring:message code="login-error-registration.nullToken"/></h3>
                </c:if>
                <c:if test="${nonCorrectToken}">
                    <h3><spring:message code="login-error-registration.nonCorrectToken"/></h3>
                </c:if>
                <c:if test="${errorUserEmail}">
                    <h2><spring:message code="error.errorUserEmail.errorUserEmail"/></h2>
                    <div class="col-12">
                        <button onclick="document.location='/login/forgot'">
                            <spring:message code="error.errorUserEmail.button"/>
                        </button>
                    </div>
                </c:if>
<%--            </div>--%>
<%--        </div>--%>
    </section>
</div>

<jsp:include page="../fragments/footer.jsp" flush="true"/>