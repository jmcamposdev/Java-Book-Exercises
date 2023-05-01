package unit04.Actividad05;

/*
    Crear una función que mediante un booleano indique si el caracter que se pasa como parámetro
    de entrada corresponde con una vocal o no.
 */
public class Actividad5 {
    public static void main(String[] args) {
        System.out.println("¿Es la 'a' una vocal? " + esVocal('a'));
        System.out.println("¿Es la 'b' una vocal? " + esVocal('b'));
        System.out.println("¿Es la 'e' una vocal? " + esVocal('e'));
        System.out.println("¿Es la 'i' una vocal? " + esVocal('i'));
        System.out.println("¿Es la 'o' una vocal? " + esVocal('o'));
        System.out.println("¿Es la 'u' una vocal? " + esVocal('u'));
        System.out.println("¿Es la 'z' una vocal? " + esVocal('z'));
    }

    private static boolean esVocal(char c) {
        // Pasamos el caracter a minúscula
        c = Character.toLowerCase(c);

        // Comprobamos si es una vocal
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
