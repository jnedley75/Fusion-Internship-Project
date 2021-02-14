<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><%@ page isELIgnored="false" %>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <meta charset="ISO-8859-1">
    <style>
        <%@include file="/css/success.css" %>
    </style>
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
