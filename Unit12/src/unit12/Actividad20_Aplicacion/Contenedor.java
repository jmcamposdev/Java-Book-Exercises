package unit12.Actividad20_Aplicacion;

import unit12.Actividad02.Cola;

import java.util.Arrays;
import java.util.Comparator;

/*
    Añade a la clase Contenedor el método
    T get (int indice),
    que devuelve el elemento que ocupa el lugar indice dentro del contenedor.
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
