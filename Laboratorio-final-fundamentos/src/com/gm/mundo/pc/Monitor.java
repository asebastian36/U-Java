package com.gm.mundo.pc;

public class Monitor {
    //  Atributos:
    private final int idMonitor;
    private String marca;
    private double tamano;
    private static int contadorMonitores;
    
    //  metodos:
    private Monitor() {
        this.idMonitor = ++Monitor.contadorMonitores;
    }
    
    public Monitor(String marca, double tamano) {
        this();
        this.marca = marca;
        this.tamano = tamano;
    }

    public int getIdMonitor() {
        return this.idMonitor;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getTamano() {
        return this.tamano;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }
    
    public static int getContadorMonitores() {
        return Monitor.contadorMonitores;
    }

    public static void setContadorMonitores(int ContadorMonitores) {
        Monitor.contadorMonitores = ContadorMonitores;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Monitor{");
        sb.append("idMonitor=").append(idMonitor);
        sb.append(", marca=").append(marca);
        sb.append(", tamano=").append(tamano);
        sb.append('}');
        return sb.toString();
    }
}
