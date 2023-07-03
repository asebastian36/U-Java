# Notas

Se copio el proyecto anterior **AsociacionesJPA**.

## Cambios

* Creacion de la clase `PruebaJPQL` para probar las consultas de JPQL.

## Consultas con JPQL de JPA

Java Persistence Query Language (JPQL) es un **lenguaje de consultas orientado a objetos diseñado específicamente para interactuar con bases de datos utilizando el estándar de persistencia de Java**, conocido como Java Persistence API (JPA). JPQL proporciona una forma declarativa y basada en consultas para acceder y manipular objetos persistentes almacenados en una base de datos relacional.

JPQL se basa en la sintaxis de consulta de Hibernate Query Language (HQL) y está estrechamente relacionado con SQL. Sin embargo, a diferencia de SQL, que se centra en las tablas y columnas de una base de datos relacional, JPQL se centra en los objetos y sus relaciones definidas en el modelo de datos de la aplicación.

JPQL **permite a los desarrolladores realizar consultas sobre entidades (objetos persistentes) utilizando una combinación de cláusulas y expresiones similares a SQL**. Estas consultas pueden incluir criterios de selección, restricciones, ordenación y agrupación de resultados, así como también funciones y operadores para manipular y transformar datos.

Una ventaja clave de JPQL es su capacidad para escribir consultas independientes del proveedor de JPA utilizado. Esto significa que las consultas JPQL escritas para una aplicación funcionarán con cualquier proveedor de JPA compatible, lo que brinda portabilidad y flexibilidad a nivel de base de datos.

JPQL también admite la parametrización de consultas, lo que permite que los valores sean pasados como parámetros en tiempo de ejecución, lo que mejora la seguridad y la reutilización de consultas.

En resumen, JPQL es un lenguaje de consultas orientado a objetos que permite a los desarrolladores interactuar con bases de datos utilizando el estándar de persistencia de Java. Proporciona una forma declarativa y basada en consultas para acceder y manipular objetos persistentes en una base de datos relacional, independiente del proveedor de JPA utilizado.

**Ejemplos:**

* Consulta básica:

```java
String jpql = "SELECT e FROM Empleado e";
Query query = entityManager.createQuery(jpql);
List<Empleado> empleados = query.getResultList();
```

En este ejemplo, se seleccionan todos los objetos de tipo "Empleado" almacenados en la base de datos.

* Consulta con parámetros:

```java
String jpql = "SELECT p FROM Producto p WHERE p.precio > :precioMinimo";
Query query = entityManager.createQuery(jpql);
query.setParameter("precioMinimo", 50.0);
List<Producto> productos = query.getResultList();
```

En este caso, se seleccionan todos los productos cuyo precio sea mayor que un valor mínimo especificado como parámetro.

* Consulta con ordenamiento:

```java
String jpql = "SELECT c FROM Cliente c ORDER BY c.apellido, c.nombre";
Query query = entityManager.createQuery(jpql);
List<Cliente> clientes = query.getResultList();
```

Aquí, se seleccionan todos los clientes y se ordenan en función de su apellido y nombre.

* Consulta con una función agregada:

```java
String jpql = "SELECT COUNT(p) FROM Pedido p";
Query query = entityManager.createQuery(jpql);
Long count = (Long) query.getSingleResult();
```

En este ejemplo, se cuenta el número total de pedidos almacenados en la base de datos.

Estos son solo algunos ejemplos básicos para ilustrar el uso de JPQL. El lenguaje también ofrece una amplia gama de características y capacidades para realizar consultas más complejas y expresivas en función de las necesidades de la aplicación.

## Uso de JOIN en consultas JPQL

El `JOIN` es una operación utilizada en consultas JPQL para combinar registros de dos o más entidades relacionadas en función de una condición específica. Permite recuperar datos relacionados de diferentes entidades en una sola consulta.

Existen varios tipos de `JOIN` disponibles en JPQL:

