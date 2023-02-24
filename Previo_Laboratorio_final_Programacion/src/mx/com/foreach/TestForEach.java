package mx.com.foreach;
    
public class TestForEach {
    //  for each, for mejorado
    public static void main(String[] args) {
        int edades[] = {1, 2, 3, 4, 5};
        for(int i : edades) {
            System.out.println("i = " + i);
        }
        
        //  desventaja del for each
        //  perdemos el contador que nos daba acceso
        //  a la informacion de los indices del arreglo y/o lista
        
        //  for each no permite el uso de var, para declarar arreglos 
        
        //  recorrer un arreglo de tipo object con for each
        Persona personas[] = {new Persona("Angel"), new Persona("Sebastian"), new Persona("Franco"), new Persona("Lopez")};
        for(Persona personaActual : personas) {
            System.out.println("personaActual = " + personaActual);
        }
    }
}
