package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import mx.com.gm.sga.datos.UsuarioDao;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author angel
 */

@Stateless
public class UsuarioServiceImpl implements UsuarioService, UsuarioServiceRemote{
    @Inject
    UsuarioDao repositorio;
    
    @Override
    public List<Usuario> listarUsuarios() {
        return repositorio.findAll();
    }

    @Override
    public Usuario encontrarUsuarioPorId(Usuario usuario) {
        return repositorio.findByIdUsuario(usuario);
    }

    @Override
    public Usuario encontrarUsuarioPorUserName(Usuario usuario) {
        return repositorio.findByUsername(usuario);
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        repositorio.agregarUsuario(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        repositorio.actualizarUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        repositorio.eliminarUsuario(usuario);
    }
    
}
