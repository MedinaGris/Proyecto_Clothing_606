/*   Author: Griselda Medina Avendaño
    Creado : 8 mar 2022
    Actualización: 
    Descripción:
*/
package bd;


import java.sql.*;


public class Conexion {
    private Connection connection=null;
    private final String url;
    private final String user;
    private final String pwd;

    
     public Conexion(String user, String pwd,String url ) {
        this.user= user;
        this.pwd= pwd;
        this.url= url;
     
    }
     
     public Conexion(){
        user= "postgres";
        pwd= "medinagris";
        url="jdbc:postgresql://localhost/bdclothing";   
    }
     
  

    public void conectar() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");

            } catch (ClassNotFoundException ex) {
                throw new SQLException(ex);
            }
            connection = DriverManager.getConnection(url, user, pwd);
            System.out.println("conexion establecida");
        }
       
    }

    public void desconectar() throws SQLException {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
            System.out.println("Conexión cerrada");
        } catch (Exception ex) {
            throw new SQLException(ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        Conexion c= new Conexion();
        c.conectar();
        c.desconectar();      
    }
    
    
   
}
