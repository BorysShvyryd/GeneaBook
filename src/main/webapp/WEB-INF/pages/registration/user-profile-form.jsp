<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<form:form method="post" modelAttribute="userProfile">
    <form:hidden path="id"/>
    <form:hidden path="registered"/>
    <form:hidden path="updated"/>
    <form:hidden path="user.id"/>

    <label>Firstname:
        <form:input path="name.firstName" disabled="${readOnly}"/>
        <form:errors path="name.firstName"/>
    </label>
    <label>Lastname:
        <form:input path="name.lastName" disabled="${readOnly}"/>
        <form:errors path="name.lastName"/>
    </label>
    <label>Middle name:
        <form:input path="name.middleName" disabled="${readOnly}"/>
        <form:errors path="name.middleName"/>
    </label>
    <label>Sex:
        <form:radiobuttons path="sex" disabled="${readOnly}"/>
        <form:errors path="sex"/>
    </label>
    <label>Date of birth:
        <form:input type="date" path="dateOfBirth" disabled="${readOnly}"/>
        <form:errors path="dateOfBirth"/>
    </label>
    <label>Place of birth:
        <form:input path="placeOfBirth" disabled="${readOnly}"/>
        <form:errors path="placeOfBirth"/>
    </label>

    <c:choose>
        <c:when test="${readOnly}">
            <input type="submit" value="Return">
        </c:when>
        <c:otherwise>
            <input type="submit">
        </c:otherwise>
    </c:choose>
</form:form>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>