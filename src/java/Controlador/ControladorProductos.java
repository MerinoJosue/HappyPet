/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import com.google.gson.Gson;
import Modelo.Productos;
import Modelo.ProductosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class ControladorProductos extends HttpServlet {

    Productos pr = new Productos();
    ProductosDAO pdao = new ProductosDAO();
    int pde;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Productos")) {
            switch (accion) {

                case "Listar":
                    List<Productos> lista = pdao.listar();
                    System.out.println("Número de productos listados en el servlet: " + lista.size());
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("Productos.jsp").forward(request, response);
                    break;

                case "Agregar":
                    String Nombre = request.getParameter("txtNombre");
                    String Precio = request.getParameter("txtPrecio");
                    String Stock = request.getParameter("txtStock");
                    String Estado = request.getParameter("txtEstado");
                    pr.setNombre(Nombre);
                    pr.setPrecio(Precio);
                    pr.setStock(Stock);
                    pr.setEstado(Estado);
                    pdao.agregar(pr);
                    request.getRequestDispatcher("ControladorProductos?menu=Productos&accion=Listar").forward(request, response);
                    break;

                case "Editar":

                    pde = Integer.parseInt(request.getParameter("id"));
                    Productos p = pdao.listarId(pde);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("ControladorProductos?menu=Productos&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String Nombre1 = request.getParameter("txtNombre");
                    String Precio1 = request.getParameter("txtPrecio");
                    String Stock1 = request.getParameter("txtStock");
                    String Estado1 = request.getParameter("txtEstado");
                    Productos pr = new Productos(pde, Nombre1, Precio1, Stock1, Estado1);
                    pdao.actualizar(pr);
                    request.getRequestDispatcher("ControladorProductos?menu=Productos&accion=Listar").forward(request, response);
                    break;

                case "GenerarPDF":
                    // Obtener la lista de productos
                    List<Productos> listaProductos = pdao.listar();
                    try {
                        response.setContentType("application/pdf");
                        response.setHeader("Content-Disposition", "attachment; filename=productos.pdf");
                        PrintWriter out = response.getWriter();
                        out.println("ID | Nombre | Precio | Stock | Estado");
                        for (Productos producto : listaProductos) {
                            out.println(producto.getId_Producto() + " | " + producto.getNombre() + " | " + producto.getPrecio() + " | " + producto.getStock() + " | " + producto.getEstado());
                        }
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case "Delete":
                    pde = Integer.parseInt(request.getParameter("id"));
                    pdao.delete(pde);
                    request.getRequestDispatcher("ControladorProductos?menu=Productos&accion=Listar").forward(request, response);
                    break;
                default:
                    request.getRequestDispatcher("ControladorProductos?menu=Productos&accion=Listar").forward(request, response);
            }
            System.out.println("");

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

        processRequest(request, response);
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
