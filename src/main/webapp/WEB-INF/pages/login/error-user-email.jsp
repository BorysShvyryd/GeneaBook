<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<div>
    <section id="login-form">
        <div class="body">

            <h2>There is no user with this email address. Please enter a valid email.</h2>
            <button onclick="document.location='/login/forgot'">
                Return
            </button>

        </div>
    </section>
</div>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>
