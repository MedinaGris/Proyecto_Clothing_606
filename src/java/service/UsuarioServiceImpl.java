
package service;

import entity.Usuario;
import java.util.List;
import model.IUsuarioModel;
import model.UsuarioModelImpl;

/*  

Author: Griselda Medina Avendaño
    Creado : 16 mar 2022
    Actualización: 
    Descripción:
*/
public class UsuarioServiceImpl implements IUsuarioService{ 
      IUsuarioModel modelo = new  UsuarioModelImpl();
    
    @Override
    public void crearRegistro(Usuario usuario) {
        modelo.crearRegistro(usuario);
    }

    @Override
    public void actualizarRegistro(Usuario usuario) {
        modelo.actualizarRegistro(usuario);
    }

    @Override
    public List<Usuario> obtenerRegistros() {
        return modelo.obtenerRegistros();
    }

    @Override
    public Usuario obtenerRegistro(int idUsuario) {
        return modelo.obtenerRegistro(idUsuario);
    }

    @Override
    public void eliminarRegistro(int idUsuario) {
        modelo.eliminarRegistro(idUsuario);
    }
    
}
