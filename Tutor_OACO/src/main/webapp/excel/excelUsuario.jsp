<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="mx.ulsa.modelo.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h2>Reporte de Usuarios</h2>
		<%
		String formato = request.getParameter("formato");
		if ((formato != null) && (formato.equals("excel"))) {
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment; fileName=ExcelTablaReporteUsuarios.xls");
		}
		
		%>
		<c:if test="${listaUsuarios != null }">						
						<table border=2>
							<thead >
								<tr>
									<th >#</th>
									<th >Correo</th>
									<th >Nombre</th>
									<th >Status</th>
									<th >Fecha
										Registro</th>
									<th >Fecha
										Vigencia</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${listaUsuarios}" var="per">
									<tr>
										<td class="text-center align-middle"><c:out
												value="${per.getId()}" /></td>
										<td class="text-center align-middle"><c:out
												value="${per.getCorreo()}" /></td>
										<td class="text-center align-middle"><c:out
												value="${per.getPersona().getNombre().length() > 0 ? per.getPersona().getNombre() : 'Sin Asignacion de Persona'}" /></td>
										<td class="text-center align-middle"><c:out
												value="${per.getStatus()  == true ? 'Activo' : 'Inactivo'}" /></td>
										<td class="text-center align-middle"><c:out
												value="${per.getFechaResgitro().toString()}" /></td>
										<td class="text-center align-middle"><c:out
												value="${per.getFechaVigencia().toString()}" /></td>
										
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>

</body>
</html>