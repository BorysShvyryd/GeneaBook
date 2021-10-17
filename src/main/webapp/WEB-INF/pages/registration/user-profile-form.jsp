<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<div class="row gtr-200">
    <section>
        <hr class="major"/>
        <div class="row gtr-200">
            <div class="col-6 col-12-medium">
                <form:form method="post" modelAttribute="userProfile">
                    <div class="row gtr-uniform">
                        <div class="col-12">
                            <form:hidden path="id"/>
                            <form:hidden path="registered"/>
                            <form:hidden path="updated"/>
                            <form:hidden path="user.id"/>
                        </div>
                        <div class="col-12">
                            <label>Firstname:
                                <form:input path="name.firstName" disabled="${readOnly}"/>
                                <form:errors path="name.firstName"/>
                            </label>
                        </div>
                        <div class="col-12">
                            <label>Lastname:
                                <form:input path="name.lastName" disabled="${readOnly}"/>
                                <form:errors path="name.lastName"/>
                            </label>
                        </div>
                        <div class="col-12">
                            <label>Middle name:
                                <form:input path="name.middleName" disabled="${readOnly}"/>
                                <form:errors path="name.middleName"/>
                            </label>
                        </div>
                        <div class="col-12">
                            <label>Sex:
                                <form:radiobuttons path="sex" disabled="${readOnly}"/>
                                <form:errors path="sex"/>
                            </label>
                        </div>
                        <div class="col-12">
                            <label>Date of birth:
                                <form:input type="date" path="dateOfBirth" disabled="${readOnly}"/>
                                <form:errors path="dateOfBirth"/>
                            </label>
                        </div>
                        <div class="col-12">
                            <label>Place of birth:
                                <form:input path="placeOfBirth" disabled="${readOnly}"/>
                                <form:errors path="placeOfBirth"/>
                            </label>
                        </div>
                        <div class="col-12">
                            <c:choose>
                                <c:when test="${readOnly}">
                                    <input type="submit" value="Return">
                                </c:when>
                                <c:otherwise>
                                    <input type="submit">
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </section>
</div>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>