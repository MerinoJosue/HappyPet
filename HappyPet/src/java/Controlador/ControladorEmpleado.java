package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Anotación para definir el servlet y su URL de mapeo
@WebServlet(name = "ControladorEmpleado", urlPatterns = {"/ControladorEmpleado"})
public class ControladorEmpleado extends HttpServlet {

    Empleado em = new Empleado(); // Crea una instancia de Empleado
    EmpleadoDAO edao = new EmpleadoDAO(); // Crea una instancia de EmpleadoDAO para acceder a los métodos de la base de datos
    int ide; // Variable para almacenar el ID del empleado

    // Método para procesar las solicitudes tanto GET como POST
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtiene los parámetros 'menu' y 'accion' de la solicitud
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        System.out.println("Menú: " + menu + ", Acción: " + accion);

        // Verifica si el menú seleccionado es "Empleado"
        if (menu.equals("Empleado")) {
            // Verifica la acción seleccionada
            switch (accion) {
                case "Listar": // Caso para listar los empleados
                    List<Empleado> lista = edao.listar(); // Obtiene la lista de empleados
                    System.out.println("Número de empleados listados en el servlet: " + lista.size());
                    request.setAttribute("empleados", lista); // Establece la lista de empleados como un atributo de la solicitud
                    request.getRequestDispatcher("Empleados.jsp").forward(request, response); // Redirige a la página Empleados.jsp
                    break;

                case "Agregar": // Caso para agregar un nuevo empleado
                    String Dni = request.getParameter("txtDni"); // Obtiene el DNI del formulario
                    String Nom = request.getParameter("txtNom"); // Obtiene el nombre del formulario
                    String Tel = request.getParameter("txtTel"); // Obtiene el teléfono del formulario
                    String Estado = request.getParameter("txtEstado"); // Obtiene el estado del formulario
                    String User = request.getParameter("txtUser"); // Obtiene el usuario del formulario
                    // Establece los datos en el objeto Empleado
                    em.setDni(Dni);
                    em.setNom(Nom);
                    em.setTel(Tel);
                    em.setEstado(Estado);
                    em.setUser(User);
                    edao.agregar(em); // Agrega el empleado a la base de datos
                    request.getRequestDispatcher("ControladorEmpleado?menu=Empleado&accion=Listar").forward(request, response); // Redirige a la acción Listar
                    break;

                case "Editar": // Caso para editar un empleado existente
                    ide = Integer.parseInt(request.getParameter("id")); // Obtiene el ID del empleado a editar
                    Empleado e = edao.listarId(ide); // Obtiene el empleado de la base de datos por su ID
                    request.setAttribute("empleado", e); // Establece el empleado como un atributo de la solicitud
                    request.getRequestDispatcher("ControladorEmpleado?menu=Empleado&accion=Listar").forward(request, response); // Redirige a la acción Listar
                    break;

                case "Actualizar": // Caso para actualizar un empleado existente
                    // Obtiene los datos actualizados del formulario
                    String DniActualizar = request.getParameter("txtDni");
                    String NomActualizar = request.getParameter("txtNom");
                    String TelActualizar = request.getParameter("txtTel");
                    String EstadoActualizar = request.getParameter("txtEstado");
                    String UserActualizar = request.getParameter("txtUser");
                    // Crea un nuevo objeto Empleado con los datos actualizados
                    Empleado em = new Empleado(ide, DniActualizar, NomActualizar, TelActualizar, EstadoActualizar, UserActualizar);
                    edao.actualizar(em); // Actualiza el empleado en la base de datos
                    request.getRequestDispatcher("ControladorEmpleado?menu=Empleado&accion=Listar").forward(request, response); // Redirige a la acción Listar
                    break;

                case "Delete": // Caso para eliminar un empleado
                    ide = Integer.parseInt(request.getParameter("id")); // Obtiene el ID del empleado a eliminar
                    edao.delete(ide); // Elimina el empleado de la base de datos
                    request.getRequestDispatcher("ControladorEmpleado?menu=Empleado&accion=Listar").forward(request, response); // Redirige a la acción Listar
                    break;

                default: // Caso por defecto
                    request.getRequestDispatcher("Empleados.jsp").forward(request, response); // Redirige a la página Empleados.jsp
                    break;
            }
        }
    }

    // Método que maneja las solicitudes GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response); // Llama al método processRequest para manejar la solicitud
    }

    // Método que maneja las solicitudes POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response); // Llama al método processRequest para manejar la solicitud
    }

    // Método que proporciona una descripción corta del servlet
    @Override
    public String getServletInfo() {
        return "Controlador de Empleados"; // Descripción del servlet
    }
}
