# Enterprise Java Beans EJB's

## Que es un enterprise JavaBean EJB'S?

Un enterprise JavaBean es una clase Java con caracteristicas que lo hacen mucho mas potente
y robusto.

* Los metodos de un EJB son transaccionales.
* Los metodos pueden ser remotos.
* Facilidad de comunicacion con las bases de datos.
* Los metodos pueden ser seguros.

> El servidor de aplicaciones es el que contiene a los EJB'S

Los EJB'S es codigo Java del lado del servidor que tiene la logica de negocio y por lo tanto
cubren el rol de la capa de servicio, los EJB son clases puras de Java, los cuales al ser
desplegados en un servidor reducen la complejidad de programacion, agregando robustes,
reutilizacion y escalabilidad a las aplicaciones Java.

Se programan una vez y se ejecutan en servidores que soporten el estandar Java EE, los
EJB's son una tecnologia muy experimentada y que brinda beneficios de seguridad,
transaccionalidad, multitreading, etc. Todo esto con ayuda de un servidor de aplicaciones
Java. A diferencia de un Java Bean, un enterprise Java Bean es una clase Java con
caracteristicas que lo hacen mucho mas potente y robusto. Los metodos de un EJB son
transaccionales, pueden ser remotos, existe facilidad de comunicacion con la base de datos,
los metodos pueden ser seguros, pueden ser asincronos, etc.

## Caracteristicas de un EJB

Cuando un EJB se ejecuta en un contenedor Java EE que soporta EJB's, el contenedor agrega
los siguientes servicios disponibles de manera automatica:

* Seguridad.
* Llamadas asincronas.
* Llamadas remotas.
* Web services.
* Transacciones.
* Inyeccion de dependencias (CDI).
* Pool de conexiones.
* Thread-safety.
* Sheduling.
* Mensajeria.
* Interceptores.
* etc...

Estos servicios permiten crear aplicaciones de mision critica con operaciones los siete dias
de la semana, las veinticuatro horas del dia, los trescientos sesenta y cinco dias del año.
Independientemente del servidor utilizado se tendran estos servicios al crear y desplegar
los EJB's.

**Servidores de aplicaciones Java:**

* GlassFish.
* JBoss.
* WebSphere.
* Oracle web logic.

> Tambien existen servidores web como Tom cat.

## Configuracion y tipos de EJB's

Se crea una clase pura de Java, agregando el uso de notaciones que en conjunto nos dara
un EJB, tipos de EJB's:

* **Stateless:** No guardan estado y se utiliza la notacion `@Stateless` (son los mas
utilizados).
* **Stateful:** Guardan estado y se utiliza la anotacion `@Stateful`.
* **Singleton:** Solo existe una instancia en memoria y se utiliza la notacion `@Singleton`.

## Formas de comunicarnos con un EJB

Con el objetivo de permitir la comunicacion de sus metodos, existen distintas formas de
comunicarnos con un EJB:

* **Remota.** Desde el cliente al servidor.
* **Interfaz local:** Se utiliza cuando el cliente se encuentra en el mismo servidor Java.
* **Interfaz remota:** Se utiliza cuando el cliente se encuentra fuera del servidor Java.
* **No interface:** Es una variante y simplificacion de los EJB locales.

Las interfaces de negocio son clases Java que contienen la declaracion de los metodos de
negocio que son visibles al cliente, tambien tenemos una clase llamada Bean, esta clase
implementa los metodos de negocio y puede implementar 0 o mas interfaces de negocio
dependiendo del tipo de EJB, esta clase se debe anotar con `@Stateless` o `@Stateful`, o
`@Singleton` dependiendo del tipo de EJB que se quiera crear.

## Anatomia de un EJB

```Java
package beans;

import javax.ejb.Stateless;

//  puede implementar o no una interface

@Stateless
public class HolaMundoEJB {

    //  metodo de negocio
    public int sumar(int a, int b) {
      return a + b;
    }

}
```

Esta sintaxis permite convertir una clase pura de Java en un EJB simplemente anotando
la anotacion del Bean correspondiente, esto en automatico hace que esta clase tenga
caracteristicas como metodos transaccionales, metodos con seguridad, etc y puede
acceder al manejo de entidades con `Entity manager` y asi persistir informacion en la
base de datos entre otras muchas caracteristicas mas. Todo esto simplemente agregando la
anotacion EJB respectiva.

> Otra forma de configurar un EJB es utilizando el archivo descriptor `EJBJar.xml` el cual
> ya es opcional.

Un EJB se ejecuta en un contenedor Java, este ambiente de ejecucion es el que permite
agregar las caracteristicas empresariales a las clases Java, permitiendo realizar llamadas
remotas, inyeccion de dependencias, manejo de estados, ciclo de vida, manejo de mensajeria,
manejo de transacciones, seguridad, interceptores, manejo de metodos asincronos, etc. Todo
esto ocurre haciendo deploy de esta clase Java EJB al servidor de aplicaciones Java
respectivo, esto permite que el programador Java se enfoque en los metodos de negocio y
delegue todas estas caracteristicas de requerimientos no funcionales a los servidores
de aplicaciones Java.
