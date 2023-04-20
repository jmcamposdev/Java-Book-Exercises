package unit12.Actividad27_Aplicacion;

import java.util.Comparator;
import java.util.TreeSet;

/*
    Implementa una aplicación donde se insertan 20 números enteros aleatorios distintos,
    menores que 100, en una colección.
    Deberán guardarse por orden decreciente a medida que se vayan generando,
    y se mostrará la colección resultante por pantalla.
 */
public class Actividad27 {
    public static void main(String[] args) {
        TreeSet<Integer> numeros = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < 20; i++) {
            numeros.add((int) (Math.random() * 100));
        }
        System.out.println(numeros);
    }
}
