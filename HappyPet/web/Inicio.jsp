<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenido a HappyPet</title>
    <style>
        body {
            margin: 0;
            display: flex;
            justify-content: center;
            font-family: Arial, sans-serif;
            background-color: #f0f8ff; /* Color de fondo suave */
        }

        .back-img-container {
            position: relative;
            width: 900px;
            height: 600px;
            margin-bottom: 30px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            border-radius: 15px;
            overflow: hidden; /* Para que la imagen de fondo no se salga del contenedor */
        }
        .back-img {
            background-image: url('imagen/14.jpeg');
            background-repeat: no-repeat;
            background-size: cover; /* Mantener la imagen como estaba */
            width: 100%;
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column; /* Para centrar el contenido verticalmente */
        }
        .imagen-logo {
            background-image: url('imagen/logo.jpeg');
            background-repeat: no-repeat;
            background-size: contain;
            width: 200px;
            height: 100px;
            position: absolute;
            top: 20px;
            left: 20px;
        }
        .inicio {
            background-color: rgba(255, 255, 255, 0.8); /* Fondo blanco semitransparente */
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            text-align: center;
        }
        .inicio h1 {
            margin-bottom: 20px;
            color: #333;
        }
        .btn {
            background-color: #00bfff; /* Color de botón */
            color: white;
            padding: 15px 30px;
            border: none;
            margin: 10px;
            font-size: 18px;
            border-radius: 5px;
            text-decoration: none;
            display: inline-block;
            transition: background-color 0.3s ease;
        }
        .btn:hover {
            background-color: #008fbf; /* Color de botón al pasar el ratón por encima */
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="back-img-container">
            <div class="imagen-logo"></div>
            <div class="back-img">
                <div class="inicio">
                    <h1>Bienvenido(a) a HappyPet</h1>
                    <a href="LoginAdministrador.jsp" class="btn">Admin</a>
                    <a href="LoginEmpleado.jsp" class="btn">Empleado</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
