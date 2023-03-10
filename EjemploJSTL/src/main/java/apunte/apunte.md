# JSTL (javaserver pages standard tag library)

JSTL extiende los tags de los JSP's, agregando principalmente las siguientes librerias:

* **core:** Permite leer y manipular datos, asi como iterar, agregar condiciones y
otras funciones basicas.
* **xml:** Permite la manipulacion y transformacion de documentos XML.
* **sql:** Permite ejecutar consultas a una base de datos, asi como crear conexiones a
las mismas.
* **fmt:** Permite dar formato a las cadenas, apoyado de conceptos como
internacionalizacion (Locale).

## Configuracion de JSTL

Agregar las siguientes librerias al Classpath (No es necesario si el servidor web
como Glashfish ya cuenta con estas librerias):

* standar.jar
* jstl.jar

Configuracion de la directiva JSP:

JSP clasico:

* `<% taglib uri="http://java.sun.com/jstl/core" prefix="c" %>`

Documento JSP (jspx)

```html
<html
  xmlns:c = "http://java.sun.com/jsp/jstl/core"
  xmlns:jsp = "http://java.sun.com/JSP/Page"  >
```

## Libreria core de JSTL

> Combinacion de JSTL con EL:

* Tags de despligue de informacion: `<c:out value="${persona.nombre}"`
* Tags de creacion y manipulacion de variables: `<c:set var="nombre" value="Angel" scope="page" />`
* Tags de elementos condicionales: `<c:if test="${i > 0}"> y <c:choose> <c:when test="a">...`
* Tags de iteracion de elementos: `<c:forEach var="persona" items="${personas}">...`
* Tags de importacion de recursos web: `<c:import url = "recursoInternoExterno" >`
* Tags de redireccionamiento: `<c:redirect url="${ nuevaUrl } />"`
* Tags de manejo de parametros:

```java
<c:import url = "c-import-param.jsp" >
  <c:param name = "nombre" value = "${ param.select}" />
  </c:import>
```
