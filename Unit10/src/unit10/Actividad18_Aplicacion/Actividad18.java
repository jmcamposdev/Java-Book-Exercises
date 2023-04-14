package unit10.Actividad18_Aplicacion;

import java.util.Arrays;

/*
    Escribe la función Integer[] LeerEnteros (String texto),
    al que se le pasa una ca dena y devuelve una tabla con todos los enteros que aparecen en ella.
 */
public class Actividad18 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(leerEnteros("123456789")));
    }
    
    public static Integer[] leerEnteros (String texto) {
        String[] numerosString = texto.split("");
        Integer[] numeros = new Integer[0];
        int index = 0;
        for (String numero : numerosString) {
            numeros = Arrays.copyOf(numeros,numeros.length+1);
            numeros[index++] = Integer.parseInt(numero);
        }
        return numeros;
    }
}
