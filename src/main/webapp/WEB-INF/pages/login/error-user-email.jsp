<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<div class="row gtr-200">
    <section>
        <hr class="major"/>
        <div class="row gtr-200">
            <div class="col-6 col-12-medium">

                <h2>There is no user with this email address. Please enter a valid email.</h2>
                <div class="col-12">
                    <button onclick="document.location='/login/forgot'">
                        Return
                    </button>
                </div>
            </div>

        </div>
    </section>
</div>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>
