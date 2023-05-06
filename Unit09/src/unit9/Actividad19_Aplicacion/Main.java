package unit9.Actividad19_Aplicacion;

import unit9.Actividad17_Aplicacion.Lista;

/*
    Repetir la Actividad 18 con la interfaz Pila apilando y desapilando objetos.
 */
public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();

        lista.apilar(1); // Integer
        lista.apilar("Hola"); // String
        lista.apilar(3.14); // Double
        lista.apilar(true); // Boolean

        System.out.println(lista.desapilar()); // Boolean
        System.out.println(lista.desapilar()); // Double
        System.out.println(lista.desapilar()); // String
        System.out.println(lista.desapilar()); // Integer
    }
}
