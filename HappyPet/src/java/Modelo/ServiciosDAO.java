package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServiciosDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public List<Servicios> listar() {
        String sql = "SELECT * FROM servicios";
        List<Servicios> lista = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = cn.Conexion();
            if (con == null) {
                System.out.println("No se pudo establecer la conexión a la base de datos.");
                return lista;
            }
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Servicios sv = new Servicios();
                sv.setId_Servicio(rs.getInt("Id_Servicio"));  // Asegúrate de que esta columna exista en tu BD
                sv.setNombre(rs.getString("nombre"));
                sv.setDescripcion(rs.getString("descripcion"));
                sv.setCosto(rs.getString("costo"));
                lista.add(sv);
            }

            System.out.println("Número de servicios recuperados: " + lista.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lista;
    }

    
    public int agregar(Servicios sv) {
        String sql = "insert into servicios(nombre, descripcion, costo)values(?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, sv.getNombre());
            ps.setString(2, sv.getDescripcion());
            ps.setString(3, sv.getCosto());
            ps.executeUpdate();

        } catch (Exception e) {

        }
        return r;
    }
    
    public Servicios listarId(int id) {
        Servicios svc = new Servicios();
        String sql = "select * from servicios where Id_Servicio=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                svc.setNombre(rs.getString(1));
                svc.setDescripcion(rs.getString(2));
                svc.setCosto(rs.getString(3));
            }
        } catch (Exception e) {
        }
        return svc;
    }

    public int actualizar(Servicios sv) {
        int resultado = 0;
        String sql = "UPDATE servicios SET nombre=?, descripcion=?, costo=? WHERE Id_Servicio=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, sv.getNombre());
            ps.setString(2, sv.getDescripcion());
            ps.setString(3, sv.getCosto());
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return resultado;
    }

    public void delete(int id) {
        String sql = "DELETE FROM Empleado WHERE Id_Empleado=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Aquí deberías cerrar los recursos (ps, con) para evitar posibles fugas de recursos
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
