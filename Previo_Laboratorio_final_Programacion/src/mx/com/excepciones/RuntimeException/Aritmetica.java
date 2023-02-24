package mx.com.excepciones.RuntimeException;

public class Aritmetica {
    public static int division(int numerador, int denominador) {
        if ( denominador == 0) {
            //  prevenimos que puede pasar una excepcion con esta sintaxis
            throw new OperacionExcepciones("Division entre cero");
        }
        
        return numerador / denominador;
    }
}
