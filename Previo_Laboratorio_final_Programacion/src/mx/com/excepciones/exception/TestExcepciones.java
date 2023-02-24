package mx.com.excepciones.exception;

public class TestExcepciones {
    public static void main(String[] args) {
        int resultado = 0;
        
        try {
            //  condicion que genera la excepcion
            resultado = Aritmetica.division(10, 0);
            
            //  solucion o medida para que no termine el programa
        } catch(Exception e) {
            //  es un metodo que llama a la pila de excepciones
            //  e.printStackTrace(System.out);
            System.out.println(e.getMessage());
            
            //  entonces este metodo llama a esas excepciones a salida en consola
        }
        
        System.out.println("resultado = " + resultado);
    }
}
