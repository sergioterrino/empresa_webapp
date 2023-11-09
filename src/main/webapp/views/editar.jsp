<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Empleado</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script src="https://kit.fontawesome.com/aac395d8de.js"></script>
</head>
<body>
	<div class="container">
		<h1>Editar Empleado</h1>
		<form action="empleados?opcion=guardar" method="post">
			<!-- Reemplaza guardarCambios.jsp con tu página de guardado -->
			<table border="1">
				<tr>
					<th>DNI</th>
					<th>Nombre</th>
					<th>Sexo</th>
					<th>Categoría</th>
					<th>Años</th>
					<th>Acción</th>
				</tr>
				<tr>
					<td><input name="dni" value="${empleado.dni}" /></td>
					<td><input name="nombre" value="${empleado.nombre}" /></td>
					<td><input name="sexo" value="${empleado.sexo}" /></td>
					<td><input name="categoria" value="${empleado.categoria}" /></td>
					<td><input name="anyos" value="${empleado.anyos}" /></td>
					<td><input type="submit" value="Guardar"></td>
					<td><input type="hidden" name="id" value="${empleado.id}"/></td>
				</tr>
			</table>
		</form>
		<%
		/*
			<form action="empleados?opcion=guardar" method="post">
				<input type="hidden" name="dni" value="${empleado.dni}"/>
				<input type="hidden" name="nombre" value="${empleado.nombre}" />
				<input type="hidden" name="sexo" value="${empleado.sexo}" />
				<input type="hidden" name="categoria" value="${empleado.categoria}" />
				<input type="hidden" name="anyos" value="${empleado.anyos}" />
				<input id="btnVolver" type="submit" value="Guardar Cambios">
				
			</form>
			*/
		%>
		<button onclick="history.back()" id="btnVolver"
			style="position: absolute; top: 3%; left: 1%; background-color: #3498db; color: white; font-weight: bold; border: 1px solid white; border-radius: 5px; padding: 0.5%;">
			<i class="fas fa-reply"></i> Volver
		</button>
	</div>
</body>
</html>