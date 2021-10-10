<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<table>
    <tr>
        <th><h4>№</h4></th>
        <th><h4>ID</h4></th>
        <th><h4>NICKNAME</h4></th>
        <th><h4>EMAIL</h4></th>
        <th><h4>DATE REGISTER</h4></th>
        <th><h4>DATE UPDATED</h4></th>
        <th><h4>ROLE</h4></th>
        <th><h4>BLOCKED</h4></th>
        <th><h4>ACTION</h4></th>
    </tr>

    <c:forEach var="user" items="${allUsers}" varStatus="number">

        <tr>
            <td>
                <c:out value="${number.count}"/>
            </td>
            <td>
                <c:out value="${user.id}"/>
            </td>
            <td>
                <c:out value="${user.nickname}"/>
            </td>
            <td>
                <c:out value="${user.email}"/>
            </td>
            <td>
                <c:out value="${user.dateRegisterLogin}"/>
            </td>
            <td>
                <c:out value="${user.dateUpdateLogin}"/>
            </td>
            <td>
                <sec:authentication property="principal.authorities"/>
            </td>
            <td>
                <c:choose>
                    <c:when test="${user.isEnabled()}">
                        UNBLOCKED
                    </c:when>
                    <c:otherwise>
                        BLOCKED
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${user.isEnabled()}">
                        <button onclick="document.location='/admin/listUsers/blocked?id=${user.id}&value=0'">
                            Block
                        </button>
                    </c:when>
                    <c:otherwise>
                        <button onclick="document.location='/admin/listUsers/blocked?id=${user.id}&value=1'">
                            Unblock
                        </button>
                    </c:otherwise>
                </c:choose>
                <button onclick="document.location='/admin/listUsers/delete?id=${user.id}'">Delete</button>
                <button onclick="document.location='/admin/listUsers/change-admin-role?id=${user.id}'">Change ADMIN role</button>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>