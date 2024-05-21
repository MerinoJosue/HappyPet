package Modelo;

import Conexion.Conexion;
import Modelo.Cita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Cita buscar(int ID_Cita) {
        Cita c = new Cita();
        String sql = "SELECT c.ID_Cita,cl.nombre,m.Nombre,e.Nom,c.Fecha,c.Hora,c.Motivo"
                + "FROM citas AS c"
                + "left join cliente cl"
                + "on c.ID_Cliente = cl.Id_Cliente"
                + "left join mascotas m"
                + "on c.ID_Mascota = m.ID_Mascota"
                + "left join empleado e"
                + "on c.ID_Empleado = e.Id_Empleado where c.ID_Cita=" + ID_Cita;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId_Cita(rs.getInt(1));
                c.setCliente(rs.getString(2));
                c.setMascota(rs.getString(3));
                c.setEmpleado(rs.getString(4));
                c.setFecha(rs.getString(5));
                c.setHora(rs.getString(6));
                c.setMotivo(rs.getString(7));
            }
        } catch (Exception e) {
        }
        return c;
    }

    public List<Cita> listar() {
        String sql = "SELECT c.ID_Cita,cl.nombre,m.Nombre,e.Nom,c.Fecha,c.Hora,c.Motivo"
                + " FROM citas AS c"
                + " left join cliente cl"
                + " on c.ID_Cliente = cl.Id_Cliente"
                + " left join mascotas m"
                + " on c.ID_Mascota = m.ID_Mascota"
                + " left join empleado e"
                + " on c.ID_Empleado = e.Id_Empleado";
        List<Cita> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            if (con == null) {
                System.out.println("No se pudo establecer la conexión a la base de datos.");
                return lista;
            }
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cita c = new Cita();
                c.setId_Cita(rs.getInt(1));
                c.setCliente(rs.getString(2));
                c.setMascota(rs.getString(3));
                c.setEmpleado(rs.getString(4));
                c.setFecha(rs.getString(5));
                c.setHora(rs.getString(6));
                c.setMotivo(rs.getString(7));
                lista.add(c);
            }
            System.out.println(lista);
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
        }
        return lista;
    }

    public int agregar(Cita c) {
        String sql = "INSERT INTO citas(ID_Cliente, ID_Mascota, ID_Empleado, Fecha, Hora, Motivo)values(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(c.getCliente()));
            ps.setInt(2, Integer.parseInt(c.getMascota()));
            ps.setInt(3, Integer.parseInt(c.getEmpleado()));
            ps.setString(4, c.getFecha());
            ps.setString(5, c.getHora());
            ps.setString(6, c.getMotivo());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public int actulizar(Cita c) {
        String sql = "UPDATE citas ID_Cliente=?,ID_Mascota=?,ID_Empleado=?,Fecha=?,Hora=?,Motivo=? WHERE ID_Cita=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getCliente());
            ps.setString(2, c.getMascota());
            ps.setString(3, c.getEmpleado());
            ps.setString(4, c.getFecha());
            ps.setString(5, c.getHora());
            ps.setString(6, c.getMotivo());
            ps.setInt(8, c.getId_Cita());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public void delete(int id) {
        String sql = "delete from citas where ID_Cita=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
