/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USER
 */
public class Mascota {
    
    String   Id_Mascota;
    String   cliente;
    String   Nombre;
    String   Especie;
    String   Raza;
    String   Edad;
    String   Sexo;    
    
    public Mascota(){}

    public Mascota(String ID_Mascota, String cliente, String Nombre, String Especie, String Raza, String Edad, String Sexo) {
        this.Id_Mascota = ID_Mascota;
        this.cliente = cliente;
        this.Nombre = Nombre;
        this.Especie = Especie;
        this.Raza = Raza;
        this.Edad = Edad;
        this.Sexo = Sexo;
    }

    public String getId_Mascota() {
        return Id_Mascota;
    }

    public void setId_Mascota(String ID_Mascota) {
        this.Id_Mascota = ID_Mascota;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEspecie() {
        return Especie;
    }

    public void setEspecie(String Especie) {
        this.Especie = Especie;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String Raza) {
        this.Raza = Raza;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    

    
}
