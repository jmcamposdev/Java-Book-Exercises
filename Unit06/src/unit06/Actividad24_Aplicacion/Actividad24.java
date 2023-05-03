package unit06.Actividad24_Aplicacion;

import java.util.Scanner;

/*
    Implementar un sencillo editor de texto que, una vez que se ha insertado el texto,
    permita reemplazar todas las ocurrencias de una palabra por otra.
    Para salir escribirá la palabra "salir".
 */
public class Actividad24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entradaUsuario = "";
        String texto;

        // Pedimos el texto
        System.out.print("Introduce un texto: ");
        texto = sc.nextLine();

        // Mostramos el texto
        System.out.println("Texto introducido: \n" + texto);

        // Pedimos la palabra a buscar
        while (!entradaUsuario.equals("!q")) {
            System.out.println("Para salir escribe \"!q\"");
            System.out.print("Introduce la palabra a buscar: ");
            entradaUsuario = sc.nextLine();
            if (!entradaUsuario.equals("salir")) {
                // Pedimos la palabra a reemplazar
                System.out.print("Introduce la palabra a reemplazar: ");
                String palabraReemplazar = sc.nextLine();
                // Reemplazamos la palabra
                texto = texto.replaceAll(entradaUsuario, palabraReemplazar);
                // Mostramos el texto
                System.out.println("Texto modificado: \n" + texto);
            }
        }


    }
}
