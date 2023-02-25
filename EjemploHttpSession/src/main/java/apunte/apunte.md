# Manejo de sesiones con HTTP session

## Sesion HTTP

El API de los servlets nos permite administrar las sesiones de los clientes con la clase `HttpSession` esto ocurre de manera automatica, cada peticion que realiza un cliente hacia el recurso
web de manera automatica crea una nueva sesion, por ejemplo si tenemos dos navegadores distintos en la misma pc se consideran distintos clientes debido a que es diferente navegador web y cada
cliente crea una una sesion en el servidor web, pero si tenemos una nueva ventana en el mismo navegador web no se considerara un nuevo cliente y por lo tanto no se crea una nueva sesion en el
servidor. Una sesion nos permite administrar las peticiones que realiza un usuario el objeto `HttpSession` se obtiene a partir del objeto `HttpServletRequest`, por lo que **una sesion se utiliza
para administrar distintas peticiones del usuario**, una sesion tiene un duracion de vida mas larga que una peticion (request), por lo tanto **una sesion se destruye hasta que transcurra el tiempo
que le hemos asignado a la sesion de inactividad** o tambien puede **destruirse manualmente con el metodo** `invalidate`.

## Manejo de sesiones con servlets

* `request.getSession()`: Se utiliza para obtener la sesion que se creo a partir de la peticion del cliente.
* `sesion.getAttribute()`: Permite obtener un atributo previamente agregado a la sesion del cliente.
* `sesion.setAttribute()`: Permite agregar un atributo a la sesion actual del cliente.
* `sesion.removeAttribute()`: Permite eliminar un atributo agregado a la sesion.
* `sesion.invalidate()`: Invalida la sesion actual del cliente.
* `sesion.isNew`: Permite saber si la sesion ha sido recien creada.
* `sesion.getCreationTime()`: Permite conocer la fecha y hora de cuando se creo la sesion.
* `sesion.getLastAccesedTime()`: Permite conocer la ultima vez que la sesion fue accedida por el cliente.
* `sesion.getMaxInactiveInterval()`: Permite conocer el tiempo de inactividad (en segundos) necesario para que la sesion se destruya si no recibe una peticion.
* `sesion.setMaxInactiveInterval()`: Permite modificar el valor mencionado en funcion anterior. Este valor tambien se puede modificar en el archivo `web.xml`.
