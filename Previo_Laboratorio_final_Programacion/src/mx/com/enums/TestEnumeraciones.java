package mx.com.enums;

public class TestEnumeraciones {
    public static void main(String[] args) {
        //  ejemplo de como usar un elemento de una enumeracion
        //  Enumeraciones.LUNES;
        
        indicarDiaSemana(Enumeraciones.SABADO);
    }
    
    private static void indicarDiaSemana(Enumeraciones dias) {
        switch(dias) {
            case LUNES:
                System.out.println("Segundo dia de la semana");
                break;
            
            case MARTES:
                System.out.println("Tercer dia de la semana");
                break;
                
            case MIERCOLES:
                System.out.println("Cuarto dia de la semana");
                break;
            
            case JUEVES:
                System.out.println("Quinto dia de la semana");
                break;
                
            case VIERNES:
                System.out.println("Sexto dia de la semana");
                break;
            
            case SABADO:
                System.out.println("Septimo dia de la semana");
                break;
                
            case DOMINGO:
                System.out.println("Primer dia de la semana");
                break;
                
            default:
                System.out.println("Este dia no esta");
        }
    }
}
