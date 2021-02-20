<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
		<title>Fusion Internship</title>
		<style>
			<%@include file="/css/Home.css" %>
		</style>

	</head>
	
	<body>
		<div class="container">
			<div class="row justify-content-md-center">
				<div class="col col-lg-2"></div>
				<div class="col-md-auto">
					<h1>Fusion Internship Project</h1>
				</div>
				<div class="col col-lg-2"></div>
			</div>
			<div class="row">
				<div class="col"></div>
				<div class="col-md-auto">
					<form action="http://example.com:8080/login/database">
						<button class="regLogin">
							Login
						</button>
					</form>
				</div>
				<div class="col"></div>
			</div>
			<div class="row">
				<div class="col"></div>
				<div class="col-md-auto">
					<form action="http://example.com:8080/success/google">
						<button class = "googleLogin">
							Login with Google
							<div class="googlePng">
								<img width="20px" style="margin-top:7px; margin-right:8px" alt="Google sign-in"
									 src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/512px-Google_%22G%22_Logo.svg.png" />
							</div>
						</button>
					</form>
				</div>
				<div class="col"></div>
			</div>
		</div>
	</body>
	
</html>