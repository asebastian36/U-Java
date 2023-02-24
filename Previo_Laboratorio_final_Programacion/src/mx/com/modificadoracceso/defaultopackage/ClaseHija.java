package mx.com.modificadoracceso.defaultopackage;


public class ClaseHija extends Clase1{
    ClaseHija() {
        super();
        System.out.println("atributo default " + this.atributoDefault);
        this.metodoDefault();
    }
    
}
