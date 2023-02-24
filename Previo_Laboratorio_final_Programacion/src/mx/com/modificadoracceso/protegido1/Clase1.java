package mx.com.modificadoracceso.protegido1;

//  El modificador de acceso protegido no es utilizable en clases
//  solo en constructores, atributos y metodos
public class Clase1 {
    protected String atributoProtegido = "Valor atributo protected";
    //  se podra acceder desde las clases padres, hijas
    //  o las clases que esten en el mismo paquete
    
    protected Clase1() {
        System.out.println("Constructor protected");
    }
    
    public Clase1(String argumento) {
        System.out.println("Constructor Publico");
    }
    
    protected void metodoProtegido() {
        System.out.println("Metodo protected");
    }

    public String getAtributoProtegido() {
        return this.atributoProtegido;
    }

    public void setAtributoProtegido(String atributoProtegido) {
        this.atributoProtegido = atributoProtegido;
    }
    
    //  conclusion cualquier clase que este fuera del paquete de la clase 
    //  con los (atributos, constructores, metodos) protected no tendra 
    //  acceso directo a estos
}
