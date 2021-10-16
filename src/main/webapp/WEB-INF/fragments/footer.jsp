<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

</div>
</div>

<!-- Sidebar -->
<div id="sidebar">
    <div class="inner">

        <!-- Menu -->
        <nav id="menu">
            <header class="major">
                <h2>Menu</h2>
            </header>
            <ul>
                <li><a href="/">Homepage</a></li>
                <li><a href="#">Who we are</a></li>
                <li><a href="#">For what</a></li>
                <li><a href="#">Reviews</a></li>
                <li><a href="#">Contacts</a></li>

                <sec:authorize access="!isAuthenticated()">
                    <li><a href="/registration">Registration</a></li>
                    <li><a href="/login">Login</a></li>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <li>
                        <span class="opener">My menu</span>
                        <ul>
                            <li><a href="/genealogy">Main page</a></li>
                            <li><a href="/genealogy/profile">My profile</a></li>
                            <li><a href="/genealogy/family">My family tree</a></li>
                            <li><a href="#">Setting</a></li>
                        </ul>
                    </li>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li><a href="/admin/listUsers">List of users</a></li>
                    </sec:authorize>
                    <li><a href="/logout">Sign out</a></li>
                </sec:authorize>
            </ul>
        </nav>

        <section>
            <header class="major">
                <h2>Get in touch</h2>
            </header>
            <p>Lorem ipsum in dolore. Proin sed.</p>
            <ul class="contact">
                <li class="icon solid fa-envelope"><a href="#">genealogy@gmail.com</a></li>
                <li class="icon solid fa-phone">(457) 720-8287</li>
                <li class="icon solid fa-home">43-100 Tychy Honoraty<br />
                    Nashville, TN 00000-0000</li>
            </ul>
        </section>

        <!-- Footer -->
        <footer id="footer">
            <p class="copyright">&copy; 2021 genealogy.com. All rights reserved. The final project CodersLab was made by
                <a href="https://github.com/BorysShvyryd">Boris Shvyryd</a>.</p>
        </footer>

    </div>
</div>

</div>

<!-- Scripts -->
<script src="../../resources/js/jquery.min.js"></script>
<script src="../../resources/js/browser.min.js"></script>
<script src="../../resources/js/breakpoints.min.js"></script>
<script src="../../resources/js/util.js"></script>
<script src="../../resources/js/main.js"></script>

</body>
</html>