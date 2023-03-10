# Expression Language (EL)

Nos permite simplificar el despliegue de informacion en un JSP utilizando JavaBeans

Sintaxis con acciones JSP:

* `<jsp:useBean id="nombreBean" class="ClaseBean" />`
* `<jsp:getProperty name="nombreBean" ppropiedad="nombre propiedad" />`

Sintaxis con Expression Language (EL):

* `${ nombreBean.nombrePropiedad }`
* `${ nombreBean["nombrePropiedad"]}`

## Caracteristicas de Expression Language

Los objetos JavaBean a utilizar se deben agregar previamente en algun alcance (scope)
por medio del metodo setAttribute() en un Servlet:

* page
* request
* session
* application

La notacion es muy simplificada, pero solo permite la lectura de informacion (getters).
No existe notacion para la modificacion de los atributos en un JavaBean (setters).

Permite acceder a propiedades de un JavaBean de manera anidada. Ej. `${alumno.direccion.calle}`

## Mas caracteristicas de Expression Language

* Acceso a propiedades de un objeto de tipo Collection o Arreglos.
Ej. `${ listaPersonas[ indice/llave ]}`

> Nota: No es posible iterar los elementos, para ellos debemos usar JSTL.

* Conversiones automaticas de tipos de datos al desplegar la informacion.
* Manejo automatico de valores null o vacios, convirtiendolos en cadenas vacias.

> No es buena practica incorporar logica en estas expresiones

* Conjunto de operadores:
  * `${ 3 + 2 - 1}`
  * `${ "x" > "y"}`
  * `${3 >= 10/2 }`

## Acceso a variables implicitas con EL

* Objeto **pageContext** Ej. `${pageContext.session.id}`
* Valores de parametros con **param** y **paramValues**. Ej. `${ param.nombre }`
* Valores de cabeceros con **header** y **headerValues**. Ej. `$ header["user-agent"]`
* Valores con el objeto **cookie**. Ej. `${ cookie.nombre.Cookie.value }`
* Valores de atributos en algun alcance con **pageScope**, **requestScope**,
**sessionScope** y **applicationScope**. Ej. `${sessionScope.rectangulo.area}` o
 `${rectangulo.area}`
