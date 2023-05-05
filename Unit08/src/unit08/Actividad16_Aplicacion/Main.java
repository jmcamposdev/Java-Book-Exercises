package unit08.Actividad16_Aplicacion;

/*
    Implementa los siguientes métodos en la clase Número:
    • static boolean esNumero(Object ob) que nos dice si su parámetro de entrada es tipo numérico (Integer, Double, Float, etc.)
    • boolean sumar (Object a, Object b) que muestra por consola la concatenación de los parámetros de entrada si ambos
    son cadenas, o muestra su suma  convertida a tipo Double si ambos son tipo numéricos. En cualquier otro caso
    muestra el mensaje “No sumables”.
 */
public class Main {
    public static void main(String[] args) {
        // Prueba
        System.out.println("Prueba de esNumero()" + "\n");
        System.out.println("¿Es 1 un número? " + Numero.esNumero(1));
        System.out.println("¿Es 1.0 un número? " + Numero.esNumero(1.0));
        System.out.println("¿Es \"1\" un número? " + Numero.esNumero("1"));
        System.out.println("¿Es \"1.0\" un número? " + Numero.esNumero("1.0"));

        System.out.println("Prueba de sumar()" + "\n");
        System.out.println("Sumar \"1\" y \"1\": ");
        Numero.sumar("1","1");
        System.out.println("Sumar 1 y 1: ");
        Numero.sumar(1,1);
        System.out.println("Sumar \"1\" y 1: ");
        Numero.sumar("1",1);


    }
}
