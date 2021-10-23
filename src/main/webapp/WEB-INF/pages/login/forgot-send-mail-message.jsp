<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<hr class="major"/>
<div class="row gtr-200">

    <div class="col-6 col-12-medium">

        <c:if test="${sendEmail}">
            <p>
            <h4><spring:message code="registration.sendEmail.h4title"/></h4>
            </p
            <p>
            <h4><spring:message code="registration.sendEmail.h4link"/></h4>
            <a href="#">mail</a></h4>
            </p>
            <p>
            <h4><spring:message code="registration.sendEmail.h4resend"/>
                <a href="/register/resend">
                    <button>Resend</button>
                </a>
            </h4>
            </p>
        </c:if>

        <c:if test="${sendForgotPass}">
            <h4>
                <spring:message code="forgot-send-mail-message.sendForgotPass"/>
            </h4>
            <h4>
                <spring:message code="forgot-send-mail-message.sendForgotPass.link"/>
                <a href="#">mail</a>
            </h4>
            <h4>
                <spring:message code="forgot-send-mail-message.sendForgotPass.resend"/>
                <a href="/login/forgot/resend">
                    <button>
                        <spring:message code="forgot-send-mail-message.sendForgotPass.button"/>
                    </button>
                </a>
            </h4>
        </c:if>

    </div>

</div>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>