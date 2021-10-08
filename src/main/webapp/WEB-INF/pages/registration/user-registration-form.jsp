<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<div>
    <section>
        <p>
            <h3><spring:message code="user-registration-form.h3"/></h3>
        </p>
        <p>
            <h4><spring:message code="user-registration-form.h4"/></h4>
        </p>
    </section>

    <div>
        <form:form method="POST" modelAttribute="user">
            <form:hidden path="id"/>
            <form:hidden path="dateRegisterLogin"/>
            <form:hidden path="dateUpdateLogin"/>
            <form:hidden path="nickname"/>
            <form:hidden path="email"/>
            <%--    &lt;%&ndash;    <form:select path="userProfile"/>&ndash;%&gt;--%>

            <h2>Registration</h2>
            <div>
                <form:input path="nickname" disabled="true"/>
            </div>
            <div>
                <form:input path="email" disabled="true"/>
            </div>
            <div>
                <form:input type="password" path="password" placeholder="Password"/>
                <form:errors path="password"/>
            </div>
            <div>
                <form:input type="password" path="confirmPassword"
                            placeholder="Confirm your password"/>
                    <%--            <form:errors path="password"></form:errors>--%>
                    <%--                ${passwordError}--%>
            </div>
            <button type="submit"><spring:message code="user-registration-form.submit"/></button>
        </form:form>

    </div>
</div>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>