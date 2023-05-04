package unit07.Actividad25_Aplicacion;

import unit07.Actividad11_12.Lista;

/*
    Un conjunto es una estructura dinámica de datos como la lista, con dos diferencias:
    en primer lugar, en una lista puede haber elementos repetidos, mientras que en un conjunto no.
    Además, en una lista el orden de inserción de los elementos puede ser relevante Y debemos tenerlo en cuenta,
    mientras que en un conjunto solo interesa si un elemento pertenece o no al conjunto y no el lugar que ocupa.
    Se pide implementar la clase Conjunto utilizando una lista para almacenar números de tipo Integer.
    Implementa los siguientes métodos:
        • Un constructor sin parámetros.
        • int numeroElementos (): devuelve el número de elementos del conjunto.
        • boolean insertar (Integer nuevo) : inserta un nuevo elemento en el conjunto.
        • boolean insertar (Conjunto otroConjunto): añade al conjunto los elementos del conjunto otroConjunto.
        • boolean eliminarElemento (Integer elemento): en caso de pertenecer al conjunto elimina elemento.
        • boolean eliminarConjunto (Conjunto otroConjunto): elimina del conjunto invocante
          los elementos del conjunto que se pasa como parámetro.
        • boolean pertenece (Integer elemento): indica si el elemento que se le pasa como parámetro pertenece o no al conjunto.
        • muestra ( ) : muestra el conjunto por consola.

    De forma general, los métodos que devuelven un booleano indican con el si el conjunio se ha modificado.
 */
public class Conjunto {
    Lista lista;

    public Conjunto(){
        lista = new Lista();
    }

    public int numeroElementos(){
        return lista.numeroElementos();
    }

    public boolean insertar(Integer nuevo){
        boolean insertado = false;
        if (lista.search(nuevo) == -1){
            lista.addFinal(nuevo);
            insertado = true;
        }
        return insertado;
    }

    public boolean insertar(Conjunto otroConjunto){
        boolean insertado = true;
        for (Integer i : otroConjunto.lista.getLista()){
            if (!this.insertar(i)){
                insertado = false;
            }
        }
        return insertado;
    }

    public boolean eliminarElemento(Integer elemento){
        boolean eliminado = false;
        int indice = lista.search(elemento);
        if (indice != -1){
            lista.removeInteger(indice);
            eliminado = true;
        }
        return eliminado;
    }

    public boolean eliminarConjunto(Conjunto otroConjunto){
        boolean eliminado = true;
        int indice;
        for (Integer i : otroConjunto.lista.getLista()){
            if (!this.eliminarElemento(i)){
                eliminado = false;
            }
        }
        return eliminado;
    }

    public boolean pertenece(Integer elemento){
        return lista.search(elemento) != -1;
    }

    public void muestra(){
        lista.mostrarLista();
    }
}
