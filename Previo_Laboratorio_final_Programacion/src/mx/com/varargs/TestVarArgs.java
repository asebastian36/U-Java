package mx.com.varargs;

import mx.com.enums.Continentes;

public class TestVarArgs {
    public static void main(String[] args) {
        //  salidas de la primera enumeracion (Enumeraciones)
        //  pasamos argumentos variables a un metodo
        //  imprimirNumeros(3, 4, 5, 6, 7, 7, 8,9);
        //  variosParametros("Angel", 5, 6, 7, 99);
        
        //  salida de la enumeracion continentes
        for (Continentes continentes : Continentes.values()) {
            System.out.println("Continente " + continentes);
            System.out.println("No. Paises " + continentes.getPaises());
            System.out.println("Poblacion " + continentes.getHabitantes() + " de habitantes");
            System.out.println("");
        }
        

    }
    
    //  uso de argumentos variables
    private static void imprimirNumeros(int... numeros) {
        //  esta variable de argumentos variables se convierte en un arreglo
        for (int i = 0;i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
    }
    
    private static void variosParametros(String nombre, int... numeros) {
        //  nota las varargs debe ser el ultimo argumento en la firma del metodo
        System.out.println("nombre: " + nombre);
        imprimirNumeros(numeros);
    }
}
