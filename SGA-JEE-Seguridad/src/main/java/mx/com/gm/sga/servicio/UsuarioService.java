package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author angel
 */

@Local
public interface UsuarioService {
    public List<Usuario> listarUsuarios();
    
    public Usuario encontrarUsuarioPorId(Usuario  usuario);
    
    public Usuario encontrarUsuarioPorUserName(Usuario usuario);
    
    public void agregarUsuario(Usuario usuario);
    
    public void actualizarUsuario(Usuario usuario);
    
    public void eliminarUsuario(Usuario usuario);
}
