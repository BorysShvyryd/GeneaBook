<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>
<div>
    <form method="post">
        <div>
            <hr class="major"/>
            <table>
                <h3>Do you really want to delete the user: ${deleteUser.nickname} </h3>
                <tr>
                    <td>
                        <c:out value="${deleteUser.id}"/>
                    </td>
                    <td>
                        <c:out value="${deleteUser.nickname}"/>
                    </td>
                    <td>
                        <c:out value="${deleteUser.email}"/>
                    </td>
                </tr>
            </table>
        </div>
        <div>
            <button type="submit" name="action" value="okButton">Ok</button>
            <button type="submit" name="action" value="cancelButton">Cancel</button>
        </div>
    </form>
</div>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>