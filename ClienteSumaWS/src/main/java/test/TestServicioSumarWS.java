package test;

import clientews.servicio.ServicioSumarImplService;
import clientews.servicio.ServicioSumarWS;

/**
 *
 * @author angel
 */

public class TestServicioSumarWS {
    public static void main(String[] args) {
        ServicioSumarWS servicio = new ServicioSumarImplService().getServicioSumarImplPort();
        System.out.println("Ejecutando servicio sumar WS");
        int a = 3500;
        int b = 5000;
        int resultado = servicio.sumar(a, b);
        System.out.println("Resultado de " + a + " + " + b + " = " + resultado);
    }
}
