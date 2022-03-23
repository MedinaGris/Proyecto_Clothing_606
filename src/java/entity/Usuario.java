
package entity;
/*   Author: Griselda Medina Avendaño
    Creado : 8 mar 2022
    Actualización: 
    Descripción:
*/
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.UsuarioModelImpl;


public class Usuario extends Persona{
    private int codigo;
    private String nombreUsuario;
    private String contraseña;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, String contraseña) {
        this.codigo= idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

   
    public int getcodigo() {
        return codigo;
    }

    public void setcodigo(int idUsuario) {
        this.codigo = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
//      public static void main(String[] args) throws SQLException {
//        Usuario u1=new Usuario();
//        u1.setcodigo(3);
//        u1.setNombreUsuario("griselda");
//        u1.setContraseña("medina");
//        
//        
//  
//        
//    }
    
    
}
