<%-- 
    Document   : Inicio
    Created on : 21 may. 2024, 16:30:23
    Author     : Ionic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <style>
            body {
                margin: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                font-size: 20px;
            }

            .container {
                text-align: center;
                position: relative; /* Se añade posición relativa para permitir posicionamiento absoluto de los elementos hijos */
            }

            .back-img-container {
                position: relative; /* Se añade posición relativa para contener la imagen de fondo y el logo */
                width: 900px;
                height: 600px;
                margin-bottom: 30px;
            }

            .back-img {
                background-image: url("images/fullperros.jpeg");
                background-repeat: no-repeat;
                background-size: contain;
                width: 100%; /* Ancho relativo al contenedor */
                height: 100%; /* Altura relativa al contenedor */
            }

            .imagen-logo {
                background-image: url("images/logo.jpeg");
                background-repeat: no-repeat;
                background-size: contain;
                width: 500px;
                height: 75px;
                position: absolute; /* Se añade posición absoluta */
                top: 20px;
                left: 20px;
            }

            .btn{
                background-color: aqua;
                padding: 20px 0px;
                border: 0px;
                margin: 0 15px;
                font-size: 24px;
                width: 150px;
            }

            .inicio {
                padding: 30px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="back-img-container"> <!-- Contenedor para la imagen de fondo y el logo -->
                <div class="imagen-logo"></div> <!-- Logo -->
                <div class="back-img"> <!-- Imagen de fondo -->
                    <div class="inicio">
                        <h1>Bienvenido(a) a HappyPet</h1>
                        <input type="submit" name="accion" value="Empleado" class="btn btn-primary">
                        <input type="submit" name="accion" value="Administrador" class="btn btn-primary">
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
