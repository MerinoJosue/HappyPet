/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Servicios;
import Modelo.ServiciosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ionic
 */
@WebServlet(name = "ControladorServicios", urlPatterns = {"/ControladorServicios"})
public class ControladorServicios extends HttpServlet {

    Servicios sv = new Servicios();
    ServiciosDAO sdao = new ServiciosDAO();
    int sde;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        System.out.println("Menú: " + menu + ", Acción: " + accion);

        if (menu.equals("Servicio")) {
            switch (accion) {
                case "Listar":
                    List<Servicios> lista = sdao.listar();
                    System.out.println("Número de servicios listados en el servlet: " + lista.size());
                    request.setAttribute("servicios", lista);
                    request.getRequestDispatcher("Servicios.jsp").forward(request, response);
                    break;

                case "Agregar":
                    String nom = request.getParameter("txtnombre");
                    String des = request.getParameter("txtdescripcion");
                    String cos = request.getParameter("txtcosto");
                    sv.setNombre(nom);
                    sv.setDescripcion(des);
                    sv.setCosto(cos);
                    sdao.agregar(sv);
                    request.getRequestDispatcher("ControladorServicios?menu=Servicio&accion=Listar").forward(request, response);
                    break;
                    
                case "Editar":
                    sde = Integer.parseInt(request.getParameter("id"));
                    Servicios s = sdao.listarId(sde);
                    request.setAttribute("servicios", s);
                    request.getRequestDispatcher("ControladorServicios?menu=Servicio&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String nom1 = request.getParameter("txtnombre");
                    String des1 = request.getParameter("txtdescripcion");
                    String cos1 = request.getParameter("txtcosto");
                    Servicios sv = new Servicios(sde, nom1, des1, cos1);
                    sdao.actualizar(sv);
                    request.getRequestDispatcher("ControladorServicios?menu=Servicio&accion=Listar").forward(request, response);

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
    }// </editor-fold>

}
