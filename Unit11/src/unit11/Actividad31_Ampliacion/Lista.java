package unit11.Actividad31_Ampliacion;

import java.io.Serializable;
import java.util.Arrays;

public class Lista implements Serializable {
    Object tabla[];
    public Lista() {
        tabla = new Object[0];
    }

    void insertarPrincipio(Object nuevo) {
        tabla = Arrays.copyOf(tabla, tabla.length + 1);
        System.arraycopy(tabla, 0, tabla, 1, tabla.length - 1);
        tabla[0] = nuevo;
    }

    public void insertarFinal(Object nuevo) {
        tabla = Arrays.copyOf(tabla, tabla.length + 1);
        tabla[tabla.length - 1] = nuevo;
    }

    void insertarFinal(Lista otraLista) {
        int tamInicial = tabla.length;
        tabla = Arrays.copyOf(tabla, tabla.length + otraLista.tabla.length);
        System.arraycopy(otraLista.tabla, 0, tabla, tamInicial, otraLista.tabla.length);
    }

    void insertar (int posicion, Object nuevo) {
        if (posicion < 0 || posicion > tabla.length) {
            throw new IndexOutOfBoundsException("Posición no válida.");
        }
        tabla = Arrays.copyOf(tabla, tabla.length + 1);
        System.arraycopy(tabla, posicion, tabla, posicion + 1, tabla.length - posicion - 1);
        tabla[posicion] = nuevo;
    }

    public Object eliminar(int indice) {
        Object eliminado = null;
        if (indice >= 0 && indice < tabla.length) {
            eliminado = tabla[indice];
            System.arraycopy(tabla, indice + 1, tabla, indice, tabla.length - indice - 1);
            tabla = Arrays.copyOf(tabla, tabla.length - 1);
        }
        return eliminado;
    }

    public Object get(int indice) {
        Object resultado = null;
        if (indice >= 0 && indice < tabla.length) {
            resultado = tabla[indice];
        }
        return resultado;
    }

    int buscar (Object claveBusqueda) {
        int indice = -1;
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i].equals(claveBusqueda)) {
                indice = i;
                break;
            }
        }
        return indice;
    }

    public int size() {
        return tabla.length;
    }

    public void sort(java.util.Comparator<Object> c) {
        Arrays.sort(tabla, c);
    }
    public void sort() {
        Arrays.sort(tabla);
    }

    public String toString() {
        return Arrays.deepToString(tabla);
    }
}
