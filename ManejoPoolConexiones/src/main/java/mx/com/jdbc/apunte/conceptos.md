# Pool de conexiones JDBC

## Que es un pool de conexiones?

Nos permite agilizar el proceso de obtener una conexion por cada clase Java que necesite una conexion, ya que el objetivo de el pool de conexiones es tener listas varias conexiones a la bd de manera que sea mucho mas eficiente el proceso de obtener y liberar una conexion a la bd.

Puede crearse de varias maneras:

* Una es con codigo Java (desarrollado por nosotros), sin embargo se tendra que mantener y escalar por nosotros mismos.
* Utilizando algun proyecto como el proyecto de JDBC de apache.
* Otra manera es apoyandonos del servidor de aplicaciones Java como tom cat, etc.

> Crear una nueva conexion puede llegar a tener un consumo de recursos muy alto, por lo que es importante manejar bien las conexiones, el proceso de administracion  de una conexion se delega al pool de conexiones.
