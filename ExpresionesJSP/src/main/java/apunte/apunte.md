# Elementos de un JSP

* Expresiones:
  * Sintaxis: `<%= expresion %>`
  * La expresion se evalua y se inserta en la salida del servlet.
  * Es equivalente a `out.println(expresion)`

* Scriptlets:
  * Sintaxis: `<% codigoJava %>`
  * El codigo Java se inserta en el metodo `service()` del servlet generado.
  * Puede ser cualquier codigo Java valido.

* Declaraciones:
  * Sintaxis: `<%! codigoJava %>`
  * Se utiliza para agregar codigo a la clase del Servlet generado.

* Sintaxis XML:
  * Cada elemento JSP tiene su equivalente en sintaxis XML.
  * Esta sintaxis se utiliza para tener una mayor compatibilidad, por ejemplo, con herramientas visuales.

## Variables implicitas en los JSP's

* request:
  * Es el objeto `HttpServletRequest`
* response:
  * Es el objeto `HttpServletResponse`
* out:
  * Es el objeto `JspWriter`(equivalente a PrintWriter)
* session:
  * Es el objeto `HttpSession` asociado con el objeto request
  * Se puede deshabilitar el uso de sesiones en un JSP
* application:
  * Es el objeto `ServletContext` que se obtiene a partir del metodo `getServletContext()` en un servlet
