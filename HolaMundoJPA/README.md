# Introduccion a Java Persistance API (JPA)

Java Persistence API, o JPA, es una especificación de Java que **proporciona un conjunto de interfaces y clases para administrar la persistencia de datos en aplicaciones Java**. La persistencia se refiere a la capacidad de almacenar y recuperar objetos en una base de datos de manera transparente, sin tener que preocuparse por los detalles específicos del almacenamiento de datos.

**JPA se basa en el patrón de diseño ORM (Object-Relational Mapping), que permite mapear objetos Java a tablas en una base de datos relacional**. El objetivo principal de JPA es simplificar el acceso y la manipulación de datos en la capa de persistencia de una aplicación.

Una de las ventajas clave de JPA es que ofrece una capa de abstracción sobre los proveedores de persistencia subyacentes, como Hibernate, EclipseLink o Apache OpenJPA. Esto significa que **puedes escribir código JPA independiente del proveedor, lo que te permite cambiar fácilmente de un proveedor a otro sin tener que modificar tu código**.

Para utilizar JPA, primero debes definir una entidad en tu aplicación. Una entidad es una clase Java que representa una tabla en la base de datos. Puedes anotar la clase con las anotaciones proporcionadas por JPA para establecer las relaciones entre las entidades y los atributos de la base de datos.

Luego, puedes usar el Administrador de Entidades (Entity Manager) para realizar operaciones de persistencia, como guardar, actualizar o eliminar entidades en la base de datos. El Entity Manager se encarga de administrar el ciclo de vida de las entidades y proporciona métodos para realizar consultas y transacciones.

JPA también ofrece un lenguaje de consulta llamado JPQL (Java Persistence Query Language) que te permite escribir consultas orientadas a objetos en lugar de consultas SQL tradicionales. Esto facilita la manipulación de datos y evita la necesidad de escribir consultas específicas del proveedor.

## Caracteristicas de JPA

**Mapeo objeto-relacional (ORM):** JPA proporciona un mecanismo de mapeo que permite representar objetos Java como entidades persistentes en una base de datos relacional. Esto significa que puedes trabajar con objetos en tu código Java y JPA se encargará de mapearlos a tablas y columnas en la base de datos.

**Independencia del proveedor:** JPA proporciona una capa de abstracción sobre los proveedores de persistencia subyacentes. Esto significa que puedes escribir código JPA independiente del proveedor y cambiar fácilmente de un proveedor a otro sin tener que modificar tu código. Los proveedores más populares incluyen Hibernate, EclipseLink y Apache OpenJPA.

**Administración del ciclo de vida de las entidades:** JPA se encarga del ciclo de vida de las entidades. Esto significa que puedes crear, recuperar, actualizar y eliminar entidades utilizando métodos proporcionados por el Administrador de Entidades (Entity Manager). JPA también gestiona la sincronización entre las entidades y la base de datos.

**Consultas orientadas a objetos:** JPA proporciona el lenguaje de consulta JPQL (Java Persistence Query Language), que te permite realizar consultas orientadas a objetos en lugar de consultas SQL tradicionales. JPQL es similar a SQL, pero trabaja con entidades y atributos en lugar de tablas y columnas. Esto facilita la manipulación y recuperación de datos de manera más intuitiva.

**Asociaciones y relaciones entre entidades:** JPA permite establecer asociaciones y relaciones entre entidades. Puedes definir relaciones uno a uno, uno a muchos, muchos a uno y muchos a muchos utilizando anotaciones en tus clases de entidad. Estas relaciones se reflejarán en el esquema de la base de datos y JPA se encargará de administrar la integridad referencial.

**Transacciones:** JPA admite transacciones, lo que significa que puedes agrupar varias operaciones de persistencia en una única transacción. Esto garantiza la consistencia de los datos y permite la recuperación en caso de errores o fallos en el sistema. Puedes gestionar transacciones utilizando anotaciones o programáticamente.

**Caché de entidades:** JPA proporciona una caché de entidades en memoria que mejora el rendimiento de la aplicación al reducir las consultas a la base de datos. La caché de entidades almacena objetos recuperados de la base de datos en memoria y los actualiza automáticamente cuando se realizan cambios. Esto evita consultas innecesarias a la base de datos y mejora el rendimiento general.

## Clases de entidad JPA

En el contexto de JPA (Java Persistence API), las clases de entidad son **clases de Java que representan entidades persistentes en una base de datos relacional**. Una entidad es un objeto que se guarda y recupera de una base de datos y se asocia con una tabla en la base de datos.

Las clases de entidad en JPA deben cumplir con ciertas reglas y anotaciones para que puedan ser administradas por el proveedor de persistencia. Estas reglas incluyen:

