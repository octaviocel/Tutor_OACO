<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="mx.ulsa.modelo.Usuario"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salir</title>
</head>
<body>
	<%
	//Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
	session.removeAttribute("usuario");
	session.invalidate();
	response.sendRedirect(request.getContextPath() + "/usuario/login.jsp");
	%>
	
</body>

</html>