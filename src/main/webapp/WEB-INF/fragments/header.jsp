<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE HTML>

<html>
<head>
    <title>Family tree</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
    <link rel="stylesheet" href="../../resources/css/main.css"/>
</head>
<body class="is-preload">

<!-- Wrapper -->
<div id="wrapper">

    <!-- Main -->
    <div id="main">
        <div class="inner">

            <!-- Header -->
            <header id="header">
                <a href="#" class="logo"><strong>Family tree</strong> project</a>

                <ul class="icons">

                    <sec:authorize access="!isAuthenticated()">
                        <li><a href="/login"><span class="logo">Log in</span></a></li>
                        <li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
                        <li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
                        <li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
                    </sec:authorize>

                    <sec:authorize access="isAuthenticated()">
                        <li><a href="/genealogy/profile"><span class="logo">${pageContext.request.userPrincipal.name}</span></a></li>
                        <li><a href="/logout"><span class="logo">Sign out</span></a></li>
                    </sec:authorize>

                </ul>
            </header>