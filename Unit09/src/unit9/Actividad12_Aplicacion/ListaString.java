package unit9.Actividad12_Aplicacion;

import unit9.Actividad11.Lista;

import java.util.Arrays;

/*
    Implementar la clase Lista para almacenar elementos de tipo String
 */
public class ListaString {
    String[] lista;

    public ListaString(){
        lista = new String[0];
    }

    public void insertarPrincipio(String elemento){
        lista = Arrays.copyOf(lista, lista.length + 1);
        System.arraycopy(lista, 0, lista, 1, lista.length - 1 );
        lista[0] = elemento;
    }

    public void insertarFinal(String elemento){
        lista = Arrays.copyOf(lista, lista.length + 1);
        lista[lista.length - 1] = elemento;
    }

    public void insertarFinal (ListaString otraLista) {
        for (int i = 0; i < otraLista.lista.length; i++) {
            insertarFinal(otraLista.lista[i]);
        }
    }

    public void insertar(int index, String elemento){
        if (index >= 0 && index < lista.length) {
            lista = Arrays.copyOf(lista, lista.length + 1);
            System.arraycopy(lista, index, lista, index + 1, lista.length - index - 1);
            lista[index] = elemento;
        }
    }

    public String eliminar (int index) {
        String elemento = null;
        if (index >= 0 && index < lista.length) {
            elemento = lista[index];
            System.arraycopy(lista, index + 1, lista, index, lista.length - index - 1);
            lista = Arrays.copyOf(lista, lista.length - 1);
        }
        return elemento;
    }

    public String get(int index){
        String elemento = null;
        if (index >= 0 && index < lista.length) {
            elemento = lista[index];
        }
        return elemento;
    }

    public int buscar(String elemento){
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

    @Override
    public String toString() {
        return Arrays.deepToString(lista);
    }
}
