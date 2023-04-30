package unit1.Actividad05;

/*
    El tipo short permite almacenar valores comprendidos entre -32768 y 32767.
    Escribir un programa que comprueba que el rango de valores de un tipo se comporta de
    forma cíclica, es decir, que el valor siguiente al máximo es el mínimo y viceversa.
 */
public class Actividad5 {
    public static void main(String[] args) {
        short num = 32767;
        System.out.println("Valor máximo: " + num);
        num++;
        System.out.println("Valor mínimo: " + num);
    }
}