* `INNER JOIN`: Devuelve solo los registros que coinciden en ambas entidades involucradas en la relación. Es decir, solo se seleccionan los registros que tienen una correspondencia en ambas tablas. Por ejemplo:

```java
SELECT c FROM Cliente c INNER JOIN c.pedidos p
```

En este caso, se seleccionan todos los clientes que tienen pedidos asociados. Solo se obtendrán los clientes que tengan al menos un pedido.

* `LEFT JOIN`: Devuelve todos los registros de la entidad de la izquierda (entidad principal en la consulta) y los registros relacionados de la entidad de la derecha, si existen. Si no hay una correspondencia en la entidad de la derecha, se devolverá un valor NULL. Por ejemplo:

```java
SELECT c FROM Cliente c LEFT JOIN c.pedidos p
```

Aquí, se seleccionan todos los clientes y los pedidos asociados, si existen. Si un cliente no tiene pedidos, se devolverá `NULL` para los atributos relacionados.

* RIGHT `JOIN`: Similar al `LEFT JOIN`, pero invierte el orden de las entidades. Devuelve todos los registros de la entidad de la derecha y los registros relacionados de la entidad de la izquierda, si existen. Si no hay una correspondencia en la entidad de la izquierda, se devolverá un valor NULL. Ejemplo:

```java
SELECT p FROM Pedido p RIGHT JOIN p.cliente c
```

En este caso, se seleccionan todos los pedidos y los clientes asociados, si existen. Si un pedido no tiene un cliente asociado, se devolverá NULL para los atributos relacionados.

Además de los tipos de `JOIN` mencionados anteriormente, también existen otros como `FULL JOIN` y `CROSS JOIN`, pero no son compatibles con todos los proveedores de JPA.

El uso de `JOIN` en JPQL permite combinar entidades relacionadas en una sola consulta, evitando la necesidad de realizar consultas separadas para recuperar información relacionada. Esto mejora la eficiencia y la claridad del código al reducir el número de consultas necesarias para obtener los datos deseados.

* Consulta con `JOIN`:

```java
String jpql = "SELECT c FROM Cliente c JOIN c.pedidos p WHERE p.total > 100";
Query query = entityManager.createQuery(jpql);
List<Cliente> clientes = query.getResultList();
```

En este ejemplo, se seleccionan todos los clientes que tienen pedidos con un total mayor a 100.

* Consulta con operadores lógicos:

```java
String jpql = "SELECT e FROM Empleado e WHERE e.edad >= 30 AND e.departamento = 'Ventas'";
Query query = entityManager.createQuery(jpql);
List<Empleado> empleados = query.getResultList();
```

Aquí, se seleccionan todos los empleados que tienen al menos 30 años de edad y trabajan en el departamento de "Ventas".

* Consulta con funciones de fecha:

```java
String jpql = "SELECT r FROM Reserva r WHERE FUNCTION('MONTH', r.fechaInicio) = 6";
Query query = entityManager.createQuery(jpql);
List<Reserva> reservas = query.getResultList();
```

En este caso, se seleccionan todas las reservas que tienen lugar en el mes de junio.

* Consulta con una subconsulta:

```java
String jpql = "SELECT p FROM Producto p WHERE p.precio > (SELECT AVG(precio) FROM Producto)";
Query query = entityManager.createQuery(jpql);
List<Producto> productos = query.getResultList();
```

Aquí, se seleccionan todos los productos que tienen un precio mayor que el precio promedio de todos los productos.

Estos ejemplos demuestran algunas de las funcionalidades más comunes de JPQL, como `JOIN`, operadores lógicos, funciones de fecha y subconsultas. Sin embargo, JPQL ofrece muchas más capacidades y características que se pueden utilizar para realizar consultas más avanzadas y personalizadas según los requerimientos de la aplicación.

**Desglose del código línea por línea:**

