package unit06.Actividad18_Aplicacion;


//    El preprocesador del lenguaje C elimina los comentarios (/* ... */) del código fuente antes de compilar.
//    Diseña un programa que lea por teclado una sentencia en C, y elimine los comentarios.
//    Sentencia: if (a==3) /* igual a tres */ a++; /* incrementamos a */
//    Salida: 1f (a==3) a++;

import java.util.Scanner;

public class Actividad18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentencia;

        // Pedimos la sentencia
        System.out.print("Introduce la sentencia: ");
        sentencia = sc.nextLine();

        // Eliminamos los comentarios
        sentencia = eliminarComentarios(sentencia);

        // Mostramos la sentencia sin comentarios
        System.out.println("La sentencia sin comentarios es: "+sentencia);
    }

    private static String eliminarComentarios(String sentencia) {
        StringBuilder sentenciaSinComentarios = new StringBuilder(); // Sentencia sin comentarios
        boolean comentario = false; // Indica si estamos en un comentario

        for (int i = 0; i < sentencia.length(); i++) { // Recorremos la sentencia
            if (sentencia.charAt(i) == '/' && sentencia.charAt(i+1) == '*') { // Si encontramos un comentario de apertura
                comentario = true; // Estamos en un comentario
            } else if (sentencia.charAt(i) == '*' && sentencia.charAt(i+1) == '/') { // Si encontramos un comentario de cierre
                comentario = false; // Ya no estamos en un comentario
                i++; // Saltamos el caracter '/'
            } else if (!comentario) { // Si no estamos en un comentario
                sentenciaSinComentarios.append(sentencia.charAt(i)); // Añadimos el caracter a la sentencia sin comentarios
            }
        }

        return sentenciaSinComentarios.toString();
    }
}
