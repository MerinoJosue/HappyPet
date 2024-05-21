package Modelo;

public class Cliente {
    int Id_Cliente;
    String nombre;
    String dni;
    String apellido;
    String direccion;
    String telefono;
    String Correo;

    public Cliente(){
    }

    public Cliente(int Id_Cliente, String nombre, String dni, String apellido, String direccion, String telefono, String Correo) {
        this.Id_Cliente = Id_Cliente;
        this.nombre = nombre;
        this.dni = dni;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.Correo = Correo;
    }
    
    
    
    
    public int getId_Cliente() {return this.Id_Cliente;}
    public void setId_Cliente(int Id_Cliente) {this.Id_Cliente = Id_Cliente;}
    public String getNombre() {return this.nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getDni() {return this.dni;}
    public void setDni(String dni) {this.dni = dni;}
    public String getApellido() {return this.apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public String getDireccion() {return this.direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    public String getTelefono() {return this.telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public String getCorreoElectronico() {return this.Correo;}
    public void setCorreoElectronico(String CorreoElectronico) {this.Correo = CorreoElectronico;}

}
