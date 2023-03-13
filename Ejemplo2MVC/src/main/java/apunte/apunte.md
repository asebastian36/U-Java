# Cambios con el ejemplo 1

Agregar variables en el alcance de request, session y aplication

> agregando complejidad respecto al ejemplo 1

## cambios en index.jsp

Cambios en los titulos y contenido del HTML. Por un div y dos enlaces al
`servletControlador` un enlace con parametros y el otro sin parametros.

```html
<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplo MVC 2</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Ejemplo MVC 2</h1>
        <br>
        <div style="color: azul">${mensaje}</div>
        <br>
        <a href="${pageContext.request.contextPath}/ServletControlador">Link al servlet controlador sin parametros</a>
        <br>
        <br>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=agregarVariables">Link al servlet controlador que agrega parametros</a>
        <br>
        <br>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables">Link al servlet controlador que lista parametros</a>

    </body>
</html>
```

## Cambios en carpeta vista

Se elimino el `desplegarVariables.jsp`

## Cambios en el paquete controlador

Ahora si se procesan variables, se crean otros JavaBeans diferentes para distintos
alcances. Y manejamos los distintos flujos que se crearon.

```java
package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Rectangulo;

/**
 *
 * @author asebastian36
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  procesamos los parametros
        String accion = request.getParameter("accion");

        //  creamos los JavaBean
        Rectangulo rectanguloReq = new Rectangulo(3, 7);
        Rectangulo rectanguloSess = new Rectangulo(4, 8);
        Rectangulo rectanguloAppl = new Rectangulo(5, 9);

        //  agregamos el JavaBean a algun alcance
        //  revisamos la accion proporcionada
        if ("agregarVariables".equals(accion)) {
            //  alcance request
            request.setAttribute("rectanguloRequest", rectanguloReq);

            //  alcance session
            HttpSession sesion = request.getSession();
            sesion.setAttribute("rectanguloSession", rectanguloSess);

            //  alcance application
            ServletContext application = this.getServletContext();
            application.setAttribute("rectanguloApplication", rectanguloAppl);

            //  agregamos un mensaje
            request.setAttribute("mensaje", "Las variables fueron agregadas");
            
            //  redireccionamos al jsp de index
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        } else if ("listarVariables".equals(accion)) {
            //  redireccionamos al jsp que despliega las variables, le mandamos la informacion con forward
            
            request.setAttribute("mensaje", "Las variables fueron listadas");
            request.getRequestDispatcher("WEB-INF/alcanceVariables.jsp").forward(request, response);
        } else {
            //  redireccionamos a la pagina de inicio
            request.setAttribute("mensaje", "accion no proporcionada o desconocida");
            request.getRequestDispatcher("index.jsp").forward(request, response);

            //  alternativa que no agrega informacion al JSP
            //  response.sendRedirect("index.jsp");
        }
    }
}
```

## Extras

JSP que reemplazo el JSP en el paquete vista.

```html
<%-- 
    Document   : alcanceVariables
    Created on : 12 mar. 2023, 18:37:01
    Author     : asebastian36
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcance de Variables</title>
    </head>
    <body>
        <h1>Alcance de Variables</h1>
        <br>
        Variable request:
        <br>
        Rectangulo:
        <br>
        Base: ${rectanguloRequest.base},
        Altura: ${rectanguloRequest.altura},
        Area: ${rectanguloRequest.area}
        <br>
        <br>
        Variable session:
        <br>
        Rectangulo:
        <br>
        Base: ${rectanguloSession.base},
        Altura: ${rectanguloSession.altura},
        Area: ${rectanguloSession.area}
        <br>
        <br>
        Variable application:
        <br>
        Rectangulo:
        <br>
        Base: ${rectanguloApplication.base},
        Altura: ${rectanguloApplication.altura},
        Area: ${rectanguloApplication.area}
        <br>
        <br>
        <a href="${pageContext.request.getContextPath()}">Regresar a inicio</a>
    </body>
</html>
```
