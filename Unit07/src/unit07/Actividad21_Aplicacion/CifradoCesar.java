package unit07.Actividad21_Aplicacion;

/*
    El cifrado César es una forma sencilla de modificar un texto para que no sea entendible a quienes no conocen el código.
    Este cifrado consiste en modificar cada letra de un texto por otra que se encuentra en el alfabeto n posiciones detrás.
    Por ejemplo, para un valor de n igual a 3, la letra a se codifica con la d, y la letra q se codifica con la x.
    En el caso de que una letra exceda a la z, seguiremos de forma circular utilizando la a. Solo se cifrarán las letras, mayúsculas o minúsculas.
    Realiza una clase que, mediante un método estático, devuelva cifrado el texto que se le pasa con un paso de n letras.
 */
public class CifradoCesar {
    char[] alfabeto = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    String texto;

    public CifradoCesar(String texto) {
        this.texto = texto.toLowerCase();
    }

    public String cifrar(int n) {
        boolean isLetterFound = false;
        StringBuilder cifrado = new StringBuilder();
        for (int i = 0; i < this.texto.length(); i++) {
            char letra = this.texto.charAt(i);
            if (Character.isLetter(letra)) {
                int posicion = 0;
                for (int j = 0; j < this.alfabeto.length && !isLetterFound; j++) {
                    if (this.alfabeto[j] == letra) {
                        posicion = j;
                        isLetterFound = true;
                    }
                }
                int nuevaPosicion = (posicion + n) % this.alfabeto.length;
                cifrado.append(this.alfabeto[nuevaPosicion]);
            } else {
                cifrado.append(letra);
            }
        }

        return cifrado.toString();
    }
}
