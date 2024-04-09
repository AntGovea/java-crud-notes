<%-- 
    Document   : CapturaNoticias
    Created on : 7 abr. 2024, 22:48:50
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
        .form-container {
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .form-container h2 {
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
        .form-group textarea {
            width: calc(100% - 10px);
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .form-group textarea {
            height: 100px;
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
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <div class="form-container">
        <h2>Notas castores</h2>
        <form action="tu_script_de_procesamiento" method="POST">
            <div class="form-group">
                <label for="titulo">Título:</label>
                <input type="text" id="titulo" name="titulo" required>
            </div>
            <div class="form-group">
                <label for="descripcion">Descripción:</label>
                <textarea id="descripcion" name="descripcion" required></textarea>
            </div>
            <div class="form-group">
                <input type="submit" value="Publicar nota">
            </div>
        </form>
    </div>

</body>
</html>