* **Anotación @Entity:** Debe agregar la anotación @Entity en la clase para indicar que es una entidad persistente.

* **Identificador:** La clase debe tener un campo o propiedad que se utiliza como identificador único para cada instancia de la entidad. El identificador se anota con la anotación @Id.

* **Generación de identificador:** Puedes utilizar la anotación @GeneratedValue en conjunto con @Id para especificar cómo se generará automáticamente el valor del identificador, por ejemplo, utilizando una estrategia de generación de claves primarias.

* **Mapeo de atributos:** Debes mapear los atributos de la entidad a las columnas de la tabla correspondiente en la base de datos. Puedes utilizar varias anotaciones de mapeo, como @Column para especificar el nombre de la columna, el tipo de datos y otras propiedades.

* **Relaciones:** Si la entidad tiene relaciones con otras entidades, debes establecer las anotaciones de mapeo apropiadas, como @OneToOne, @OneToMany, @ManyToOne o @ManyToMany, según el tipo de relación que desees establecer.

* **Constructor predeterminado:** La clase de entidad debe tener un constructor predeterminado sin argumentos.

Una vez que hayas definido tus clases de entidad según estas reglas, puedes utilizar el EntityManager de JPA para administrar la persistencia de las entidades. Esto incluye operaciones como guardar, actualizar, eliminar y buscar entidades en la base de datos.

Ejemplo:

```java
@Entity
public class Persona {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private Integer telefono;

    //  no se agregaron mas anotaciones dado que se llaman
    //  igual que las columnos de la tabla

    //  constructores, getters y setters
}
```

## Arquitectura empresarial con JPA

La arquitectura empresarial con JPA (Java Persistence API) se basa en el **patrón de diseño de tres capas, que separa la lógica empresarial en diferentes componentes para mejorar la modularidad, la escalabilidad y el mantenimiento del sistema**. JPA se utiliza en la capa de persistencia para interactuar con la base de datos relacional.

* **Capa de presentación (Interfaz de usuario):** Esta capa se encarga de la interacción con el usuario. Puede ser una interfaz web, una aplicación de escritorio o cualquier otra forma de interfaz que permita a los usuarios interactuar con el sistema. En esta capa, se capturan las solicitudes del usuario y se muestran los resultados.

* **Capa de lógica empresarial (Capa de servicio):** Aquí se encuentra la lógica de negocio de la aplicación. Los componentes de esta capa se encargan de procesar las solicitudes recibidas de la capa de presentación, realizar las validaciones necesarias, coordinar las operaciones de datos y realizar cualquier otra tarea relacionada con la lógica empresarial. En esta capa, se definen las interfaces de servicio que especifican los métodos que se pueden invocar desde la capa de presentación.

* **Capa de persistencia (Capa de acceso a datos):** Esta capa se ocupa de la persistencia de datos y la comunicación con la base de datos. Aquí es donde JPA entra en juego. Los componentes de esta capa utilizan JPA para mapear las clases de entidad a las tablas de la base de datos, realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) y ejecutar consultas personalizadas. La capa de persistencia se comunica con la base de datos y devuelve los resultados a la capa de lógica empresarial.

* **Base de datos:** Es el componente final de la arquitectura. Aquí se almacenan los datos persistentes de la aplicación. JPA se encarga de traducir las operaciones realizadas en la capa de persistencia en instrucciones SQL para interactuar con la base de datos.

La arquitectura empresarial con JPA **proporciona una separación clara de responsabilidades y permite una fácil mantenibilidad y extensibilidad del sistema**. JPA simplifica la capa de persistencia al proporcionar una API orientada a objetos para trabajar con la base de datos, evitando la necesidad de escribir consultas SQL directamente.

## API de JPA y Entity manager

El API de JPA (Java Persistence API) es una **especificación de Java que define una serie de interfaces y anotaciones para el manejo de la persistencia de datos en aplicaciones Java**. Proporciona una capa de abstracción sobre la capa de persistencia subyacente, lo que permite a los desarrolladores interactuar con diferentes sistemas de bases de datos relacionales de manera uniforme.

El componente central del API de JPA es el EntityManager. El **EntityManager es una interfaz que actúa como una interfaz de alto nivel para interactuar con la unidad de persistencia**. La unidad de persistencia es una **colección de entidades y sus relaciones**, y se representa mediante una clase llamada `EntityManagerFactory`.

A continuación, te explico algunas de las principales funciones y conceptos relacionados con el EntityManager:

* **Gestión del ciclo de vida de las entidades:** El EntityManager permite crear, leer, actualizar y eliminar entidades persistentes. Puedes utilizar métodos como persist() para guardar una nueva entidad, find() para buscar una entidad por su identificador, merge() para actualizar una entidad y remove() para eliminar una entidad.

