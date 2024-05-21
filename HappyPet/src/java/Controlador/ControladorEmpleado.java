package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorEmpleado", urlPatterns = {"/ControladorEmpleado"})
public class ControladorEmpleado extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    int ide;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        System.out.println("Menú: " + menu + ", Acción: " + accion);

        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List<Empleado> lista = edao.listar();
                    System.out.println("Número de empleados listados en el servlet: " + lista.size());
                    request.setAttribute("empleados", lista);
                    request.getRequestDispatcher("Empleados.jsp").forward(request, response);
                    break;

                case "Agregar":
                    String Dni = request.getParameter("txtDni");
                    String Nom = request.getParameter("txtNom");
                    String Tel = request.getParameter("txtTel");
                    String Estado = request.getParameter("txtEstado");
                    String User = request.getParameter("txtUser");
                    em.setDni(Dni);
                    em.setNom(Nom);
                    em.setTel(Tel);
                    em.setEstado(Estado);
                    em.setUser(User);
                    edao.agregar(em);
                    request.getRequestDispatcher("ControladorEmpleado?menu=Empleado&accion=Listar").forward(request, response);
                    break;

                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("ControladorEmpleado?menu=Empleado&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String DniActualizar = request.getParameter("txtDni");
                    String NomActualizar = request.getParameter("txtNom");
                    String TelActualizar = request.getParameter("txtTel");
                    String EstadoActualizar = request.getParameter("txtEstado");
                    String UserActualizar = request.getParameter("txtUser");
                    Empleado em = new Empleado(ide, DniActualizar, NomActualizar,
                    TelActualizar, EstadoActualizar, UserActualizar);
                    edao.actualizar(em);
                    request.getRequestDispatcher("ControladorEmpleado?menu=Empleado&accion=Listar").forward(request, response);

                    break;

                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("ControladorEmpleado?menu=Empleado&accion=Listar").forward(request, response);
                    break;

                default:
                    request.getRequestDispatcher("Empleados.jsp").forward(request, response);
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
        return "Controlador de Empleados";
    }
}
