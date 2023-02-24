# Apunte

## pom.xml

Etiquetas que indican la version del JDK que usa el proyecto, version de Java:

```xml
<maven.compiler.source>1.8</maven.compiler.source>
<maven.compiler.target>1.8</maven.compiler.target>

<jakartaee>8.0</jakartaee>
```

Despues de revisar esto se crea la clase de servlet en la carpeta `source packages`, en servlet es una clase de Java.

> hay clases en ese paquete se pueden eliminar.

### ejemplo

```java
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/*
 * @author Angel Sebastian
 */

//  esta notacion se usa para poder acceder al servlet desde el navegador
//  entre parentesis esta el path para acceder al servlet
@WebServlet("/HolaMundo")
public class HolaMundo extends HttpServlet{
    //  un servlet solo es una clase de Java que extiende de HttpServlet
    
    //  llamada al servlet de tipo get
    @Override
    //  glashfissh se encarga de hacer la llamada a este metodo
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //  recibir la peticion, responder y establecer el tipo de contenido 
        //  que va a recibir el navegador  la peticion con un hola mundo
        response.setContentType("text/html;charset=UTF-8");
        
        //  el getwriter manda la excepcion io y la procesamos
        //  printwriter es como mandar salida a consola pero ahora sera al navegador web
        PrintWriter out = response.getWriter();
        out.println("Hola mundo desde Servlets");
        
        //  no es recomendable usar o poner codigo html en un servlet
    }
}
```

Es recomendable hacer un `clean and build` al codigo para actualizar las versiones del codigo.
Al hacer clean and build se creara un `archivo.war`, war = web archive file | contiene informacion web.

> nota debe estar deshabilitado el servidor de aplicaciones para hacerlo.

Los archivos web que se crean por defecto en un proyecto Java web estan en la carpeta `Web Pages` se crean por defecto:

* `index.html`
* carpeta `WEB-INF`:
  * `web.xml`: Se establece la version del API de los servlets, se puede llegar a usar para configurar caracteristicas del
     API de los servlets y los JSP.
  * `beans.xml`

### llamada al servlet desde el HTML

```html
<!DOCTYPE html>
<html>
    <head>
        <title>Inicio</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Llamando al Servlet</h1>
        <!--se esta llamando con el nombre del proyecto y la ruta del servlet-->
        <a href="/HolaMundoServlet/HolaMundo">Servlet HolaMundo</a>
    </body>
</html>
```

Posibles fallas al crear un proyecto java web con maven (descarga en las librerias):

* Windows defender
* Antivirus
* Fallas en la conexion
* Algun proxy

> NOTA dar `clean and build` para que se descarguen librerias faltantes.
