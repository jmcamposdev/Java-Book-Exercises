package unit12.Actividad35_Ampliacion;

import unit12.Actividad02.Cola;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/*
    Añade a la clase Contenedor para tipos genéricos los métodos:
        int [] buscarTodos (Object e): devuelve una tabla con los índices de todas las ocurrencias de e.
        boolean eliminarTodos (Object e): elimina todas las ocurrencias de e. Devuelve true si la lista queda alterada.
 */

public class Contenedor<T> implements Comparable<T>, Cola<T> {
    private T[] objetos;

    public Contenedor(T[] objetos) {
        this.objetos = objetos;
    }

    public void insertarAlPrincipio (T nuevo) {
        objetos = Arrays.copyOf(objetos, objetos.length +1);
        System.arraycopy(objetos,0,objetos,1,objetos.length -1);
        objetos[0] = nuevo;
    }

    public void insertarAlFinal (T nuevo) {
        objetos = Arrays.copyOf(objetos, objetos.length +1);
        objetos[objetos.length - 1] = nuevo;
    }

    public T extraerDelPrincipio() {
        T objetoExtraido = null;
        if (objetos.length > 0) {
            objetoExtraido = objetos[0];
            objetos = Arrays.copyOfRange(objetos, 1, objetos.length);
        }

        return objetoExtraido;
    }

    public T extraerDelFinal() {
        T objetoExtraido = null;
        if (objetos.length > 0) {
            objetoExtraido = objetos[objetos.length - 1];
            objetos = Arrays.copyOf(objetos, objetos.length - 1);
        }

        return objetoExtraido;
    }

    public T get (int indice) {
        T objetoExtraido = null;
        if (indice >= 0 && indice < objetos.length) {
            objetoExtraido = objetos[indice];
        }
        return objetoExtraido;
    }

    public void ordenar() {
        Arrays.sort(objetos);
    }

    public void ordenar(Comparator<T> c) {
        Arrays.sort(objetos, c);
    }

    public int[] buscarTodos (T e) {
        int[] indices = new int[0];
        for (int i = 0; i < objetos.length; i++) {
            if (objetos[i].equals(e)) {
                indices = Arrays.copyOf(indices, indices.length + 1);
                indices[indices.length - 1] = i;
            }
        }
        return indices;
    }

    public boolean eliminarTodos (T e) {
        boolean listaAlterada = false;
        Iterator<T> iterador = Arrays.stream(objetos).iterator();
        while (iterador.hasNext()) {
            if (iterador.next().equals(e)) {
                iterador.remove();
                listaAlterada = true;
            }
        }
        return listaAlterada;
    }


    @Override
    public String toString() {
        return "Contenedor{" +
                "objetos=" + Arrays.toString(objetos) +
                '}';
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }

    @Override
    public void encolar(T elemento) {
        this.insertarAlFinal(elemento);
    }

    @Override
    public T desencolar() {
        return this.extraerDelPrincipio();
    }
}
