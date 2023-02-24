# Request headers (cabeceros de peticion)

Los cabeceros de peticion permiten obtener metadatos de la peticion HTTP.

Ejemplo:

* El metodo HTTP utilizado en la peticion(GET, POST, etc).
* La IP del equipo que realizo la peticion (192.168.1.1)
* El dominio del equipo que realizo la peticion (www.mydomain.com)
* El recurso solicitado ( <http://mydomain.com/recurso> )
* El navegador que se utilizo en la peticion (Mozilla, MSIE, etc)
* entre varios cabeceros mas

## Metodos para procesar peticiones HTTP

Metodos de la clase HttpServletRequest:

* `getHeader()`: Permite procesar un cabecero a la vez.
* `getHeaders()`: Todos los nombres en una enumeracion que corresponden con los cabeceros de
la peticion HTTP.
* `getHeadersNames()`: Recupera todos los nombres relacionados con los cabeceros en la peticion
HTTP.

Metodos con informacion relativa al contexto:

* `getMethod()`: Retorna informacion referente al tipo de metodo que se ejecuto pudiendo ser GET,
POST, o cualquier metodo relacionado con el protocolo HTTP.
* `getRequestURI()`:Permite obtener la URI con la cual se solicito el recurso web.
* `getQueryString()`:Permite recuperar los parametros que vienen posterior al signo de pregunta
en una peticion de tipo GET.
* `getProtocol()`:Indica que protocolo se utilizo.

Y algunos metodos mas especializados:

> cookie archivo que se almacena en el navegador para guardar ciertas preferencias del usuario
> al momento en que este usuario utiliza un sitio web.

* `getCookies()`: Para obtener todas las cookies que se procesan o se almacenan en la peticion
 HTTP.
* `getAuthType()`:Para procesar la seguridad en el API de los servlets y los JSP's.
* `getRemoteUser()`:Lo mismo que el anterior.
* `getContentLength`:Obtener el largo de la peticion.
* `getContentType()`: Obtiene el tipo de nuestra peticion.
* `getDateHeader()`
* `getIntHeader()`
