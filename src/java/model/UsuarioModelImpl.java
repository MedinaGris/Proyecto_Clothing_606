
package model;
/*  
PROYECTO ACTUAL VALIDADO
Author: Griselda Medina Avendaño
    Creado : 15 mar 2022
    Actualización: 16 marzo 2022
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
            String sql = "INSERT INTO usuario (nombreUsuario,contraseña, sexo, edad) VALUES (?,?,?,?)";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1,usuario.getNombreUsuario());
                statement.setString(2,usuario.getContraseña());
                statement.setString(3,usuario.getSexo());
                statement.setInt(4,usuario.getEdad());
                
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

            String sql = "update usuario set nombreUsuario=?, contraseña =?, sexo= ?, edad= ? where idUsuario=?";
            try ( PreparedStatement statement = connection.prepareStatement(sql)) {
                
                statement.setString(1, usuario.getNombreUsuario());
                statement.setString(2, usuario.getContraseña());
                statement.setString(3, usuario.getSexo());
                statement.setInt(4, usuario.getEdad());
                statement.setInt(5, usuario.getcodigo());
                
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
                    usuario.setContraseña(resultSet.getString(3));
                    usuario.setSexo(resultSet.getString(4));
                    usuario.setEdad(resultSet.getInt(5));
                    
                    listaUsuario.add(usuario);
                }
 
            }
            conexion.desconectar();
  
        }catch(SQLException e){
            System.out.println("error : "+e.getMessage());
            
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
            String sql = "SELECT *FROM usuario WHERE idUsuario = ?";
            try ( PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, codigo);
                resultSet = statement.executeQuery();
                
                while(resultSet.next()){
                    
                    usuario.setcodigo(resultSet.getInt(1));
                    usuario.setNombreUsuario(resultSet.getString(2));  
                    usuario.setContraseña(resultSet.getString(3));
                    usuario.setSexo(resultSet.getString(4));
                    usuario.setEdad(resultSet.getInt(5));
                }  
            }
            conexion.desconectar();
  
        }catch(SQLException e){
            System.out.println("No se encontro el registro: "+e.getMessage());   
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
    
        
//     public static void main(String[] args) {
//        Usuario u = new Usuario();
//        UsuarioModelImpl us= new UsuarioModelImpl();
//        
//        
////
////        us.actualizarRegistro(u);
////        us.eliminarRegistro(3);
//        
//        
////                Obtener registros
//        for (int i = 0; i < us.obtenerRegistros().size(); i++) {
//            System.out.println(us.obtenerRegistros().get(i).getcodigo());
//            System.out.println(us.obtenerRegistros().get(i).getNombreUsuario());
//            System.out.println(us.obtenerRegistros().get(i).getContraseña());  
//        }
//  
//        
//        
//        }
//    
     
     
     
}
