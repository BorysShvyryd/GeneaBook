<%@ page import="java.util.Base64" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<div class="row gtr-200">
    <section>
        <div class="row gtr-200">
            <div class="col-6 col-12-medium">
                <c:choose>
                    <c:when test="${empty userProfile.idMainPhoto}">
                        <p>
                            <span class="image left">
                                <c:choose>
                                    <c:when test="${userProfile.sex == 'MALE'}">
                                        <img src="../../../resources/img/anonymous/man.png">
                                    </c:when>
                                    <c:otherwise>
                                        <img src="../../../resources/img/anonymous/woman.png">
                                    </c:otherwise>
                                </c:choose>
                            </span>
                        </p>
                    </c:when>
                    <c:otherwise>
                        <p>
                            <span class="image left">
                                <c:forEach var="imgimg" items="${userProfile.userPhotoList}">

                                    <img src="../../../resources/img/saved.png" alt="Main images">

<%--                                    <img src="data:image/gif;base64,<%= imgDataBase64 %>" alt="images Here"/>--%>
                                </c:forEach>
                            </span>
<%--                                ${userProfile.userPhotoList.get(userProfile.idMainPhoto).description}--%>
                        </p>

                        <div class="box alt">
                            <div class="row gtr-50 gtr-uniform">
                                <c:forEach var="photo" items="${userProfile.userPhotoList}">
                                    <div class="col-4"><span class="image fit"><img src="#" alt=""/></span></div>
                                </c:forEach>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>

            </div>
            <div class="col-6 col-12-medium">
                <c:choose>
                    <c:when test="${readOnly}">
                        <h2>View profile</h2>
                    </c:when>
                    <c:otherwise>
                        <h2>Edit profile</h2>
                    </c:otherwise>
                </c:choose>

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
                            <c:if test="${not readOnly || (not empty userProfile.dateOfDeath)}">
                                <label>Date of death:
                                    <form:input type="date" path="dateOfDeath" disabled="${readOnly}"/>
                                    <form:errors path="dateOfDeath"/>
                                </label>
                            </c:if>
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
                                    <c:if test="${readOnly}">
                                        <a href="/genealogy/family/edit-profile?id=${userProfile.id}">
                                            Edit
                                        </a>
                                        <%--                                        <button onclick="document.location('/genealogy/family/edit-profile?id=${userProfile.id}')">--%>
                                        <%--                                            Edit--%>
                                        <%--                                        </button>--%>
                                    </c:if>
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