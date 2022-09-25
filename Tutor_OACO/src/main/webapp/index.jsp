<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>Inicio</title>

<meta name="description" content="">
<meta name="author" content="">
<meta name="keywords" content="">

<!-- Mobile Specific Metas
    ================================================== -->
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">

<!-- Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,600,700"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">

<!-- Favicon
    ================================================== -->
<link rel="apple-touch-icon" sizes="180x180"
	href="images/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="16x16"
	href="images/favicon.png">

<!-- Stylesheets
    ================================================== -->
<!-- Bootstrap core CSS -->
<link href="css/cssTemplate/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/cssTemplate/style.css" rel="stylesheet">
<link href="css/cssTemplate/responsive.css" rel="stylesheet">
</head>
<body>

	<%@ page errorPage="/erroPage.jsp"%>

	<jsp:include page="/componentes/headerPublico.jsp"></jsp:include>

	<div id="hero" class="hero overlay">
		<div class="hero-content">
			<div class="hero-text">
				<h1>El comienzo con JSP.</h1>
				<p>El primer proyecto creado en JSP. Dynamic Web Project .</p>
				<a href="<%=request.getContextPath()%>/usuario/login.jsp"
					class="btn btn-border">Iniciar sesi&oacute;n</a>
			</div>
			<!-- /.hero-text -->
		</div>
		<!-- /.hero-content -->
	</div>
	<!-- /.hero -->

	<main id="main" class="site-main">

		<section class="site-section section-features">
			<div class="container">
				<div class="row">
					<div class="col-sm-5">
						<h2>JSP</h2>
						<p>La tecnolog&iacute;a JavaServer Pages permite generar
							contenido Web din&aacute;mico como, por ejemplo, archivos HTML,
							DHTML, XHTML y XML, para incluirlos en una aplicaci&oacute;n Web.
							Los archivos JSP son una forma de implementar contenido de
							p&aacute;ginas din&aacute;mico del lado del servidor. Los
							archivos JSP permiten a un servidor Web como, por ejemplo, Apache
							Tomcat, a&ntilde;adir contenido din&aacute;micamente a las
							p&aacute;ginas HTML antes de enviarlas al navegador que las
							solicita.</p>
					</div>
					<div class="col-sm-7 hidden-xs">
						<img src="images/ipad-pro.png" alt="">
					</div>
				</div>
			</div>
		</section>
		<!-- /.section-features -->


		<section class="site-section section-map-feature text-center">

			<div class="container">
				<h2>Laboratorio de Programaci&oacute;n para Servidores Web</h2>
				<p>Docente: Harim Altamirano Castellanos.</p>
				<a href="<%=request.getContextPath()%>/usuario/registrar.jsp"
					class="btn btn-fill">Registrate</a>
				<div class="row">
					<div class="col-sm-3 col-xs-6">
						<div class="counter-item">
							<p class="counter" data-to="377" data-speed="2000">0</p>
							<h3>Coffee Cups</h3>
						</div>
						<!-- /.counter-item -->
					</div>
					<div class="col-sm-3 col-xs-6">
						<div class="counter-item">
							<p class="counter" data-to="1204" data-speed="2000">0</p>
							<h3>Projects completed</h3>
						</div>
						<!-- /.counter-item -->
					</div>
					<div class="col-sm-3 col-xs-6">
						<div class="counter-item">
							<p class="counter" data-to="459" data-speed="1000">0</p>
							<h3>Happy Clients</h3>
						</div>
						<!-- /.counter-item -->
					</div>
					<div class="col-sm-3 col-xs-6">
						<div class="counter-item">
							<p class="counter" data-to="675" data-speed="1000">0</p>
							<h3>Average Deal</h3>
						</div>
						<!-- /.counter-item -->
					</div>
				</div>
			</div>

		</section>
		<!-- /.section-map-feature -->

		<!-- /.section-portfolio -->

		<section class="site-section section-newsletter text-center">
			<div class="container">
				<h2>Subscribete y se parte de nuestra comunidad</h2>
				<form class="form-group newsletter-group">
					<input type="email" class="form-control" placeholder="Your e-mail"
						required>
					<button class="btn btn-green" type="button">Subscribete</button>
				</form>
				<!-- /.newsletter-group -->
			</div>
		</section>
		<!-- /.section-newsletter -->

	</main>
	<!-- /#main -->

	<footer id="colophon" class="site-footer">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-4 col-xs-6">
					<a class="site-title"><span>Software</span>4All</a>
					<p>We're a digital agency focused on creative and
						results-driven solutions.</p>
					<p>We measure our success by the results we drive for our
						clients.</p>
				</div>
				<div
					class="col-lg-offset-4 col-md-3 col-sm-4 col-md-offset-2 col-sm-offset-0 col-xs-6 ">
					<h3>Keep in touch</h3>
					<ul class="list-unstyled contact-links">
						<li><i class="fa fa-envelope" aria-hidden="true"></i><a
							href="mailto:info@agencyperfect.com">octavio.celaya@software4all.com</a></li>
						<li><i class="fa fa-phone" aria-hidden="true"></i><a
							href="tel:+37400800000">951 242 3410 </a></li>
						<li><i class="fa fa-fax" aria-hidden="true"></i><a
							href="+37400900000">+374 (00) 90 00 00</a></li>
						<li><i class="fa fa-map-marker" aria-hidden="true"></i>
							<p>Oaxaca de Juarez, Oax.</p></li>
					</ul>
				</div>
				<div class="clearfix visible-xs"></div>

			</div>
		</div>
		<div class="copyright">
			<div class="container">
				<div class="row">
					<div class="col-xs-8">
						<div class="social-links">
							<a class="twitter-bg" href="www.twitter.com"><i
								class="fa fa-twitter"></i></a> <a class="facebook-bg"
								href="www.facebook.com"><i class="fa fa-facebook"></i></a> <a
								class="linkedin-bg"
								href="https://www.linkedin.com/in/octavio-celaya-ojeda-246a3a1b5/"><i
								class="fa fa-linkedin"></i></a>
						</div>
						<!-- /.social-links -->
					</div>
					<div class="col-xs-4">
						<div class="text-right">
							<p>&copy; Software4All</p>
							<p>All Rights Reserved</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /.copyright -->
	</footer>
	<!-- /#footer -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="js/jsTemplate/bootstrap.min.js"></script>
	<script src="js/jsTemplate/bootstrap-select.min.js"></script>
	<script src="js/jsTemplate/jquery.slicknav.min.js"></script>
	<script src="js/jsTemplate/jquery.countTo.min.js"></script>
	<script src="js/jsTemplate/jquery.shuffle.min.js"></script>
	<script src="js/jsTemplate/script.js"></script>
</body>
</html>