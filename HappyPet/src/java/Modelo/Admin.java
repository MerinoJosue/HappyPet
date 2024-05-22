
package Modelo;

public class Admin {
    int Id_Admin;
    String Dni;
    String Nom;
    String Tel;
    String Estado;
    String User;

public Admin(){
    
}   
public Admin(int Id_Admin,String Dni,String Nom,String Tel, String Estado,String User){
    this.Id_Admin=Id_Admin;
    this.Dni=Dni;
    this.Nom=Nom;
    this.Tel=Tel;
    this.Estado=Estado;
    this.User=User;
}

    public int getId_Admin() {
        return Id_Admin;
    }

    public void setId_Admin(int Id_Admin) {
        this.Id_Admin = Id_Admin;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }
    
}
