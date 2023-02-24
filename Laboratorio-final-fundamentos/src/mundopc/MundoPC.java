package mundopc;

import com.gm.mundo.pc.*;

public class MundoPC {
    public static void main(String[] args) {
        //  test de dispositivos de entrada
        Teclado tecladoCorsair0 = new Teclado("USB", "Corsair");
        Raton mouseLogitech0 = new Raton("bluetooth", "Logitech");
        Monitor monitorLG0 = new Monitor("LG", 27);
        
        Computadora miLap = new Computadora("mi laptop mas o menos", monitorLG0, tecladoCorsair0, mouseLogitech0);
        
        Orden pedido0 = new Orden();
        pedido0.agregarComputadora(miLap);
        
        Teclado tecladoCorsair1 = new Teclado("USB", "Corsair");
        Raton mouseLogitech1 = new Raton("bluetooth", "Logitech");
        Monitor monitorLG1 = new Monitor("LG", 27);
        
        Computadora miLap1 = new Computadora("mi laptop mas o menos", monitorLG0, tecladoCorsair0, mouseLogitech0);
        
        pedido0.agregarComputadora(miLap1);
        System.out.println(pedido0.mostrarOrden());
        
        
                
     }
}
