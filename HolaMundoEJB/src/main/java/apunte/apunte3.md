# Ejercicio

El objetivo del ejercicio es realizar una llamada a un EJB de manera remota, entonces se
creara un componente del lado del servidor que sera un EJB con el nombre `HolaMundoEJB`, sin
embargo se incluira un cliente que accedera al EJB desde una interfaz remota, haciendo asi
una llamada remota a un EJB.

> Hay que modificar el pom para que se maneje la version 8 del jdk, ya que Java EE soporta
> hasta esa version.

**Sintaxis modificada del `pom.xml`**

```xml
<maven.compiler.source>1.8</maven.compiler.source>
<maven.compiler.target>1.8</maven.compiler.target>
```

> Tambien se debe ajustar las propiedades del proyecto para usar el jdk 1.8.

Ruta de configuracion en netbeans `properties -> Source -> Source/Binary format` y
`properties -> Build -> Compile -> Java Platform`.

## Agregando dependencias

```xml
<dependency>
  <groupId>javax</groupId>
  <artifactId>javaee-api</artifactId>
  <version>8.0.1</version>
  <scope>provided</scope>
</dependency>
<dependency>
  <!--Libreria para ejecutar el cliente del EJB--> 
</dependency>
<dependency>
  <groupId>org.glassfish.main.appclient</groupId>
  <artifactId>gf-client</artifactId>
  <version>5.0.1</version>
</dependency>
```

Por ultimo hacer un `clean and build`.

## Creacion de la interfaz remota

Creamos una interfaz y se le agrego la notacion de `@Remote`, esta notacion lo que hace es
permitir que el cliente pueda llamar a esta interfaz de manera remota. Despues definimos
el metodo que utilizara el cliente.

## Agregar la implementacion de la interfaz remota

La implementacion de la interfaz remota sera un EJB, para que esta clase se vuelva un EJB
se necesito de la notacion `@Stateless`, para ejecutar el EJB es necesario que este
desplegado en el servidor.

Proporcionamos la siguiente ruta que obtenemos al hacer `clean and build de la aplicacion`
ejemplo de ruta: `C:\Cursos\Java\U-Java\HolaMundoEJB\target`.

## agregar el EJB al servidor

Entramos en la opcion de configuracion del servidor de glashfish en `Services -> View
Domain Admin Console -> Applications -> Deploy` una vez pegamos la ruta obtenida y
seleccionamos el `.jar`.

Despues cambiamos el nombre de la aplicacion a `HolaMundoEJB`, una vez procesado este
cambio revisamos la consola del servidor para revisar los `nombre JNDI` para la
implementacion de la interfaz remota, ejemplo: `java:global/HolaMundoEJB/HolaMundoEjbImpl!beans.HolaMundoEjbRemote` este nombre se utiliza para llamar al componente
utilizando el api de JNDI - Java Naming & Directory Interface.

> JNDI permite ubicar componentes del servidor desde el cliente.

## Creacion del test

utilizamos una clase Java con un  metodo `main` dentro llamaremos al componente creado
utilizado el api de JNDI con el nombre global proporcionado una vez obtenido el componente
utilizaremos su metodo.

> Nota al hacer cambios en la interfaz o la implementacion se tiene que volver a desplegar
> la clase.
