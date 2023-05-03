package unit06.Actividad01;

/*
    Escribir un programa que muestre todos los caracteres Unicode junto a su code point, cuyo
    valor esé comprendido entre \u0000 y \uFFFF.
 */
public class Actividad01 {
    public static void main(String[] args) {
        for (int i = 0x0000; i <= 0xFFFF; i++) {
            String hex = Integer.toHexString(i);
            System.out.println("\\u" + hex + " = " + (char) i);
        }
    }
}
