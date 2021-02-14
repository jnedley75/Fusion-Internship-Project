<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	
	<head>
		<title>Fusion Internship</title>
		<style>
			<%@include file="/css/Home.css" %>
		</style>

	</head>
	
	<body>
		<h1> Fusion Internship Project</h1>
		<form action="http://example.com:8080/login/database">
			<input class="regLogin" type="submit" value="Login"/>
		</form>
		<form action="http://example.com:8080/success/google">
			<button class = "googleLogin">
					Login with Google
					<div class="googlePng">
						<img width="20px" style="margin-top:7px; margin-right:8px" alt="Google sign-in"
							 src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/512px-Google_%22G%22_Logo.svg.png" />
					</div>
			</button>
		</form>
	</body>
	
</html>