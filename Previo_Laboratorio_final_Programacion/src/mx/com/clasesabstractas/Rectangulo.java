package mx.com.clasesabstractas;

public class Rectangulo extends FiguraGeometrica {

    public Rectangulo(String tipoFigura) {
        super(tipoFigura);
    }

    //  implementacion del metodo abstracto en una subclase
    @Override
    public void dibujar() {
        System.out.println("Se imprime un " + this.getClass().getSimpleName());
    }

}
