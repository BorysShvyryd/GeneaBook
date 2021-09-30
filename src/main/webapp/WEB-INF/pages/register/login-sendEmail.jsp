<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sendEmail}">
    <h4>A confirmation email has been sent to your email address.</h4> <br>

    <h4>Please follow the instructions. <a href="#">mail</a></h4> <br>

    <h4>Didn't receive the email? <a href="/register/resend">
        <button>Resend</button>
    </a></h4>
    <br>
</c:if>

<c:if test="${sendForgotPass}">
    <h4>An error occurred. Please repeat the registration.</h4>
</c:if>