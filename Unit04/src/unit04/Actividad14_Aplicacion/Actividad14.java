package unit04.Actividad14_Aplicacion;

/*
    Implementa la función
        static double distancia(double x1, double y1, double x2, double y2)
    que devuelve la distancia entre los puntos (x1,y1) y (x2,y2).
    La formula para calcular la distancia entre dos puntos es:
        d = raiz_cuadrada((x2 - x1)^2 + (y2 - y1)^2)
 */
public class Actividad14 {
    public static void main(String[] args) {
        System.out.println(distancia(1, 3, 2, 2));
        System.out.println(distancia(4, 1, 3, 3));
        System.out.println(distancia(4, 1, 4, 4));
    }

    private static double distancia(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
