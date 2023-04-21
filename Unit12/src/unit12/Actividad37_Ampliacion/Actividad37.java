package unit12.Actividad37_Ampliacion;

public class Actividad37 {
    public static void main(String[] args) {
        Cola<Integer> cola = new Cola<>();
        System.out.println("Cola vacía: " + cola.isEmpty());
        for (int i = 0; i < 10; i++) {
            cola.add(i);
        }
        cola.desencolar();
        System.out.println("Cola: " + cola);

        Pila<Integer> pila = new Pila<>();
        System.out.println("Pila vacía: " + pila.isEmpty());
        for (int i = 0; i < 10; i++) {
            pila.push(i);
        }
        pila.pop();
        System.out.println("Pila: " + pila);
    }
}
