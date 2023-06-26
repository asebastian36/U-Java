# Notas

Se copio el proyecto anterior **SGA-JEE-WEB-Actualizacion**.

## Cambios

* Se agrego la clase `ClienteAsociacionesJPA` para ejemplicar las asociaciones y aplicar el uso del `fetc de relaciones`.
* Se hicieron cambios en las relaciones de las clases de entidad de `Persona` y `Usuario` para cambiar el fetch de relaciones a `EAGER`.
* Se borraron los cambios a los fetch de relaciones en las clases de entidad.
* Se agregaron cambios en las clases de entidad para incluir la persistencia en cascada.

## Asociaciones en JPA

En el contexto de Java Persistence API (JPA), las asociaciones se refieren a las **relaciones entre entidades en una base de datos relacional.** JPA proporciona una forma de mapear estas relaciones y gestionarlas de manera eficiente.

Las asociaciones en JPA **se establecen mediante el uso de anotaciones en las clases de entidades.** Estas anotaciones permiten definir cómo se relacionan las entidades entre sí y cómo se debe realizar el mapeo de la base de datos.

Hay varios tipos de asociaciones en JPA, que incluyen:

1. **Asociación Uno a Uno (One-to-One):** Es una relación donde una entidad está asociada con otra entidad en un solo sentido. Cada entidad tiene una referencia a la otra entidad. Por ejemplo, una entidad "Empleado" puede tener una asociación uno a uno con una entidad "DetallesEmpleado". **Ejemplo en notacion:** `@OneToOne`

2. **Asociación Uno a Muchos (One-to-Many):** Es una relación donde una entidad está asociada con múltiples entidades de otro tipo. Por ejemplo, una entidad "Departamento" puede tener una asociación uno a muchos con una entidad "Empleado", lo que significa que un departamento puede tener varios empleados. **Ejemplo en notacion:** `@OneToMany`

3. **Asociación Muchos a Uno (Many-to-One):** Es una relación donde varias entidades de un tipo están asociadas con una única entidad de otro tipo. Por ejemplo, varias entidades "Empleado" pueden tener una asociación muchos a uno con una entidad "Departamento", lo que significa que varios empleados pueden pertenecer a un solo departamento. **Ejemplo en notacion:**`@ManyToOne`

4. **Asociación Muchos a Muchos (Many-to-Many):** Es una relación donde múltiples entidades de un tipo están asociadas con múltiples entidades de otro tipo. Por ejemplo, una entidad "Estudiante" puede tener una asociación muchos a muchos con una entidad "Clase", lo que significa que varios estudiantes pueden estar inscritos en múltiples clases, y una clase puede tener varios estudiantes. **Ejemplo en notacion:** `@ManyToMany`

Las asociaciones en JPA permiten establecer vínculos entre entidades y realizar consultas y operaciones relacionales de manera más sencilla. El JPA se encarga de mapear estas asociaciones a tablas y manejar la sincronización entre los objetos Java y los datos de la base de datos.

## Direccionalidad en las relaciones

La direccionalidad en las relaciones se refiere a la **forma en que las entidades se relacionan entre sí y si esa relación es unidireccional o bidireccional**. En el contexto de JPA, la direccionalidad de una relación determina si una entidad puede acceder directamente a otra entidad a través de la asociación o si solo una entidad puede acceder a la otra.

1. **Relación Unidireccional:** En una relación unidireccional, una entidad puede acceder a otra entidad a través de la asociación, pero la entidad objetivo de la asociación no tiene conocimiento de la entidad que la referencia. En otras palabras, la relación solo se puede seguir en una dirección. Por ejemplo, si tienes una entidad "Empleado" y una entidad "Departamento", la entidad "Empleado" puede tener una referencia al "Departamento" al que pertenece, pero el "Departamento" no tiene conocimiento directo de los empleados que pertenecen a él. La relación se define utilizando anotaciones en la entidad fuente, especificando la asociación con la entidad objetivo.

