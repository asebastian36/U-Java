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
