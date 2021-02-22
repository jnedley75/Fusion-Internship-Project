<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><%@ page isELIgnored="false" %>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <meta charset="ISO-8859-1">
    <style>
        <%@include file="/css/success.css" %>
    </style>
    <jsp:include page="navBar.jsp" />
    <Title>Logged In Successfully</Title>
</head>
<body>
<div class="message">
    <h2>${login.message}</h2>
    <c:if test = "${AdminCheck.adminCheck == true}">
        <form action="http://example.com:8080/table\">
            <input class="showTable" type="submit" value="View Users"/>
        </form>
    </c:if>

</div>
    <script>
            <%--if(${AdminCheck.adminCheck} === true){--%>
            <%--    document.write("<form action=\"http://example.com:8080/table\">" +--%>
            <%--        "<input class=\"showTable\" type=\"submit\" value=\"View Users\"/>" +--%>
            <%--        "</form>");--%>
            <%--}else{--%>
            <%--    document.write("<p>Enter administrator password to become an admin</p>" +--%>
            <%--        "<form id=\"verifyForm\">\n" +--%>
            <%--        "\t<input class=\"adminVerification\" type=\"password\" id=\"verify\" name=\"adminVerification\" placeholder=\"Password\"/>\n" +--%>
            <%--        "</form>\n<button onclick=\"check()\">Verify</button>");--%>
            <%--}--%>

            <%--function check(callback){--%>
            <%--    var token = "${_csrf.token}";--%>

            <%--    $.ajaxSetup({--%>
            <%--        beforeSend: function (xhr) {--%>
            <%--            xhr.setRequestHeader('X-CSRF-TOKEN', token)--%>
            <%--        }--%>
            <%--    });--%>
            <%--    var verify = document.getElementById("verify").value;--%>
            <%--    if(verify === "IamADMIN") {--%>
            <%--        var newAdmin = true;--%>
            <%--        var loginID = ${AdminCheck.loginID};--%>
            <%--        //var send = JSON.stringify({'newAdmin':newAdmin,'loginID':loginID});--%>

            <%--        $.ajax({--%>
            <%--            type: 'POST',--%>
            <%--            url: 'update',--%>
            <%--            data: {--%>
            <%--                "adminStatus":newAdmin,--%>
            <%--                "loginID":loginID--%>
            <%--            },--%>
            <%--            success: function(data) {--%>
            <%--                alert("You are now an admin");--%>
            <%--                location.reload();--%>
            <%--            },--%>
            <%--            error: function(data) {--%>
            <%--                alert("It didn't work");--%>
            <%--            },--%>
            <%--        });--%>
            <%--    } else{--%>
            <%--        alert("Sorry, try again")--%>
            <%--        location.reload();--%>
            <%--    }--%>
            <%--}--%>

    </script>
</body>
</html>
