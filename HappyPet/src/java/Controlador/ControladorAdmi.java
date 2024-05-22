/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Admin;
import Modelo.AdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorAdmi extends HttpServlet {

    Admin ad = new Admin();
    AdminDAO adao = new AdminDAO();
    int ade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");

        String accion = request.getParameter("accion");

        if (accion != null) {
            String user = request.getParameter("txtUser");
            String dni = request.getParameter("txtDni");
            Admin adminValidado = adao.ValidarAdmin(user, dni);
            if (adminValidado != null) {
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
            } else {
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
                request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
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
