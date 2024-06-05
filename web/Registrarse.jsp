<%-- 
    Document   : Registrarse
    Created on : 4 jun. 2024, 22:30:40
    Author     : Ionic
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register User</title>
    </head>
    <body>
        <h1>Register User</h1>
        <form action="RegisterServlet" method="post">
            <label for="nombreUsuario">Username:</label>
            <input type="text" id="nombreUsuario" name="nombreUsuario" required><br><br>
            
            <label for="clave">Password:</label>
            <input type="password" id="clave" name="clave" required><br><br>
            
            <label for="estado">State:</label>
            <input type="checkbox" id="estado" name="estado"><br><br>
            
            <input type="submit" value="Register">
        </form>
    </body>
</html>