2. **Relación Bidireccional:** En una relación bidireccional, las entidades están conectadas en ambas direcciones. Cada entidad puede acceder directamente a la otra entidad a través de la asociación. Por ejemplo, si tienes una relación bidireccional entre las entidades "Empleado" y "Departamento", la entidad "Empleado" tiene una referencia al "Departamento" al que pertenece, y el "Departamento" también tiene una referencia a los empleados que pertenecen a él. La relación se define mediante anotaciones en ambas entidades, estableciendo la asociación entre ellas.

La elección entre una relación unidireccional y una relación bidireccional depende de los requisitos del modelo de datos y la forma en que se accederá y se manejarán las entidades. Las relaciones unidireccionales suelen ser más simples y suficientes en muchos casos, mientras que las relaciones bidireccionales brindan flexibilidad adicional para navegar entre entidades en ambos sentidos.

## Ejemplos prácticos de relaciones utilizando anotaciones en clases de entidad en JPA

* Relación Uno a Uno (One-to-One):

```java
@Entity
public class Empleado {
    @Id
    private Long id;

    // ...

    @OneToOne
    @JoinColumn(name = "detalle_id")
    private DetallesEmpleado detallesEmpleado;

    // ...
}

@Entity
public class DetallesEmpleado {
    @Id
    private Long id;

    // ...

    @OneToOne(mappedBy = "detallesEmpleado")
    private Empleado empleado;

    // ...
}
```

En este ejemplo, tenemos una relación uno a uno entre las entidades "Empleado" y "DetallesEmpleado". La anotación `@OneToOne` se utiliza en ambas entidades para establecer la asociación. En la clase "Empleado", la anotación `@JoinColumn` se usa para especificar la columna que se utilizará como clave extranjera en la tabla de "Empleado".

* Relación Uno a Muchos (One-to-Many):

```java
@Entity
public class Departamento {
    @Id
    private Long id;

    // ...

    @OneToMany(mappedBy = "departamento")
    private List<Empleado> empleados;

    // ...
}

@Entity
public class Empleado {
    @Id
    private Long id;

    // ...

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    // ...
}
```

En este ejemplo, tenemos una relación uno a muchos entre las entidades "Departamento" y "Empleado". La anotación `@OneToMany` se utiliza en la entidad "Departamento" para establecer la asociación, y la anotación `@ManyToOne` se utiliza en la entidad "Empleado" para indicar la relación con el departamento. La anotación `@JoinColumn` se usa para especificar la columna que se utilizará como clave extranjera en la tabla de "Empleado".

* Relación Muchos a Muchos (Many-to-Many):

```java
@Entity
public class Estudiante {
    @Id
    private Long id;

    // ...

    @ManyToMany
    @JoinTable(name = "estudiantes_clases",
               joinColumns = @JoinColumn(name = "estudiante_id"),
               inverseJoinColumns = @JoinColumn(name = "clase_id"))
    private List<Clase> clases;

    // ...
}

@Entity
public class Clase {
    @Id
    private Long id;

    // ...

    @ManyToMany(mappedBy = "clases")
    private List<Estudiante> estudiantes;

    // ...
}
```

En este ejemplo, tenemos una relación muchos a muchos entre las entidades "Estudiante" y "Clase". La anotación `@ManyToMany` se utiliza en ambas entidades para establecer la asociación. Además, se utiliza la anotación `@JoinTable` en la entidad "Estudiante" para especificar la tabla intermedia que se utilizará para almacenar la relación.

## Normalizacion y tablas transitivas

La normalización es un proceso utilizado en el diseño de bases de datos para organizar la estructura de los datos y minimizar la redundancia, lo que a su vez mejora la integridad y eficiencia de la base de datos. El objetivo principal de la normalización es evitar la duplicación innecesaria de datos y mantener la consistencia de los datos en todas las tablas.

La normalización se basa en una serie de formas normales, que establecen reglas para la organización de los datos. Las formas normales, como la Primera Forma Normal (1NF), la Segunda Forma Normal (2NF) y la Tercera Forma Normal (3NF), entre otras, se utilizan para descomponer una tabla en múltiples tablas más pequeñas y eliminar las dependencias no deseadas.

