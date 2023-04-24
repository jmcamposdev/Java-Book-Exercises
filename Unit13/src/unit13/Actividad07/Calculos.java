package unit13.Actividad07;

public class Calculos {
    public Integer cuadrado (Integer a) {
        return a*a;
    }
    public Integer cubo (Integer x) {
        return x*x*x;
    }
    public static Double raiz3 (Double x) {
        return Math.pow(x, 1./3);
    }
    public static Double raizN (Double base, Integer n) {
        return Math.pow(base, 1./n);
    }

    public static Double producto (Double a, Double b) {
        return a*b;
    }
}
