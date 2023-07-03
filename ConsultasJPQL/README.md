# Notas

Se copio el proyecto anterior **ConsultasJPQL**.

## Cambios

* Creacion de la clase `PruebaCriteria`.

## Consultas con el API de criteria

Las consultas con el API de Criteria se refieren a la forma de realizar consultas o búsquedas específicas en una base de datos utilizando el lenguaje de consulta de Criteria. Criteria es una API de Java que proporciona una forma programática de **construir consultas dinámicamente y realizar operaciones de filtrado, ordenamiento y proyección en una base de datos relacional**.

El API de Criteria se utiliza comúnmente en el desarrollo de aplicaciones Java que interactúan con bases de datos utilizando el estándar Java Persistence API (JPA). Permite construir consultas de manera más flexible y legible en comparación con el uso de consultas SQL directamente.

Algunas características y operaciones que se pueden realizar con el API de Criteria incluyen:

1. **Filtrado:** Se pueden agregar restricciones o condiciones a una consulta utilizando operadores como igualdad, desigualdad, mayor que, menor que, entre otros.

2. **Ordenamiento:** Los resultados de la consulta se pueden ordenar según uno o varios campos, en orden ascendente o descendente.

3. **Proyección:** Es posible seleccionar solo los campos específicos que se desean recuperar de la base de datos en lugar de obtener todos los campos de una entidad.

4. **Joins:** Se pueden realizar uniones o combinaciones de entidades relacionadas utilizando operadores de join.

5. **Agregaciones:** Se pueden realizar operaciones de agregación, como sumas, promedios, máximos o mínimos, en los resultados de la consulta.

6. **Paginación:** Es posible limitar la cantidad de resultados recuperados y obtener solo una porción específica de los mismos para implementar la paginación en los resultados.

Estas son solo algunas de las funcionalidades que se pueden lograr utilizando el API de Criteria. La forma exacta de construir y ejecutar consultas puede variar dependiendo del ORM (Object-Relational Mapping) utilizado y de la implementación específica del API de Criteria en el framework o biblioteca que se esté utilizando.

**Ejemplos de consultas utilizando el API de Criteria en Java:**

* Ejemplo de consulta básica:

```java
CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
Root<Product> root = criteriaQuery.from(Product.class);
criteriaQuery.select(root);

List<Product> products = entityManager.createQuery(criteriaQuery).getResultList();
```

En este ejemplo, se crea una consulta para obtener todos los productos de la base de datos. Se utiliza el `CriteriaBuilder` para construir la consulta, se especifica la entidad raíz (Product) y se seleccionan todos los campos de esa entidad. Luego se ejecuta la consulta y se obtienen los resultados.

* Ejemplo de consulta con filtrado:

```java
CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
Root<Product> root = criteriaQuery.from(Product.class);
criteriaQuery.select(root);

Predicate condition = criteriaBuilder.equal(root.get("category"), "Electronics");
criteriaQuery.where(condition);

List<Product> products = entityManager.createQuery(criteriaQuery).getResultList();
```

En este ejemplo, se agrega un filtro a la consulta anterior para obtener solo los productos de la categoría "Electronics". Se utiliza el `CriteriaBuilder` para construir una condición de igualdad (equal) en el campo "category" de la entidad. Luego se agrega esta condición a la consulta utilizando el método `where`. La consulta final solo recuperará los productos que cumplan con la condición especificada.

* Ejemplo de consulta con ordenamiento:

```java
CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
Root<Product> root = criteriaQuery.from(Product.class);
criteriaQuery.select(root);

criteriaQuery.orderBy(criteriaBuilder.asc(root.get("price")));

List<Product> products = entityManager.createQuery(criteriaQuery).getResultList();
```

En este ejemplo, se realiza una consulta para obtener todos los productos, pero esta vez se ordenan por el campo "price" en orden ascendente. Se utiliza el método `orderBy` para especificar el ordenamiento de la consulta. La consulta final devolverá los productos ordenados según el precio.

Estos son solo algunos ejemplos básicos para darte una idea de cómo se construyen las consultas utilizando el API de Criteria. Puedes combinar diferentes operaciones y condiciones para crear consultas más complejas según tus necesidades específicas.
