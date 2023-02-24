package com.gm.mundo.pc;

public class Orden {
    //  Atributos:
    private final int idOrden;
    private Computadora [] computadora;
    private int contadorComputadoras;
    private static int contadorOrdenes;
    private static final int MAX_COMPUTADORAS = 10;
    
    //  metodos:
    public Orden() {
        this.idOrden = ++Orden.contadorOrdenes;
        this.computadora = new Computadora[Orden.MAX_COMPUTADORAS];
    }
    
    public void agregarComputadora(Computadora computadora) {
        if (this.contadorComputadoras < Orden.MAX_COMPUTADORAS) this.computadora[this.contadorComputadoras++] = computadora;
         else System.out.println("Has superado el limite de computadoras");
    }
    
    public String mostrarOrden() {
        StringBuilder sb = new StringBuilder();
        sb.append("Orden #").append(this.idOrden);
        sb.append("contador computadoras=").append(this.contadorComputadoras);
        sb.append("Computadoras de la orden #").append(this.idOrden);
        for (int i = 0; i < this.contadorComputadoras; i++) {
            sb.append("\n" + this.computadora[i]);
        }
        return sb.toString();
    }
}
