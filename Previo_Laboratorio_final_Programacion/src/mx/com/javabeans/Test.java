package mx.com.javabeans;

public class Test {
    public static void main(String[] args) {
        //  es muy comun que al usar javabeans 
        //  solo se ocupen constructores vacios
        PersonaBean persona = new PersonaBean();
        persona.setNombre("Angel");
        persona.setApellido("Franco");
        
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Apellido: " + persona.getApellido());
    }
}