Una tabla transitiva es una tabla intermedia que se utiliza para establecer una relación entre dos tablas. Esta tabla actúa como un puente o enlace entre las dos tablas relacionadas y se crea para evitar la dependencia directa entre ellas. La tabla transitiva permite resolver una relación muchos a muchos, que no se puede representar directamente en una estructura de base de datos relacional.

En el ejemplo anterior, la tabla "Asignación" es una tabla transitiva que se utiliza para relacionar las entidades "Estudiante", "Clase" y "Profesor". En lugar de tener una relación directa entre "Estudiante" y "Profesor" o entre "Estudiante" y "Clase", la tabla "Asignación" permite establecer y gestionar correctamente la relación muchos a muchos entre estas entidades.

Al utilizar una tabla transitiva, se evita la duplicación de información en las tablas principales, ya que la información relevante se almacena en la tabla transitiva y se hace referencia a través de las claves foráneas. Además, la tabla transitiva proporciona una estructura más flexible para manejar relaciones complejas y permite realizar consultas y operaciones más eficientes en la base de datos.

**Ejemplo de cómo normalizar una relación muchos a muchos con una tabla transitiva en una base de datos relacional:**

Supongamos que tenemos tres entidades: "Estudiante", "Clase" y "Profesor". Hay una relación muchos a muchos entre "Estudiante" y "Clase", y también hay una relación muchos a muchos entre "Clase" y "Profesor". Para normalizar esta estructura, se puede introducir una tabla transitiva llamada "Asignación" que vincule las tres entidades.

* **Entidad Estudiante:**

```java
@Entity
public class Estudiante {
    @Id
    private Long id;

    // ...

    @ManyToMany
    @JoinTable(name = "asignacion",
               joinColumns = @JoinColumn(name = "estudiante_id"),
               inverseJoinColumns = @JoinColumn(name = "clase_id"))
    private List<Clase> clases;

    // ...
}
```

* **Entidad Clase:**

```java
@Entity
public class Clase {
    @Id
    private Long id;

    // ...

    @ManyToMany
    @JoinTable(name = "asignacion",
               joinColumns = @JoinColumn(name = "clase_id"),
               inverseJoinColumns = @JoinColumn(name = "profesor_id"))
    private List<Profesor> profesores;

    // ...
}
```

* **Entidad Profesor:**

```java
@Entity
public class Profesor {
    @Id
    private Long id;

    // ...

    @ManyToMany(mappedBy = "profesores")
    private List<Clase> clases;

    // ...
}
```

* **Tabla de Asignación:**

La tabla "Asignación" es una tabla intermedia que contiene las claves primarias de las entidades "Estudiante", "Clase" y "Profesor". También puede incluir otros atributos relevantes a la relación entre estas entidades.

```sql
CREATE TABLE Asignacion (
  estudiante_id INT,
  clase_id INT,
  profesor_id INT,
  PRIMARY KEY (estudiante_id, clase_id, profesor_id),
  FOREIGN KEY (estudiante_id) REFERENCES Estudiante (id),
  FOREIGN KEY (clase_id) REFERENCES Clase (id),
  FOREIGN KEY (profesor_id) REFERENCES Profesor (id)
);
```

En este ejemplo, la tabla "Asignación" actúa como una tabla transitiva que relaciona los estudiantes, las clases y los profesores. Tiene claves foráneas que hacen referencia a las claves primarias de las entidades relacionadas.

Esta estructura normalizada evita la redundancia y permite representar correctamente la relación entre los estudiantes, las clases y los profesores. La tabla "Asignación" sirve como punto de conexión entre las entidades, y las anotaciones JPA se utilizan para establecer las relaciones y mapearlas a nivel de código.

## Fetch de relaciones

En el contexto de JPA, el fetch de relaciones se refiere a la forma en que se cargan los datos de las entidades relacionadas cuando se realiza una consulta a la base de datos. El fetch determina si las entidades relacionadas se cargarán de manera ansiosa (eager) o perezosa (lazy).

* **Fetch Eager (Ansioso):**
En una relación con fetch eager, las entidades relacionadas se cargan inmediatamente junto con la entidad principal durante la consulta. Esto significa que todos los datos relacionados se recuperan de la base de datos en ese momento.

