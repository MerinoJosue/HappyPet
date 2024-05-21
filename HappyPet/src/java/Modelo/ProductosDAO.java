/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.Conexion;
import Modelo.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductosDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Productos buscar(String Nombre) {
        Productos pr = new Productos();
        String sql = "select * from Productos where Nombre=" + Nombre;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pr.setId_Producto(rs.getInt(1));
                pr.setNombre(rs.getString(2));
                pr.setPrecio(rs.getString(3));
                pr.setStock(rs.getString(4));
                pr.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return pr;
    }

    public List listar() {
        String sql = "select * from Productos";
        List<Productos> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Productos pr = new Productos();
                pr.setId_Producto(rs.getInt(1));
                pr.setNombre(rs.getString(2));
                pr.setPrecio(rs.getString(3));
                pr.setStock(rs.getString(4));
                pr.setEstado(rs.getString(5));
                lista.add(pr);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int agregar(Productos pr) {
        String sql = "INSERT INTO Productos (Nombre, Precio, Stock, Estado) VALUES (?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNombre());
            ps.setString(2, pr.getPrecio());
            ps.setString(3, pr.getStock());
            ps.setString(4, pr.getEstado());
            r = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    

    public Productos listarId(int id) {
        Productos pro = new Productos();
        String sql = "select * from Productos where Id_Producto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro.setNombre(rs.getString(2));
                pro.setPrecio(rs.getString(3));
                pro.setStock(rs.getString(4));
                pro.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return pro;
    }

    public int actualizar(Productos pr) {
        int resultado = 0;
        String sql = "update Productos set  Nombre=?, Precio=?, Stock=?,Estado=? where Id_Producto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNombre());
            ps.setString(2, pr.getPrecio());
            ps.setString(3, pr.getStock());
            ps.setString(4, pr.getEstado());
            ps.setInt(5, pr.getId_Producto());
            resultado=ps.executeUpdate();

        } catch (Exception e) {
        }
        return resultado;
    }

    public void delete(int id) {
        String sql = "delete from Productos where Id_Producto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
