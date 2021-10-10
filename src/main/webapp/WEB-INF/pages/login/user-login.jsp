<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<div>
    <section id="login-form">
        <div>
            <form method="post">

                <h2>Please Sign In</h2>

                <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION.message}">
                    <spring:message code="login.errorLogIn"/>
                </c:if>

                <label><spring:message code="login.email"/>:
                    <input type="text" name="username" placeholder="Email"/>
                </label>

                <label><spring:message code="login.pas"/>:
                    <input type="password" name="password" placeholder="Password"/>
                </label>

                <input type="submit" value="<spring:message code="login.btn" />">

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION.message}">
                    <p>
                        Forgot password? <a href="/login/forgot">Recover password</a>
                    </p>
                </c:if>

            </form>
        </div>
    </section>
</div>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>
