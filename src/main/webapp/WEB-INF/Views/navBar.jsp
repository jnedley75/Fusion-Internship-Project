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
            background-color: #202225;
        }

        .navbar {
            box-shadow: 0 2px 4px -1px rgba(0,0,0,0.25);
            /*box-shadow: 0 2px 2px -2px rgba(0,0,0,.2);*/
        }

        .dropdown-menu{
            background-color: #2b2b2b;
        }

        .googleLogo{
            height: auto;
            width: auto;
            max-height: 90px;
            max-width: 25px;
            margin-bottom: 2px;
            margin-right: 3px;
            margin-left: 3px;
            padding: 0;
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
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <c:choose>
                                <c:when test="${sessionScope.loggedStatus == true}">
                                    ${sessionScope.username}
                                </c:when>
                                <c:otherwise>
                                    Account
                                </c:otherwise>
                            </c:choose>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                            <c:if test = "${sessionScope.loggedStatus == true}">
                                <a:if test="${sessionScope.adminStatus == true}">
                                    <a class="dropdown-item" href="http://example.com:8080/table\">View Users</a>
                                </a:if>
                                <div class="dropdown-divider"></div>
                            </c:if>
                            <c:choose>
                                <c:when test = "${sessionScope.loggedStatus == true}">
                                    <a class="dropdown-item" href="http://example.com:8080/logout\">Sign Out</a>
                                </c:when>
                                <c:otherwise>
                                    <a class="dropdown-item" href="http://example.com:8080/login/database">Login</a>
                                    <a class="dropdown-item" href="http://example.com:8080/success/google">Login with Google<img class="googleLogo" src="/resources/images/googleLogo.png"></a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</html>
