# Notas

Se clono la solucion porque esta el codigo igual y no se porque falla.

## Cambios

* Se agrego una clase de entidad `Usuario`, se cambio la clase `Persona` por una generada con el IDE que ya generaba el codigo y la relacion con la base de datos en las clases.

## Ciclo de vida en JPA

El ciclo de vida  en JPA (Java Persistence API) **describe el estado y las transiciones que experimenta una entidad gestionada por JPA a medida que interactúa con la base de datos**. A continuación, se presenta un resumen de los estados y las etapas del ciclo de vida en JPA:

1. **Estado Transitorio (Transient):** Una entidad se encuentra en este estado cuando se crea mediante el operador `new`, pero aún no está asociada con un contexto de persistencia.

2. **Estado Gestionado (Managed):** Cuando se realiza una operación persistente en una entidad transitoria, esta pasa al estado gestionado. En este estado, cualquier cambio realizado en la entidad se reflejará automáticamente en la base de datos una vez que se complete la transacción.

3. **Estado Eliminado (Removed):** Si se invoca el método `EntityManager.remove()` en una entidad gestionada, esta pasará al estado eliminado. La entidad se eliminará de la base de datos una vez que se complete la transacción.

4. **Estado Desconectado (Detached):** Una entidad gestionada se convierte en desconectada cuando se cierra la sesión del `EntityManager` o se termina la transacción. En este estado, los cambios realizados en la entidad no se sincronizarán automáticamente con la base de datos.

5. **Estado Fusionado (Merged):** Cuando se invoca el método `EntityManager.merge()` en una entidad desconectada, esta pasa al estado fusionado. En este estado, los cambios realizados en la entidad se sincronizarán con la base de datos una vez que se complete la transacción.

6. **Estado Actualizado (Refreshed):** Se puede invocar el método `EntityManager.refresh()` en una entidad gestionada para actualizar su estado con los datos más recientes de la base de datos.

Estos son los estados principales en el ciclo de vida de una entidad en JPA. El ciclo de vida permite a JPA realizar la administración automática de las entidades y facilita la persistencia y recuperación de datos en la base de datos.

## Aciones con el ciclo de vide da JPA

### Persistir un objeto en JPA

```java
@Test
public void testPersistirObjeto() {
    //  paso 1. crea un objeto
    //  entrado a estado transitivo
    Persona persona1 = new Persona();

    //  paso 2. Iniciar transaccion
    EntityTransaction tx = em.getTransaction();
    tx.begin();

    //  paso 3. se ejecuta SQL
    em.persist(persona1);

    //  paso 4. Commit/rollback
    tx.commit();

    //  objeto en estado detached
    log.debug("objeto persistido: " + persona1);
}
```

### Recuperar un objeto de entidad en JPA

```java
@Test
public void testEncontrarObjeto() {
    //  Paso 1. iniciar transaccion
    EntityTransaction tx = em.getTransaction();
    tx.begin();

    //  paso 2. ejecuta SQL de tipo select por id
    Persona persona1 = em.find(Persona.class, 23);

    //  paso 3. Termina transaccion
    tx.commit();

    //  Objeto en estado detached
    log.debug("Objeto recuperado: " + persona1);
}
```

### Actualizar un objeto persistente en JPA

```java
@Test
public void testActualizarObjeto() {
    //  Paso 1. inicia transaccion 1 (obtener el valor)
    EntityTransaction tx1 = em.getTransaction();
    tx1.begin();

    //  paso 2. ejecuta SQL de tipo select por id
    Persona persona1 = em.find(Persona.class, 23);

    //  paso 3. Termina transaccion
    tx.commit();

    //  Objeto en estado detached
    log.debug("Objeto recuperado: " + persona1);

    //  paso 4. establecer nuevos valores
    persona1.setApeMaterno("Nava");

    //  paso 5. iniciar transaccion 2 (guardar el valor ya modificado)
    EntityTransaction tx2 = em.getTransaction();
    tx2.begin();

    //  paso 6. ejecuta SQL (sincronizar el objeto modificado a la bd)
    em.merge(persona1);

    //  paso 7. Termina transaccion 2, se aplicacan los cambios al objeto
    tx2.commit();

    //  pobjeto en estado detached ya modificado
    log.debug("Objeto modificado: " + persona1);
}
```

### Actualizar un objeto persistente con sesion larga

```java
@Test
public void testActualizarObjetoSesionLarga() {
    //  Paso 1. inicia transaccion 1
    EntityTransaction tx1 = em.getTransaction();
    tx1.begin();

    //  paso 2. Ejecutar SQL de tipo select
    Persona persona1 = em.fing(Persona.class, 23);

    //  paso 3. setValue (establecer nuevos valores en el objeto recuperado)
    persona1.setApeMaterno("Aguirre");
    persona1.setApePaterno("Torres");

    //  paso 4. termina la transaccion1
    //  ejecuta el update con los cambios sobre el objeto
    tx1.commit();

    //  objeto en estado detached
    log.debug("Objeto recuperado: " + persona1);
}
```

### Eliminar un objeto persistente en JPA

```java
@Test
public void testEliminarObjeto() {
    //  Paso 1. inicia transaccion 1 (obtener el valor)
    EntityTransaction tx1 = em.getTransaction();
    tx1.begin();

    //  paso 2. ejecuta SQL de tipo select por id
    Persona persona1 = em.find(Persona.class, 23);

    //  paso 3. Termina transaccion
    tx.commit();

    //  Objeto en estado detached
    log.debug("Objeto recuperado: " + persona1);

    //  paso 4. iniciar transaccion 2 (eliminar el valor obtenido)
    EntityTransaction tx2 = em.getTransaction();
    tx2.begin();

    //  paso 5. ejecuta SQL (delete)
    em.remove(persona1);

    //  paso 6. Termina transaccion 2, se eliminara al hacer el commit
    tx2.commit();

    //  objeto en estado transitivo ya modificado
    //  ya no es posible resincronizarlo en otra transaccion,
    //  solo esta en memoria, pero al terminar de ejecutar el metodo
    //  se eliminara
    log.debug("Objeto eliminado: " + persona1);
}
```
