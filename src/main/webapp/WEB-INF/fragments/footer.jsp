<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

</div>
</div>

<!-- Sidebar -->
<div id="sidebar">
    <div class="inner">

        <!-- Search -->
<%--        <section id="search" class="alt">--%>
<%--            <form method="post" action="#">--%>
<%--                <input type="text" name="query" id="query" placeholder="Search" />--%>
<%--            </form>--%>
<%--        </section>--%>

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
                    <li><a href="/registration">Regisrtration</a></li>
                    <li><a href="/login">Login</a></li>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <li><a href="/genealogy/family">My family tree</a></li>
                    <li><a href="/genealogy/profile">My profile</a></li>
                    <li><a href="/logout">Sign out</a></li>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li><a href="/admin/listUsers">List of users</a></li>
                    </sec:authorize>
                </sec:authorize>
            </ul>
        </nav>

        <!-- Section -->
<%--        <section>--%>
<%--            <header class="major">--%>
<%--                <h2>Who we are</h2>--%>
<%--            </header>--%>
<%--            <div class="mini-posts">--%>
<%--                <article>--%>
<%--                    <a href="#" class="image"><img src="../../resources/img/pic07.jpg" alt="" /></a>--%>
<%--                    <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>--%>
<%--                </article>--%>
<%--                <article>--%>
<%--                    <a href="#" class="image"><img src="../../resources/img/pic08.jpg" alt="" /></a>--%>
<%--                    <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>--%>
<%--                </article>--%>
<%--                <article>--%>
<%--                    <a href="#" class="image"><img src="../../resources/img/pic09.jpg" alt="" /></a>--%>
<%--                    <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>--%>
<%--                </article>--%>
<%--            </div>--%>
<%--            <ul class="actions">--%>
<%--                <li><a href="#" class="button">More</a></li>--%>
<%--            </ul>--%>
<%--        </section>--%>

        <!-- Section -->
<%--        <section>--%>
<%--            <header class="major">--%>
<%--                <h2>Get in touch</h2>--%>
<%--            </header>--%>
<%--            <p>Sed varius enim lorem ullamcorper dolore aliquam aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin sed aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>--%>
<%--            <ul class="contact">--%>
<%--                <li class="icon solid fa-envelope"><a href="#">information@untitled.tld</a></li>--%>
<%--                <li class="icon solid fa-phone">(000) 000-0000</li>--%>
<%--                <li class="icon solid fa-home">1234 Somewhere Road #8254<br />--%>
<%--                    Nashville, TN 00000-0000</li>--%>
<%--            </ul>--%>
<%--        </section>--%>

        <!-- Footer -->
        <footer id="footer">
            <p class="copyright">&copy; 2021 genealogy.com. All rights reserved. The final project CodersLab was made by <a href="https://github.com/BorysShvyryd">Boris Shvyryd</a>.</p>
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