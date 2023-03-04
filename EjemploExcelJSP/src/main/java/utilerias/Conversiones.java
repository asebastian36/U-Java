package utilerias;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author asebastian36
 */


public class Conversiones {
    private static final String FORMATO_FECHA = "dd/MM/yy";
    
    public static String format(Date fecha) {
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
    }
}
