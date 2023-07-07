# Notas

Se copio el proyecto anterior **AsociacionesJPA**.

## Cambios

* Cambios en la capa de servicio (en la implementacion) en el metodo de actualizar.
* Cambios en el `persistence.xml` para volver a usar glassfish.
* Cambio en la clase de `Persona` para eliminar temporalmente una validacion.

## Manejo de transacciones

El manejo de transacciones en Java EE (Enterprise Edition) se refiere a la **forma en que se administran las operaciones que implican cambios en la base de datos o en otros recursos**. Una transacción es una secuencia de operaciones que se deben ejecutar como una unidad indivisible, es decir, o se ejecutan todas o ninguna. El objetivo de las transacciones es garantizar la integridad de los datos y mantener la consistencia en el sistema.

Java EE proporciona un conjunto de API (Application Programming Interface) para manejar transacciones de manera fácil y eficiente. Aquí hay algunos conceptos clave relacionados con el manejo de transacciones en Java EE:

1. **Gestor de transacciones:** Java EE utiliza un gestor de transacciones para administrar la coordinación y el control de las transacciones. El gestor de transacciones se encarga de iniciar, comprometer o revertir una transacción, y asegurarse de que todas las operaciones dentro de la transacción se realicen correctamente. El gestor de transacciones se integra con el contenedor de aplicaciones Java EE.

2. **Anotaciones:** Java EE utiliza anotaciones para marcar las operaciones que deben ejecutarse dentro de una transacción. Por ejemplo, la anotación `@Transactional` se puede utilizar para indicar que un método debe ejecutarse dentro de una transacción. Las anotaciones se colocan en los métodos o clases relevantes.

3. **Control de transacciones declarativo:** Java EE permite el control de transacciones declarativo, lo que significa que las transacciones se definen mediante metadatos en lugar de tener que escribir código explícito para administrar las transacciones. Esto simplifica el desarrollo y evita la duplicación de código.

4. **Control de transacciones programático:** Además del control declarativo, Java EE también permite el control de transacciones programático. Esto significa que puedes escribir código Java para iniciar, comprometer o revertir transacciones de forma manual. El control programático ofrece una mayor flexibilidad, pero también requiere más trabajo y es propenso a errores si no se maneja adecuadamente.

5. **Niveles de aislamiento:** Java EE admite diferentes niveles de aislamiento para las transacciones, que definen cómo se comparten los datos entre las transacciones concurrentes. Algunos de los niveles de aislamiento comunes son: READ_UNCOMMITTED, READ_COMMITTED, REPEATABLE_READ y SERIALIZABLE. El nivel de aislamiento adecuado se selecciona según los requisitos del sistema.

Java EE ofrece una serie de mecanismos para el manejo de transacciones, desde el control declarativo hasta el control programático. Esto facilita la administración de transacciones y ayuda a mantener la consistencia de los datos en las aplicaciones empresariales desarrolladas en Java EE.

**Ejemplos de código en Java EE para mostrar cómo se puede manejar las transacciones:**

* Uso de anotaciones `@Transactional`:

```java
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserService {

    @PersistenceContext(unitName = "myPersistenceUnit")
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createUser(User user) {
        // Lógica para crear un nuevo usuario
        entityManager.persist(user);
    }
}
```

En este ejemplo, la anotación `@Transactional` se utiliza para indicar que el método `createUser` debe ejecutarse dentro de una transacción. La anotación `@PersistenceContext` se utiliza para inyectar el `EntityManager` que se utilizará para interactuar con la base de datos.

* Control programático de transacciones:

```java
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UserService {

    @PersistenceContext(unitName = "myPersistenceUnit")
    private EntityManager entityManager;

    public void createUser(User user) {
        UserTransaction userTransaction = getUserTransaction();
        try {
            userTransaction.begin();
            // Lógica para crear un nuevo usuario
            entityManager.persist(user);
            userTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                userTransaction.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private UserTransaction getUserTransaction() {
        // Obtener la referencia a UserTransaction desde el contenedor
        // Este código puede variar dependiendo del contenedor de la aplicación
        // Aquí se muestra un ejemplo básico para ilustrar el concepto
        return (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
    }
}
```

En este ejemplo, se utiliza el control programático de transacciones utilizando la interfaz `UserTransaction`. Se inicia una transacción, se ejecuta la lógica para crear un nuevo usuario y, si todo va bien, se realiza el commit. Si ocurre alguna excepción, se realiza un rollback para deshacer los cambios.

