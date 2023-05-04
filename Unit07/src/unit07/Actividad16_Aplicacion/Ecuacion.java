package unit07.Actividad16_Aplicacion;

/*
    Implementa una clase que permita resolver ecuaciones de segundo grado. Los coeficientes
    pueden indicarse en el constructor y modificarse a posteriori. Es fundamental que la clase disponga
    de un método que devuelva las distintas soluciones y de un método que nso informe si el discriminante
    es positivo.

 */
public class Ecuacion {
    double a, b, c;
    boolean discriminantePositivo;

    public Ecuacion(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        discriminantePositivo = discriminantePositivo();
    }

    public Ecuacion() {
        this(0, 0, 0);
    }

    public double getA() {
        return a;
    }
    public void setA(double a) {
        this.a = a;
        discriminantePositivo = discriminantePositivo();
    }

    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
        discriminantePositivo = discriminantePositivo();
    }

    public double getC() {
        return c;
    }
    public void setC(double c) {
        this.c = c;
        discriminantePositivo = discriminantePositivo();
    }



    public boolean discriminantePositivo() {
        // Si el discriminante es positivo, hay dos soluciones reales
        return (Math.pow(b, 2) - 4 * a * c) > 0;
    }

    public double[] soluciones() {
        if (!discriminantePositivo) { // Si el discriminante es negativo, no hay soluciones reales
            return null;
        }

        // Si el discriminante es positivo, hay dos soluciones reales
        double[] soluciones = new double[2];
        soluciones[0] = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
        soluciones[1] = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
        return soluciones;
    }

    public String toString() {
        return "Ecuacion: " + a + "x^2 + " + b + "x + " + c;
    }
}
