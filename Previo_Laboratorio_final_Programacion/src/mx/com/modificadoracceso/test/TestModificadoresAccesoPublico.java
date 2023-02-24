package mx.com.modificadoracceso.test;

import mx.com.modificadoracceso.publico.Clase1;

public class TestModificadoresAccesoPublico {
    public static void main(String[] args) {
        //  cuando una clase es public la podemos usar sin ninguna restriccion
        //  ya sea en el mismo paquete o desde otro paquete
        Clase1 clase1 = new Clase1();
        
        //  cuando un atributo es public lo podemos usar sin ninguna restriccion
        //  ya sea en el mismo paquete o desde otro paquete
        System.out.println("clase1 = " + clase1.atributoPublico);
        
        //  cuando un constructor es public lo podemos usar sin ninguna restriccion
        //  ya sea en el mismo paquete o desde otro paquete
        
        //  cuando un metodo es public lo podemos usar sin ninguna restriccion
        //  ya sea en el mismo paquete o desde otro paquete
        clase1.metodoPublico();
    }
}
