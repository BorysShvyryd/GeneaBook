<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>--%>
<%--<fmt:setBundle basename="app" var="messageLang"/>--%>
<%--<fmt:message key="app.title" bundle="${messageLang}"/>--%>

<jsp:include page="../../header.jsp" flush="true"/>

<h3>Your email address has been successfully verified.
    Continue registration.</h3>

<form:form method="post" modelAttribute="loggedUser">
    <form:hidden path="id"/>
    <form:hidden path="dateRegisterLogin"/>
    <form:hidden path="dateUpdateLogin"/>

    <%--    <form:select path="userProfile"/>--%>

    nicName: <form:input path="nicName" disabled="true"/><br>
<%--    <form:errors path="nicName"/> <br>--%>

    email: <form:input path="email" disabled="true"/><br>
<%--    <form:errors path="email"/> <br>--%>

    password: <form:password path="password"/>
    <form:errors path="password"/> <br>

    confirm password <input type="password">

    <input type="submit">

</form:form>

<jsp:include page="../../footer.jsp" flush="true"/>