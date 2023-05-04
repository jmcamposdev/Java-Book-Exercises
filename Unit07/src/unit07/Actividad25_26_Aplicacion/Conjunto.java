package unit07.Actividad25_26_Aplicacion;

import unit07.Actividad11_12.Lista;

/*
    Actividad 7.25
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

    Actividad 7.26
    Añade a la clase Conjunto los siguientes métodos estáticos:
    • static boolean incluido (Conjunto c1, Conjunto c2): que devuelve true Si d está incluido en c2, es decir, si todos los elementos de c1 están también en c2.
    • static Conjunto union (Conjunto c1, Conjunto c2): devuelve un nuevo conjunto con todos los elementos que están en c1, en c2 o en ambos (elementos comunes y no comunes).
    • static interseccion (Conjunto c1, Conjunto c2): que devuelve un nuevo conjunio con todos los elementos que están en c1 y en c2 a la vez (elementos comunes).
    • static diferencia (Conjunto c1, Conjunto c2): que devuelve un nuevo conjunio con todos los elementos que están en c1, pero no en c2.
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

    public static boolean incluido (Conjunto c1, Conjunto c2) {
        // Comprobamos que los conjuntos tengan la misma longitud
        boolean mismaLongitud = c1.numeroElementos() == c2.numeroElementos();
        boolean incluido = mismaLongitud;

        if (mismaLongitud) { // Si tienen la misma longitud, comprobamos que todos los elementos de c1 estén en c2
            Lista listaC2 = c2.lista; // Guardamos la lista de c2 para no tener que acceder a ella cada vez
            Integer[] listaC1Lista = c1.lista.getLista(); // Guardamos la lista de c1 para no tener que acceder a ella cada vez
            for (int i = 0; i < listaC1Lista.length && incluido; i++) { // Recorremos la lista de c1
                if (listaC2.search(listaC1Lista[i]) == -1) { // Si el elemento de c1 no está en c2, no está incluido
                    incluido = false; // Establecemos incluido a false
                }
            }
        }
        return incluido;
    }

    public static Conjunto union (Conjunto c1, Conjunto c2) {
        Conjunto union = new Conjunto(); // Creamos un nuevo conjunto
        // Insertamos los elementos de c1 y c2 en el nuevo conjunto
        union.insertar(c1);
        union.insertar(c2);
        return union;
    }

    public static Conjunto interseccion (Conjunto c1, Conjunto c2) {
        Conjunto interseccion = new Conjunto(); // Creamos un nuevo conjunto
        Integer[] listaC1 = c1.lista.getLista(); // Guardamos la lista de c1 para no tener que acceder a ella cada vez
        for (Integer integer : listaC1) { // Recorremos la lista de c1
            if (c2.pertenece(integer)) { // Si el elemento de c1 está en c2, lo añadimos al conjunto
                interseccion.insertar(integer);
            }
        }
        return interseccion;
    }

    public static Conjunto diferencia (Conjunto c1, Conjunto c2) {
        Conjunto diferencia = new Conjunto(); // Creamos un nuevo conjunto
        Integer[] listaC1 = c1.lista.getLista(); // Guardamos la lista de c1 para no tener que acceder a ella cada vez
        for (Integer integer : listaC1) { // Recorremos la lista de c1
            if (!c2.pertenece(integer)) { // Si el elemento de c1 no está en c2, lo añadimos al conjunto
                diferencia.insertar(integer);
            }
        }
        return diferencia;
    }
}
