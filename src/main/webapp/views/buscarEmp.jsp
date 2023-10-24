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
				<label for="empleados">Por qu� campo quieres buscar:</label> 
				<select id="empleados" name="choice">
					<option value="DNI">DNI</option>
					<option value="Nombre">Nombre</option>
					<option value="Sexo">Sexo</option>
					<option value="Categor�a">Categor�a</option>
					<option value="Anyos">Anyos</option>
				</select>
			</div>
			<div id="divBuscarEmp">
				Introduzca su b�squeda: <input type="text" name="busqueda"	placeholder="Escribe su b�squeda aqu�..." />
			</div>
			
			<div id="divBuscarEmp">
	     		<input type="submit" value="Buscar" />
	    	</div>
	    </form>
    </div>
</body>
</html>