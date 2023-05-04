package unit07.Actividad20_Aplicacion;

/*
    Escribe la clase Punto que representa un punto en el plano (con un componente x y un componente y), con los métodos:
        • Punto (double x, double y) : construye un objeto con los datos pasados como parámetros.
        • void desplazax (double dx): incrementa el componente x en la cantidad dx.
        • void desplazaY (double dy): incrementa el componente y en la cantidad dy.
        • void desplaza (double dx, double dy): desplaza ambos componentes según las
          cantidades dx (en el eje x) y dy (en el componente y).
        • double distanciaEuclidea (Punto otro): calcula y devuelve la distancia euclídea
          entre el punto invocante y el punto otro.
        • void muestra (): muestra por consola la información relativa al punto.
 */
public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void desplazaX(double dx) {
        this.x += dx;
    }

    public void desplazaY(double dy) {
        this.y += dy;
    }

    public void desplaza(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public double distanciaEuclidea(Punto otro) {
        return Math.sqrt(Math.pow(this.x - otro.x, 2) + Math.pow(this.y - otro.y, 2));
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
