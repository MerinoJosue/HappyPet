/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USER
 */
public class Cita {
    int   Id_Cita;
    String  cliente;
    String  mascota;
    String empleado;
    String   Fecha;
    String   Hora;
    String   Motivo;
    
    public Cita(){}

    public Cita(int ID_Cita, String cliente, String mascota, String empleado, String Fecha, String Hora, String Motivo) {
        this.Id_Cita = ID_Cita;
        this.cliente = cliente;
        this.mascota = mascota;
        this.empleado = empleado;
        this.Fecha = Fecha;
        this.Hora = Hora;
        this.Motivo = Motivo;
    }

    public int getId_Cita() {
        return Id_Cita;
    }

    public void setId_Cita(int ID_Cita) {
        this.Id_Cita = ID_Cita;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

}