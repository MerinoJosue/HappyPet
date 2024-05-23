/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet para redireccionar a diferentes páginas según la acción solicitada.
 * Autor: Ionic
 */
public class Redireccionar extends HttpServlet {

    /**
     * Procesa las solicitudes tanto GET como POST.
     * @param request la solicitud HttpServletRequest
     * @param response la respuesta HttpServletResponse
     * @throws ServletException si ocurre un error específico del servlet
     * @throws IOException si ocurre un error de I/O
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Este método puede ser utilizado para procesamiento común entre GET y POST
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        // En el caso de GET, actualmente no se realiza ninguna acción específica
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtiene el parámetro "accion" de la solicitud
        String accion = request.getParameter("accion");

        // Redirige a la página correspondiente según el valor de "accion"
        if ("Empleado".equals(accion)) {
            response.sendRedirect("PrincipalEmp.jsp");
        } else if ("Admin".equals(accion)) {
            response.sendRedirect("Principal.jsp");
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
