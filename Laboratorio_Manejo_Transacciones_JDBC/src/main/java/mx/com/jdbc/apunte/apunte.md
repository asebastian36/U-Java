# Nota del proyecto laboratorio manejo de transacciones JDBC

```java
//  sintaxis para obtener conexion con la bd
Conection conexion = null;

conn = Conexion.getConnection();
```
> Esta sintaxis se repite en todos los metodos de las clases DAO porque cada instruccion SQL
> habre y cierra una conexion.

Sin embargo en el manejo de transacciones no funciona asi, dado que en una sola transaccion podemos ejecutar diferentes sentencias sobre una bd, no necesariamente sobre una tabla en particular sino que puede ser sobre cualquier tabla de la bd y una transaccion puede hacer rollback de todas esas sentencias de una sola vez, sin embargo para que esta transaccion pueda manejar el rollback o el commit de estas sentencias SQL **se necesita sea la misma conexion a la bd** si no se hace una misma conexion a la bd no se podra hacer el rollback ni el commit a ese grupo de sentencias

## cambio para poder hacer transacciones con JDBC

---
Se agrega el atributo de tipo `Connection` y se agrega un constructor que inicie el atributo.
>la mayor diferencia de tener la misma conexion es que al ejecutarse una sentencia esta no se cerrara al terminar de ejecutarse sino que se mantendra abierta y la conexion se manejara fuera de esta clase y la clase externa decidira si se hara commit o rollback en toda la transaccion.

```java
public class PersonaDAO {
    //  atributo con la conexion
    private Connection conexionTransacciones;

    //  constructores 
    public PersonaDAO(Connection conexionTransacciones) {
        this.conexionTransacciones = conexionTransacciones;
    }

    public PersonaDAO() {
    }
}
```

Falta que los metodos usen la conexion del atributo en lugar de obtener una nueva, Este cambio se hace en todos los metodos de las sentencias SQL y tambien todos los metodos deben propagar sus excepciones con un `throw` en la firma del metodo.

```java
//  ejemplo de los cambios
public List<Persona> seleccionar() throws SQLException {
    Connection conexion = null;
    conexion = this.conexionTransacciones != null? this.conexionTransacciones : Conexion.getConnection();
}

//  para cerrar la conexion si es una conexion creada en el metodo
if (this.conexionTransacciones == null) Conexion.close(conexion);
```

## codigo para la prueba
```java
//  creamos una conexion en el main

//  se definio fuera del try-catch porque no solo se necesita en el metodo try
Connection conexion = null;
        
try {
    //  obtenemos una conexion y desactivamos el autocommit
    conexion = Conexion.getConnection();
    if (conexion.getAutoCommit()) conexion.setAutoCommit(false);
    
    //  iniciamos la clase DAO con la conexion (esto hace posible el rollback y el commit)
    PersonaDAO personaDAO = new PersonaDAO(conexion);
            
    //  aqui empezamos las transacciones
    personaDAO.insertar(new Persona("Palaalaa", "UwU", "palaaa@mail.com", "5588226633"));        personas = personaDAO.seleccionar();
            
    personas.forEach(persona -> {
        System.out.println("persona = " + persona);
    });
    
    //  hasta este momento se guardan los cambios de la transaccion
    conexion.commit();
    System.out.println("se ha hecho commit de la transaccion");

    } catch (SQLException ex) {
        //  esto solo se ejecuta en caso de error
        ex.printStackTrace(System.out);
        System.out.println("Entramos al rollback");
            
    try {
        //  aqui se aplica el rollback fuera del try
        conexion.rollback();
    } catch (SQLException ex1) {
            ex1.printStackTrace(System.out);
    }
}
```

> Nota un conjunto de instrucciones SELECT no es necesario hacer una transaccion porque no afectan el estado de la bd, para las demas tipo de sentencias si es necesario porque cambian el estado de la bd.
