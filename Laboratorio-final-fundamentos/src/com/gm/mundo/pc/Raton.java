package com.gm.mundo.pc;

public class Raton extends DispositivoEntrada{
    //  Atributos:
    private final int idRaton;
    private static int contadorRatones;
    
    //  metodos:
    public Raton(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        idRaton = contadorRatones;
        contadorRatones++;
    }
    
    public static int getContadorRatones() {
        return Raton.contadorRatones;
    }
    
    public int getIdRaton() {
        return this.idRaton;
    }

    public static void setContadorRatones(int ContadorRatones) {
        Raton.contadorRatones = ContadorRatones;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Raton{");
        sb.append("idRaton=").append(idRaton);
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
