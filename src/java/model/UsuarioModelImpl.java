
package model;
/*  
PROYECTO ACTUAL VALIDADO
Author: Griselda Medina Avendaño
    Creado : 8 mar 2022
    Actualización: 
    Descripción:
*/
import bd.Conexion;
import entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioModelImpl implements IUsuarioModel {

    private Conexion conexion;
    private Connection connection;
    private static Usuario usuario;



    @Override
    public void crearRegistro(Usuario usuario) {
        try{
            conexion = new Conexion();
            conexion.conectar();
            connection = conexion.getConnection();
            String sql = "INSERT INTO usuario (nombreUsuario,contraseña) VALUES (?,?)";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1,usuario.getNombreUsuario());
                statement.setString(2,usuario.getContraseña());
                statement.executeUpdate();
                System.out.println("insercion exitosa");
            }
            conexion.desconectar();
            
        }catch(SQLException e){
            System.out.println("Error al crear el registro: "+e.getMessage());
        }
    }

    @Override
    public void actualizarRegistro(Usuario usuario) {
        try {

            conexion = new Conexion();
            conexion.conectar();
            connection = conexion.getConnection();

            String sql = "update usuario set nombreUsuario=?, contraseña = ? where idUsuario=?";
            try ( PreparedStatement statement = connection.prepareStatement(sql)) {
                
                statement.setString(1, usuario.getNombreUsuario());
                statement.setString(2, usuario.getContraseña());
                statement.setInt(3, usuario.getcodigo());
                statement.executeUpdate();
                System.out.println("datos actualizados correctamente...");

            }
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("error:" + e.getMessage());
        }

    }

//    @Override
    public List<Usuario> obtenerRegistros() {
        List <Usuario> listaUsuario = null;
        try{
            ResultSet resultSet;
            listaUsuario = new ArrayList<>();
            conexion = new Conexion();
            conexion.conectar();
            connection = conexion.getConnection();
            String sql = "SELECT *FROM usuario";
            try ( PreparedStatement statement = connection.prepareStatement(sql)) {
                resultSet = statement.executeQuery();
                
                while(resultSet.next()){
                    Usuario usuario = new Usuario();
                    usuario.setcodigo(resultSet.getInt(1));
                    usuario.setNombreUsuario(resultSet.getString(2));
                    
                    listaUsuario.add(usuario);
                }
 
            }
            conexion.desconectar();
  
        }catch(SQLException e){
            System.out.println("error al eliminar el registro: "+e.getMessage());
            
        }
        return listaUsuario;
        
    }

    @Override
    public Usuario obtenerRegistro(int codigo) {
        Usuario usuario  = null;
        try{
            ResultSet resultSet;
            usuario =new Usuario();
            conexion = new Conexion();
            conexion.conectar();
            
            connection = conexion.getConnection();
            String sql = "SELECT *FROM usuario WHERE codigo = ?";
            try ( PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, codigo);
                resultSet = statement.executeQuery();
                
                while(resultSet.next()){
                    
                    usuario.setcodigo(resultSet.getInt(1));
                    usuario.setNombreUsuario(resultSet.getString(2));  
                }  
            }
            conexion.desconectar();
  
        }catch(SQLException e){
            System.out.println("error al eliminar el registro: "+e.getMessage());   
        }
         return usuario;    
    }



    
    @Override
    public void eliminarRegistro(int idUsuario) {
       try{
            conexion = new Conexion();
            conexion.conectar();
            connection = conexion.getConnection();
            
            String sql = "DELETE FROM usuario WHERE idUsuario=?";
            try ( PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1,idUsuario);
                statement.executeUpdate();
                System.out.println("registro eliminado");

            }
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("error al eliminar el registro:" + e.getMessage());
        }
           
       }
    
        
     public static void main(String[] args) {
        Usuario u = new Usuario();
        UsuarioModelImpl us= new UsuarioModelImpl();
        
        
        u.setContraseña("999");
        u.setNombreUsuario("Martha");
        u.setcodigo(9);  
        
        us.actualizarRegistro(u);
        us.eliminarRegistro(5);
  
        
        
        }
    
}
