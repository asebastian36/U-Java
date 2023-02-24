package mx.com.instanciade;

public class Test {
    
    //  instance of significa que podremos determinar el tipo del objeto
    //  en tiempo de ejecucion
    public static void main(String[] args) {
        Empleado empleadoInstancia = new Empleado("Diego", 5000000);
        determinarTipo(empleadoInstancia);
        
        empleadoInstancia = new Gerente("Chamoy", 6000000, "leloide");
        determinarTipo(empleadoInstancia);       
    }
    
    //  este metodo llamara al metodo mostrar detalles
    //  del objeto recibido, se pone el tipo mas generico
    public static void determinarTipo(Empleado empleado) {
        
        //  se utilizara para preguntar, y se debe preguntar desde las 
        //  clases mas especificas, hasta las clases mas genericas
        
        //  se esta preguntando si el apuntador empleado esta apuntando al tipo
        //  gerente
        if(empleado instanceof Gerente) {
            System.out.println("Es de tipo Gerente");
            
            //  el apuntador de tipo empleado no puede acceder al metodo
            //  getDepartamento desde el objeto Gerente, para esto hay que
            //  hacer una conversion de tipo:
            
            //  opcion 1
            ((Gerente) empleado).getDepartamento();
            
            //  opcion 2
            Gerente gerente = (Gerente) empleado;
            
            //  opcion 2 version pro
            //  ((Gerente) empleado).getDepartamento();
            
            System.out.println("gerente = " + gerente.getDepartamento());
        }
        
        else if(empleado instanceof Empleado) {
            System.out.println("Es de tipo Empleado");
            
            //  error ClassCastException
            //  Gerente gerente = (Gerente) empleado;
            //  System.out.println("gerente = " + gerente.getDepartamento());
            
            //  este error es debido a llamar desde un apuntador de tipo gerente
            //  un metodo de la clase gerente, pero apuntando a un objeto de la 
            //  clase padre que no tiene dicho metodo
        }
        
        else if(empleado instanceof Object) System.out.println("Es de tipo Object");
        
        
        System.out.println("");
        
        /*
            se esta preguntando desde la clase mas especifica hasta la mas 
            generica porque una clase muy especifica puede pertenecer o tener
            relacion con las clases mas genericas
        
            cambiar else if por if para comprobarlo 
        
            se conocio un nuevo tipo de error ClassCastException, este error
            se presenta en tiempo de ejecucion.
        */
    }
}
