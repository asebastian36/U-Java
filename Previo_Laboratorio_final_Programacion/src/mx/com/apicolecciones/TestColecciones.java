package mx.com.apicolecciones;

import java.util.*;

public class TestColecciones {
    public static void main(String[] args) {
        //  creacion de una instancia de una lista
        List miLista = new ArrayList();
        
        //  agregar valores a la lista:
        miLista.add("Domingo");
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");
        miLista.add("Sabado");
        miLista.add("Sabado");
        
        System.out.println("dias de la semana con una lista");
        imprimir(miLista);
        
        //  en las listas se pueden repetir elementos
        //  las listas si respetan un orden
        
        //  creacion de una instacia de un set
        Set miSet = new HashSet();
        
        //  agregar valores a un set
        miSet.add("Domingo");
        miSet.add("Lunes");
        miSet.add("Martes");
        miSet.add("Miercoles");
        miSet.add("Jueves");
        miSet.add("Viernes");
        miSet.add("Sabado");
        miSet.add("Sabado");
        
        System.out.println("dias de la semana con un set");
        imprimir(miSet);
        
        //  crear instancia de un map
        Map miMapa = new HashMap();
        
        //  agregar valores a un map
        miMapa.put("valor 0", ":-D");
        miMapa.put("valor 1", ":-(");
        miMapa.put("valor 2", ":-)");
        miMapa.put("valor 3", ":-|");
        
        //  obtener un elemento
        String valor =(String) miMapa.get("valor 3");
        System.out.println("valor = " + valor + "\n");
        
        System.out.println("iteracion de las llaves del map");
        imprimir(miMapa.keySet());
        
        System.out.println("iteracion de los valores del map");
        imprimir(miMapa.values());
    }
    
    public static void imprimir(Collection coleccion) {
        //  forma de iterar opcion 1:
        for(Object dias: coleccion) {
//            System.out.println("dia: " + dias);
        }
        
        //  opcion 2 con expresiones lamda:
        coleccion.forEach(elemento -> {
            System.out.println("elemento = " + elemento);
        });
        System.out.println("");
    }
}
