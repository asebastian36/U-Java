package mx.com.excepciones.exception;

public class Aritmetica {
    //  pero tambien debe estar en la firma del metodo
    public static int division(int numerador, int denominador) throws OperacionExcepciones {
        if ( denominador == 0) {
            //  prevenimos que puede pasar una excepcion con esta sintaxis
            throw new OperacionExcepciones("Division entre cero");
        }
        
        return numerador / denominador;
    }
}
