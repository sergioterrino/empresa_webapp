<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buscar Empleado</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
</head>
<body>
	<div class="container">
		<h1>Buscar Empleado</h1>
		<form action="empleados?opcion=buscarEmp" method="post"> 
			<div id="divBuscarEmp">
				<label for="empleados">Por qué campo quieres buscar:</label> 
				<select id="empleados" name="choice">
					<option value="DNI">DNI</option>
					<option value="Nombre">Nombre</option>
					<option value="Sexo">Sexo</option>
					<option value="Categoría">Categoría</option>
					<option value="Anyos">Anyos</option>
				</select>
			</div>
			<div id="divBuscarEmp">
				Introduzca su búsqueda: <input type="text" name="busqueda"	placeholder="Escribe su búsqueda aquí..." />
			</div>
			
			<div id="divBuscarEmp">
	     		<input type="submit" value="Buscar" />
	    	</div>
	    </form>
    </div>
</body>
</html>