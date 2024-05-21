/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

// Importaciones necesarias
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Definición de la clase del servlet
public class ControladorValidar extends HttpServlet {
    // Instancia de EmpleadoDAO para interactuar con la base de datos
    EmpleadoDAO edao = new EmpleadoDAO();
    // Instancia de Empleado para almacenar el resultado de la validación
    Empleado em = new Empleado();
    
    // Método para procesar las solicitudes HTTP
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String accion = request.getParameter("accion");
        
         if (accion != null && em.getUser() != null) {
                String user = request.getParameter("txtUser");
                String dni = request.getParameter("txtDni");
                Empleado empleadoValidado = edao.Validar(user, dni);
                if (empleadoValidado != null) {
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
         }
        
    }

    // Maneja las solicitudes HTTP GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Llama al método para procesar la solicitud
        processRequest(request, response);     
    }

    // Maneja las solicitudes HTTP POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Llama al método para procesar la solicitud
        // Obtiene el parámetro 'accion' del formulario
        String accion = request.getParameter("accion");
        // Verifica si la acción es 'Ingresar'
        if (accion.equalsIgnoreCase("Ingresar")) {
            // Obtiene el nombre de usuario y la contraseña del formulario
            String user = request.getParameter("txtuser");
            String pass = request.getParameter("txtpass");
            // Valida el usuario y la contraseña
            em = edao.Validar(user, pass);
            // Si el usuario es válido, redirige a la página Principal
            if (em.getUser() != null) {
                request.getRequestDispatcher("Controlador?accion=Principal").forward(request, response);
            } else { // Si el usuario no es válido, redirige a la página de inicio de sesión
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else { // Si la acción no es 'Ingresar', redirige a la página de inicio de sesión
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // Devuelve una descripción breve del servlet
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

