package mx.com.excepciones.RuntimeException;

public class TestExcepciones {
    public static void main(String[] args) {
        int resultado = 0;
        
        try {
            //  condicion que genera la excepcion
            resultado = Aritmetica.division(10, 0);
            
            //  solucion o medida para que no termine el programa
            //  se puede procesar mas de una excepcion:
            
        } catch (OperacionExcepciones e) {
            System.out.println("Ocurrio un error de tipo OperacionExcepciones: ");
            System.out.println(e.getMessage());
        } catch(Exception e) {
            //  es un metodo que llama a la pila de excepciones
            //  e.printStackTrace(System.out);
            System.out.println("Ocurrio un error");
            System.out.println(e.getMessage());
            
            //  entonces este metodo llama a esas excepciones a salida en consola
        } finally {
            System.out.println("Se reviso la division entre cero");
        }
        
        //  el bloque finally se puede utilizar para cerrar recursos
        
        System.out.println("resultado = " + resultado);
    }
}
