<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${nullToken}">
    <h4>Your link is invalid. Please try to register again.</h4>
</c:if>

<c:if test="${errorToken}">
    <h4>An error occurred. Please repeat the registration.</h4>
</c:if>

<a href="/register">
    <button>Register</button>
</a>