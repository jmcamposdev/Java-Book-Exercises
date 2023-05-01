package unit05.Actividad09;

import java.util.Arrays;
import java.util.Scanner;

/*
    Diseñar una aplicación para un campeonato de programación, donde se introducirá la puntuación de 5
    programadores. La aplicación debe de mostrar la puntuación ordenada de los 5 programadores. En ocasiones
    cuando finalizan los 5 participantes anteriores se suman al campeonato programador de exhibición, cuyos
    puntos se incluyen con el resto. La forma de saber que no intervienen más programadores es insertando la
    puntuación de -1. La aplicación debe de mostrar los puntos ordenados de todos los participantes.
 */
public class Actividad9 {
    public static void main(String[] args) {
        int[] notasProgramadores = new int[5];
        for (int i = 0; i < 5; i++) {
            int nota = getInt("Introduce la nota: ");
            notasProgramadores[i] = nota;
        }
        Arrays.sort(notasProgramadores);
        System.out.println("La puntuación de los 5 programadores es: "+Arrays.toString(notasProgramadores));
        int notaExhibicion = getInt("Ingrese la nota de exhibición: ");
        while (notaExhibicion != -1){
            notasProgramadores = insercionOrdenada(notasProgramadores,notaExhibicion);
            notaExhibicion = getInt("Ingrese la nota de exhibición: ");
        }
        System.out.println("Las notas totales son: "+Arrays.toString(notasProgramadores));
    }

    public static int getInt(String mensaje) {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.print(mensaje);
        while (!sc.hasNextInt()){
            System.out.println("Ingrese un valor numérico.");
            System.out.print(mensaje);
            sc.nextLine();
        }
        numero = sc.nextInt();
        return numero;
    }

    public static int[] insercionOrdenada (int[] t, int nuevoValor){
        int[] nuevoArray = new int[t.length+1];
        int indiceInsercion = Arrays.binarySearch(t,nuevoValor);
        if (indiceInsercion < 0) {
            indiceInsercion = -indiceInsercion -1;
        }
        System.arraycopy(t,0,nuevoArray,0,indiceInsercion);
        System.arraycopy(t,indiceInsercion,nuevoArray,indiceInsercion+1,t.length-indiceInsercion);
        nuevoArray[indiceInsercion] = nuevoValor;
        return nuevoArray;
    }
}
