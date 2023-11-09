<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestor de Empleados</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
</head>
<body>
	<div class="container">
		<h1>Gestor de Empleados</h1>
		<table class="menu" style="text-align:center;">
            <tr>
                <th colspan="3" style="text-align:center;">Menú</th>
            </tr>
            <tr>
                <td><a href="empleados?opcion=listar" class="button">Ver Empleados</a></td>
                <td><a href="empleados?opcion=buscarEmpPorDni" class="button">Buscar Empleado por Dni</a></td>
                <td><a href="empleados?opcion=buscarEmp" class="button">Buscar Empleado</a></td>
            </tr>
        </table>
	</div>
</body>
</html>