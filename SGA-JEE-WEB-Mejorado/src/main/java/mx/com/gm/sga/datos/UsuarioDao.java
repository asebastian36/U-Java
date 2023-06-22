package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author angel
 */

public interface UsuarioDao {
    public List<Usuario> findAll();
    
    public Usuario findByIdUsuario(Usuario usuario);
    
    public Usuario findByUsername(Usuario usuario);
    
    public Usuario findByPassword(Usuario usuario);
    
    public void agregarUsuario(Usuario usuario);
    
    public void actualizarUsuario(Usuario usuario);
    
    public void eliminarUsuario(Usuario usuario);
}
