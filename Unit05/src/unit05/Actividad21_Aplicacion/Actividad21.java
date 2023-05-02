package unit05.Actividad21_Aplicacion;

import java.util.Arrays;

import static unit05.Actividad09.Actividad9.getInt;

/*
    1 2 3 4 5
    1 2 3 5 4
    1 2 5 4
    2 5 4 1
    Diseña una aplicación para gestionar la llegada a meta de los participantes de una carrera.
    Cada uno de ellos dispone de un dorsal (un número entero) que los identifica.
    En la aplicación se introduce el número de dorsal de cada corredor cuando este llega a la meta.
    Para indicar que la carrera ha finalizado (han llegado todos los corredores a la meta), se introduce como dorsal el número -1.

    A continuación, la aplicación solicita información extra de los corredores.
    En primer lugar, se introducen los dorsales de todos los corredores menores de edad; para premiarlos por su esfuerzo se les avanza un puesto en el ranking general de la carrera, es decir, es como si hubieran adelantado al corredor que llevaban delante.
    En segundo lugar, se introducen los dorsales de los corredores que han dado positivo en el test antidopaje, lo que provoca su expulsión inmediata.

     Para finalizar, se introducen los dorsales de los corredores que no han pagado su inscripción en la carrera, lo que provoca que se releguen a los últimos puestos del ranking general.

     La aplicación debe mostrar los dorsales de los corredores que han conseguido las medallas de oro, plata y bronce.
 */
public class Actividad21 {
    public static void main(String[] args) {
        int[] dorsales = new int[0];
        int dorsal;

        // Leer los dorsales de los corredores
        System.out.println("Introduce los dorsales de los corredores: ");
        System.out.println("Para finalizar introduce -1");
        do {
            dorsal = getInt("Introduce el dorsal del corredor: ");
            if (dorsal != -1) {
                dorsales = insertar(dorsales, dorsal);
            }
        } while (dorsal != -1);

        // Pedir los dorsales de los menores de edad
        System.out.println("Introduce los dorsales de los menores de edad: ");
        System.out.println("Para finalizar introduce -1");
        do {
            dorsal = getInt("Introduce el dorsal del corredor: ");
            if (dorsal != -1) { // Si el dorsal no es -1
                if (contains(dorsales, dorsal)) { // Comprobar si el dorsal existe
                    moverUnPuesto(dorsales, dorsal); // Mover el dorsal una posición
                } else { // Si el dorsal no existe
                    System.out.println("El dorsal no existe");
                }
            }
        } while (dorsal != -1);

        // Pedir los dorsales de los corredores que han dado positivo en el test antidopaje
        System.out.println("Introduce los dorsales de los corredores que han dado positivo en el test antidopaje: ");
        System.out.println("Para finalizar introduce -1");
        do {
            dorsal = getInt("Introduce el dorsal del corredor: ");
            if (dorsal != -1) { // Si el dorsal no es -1
                if (contains(dorsales, dorsal)) { // Comprobar si el dorsal existe
                    dorsales = eliminar(dorsales, dorsal); // Eliminar el dorsal
                } else { // Si el dorsal no existe
                    System.out.println("El dorsal no existe");
                }
            }
        } while (dorsal != -1);

        // Pedir los dorsales de los corredores que no han pagado su inscripción en la carrera
        System.out.println("Introduce los dorsales de los corredores que no han pagado su inscripción en la carrera: ");
        System.out.println("Para finalizar introduce -1");
        do {
            dorsal = getInt("Introduce el dorsal del corredor: ");
            if (dorsal != -1) { // Si el dorsal no es -1
                if (contains(dorsales, dorsal)) { // Comprobar si el dorsal existe
                    dorsales = moverUltimo(dorsales, dorsal); // Mover el dorsal al último puesto
                } else { // Si el dorsal no existe
                    System.out.println("El dorsal no existe");
                }
            }
        } while (dorsal != -1);

        // Mostrar los dorsales de los corredores que han conseguido las medallas de oro, plata y bronce
        if (dorsales.length >= 3) {
            mostrarMedallas(dorsales);
        } else {
            System.out.println("No hay suficientes dorsales para mostrar las medallas");
        }


    }

    private static void mostrarMedallas(int[] dorsales) {
        System.out.println("Medalla de oro: " + dorsales[0]);
        System.out.println("Medalla de plata: " + dorsales[1]);
        System.out.println("Medalla de bronce: " + dorsales[2]);
    }

    private static int[] moverUltimo(int[] dorsales, int dorsal) {
        int posicion = getIndice(dorsales, dorsal);

        // Eliminar el dorsal
        for (int i = posicion; i < dorsales.length - 1; i++) {
            dorsales[i] = dorsales[i + 1];
        }
        dorsales = Arrays.copyOf(dorsales, dorsales.length - 1);

        // Insertar el dorsal al final
        dorsales = insertar(dorsales, dorsal);

        return dorsales;
    }

    private static int[] eliminar(int[] dorsales, int dorsal) {
        int posicion = getIndice(dorsales, dorsal);

        // Eliminar el dorsal
        for (int i = posicion; i < dorsales.length - 1; i++) {
            dorsales[i] = dorsales[i + 1];
        }
        dorsales = Arrays.copyOf(dorsales, dorsales.length - 1);

        return dorsales;
    }

    private static void moverUnPuesto(int[] dorsales, int dorsal) {
        int posicion = getIndice(dorsales, dorsal);

        // Mover el dorsal una posición
        if (posicion != 0) {
            int aux = dorsales[posicion]; // Guardamos el dorsal elegido
            dorsales[posicion] = dorsales[posicion - 1]; // Movemos el dorsal anterior a la posición elegida
            dorsales[posicion - 1] = aux; // Movemos el dorsal elegido a la posición anterior
        }
    }

    private static int[] insertar(int[] dorsales, int dorsal) {
        if (!contains(dorsales, dorsal)) {
            dorsales = Arrays.copyOf(dorsales, dorsales.length + 1);
            dorsales[dorsales.length - 1] = dorsal;
        } else {
            System.out.println("El dorsal ya existe");
        }

        return dorsales;
    }


    public static boolean contains (int[] tabla, int valor) {
        boolean encontrado = false;
        for (int i = 0; i < tabla.length && !encontrado; i++) {
            if (tabla[i] == valor) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    public static int getIndice (int[] tabla, int valor) {
        int posicion = -1;
        for (int i = 0; i < tabla.length && posicion == -1; i++) {
            if (tabla[i] == valor) {
                posicion = i;
            }
        }
        return posicion;
    }
}
