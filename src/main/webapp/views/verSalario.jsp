<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ver salario</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
</head>
<body>
	<div class="container">
		<h1>
			Nómina de
			<%=request.getAttribute("nombre")%>
		</h1>
		<p>
			El empleado con DNI = <b><%=request.getAttribute("dni")%></b>
			tiene un salario = <b><%=request.getAttribute("salario")%></b> €
		</p>
	</div>
</body>
</html>