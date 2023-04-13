package Functions;

import java.util.ArrayList;

public class Pila<T> {
    private final ArrayList<T> elementos;

    public Pila() {
        elementos = new ArrayList<T>();
    }

    public void apilar(T elemento) {
        elementos.add(elemento);
    }

    public T desapilar() {
        if (elementos.isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        return elementos.remove(elementos.size() - 1);
    }

    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    public int tamano() {
        return elementos.size();
    }

    public T cima() {
        if (elementos.isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        return elementos.get(elementos.size() - 1);
    }
}