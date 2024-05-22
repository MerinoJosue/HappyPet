/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Servicios;
import Modelo.ServiciosDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet controlador para manejar las acciones relacionadas con los servicios.
 * Autor: Ionic
 */
@WebServlet(name = "ControladorServicios", urlPatterns = {"/ControladorServicios"})
public class ControladorServicios extends HttpServlet {

    // Instancias de los modelos necesarios
    Servicios sv = new Servicios();
    ServiciosDAO sdao = new ServiciosDAO();
    int sde; // Variable para almacenar el id del servicio a editar

    /**
     * Procesa las solicitudes tanto GET como POST.
     * @param request la solicitud HttpServletRequest
     * @param response la respuesta HttpServletResponse
     * @throws ServletException si ocurre un error específico del servlet
     * @throws IOException si ocurre un error de I/O
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtiene los parámetros "menu" y "accion" de la solicitud
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        System.out.println("Menú: " + menu + ", Acción: " + accion);

        // Verifica si el menú es "Servicio"
        if (menu.equals("Servicio")) {
            switch (accion) {
                // Acción para listar los servicios
                case "Listar":
                    List<Servicios> lista = sdao.listar(); // Obtiene la lista de servicios desde la base de datos
                    System.out.println("Número de servicios listados en el servlet: " + lista.size());
                    request.setAttribute("servicios", lista); // Añade la lista de servicios a la solicitud
                    request.getRequestDispatcher("Servicios.jsp").forward(request, response); // Redirige a la página de servicios
                    break;

                // Acción para agregar un nuevo servicio
                case "Agregar":
                    String nom = request.getParameter("txtnombre"); // Obtiene el nombre del servicio del formulario
                    String des = request.getParameter("txtdescripcion"); // Obtiene la descripción del servicio del formulario
                    String cos = request.getParameter("txtcosto"); // Obtiene el costo del servicio del formulario
                    sv.setNombre(nom);
                    sv.setDescripcion(des);
                    sv.setCosto(cos);
                    sdao.agregar(sv); // Agrega el nuevo servicio a la base de datos
                    request.getRequestDispatcher("ControladorServicios?menu=Servicio&accion=Listar").forward(request, response); // Redirige a la acción de listar para actualizar la vista
                    break;
                    
                // Acción para editar un servicio existente
                case "Editar":
                    sde = Integer.parseInt(request.getParameter("id")); // Obtiene el id del servicio a editar
                    Servicios s = sdao.listarId(sde); // Obtiene el servicio desde la base de datos
                    request.setAttribute("servicios", s); // Añade el servicio a la solicitud
                    request.getRequestDispatcher("EditarServicio.jsp").forward(request, response); // Redirige al formulario de edición
                    break;

                // Acción para actualizar un servicio existente
                case "Actualizar":
                    String nom1 = request.getParameter("txtnombre"); // Obtiene el nombre actualizado del formulario
                    String des1 = request.getParameter("txtdescripcion"); // Obtiene la descripción actualizada del formulario
                    String cos1 = request.getParameter("txtcosto"); // Obtiene el costo actualizado del formulario
                    Servicios svActualizado = new Servicios(sde, nom1, des1, cos1); // Crea un nuevo objeto servicio con los datos actualizados
                    sdao.actualizar(svActualizado); // Actualiza el servicio en la base de datos
                    request.getRequestDispatcher("ControladorServicios?menu=Servicio&accion=Listar").forward(request, response); // Redirige a la acción de listar para actualizar la vista
                    break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

