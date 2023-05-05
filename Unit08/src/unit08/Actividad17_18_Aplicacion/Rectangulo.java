package unit08.Actividad17_18_Aplicacion;

/*
    Actividad 18
    Hereda de Poligono e implementa la Clase Rectangulo
 */
public class Rectangulo extends Poligono{

    public Rectangulo(double base, double altura) {
        super(base, altura);
    }

    @Override
    public double area() {
        return this.getBase() * this.getAltura();
    }
}
