package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

/*
    Contiene las opecaciones a ejecutar en el archivo peliculas.txt
*/

public interface IAccesoDatos {
    //  se agrega la sintaxis throws a la firma del metodo para 
    //  indicar que puede haber una excepcion y especificamos el tipo
    boolean existe(String nombreArchivo) throws AccesoDatosEx;
    
    List<Pelicula> listar(String nombre) throws LecturaDatosEx;
    
    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar)throws EscrituraDatosEx;
    
    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
    
    void crear(String nombreArchivo) throws AccesoDatosEx;
    
    void borrar(String nombreArchivo) throws AccesoDatosEx;
}
