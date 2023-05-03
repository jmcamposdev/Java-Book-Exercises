package unit06.Actividad06;

import java.util.Scanner;

/*
    Escribir un programa que pida el nombre completo al usuario y lo muestre sin vocales
    (mayúsculas, minúsculas y acentuadas). Por ejemplo, si el usuario introduce “Álvaro Pérez”,
    se mostrará “lvr Prz”.
 */
public class Actividad6 {
    public static final String VOCALES = "aeiouáéíóúAEIOUÁÉÍÓÚ"; // Constante con las vocales

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreCompleto;
        String nombreSinVocales;

        // Pedimos el nombre completo
        System.out.print("Ingresa tu nombre completo: ");
        nombreCompleto = sc.nextLine();

        // Quitamos las vocales
        nombreSinVocales = sinVocales(nombreCompleto);

        // Mostramos el resultado
        System.out.println("Tu nombre sin vocales es: "+nombreSinVocales);
    }

    public static String sinVocales(String cadena){
        // Esta opción es más eficiente
        StringBuilder cadenaSinVocales = new StringBuilder();
        for (int i = 0; i < cadena.length(); i++) { // Recorremos la cadena
            if (!VOCALES.contains(""+cadena.charAt(i))){ // Si el caracter no es una vocal
                cadenaSinVocales.append(cadena.charAt(i)); // Lo agregamos a la cadena
            }
        }
        return cadenaSinVocales.toString(); // Devolvemos la cadena
    }

}
