<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ver salario</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script src="https://kit.fontawesome.com/aac395d8de.js"></script>
</head>
<body>
	<div class="container">
		<h1>
			Nómina de
			<%=request.getAttribute("nombre")%>
		</h1>
		<div id="divVerSalario">
			El empleado con DNI = <b><%=request.getAttribute("dni")%></b>
			tiene un salario = <b><%=request.getAttribute("salario")%></b> €
		</div>
		<button onclick="history.back()" id="btnVolver"
			style="position: absolute; top: 3%; left: 1%; background-color: #3498db; color: white; font-weight: bold; border: 1px solid white; border-radius: 5px;padding:0.5%;">
			<i class="fas fa-reply"></i> Volver
		</button>
	</div>
</body>
</html>