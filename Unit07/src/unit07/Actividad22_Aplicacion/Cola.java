package unit07.Actividad22_Aplicacion;

import java.util.Arrays;

/*
    Una cola es otra estructura dinámica como la pila, donde los elementos, en vez de apilarse y desapilarse, se encolan y desencolan.
    La diferencia con las pilas es que se desencola el primer elemento encolado, ya que así es como funcionan las colas del autobús o del cine.
    El primero que llega es el primero que sale de la cola (vamos a suponer que nadie se cuela).
    Por tanto, los elementos se encolan y desencolan en extremos opuestos de la estructura,
    llamados primero (el que está primero y será el próximo en abandonar la cola) y último (el que llegó último).
    Implementa la clase Cola donde los elementos Integer encolados se guardan en una tabla.
 */
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

