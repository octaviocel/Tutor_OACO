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
		<h2>Reporte de Personas</h2>
		<%
		String formato = request.getParameter("formato");
		if ((formato != null) && (formato.equals("excel"))) {
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment; fileName=ReportePersonas.xls");
		}
		
		%>
	<c:if test="${listaPersonas != null }">
		<table border=2>
			<thead>
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Apellido Paterno</th>
					<th>Apellido Materno</th>
					<th>Edad</th>
					<th>Telefono</th>
					<th>RFC</th>
					<th>Fecha Nac</th>
					<th>Domicilio</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaPersonas}" var="per">
					<tr>
						<td class="text-center align-middle"><c:out
								value="${per.getId()}" /></td>
						<td><c:out value="${per.getNombre()}" /></td>
						<td><c:out value="${per.getApePaterno()}" /></td>
						<td><c:out value="${per.getApeMaterno()}" /></td>
						<td><c:out value="${per.getEdad().toString()}" /></td>
						<td><c:out value="${per.getTelefono()}" /></td>
						<td><c:out value="${per.getRfc()}" /></td>
						<td><c:out value="${per.getFechaNac().toString()}" /></td>
						<td><c:out value="${per.getDomicilio()}" /></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>