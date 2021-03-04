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
		<jsp:include page="navBar.jsp" />
			<div class="container-fluid-slides">
				<div class="row">
					<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
						<div class="carousel slide" id="carousel-404808">
							<ol class="carousel-indicators">
								<li data-slide-to="0" data-target="#carousel-404808" class="active">
								</li>
								<li data-slide-to="1" data-target="#carousel-404808">
								</li>
								<li data-slide-to="2" data-target="#carousel-404808">
								</li>
							</ol>
							<div class="carousel-inner">
								<div class="carousel-item active">
									<img class="d-block w-100" style="filter: brightness(50%)" alt="Carousel Bootstrap First" src="/resources/images/1st.jpg"/>
									<div class="carousel-caption">
										<h1>Fusion Internship Project</h1>
										<h3>Developed by: Jeff Nedley</h3>
										<button type="button" class="btn btn-outline-light btn-lg">LOGIN</button>
										<button type="button" class="btn btn-primary btn-lg"><img class="logo" src="/resources/images/googleLogo.png">LOGIN WITH GOOGLE</button>
									</div>
								</div>
								<div class="carousel-item">
									<img class="d-block w-100" style="filter: brightness(50%)" alt="Carousel Bootstrap Second" src="/resources/images/2nd.jpg" />
									<div class="carousel-caption">
									</div>
								</div>
								<div class="carousel-item">
									<img class="d-block w-100" style="filter: brightness(50%)" alt="Carousel Bootstrap Third" src="/resources/images/3rd.jpg" />
									<div class="carousel-caption">
									</div>
								</div>
							</div>
							<a class="carousel-control-prev" href="#carousel-404808" data-slide="prev">
								<span class="carousel-control-prev-icon"></span>
								<span class="sr-only">Previous</span>
							</a>
							<a class="carousel-control-next" href="#carousel-404808" data-slide="next">
							<span class="carousel-control-next-icon"></span>
							<span class="sr-only">Next</span>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="container-fluid padding">
				<div class="row login text-center">
					<div class="col-12">
						<h1 class="display-4">Login using the buttons above!</h1>
					</div>
				</div>
			</div>
		<footer>
			<div class="container-fluid footer padding">
				<div class="row text-center">
					<div class="col-12">
						<img class="foot-img" src="/resources/images/FusionLogo.png">
						<div class="row hr text-center">
							<hr class="light">
						</div>
						<div class="row foot text-center">
							<p>Internship Project by Jeffrey Nedley</p>
						</div>
					</div>
				</div>
			</div>
		</footer>
<%--		<div class="container">--%>
<%--			<div class="row">--%>
<%--				<div class="col-xl-10">--%>
<%--					<h1 class="align-center">Fusion Internship Project</h1>--%>
<%--				</div>--%>
<%--			</div>--%>
<%--			<div class="row">--%>
<%--				<div class="col"></div>--%>
<%--				<div class="col-md-auto">--%>
<%--					<form action="http://example.com:8080/login/database">--%>
<%--						<button class="regLogin">--%>
<%--							Login--%>
<%--						</button>--%>
<%--					</form>--%>
<%--				</div>--%>
<%--				<div class="col"></div>--%>
<%--			</div>--%>
<%--			<div class="row">--%>
<%--				<div class="col"></div>--%>
<%--				<div class="col-md-auto">--%>
<%--					<form action="http://example.com:8080/success/google">--%>
<%--						<button class = "googleLogin">--%>
<%--							Login with Google--%>
<%--							<div class="googlePng">--%>
<%--								<img width="20px" style="margin-top:7px; margin-right:8px" alt="Google sign-in"--%>
<%--									 src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/512px-Google_%22G%22_Logo.svg.png" />--%>
<%--							</div>--%>
<%--						</button>--%>
<%--					</form>--%>
<%--				</div>--%>
<%--				<div class="col"></div>--%>
<%--			</div>--%>
<%--		</div>--%>
	</body>

</html>