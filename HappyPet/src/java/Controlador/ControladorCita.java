package Controlador;

import Modelo.Empleado;
import Modelo.Cita;
import Modelo.CitaDAO;
import Modelo.Cliente;
import Modelo.ClienteDao;
import Modelo.EmpleadoDAO;
import Modelo.Mascota;
import Modelo.MascotaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControladorCita
 */
public class ControladorCita extends HttpServlet {

    Cita c = new Cita(); // Crea una instancia de Cita
    CitaDAO cdao = new CitaDAO(); // Crea una instancia de CitaDAO para acceder a los métodos de la base de datos
    int cde; // Variable para almacenar el ID de la cita

    // Método para procesar las solicitudes tanto GET como POST
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String menu = request.getParameter("menu"); // Obtiene el parámetro 'menu' de la solicitud
        String accion = request.getParameter("accion"); // Obtiene el parámetro 'accion' de la solicitud
        
        if (menu.equals("Cita")) { // Verifica si el menú seleccionado es "Cita"
            switch (accion) { // Verifica la acción seleccionada
                case "Listar": // Caso para listar las citas
                    List<Cita> lista = cdao.listar(); // Obtiene la lista de citas
                    System.out.println("Número de citas listadas en el servlet: " + lista.size());
                    request.setAttribute("citas", lista); // Establece la lista de citas como un atributo de la solicitud
                    request.getRequestDispatcher("Citas.jsp").forward(request, response); // Redirige a la página Citas.jsp
                    break;

                case "Agregar": // Caso para agregar una nueva cita
                    String Fecha = request.getParameter("txtFecha"); // Obtiene la fecha de la cita del formulario
                    String Hora = request.getParameter("txtHora"); // Obtiene la hora de la cita del formulario
                    String Empleado = request.getParameter("empleados"); // Obtiene el empleado de la cita del formulario
                    String Cliente = request.getParameter("cliente"); // Obtiene el cliente de la cita del formulario
                    String Mascota = request.getParameter("mascotas"); // Obtiene la mascota de la cita del formulario
                    String Motivo = request.getParameter("txtMotivo"); // Obtiene el motivo de la cita del formulario
                    c.setFecha(Fecha); // Establece la fecha en el objeto Cita
                    c.setHora(Hora); // Establece la hora en el objeto Cita
                    c.setEmpleado(Empleado); // Establece el empleado en el objeto Cita
                    c.setCliente(Cliente); // Establece el cliente en el objeto Cita
                    c.setMascota(Mascota); // Establece la mascota en el objeto Cita
                    c.setMotivo(Motivo); // Establece el motivo en el objeto Cita
                    cdao.agregar(c); // Agrega la cita a la base de datos
                    request.getRequestDispatcher("ControladorCita?menu=Cita&accion=Listar").forward(request, response); // Redirige a la acción Listar
                    break;

                case "Editar": // Caso para editar una cita (pendiente de implementación)
                    break;

                case "Actualizar": // Caso para actualizar una cita (pendiente de implementación)
                    break;

                case "Delete": // Caso para eliminar una cita
                    cde = Integer.parseInt(request.getParameter("Id_Cita")); // Obtiene el ID de la cita a eliminar
                    cdao.delete(cde); // Elimina la cita de la base de datos
                    System.out.println(cde);
                    request.getRequestDispatcher("ControladorCita?menu=Cita&accion=Listar").forward(request, response); // Redirige a la acción Listar
                    break;

                default:
                    throw new AssertionError(); // Lanza una excepción si la acción no es reconocida
            }

            request.getRequestDispatcher("Citas.jsp").forward(request, response); // Redirige a la página Citas.jsp
        }
        
        // Respuesta HTML de prueba (puede ser eliminada)
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorCita</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCita at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // Método que maneja las solicitudes GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Cita> lista = cdao.listar(); // Obtiene la lista de citas
        request.setAttribute("citas", lista); // Establece la lista de citas como un atributo de la solicitud
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("Citas.jsp"); // Redirige a la página Citas.jsp
        dispatcher.forward(request, response);
    }

    // Método que maneja las solicitudes POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response); // Llama al método processRequest para manejar la solicitud
        /*
        String clienteSeleccionado = request.getParameter("clienteSeleccionado");
        List<Mascota> listaMascota = mcdao.listarxCliente(clienteSeleccionado);
        request.setAttribute("mascotas", listaMascota);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("Citas.jsp");
        dispatcher.forward(request, response);
        */
    }

    // Método que proporciona una descripción corta del servlet
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
