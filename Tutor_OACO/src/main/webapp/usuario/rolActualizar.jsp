<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="mx.ulsa.modelo.Usuario"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar Rol</title>
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

			<c:if test="${RolActualizar == null}">
				<jsp:forward page="./usuario/rol.jsp"></jsp:forward>
			</c:if>

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
					<h1 class="h2">Actualizar Rol</h1>

				</div>
				<div class="row">
					<div class="col-10">
						<form action="<%=request.getContextPath()%>/Rol/guardar">
							<div class="mb-3">
								<input type="hidden" name="idguardar" value="${RolActualizar.getId()}" />
								<label for="exampleInputEmail1" class="form-label">Rol </label>
								<input type="text" class="form-control" name="rol" id="rol"
									aria-describedby="emailHelp" value="${RolActualizar.getNombres()}">
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Descripci&oacute;n</label>
								<input type="text" class="form-control" name="descripcion"
									id="exampleInputPassword1"
									value="${RolActualizar.getDescripcion()}">
							</div>

							<div class="row">
								<div class="col-2">
									<button class="btn btn-success" type="submit">Guardar</button>
								</div>
							</div>
						</form>
						<br />
						<div class="row">
							<div class="col-2">
								<a href="<%=request.getContextPath()%>/usuario/rol.jsp"
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