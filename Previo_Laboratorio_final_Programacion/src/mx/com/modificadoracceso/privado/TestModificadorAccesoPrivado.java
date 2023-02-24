package mx.com.modificadoracceso.privado;


public class TestModificadorAccesoPrivado {

    public static void main(String[] args) {
        Clase1 clase1 = new Clase1("Publico");
        
        clase1.setAtributoPrivado("cambio en atributo privado");
        System.out.println(clase1.getAtributoPrivado());
    }
}
