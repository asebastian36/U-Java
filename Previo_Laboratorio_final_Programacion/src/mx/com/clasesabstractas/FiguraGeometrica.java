package mx.com.clasesabstractas;

//  se utiliza cuando definimos un metodo o metodos sin comportamiento
//  nota debe tener al menos un metodo abstracto, y las clases abstractas
//  no se instancian
public abstract class FiguraGeometrica {
    //  atributo
    private String tipoFigura;

    //  metodos
    protected FiguraGeometrica(String tipoFigura) {
        this.tipoFigura = tipoFigura;
    }
    
    //  metodo abstracto
    public abstract void dibujar();

    public String getTipoFigura() {
        return this.tipoFigura;
    }

    public void setTipoFigura(String tipoFigura) {
        this.tipoFigura = tipoFigura;
    }

    @Override
    public String toString() {
        return "FiguraGeometrica{" + "tipoFigura=" + tipoFigura + '}';
    }
}
