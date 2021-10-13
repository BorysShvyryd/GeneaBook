<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

FAMILY TREE<br>

<!-- Search -->
<%--        <section id="search" class="alt">--%>
<%--            <form method="post" action="#">--%>
<%--                <input type="text" name="query" id="query" placeholder="Search" />--%>
<%--            </form>--%>
<%--        </section>--%>

${currentUserProfile}
current family member: ${userIdRelation.name.firstName} ${userIdRelation.name.lastName}<br>

<c:forEach var="singleFamilyTies" items="${familyTies}">
    <a href="/genealogy/family/${userIdRelation.id}/add-family-member/${userIdRelation.id}/${singleFamilyTies.id}">add ${singleFamilyTies.nameFamilyTies}</a><br>
</c:forEach>

view family tree

<jsp:include page="../../fragments/footer.jsp" flush="true"/>
