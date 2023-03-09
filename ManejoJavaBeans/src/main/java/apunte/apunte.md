# Manejo de JavaBeans con JSP

* Los JSP pueden acceder a los JavaBeans.

* Un JavaBean es una clase de Java que sigue ciertas reglas basicas:

  * Debe tener un constructor vacio.
  * Todos los atributos deben ser privados.
  * Se debe generar el metodo get y set para cada atributo.

* Un JSP debe utilizar el nombre de la propiedad para acceder o modificar el atributo
de un JavaBean.
* Indirectamente el JSP manda a llamar al metodo get o set asociado con la propiedad
indicada en el JSP.

## Ejemplos de propiedades de JavaBeans

| Nombre propiedad | Nombre de los metodos | Codigo en el JSP |
|:---|:---|:---|
| nombreUsuario | getNombreUsuario setNombreUsuario | `<jsp:getProperty...property="nombreUsuario" />` `<jsp:setProperty...property="nombreUsuario" />` |
| eliminado | isEliminado setEliminado | `<jsp:getProperty...property="eliminado" />` `<jsp:setProperty...property="eliminado" />`|
| noTelefono | getTelefono setTelefono | `<jsp:getProperty...property="telefono" />` `<jsp:setProperty...property="telefono" />`|
| codigo_postal | getCodigo_postal setCodigo_postal | `<jsp:getProperty...property="codigo_postal" />` `<jsp:setProperty...property="codigo_postal" />`|

## Alcance de atributos en un JSP (scope)

* **page:** Alcance basico, solo se utiliza dentro de los JSP, Un atributo que
tenga el alcance de page unicamente existira durante el tiempo que se traduce un JSP
a un servlet, pero una variable definida con este alcance no podra utilizarse
posteriormente al tiempo de traduccion de un JSP a un servlet.

* **request:** Las variables que pongamos en este alcance unicamente van a existir
durante el tiempo en que un usuario haga una peticion hacia nuestro servidor web
y una vez que llega la informacion al servidor, entonces esta informacion en el
alcance de request, se destruye. Si volvieramos a hacer una peticion, entonces las
variables almacenadas en el alcance de request se destruirian, por lo tanto el alcance
de request existe solo durante una unica peticion, pero no va a existir en peticiones
subsiguientes.

* **session:** Cuando agregamos una variable al alcance session va a durar, durante
distintas peticiones hacia nuestro servidor web, asi que podemos agregar informacion
hacia nuestro alcance de session y va existir mientras el tiempo de vida que hagamos
peticiones entre nuestro cliente servidor, por lo menos durante 30 minutos, si pasan
30 minutos de inactividad entonces la session se destruye a menos que se configure la
session.

* **application:** Cuando agreguemos informacion a este alcance, entonces va a existir
durante todo el tiempo que este arriba la aplicacion y se va a destruir hasta que
detengamos nuestro servidor web o que hagamos un undeploy de nuestra aplicacion.

> undeploy: eliminar la aplicacion del servidor web.

## Uso basico de los JavaBeans

* `jsp:useBean` Permite acceder a un bean en un alcance (scope) especificado.

ejemplo:

```java
<jsp:useBean id="nombreBean" class="paquete.nombreClase" />
```

* `jsp:setProperty` Permite modificar una o varias propiedades de un bean especificado.

ejemplo:

```java
<jsp:setProperty name="nombreBean" property="nombreUsuario" value="Angel" />
```

* `jsp:getProperty` Permite acceder a una propiedad de un bean especificado.

ejemplo:

```java
<jsp:getProperty name="nombreBean" property="nombreUsuario" />
```
