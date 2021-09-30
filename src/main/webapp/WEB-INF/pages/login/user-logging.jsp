<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="login.title" /></title>
</head>
<body>

<form modelAttribute="loginUser" method="post">
    <p>
        <label><spring:message code="login.nicName" />:<br>
            <input type="text" name="nicName" />
        </label>
    </p>
    <p>
        <label><spring:message code="login.pas" />:<br>
            <input type="password" name="password" />
        </label>
    </p>

    <input type="submit" value="<spring:message code="login.btn" />">
</form>

Forgot password? <a href="/login/forgot">Send new password</a>

</body>
</html>