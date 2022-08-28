<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="mx.ulsa.modelo.Usuario" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>
	<%
	Usuario user = (Usuario) request.getSession().getAttribute("usuario");
	%>
	<c:if test="${user != null }">
		<h2>This is my Profile</h2>
		<h2>${user.getCorreo()}</h2>
	</c:if>
	<c:if test="${user == null }">
		<jsp:forward page="./login.jsp"></jsp:forward>
	</c:if>
	
	
</body>
</html>