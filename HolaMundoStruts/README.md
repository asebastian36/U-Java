# Notas

Primer proyecto implementando struts 2.

## Cambios

* Cambios al `pom.xml` para agregar las dependencias de struts 2 y log4j.
* Cambios en el archivo de `web.xml`.
* Se agrego la clase `HolaMundoAction` en el paquete `beans`.
* Cambios en el `index.html`.
* Creacion del `struts.xml` en la ruta de `Other sources -> src/main/resources`.
* Creacion del archivo `log4j2.xml` esta en la misma ruta que el `struts.xml`.

## Struts 2

Struts 2 es un marco de trabajo MVC (Modelo-Vista-Controlador) para aplicaciones web Java. Es una implementación de Apache Struts, un marco de trabajo web popular que ha estado en uso durante más de 15 años. Struts 2 es un marco de trabajo maduro y bien probado que se puede utilizar para crear aplicaciones web complejas.

Struts 2 se basa en el patrón de diseño MVC, que es una forma de organizar el código de una aplicación web. El modelo representa los datos de la aplicación, la vista representa la interfaz de usuario de la aplicación y el controlador maneja las solicitudes del usuario. Struts 2 utiliza una variedad de componentes para facilitar el desarrollo de aplicaciones web MVC, como:

* ActionServlet: Un servlet que maneja las solicitudes del usuario y llama a los controladores.
* Actions: Clases que implementan la lógica de negocios de la aplicación.
* Tags: Etiquetas HTML que se utilizan para agregar funcionalidad a la vista.
* Tiles: Plantillas que se utilizan para crear la interfaz de usuario de la aplicación.

Struts 2 es un marco de trabajo poderoso y flexible que se puede utilizar para crear una amplia gama de aplicaciones web. Es una buena opción para los desarrolladores que desean crear aplicaciones web complejas y bien estructuradas.

Aquí hay algunos beneficios de usar Struts 2:

* Es un marco de trabajo maduro y bien probado.
* Está bien documentado y hay una gran comunidad de desarrolladores que lo utilizan.
* Es fácil de aprender y usar.
* Es escalable y se puede utilizar para crear aplicaciones web grandes y complejas.
* Es seguro y está protegido contra vulnerabilidades comunes.

Si está buscando un marco de trabajo web Java para crear aplicaciones web complejas y bien estructuradas, Struts 2 es una buena opción.

Ejemplos de codigo

```html
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<title>Struts 2 Example</title>
</head>
<body>

<h1>This is a Struts 2 example</h1>

<s:form action="/action">
<input type="text" name="username" />
<input type="submit" value="Submit" />
</s:form>

</body>
</html>
```

Este código crea una página web simple con un formulario. El formulario tiene un campo de texto para el nombre de usuario y un botón para enviar. Cuando el usuario hace clic en el botón, el formulario se envía al controlador `/action`. El controlador procesa el formulario y muestra una respuesta al usuario.

Ejemplo de código para un controlador Struts 2:

```java
package com.example.struts2;

import org.apache.struts2.interceptor.ServletRequestAware;

public class Action implements ServletRequestAware {

    private String username;

    public String execute() {
        // Get the username from the form
        this.username = request.getParameter("username");

        // Do something with the username
        System.out.println("The username is " + username);

        // Return a success message
        return "success";
    }

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    private HttpServletRequest request;

}
```

Este código define un controlador para la página web anterior. El controlador recibe el nombre de usuario del formulario y lo imprime en la consola. Luego, el controlador devuelve una respuesta de éxito al usuario.

Struts 2 es un marco de trabajo poderoso y flexible que se puede utilizar para crear una amplia gama de aplicaciones web. Es una buena opción para los desarrolladores que desean crear aplicaciones web complejas y bien estructuradas.

Ejemplos de casos de uso

* **Creación de aplicaciones web complejas.** Struts 2 es un marco de trabajo poderoso y flexible que se puede utilizar para crear aplicaciones web complejas. Es una buena opción para los desarrolladores que desean crear aplicaciones web con una gran cantidad de funcionalidad.
* **Implementación de patrones de diseño MVC.** Struts 2 está diseñado sobre el patrón de diseño MVC, que es una forma probada de estructurar el código de las aplicaciones web. Esto hace que sea más fácil de entender y mantener el código de una aplicación Struts 2.
* **Aislamiento de la lógica de negocios.** Struts 2 permite a los desarrolladores aislar la lógica de negocios de la interfaz de usuario. Esto hace que sea más fácil probar la lógica de negocios y cambiar la interfaz de usuario sin afectar la lógica de negocios.
* **Seguridad.** Struts 2 incluye una serie de características de seguridad que ayudan a proteger las aplicaciones web contra ataques. Estas características incluyen validación de entrada, prevención de inyección SQL y control de acceso basado en roles.

En general, Struts 2 es un marco de trabajo poderoso y flexible que se puede utilizar para crear una amplia gama de aplicaciones web. Es una buena opción para los desarrolladores que desean crear aplicaciones web complejas y bien estructuradas.

Aquí hay algunos ejemplos específicos de cómo se puede utilizar Struts 2:

* Una tienda en línea: Struts 2 se puede utilizar para crear una tienda en línea que permita a los clientes comprar productos en línea. Struts 2 podría utilizarse para manejar el carrito de la compra, el proceso de pago y el envío de productos.
* Un sistema de gestión de contenido (CMS): Struts 2 se puede utilizar para crear un CMS que permita a los usuarios crear y administrar contenido en un sitio web. Struts 2 podría utilizarse para manejar la edición de contenido, la publicación de contenido y la gestión de usuarios.
* Un sistema de gestión de proyectos (PMS): Struts 2 se puede utilizar para crear un PMS que permita a los usuarios administrar proyectos. Struts 2 podría utilizarse para manejar el seguimiento de tareas, el seguimiento del tiempo y la gestión de riesgos.
* Un sistema de gestión de clientes (CRM): Struts 2 se puede utilizar para crear un CRM que permita a las empresas gestionar sus relaciones con los clientes. Struts 2 podría utilizarse para manejar el seguimiento de contactos, el seguimiento de oportunidades y el seguimiento de transacciones.

Estos son solo algunos ejemplos de cómo se puede utilizar Struts 2. Struts 2 es un marco de trabajo poderoso y flexible que se puede utilizar para crear una amplia gama de aplicaciones web.
