package mx.com.gm.peliculas.excepciones;

//  nota se elegio la excepcion de tipo Exception con fines didacticos
public class AccesoDatosEx extends Exception{
    //  agregamos un constructor con el string que tenga los detalles
    //  de la excepcion y lo pasamos al constructor de la clase padre
    public AccesoDatosEx(String mensaje) {
        super(mensaje);
    }
    
    //  despues haremos lo mismo con las excepciones hijas
}
