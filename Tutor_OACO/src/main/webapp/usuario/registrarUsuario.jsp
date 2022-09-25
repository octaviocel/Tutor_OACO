<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="mx.ulsa.modelo.Usuario"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Usuarios</title>
<jsp:include page="/componentes/bootstrap.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/dashboard.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/dashboard.rtl.css">
</head>
<body>

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
					<h1 class="h2">Registrar Usuario</h1>

				</div>
				<div class="row">
					<div class="col-10">
						<form
							action="<%=request.getContextPath()%>/Usuario/registrarUsuarioPersona"
							method="post">
							<div class="mb-3 row">
								<label for="correo" class="col-sm-2 col-form-label">Correo</label>
								<div class="col-sm-10">
									<input type="email" name="correo" id="correo"
										class="form-control" id="staticEmail">
								</div>
							</div>
							<div class="mb-3 row">
								<label for="password" class="col-sm-2 col-form-label">Contrase&ntilde;a</label>
								<div class="col-sm-10">
									<input type="password" name="password" class="form-control"
										id="inputPassword">
								</div>
							</div>

							<div class="mb-3 row">
								<label for="persona" class="col-sm-2 col-form-label">Persona</label>
								<div class="col-sm-10">
									<select name="persona" >

										<c:forEach var="plat" items="${listaPersonas}">
											<option name="personaOption" value=" ${plat.getId()} "
												>${plat.getNombre()} ${plat.getApePaterno()}</option>
										</c:forEach>

									</select>
								</div>
							</div>
							
							<div class="mb-3 row">
								<label for="rol" class="col-sm-2 col-form-label">Rol</label>
								<div class="col-sm-10">
									<select name="rol" >

										<c:forEach var="rol" items="${listaRoles}">
											<option name="rolOption" value=" ${rol.getId()} "
												>${rol.getNombres()}</option>
										</c:forEach>

									</select>
								</div>
							</div>

							<div class="mb-3 form-check">
								<input type="checkbox" class="form-check-input" name="status"
									id="status"> <label class="form-check-label"
									for="status">Estatus</label>
							</div>

							<div class="mb-3 row">
								<label for="fechaVigencia" class="col-sm-2 col-form-label">Fecha
									Vigencia</label>
								<div class="col-sm-4">
									<input type="date" name="fechaVigencia" class="form-control"
										id="fechaVigencia">
								</div>
							</div>
							<div class="row">
								<div class="col-2">
									<button class="btn btn-success" type="submit">Agregar</button>
								</div>
							</div>
						</form>
						<br />
						<div class="row">
							<div class="col-2">
								<a href="<%=request.getContextPath()%>/usuario/usuario.jsp"
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