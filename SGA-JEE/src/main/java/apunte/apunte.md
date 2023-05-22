# Ejercicio

Sistema de gestion de alumnos, objetivo del ejercicio: agregar un EJB de sesion a nuestro
al proyecto. A lo largo del curso se agregaran componentes al sistema. Esta aplicacion web,
puede tener clientes remotos y web services.

Configuramos el proyecto con el jdk 8 y las dependencias correspondientes, despues se
incluyeron las dependencias.

Posteriormente agregar la clase `Persona` que implementa la interfaz `Serializable` lo que
hace esta interfaz de tipo marcador es permitir que la clase pueda convertirse en una
secuencia de bytes ya sea para almacenarlo en un archivo o transferirlo a traves de la red
o almacenarlo en una base de datos.

Luego creamos la interfaz remota `PersonaServiceRemote` el objetivo de esta interfaz es
interactuar con la capa de datos y la capa de datos interactuara con una base de datos. La
implementacion de esta interfaz sera un EJB de tipo `Stateless` solo implementaremos
algunos metodos dado que aun no hacemos la conexion a la base de datos.

> Solo se implementaron los metodos que NO son `void`.

Por ultimo se agrego una clase `Cliente` que tendra un metodo `main` para hacer las pruebas
una vez subido el `jar` generado de hacer `clean and build` del proyecto.

Esto se hace desplegando el servidor y una vez arriba las opciones para hacerlo son:
`services -> view domain admin console -> applications -> deploy`.

Una vez subido el jar al servidor buscamos en la consola el `Portable JNDI names` para
nuestro EJB en este caso el nombre es `java:global/SGA-JEE/PersonaServiceImpl!mx.com.sga.servicio.PersonaServiceRemote`, se ocupara para buscar nuestro EJB con la clase `Context`
que se creo en cliente con el metodo `lookup`.
