package beans;

import org.apache.logging.log4j.*;

/**
 *
 * @author angel
 */

public class HolaMundoAction {
    Logger log = LogManager.getLogger();
    
    private String saludos;
    
    //  tener un metodo execute hace a una clase un Action
    public String execute() {
        log.info("Ejecutando metodo execute desde Struts2");
        this.setSaludos("Adios desde Struts2");
        return "exito";
    }

    public String getSaludos() {
        return saludos;
    }

    public void setSaludos(String saludos) {
        this.saludos = saludos;
    }
}
