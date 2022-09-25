<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar - Tutor</title>

<link rel="stylesheet" type="text/css" href="../css/montserrat-font.css">
<link rel="stylesheet" type="text/css"
	href="../fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
<!-- Main Style Css -->
<link rel="stylesheet" href="../css/style.css" />
</head>
<body class="img js-fullheight"
	style="background-image: url(../images/hero.jpg); display: flex; align-content: center; justify-content: center;">
	<%@ page errorPage="/erroPage.jsp"%>
	<div style="justify-content: center; align-self: center;">
		<div class="form-v10-content">
			<c:if test="${msgError != null}">
				<div class="alert alert-danger" role="alert">
					<h4 class="alert-heading">Errores!</h4>
					<p>${msgError}</p>
					<hr>
					<p class="mb-0">Error al registrar</p>
				</div>
			</c:if>
			<form class="form-detail"
				action="<%=request.getContextPath()%>/Usuario/registrar"
				method="post" id="myform">
				<div class="form-left">
					<h2 style="color: #6fc754;">Informaci&oacute;n General</h2>
					<!--
					<div class="form-row">
						<input type="text" name="nombre" id="first_name"
							class="input-text" placeholder="Nombre (s)" required>
					</div>
					<div class="form-group">
					
						<div class="form-row form-row-1">
							<input type="text" name="apePaterno" id="first_name"
								class="input-text" placeholder="Apellido Paterno" required>
						</div>
						<div class="form-row form-row-2">
							<input type="text" name="apeMaterno" id="last_name"
								class="input-text" placeholder="Apellido Materno" required>
						</div>
						
					</div>
					-->
					<div class="form-row">
						<input type="email" name="correo" class="input-text" id="company"
							placeholder="Correo" required pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}">

					</div>
					<div class="form-row">
						<input type="password" name="password" class="input-text"
							id="company" placeholder="Contrase&ntilde;a" required>

					</div>
					<!--
					<div class="form-group">
						<div class="form-row form-row-3">
							<input type="text" name="telefono" class="input-text"
								id="company" placeholder="Tel&eacute;fono" required>

						</div>
						<div class="form-row form-row-4">
							<input type="number" name="edad" class="input-text" id="company"
								placeholder="Edad" min="18" max="100" required>
						</div>

					</div>
					-->
					<br /> <br /> <br /> <br />
					<div class="form-row">
						<a href="<%=request.getContextPath()%>/index.jsp"> Regresar
							Inicio</a>
					</div>
				</div>
				<div class="form-right" style="background-color: #6fc754;">
					<h2>Click en Registrar</h2>
					<h2>${msgErroRegistro}</h2>
					<!-- <div class="form-row">
						<input type="text" name="calle" class="street" id="street"
							placeholder="Calle" required>
					</div>
					<div class="form-row">
						<input type="text" name="colonia" class="additional"
							id="additional" placeholder="Colonia" required>
					</div>
					<div class="form-group">
						<div class="form-row form-row-1">
							<input type="text" name="codigo" class="zip" id="zip"
								placeholder="CP" required>
						</div>
						<div class="form-row form-row-2">
							<select name="Estado">
								<option value="place">Oaxaca</option>
								<option value="Street">Veracruz</option>
								<option value="District">CDMX</option>
								<option value="City">Monterrey</option>
							</select> <span class="select-btn"> <i
								class="zmdi zmdi-chevron-down"></i>
							</span>
						</div>
					</div>
					<div class="form-row">
						<input type="text" name="nombreEmpresa" class="code" id="code"
							placeholder="Nombre de Empresa" required>
					</div>
					<div class="form-row">

						<input type="text" name="numEmpre" class="phone" id="phone"
							placeholder="Numero Empresa" required>

					</div>
					<div class="form-row">
						<input type="text" name="emailEmpresa" id="your_email"
							class="input-text" pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}"
							placeholder="Correo Empresa(opcional)">
					</div>
					<div class="form-checkbox">
						<label class="container"><p>I do accept the Terms and
								Conditions of your site.</p> <input type="checkbox" name="checkbox">
							<span class="checkmark"></span> </label>
					</div>
					 -->
					<div class="form-row-last">
						<input type="submit" name="register" class="register"
							value="Registrarse">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>