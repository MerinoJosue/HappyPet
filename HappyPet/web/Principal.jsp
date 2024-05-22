<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Veterinaria</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <header class="header">
            <div class="menu container">
                <a href="#" class="logo">Veterinaria</a>
                <input type="checkbox" id="menu"/>
                <label for="menu">
                    <img src="imagen/Perritos.png" class="menu-icono" alt=""/>
                </label>
                <nav class="navbar">
                    <ul class="navbar-nav" id="navbarNav">
                        <li class="nav-item"><a class="fa-sharp fa-solid fa-hospital-user" href="ControladorProductos?menu=Productos&accion=Listar">Productos</a></li>
                        <li class="nav-item"><a class="fa-solid fa-bed-pulse" href="ControladorCliente?menu=Cliente&accion=Listar">Clientes</a></li>
                        <li class="nav-item"><a class="fa-solid fa-hospital" href="ControladorEmpleado?menu=Empleado&accion=Listar">Empleado</a></li>
                        <li class="nav-item"><a class="fa-solid fa-bed-pulse" href="Controlador?menu=RegistrarVenta">Nueva Venta</a></li>
                        <li class="nav-item"><a class="fa-solid fa-phone" href="ControladorServicios?menu=Servicios">Servicios</a></li>
                        <li class="nav-item"><a class="fa-solid fa-envelope" href="ControladorCita?menu=Cita&accion=Listar">Registrar Cita</a></li>
                    </ul>
                </nav>
            </div>
            <div class="header-content container">
                <div class="header-txt">
                    <h1>Centro de Veterinaria</h1>
                </div>
                <div class="header-img">
                    <img src="imagen/pexels-jozef-feher-356581-2774140.jpg" alt=""/>
                   
                </div>
            </div>
        </header>
        <script>
            document.getElementById('menu').addEventListener('change', function () {
                var navbarNav = document.getElementById('navbarNav');
                if (this.checked) {
                    navbarNav.classList.add('active');
                } else {
                    navbarNav.classList.remove('active');
                }
            });
        </script>
    </body>
</html>
