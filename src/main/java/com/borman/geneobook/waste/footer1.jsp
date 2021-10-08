<%--<!-- Footer -->--%>
<%--<footer id="footer">--%>
<%--    <p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a href="#">Shvyryd</a>. Design: <a href="#">HTML5 UP</a>.</p>--%>
<%--</footer>--%>

<%--</div>--%>
<%--</div>--%>

<%--</div>--%>

<%--<!-- Scripts -->--%>
<%--<script src="../../resources/js/jquery.min.js"></script>--%>
<%--<script src="../../resources/js/browser.min.js"></script>--%>
<%--<script src="../../resources/js/breakpoints.min.js"></script>--%>
<%--<script src="../../resources/js/util.js"></script>--%>
<%--<script src="../../resources/js/main.js"></script>--%>

<%--</body>--%>
<%--</html>--%>

<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
<head>
</head>
<body>
<div th:fragment="footer">
    <div class="container">
        <footer>
            © 2021 genealogy.com
            <span sec:authorize="isAuthenticated()">| Logged user: <span sec:authentication="name"></span> |
                Roles: <span sec:authentication="principal.authorities"></span> |
                <a th:href="@{/logout}">Sign Out</a>
            </span>
            <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        </footer>
    </div>

</div>
</body>
</html>