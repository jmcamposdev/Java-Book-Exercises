package unit10.Actividad1;

import java.util.Scanner;

/*
    Escribir el método:
        Integer leerEntero();
    Que pida un entero por consola, lo lee del telcado y lo devuelve. Si la cadena introducida
    por consola no tiene el formato correcto, muestra un mensaje de error y vuvelve a pedirlo
*/
public class Actividad1 {
    public static void main(String[] args) {
        leerEntero();
    }
    
    // Existe una mejor forma de realizar esta función sin un try-catch ya que es innecesario esta en el Paquete Funtions/GetData/GetInt.
    public static Integer leerEntero() {
    Integer numero = null;
    boolean isInteger = false;
    while(!isInteger) {
        try {
            System.out.print("Introduce un entero: ");
            numero = new Scanner(System.in).nextInt();
            isInteger = true;
        } catch (Exception e) {
            System.out.println("El valor introducido no es un entero");
        }
    }
    
    return numero;
}
    
}
