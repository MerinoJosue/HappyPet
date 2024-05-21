/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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
 *
 * @author USER
 */
public class ControladorCita extends HttpServlet {

    Cita c = new Cita();
    CitaDAO cdao = new CitaDAO();

       
    int cde;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        
        if (menu.equals("Cita")) {
             switch (accion) {
                                                
                case "Listar":
                    List<Cita> lista = cdao.listar();
                    System.out.println("Número de citas listadas en el servlet: " + lista.size());
                    request.setAttribute("citas", lista);
                    request.getRequestDispatcher("Citas.jsp").forward(request, response);
                    break;

                case "Agregar":
                    
                    String Fecha = request.getParameter("txtFecha");                                                                           
                    String Hora = request.getParameter("txtHora");
                    String Empleado = request.getParameter("empleados");
                    String Cliente = request.getParameter("cliente");
                    String Mascota = request.getParameter("mascotas");
                    String Motivo = request.getParameter("txtMotivo");
                    c.setFecha(Fecha);
                    c.setHora(Hora);
                    c.setEmpleado(Empleado);
                    c.setCliente(Cliente);
                    c.setMascota(Mascota);
                    c.setMotivo(Motivo);
                    cdao.agregar(c);
                    request.getRequestDispatcher("ControladorCita?menu=Cita&accion=Listar").forward(request, response);
                    break;

                case "Editar":
                 
                    break;
                case "Actualizar":
                   
                    break;
                case "Delete":
                    cde = Integer.parseInt(request.getParameter("Id_Cita"));
                    cdao.delete(cde);
                    System.out.println(cde);
                    request.getRequestDispatcher("ControladorCita?menu=Cita&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            
            request.getRequestDispatcher("Citas.jsp").forward(request, response);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        List<Cita> lista = cdao.listar();
        request.setAttribute("citas", lista);
                
        
                        
        RequestDispatcher dispatcher = request.getRequestDispatcher("Citas.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        /*String clienteSeleccionado = request.getParameter("clienteSeleccionado");
        List<Mascota> listaMascota = mcdao.listarxCliente(clienteSeleccionado);
        request.setAttribute("mascotas", listaMascota);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("Citas.jsp");
        dispatcher.forward(request, response);*/
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}