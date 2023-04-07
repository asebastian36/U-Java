# Creacion de backing bean

Es un managed bean que hara de controlador en la aplicacion, su ubicacion es `beans.backing` y el nombre de la clase es `VacanteForm`
se consultura desde ese bean los posibles resultados si el candidato coincide con el nombre establecido. Si cumple pasara al
archivo `exito.xhtml` sino pasara al archivo `fallo.xhtml`.

```java
package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Angel Franco
 */

@Named
@RequestScoped
public class VacanteForm {
    //  uso de CDI para inyectar una dependencia
    @Inject
    //  agregando la inyeccion del tipo Candidato
    private Candidato candidato;

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    //  redireccionamiento a otra pagina con condicional
    public String enviar() {
        if(this.candidato.getNombre().equals("Angel")) return "exito";
        else return "fallo";
    }
}
```

Estas son las paginas a las que redirecciona:

Exito:

```xhtml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html">
    <head>
        <title>Exito</title>
    </head>
    <body>
        <h:form>
            Gracias #{candidato.nombre} por aplicar a la vacante
            <br/>
            <h:commandLink action="index">Regresar</h:commandLink>
        </h:form>
    </body>
</html>
```

Fallo:

```xhtml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html">
    <head>
        <title>Fallo</title>
    </head>
    <body>
        <h:form>
            Lo siento #{candidato.nombre} no hay vacantes por el momento
            <br/>
            <h:commandLink action="index">Regresar</h:commandLink>
        </h:form>
    </body>
</html>
```

Hay que hacer un ajuste en `WEB-INF` en el archivo `beans.xml` para que funcione la inyeccion de dependencias.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://xmlns.jcp.org/xml/ns/javaee"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/beans_2_0.xsd"
       bean-discovery-mode="all">
       version="2.0">
</beans>
```
