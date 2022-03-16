
package model;
/*   Author: Griselda Medina Avendaño
    Creado : 8 mar 2022
    Actualización: 
    Descripción:
*/
import entity.Usuario;
import java.util.List;


public interface IUsuarioModel {
public void crearRegistro(Usuario usuario);
public void actualizarRegistro(Usuario usuario);
public List<Usuario>obtenerRegistros();
public Usuario obtenerRegistro(int idUsuario);

public void eliminarRegistro(int idUsuario);

}
