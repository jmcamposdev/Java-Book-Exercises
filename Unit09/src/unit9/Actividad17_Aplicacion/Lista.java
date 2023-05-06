package unit9.Actividad17_Aplicacion;

import java.util.Arrays;

/*
    Definir las interfaces Cola y Pila para objetos Object e implementarlos en la clase Lista definida en la Actividad 11
 */
public class Lista implements Pila, Cola{
    Object[] lista;

    public Lista(){
        lista = new Object[0];
    }

    public void insertarPrincipio(Object elemento){
        lista = Arrays.copyOf(lista, lista.length + 1);
        System.arraycopy(lista, 0, lista, 1, lista.length - 1 );
        lista[0] = elemento;
    }

    public void insertarFinal(Object elemento){
        lista = Arrays.copyOf(lista, lista.length + 1);
        lista[lista.length - 1] = elemento;
    }

    public void insertarFinal (Lista otraLista) {
        for (int i = 0; i < otraLista.lista.length; i++) {
            insertarFinal(otraLista.lista[i]);
        }
    }

    public void insertar(int index, Object elemento){
        if (index >= 0 && index < lista.length) {
            lista = Arrays.copyOf(lista, lista.length + 1);
            System.arraycopy(lista, index, lista, index + 1, lista.length - index - 1);
            lista[index] = elemento;
        }
    }

    public Object eliminar (int index) {
        Object elemento = null;
        if (index >= 0 && index < lista.length) {
            elemento = lista[index];
            System.arraycopy(lista, index + 1, lista, index, lista.length - index - 1);
            lista = Arrays.copyOf(lista, lista.length - 1);
        }
        return elemento;
    }

    public Object get(int index){
        Object elemento = null;
        if (index >= 0 && index < lista.length) {
            elemento = lista[index];
        }
        return elemento;
    }

    public int buscar(Object elemento){
        boolean encontrado = false;
        int index = -1;
        for (int i = 0; i < lista.length && !encontrado; i++) {
            if (lista[i].equals(elemento)) {
                index = i;
                encontrado = true;
            }
        }
        return index;
    }

    public boolean estaVacia() {
        return lista.length == 0;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(lista);
    }

    @Override
    public void encolar(Object elemento) {
        insertarFinal(elemento);
    }

    @Override
    public Object desencolar() {
        return eliminar(0);
    }

    @Override
    public void apilar(Object elemento) {
        insertarFinal(elemento);
    }

    @Override
    public Object desapilar() {
        return eliminar(lista.length - 1);
    }
}
