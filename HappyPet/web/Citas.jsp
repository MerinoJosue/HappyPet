<%@page import="Modelo.MascotaDao"%>
<%@page import="Modelo.Mascota"%>
<%@page import="Modelo.Cliente"%>
<%@page import="Modelo.ClienteDao"%>
<%@page import="Modelo.Empleado"%>
<%@page import="Modelo.EmpleadoDAO"%>
<%@page import="Modelo.CitaDAO"%>
<%@page import="Modelo.Cita"%>
<%@page import="java.util.List"%>
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
    <div class="container">
        <div class="row">
           <div class="col-md-4 mb-4">
                    <div class="card">
                        <div class="card-header text-center bg-info text-white">
                            <h4><i class="fa fa-user-plus"></i>    Gestión de citas</h4>
                        </div>
                        <div class="card-body">
                            <form action="ControladorCita?menu=Cita"method="POST">
                                <div class="form-group">
                                    <label>Día de la cita</label>
                                    <input type="date" name="txtFecha" class="form-control">
                                </div>

                                <br>

                                <div class=form-group">
                                    <label>Hora</label>
                                    <input type="time"  name="txtHora"  class="form-control">
                                </div>

                                <br>

                                <%
                                    EmpleadoDAO edao = new EmpleadoDAO();
                                    List<Empleado> listaEmp = edao.listar();
                                    request.setAttribute("empleados", listaEmp);

                                    ClienteDao cldao = new ClienteDao();
                                    List<Cliente> listaCliente = cldao.listar();
                                    request.setAttribute("clientes", listaCliente);

                                    MascotaDao mcdao = new MascotaDao();
                                    List<Mascota> listaMascota = mcdao.Listar();
                                    request.setAttribute("mascotas", listaMascota);
                                %>

                                <div class="form-group">
                                    <label for="empleados">Veterinario encargado</label>
                                    <select name="empleados" id="empleados" class="form-select">
                                        <c:forEach var="em" items="${empleados}">
                                            <option value="${em.id_Empleado}">
                                                ${em.nom}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <br>

                                <div class="form-group">
                                    <label for="cliente">Cliente</label>
                                    <select name="cliente" id="cliente" class="form-select">
                                        <c:forEach var="em" items="${clientes}">
                                            <option value="${em.id_Cliente}">
                                                ${em.nombre}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <br>

                                <div class="form-group">
                                    <label for="mascota">Mascota</label>
                                    <select name="mascotas" id="mascotas" class="form-select">
                                        <c:forEach var="em" items="${mascotas}">
                                            <option value="${em.id_Mascota}">
                                                ${em.nombre}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>                               

                                <br>

                                <div class=form-group">
                                    <label>Motivo</label>
                                    <input type="text"  name="txtMotivo"  class="form-control">
                                </div>

                                <br>

                                <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-8 mb-4">
                    <div class="card">
                        <div class="card-header text-center bg-info text-white">
                            <h4><i class="fa fa-list"></i>  INFORMACIÓN DE LA CITA</h4>
                        </div>

                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Fecha</th>
                                    <th scope="col">Hora</th>
                                    <th scope="col">Veterinario</th>
                                    <th scope="col">Cliente</th>
                                    <th scope="col">Mascota</th>   
                                    <th scope="col">Motivo</th>   
                                    <th scope="col"></th>   
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="em" items="${citas}">
                                    <tr>
                                        <th class="align-middle" name="Id_Cita" scope="row">${em.id_Cita}</th>
                                        <td class="align-middle">${em.fecha}</td>
                                        <td class="align-middle">${em.hora}</td>
                                        <td class="align-middle">${em.empleado}</td>
                                        <td class="align-middle">${em.cliente}</td>
                                        <td class="align-middle">${em.mascota}</td>
                                        <td class="align-middle">${em.motivo}</td>
                                        <td class="align-middle">
                                            <button type="button" class="btn btn-warning">
                                                <i class="fas fa-pencil"></i>
                                            </button>
                                            <a class="btn btn-danger" href="ControladorCita?menu=Cita&accion=Delete"><i class="fas fa-trash"></i></a>

                                        </td>
                                    </tr>
                                </c:forEach>                                        
                            </tbody>
                        </table>
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
