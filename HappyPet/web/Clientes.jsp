<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Empleados</title>
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
            .card-header {
                border-top-left-radius: 10px;
                border-top-right-radius: 10px;
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
            .table th, .table td {
                vertical-align: middle;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 mb-4">
                    <div class="card">
                        <div class="card-header text-center bg-info text-white">
                            <h4><i class="fa fa-user-plus"></i> Registrar Clientes</h4>
                        </div>
                        <div class="card-body">
                            <form action="ControladorCliente?menu=Cliente" method="POST">
                                <input type="hidden" name="menu" value="Cliente" />
                                <input type="hidden" name="id" value="${cliente.getId_Cliente()}" />
                                <div class="form-group">
                                    <label for="dni">Dni</label>
                                    <input type="text" id="dni" name="txtDni" value="${cliente.getDni()}" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="nombre">Nombres</label>
                                    <input type="text" id="nombre" name="txtNombre" value="${cliente.getNombre()}" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="apellido">Apellido</label>
                                    <input type="text" id="apellido" name="txtApellido" value="${cliente.getApellido()}" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="direccion">Direccion</label>
                                    <input type="text" id="direccion" name="txtDireccion" value="${cliente.getDireccion()}" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="telefono">Telefono</label>
                                    <input type="text" id="telefono" name="txtTelefono" value="${cliente.getTelefono()}" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="correo">Correo Electronico</label>
                                    <input type="text" id="correo" name="txtCorreoElectronico" value="${cliente.getCorreoElectronico()}" class="form-control">
                                </div>
                                <div class="d-flex justify-content-between">
                                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                                    <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 mb-4">
                    <div class="card">
                        <div class="card-header text-center bg-info text-white">
                            <h4><i class="fa fa-list"></i> Lista de Empleados</h4>
                        </div>
                        <div class="card-body">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>ID_CLIENTE</th>
                                        <th>NOMBRE</th>
                                        <th>DNI</th>
                                        <th>APELLIDO</th>
                                        <th>DIRECCION</th>
                                        <th>TELEFONO</th>
                                        <th>CORREO</th>
                                        <th>ACCIONES</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="c" items="${clientes}">
                                        <tr>
                                            <td>${c.getId_Cliente()}</td>
                                            <td>${c.getNombre()}</td>
                                            <td>${c.getDni()}</td>
                                            <td>${c.getApellido()}</td>
                                            <td>${c.getDireccion()}</td>
                                            <td>${c.getTelefono()}</td>
                                            <td>${c.getCorreoElectronico()}</td>
                                            <td>
                                                <a class="btn btn-warning btn-sm mb-1" href="ControladorCliente?menu=Cliente&accion=Editar&id=${c.getId_Cliente()}">Editar</a>
                                                <a class="btn btn-danger btn-sm mb-1" href="ControladorCliente?menu=Cliente&accion=Delete&id=${c.getId_Cliente()}">Delete</a>
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
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>
</html>
