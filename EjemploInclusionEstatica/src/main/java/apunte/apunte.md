# Inclusion de archivos en JSP

Agregar a un JSP dentro de otro, existen dos formas para realizar esta accion:

* Inclusion Estatica (translation time):
  * `<%@ include file="paginaRelativa.jsp" %>`

* Inclusion Dinamica (request time):
  * `<jsp:include page="paginaRelatica.jsp" />`

La inclusion estatica podemos reconocer esta directiva con `@` despues se especifica el
JSP a emplear, con diferencia a la inclusion dinamica que en lugar de usar una
directica usa una accion.

## Inclusion estatica

* Sintaxis:
  * `<%@ include file="paginaRelativa.jsp" %>`

* Objetivo:
  * Reutilizar codigo en texto plano, HTML o JSP.
  * En este caso el JSP que se incluye puede afectar al JSP incluyente.

* Notas:
  * En este caso no se delega el control al JSP incluido, sino que se incluye el
  archivo JSP, generando un unico JSP.
  * Por lo anterior, se pueden tener variables o metodos que se comparten entre los
  JSP.
  * Para tener la version mas reciente, se recomienda compilar y construir nuevamente
  el proyecto.

### Diagrama

| Archivos JSP                                                  | Tiempo de Traduccion (Translation time                               | Tiempo de ejecucion (Request time)            |   |   |
|---------------------------------------------------------------|-------------------------------------------------------------------------------------|-----------------------------------------------|---|---|
| Se menciona el a.jsp JSP Principal y el  b.jsp JSP a Incluir. | Servlet Generado, incluye el contenido de a.jsp y b.jsp los mezcla (`out.write()`). | Incluye el html de a.jsp y b.jsp ( `<html>` ) |   |   |

## Inclusion dinamica

* Sintaxis:
  * `<jsp:include page="paginaRelativa.jsp" />`

* Objetivo:
  * Reutilizar codigo en texto plano, HTML o JSP.
  * Permite actualizar el contenido sin alterar al JSP que incluye el contenido a
  reutilizar.

* Notas:
  * El JSP principal, delega el control al JSP incluido y la salida del JSP se agrega
  al JSP principal.
  * No se comparten variables o metodos entre los JSP, pero garantiza tener siempre la
  version mas reciente.
  * La pagina debe ser relativa a la aplicacion web (uso de / ).
  * Se pueden incluir archivos privados (desde la carpeta WEB-INF).
