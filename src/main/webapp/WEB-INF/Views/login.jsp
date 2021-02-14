
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><%@ page isELIgnored="false" %>
    <meta charset="ISO-8859-1">
    <title>Please log in</title>
    <style>
        <%@include file="/css/login.css" %>
    </style>
</head>
<body>
<div class ="title">
    LOGIN
</div>
<div class="centerbody">
    <form action="/login" autocomplete="off" method="post">
	<pre>
		<input type="text" id="username" name="username" placeholder="Username"/>
		<input type="password" id="password" name ="password" placeholder="Password" />
		<input type="submit" value="Submit" />
	</pre>
    </form>
</div>
</body>
</html>
