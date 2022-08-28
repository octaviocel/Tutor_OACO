<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login - Tutor</title>
<link href="../css/style2.css" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="img js-fullheight"
	style="background-image: url(../images/hero.jpg);">
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section"><a href="<%=request.getContextPath()%>/index.jsp" style="color: #6fc754;"> Ir a Inicio</a></h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap p-0">
						<h3 class="mb-4 text-center">Tienes Cuenta?</h3>
						<form action="<%=request.getContextPath()%>/Usuario/login"
						method="post" class="signin-form">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Username"
									name="correo"
									required>
							</div>
							<div class="form-group">
								<input id="password-field" type="password" class="form-control"
									name="contrasenia"
									placeholder="Password" required> <span
									toggle="#password-field"
									class="fa fa-fw fa-eye field-icon toggle-password"></span>
							</div>
							<div class="form-group" >
								<button type="submit"
									class="form-control btn  submit px-3" style="background: #6fc754;">Sign
									In</button>
							</div>
							<div class="form-group d-md-flex">
								<div class="w-50">
									<label class="checkbox-wrap checkbox-primary" style="color: #6fc754;">Remember
										Me <input type="checkbox" checked style="background-color: #6fc754;"> <span
										class="checkmark" ></span>
									</label>
								</div>
								<div class="w-50 text-md-right">
									<a href="#" style="color: #fff">Forgot Password</a>
								</div>
							</div>
						</form>
						<p class="w-100 text-center">&mdash; Or Sign In With &mdash;</p>
						<div class="social d-flex text-center">
							<a href="#" class="px-2 py-2 mr-md-1 rounded twitter-bg"><span
								class="fa fa-facebook mr-2"></span> Facebook</a> <a href="#"
								class="facebook-bg px-2 py-2 ml-md-1 rounded"><span
								class="fa fa-twitter mr-2"></span> Twitter</a>
						</div>
						<br />
						<p class="w-100 text-center">&mdash; No tienes cuenta Registrate &mdash;</p>
						<div class="social d-flex text-center">
							<a href="<%=request.getContextPath()%>/usuario/registrar.jsp" style="background-color: #6fc754;" class="px-2 py-2 mr-md-1 rounded"><span
								class=" mr-2"></span> Registrarme</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="../js/jsLogin/jquery.min.js"></script>
	<script src="../js/jsLogin/popper.js"></script>
	<script src="../js/jsLogin/bootstrap.min.js"></script>
	<script src="../js/jsLogin/main.js"></script>
</body>
</html>