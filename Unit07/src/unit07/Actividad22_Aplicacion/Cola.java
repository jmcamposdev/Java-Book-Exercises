package unit07.Actividad22_Aplicacion;

import java.util.ArrayList;
import java.util.Arrays;

public class Cola {
    private Integer[] elementos;

    public Cola() {
        elementos = new Integer[0];
    }

    public void encolar(Integer elemento) {
        elementos = Arrays.copyOf(elementos, elementos.length + 1);
        elementos[elementos.length - 1] = elemento;
    }

    public Integer desencolar() {
        if (elementos.length == 0) {
            throw new RuntimeException("La cola está vacía");
        }
        Integer elemento = elementos[0]; // Guardamos el primer elemento
        System.arraycopy(elementos, 1, elementos, 0, elementos.length - 1); // Desplazamos los elementos
        elementos = Arrays.copyOf(elementos, elementos.length - 1); // Redimensionamos el array
        return elemento;
    }

    public boolean estaVacia() {
        return elementos.length == 0;
    }

    public int tamano() {
        return elementos.length;
    }

    public Integer frente() {
        if (elementos.length == 0) {
            throw new RuntimeException("La cola está vacía");
        }
        return elementos[0];
    }
}

