<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="mx.ulsa.modelo.Usuario"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
	%>
	<c:if test="${usuario == null}">
		<jsp:forward page="./login.jsp"></jsp:forward>
	</c:if>
	<header
		class="navbar navbar-dark sticky-top flex-md-nowrap p-0 shadow"
		style="background-color: #6fc754;"
		>
		<a class="navbar-brand col-md-4 col-lg-3 me-0 px-4 fs-7"  href="#" style="color: black;">
			<img alt="quebrado" class="rounded"
			src="https://dthezntil550i.cloudfront.net/f4/latest/f41908291942413280009640715/1280_960/1b2d9510-d66d-43a2-971a-cfcbb600e7fe.png"
			width="30px" height="35px"/>
			 <%=usuario.getCorreo()%>
		</a>

		<button class="navbar-toggler position-absolute d-md-none collapsed"
			type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu"
			aria-controls="sidebarMenu" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="navbar-nav">		
			<div class="nav-item text-nowrap">
				<a class="nav-link px-3 fs-8" style="color: black;"
					href="<%=request.getContextPath()%>/usuario/logout.jsp">Salir</a>
			</div>
		</div>
	</header>
</body>
</html>