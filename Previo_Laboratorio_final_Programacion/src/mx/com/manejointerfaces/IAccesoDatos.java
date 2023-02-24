package mx.com.manejointerfaces;

public interface IAccesoDatos {
    //  se tiene que declarar un valor obligatoriamente a las constantes
    //  al definirla
    int MAX_REGISTRO = 10;
    
    //  todos los metodos son publicos y abstractos
    void insertar();
    
    void listar();
    
    void actualizar();
    
    void eliminar();
    
    
    //  clases abstractas vs interfaces
        
        /*
            en ambas los metodos no tienen una implementacion,
            pero en una interfaz todos los metodos son abstractos
            en las interfaces todos los atributos son constantes
        
            tip para sabes cuando usar una interfaz o una clase abstracta
        
            se usa una clase abstracta cuando la relacion entre clases es de
            herencia.
        
            y se usa una interfaz cuando la relacion entre clases es de 
            comportamiento en comun.
        */

}
