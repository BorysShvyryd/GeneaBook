<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<div>
    <form:form method="post" modelAttribute="userProfileNewFamilyMember" cssClass="my_subform">

        <table>
            <tr>
                <td>
                    <select name="idSelectedUserProfile">
                        <c:forEach var="singleUserProfile" items="${allUserProfile}">
                            <option value="${singleUserProfile.id}">
                                    ${singleUserProfile.name.lastName}
                                    ${singleUserProfile.name.firstName}
                                    ${singleUserProfile.name.middleName}
                            </option>
                        </c:forEach>
                    </select>
                </td>

                <td>
                    <select name="idSelectedFamilyTies">
                        <c:forEach var="singleFamilyTies" items="${listFamilyTies}">
                            <option value="${singleFamilyTies.id}">${singleFamilyTies.nameFamilyTies}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

        </table>

        <form:hidden path="id"/>
        <form:hidden path="registered"/>
        <form:hidden path="updated"/>
        <form:hidden path="user.id"/>
        <form:hidden path="familyTies"/>

        Firstname: <form:input path="name.firstName"/>
        <form:errors path="name.firstName"/> <br>
        Lastname: <form:input path="name.lastName"/>
        <form:errors path="name.lastName"/> <br>
        Middle name: <form:input path="name.middleName"/>
        <form:errors path="name.middleName"/> <br>

        Sex: <form:radiobuttons path="sex"/>
        <form:errors path="sex"/> <br>

        dateOfBirth: <form:input type="date" path="dateOfBirth"/>
        <form:errors path="dateOfBirth"/> <br>

        placeOfBirth: <form:input path="placeOfBirth"/>
        <form:errors path="placeOfBirth"/> <br>

        <input type="submit">

    </form:form>
</div>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>