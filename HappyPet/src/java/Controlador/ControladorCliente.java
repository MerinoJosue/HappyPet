/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class ControladorCliente extends HttpServlet {

    Cliente c = new Cliente();
    ClienteDao cdao = new ClienteDao();
    int cde;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        switch (accion) {
            case "Listar":
                List<Cliente> lista = cdao.listar();
                System.out.println("Número de cliente listados en el servlet: " + lista.size());
                request.setAttribute("clientes", lista);
                request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                break;
            case "Agregar":
                String Nom = request.getParameter("txtNombre");
                String Dni = request.getParameter("txtDni");
                String Ape = request.getParameter("txtApellido");
                String Dire = request.getParameter("txtDireccion");
                String Tel = request.getParameter("txtTelefono");
                String Cor = request.getParameter("txtCorreoElectronico");
                c.setNombre(Nom);
                c.setDni(Dni);
                c.setApellido(Ape);
                c.setDireccion(Dire);
                c.setTelefono(Tel);
                c.setCorreoElectronico(Cor);
                cdao.agregar(c);
                request.getRequestDispatcher("ControladorCliente?menu=Cliente&accion=Listar").forward(request, response);
                break;

            case "Actualizar":
                String Nom1 = request.getParameter("txtNombre");
                String Dni1 = request.getParameter("txtDni");
                String Ape1 = request.getParameter("txtApellido");
                String Dire1 = request.getParameter("txtDireccion");
                String Tel1 = request.getParameter("txtTelefono");
                String Cor1 = request.getParameter("txtCorreoElectronico");
                Cliente c = new Cliente(cde, Nom1, Dni1, Ape1, Dire1, Tel1, Cor1);
                cdao.actualizar(c);
                request.getRequestDispatcher("ControladorCliente?menu=Cliente&accion=Listar").forward(request, response);

                break;

            case "Editar":
                cde = Integer.parseInt(request.getParameter("id"));
                Cliente c1 = cdao.listarId(cde);
                request.setAttribute("cliente", c1);
                request.getRequestDispatcher("ControladorCliente?menu=Cliente&accion=Listar").forward(request, response);
                break;

            case "Delete":
                cde = Integer.parseInt(request.getParameter("id"));
                cdao.delete(cde);
                request.getRequestDispatcher("ControladorCliente?menu=Cliente&accion=Listar").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                break;
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
