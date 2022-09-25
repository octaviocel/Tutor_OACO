<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Reporte de Roles</h2>
	<%
	String formato = request.getParameter("formato");
	if ((formato != null) && (formato.equals("excel"))) {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment; fileName=ReporteProductos.xls");
	}
	%>
	<c:if test="${listaProductos != null }">
		<table border=2>
			<thead>
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Descripci&oacute;n</th>
					<th>Precio</th>
					<th>Imagen</th>
					<th>Existencia</th>
					<th>C&oacute;digo</th>
					<th>Iva</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaProductos}" var="per">
					<tr>
						<td class="text-center align-middle"><c:out
								value="${per.getId()}" /></td>
						<td><c:out value="${per.getNombre()}" /></td>
						<td><c:out value="${per.getDescripcion()}" /></td>
						<td class="text-center align-middle"><c:out
								value="$ ${per.getPrecio().toString()}" /></td>
						<td class="text-center align-middle"><img alt="ImgenPr"
							src="${per.getImagen()}" height="52" width="52"></td>
						<td class="text-center align-middle"><c:out
								value="${per.getNumExistentes().toString()}" /></td>
						<td class="text-center align-middle"><c:out
								value="${per.getCodigoBarra()}" /></td>
						<td class="text-center align-middle"><c:out
								value="${per.getIva().toString()} %" /></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>