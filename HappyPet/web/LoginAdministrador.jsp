<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Incluye la hoja de estilos de Bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
        <style>
            body {
                /* Configuración del fondo de la página */
                background-image: url('imagen/pexels-yfshoot-8813000.jpg');
                background-size: cover;
                background-position: center;
                height: 100vh; /* Establece el tamaño de la pantalla completa */
                display: flex;
                justify-content: flex-end; /* Alinea los elementos al extremo derecho */
                align-items: center; /* Centra verticalmente los elementos */
                padding-right: 50px; /* Añade un espacio a la derecha */
            }
            .logo-container {
                /* Posiciona el contenedor del logo en la esquina superior izquierda */
                position: absolute;
                top: 20px;
                left: 20px;
            }
            .login-container {
                /* Estilos del contenedor del formulario de inicio de sesión */
                display: flex;
                flex-direction: column;
                align-items: center;
                background-color: rgba(255, 255, 255, 0.8); /* Fondo semitransparente */
                padding: 20px;
                border-radius: 10px;
            }

            .welcome-text {
                /* Estilos para el texto de bienvenida */
                margin-bottom: 20px;
                text-align: center;
            }
        </style>
        <title>Document</title>
    </head>
    <body>

        <!-- Contenedor del logo -->
        <div class="logo-container">
            <!-- Enlace con el logo de HappyPet -->
            <a href="Principal.jsp">
                <img src="imagen/Logo.jpeg" alt="Logo HappyPet" width="100">
            </a>
        </div>

        <!-- Contenedor del formulario de inicio de sesión -->
        <div class="login-container">
            <!-- Texto de bienvenida -->
            <div class="welcome-text">
                <label>Bienvenidos(a) a HappyPet</label>
            </div>
            <!-- Formulario de inicio de sesión -->
            <div class="card col-sm-10">
                <div class="card-body">
                    <form class="form-sign" action="ValidarAdmin" method="POST">
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" name="txtuser" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Contraseña:</label>
                            <input type="password" name="txtpass" class="form-control">
                        </div>
                        <div class="card-body text-center">
                            <input type="submit" name="accion" value="Ingresar" class="btn btn-primary">
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Scripts de Bootstrap y Popper -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>
</html>
