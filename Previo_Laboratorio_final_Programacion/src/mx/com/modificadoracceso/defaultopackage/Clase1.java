package mx.com.modificadoracceso.defaultopackage;

//  Clase default o package
//  ausencia del modificador aplica a clases, atributos y metodos
//  solo puede ser utilizada por clases que esten en el mismo 
//  paquete
class Clase1 {
    String atributoDefault = "Valor atributo default"; 
    
    Clase1() {
        System.out.println("Constructor default");
    }
    
    void metodoDefault() {
        System.out.println("Metodo default");
    }
}
