<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    <title>Registration</title>
    <style>
        <%@include file="/css/register.css" %>
    </style>
</head>
<body>
    <jsp:include page="navBar.jsp" />

<div class="container-fluid">
    <div class="row text-center">
        <div class="col-12">
            <h1>REGISTRATION</h1>
        </div>
    </div>
    <div class="row text-center">
        <div class="col-12">
            <form action="/register" class="text-center" autocomplete="off" method="post">
                <input type="text" id="email" name="email" placeholder="Email"/>
                <div class="row text-center justify-content-center">
                    <input type="text" id="username" name="username" placeholder="Username"/>
                </div>
                <div class="row text-center justify-content-center">
                    <input type="text" id="password" name="password" placeholder="Password"/>
                </div>
                <div class="row text-center justify-content-center">
                    <input type="text" id="age" name="age" placeholder="Age"/>
                </div>
                <div class="row text-center justify-content-center">
                    <input type="text" id="gender" name="gender" placeholder="Gender"/>
                </div>
                <input class="register btn btn-primary btn-lg" type="submit" value="Register" />
            </form>
        </div>
    </div>
</div>

</body>
</html>
