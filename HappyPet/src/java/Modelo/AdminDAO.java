package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Admin ValidarAdmin(String user, String dni) {
        Admin ad = new Admin();
        String sql = "SELECT * FROM admin WHERE User=? AND Dni=?";
        try {
            con = cn.Conexion();
            if (con != null) {
                System.out.println("Conexión establecida correctamente.");
            } else {
                System.out.println("Error: No se pudo establecer la conexión.");
            }
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                ad.setId_Admin(rs.getInt("Id_Admin"));
                ad.setUser(rs.getString("User"));
                ad.setDni(rs.getString("Dni"));
            }
            // Se cierran los recursos
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ad;
    }

    public List<Admin> listar() {
        String sql = "SELECT * FROM admin";
        List<Admin> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            if (con == null) {
                System.out.println("No se pudo establecer la conexión a la base de datos.");
                return lista;
            }
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Admin ad = new Admin();
                ad.setId_Admin(rs.getInt("Id_Admim"));
                ad.setDni(rs.getString("Dni"));
                ad.setNom(rs.getString("Nom"));
                ad.setTel(rs.getString("Tel"));
                ad.setEstado(rs.getString("Estado"));
                ad.setUser(rs.getString("User"));
                lista.add(ad);
            }
            System.out.println("Número de empleados recuperados: " + lista.size());
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }


    public Admin listarId(int id) {
        Admin ad = new Admin();
        String sql = "select * from admin where Id_Admin=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ad.setDni(rs.getString(2));
                ad.setNom(rs.getString(3));
                ad.setTel(rs.getString(4));
                ad.setEstado(rs.getString(5));
                ad.setUser(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return ad;
    }

    public int actualizar(Empleado em) {
        int resultado = 0;
        String sql = "UPDATE empleado SET Dni=?, Nom=?, Tel=?, Estado=?, User=? WHERE Id_Empleado=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.setInt(6, em.getId_Empleado());
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
        String sql = "DELETE FROM Admin WHERE Id_Admin=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
