package mx.com.modificadoracceso.defaultopackage;


public class TestModificadorAccesoDefault {
    public static void main(String[] args) {
        //  Desde el mismo paquete podemos usar la clase default sin ser
        //  una clase hija
        Clase1 clase1 = new Clase1();
        
        //  se puede acceder al atributo y modificarlo
        System.out.println("atributo default " + clase1.atributoDefault);
        
        //  podemos acceder al metodo package
        clase1.metodoDefault();
        
        //  conclusion
        //  se usa el modificador default cuando solo queremos que nuestra clase,
        //  atributos o metodos sean accedidos por clases hijas en el mismo paquete 
        //  o clases que esten en el mismo paquete
    }
}
