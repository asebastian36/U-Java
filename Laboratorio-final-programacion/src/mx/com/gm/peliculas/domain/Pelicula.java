package mx.com.gm.peliculas.domain;

/*
    Representa los objetos pelicula utilizados en la aplicacion
    catalogo de peliculas

    nota esta clase casi es un javabean, solo le falta implementar la interfaz
    de serializable

    Tambien se le podria denominar clase de entidad
*/

public class Pelicula {
    //  Atributo
    private String nombre;

    //  constructores
    public Pelicula() {
        
    }    
    
    public Pelicula(String nombre) {
        this();
        this.nombre = nombre;
    }

    //  setters y getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //  metodo toString
    @Override
    public String toString() {
        return nombre;
    }
}
