package mx.com.autoboxingunboxing;

public class TestAutoboxingUnboxing {
    public static void main(String[] args) {
        //  tiene que ver con el tema de tipos primitivos y sus clases
        //  envolventes o clases wrapper
        
        //  pasar de literal primitiva a literal tipo object
        Integer entero = 10;//  Autoboxing
        System.out.println("entero = " + entero);
        System.out.println("entero double = " + entero.doubleValue());
        
        //  pasar de literal tipo object a literal tipo primitiva
        int entero2 = entero;// Unboxing
        System.out.println("entero2 = " + entero2);
    }
}
