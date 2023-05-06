package unit9.Actividad18_Aplicacoin;

import unit9.Actividad17_Aplicacion.Lista;

/*
    Escribir un programa donde se use una Lista para elementos Object para encolar y desencolar objetos
    de distinto tipo (Integer, String, Double, etc.) y mostrarlos por pantalla
 */
public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();

        lista.encolar(1); // Integer
        lista.encolar("Hola"); // String
        lista.encolar(3.14); // Double
        lista.encolar(true); // Boolean

        System.out.println(lista.desencolar()); // Integer
        System.out.println(lista.desencolar()); // String
        System.out.println(lista.desencolar()); // Double
        System.out.println(lista.desencolar()); // Boolean

    }
}
