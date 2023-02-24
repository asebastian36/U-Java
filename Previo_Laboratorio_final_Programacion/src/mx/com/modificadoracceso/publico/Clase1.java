package mx.com.modificadoracceso.publico;
//  analizar como afecta el modificador de acceso public desde todos sus usos
public class Clase1 {
    public String atributoPublico = "Valor atributo publico";
    
    public Clase1() {
        System.out.println("Constructor Publico");
    }
    
    public void metodoPublico() {
        System.out.println("Metodo publico");
    }
    
    //  conclusion el modificador de acceso public es el - restrictivo y nos permitira
    //  acceder a cada uno de los elementos desde cualquier otra clase sin restricciones
}
