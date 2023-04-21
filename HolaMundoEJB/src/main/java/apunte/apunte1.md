# Cliente de un EJB

## Cliente EJB via JNDI

JNDI es un API que permite encontrar servicios o recursos empresariales en un servidor de
aplicaciones Java. Para encontrar un EJB a partir de la version 3.1 podemos utilizar la
siguiente sintaxis:

`java:global[/<app-name>]/<module-name>/<bean-name>[!<fully-qualified-interface-name>]`

Ejemplo de codigo basico para encontrar un EJB:

```Java
public void iniciarContenedor() throws Exception {
    System.out.println("---Iniciando EJBContainer...");
    Map<String, Object> map = new HashMap<String, Object>();
    ecc = EJBContainer.createEJBContainer(map);
    ctx = ec.getContext();

    //  nombre JNDI portable en Java EE
    //  Java Naming an Directory Interface
    ejb = (HolaMundoEJB) ctx.lookup("java:global/miApp/classes/HolaMundoEJB!beans.HolaMundoEJB");
}
```

## Inyeccion de dependencias en EJB

Existen 2 tipos de inyeccion de dependencias en EJB:

* Utilizando la anotacion `@EJB`.
* Utilizando la anotacion `@Inject`.
