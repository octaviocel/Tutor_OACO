<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="mx.ulsa.modelo.Usuario"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar Persona</title>
<jsp:include page="/componentes/bootstrap.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/dashboard.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/dashboard.rtl.css">
</head>
<body>

	<c:if test="${PersonaActualizar == null}">
		<jsp:forward page="./usuario/persona.jsp"></jsp:forward>
	</c:if>
	<jsp:include page="/componentes/headerPrivate.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">


			<jsp:include page="/componentes/menuLateral.jsp"></jsp:include>

			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<c:if test="${msgError != null}">
					<div class="alert alert-danger" role="alert">
						<h4 class="alert-heading">Errores!</h4>
						<p>${msgError}</p>
						<hr>
						<p class="mb-0">Por favor rellena todos los campos</p>
					</div>
				</c:if>
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Actualizar Persona</h1>

				</div>
				<div class="row">
					<div class="col-10">
						<form action="<%=request.getContextPath()%>/Persona/guardar"
							method="post">
							<input type="hidden" name="idguardar" value="${PersonaActualizar.getId()}" />
							<div class="mb-3">
								<label for="nombre" class="form-label">Nombre (s) </label> <input
									type="text" class="form-control" name="nombre" id="nombre"
									value="${PersonaActualizar.getNombre()}" >
							</div>
							<div class="mb-3">
								<label for="apePat" class="form-label">Apellido Paterno
								</label> <input type="text" class="form-control" name="apePat"
									id="apePat" value="${PersonaActualizar.getApePaterno()}">
							</div>
							<div class="mb-3">
								<label for="apeMat" class="form-label">Apellido Materno
								</label> <input type="text" class="form-control" name="apeMat"
									id="apeMat" value="${PersonaActualizar.getApeMaterno()}">
							</div>
							<div class="mb-3">
								<label for="edad" class="form-label">Edad </label> <input
									type="number" min="18" max="120" class="form-control"
									name="edad" id="edad" value="${PersonaActualizar.getEdad()}">
							</div>
							<div class="mb-3">
								<label for="rfc" class="form-label">RFC </label> <input
									type="text" class="form-control" name="rfc" id="rfc"
									value="${PersonaActualizar.getRfc()}">
							</div>
							<div class="mb-3">
								<label for="telefono" class="form-label">Tel&eacute;fono
								</label> <input type="tel" maxlength="10" class="form-control"
									name="telefono" id="telefono"
									value="${PersonaActualizar.getTelefono()}">
							</div>
							<div class="mb-3">
								<label for="fechaNac" class="col-sm-2 col-form-label">Fecha
									Nacimiento</label>
								<div class="col-sm-4">
									<input type="date" name="fechaNac" class="form-control"
										id="fechaNac"
										value="${PersonaActualizar.getFechaNac()}">
								</div>
							</div>
							<div class="mb-3">
								<label for="domicilio" class="form-label">Domicilio </label> <input
									type="text" class="form-control" name="domicilio"
									id="domicilio" value="${PersonaActualizar.getDomicilio()}">
							</div>

							<div class="row">
								<div class="col-2">
									<button class="btn btn-success" type="submit">Actualizar</button>
								</div>
							</div>
						</form>
						<br />
						<div class="row">
							<div class="col-2">
								<a href="<%=request.getContextPath()%>/usuario/persona.jsp"
									type="button" class="btn btn-secondary"> Cancelar </a>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
</body>
</html>