```java
log.debug("Consulta de todas las personas");
```
- Esta línea registra un mensaje de depuración en un registro (log) para indicar que se realizará una consulta de todas las personas. El mensaje se registra utilizando el nivel de depuración (debug).

```java
cb = em.getCriteriaBuilder();
```
- Se asigna a la variable `cb` una instancia de `CriteriaBuilder`, obtenida a partir del `EntityManager` (`em`). El `CriteriaBuilder` es utilizado para construir las consultas con Criteria API.

```java
criteriaQuery = cb.createQuery(Persona.class);
```
- Se crea una instancia de `CriteriaQuery<Persona>` utilizando el `CriteriaBuilder`. Se especifica la clase de entidad `Persona` como el tipo de resultado esperado de la consulta. Esta instancia representa la consulta que se construirá.

```java
fromPersona = criteriaQuery.from(Persona.class);
```
- Se crea un objeto `Root<Persona>` utilizando el método `from()` de la instancia de `CriteriaQuery`. Este objeto representa la entidad raíz de la consulta, en este caso, la entidad `Persona`.

```java
criteriaQuery.select(fromPersona);
```
- Se especifica que se seleccionen todos los campos de la entidad raíz (`fromPersona`). Esto indica que la consulta devolverá todos los campos de la tabla asociada a la entidad `Persona`.

```java
query = em.createQuery(criteriaQuery);
```
- Se crea una instancia de `TypedQuery<Persona>` utilizando el `EntityManager` y la instancia de `CriteriaQuery` creada anteriormente. Esta instancia de `TypedQuery` representa la consulta ejecutable.

```java
personas = query.getResultList();
```
- Se ejecuta la consulta llamando al método `getResultList()` en la instancia de `TypedQuery`. Esto devuelve una lista de resultados de tipo `Persona`. La lista de resultados se asigna a la variable `personas`.

Este código realiza una consulta para obtener todas las personas de la base de datos utilizando el API de Criteria. Primero, se construye la consulta especificando la clase de entidad, se seleccionan todos los campos y se crea una instancia de `TypedQuery` para ejecutar la consulta. Finalmente, se obtienen los resultados y se almacenan en la lista `personas`.

¡Claro! Aquí está el desglose del código línea por línea:

```java
cb = em.getCriteriaBuilder();
```
- Se asigna a la variable `cb` una instancia de `CriteriaBuilder`, obtenida a partir del `EntityManager` (`em`). El `CriteriaBuilder` es utilizado para construir las consultas con Criteria API.

```java
criteriaQuery = cb.createQuery(Persona.class);
```
- Se crea una instancia de `CriteriaQuery<Persona>` utilizando el `CriteriaBuilder`. Se especifica la clase de entidad `Persona` como el tipo de resultado esperado de la consulta. Esta instancia representa la consulta que se construirá.

```java
fromPersona = criteriaQuery.from(Persona.class);
```
- Se crea un objeto `Root<Persona>` utilizando el método `from()` de la instancia de `CriteriaQuery`. Este objeto representa la entidad raíz de la consulta, en este caso, la entidad `Persona`.

```java
criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"), 2));
```
- Se utiliza el método `select()` en la instancia de `CriteriaQuery` para especificar qué campos se seleccionarán en la consulta. En este caso, se seleccionan todos los campos de la entidad raíz (`fromPersona`).
- Se utiliza el método `where()` para agregar una condición a la consulta. En este caso, se utiliza el método `equal()` del `CriteriaBuilder` (`cb`) para crear una condición de igualdad. La condición compara el campo "idPersona" de la entidad raíz (`fromPersona`) con el valor 2.

```java
persona = em.createQuery(criteriaQuery).getSingleResult();
```
- Se crea una instancia de `TypedQuery<Persona>` utilizando el `EntityManager` (`em`) y la instancia de `CriteriaQuery` creada anteriormente. Esta instancia de `TypedQuery` representa la consulta ejecutable.
- Se ejecuta la consulta llamando al método `getSingleResult()` en la instancia de `TypedQuery`. Esto devuelve un solo resultado de tipo `Persona`, que se asigna a la variable `persona`.

