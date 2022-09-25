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
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"
	rel="stylesheet" />
</head>
<body>
	<%
	Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
	%>
	<%@ page errorPage="/erroPage.jsp"%>
	<c:if test="${usuario == null}">
		<jsp:forward page="./login.jsp"></jsp:forward>
	</c:if>
	<jsp:include page="/componentes/headerPrivate.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">

			<jsp:include page="/componentes/menuLateral.jsp">
				<jsp:param name="menuActivo" value="rol" />
			</jsp:include>

			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Roles</h1>

				</div>
				<div class="row d-flex pb-2 border-bottom">
					<div class="col-5">
						<a type="button"
							href="<%=request.getContextPath()%>/usuario/registroRol.jsp"
							class="btn btn-outline-secondary"> Nuevo registro de Rol </a>
					</div>
					<div class="col-3">
						<a type="button"
							href="<%=request.getContextPath()%>/excel/excelRoles.jsp?formato=excel"
							class="btn btn-outline-secondary"> Exportar a excel </a>
					</div>
				</div>
				<br /> <br />
				<div>
					<c:if test="${listaRoles != null}">
						<table class="table table-bordered">
							<thead class="thead-dark bg-dark">
								<tr>
									<th scope="col" style="color: white; font-size: medium;">#</th>
									<th scope="col" style="color: white; font-size: medium;">Rol</th>
									<th scope="col" style="color: white; font-size: medium;">Descripci&oacute;n</th>
									<th scope="col" style="color: white; font-size: medium;"></th>
									<th scope="col" style="color: white; font-size: medium;"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listaRoles}" var="rol">
									<tr>
										<td class="text-center align-middle"><c:out
												value="${rol.getId()}" /></td>
										<td><c:out value="${rol.getNombres()}" /></td>
										<td><c:out value="${rol.getDescripcion()}" /></td>
										<td class="text-center align-middle">
											<form action="<%=request.getContextPath()%>/Rol/actualizar"
												method="post">
												<input type="hidden" name="idactualizar"
													value="${rol.getId()}" />
												<button class="btn btn-info" type="submit">
													<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
												</button>
											</form>
										</td>
										<td class="text-center align-middle">
											<button class="btn btn-danger w-25" type="submit"
												onclick="SwalDelete(${rol.getId()})">
												<i class="fa fa-trash" aria-hidden="true"></i>
											</button>
											<form id="formAction"
												action="<%=request.getContextPath()%>/Rol/eliminar"
												method="post">
												<input type="hidden" name="ideliminar"
													value="${rol.getId()}" />

											</form>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
				</div>
			</main>
		</div>
	</div>

	<script type="text/javascript">
		function SwalDelete(Id) {
			event.preventDefault();
			swal({				
				title : 'Seguro que quiere eliminar el Rol ' + Id,
				text : 'Se eliminara de manera permanente',
				type: "warning",
				showCancelButton: true,
				cancelButtonText: "No",
				confirmButtonColor: "#DD6B55",
				confirmButtonText: "Adelante",
				closeOnConfirm: false },				
				function(){					
					document.getElementById("formAction").submit();	
// 					swal({
// 						title: 'Hecho',
// 						text : 'Se ha eliminado correctamente',
// 						type: "success",
// 						closeOnConfirm: false
// 					});	
				}
			)
			
			
			
		}
	</script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
</body>
</html>