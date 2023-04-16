package Functions;

public class OperacionesString {

    public static int cantidadVocales(String cadena){
        char[] vocales = {'a','e','i','o','u','á','é','í','ó','ú'};
        int numeroDeVocales = 0;
        for (int i = 0; i < cadena.length(); i++) {
            for (char vocal : vocales) {
                if (cadena.charAt(i) == vocal) {
                    numeroDeVocales++;
                }
            }
        }
        return numeroDeVocales;
    }

    public static int cantidadCaracter(String cadena,char caracter){
        int numeroDeCaracteres = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i)==caracter){
                numeroDeCaracteres++;
            }
        }
        return numeroDeCaracteres;
    }

    public static int cantidadLetras (String cadena){
        int cantidadDeLetras = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i)!=' '){
                cantidadDeLetras++;
            }
        }
        return cantidadDeLetras;
    }

    public static int cantidadPalabras (String cadena){
        String[] cadenaArray = cadena.split(" ");
        return cadenaArray.length;
    }

    public static String invertirCadena (String cadena){
        String cadenaInversa = "";
        for (int i = cadena.length()-1; i>=0; i--) {
            cadenaInversa += cadena.charAt(i);
        }
        return cadenaInversa;
    }

    public static String palabraMayorLongitud (String cadena){
        String[] cadenaArray = cadena.split(" ");
        String palabraMayor = "";
        for (String string : cadenaArray) {
            if (string.length() > palabraMayor.length()) {
                palabraMayor = string;
            }
        }
        return palabraMayor;
    }
}
