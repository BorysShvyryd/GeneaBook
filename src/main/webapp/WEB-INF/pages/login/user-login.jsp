<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<div class="row gtr-200">
    <section>
        <hr class="major"/>
        <div class="row gtr-200">
            <div class="col-6 col-12-medium">
                <h2>Please Sign In</h2>

                <form:form modelAttribute="user" method="post">
                    <div class="row gtr-uniform">
                        <div class="col-12">
                            <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION.message}">
                                <spring:message code="login.errorLogIn"/>
                            </c:if>
                        </div>

                        <div class="col-12">
                            <label><spring:message code="login.email"/>:
                                <input type="text" name="username" placeholder="Email"/>
                            </label>
                        </div>

                        <div class="col-12">
                            <label><spring:message code="login.pas"/>:
                                <input type="password" name="password" placeholder="Password"/>
                            </label>
                        </div>

                        <div class="col-6 col-12-medium">
                            <input type="submit" value="<spring:message code="login.btn" />">
                        </div>

                        <div class="col-6 col-12-medium">
                            <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION.message}">
                                <p>
                                    Forgot password? <a href="/login/forgot">Recover password</a>
                                </p>
                            </c:if>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </div>
                </form:form>
            </div>
        </div>
    </section>
</div>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>
