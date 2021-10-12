<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<section>
    <div class="body">
        <h2><spring:message code="genealogy.no-profile-data.h2"/></h2>

        <h3><spring:message code="genealogy.no-profile-data.h3.1"/></h3>

        <h3><spring:message code="genealogy.no-profile-data.h3.2"/></h3>

        <button onclick="document.location='javascript:history.go(-1)'">
            <spring:message code="genealogy.no-profile-data.btn-return"/>
        </button>

        <button onclick="document.location='/genealogy/profile'">
            <spring:message code="genealogy.no-profile-data.btn-enter"/>
        </button>

    </div>
</section>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>