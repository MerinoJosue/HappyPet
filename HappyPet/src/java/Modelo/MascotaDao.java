/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.Conexion;
import Modelo.Mascota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MascotaDao {
 
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List Listar(){
        String sql="select * from mascotas";
        List<Mascota>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Mascota m= new Mascota();
                m.setId_Mascota(rs.getString(1));
                m.setCliente(rs.getString(2));
                m.setNombre(rs.getString(3));
                m.setEspecie(rs.getString(4));
                m.setRaza(rs.getString(5));
                m.setEdad(rs.getString(6));
                m.setSexo(rs.getString(7));
                lista.add(m);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List listarxCliente(String Id_Cliente){
        String sql="select * from mascotas where ID_Cliente="+Id_Cliente;
        List<Mascota>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Mascota m= new Mascota();
                m.setId_Mascota(rs.getString(1));
                m.setCliente(rs.getString(2));
                m.setNombre(rs.getString(3));
                m.setEspecie(rs.getString(4));
                m.setRaza(rs.getString(5));
                m.setEdad(rs.getString(6));
                m.setSexo(rs.getString(7));
                lista.add(m);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    
}