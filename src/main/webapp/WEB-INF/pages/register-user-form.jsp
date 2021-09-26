<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--<fmt:setBundle basename="app" var="messageLang"/>--%>
<%--<fmt:message key="app.title" bundle="${messageLang}"/>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--<h3><spring:message code="welcome.title" /></h3>--%>
<%--<h3><spring:message code="label.mess" /></h3>--%>

<jsp:include page="../header.jsp" flush="true"/>

<form:form method="post" modelAttribute="loggedUser">
    <form:hidden path="id"/> </font>

    nicName: <form:input path="nicName"/>
    <form:errors path="nicName"/> <br>

    email: <form:input path="email"/>
    <form:errors path="email"/> <br>

    password:  <form:password path="password"/>
    <form:errors path="password"/> <br>

    confirm password <input type="password" >
    <input type="submit">
</form:form>

<jsp:include page="../footer.jsp" flush="true"/>