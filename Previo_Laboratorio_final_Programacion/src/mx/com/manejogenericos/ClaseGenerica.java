package mx.com.manejogenericos;

//  para declarar una clase como genetica se requiere la notacion
//  diamante
public class ClaseGenerica<T> {
    //  se requiere definir el tipo generico
    T objetoGenerico;
    
    public ClaseGenerica(T objetoGenerico) {
        this.objetoGenerico = objetoGenerico;
    }
    
    public void obtenerTipo() {
        System.out.println("El tipo T es " + this.objetoGenerico.getClass().getSimpleName());
    }
}
