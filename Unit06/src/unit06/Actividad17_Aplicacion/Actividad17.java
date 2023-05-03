package unit06.Actividad17_Aplicacion;

import java.util.Scanner;

/*
   Realiza el juego del ahorcado. Las reglas del juego son:
        a) El jugador A teclea una palabra, sin que el jugador B la vea.
        b) Ahora se le muestra tantos guiones como letras tenga la palabra secreta. Por ejem-plo, para «hola» será «___».
        c) El jugador B intentará acertar, letra a letra, la palabra secreta.
        d) Cada acierto muestra la letra en su lugar y las letras no acertadas seguirán ocultas como guiones. Siguiendo con el ejemplo anterior, y suponiendo que se ha introducido: la 'o', la 'j' y la 'a', se mostrará: «_ o _ a».
        (e) El jugador B solo tiene 7 intentos.
        f) La partida terminará al acertar todas las letras que forman la palabra secreta (gana el jugador B) o cuando se agoten todos los intentos (gana el jugador A).
 */
public class Actividad17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palabraClave;
        String palabraUsuario;
        int intentos = 7;
        boolean acierto = false;

        // Pedimos la palabra clave
        System.out.print("Introduce la palabra clave: ");
        palabraClave = sc.nextLine().toLowerCase();

        while (intentos != 0 && !acierto) {
            System.out.println("Intentos restantes: "+intentos);
            System.out.print("Introduce la palabra: ");
            palabraUsuario = sc.nextLine().toLowerCase();

            if (palabraUsuario.equals(palabraClave)) {
                acierto = true;
            } else {
                intentos--;

                if (intentos != 0) {
                    if (palabraUsuario.length() > palabraClave.length()) {
                        palabraUsuario = palabraUsuario.substring(0, palabraClave.length());
                    }
                    System.out.println("Palabra incorrecta, Pista: " + pistas(palabraClave, palabraUsuario));
                }
            }
        }

        if (acierto) {
            System.out.println("Has acertado la palabra clave");
        } else {
            System.out.println("Has agotado todos los intentos");
        }

    }

    private static String pistas(String palabraClave, String palabraUsuario) {
        StringBuilder pista = new StringBuilder();
        for (int i = 0; i < Math.min(palabraClave.length(), palabraUsuario.length()); i++) {
            if (palabraClave.charAt(i) == palabraUsuario.charAt(i)) {
                pista.append(palabraClave.charAt(i));
            } else {
                pista.append("_");
            }
        }

        if (palabraClave.length() > palabraUsuario.length()) {
            pista.append("_".repeat(palabraClave.length() - palabraUsuario.length()));
        }

        return pista.toString();
    }
}
