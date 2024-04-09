<%-- 
    Document   : Login
    Created on : 6 abr. 2024, 0:54:53
    Author     : Antonio-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
      <style>
        body {
            font-family: Arial, sans-serif;
        }
        .login-container {
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .login-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input[type="text"],
        .form-group input[type="password"] {
            width: calc(100% - 10px);
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .form-group input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 3px;
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
        }
        .form-group input[type="submit"]:hover {
            background-color: #fff;
            color: #0056b3;
            outline: solid 2px #0056b3;
           font-weight: bold;
        }
    </style>
</head>
<body>

<div class="login-container">
    <h2>Login</h2>
    <form action="/crud-noticias/FormRegister" method="POST">
        <div class="form-group">
            <label for="usuario">Usuario:</label>
            <input type="text" id="usuario" name="usuario" required>
        </div>
        <div class="form-group">
            <label for="contrasena">Contraseña:</label>
            <input type="password" id="contrasena" name="contrasena" required>
        </div>
        <div class="form-group">
            <input type="submit" value="Login" name="Login">
        </div>
    </form>
</div>
</html>
