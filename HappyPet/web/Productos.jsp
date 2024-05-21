<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Formulario de Productos</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
        <style>
            body {
                background-color: #f8f9fa;
            }
            .container {
                margin-top: 50px;
            }
            .card {
                box-shadow: 0 4px 8px rgba(0,0,0,0.1);
                border-radius: 10px;
            }
            .card-body {
                padding: 30px;
            }
            .form-control {
                border-radius: 5px;
            }
            .btn {
                border-radius: 5px;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 mb-4">
                    <div class="card">
                        <div class="card-header text-center bg-info text-white">
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
                <div class="col-lg-6 col-md-6 mb-4">    
                    <div class="card">
                        <div class="card-header text-center bg-info text-white">
                            <h4><i class="fa fa-list"></i> Lista de Productos</h4>
                        </div>
                        <!-- Tabla ocupando 8 columnas en pantallas pequeñas -->
                        <div class="col-sm-7">
                            <table class="table table-hover">
                                <thead>
                                    <!-- Cabecera de la tabla -->
                                    <tr>
                                        <th>ID</th>
                                        <th>NOMBRE</th>
                                        <th>PRECIO</th>
                                        <th>STOCK</th>
                                        <th>ESTADO</th>
                                        <th>ACCIONES</th>
                                    </tr>
                                </thead>
                                <c:forEach var="pr" items="${productos}">
                                    <!-- Fila donde se mostraran los datos de la bd -->
                                    <tr>
                                        <td>${pr.getId_Producto()}</td>
                                        <td>${pr.getNombre()}</td>
                                        <td>${pr.getPrecio()}</td>
                                        <td>${pr.getStock()}</td>
                                        <td>${pr.getEstado()}</td>
                                        <td>
                                            <a class="btn btn-warning" href="ControladorProductos?menu=Productos&accion=Editar&id=${pr.getId_Producto()}">Editar</a>
                                            <a class="btn btn-warning" href="ControladorProductos?menu=Productos&accion=Delete&id=${pr.getId_Producto()}">Delete</a>
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
    <!-- Scripts de Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>