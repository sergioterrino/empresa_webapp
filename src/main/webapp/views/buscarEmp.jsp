<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<% /* Este form enviará los datos de vuelta al Servlet (los datos que se mandan son: name="choice", los values, etc) */ %>
		<form action="empleados?opcion=buscarEmp" method="post">
			<div id="divBuscarEmp">
				<label for="empleados">Por qué campo quieres buscar:</label> 
				<select id="empleados" name="choice">
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
				<input type="submit" value="Buscar" id="inp"/>
			</div>
		</form>
		<button onclick="history.back()" id="btnVolver"
			style="position: absolute; top: 3%; left: 1%; background-color: #3498db; color: white; font-weight: bold; border: 1px solid white; border-radius: 5px;padding:0.5%;">
			<i class="fas fa-reply"></i> Volver
		</button>
	</div>
</body>
</html>