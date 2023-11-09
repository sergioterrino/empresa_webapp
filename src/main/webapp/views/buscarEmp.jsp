<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buscar Empleado</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script src="https://kit.fontawesome.com/aac395d8de.js"></script>
</head>
<body>
	<div class="container" style="position: relative;">
		<h1>Buscar Empleado</h1>
		<%
		/* Este form enviará los datos de vuelta al Servlet (los datos que se mandan son: name="choice", los values, etc) */
		%>
		<form action="empleados?opcion=buscarEmp" method="post">
			<div id="divBuscarEmp">
				<label for="empleados">Por qué campo quieres buscar:</label> <select
					id="empleados" name="choice">
					<option value="DNI">DNI</option>
					<option value="Nombre">Nombre</option>
					<option value="Sexo">Sexo</option>
					<option value="Categoria">Categoría</option>
					<option value="Anyos">Anyos</option>
				</select>
			</div>
			<div id="divBuscarEmp">
				Introduzca su búsqueda: <input type="text" name="busqueda"
					placeholder="Escribe su búsqueda aquí..." />
			</div>

			<div id="divBuscarEmp">
				<input type="submit" value="Buscar" id="inp" />
			</div>
		</form>
		<c:if test="${not empty lista}">
			<div class="containerVerEmp" style="position: relative;">
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
							<td>
								<form action="empleados?opcion=editar" method="post">
									<input type="hidden" name="dni" value="${empleado.dni}" />
									<input type="hidden" name="nombre" value="${empleado.nombre}" />
									<input type="hidden" name="sexo" value="${empleado.sexo}" />
									<input type="hidden" name="categoria" value="${empleado.categoria}" />
									<input type="hidden" name="anyos" value="${empleado.anyos}" />
									<input type="submit" value="Modificar"/>
								</form>
							</td>

						</tr>
					</c:forEach>
				</table>
			</div>
		</c:if>
		<button onclick="history.back()" id="btnVolver"
			style="position: absolute; top: 3%; left: 1%; background-color: #3498db; color: white; font-weight: bold; border: 1px solid white; border-radius: 5px; padding: 0.5%;">
			<i class="fas fa-reply"></i> Volver
		</button>
	</div>
</body>
</html>