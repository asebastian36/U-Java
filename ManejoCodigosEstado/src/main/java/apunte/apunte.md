# Codigos de estado HTTP

Los codigo de estado se utilizan para indicar el estado de la respuesta del servidor web hacia el cliente (navegador web),
nos permiten indicar al cliente una respuesta por parte del servidor web.

## API de servlets al usar codigos de estado

Los siguientes metodos nos permiten indicar el codigo de respuesta del servidor web al cliente (navegador web):

* `response.setStatus(int codigo)`:
  * Se utilizan normalmente **constantes**, tales como SC_OK, SC_NOT_FOUND, etc.
* `response.sendError(int codigo, String mensaje)`:
  * Se utiliza para mostrar el error en un documento HTML, normalmente los navegadores.
* `response.sendRedirect(String url)`:
  * Se utiliza para indicar un redireccionamiento a otra pagina. El codigo de estado es el 302.

## Codigos de estado HTTP mas comunes

1. **200 (Ok):** La respuesta fue correcta, es el codigo de estado por default
2. **204 (Sin contenido):** El navegador continua desplegando el documento previo
3. **301 (Movido permanentemente):** El documento solicitado ha cambiado de ubicacion, y posiblemente se indica la nueva ruta, en ese caso el navegador se redirecciona a la
nueva pagina de manera automatica.
4. **302 (Encontrado):** El documento se ha movido temporalmente, y el navegador se mueve al nuevo
url de manera automatica.
5. **401 (Sin autorizacion):** No se tiene permiso para visualizar el contenido solicitado, debido
a que se trato de acceder a un recurso protegido con contrasena sin la autorizacion respectiva.
6. **500 (Error interno del servidor web):** El servidor web lanzo una excepcion irrecuperable por lo tanto no
se puede continuar procesando la peticion.
