<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ver Empleado</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script src="https://kit.fontawesome.com/aac395d8de.js"></script>
</head>
<body>
	<div class="container" style="position: relative;">
		<h1>Lista de Empleados</h1>
		<table border="1">
			<tr>
				<th>DNI</th>
				<th>Nombre</th>
				<th>Sexo</th>
				<th>Categoría</th>
				<th>Años</th>
				<th>Acción</th>
			</tr>
			<c:forEach var="empleado" items="${lista}">
				<tr>
					<td><c:out value="${empleado.dni}"></c:out></td>
					<td><c:out value="${empleado.nombre}"></c:out></td>
					<td><c:out value="${empleado.sexo}"></c:out></td>
					<td><c:out value="${empleado.categoria}"></c:out></td>
					<td><c:out value="${empleado.anyos}"></c:out></td>
					<td><a <% /* Aún no está implementado */ %>
						href="empleados?opcion=eliminar&id=<c:out value="${empleado.id}"></c:out>">Modificar</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<button onclick="history.back()" id="btnVolver"
			style="position: absolute; top: 3%; left: 1%; background-color: #3498db; color: white; font-weight: bold; border: 1px solid white; border-radius: 5px;padding:0.5%;">
			<i class="fas fa-reply"></i> Volver
		</button>
	</div>

</body>
</html>