
package service;

import entity.Usuario;
import java.util.List;

/*  

Author: Griselda Medina Avendaño
    Creado : 16 mar 2022
    Actualización: 
    Descripción:
*/

public interface IUsuarioService {
  
    public void crearRegistro(Usuario usuario);
    public void actualizarRegistro(Usuario usuario);
    public List<Usuario>obtenerRegistros();
    public Usuario obtenerRegistro(int idUsuario);

    public void eliminarRegistro(int idUsuario);


}
