package mx.com.manejogenericos;

import java.util.*;

public class TestColeccionesGenericas {
    public static void main(String[] args) {
        //  implementando tipos genericos a las colecciones:
        
        //  sintaxis:
        List<String> miLista = new ArrayList<>();
        
        miLista.add("Domingo");
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");
        miLista.add("Sabado");
        miLista.add("Sabado");
        
        //  recuperar un elemento de la lista
//        String dato = miLista.get(0);
        
        System.out.println("dias de la semana con una lista");
        imprimir(miLista);
        
        //  sintaxis:
        Set<Integer> miSet = new HashSet<>();
        
        miSet.add(1);
        miSet.add(2);
        miSet.add(3);
        miSet.add(4);
        miSet.add(5);
        miSet.add(5);
        miSet.add(6);
        miSet.add(7);
        
        System.out.println("enumeracion con un set");
        imprimir(miSet);
        
        //  Sintaxis
        Map<String, String> miMapa = new HashMap();
        
        miMapa.put("valor 0", ":-D");
        miMapa.put("valor 1", ":-(");
        miMapa.put("valor 2", ":-)");
        miMapa.put("valor 3", ":-|");
        
        //  nota cuando ya utilizamos una llave para asociarla a un valor
        //  al repetirla reemplazara el valor que tenia por el valor nuevo
        miMapa.put("valor 3", "<3");
        
        String valor = miMapa.get("valor 3");
        System.out.println("valor = " + valor + "\n");
        
        System.out.println("iteracion de las llaves del map");
        imprimir(miMapa.keySet());
        
        System.out.println("iteracion de los valores del map");
        imprimir(miMapa.values());
    }
    
    public static void imprimir(Collection coleccion) {
        coleccion.forEach(elemento -> {
            System.out.println("elemento = " + elemento);
        });
        
        System.out.println("");
    }
}