```java
@Entity
public class Departamento {
    @Id
    private Long id;

    // ...

    @OneToMany(fetch = FetchType.EAGER)
    private List<Empleado> empleados;

    // ...
}
```

En este ejemplo, la relación entre "Departamento" y "Empleado" se configura con fetch eager. Cuando se recupera un "Departamento" de la base de datos, todos los "Empleado" asociados a ese departamento también se cargarán de inmediato.

* **Fetch Lazy (Perezoso):**
En una relación con fetch lazy, las entidades relacionadas no se cargan automáticamente junto con la entidad principal durante la consulta. En su lugar, se cargarán solo cuando se acceda explícitamente a ellas.

```java
@Entity
public class Departamento {
    @Id
    private Long id;

    // ...

    @OneToMany(fetch = FetchType.LAZY)
    private List<Empleado> empleados;

    // ...
}
```

En este ejemplo, la relación entre "Departamento" y "Empleado" se configura con fetch lazy. Cuando se recupera un "Departamento" de la base de datos, los "Empleado" asociados a ese departamento no se cargarán de inmediato. Solo se cargarán cuando se acceda a la lista de empleados.

El uso de fetch eager o fetch lazy depende de las necesidades y características específicas de la aplicación. Fetch eager es útil cuando se necesita acceder a los datos relacionados de inmediato y cuando se sabe que siempre se necesitarán. Por otro lado, fetch lazy es útil cuando se desea cargar los datos relacionados solo cuando sea necesario y para evitar la sobrecarga de datos innecesarios en consultas simples.

Es importante tener en cuenta que el comportamiento predeterminado en JPA es fetch lazy para las relaciones de tipo Collection (como List, Set, etc.) y fetch eager para las relaciones de tipo OneToOne o ManyToOne. Sin embargo, esto puede ser configurado explícitamente utilizando las anotaciones `@OneToMany(fetch = FetchType.LAZY)` o `@OneToMany(fetch = FetchType.EAGER)` según sea necesario.

## Guardado en cascada

El guardado en cascada (cascade saving) es una característica en JPA que permite propagar las operaciones de guardado (persistencia) desde una entidad principal a las entidades relacionadas. En otras palabras, cuando se realiza una operación de guardado en la entidad principal, las entidades relacionadas también se guardan automáticamente sin necesidad de realizar operaciones adicionales.

El guardado en cascada es útil cuando se tienen relaciones de dependencia entre entidades y se desea mantener la consistencia de los datos de manera automática. Simplifica el código y evita tener que realizar operaciones de guardado en cada entidad relacionada de forma individual.

Las operaciones de guardado que se pueden propagar en cascada son:

1. Persistencia (INSERT): Se guarda una nueva entidad y todas las entidades relacionadas que aún no existan en la base de datos.
2. Actualización (UPDATE): Se actualizan todas las entidades relacionadas con los cambios realizados en la entidad principal.
3. Eliminación (DELETE): Se eliminan todas las entidades relacionadas cuando se elimina la entidad principal.

Para habilitar el guardado en cascada, se utiliza la anotación `cascade` en la relación de las entidades. A continuación, se muestra un ejemplo:

```java
@Entity
public class Departamento {
    @Id
    private Long id;

    // ...

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    private List<Empleado> empleados;

    // ...
}
```

En este ejemplo, la entidad "Departamento" tiene una relación `OneToMany` con la entidad "Empleado". La anotación `cascade = CascadeType.ALL` indica que se aplicará el guardado en cascada para todas las operaciones (persistencia, actualización y eliminación) en la relación. Esto significa que cuando se guarda un "Departamento", todos los "Empleados" asociados a ese departamento también se guardarán automáticamente.

Es importante tener cuidado al utilizar el guardado en cascada para evitar efectos no deseados, como la eliminación accidental de entidades relacionadas. Se debe considerar cuidadosamente la estructura de las entidades y las relaciones para garantizar que el guardado en cascada se utilice correctamente y no se produzcan resultados inesperados en la base de datos.
