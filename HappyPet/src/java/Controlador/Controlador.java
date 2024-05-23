
package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Productos;
import Modelo.ProductosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Define la clase Controlador como un servlet y especifica la URL en la que responde
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    Empleado em = new Empleado(); // Crea una instancia de Empleado
    EmpleadoDAO edao = new EmpleadoDAO(); // Crea una instancia de EmpleadoDAO para acceder a los métodos de la base de datos
    int ide; // Variable para almacenar el ID del empleado
    
    // Método para procesar las solicitudes tanto GET como POST
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu"); // Obtiene el parámetro 'menu' de la solicitud
        String accion = request.getParameter("accion"); // Obtiene el parámetro 'accion' de la solicitud
        
        // Verifica si se ha recibido una acción
        if (accion != null) {
            // Obtiene los parámetros del formulario de inicio de sesión
            String user = request.getParameter("txtUser");
            String dni = request.getParameter("txtDni");
            // Valida las credenciales del empleado
            Empleado empleadoValidado = edao.Validar(user, dni);
            // Si las credenciales son válidas, redirige a la página principal del empleado
            if (empleadoValidado != null) {
                request.getRequestDispatcher("PrincipalEmp.jsp").forward(request, response);
            } else {
                // Si las credenciales no son válidas, redirige a la página de inicio de sesión
                request.getRequestDispatcher("LoginEmpleado.jsp").forward(request, response);
            }
        }

        // Verifica si la acción es 'Ingresar'
        if (accion.equalsIgnoreCase("Ingresar")) {
            // Obtiene el nombre de usuario y la contraseña del formulario
            String user = request.getParameter("txtuser");
            String pass = request.getParameter("txtpass");
            // Valida el usuario y la contraseña
            em = edao.Validar(user, pass);
            // Si el usuario es válido, redirige a la página Principal
            if (em.getUser() != null) {
                request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
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
        return "Short description";
    }// </editor-fold>

}
