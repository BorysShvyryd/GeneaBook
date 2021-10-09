<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

FAMILY TREE

<a href="/genealogy/family/member" >Add a family member</a><br>

<c:forEach var="singleFamilyTies" items="${familyTies}">
    <a href="/genealogy/family/member/${userIdRelation.id}/${singleFamilyTies.id}">add ${singleFamilyTies.nameFamilyTies}</a><br>
</c:forEach>

wiev family tree

<jsp:include page="../../fragments/footer.jsp" flush="true"/>
