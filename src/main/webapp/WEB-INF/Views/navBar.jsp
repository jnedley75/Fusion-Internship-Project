<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true"%>
<head>
    <style>
        .nav{
            height: auto;
            width: auto;
            max-height: 350px;
            max-width: 200px;
        }

        .navbar{
            background-color: #262329;
        }
    </style>
</head>
<html>
    <nav class="navbar navbar-expand-md navbar-white sticky-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="http://example.com:8080">
                <img class="nav" src="/resources/images/FusionLogo.png" alt="Fusion Logo"/>
            </a>
            <button class="navbar-toggler" type="button" data-toggler="collapse" data-target="#navbarResponsive">
                <span class="navbar-toggler"></span>
            </button>
            <div class="collapse navbar-collapse" id="#navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <c:if test = "${sessionScope.loggedStatus == true}">
                        <a:if test="${sessionScope.adminStatus == true}">
                            <li class="nav-item active">
                                <a class="nav-link" href="http://example.com:8080/table\">View Users</a>
                            </li>
                        </a:if>
                        <li class="nav-item">
                            <a class="nav-link" href="http://example.com:8080/logout">Logout</a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
</html>
