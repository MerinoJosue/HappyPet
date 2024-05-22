

package Modelo;

public class Servicios {
    
    private int Id_Servicio;
    private String nombre;
    private String descripcion;
    private String costo;
    
    public Servicios(){
    }

    public Servicios(int Id_Servicio, String nombre, String descripcion, String costo) {
        this.Id_Servicio = Id_Servicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
    }


    public int getId_Servicio() {
        return Id_Servicio;
    }

    public void setId_Servicio(int Id_Servicio) {
        this.Id_Servicio = Id_Servicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }
    
    
    
}
