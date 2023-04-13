package Functions;

import java.util.ArrayList;

public class Cola<T> {
    private ArrayList<T> elementos;

    public Cola() {
        elementos = new ArrayList<T>();
    }

    public void encolar(T elemento) {
        elementos.add(elemento);
    }

    public T desencolar() {
        if (elementos.isEmpty()) {
            throw new RuntimeException("La cola está vacía");
        }
        return elementos.remove(0);
    }

    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    public int tamano() {
        return elementos.size();
    }

    public T frente() {
        if (elementos.isEmpty()) {
            throw new RuntimeException("La cola está vacía");
        }
        return elementos.get(0);
    }
}
