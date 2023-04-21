package unit12.Actividad37_Ampliacion;

import java.util.ArrayList;

/*
    Implementa las clases Cola y Pila genéricas heredando de ArrayList.
 */
public class Cola<T> extends ArrayList<T>{

    public void encolar(T elemento) {
        this.add(elemento);
    }

    public T desencolar() {
        T elemento = null;
        if (!this.isEmpty()) {
            elemento = this.remove(0);
        }
        return elemento;
    }


}
