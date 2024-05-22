<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario de Productos</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.6/css/jquery.dataTables.min.css">
    <style>
         body {
            background-image: url('imagen/pexels-yfshoot-8813000.jpg'); /* Ruta de tu imagen de fondo */
            background-size: cover; /* Ajustar la imagen al tamaño del contenedor */
            background-repeat: no-repeat; /* Evitar la repetición de la imagen */
            background-position: center; /* Centrar la imagen */
            background-attachment: fixed; /* Fijar la imagen para que no se desplace con el contenido */
            background-color: #f8f9fa; /* Color de fondo de respaldo */
        }
        .container {
            margin-top: 50px;
        }
        .card {
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            border-radius: 10px;
            background-color: rgba(255, 255, 255, 0.8); /* Fondo blanco semitransparente */
        }
        .card-header {
            background-color: rgba(23, 162, 184, 0.8) !important; /* Fondo semitransparente */
            color: #fff;
            border-radius: 10px 10px 0 0;
        }
        .form-control, .btn {
            border-radius: 5px;
            font-weight: bold;
        }
        .table th, .table td {
            background-color: rgba(255, 255, 255, 0.8) !important; /* Fondo blanco semitransparente */
        }
        .table th {
            font-weight: bold;
        }
        .table-container {
            max-height: 400px; /* Puedes ajustar esta altura según sea necesario */
            overflow-y: auto;
        }
    </style>
</head>
<body>
   <div class="logo-container">
        <a href="PrincipalEmp.jsp">
            <img src="imagen/Logo.jpeg" alt="Logo HappyPet" width="100">
        </a>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6 mb-4">
                <div class="card">
                    <div class="card-header text-center">
                        <h4><i class="fa fa-user-plus"></i> Registrar Producto</h4>
                    </div>
                    <div class="card-body">
                        <form action="ControladorProductos?menu=Productos" method="POST">
                            <input type="hidden" name="menu" value="Productos" />
                            <input type="hidden" name="id" value="${producto.getId_Producto()}" />
                            <div class="form-group">
                                <label>Nombre</label>
                                <input type="text" value="${producto.getNombre()}" name="txtNombre" class="form-control">
                            </div> 
                            <div class="form-group">
                                <label>Precio</label>
                                <input type="text" value="${producto.getPrecio()}" name="txtPrecio" class="form-control">
                            </div> 
                            <div class="form-group">
                                <label>Stock</label>
                                <input type="text" value="${producto.getStock()}" name="txtStock" class="form-control">
                            </div> 
                            <div class="mb-3">
                                <label>Estado</label>
                                <input type="text" value="${producto.getEstado()}" name="txtEstado" class="form-control">
                            </div>
                            <div class="text-center">
                                <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                                <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Lista de Productos -->
            <div class="col-lg-6 col-md-6 mb-4">    
                <div class="card">
                    <div class="card-header text-center">
                        <h4><i class="fa fa-list"></i> Lista de Productos</h4>
                    </div>
                    <div class="card-body">
                        <div class="table-container">
                            <table id="tablaEmpleados" class="table">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nombre</th>
                                        <th>Precio</th>
                                        <th>Stock</th>
                                        <th>Estado</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="pr" items="${productos}">
                                        <tr>
                                            <td>${pr.getId_Producto()}</td>
                                            <td>${pr.getNombre()}</td>
                                            <td>${pr.getPrecio()}</td>
                                            <td>${pr.getStock()}</td>
                                            <td>${pr.getEstado()}</td>
                                            <td>
                                                <!-- Botones de acciones -->
                                                <a class="btn btn-warning" href="ControladorProductos?menu=Productos&accion=Editar&id=${pr.getId_Producto()}">Editar</a>
                                                <a class="btn btn-warning" href="ControladorProductos?menu=Productos&accion=Delete&id=${pr.getId_Producto()}">Eliminar</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Scripts -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.datatables.net/1.11.6/js/jquery.dataTables.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#tablaEmpleados').DataTable({
                "scrollY": "400px",  // Ajusta la altura del scroll
                "scrollCollapse": true,
                "paging": false  // Desactiva la paginación si no la necesitas
            });
        });
    </script>
</body>
</html>
