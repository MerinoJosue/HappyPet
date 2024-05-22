<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <style>
        body {
            background-image: url('imagen/pexels-magda-ehlers-pexels-5958807.jpg');
            background-size: cover;
            background-position: center;
            height: 100vh;
            display: flex;
            justify-content: flex-end;
            align-items: center;
            padding-right: 50px;
        }

        .logo-container {
            position: absolute;
            top: 20px;
            left: 20px;
        }

        .login-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            background-color: rgba(255, 255, 255, 0.8);
            padding: 20px;
            border-radius: 10px;
        }

        .welcome-text {
            margin-bottom: 20px;
            text-align: center;
        }
    </style>
    <title>Document</title>
</head>
<body>

    <div class="logo-container">
        <a href="Inicio.jsp">
            <img src="imagen/Logo.jpeg" alt="Logo HappyPet" width="100">
        </a>
    </div>

    <div class="login-container">
        <div class="welcome-text">
            <label>Bienvenidos(a) a HappyPet</label>
        </div>
        <div class="card col-sm-10">
            <div class="card-body">
                <form class="form-sign" action="Validar" method="POST">
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

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>
