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
		response.setHeader("Content-disposition", "attachment; fileName=ReporteRoles.xls");
	}
	%>
	<c:if test="${listaRoles != null}">
		<table border=2>
			<thead >
				<tr>
					<th >#</th>
					<th >Rol</th>
					<th >Descripci&oacute;n</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaRoles}" var="rol">
					<tr>
						<td class="text-center align-middle"><c:out
								value="${rol.getId()}" /></td>
						<td><c:out value="${rol.getNombres()}" /></td>
						<td><c:out value="${rol.getDescripcion()}" /></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>