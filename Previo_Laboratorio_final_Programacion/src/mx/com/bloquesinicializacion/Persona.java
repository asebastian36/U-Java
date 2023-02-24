package mx.com.bloquesinicializacion;

public class Persona {
    //  hay dos tipos de bloques de inicializacion
    //  estaticos y no estaticos, se ejecutan antes que el constructor
    
    private final int idPersona;
    private static int contadorPersonas;
    
    //  bloque de inicializacion estatico
    //  se ejecuta solo una vez, cuando la clase se carga en memoria,
    //  se carga el contexto estatico
    static{
        System.out.println("Ejecutacion bloque estatico");
        ++Persona.contadorPersonas;
    }
    
    //  bloque de inicializacion no estatico
    //  se ejecuta cada vez que se instancia la clase
    {
        System.out.println("Ejecucion bloque NO estatico");
        this.idPersona = Persona.contadorPersonas++;
    }
    
    public Persona() {
        System.out.println("Ejecucion del constructor");
    }

    public int getIdPersona() {
        return this.idPersona;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + '}';
    }
}
