package beans;

import javax.ejb.Remote;

/**
 *
 * @author Angel Franco
 */

@Remote
public interface HolaMundoEjbRemote {
    public int sumar(int a, int b);
}
