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
        <form action="guardarCambios.jsp" method="post"> <!-- Reemplaza guardarCambios.jsp con tu página de guardado -->
            <label for="dni">DNI:</label>
            <input type="text" id="dni" name="dni" value="${empleado.dni}" readonly>
            
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" value="${empleado.nombre}">
            
            <label for="sexo">Sexo:</label>
            <input type="text" id="sexo" name="sexo" value="${empleado.sexo}">
            
            <label for="categoria">Categoría:</label>
            <input type="text" id="categoria" name="categoria" value="${empleado.categoria}">
            
            <label for="anyos">Años:</label>
            <input type="text" id="anyos" name="anyos" value="${empleado.anyos}">
            
            <button type="submit">Guardar Cambios</button>
        </form>
        
        <button onclick="history.back()" id="btnVolver">
            <i class="fas fa-reply"></i> Volver
        </button>
    </div>
</body>
</html>
