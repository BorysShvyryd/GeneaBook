<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<form:form method="post" modelAttribute="geneoUser">
    <form:hidden path="id"/>

    Firstname: <form:input path="firstName"/> <br>
<%--    <form:errors path="title"/> <br>--%>

    Lastname: <form:input path="lastName"/> <br>
<%--    <form:errors path="content"/> <br>--%>

    Sex: <form:radiobuttons path="sex" /> <br>
    <%--    <form:errors path="title"/> <br>--%>

    dateOfBirth: <form:input type="date" path="dateOfBirth" /> <br>
<%--    <form:errors path="categoriesList"/> <br>--%>

    dateOfBirth: <form:input type="date" path="dateOfBirth"/> <br>
<%--    <form:errors path="categoriesList"/> <br>--%>

    placeOfBirth: <form:input path="placeOfBirth"/> <br>
<%--    <form:errors path="categoriesList"/> <br>--%>

    <form:hidden path="loginUser"/> <br>
    <form:hidden path="registered"/> <br>
    <form:hidden path="updated"/> <br>

<%--    familyTies: <form:input path="familyTies"/> <br>--%>
<%--    <form:errors path="categoriesList"/> <br>--%>

    <input type="submit" name="Dodaj">
</form:form>