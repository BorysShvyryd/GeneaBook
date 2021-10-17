<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<div class="row gtr-200">
    <section>
        <hr class="major"/>
        <div class="row gtr-200">
            <div class="col-6 col-12-medium">
                <p>
                <h3><spring:message code="user-registration-form.h3"/></h3>
                </p>
                <p>
                <h4><spring:message code="user-registration-form.h4"/></h4>
                </p>

                <form:form method="POST" modelAttribute="user">
                    <div class="row gtr-uniform">
                        <form:hidden path="id"/>
                        <form:hidden path="dateRegisterLogin"/>
                        <form:hidden path="dateUpdateLogin"/>
                        <form:hidden path="nickname"/>
                        <form:hidden path="email"/>
                            <%--    <form:select path="userProfile"/>--%>

                        <h2>Registration</h2>
                        <div class="col-12">
                            <form:input path="nickname" disabled="true"/>
                        </div>
                        <div class="col-12">
                            <form:input path="email" disabled="true"/>
                        </div>
                        <div class="col-12">
                            <form:input type="password" path="password" placeholder="Password"/>
                            <form:errors path="password"/>
                        </div>
                        <div class="col-12">
                            <form:input type="password" path="confirmPassword"
                                        placeholder="Confirm your password"/>
                        </div>
                            <%--            <form:errors path="password"></form:errors>--%>
                            <%--                ${passwordError}--%>
                        <div class="col-12">
                            <button type="submit"><spring:message code="user-registration-form.submit"/></button>
                        </div>
                    </div>
                </form:form>

            </div>
        </div>
    </section>
</div>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>