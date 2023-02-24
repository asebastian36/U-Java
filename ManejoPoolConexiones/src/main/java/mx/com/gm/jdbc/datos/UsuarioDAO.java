package mx.com.gm.jdbc.datos;

import java.sql.SQLException;
import java.util.List;
import mx.com.gm.jdbc.domain.UsuarioDTO;

/**
 *
 * @author Angel Sebastian
 */
public interface UsuarioDAO {
    public void insert(UsuarioDTO usuario) throws SQLException;
    public void update(UsuarioDTO usuario) throws SQLException;
    public void delete(UsuarioDTO usuario) throws SQLException;
    public List<UsuarioDTO> select() throws SQLException;
}
