<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<div class="row gtr-200">
    <section>
        <hr class="major"/>
        <div class="row gtr-200">
            <div class="col-6 col-12-medium">
                <form method="post">
                    <div class="row gtr-uniform">
                        <h2>Please enter you email</h2>

                        <div class="col-12">
                            <c:if test="${errorConfirmToken}">
                                <p>
                                <h4><spring:message code="forgot-form.token.error"/></h4>
                                </p
                            </c:if>
                        </div>
                        <div class="col-12">
                            <label><spring:message code="login.email"/>:
                                <input type="text" name="email" placeholder="Email"/>
                            </label>
                        </div>
                        <div class="col-12">
                            <input type="submit" value="<spring:message code="login.btn" />">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
</div>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>
