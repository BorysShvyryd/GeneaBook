<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="app" var="messageLang"/>
<%--<fmt:message key="app.title" bundle="${messageLang}"/>--%>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<form:form method="post" modelAttribute="userProfile">
    <form:hidden path="id"/>
    <form:hidden path="registered"/>
    <form:hidden path="updated"/>

    Firstname: <form:input path="name.firstName"/>
    <form:errors path="name.firstName"/> <br>
    Lastname: <form:input path="name.lastName"/>
    <form:errors path="name.lastName"/> <br>
    Middle name: <form:input path="name.middleName"/>
    <form:errors path="name.middleName"/> <br>

    Sex: <form:radiobuttons path="sex"/>
    <form:errors path="sex"/> <br>

    dateOfBirth: <form:input type="date" path="dateOfBirth" />
    <form:errors path="dateOfBirth"/> <br>

    placeOfBirth: <form:input path="placeOfBirth"/>
    <form:errors path="placeOfBirth"/> <br>

<%--    familyTies: <form:input path="familyTies"/> <br>--%>
<%--    <form:errors path="categoriesList"/> <br>--%>

    <input type="submit">
</form:form>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>