package mx.com.manejogenericos;

public class TestGenericos {
    public static void main(String[] args) {
        //  instanciando una clase generica
        ClaseGenerica<Integer> instanciaGenerica0 = new ClaseGenerica(15);
        instanciaGenerica0.obtenerTipo();
        
        ClaseGenerica<Double> instanciaGenerica1 = new ClaseGenerica(15.0);
        instanciaGenerica1.obtenerTipo();
        
        ClaseGenerica<String> instanciaGenerica2 = new ClaseGenerica("UsU");
        instanciaGenerica2.obtenerTipo();
        
    }
}
