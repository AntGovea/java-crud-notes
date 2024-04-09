<%-- 
    Document   : Register
    Created on : 6 abr. 2024, 0:03:14
    Author     : Antonio-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario de Registro</title>
</head>
<body>
    <h2>Formulario de Registro</h2>
    <form action="/crud-noticias/LoginController" method="POST">
          <label for="apePaterno">Apellido Paterno:</label>
        <input type="text" id="apePaterno" name="apePaterno" required><br><br>

        <label for="apeMaterno">Apellido Materno:</label>
        <input type="text" id="apeMaterno" name="apeMaterno" required><br><br>

        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br><br>

        <label for="direccion">Dirección:</label>
        <input type="text" id="direccion" name="direccion" required><br><br>

        <label for="usuario">Usuario:</label>
        <input type="text" id="usuario" name="usuario" required><br><br>

        <label for="contrasena">Contraseña:</label>
        <input type="password" id="contrasena" name="contrasena" required><br><br>

        <label for="tipoUsuario">Tipo de Usuario:</label>
        <select id="tipoUsuario" name="tipoUsuario" required>
            <option value="1">Interno</option>
            <option value="2">Externo</option>
        </select><br><br>

        <input type="submit" value="Registrar" name="action">
    </form>
</body>
</html>


