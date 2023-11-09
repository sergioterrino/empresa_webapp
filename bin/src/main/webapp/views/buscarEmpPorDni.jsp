<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscar empleado por DNI</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script src="https://kit.fontawesome.com/aac395d8de.js"></script>
</head>
<body>
	<div class="container" style="position: relative;">
		<h1>Buscar empleado por DNI</h1>
		<form action="empleados?opcion=buscarEmpPorDni" method="post">
			DNI del Empleado: <input type="text" name="dni" id="inputText"
				placeholder="Escribe el DNI aquí..."
				style="width: 10%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; margin: 10px 0;" />
			<div>
				<input type="submit" value="Buscar"/>
			</div>
		</form>
		<button onclick="history.back()" id="btnVolver"
			style="position: absolute; top: 3%; left: 1%; background-color: #3498db; color: white; font-weight: bold; border: 1px solid white; border-radius: 5px; padding: 0.5%;">
			<i class="fas fa-reply"></i> Volver
		</button>
	</div>
</body>
</html>
