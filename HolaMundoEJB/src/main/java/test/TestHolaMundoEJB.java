package test;

import beans.HolaMundoEjbRemote;
import javax.naming.*;

/**
 *
 * @author Angel Franco
 */

public class TestHolaMundoEJB {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente\n");
        try {
            //  variable para ubicar el componente
            Context jndi = new InitialContext();
            //  lookup nos retorna el componente como un object
            HolaMundoEjbRemote holaMundo = (HolaMundoEjbRemote) jndi.lookup("java:global/HolaMundoEJB/HolaMundoEjbImpl!beans.HolaMundoEjbRemote");
            int resultado = holaMundo.sumar(5000, 8000);
            System.out.println("resultado = " + resultado);
        } catch(NamingException e) {
            e.printStackTrace(System.out);
        }
    }
}