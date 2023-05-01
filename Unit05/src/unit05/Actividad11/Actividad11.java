package unit05.Actividad11;

import unit05.Actividad09.Actividad9;

import java.util.Arrays;
import java.util.Scanner;


/*
    Crear un juego "la cámara secreta" consiste en abrir una cámara mediante su combinación secreta
    que está formada por una combinación de dígitos del 1 al 5. El jugador especificará cuál es la
    longitud de la combinación; a mayor longitud mayor dificultad. La combinación será generada de
    forma aleatoria que el usuario tendrá que acertar. En cada intento se muestra como pista para
    cada dígito si es mayor, menor o igual
 */
public class Actividad11 {
    public static void main(String[] args) {
int longitudCombinacion,numeroIntroducido;
        int[] numeroIntroducidoArray;
        longitudCombinacion = Actividad9.getInt("Ingrese la logitud de la combinación deseada: ");
        int[] combinacionGenerada = generarCombinacion(longitudCombinacion);
        int combinacionMinima = generarCombinacionMinima(longitudCombinacion); // Generamos la combinación Minima
        int combinacionMaxima = generarCombinacionMaxima(longitudCombinacion); // Generamos la combinación Máxima

        numeroIntroducido = getInt("Introduce la combinacion de "+longitudCombinacion+" cifras: ",combinacionMinima,combinacionMaxima);
        numeroIntroducidoArray = conversorArray(numeroIntroducido);

        while (!Arrays.equals(combinacionGenerada,numeroIntroducidoArray)){
            mostrarPista(combinacionGenerada,numeroIntroducidoArray);
            numeroIntroducido = getInt("Introduce la combinacion de "+longitudCombinacion+" cifras: ",combinacionMinima,combinacionMaxima);
            numeroIntroducidoArray = conversorArray(numeroIntroducido);
        }

        System.out.println("¡Enhorabuena! Has acertado la combinación secreta.");
    }

    private static void mostrarPista(int[] combinacionGenerada, int[] numeroIntroducidoArray) {
        for (int i = 0; i < combinacionGenerada.length; i++) {
            if (combinacionGenerada[i] > numeroIntroducidoArray[i]){
                System.out.println("El número "+numeroIntroducidoArray[i]+" es menor que el número secreto.");
            }else if (combinacionGenerada[i] < numeroIntroducidoArray[i]){
                System.out.println("El número "+numeroIntroducidoArray[i]+" es mayor que el número secreto.");
            }else {
                System.out.println("El número "+numeroIntroducidoArray[i]+" es igual que el número secreto.");
            }
        }
    }

    private static int[] conversorArray(int numeroIntroducido) {
        int longitud = String.valueOf(numeroIntroducido).length();
        int[] array = new int[longitud];
        for (int i = 0; i < longitud; i++) {
            array[i] = Integer.parseInt(String.valueOf(String.valueOf(numeroIntroducido).charAt(i)));
        }
        return array;
    }

    public static int[] generarCombinacion (int longitudCombinacion){
        final int MAX = 5;
        int[] combinacion = new int[longitudCombinacion];
        for (int i = 0; i < longitudCombinacion; i++) {
            combinacion[i] = (int) (Math.random()*MAX+1);
        }
        return combinacion;
    }
    public static int generarCombinacionMinima (int longitudCombinacion){
        String combinacionMinima = "";
        for (int i = 0; i < longitudCombinacion; i++) {
            combinacionMinima+="1";
        }
        return Integer.parseInt(combinacionMinima);
    }
    public static int generarCombinacionMaxima (int longitudCombinacion){
        String combinacionMinima = "";
        for (int i = 0; i < longitudCombinacion; i++) {
            combinacionMinima+="5";
        }
        return Integer.parseInt(combinacionMinima);
    }

    public static int getInt(String mensaje, int minimo, int maximo) {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.print(mensaje);
        do {
            while (!sc.hasNextInt()) {
                System.out.println("Ingrese un valor numérico.");
                System.out.print(mensaje);
                sc.nextLine();
            }
            numero = sc.nextInt();
            if (numero < minimo || numero > maximo) {
                System.out.println("Ingrese un valor entre "+minimo+" y "+maximo+".");
                System.out.print(mensaje);
            }
        } while (numero < minimo || numero > maximo);
        return numero;
    }
}
