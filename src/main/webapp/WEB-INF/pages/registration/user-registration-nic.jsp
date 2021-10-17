<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<div class="row gtr-200">
    <section>
        <hr class="major"/>
        <div class="row gtr-200">
            <div class="col-6 col-12-medium">
                <h2>Register please</h2>

                <div class="col-12">
                    <c:if test="${nullToken}">
                        <spring:message code="registration.nullToken"/>
                    </c:if>

                    <c:if test="${errorToken}">
                        <spring:message code="registration.errorToken"/>
                    </c:if>
                </div>

                <form modelAttribute="loginUser" method="post">
                    <div class="row gtr-uniform">

                        <div class="col-12">
                            <c:if test="${notCorrectNic}">
                                <spring:message code="registration.notCorrectNic"/>
                            </c:if>
                            <c:if test="${notCorrectEmail}">
                                <spring:message code="registration.notCorrectEmail"/>
                            </c:if>
                            <c:if test="${alreadyRegistered}">
                                <spring:message code="registration.alreadyregistered"/>
                            </c:if>
                        </div>

                        <div class="col-12">
                            <label>
                                <spring:message code="registration.label.nickname"/>:
                                <input type="text" name="nickname" placeholder="Nickname"/>
                            </label>
                        </div>
                        <div class="col-12">
                            <label>
                                <spring:message code="registration.label.email"/>:
                                <input type="text" name="email" placeholder="Email"/>
                            </label>
                        </div>
                        <div class="col-6 col-12-medium">
                            <input type="submit" value="<spring:message code="login.btn" />">
                        </div>
                        <div class="col-6 col-12-medium">
                            <c:if test="${alreadyRegistered}">
                                <a href="/login"> <spring:message code="registration.loginLink"/> </a>
                            </c:if>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
</div>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>