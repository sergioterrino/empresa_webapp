<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Empleados</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
</head>
<body>
	<div class="container">
		<h1>Listado de Empleados</h1>
		<table border="1">
			<tr>
				<td>DNI</td>
				<td>Nombre</td>
				<td>Sexo</td>
				<td>Categor�a</td>
				<td>A�os</td>
				<td>Accion</td>
			</tr>
			<c:forEach var="empleado" items="${lista}">
				<tr>
					<td><c:out value="${empleado.dni}"></c:out></td>
					<td><c:out value="${empleado.nombre}"></c:out></td>
					<td><c:out value="${empleado.sexo}"></c:out></td>
					<td><c:out value="${empleado.categoria}"></c:out></td>
					<td><c:out value="${empleado.anyos}"></c:out></td>
					<td>
						<a href="empleados?opcion=eliminar&id=<c:out value="${empleado.id}"></c:out>">Eliminar</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