Este código realiza una consulta utilizando el API de Criteria para obtener una persona con un `idPersona` específico (en este caso, 2). Primero, se construye la consulta especificando la clase de entidad y la condición de igualdad. Luego, se crea una instancia de `TypedQuery` para ejecutar la consulta y se obtiene el resultado único, que se asigna a la variable `persona`.

**Desglose del código línea por línea:**

```java
cb = em.getCriteriaBuilder();
```
- Se asigna a la variable `cb` una instancia de `CriteriaBuilder`, obtenida a partir del `EntityManager` (`em`). El `CriteriaBuilder` es utilizado para construir las consultas con Criteria API.

```java
criteriaQuery = cb.createQuery(Persona.class);
```
- Se crea una instancia de `CriteriaQuery<Persona>` utilizando el `CriteriaBuilder`. Se especifica la clase de entidad `Persona` como el tipo de resultado esperado de la consulta. Esta instancia representa la consulta que se construirá.

```java
fromPersona = criteriaQuery.from(Persona.class);
```
- Se crea un objeto `Root<Persona>` utilizando el método `from()` de la instancia de `CriteriaQuery`. Este objeto representa la entidad raíz de la consulta, en este caso, la entidad `Persona`.

```java
criteriaQuery.select(fromPersona);
```
- Se especifica que se seleccionen todos los campos de la entidad raíz (`fromPersona`). Esto indica que la consulta devolverá todos los campos de la tabla asociada a la entidad `Persona`.

```java
List<Predicate> criterios = new ArrayList<Predicate>();
```
- Se crea una lista llamada `criterios` para almacenar predicados. Los predicados permiten agregar varios criterios dinámicamente a la consulta.

```java
Integer idPersonaParam = 6;
ParameterExpression<Integer> parameter = cb.parameter(Integer.class, "idPersona");
criterios.add(cb.equal(fromPersona.get("idPersona"), parameter));
```
- Se crea un parámetro llamado `idPersona` de tipo `Integer` utilizando el método `parameter()` del `CriteriaBuilder`. Este parámetro se utilizará para agregar un criterio a la consulta.
- Se utiliza el método `equal()` del `CriteriaBuilder` para crear un predicado de igualdad. El predicado compara el campo "idPersona" de la entidad raíz (`fromPersona`) con el parámetro `idPersona`.
- El predicado se agrega a la lista `criterios` utilizando el método `add()`.

```java
if(criterios.isEmpty()) throw new RuntimeException("Sin criterios");
else if(criterios.size() == 1) criteriaQuery.where(criterios.get(0));
else criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0])));
```
- Se verifica si la lista de `criterios` está vacía. Si es así, se lanza una excepción.
- Si la lista tiene un solo criterio, se utiliza el método `where()` del `CriteriaQuery` para especificar ese criterio en la consulta.
- Si hay más de un criterio, se utiliza el método `and()` del `CriteriaBuilder` para combinar los criterios en un predicado lógico "AND", y luego se especifica ese predicado en la consulta.

```java
query = em.createQuery(criteriaQuery);
query.setParameter("idPersona", idPersonaParam);
```
- Se crea una instancia de `TypedQuery<Persona>` utilizando el `EntityManager` y la instancia de `CriteriaQuery` creada anteriormente. Esta instancia de `TypedQuery` representa la consulta ejecutable.
- Se utiliza el método `setParameter()` en la instancia de `TypedQuery` para asignar el valor `idPersonaParam` al parámetro `idPersona` de la consulta.

```java
persona = query.getSingleResult();
```
- Se ejecuta la consulta llamando al método `getSingleResult()` en la instancia de `TypedQuery`. Esto devuelve un solo