Estos son solo ejemplos básicos para ilustrar cómo se puede manejar las transacciones en Java EE. Es importante tener en cuenta que la configuración y el código específico pueden variar dependiendo del contenedor de aplicaciones y de la configuración de persistencia utilizada en tu proyecto.

## Manejo de una transaccion

El manejo de transacciones en Java EE **implica seguir un conjunto de pasos para asegurar la integridad de los datos y garantizar que las operaciones se realicen correctamente**. Pasos comunes para el manejo de una transacción en Java EE:

1. **Anotar el método o clase:** Para indicar que un método o clase debe ejecutarse dentro de una transacción, se utilizan anotaciones como `@Transactional` o `@TransactionAttribute`. Estas anotaciones se colocan en el nivel apropiado, dependiendo de si se quiere aplicar transacciones a nivel de método o de clase.

2. **Inyección de recursos:** Si se necesita interactuar con una base de datos u otro recurso durante la transacción, es necesario inyectar los recursos correspondientes. En Java EE, se utiliza la anotación `@PersistenceContext` para inyectar el `EntityManager` para la interacción con la base de datos.

3. **Inicio de la transacción:** La transacción se inicia antes de ejecutar las operaciones que deben ser parte de la misma. Esto puede hacerse de forma automática utilizando el enfoque declarativo a través de las anotaciones mencionadas en el paso 1, o de forma programática utilizando la interfaz `UserTransaction`.

4. **Ejecución de operaciones:** Dentro de la transacción, se realizan las operaciones necesarias en la base de datos o en otros recursos. Estas operaciones pueden incluir inserciones, actualizaciones, eliminaciones, consultas, etc.

5. **Commit o rollback:** Después de que todas las operaciones se han ejecutado sin errores, se realiza el commit para confirmar los cambios en la base de datos. Si ocurre alguna excepción o error, se realiza un rollback para deshacer los cambios y dejar la base de datos en su estado anterior.

6. **Cierre de la transacción:** Una vez que se ha realizado el commit o rollback, la transacción se cierra. Esto puede hacerse automáticamente utilizando el enfoque declarativo o programáticamente llamando a los métodos `commit()` o `rollback()` de la interfaz `UserTransaction`.

Es importante tener en cuenta que el manejo de transacciones en Java EE puede variar según el contenedor de aplicaciones que estés utilizando, así como la configuración de persistencia y el enfoque elegido (declarativo o programático). Además, es necesario considerar los niveles de aislamiento y otras configuraciones específicas para asegurar un manejo adecuado de las transacciones en tu aplicación.

## Configuracion de propagacion en Java EE

La configuración de propagación (propagation) en Java EE se refiere a cómo se propagan las transacciones entre métodos o componentes en una aplicación empresarial. En otras palabras, **define cómo se comporta una transacción existente cuando se llama a otro método o componente que también está involucrado en transacciones.**

La configuración de propagación es especialmente relevante en situaciones donde múltiples métodos o componentes se llaman entre sí y cada uno de ellos puede requerir su propia transacción. La propagación determina si una transacción existente se suspende, continúa o se fusiona con la nueva transacción solicitada.

En Java EE, se pueden utilizar anotaciones o configuraciones XML para establecer la propagación de transacciones. Algunas de las opciones comunes de propagación disponibles son:

1. `REQUIRED` (predeterminado): Si un método se ejecuta sin una transacción activa, se crea una nueva transacción para ese método. Si ya hay una transacción activa, el método se ejecuta dentro de la transacción existente.

2. `REQUIRES_NEW`: Se crea una nueva transacción para el método, incluso si ya existe una transacción activa. La transacción anterior, si la hay, se suspende temporalmente hasta que se complete el método actual.

3. `MANDATORY`: El método requiere una transacción existente. Si no hay ninguna transacción activa, se producirá una excepción.

4. `SUPPORTS`: El método se ejecuta sin una transacción activa, pero si existe una transacción, el método se ejecutará dentro de ella.

5. `NOT_SUPPORTED`: El método se ejecuta sin una transacción activa, y si existe una transacción, se suspenderá temporalmente hasta que el método se complete.

6. `NEVER`: El método no permite una transacción. Si existe una transacción activa, se producirá una excepción.

La configuración de propagación permite controlar cómo se manejan las transacciones en diferentes partes de una aplicación. Es importante considerar cuidadosamente la propagación adecuada para asegurar la coherencia y consistencia de los datos en un contexto transaccional. La elección de la configuración de propagación correcta depende de los requisitos y el diseño de tu aplicación.
