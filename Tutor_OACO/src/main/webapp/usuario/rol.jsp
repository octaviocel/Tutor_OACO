<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="mx.ulsa.modelo.Usuario"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rol</title>
<jsp:include page="/componentes/bootstrap.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/dashboard.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/dashboard.rtl.css">
</head>
<body>
	<%
	Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
	%>
	<c:if test="${usuario == null}">
		<jsp:forward page="./login.jsp"></jsp:forward>
	</c:if>
	<jsp:include page="/componentes/headerPrivate.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">

			<jsp:include page="/componentes/menuLateral.jsp"></jsp:include>

			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">				
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Roles</h1>				
					
				</div>
				<div class="row">
						<div class="col-3">
							<a type="button"
								href="<%=request.getContextPath()%>/usuario/registroRol.jsp"
								class="btn btn-outline-secondary"> Nuevo registro de Rol </a>
						</div>

					</div>
			</main>
		</div>
	</div>
</body>
</html>