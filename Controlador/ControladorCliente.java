
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
 * Servlet implementation class ControladorCliente
 */
public class ControladorCliente extends HttpServlet {

    Cliente c = new Cliente(); // Crea una instancia de Cliente
    ClienteDao cdao = new ClienteDao(); // Crea una instancia de ClienteDao para acceder a los métodos de la base de datos
    int cde; // Variable para almacenar el ID del cliente

    // Método para procesar las solicitudes tanto GET como POST
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu"); // Obtiene el parámetro 'menu' de la solicitud
        String accion = request.getParameter("accion"); // Obtiene el parámetro 'accion' de la solicitud

        switch (accion) { // Verifica la acción seleccionada
            case "Listar": // Caso para listar los clientes
                List<Cliente> lista = cdao.listar(); // Obtiene la lista de clientes
                System.out.println("Número de cliente listados en el servlet: " + lista.size());
                request.setAttribute("clientes", lista); // Establece la lista de clientes como un atributo de la solicitud
                request.getRequestDispatcher("Clientes.jsp").forward(request, response); // Redirige a la página Clientes.jsp
                break;
            case "Agregar": // Caso para agregar un nuevo cliente
                String Nom = request.getParameter("txtNombre"); // Obtiene el nombre del formulario
                String Dni = request.getParameter("txtDni"); // Obtiene el DNI del formulario
                String Ape = request.getParameter("txtApellido"); // Obtiene el apellido del formulario
                String Dire = request.getParameter("txtDireccion"); // Obtiene la dirección del formulario
                String Tel = request.getParameter("txtTelefono"); // Obtiene el teléfono del formulario
                String Cor = request.getParameter("txtCorreoElectronico"); // Obtiene el correo electrónico del formulario
                c.setNombre(Nom); // Establece el nombre en el objeto Cliente
                c.setDni(Dni); // Establece el DNI en el objeto Cliente
                c.setApellido(Ape); // Establece el apellido en el objeto Cliente
                c.setDireccion(Dire); // Establece la dirección en el objeto Cliente
                c.setTelefono(Tel); // Establece el teléfono en el objeto Cliente
                c.setCorreoElectronico(Cor); // Establece el correo electrónico en el objeto Cliente
                cdao.agregar(c); // Agrega el cliente a la base de datos
                request.getRequestDispatcher("ControladorCliente?menu=Cliente&accion=Listar").forward(request, response); // Redirige a la acción Listar
                break;
            case "Actualizar": // Caso para actualizar un cliente existente
                String Nom1 = request.getParameter("txtNombre"); // Obtiene el nombre del formulario
                String Dni1 = request.getParameter("txtDni"); // Obtiene el DNI del formulario
                String Ape1 = request.getParameter("txtApellido"); // Obtiene el apellido del formulario
                String Dire1 = request.getParameter("txtDireccion"); // Obtiene la dirección del formulario
                String Tel1 = request.getParameter("txtTelefono"); // Obtiene el teléfono del formulario
                String Cor1 = request.getParameter("txtCorreoElectronico"); // Obtiene el correo electrónico del formulario
                Cliente c = new Cliente(cde, Nom1, Dni1, Ape1, Dire1, Tel1, Cor1); // Crea un nuevo objeto Cliente con los datos actualizados
                cdao.actualizar(c); // Actualiza el cliente en la base de datos
                request.getRequestDispatcher("ControladorCliente?menu=Cliente&accion=Listar").forward(request, response); // Redirige a la acción Listar
                break;
            case "Editar": // Caso para editar un cliente existente
                cde = Integer.parseInt(request.getParameter("id")); // Obtiene el ID del cliente a editar
                Cliente c1 = cdao.listarId(cde); // Obtiene el cliente de la base de datos por su ID
                request.setAttribute("cliente", c1); // Establece el cliente como un atributo de la solicitud
                request.getRequestDispatcher("ControladorCliente?menu=Cliente&accion=Listar").forward(request, response); // Redirige a la acción Listar
                break;
            case "Delete": // Caso para eliminar un cliente
                cde = Integer.parseInt(request.getParameter("id")); // Obtiene el ID del cliente a eliminar
                cdao.delete(cde); // Elimina el cliente de la base de datos
                request.getRequestDispatcher("ControladorCliente?menu=Cliente&accion=Listar").forward(request, response); // Redirige a la acción Listar
                break;
            default:
                request.getRequestDispatcher("Clientes.jsp").forward(request, response); // Redirige a la página Clientes.jsp por defecto
                break;
        }
    }

    // Método que maneja las solicitudes GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response); // Llama al método processRequest para manejar la solicitud
    }

    // Método que maneja las solicitudes POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response); // Llama al método processRequest para manejar la solicitud
    }

    // Método que proporciona una descripción corta del servlet
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

