<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Invalid</title>
    <style>
        <%@include file="/css/invalid.css" %>
    </style>
</head>
<body>
<div class="title">Invalid username and/or password</div>
<form action="/">
    <input type="submit" value="Try again"
           onclick="window.location='WEB-INF/views/login.jsp';" />
</form>
</body>
</html>
