package mx.com.enums;

public enum Continentes {
    //  enumeracion con el atributos
    AFRICA(53, "1.2 billones"),
    ASIA(44, "4600 millones"),
    OCEANIA(14, "43 millones"),
    EUROPA(46, "746.4 millones"),
    AMERICA(34, "1.002 miles de millones");
    
    private final int paises;
    private final String habitantes;
    
    Continentes(int paises, String habitantes) {
        this.paises = paises;
        this.habitantes = habitantes;
    }
    
    public int getPaises() {
        return this.paises;
    }
    
    public String getHabitantes() {
        return this.habitantes;
    }
}
