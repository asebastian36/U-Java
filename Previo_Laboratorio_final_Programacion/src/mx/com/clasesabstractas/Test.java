package mx.com.clasesabstractas;

public class Test {
    public static void main(String[] args) {
        //  aplicando upcasting y polimorfismo
        FiguraGeometrica figura = new Rectangulo("Rectangulo");
        figura.dibujar();
        
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
}
