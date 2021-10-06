<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

FAMILY TREE

<a href="/genealogy/family/member" >Add a family member</a><br>

<c:forEach var="relationShip" items="${relationShips}">
    <a href="/genealogy/family/member-${relationShip}">add ${relationShip}</a><br>
</c:forEach>

wiev family tree

<jsp:include page="../../fragments/footer.jsp" flush="true"/>
