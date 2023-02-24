# Nota de los cambios en el proyecto

```java
//  para los test ya no crearemos la clase DAO con la clase sino con la interfaz
PersonaDAO personaDAO = new PersonaDAOImpl(conexion);
```
Esto para asi poder manejar diferentes tipos de implementaciones y siga siendo un codigo legible.

Asi quedo la interfaz:
```java
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

```

Despues solo se implemento en clase ya hecha y se cambiaron los nombres de los metodos,
Tambien formalizamos los patrones que se aplican en el proyecto en este caso el patron DAO y DTO.
