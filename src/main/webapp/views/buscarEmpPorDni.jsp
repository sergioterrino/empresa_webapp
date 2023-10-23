<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscar empleado por DNI</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
</head>
<body>
	<div class="container">
		<h1>Buscar empleado por DNI</h1>
		<form action="empleados?opcion=buscarEmpPorDni" method="post">
			DNI del Empleado: <input type="text" name="dni"
				placeholder="Escribe el DNI aquí..." />
			<p>
				<input type="submit" value="Buscar" />
			</p>
		</form>
	</div>
</body>
</html>
