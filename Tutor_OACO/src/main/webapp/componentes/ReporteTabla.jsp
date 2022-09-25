<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<h2>Comprar Fresas Y Zarzamporas</h2>
	<%
		String formato = request.getParameter("formato");
		if((formato!=null)&& (formato.equals("excel"))){
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment; fileName=ExcelTablaReporte.xls");
		}
	%>
	<table border=2>
        <tr>
            <th></th>
            <th>Fresas</th>
            <th>Zarzamoras</th>
        </tr>
        <tr>
            <th>Primer cuarto</th>
            <th>2307</th>
            <th>4706</th>
        </tr>
        <tr>
            <th>Segundo cuarto</th>
            <th>2982</th>
            <th>5104</th>
        </tr>
        <tr>
            <th>Tercer cuarto</th>
            <th>3011</th>
            <th>5220</th>
        </tr>
        <tr>
            <th>Cuarto cuarto</th>
            <th>3055</th>
            <th>5287</th>
        </tr>
    </table>
    <form action="<%=request.getContextPath()%>/componentes/ReporteTabla.jsp?formato=excel">
    	<input type="submit" value="Exportar Excel">
    </form>
    </center>

</body>
</html>