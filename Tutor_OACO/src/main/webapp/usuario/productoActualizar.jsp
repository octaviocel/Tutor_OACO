<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar Producto</title>
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

				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Actualizar Producto</h1>

				</div>
				<div class="row">
					<div class="col-10">
						<form enctype="multipart/form-data" method="post"
							action="<%=request.getContextPath()%>/Producto/guardar">
							<!-- multipart/mixed stream -->
							<input type="hidden" name="idguardar"
								value="${ProductoActualizar.getId()}" />
							<div class="mb-3">
								<label for="nombre" class="form-label">Nombre (s) </label> <input
									type="text" class="form-control" name="nombre" id="nombre"
									value="${ProductoActualizar.getNombre()}">
							</div>
							<div class="mb-3">
								<label for="descripcion" class="form-label">Descripci&oacute;n
								</label> <input type="text" class="form-control" name="descripcion"
									id="descripcion" value="${ProductoActualizar.getDescripcion()}">
							</div>
							<div class="mb-3">
								<label for="precio" class="form-label">Precio </label> <input
									type="number" step="0.01" class="form-control" name="precio"
									value="${ProductoActualizar.getPrecio().toString()}"
									id="precio">
							</div>
							<div class="mb-3">
								<h5>Usted ha elegido esta imagen si desea actualizarla,
									solo carge la nueva</h5>
								<td class="text-center align-middle"><img alt="ImgenPr"
									src="${ProductoActualizar.getImagen()}" height="125"
									width="125"></td>
							</div>
							<div class="mb-3">
								<label for="image" class="form-label">Imagen </label> <input
									type="file" class="form-control" accept="image/*" name="image"
									id="image">
							</div>
							<div class="mb-3">
								<label for="numExis" class="form-label">N&uacute;mero de
									Existencia </label> <input type="number" class="form-control"
									name="numExis"
									value="${ProductoActualizar.getNumExistentes().toString()}"
									id="numExis">
							</div>
							<div class="mb-3">
								<label for="codigo" class="form-label">C&oacute;digo de
									Barras </label> <input type="text" class="form-control" name="codigo"
									id="codigo" value="${ProductoActualizar.getCodigoBarra()}">
							</div>
							<div class="mb-3">
								<label for="iva" class="form-label">IVA </label> <input
									type="number" class="form-control" name="iva" id="iva"
									value="${ProductoActualizar.getIva().toString()}">
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
								<a href="<%=request.getContextPath()%>/usuario/producto.jsp"
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