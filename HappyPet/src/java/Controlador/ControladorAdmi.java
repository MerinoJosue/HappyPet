
package Controlador;

import Modelo.Admin;
import Modelo.AdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Define la clase ControladorAdmi como un servlet y especifica la URL en la que responde
@WebServlet(name = "ControladorAdmi", urlPatterns = {"/ControladorAdmi"})
public class ControladorAdmi extends HttpServlet {

    Admin ad = new Admin(); // Crea una instancia de Admin
    AdminDAO adao = new AdminDAO(); // Crea una instancia de AdminDAO para acceder a los métodos de la base de datos
    int ade; // Variable para almacenar el ID del administrador

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
            // Valida las credenciales del administrador
            Admin adminValidado = adao.ValidarAdmin(user, dni);
            // Si las credenciales son válidas, redirige a la página principal del administrador
            if (adminValidado != null) {
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
            } else {
                // Si las credenciales no son válidas, redirige a la página de inicio de sesión del administrador
                request.getRequestDispatcher("LoginAdministrador.jsp").forward(request, response);
            }
        }

        // Verifica si la acción es 'Ingresar'
        if (accion.equalsIgnoreCase("Ingresar")) {
            // Obtiene el nombre de usuario y la contraseña del formulario
            String user = request.getParameter("txtuser");
            String pass = request.getParameter("txtpass");
            // Valida el usuario y la contraseña
            ad = adao.ValidarAdmin(user, pass);
            // Si el usuario es válido, redirige a la página Principal
            if (ad.getUser() != null) {
                request.getRequestDispatcher("ControladorAdmi?menu=Principal").forward(request, response);
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
