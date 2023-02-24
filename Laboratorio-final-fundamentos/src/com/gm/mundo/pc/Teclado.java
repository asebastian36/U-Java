package com.gm.mundo.pc;

public class Teclado extends DispositivoEntrada{
    //  Atributos:
    private final int idTeclado;
    private static int contadorTeclados;
    
    //  metodos:
    public Teclado(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        this.idTeclado = ++Teclado.contadorTeclados;
    }
    
    public static int getContadorTeclados() {
        return Teclado.contadorTeclados;
    }

    public static void setContadorTeclados(int aContadorTeclados) {
        Teclado.contadorTeclados = aContadorTeclados;
    }
    
    public int getIdTeclado() {
        return this.idTeclado;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("idTeclado =").append(idTeclado);
        sb.append(super.toString());
        return sb.toString();
    }
}
