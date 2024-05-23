package Controlador;

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
 * Servlet controlador para gestionar las operaciones CRUD de productos.
 */
public class ControladorProductos extends HttpServlet {

    Productos pr = new Productos(); // Instancia del modelo Productos
    ProductosDAO pdao = new ProductosDAO(); // Instancia del DAO para interactuar con la base de datos
    int pde; // Variable para almacenar el ID del producto

    // Método para procesar las solicitudes tanto GET como POST
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtiene los parámetros 'menu' y 'accion' de la solicitud
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        // Verifica si el menú seleccionado es "Productos"
        if (menu.equals("Productos")) {
            // Verifica la acción seleccionada
            switch (accion) {
                case "Listar": // Caso para listar los productos
                    List<Productos> lista = pdao.listar(); // Obtiene la lista de productos
                    System.out.println("Número de productos listados en el servlet: " + lista.size());
                    request.setAttribute("productos", lista); // Establece la lista de productos como un atributo de la solicitud
                    request.getRequestDispatcher("Productos.jsp").forward(request, response); // Redirige a la página Productos.jsp
                    break;

                case "Agregar": // Caso para agregar un nuevo producto
                    // Obtiene los datos del producto del formulario
                    String Nombre = request.getParameter("txtNombre");
                    String Precio = request.getParameter("txtPrecio");
                    String Stock = request.getParameter("txtStock");
                    String Estado = request.getParameter("txtEstado");
                    // Establece los datos en el objeto Productos
                    pr.setNombre(Nombre);
                    pr.setPrecio(Precio);
                    pr.setStock(Stock);
                    pr.setEstado(Estado);
                    // Llama al método agregar del DAO para guardar el producto en la base de datos
                    pdao.agregar(pr);
                    // Redirige nuevamente al servlet para listar los productos actualizados
                    request.getRequestDispatcher("ControladorProductos?menu=Productos&accion=Listar").forward(request, response);
                    break;

                case "Editar": // Caso para editar un producto existente
                    // Obtiene el ID del producto a editar
                    pde = Integer.parseInt(request.getParameter("id"));
                    // Obtiene el producto de la base de datos por su ID
                    Productos p = pdao.listarId(pde);
                    // Establece el producto como un atributo de la solicitud
                    request.setAttribute("producto", p);
                    // Redirige nuevamente al servlet para listar los productos (incluyendo el producto a editar)
                    request.getRequestDispatcher("ControladorProductos?menu=Productos&accion=Listar").forward(request, response);
                    break;

                case "Actualizar": // Caso para actualizar un producto existente
                    // Obtiene los datos del producto del formulario
                    String Nombre1 = request.getParameter("txtNombre");
                    String Precio1 = request.getParameter("txtPrecio");
                    String Stock1 = request.getParameter("txtStock");
                    String Estado1 = request.getParameter("txtEstado");
                    // Crea una nueva instancia de Productos con los datos actualizados
                    Productos pr = new Productos(pde, Nombre1, Precio1, Stock1, Estado1);
                    // Llama al método actualizar del DAO para actualizar el producto en la base de datos
                    pdao.actualizar(pr);
                    // Redirige nuevamente al servlet para listar los productos actualizados
                    request.getRequestDispatcher("ControladorProductos?menu=Productos&accion=Listar").forward(request, response);
                    break;

                case "Delete": // Caso para eliminar un producto existente
                    // Obtiene el ID del producto a eliminar
                    pde = Integer.parseInt(request.getParameter("id"));
                    // Llama al método delete del DAO para eliminar el producto de la base de datos
                    pdao.delete(pde);
                    // Redirige nuevamente al servlet para listar los productos actualizados
                    request.getRequestDispatcher("ControladorProductos?menu=Productos&accion=Listar").forward(request, response);
                    break;

                default: // Caso por defecto, redirige a la página de listar productos
                    request.getRequestDispatcher("ControladorProductos?menu=Productos&accion=Listar").forward(request, response);
                    break;
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
