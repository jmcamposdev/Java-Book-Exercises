package unit9.Actividad32_34_Ampliacion;

import unit9.Actividad25_Aplicacion.Lista;

import java.time.LocalDateTime;

/*
    Actividad 32
    En una compañía de telecomunicaciones se desea registrar los datos de todas las llamadas de sus clientes.
    Implementar la clase Llamada que guardará los siguientes datos:
    1. Número de Teléfono del Cliente
    2. Número del Interlocutor
    3. Si llamada es saliente (Boolean)
    4. Fecha y hora del Inicio de la llamada y fin
    5. Enum que indique la zona del interlocutor (suponer 5 zonas con tarifas distintas) y tabla de constantes
       con las tarifas de las zonas en céntimos de euro/minuto

    En la clase se establecerá un orden natural compuesto basado en el número de teléfono del cliente como primer criterio
     y  en la fecha y hora de inicio como segundo criterio. Asimismo se implementará un método que devuelva la duración en
     minutos de la llamada y otro que calcule su coste, si es saliente.
     Por último implementar el método toString() que muestre los dos números de teléfono, la fecha y la hora de inicio, duración y el coste.

     Actividad 33
     Utilizar la clase Lista para guardar una serie de llamadas. A continuación, ordenarla con el criterio de orden natural y mostrarlas por pantalla

     Actividad 34
     Implementar una clase comparadora que ordene las llamadas por coste. Usarla para ordenar la lista de la Actividad 33 y mostrarla por pantalla.
 */
public class Main {
    public static void main(String[] args) {
        Lista llamadas = new Lista();

        // Generando Llamadas Aleatorias con valores aleatorios
        llamadas.insertarFinal(new Llamada("423456789", "687654321", true, LocalDateTime.of(2020, 1, 1, 12, 0), LocalDateTime.of(2020, 1, 1, 12, 30), ZonaTarifa.ZONA_A));
        llamadas.insertarFinal(new Llamada("523456739", "387654321", false, LocalDateTime.of(2021, 1, 1, 12, 0), LocalDateTime.of(2021, 1, 1, 13, 30), ZonaTarifa.ZONA_A));
        llamadas.insertarFinal(new Llamada("223456289", "187654321", true, LocalDateTime.of(2022, 1, 1, 12, 0), LocalDateTime.of(2022, 1, 1, 13, 30), ZonaTarifa.ZONA_A));
        llamadas.insertarFinal(new Llamada("123456789", "687654321", true, LocalDateTime.of(2023, 1, 1, 12, 0), LocalDateTime.of(2023, 1, 1, 15, 30), ZonaTarifa.ZONA_A));

        // Ordenando la lista de llamadas
        llamadas.ordenar();

        // Mostrando la lista de llamadas
        System.out.println("Lista Ordenada de Llamadas:");
        System.out.println(llamadas);

        // Ordenando la lista de llamadas por coste
        llamadas.ordenar(new OrdenarLlamadaPorCoste());
        System.out.println("Lista Ordenada de Llamadas por Coste:");
        System.out.println(llamadas);


    }
}
