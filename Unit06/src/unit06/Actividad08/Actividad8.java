package unit06.Actividad08;

import java.util.Scanner;

public class Actividad8 {
    public static void main(String[] args) {
        final String prefijo = "Javalín,javalón";
        final String sufijo = "javalén, len, len";
        Scanner sc = new Scanner(System.in);
        String frase;
        String fraseDesencriptada = "";
        boolean utilizaDialecto = false;

        // Pedimos la frase
        System.out.print("Ingrese la frase: ");
        frase = sc.nextLine();


        if (frase.startsWith(prefijo)){ // Si la frase empieza con el prefijo
            utilizaDialecto = true; // Utiliza el dialecto
            fraseDesencriptada = frase.substring(prefijo.length()); // Obtenemos la frase desencriptada
        } else if (frase.endsWith(sufijo)){ // Si la frase termina con el sufijo
            utilizaDialecto = true;  // Utiliza el dialecto
            fraseDesencriptada = frase.substring(0,frase.length()-sufijo.length()); // Obtenemos la frase desencriptada
        }

        fraseDesencriptada = fraseDesencriptada.strip(); // Eliminamos los espacios en blanco al principio y al final

        if (utilizaDialecto){ // Si utiliza el dialecto
            // Mostramos la frase desencriptada
            System.out.println("Se esta utizando el dialecto");
            System.out.println("La frase es: "+fraseDesencriptada);
        } else { // Si no utiliza el dialecto
            // Mostramos un mensaje
            System.out.println("No se esta utilizando el dialecto");
        }

    }
}
