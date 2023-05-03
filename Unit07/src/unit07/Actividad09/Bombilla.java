package unit07.Actividad09;

/*
    7.9

    Modelar una casa con muchas bombillas, de forma que cada bombilla se pueda encender o pagar individualmente
    Para ello, hacer una clase Bombilla con una variable privada que indique si está encendida o apagada, así como
    un método que nos diga el estado de una bombilla concreta. Además, queremos poner un interruptor general, de manera
    que si este se apaga, todas las bombillas quedan apagadas. Cuando el interruptor general se activa, las bombillas
    vuelven a estar encendidas o apagadas, según estuvieran antes. Cada bombilla se enciende y se apaga individualmente,
    pero, solo responde que está encendida si su interruptor particular está encendido y el general también.
 */

public class Bombilla {
    private boolean interruptor;
    public static boolean interruptorGeneral = true;

    // Inicializamos el interruptor de la bombilla a false (apagado)
    public Bombilla(){
        interruptor = false;
    }

    // Metodos para manipular el estado de la bombilla
    public void encender(){
        interruptor = true;
    }
    public void apagar(){
        interruptor = false;
    }

    // Comprobamos el estado de la bombilla
    private boolean estado(){
        return interruptor && interruptorGeneral;
    }

    // A través de método estado mostramos si la bombilla está encendida o apagada
    public String mostrarEstado(){
        return estado() ? "Encendida" : "Apagada";
    }
}
