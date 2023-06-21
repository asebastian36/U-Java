# Ejercicio

Hacer el sistema gestion de alumnos con una interfaz remota usando un cliente web usando
para llamadas `CDI`, es necesario configurar la version de java 1.8. Despues pasamos al
archivo `beans.xml` en la ruta `Web Pages/WEB-INF/beans.xml` para llamar a los EJB de manera
local.

> Se copiaron el paquete de `domain` y `service` del proyecto anterior.

Creamos una interfaz local (solo cambia la notacion, tiene los mismos metodos), despues
modificamos la implementacion para que incluya tambien la interfaz local.

Agregamos un servlet en un paquete llamado `web` en el que llamaremos una instancia de
la implementacion de la interfaz local usando la notacion `@Inject`, posteriormente
sobreescribimos el metodo `doGet` para enviar el listado de personas con la clase `request`
especificamente con sus metodos `setAttribute`, `getRequestDispatcher` y `forward`.

Modificamos el `index.html` para que tenga un enlace que nos redireccione al `JSP` que
mostrara el listado de personas. Una vez creado el jsp se utilizara el `taglib` de `core`
para recorrer la lista de personas.

Al terminar de hacer estos cambios, se necesita desplegar el servidor y hacer `undeploy` del
componente agregado en el proyecto pasado.

## Notas

Este proyecto se le agrego el uso de JPA que en un
inicio no tiene por que usaba datos en codigo duro.

## Lista de cambios

* Se agrego la carpeta `resources` que contendra el archivo `log4j2.xml` del proyecto anterior, despues se replico el archivo de configuracion de `persistance.xml`, tambien del proyecto anterior.

* Se reemplazo la clase de entidad `Persona` del proyecto por la del proyecto anterior, esto por ya tener la conexion con la base de datos.

* Se modificaron las implementaciones de los metodos de la interfaz de la capa de servicio, para
que se reemplazen por el uso de JPA.

* Inclusion de la las librerias del `pom.xml` del proyecto anterior a este.

* Se creo la capa de datos con una interfaz y su implementacion.

* Definimos desde la clase de dominio las `queries` que usara la implementacion de la interfaz, no es sql es `JPA querie`.

> Utilizar la notacion de `@Table` para mapear la tabla con la clase si no se llama igual.

* Se modifico la tabla de `personas` de la base de datos de `test` para que el email no se pueda repetir.
* Se implemento en la capa de servicio el uso de los metodos de la capa de datos.

* Modificaciones en el `persistance.xml` por el tipo de `transaction-type` antes era local y ahora lo maneja el servidor.

* Configuracion en el servidor para el pool de conexiones.
