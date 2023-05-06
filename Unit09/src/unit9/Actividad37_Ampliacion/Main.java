package unit9.Actividad37_Ampliacion;

import java.util.Arrays;

/*
    Escribir la interfaz Function con un único método abstracto
        double aplicar(double x)

    Implementar en la clase Main el método
        static double[] funcionTabla(double[] t, Function f)

    Al que se pasa una tabla de números realices y un objeto cuya clase implementa la
    interfaz Funcion. Devolverá una nueva tabla cuyos elementos son el resultado de aplicar
    el método aplicar() que se haya definido en f, a cada uno de los elementos de la tabla
    original. Utilizar funcionTabla() para calcular la raíz cuadrada de los elementos de una tabla
    de números reales.
 */
public class Main {
    public static void main(String[] args) {
        // Opción avanzada ya que es una interfaz funcional
        // Las interfaces funcionales solo pueden tener un método abstracto
        // Y se pueden usar como si fueran lambdas
        // También podemos llamar al Math.sqrt directamente en la lambda sin necesidad de crear la interfaz
        // Funcion f = Math::sqrt; Usando el método de referencia
        // Todo esto se dara en el Tema 13 Streams
        Funcion f = (a) -> Math.sqrt(a);

        // Otra opción es crear una clase que implemente la interfaz completa y sobre escribir el método
//        Funcion f = new Funcion() {
//            @Override
//            public double calcular(double x) {
//                return Math.sqrt(x);
//            }
//        }

        double[] tabla = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double[] tablaRaiz = funcionTabla(tabla, f);

        System.out.println("Tabla original:");
        System.out.println(Arrays.toString(tabla));

        System.out.println("Tabla raíz:");
        System.out.println(Arrays.toString(tablaRaiz));
    }

    private static double[] funcionTabla(double[] tabla, Funcion f) {
        double[] tablaRaiz = new double[tabla.length];

        for (int i = 0; i < tabla.length; i++) {
            tablaRaiz[i] = f.aplicar(tabla[i]);
        }

        return tablaRaiz;
    }
}
