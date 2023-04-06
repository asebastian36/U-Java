# Ejercicio Managed Beans

Se creo la clase `Candidato` en el paquete `beans.model`, esta pagina se asociara con la pagina html de JSF, agregaron dos anotaciones al codigo
para que pueda ser reconocido por el framework de JSF y pueda ser utilizado.

```java
package beans.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Angel Franco
 */

@Named
@RequestScoped
public class Candidato {
    private String nombre = "Introduce tu nombre";

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
```

Despues pasamos al archivo `index.xhtml` y lo modificamos agregando un formulario para acceder al atributo de la
clase `candidato`:

```xhtml
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:h="http://java.sun.com/jsf/html">
    <head>
        <title>Ejercicio JSF</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body>
        <h:form>
            <table>
                <tr>
                    <td><h:outputLabel for="nombre" value="Nombre:"></h:outputLabel></td>
                    <td><h:inputText id="nombre" value="#{candidato.nombre}"></h:inputText></td>
                    <td><h:message for="nombre"></h:message></td>
                </tr>
            </table>
        </h:form>
    </body>
</html>
```

El mensaje de `message` esta relacionado al `inputText` con el id de nombre.