* **Transacciones:** El EntityManager te permite administrar transacciones para garantizar la integridad de los datos. Puedes iniciar y finalizar transacciones utilizando métodos como begin() y commit(), respectivamente. También puedes utilizar la anotación @Transactional para que las operaciones se realicen dentro de una transacción automáticamente.

* **Consultas:** El EntityManager proporciona métodos para ejecutar consultas sobre las entidades. Puedes utilizar el lenguaje de consultas orientado a objetos llamado JPQL (Java Persistence Query Language) para realizar consultas, utilizando el método createQuery() del EntityManager.

* **Caché de primer nivel:** El EntityManager mantiene una caché de primer nivel para mejorar el rendimiento de las operaciones de lectura y escritura. La caché de primer nivel almacena las entidades que han sido recuperadas o persistidas recientemente, lo que evita la necesidad de realizar múltiples consultas a la base de datos.

* **Gestión de relaciones:** El EntityManager facilita la administración de relaciones entre entidades. Puedes establecer relaciones utilizando métodos como set() y get(), y JPA se encargará de mantener la consistencia de las relaciones en la base de datos.

* **Transacciones distribuidas:** JPA también admite transacciones distribuidas utilizando la anotación @Transactional y proporciona soporte para la administración de transacciones en entornos de múltiples bases de datos.

## Funciones del persistence.xml en JPA

El archivo `persistence.xml` es un archivo de configuración utilizado en JPA (Java Persistence API) para definir la configuración de la persistencia de datos en una aplicación. Funciones principales del archivo persistence.xml:

1. Configuración de la unidad de persistencia: El archivo persistence.xml se utiliza para definir y configurar una o varias unidades de persistencia. Cada unidad de persistencia representa una fuente de datos específica, como una base de datos. Dentro del archivo, se especifican detalles como el nombre de la unidad de persistencia, el proveedor de persistencia utilizado, la conexión a la base de datos, entre otros.

2. Mapeo de clases de entidad: El persistence.xml también se utiliza para especificar las clases de entidad que se deben administrar y persistir. Las clases de entidad representan los objetos que se guardarán en la base de datos. En el archivo, se definen las rutas de las clases de entidad utilizando la etiqueta `<class>`. Estas clases deben estar anotadas con la anotación @Entity para que sean reconocidas por JPA.

3. Configuración de propiedades: El archivo persistence.xml permite configurar propiedades específicas relacionadas con la persistencia de datos. Esto incluye detalles como el proveedor de persistencia que se utilizará, la estrategia de generación de claves primarias, el nivel de registro y otras opciones de configuración específicas del proveedor de JPA.

4. Definición de transacciones y caché: El persistence.xml también se utiliza para configurar el comportamiento de las transacciones y la caché de primer nivel. Puedes especificar detalles sobre cómo se administrarán las transacciones, como el tipo de transacción (local o global), el control de propagación y otras opciones relacionadas. También puedes configurar opciones de caché, como activar o desactivar la caché de primer nivel y especificar estrategias de caché específicas.

5. Configuración de proveedores adicionales: El persistence.xml permite agregar proveedores adicionales específicos del proveedor de JPA utilizado. Estos proveedores pueden tener propiedades y configuraciones específicas adicionales que se pueden definir en el archivo persistence.xml.

Ejemplo de la unidad de persistencia:

```xml
<persistence>
  <persistence-unit name="PersonaService" transaction-type="RESOURCE_LOCAL">
    <class>domain.Persona</class>
    <properties>
      <property name="javax.persistence.jdbc.driver"
                value="org.apache.derby.jdbc.ClientDriver"/>
      <property name="javax.persistance.jdbc.url"
                value="jdbc:derby://localhost:1527/PersonaServDB;create=true"/>
      <property name="javax.persistence.jdbc.user" value="APP"/>
      <property name="javax.persistence.jdbc.password" value="APP"/>
    </properties>
  </persistence-unit>
</persistence>
```

Ejemplo de uso de unidad de persistencia y del Entity manager:

```java
@Stateless
public class PersonaServiceBean implements PersonaService {

  //  esta parte se inyecta al desplegar el ejb al servidor
  @PersistenceContext(unitName="PersonaService")
  EntityManager em;

  public void agregar(Persona persona) {
    em.persist(persona);
  }

  public Persona encontrar(int id) {
    return em.find(Persona.class, id);
  }

  public Persona modificar(int id, String nombre) {
    Persona persona = em.find(Persona.class, id);

    if(persona != null) persona.setNombre(nombre);

    return persona;
  }

  public void eliminar(int id) {
    Employee emp = em.find(Employee.class, id);
    em.remove(emp);
  }
}
```
