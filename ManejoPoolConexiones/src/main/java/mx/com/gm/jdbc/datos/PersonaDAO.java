package mx.com.gm.jdbc.datos;

import java.sql.SQLException;
import java.util.List;
import mx.com.gm.jdbc.domain.PersonaDTO;

/**
 *
 * @author Angel Sebastian
 */
public interface PersonaDAO {
    public void insert(PersonaDTO persona) throws SQLException;
    public void update(PersonaDTO persona) throws SQLException;
    public void delete(PersonaDTO persona) throws SQLException;
    public List<PersonaDTO> select() throws SQLException;
}
