package mx.com.claseobject;

public class Test {
    public static void main(String[] args) { 
        
    //  los objetos al usar al operador new apuntan a diferentes direcciones
    //  de memoria, es diferente en el contenido
    Empleado empl2 = new Empleado("J", 5);
    Empleado empl1 = new Empleado("J", 5);
    
    
        if (empl1 == empl2) System.out.println("Tienen la misma referencia en memoria");
        else System.out.println("Tienen distinta referencia en memoria");
        
        
        if ( empl1.equals(empl2) ) System.out.println("Los objetos son iguales en contenido");   
        else System.out.println("Los objetos son diferentes en contenido");
        
        if (empl1.hashCode() == empl2.hashCode()) System.out.println("El valor hash code es igual");
        else System.out.println("El valor de hash code de ambos son diferentes");
        
        
    //  para establecer una comparacion debemos agregar el metodo equals
    //  y hashcode 
    }
}
