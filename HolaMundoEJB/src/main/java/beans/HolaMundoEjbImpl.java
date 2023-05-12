package beans;

import javax.ejb.Stateless;

/**
 *
 * @author Angel Franco
 */

@Stateless
public class HolaMundoEjbImpl implements HolaMundoEjbRemote{
    @Override
    public int sumar(int a, int b) {
        System.out.println("Ejecutando metodo suma en el servidor");
        return a + b;
    }
}
