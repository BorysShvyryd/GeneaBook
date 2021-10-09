<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<fmt:setBundle basename="app" var="messageLang"/>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<form:form method="post" modelAttribute="userProfile">
    <form:hidden path="id"/>
    <form:hidden path="registered"/>
    <form:hidden path="updated"/>
    <form:hidden path="user.id"/>

    <label>Firstname:
    <form:input path="name.firstName"/>
    <form:errors path="name.firstName"/></label>
    <label>Lastname:
    <form:input path="name.lastName"/>
    <form:errors path="name.lastName"/></label>
    <label>Middle name:
    <form:input path="name.middleName"/>
    <form:errors path="name.middleName"/></label>
    <label>Sex:
    <form:radiobuttons path="sex"/>
    <form:errors path="sex"/></label>
    <label>
    Date of birth:<form:input type="date" path="dateOfBirth"/>
    <form:errors path="dateOfBirth"/></label>
    <label>
    Place of birth: <form:input path="placeOfBirth"/>
    <form:errors path="placeOfBirth"/></label>

    <%--    familyTies: <form:input path="familyTies"/> <br>--%>
    <%--    <form:errors path="categoriesList"/> <br>--%>

    <input type="submit">
</form:form>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>