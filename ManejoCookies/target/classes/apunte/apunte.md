# Manejo de cookies

## Manejo de sesiones con servlets

Una sesion en una aplicacion web permite administrar varias peticiones de un mismo usuario.

Esta necesidad surge dado que el protocolo HTTP no recuerda informacion, es un protocolo sin estado (entre peticiones
no recordara informacion del usuario que realizao dicha peticion).

Las sesiones en los servlets se pueden manejar por medio de dos mecanismos:

* Cookies
* URL Rewritting

El API de los servlets abstrae estos conceptos en una clase llamada `HTTPSession`.

## Concepto y uso de cookies

Una cookie es un archivo que contiene informacion en forma de nombre y valor, el cual se almacena en el navegador web.

El objetivo de una cookie es almacenar informacion del usuario cada vez que accede a un mismo sitio, como puede ser el
lenguaje preferido, colores preferidos y en general las preferencias del usuario.

Las cookies no se deben utilizar para almacenar informacion sensible como passwords, tarjetas de credito, etc. Debido
a que la informacion almacenada es texto plano sin ningun tipo de encriptacion.

## API de las cookies en los servlets

Una cookie se puede leer en una peticion HTTP (se itera el arreglo de cookies) y se puede escribir en una respuesta
HTTP.

Creacion de un objeto cookie:

```Java
Cookie cookie = new Cookie("usuario", "Angel");
//  regresa usuario
cookie.getName();
//  regresa Angel
cookie.getValue();
```

Metodos para leer todas las cookies en una peticion HTTP:

```java
Cookie[] cookies = request.getCookies();
```

> Todos los valores que se almacenan en una cookie son de tipo string

Metodo para agregar una cookie en la respuesta:

```java
response.addCookie(cookie);
```

## API del objeto cookie

Metodos mas comunes en un objeto cookie:

* `getDomain/setDomain`: Se utiliza para especificar el dominio de donde proviene o se va a almacenar la cookie.
* `getMaxAge/setMaxAge`: Especifica el tiempo a expirar (segundos).
* `getName`: Obtiene el nombre de la cookie, para colocar el nombre se debe usar el constructor de la clase.
* `getValue/setValue`: Especifica el valor asociado con el nombre de la cookie.
