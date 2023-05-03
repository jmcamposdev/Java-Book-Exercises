package unit07.Actividad11_12;
/*
    7.11

    Las Listas son estructuras dinámicas de datos donde se pueden insertar o eliminar elementos
    de un determinado tipo sin limitación de espacio.

    Implementar la clase Lista correpondiente a una lista de números de la clase Integer-
    Los números se guardarám en una tabla que se redimensionará con las inserciones y eliminaciones
    aumentando o disminuyendo la capacidad de la lista según el caso:
    - Un constructor que inicialice la tabla con un tamaño de 0;
    - Obtener el número de elementos insertados en la lista-
    - Insertar un número al final de la lista;
    - Insertar un número al principio de la lista;
    - Insertar un número en un lugar de la lista cuyo índice se pasa por parámetro;
    - Añadir al final de la lista los elementos de otra lista que se pasa como parámetro;
    - Eliminar un elemento cuyo índice en la lista se pasa por parámetro;
    - Obtener el elemento cuyo índice se pasa por parámetro;
    - Buscar un número en la lista, devolviendo el índice del primer lugar donde se encuentre. Si no devolverá -1;
    - Mostrar los elementos de la lisa por consola;

    7.12
    Añadir a la clase Lista el método estático:
        Lista concatena(Lista l1, Lista l2)
    que construye y devuelve una lista que contiene, en el mismo orden, una copia de todos los elementos de l1 y l2

 */

import java.util.Arrays;
import java.util.Objects;

public class Lista {
    private Integer[] lista;

    public Lista(){
        lista = new Integer[0];
    }

    public int numeroElementos(){
        return lista.length;
    }

    public Integer[] getLista() {
        return lista;
    }

    public void add(int index, Integer num){
        if (index < 0 || index >= lista.length){
            throw new IllegalArgumentException("Valor del indice fuera de rando");
        }

        lista = Arrays.copyOf(lista,lista.length+1);
        System.arraycopy(lista,index,lista,index+1,lista.length-index-1);
        lista[index] = num;
    }
    public void addFinal(Integer num){
        lista = Arrays.copyOf(lista,lista.length+1);
        lista[lista.length-1] = num;
    }
    public void addFinal(Integer[] nums){
        lista = Arrays.copyOf(lista,lista.length+nums.length);
        System.arraycopy(nums,0,lista,lista.length-nums.length,nums.length);
    }

    public void addStart(Integer num){
        lista = Arrays.copyOf(lista,lista.length+1);
        System.arraycopy(lista,0,lista,1,lista.length-1);
        lista[0] = num;
    }

    public Integer removeInteger(int index){
        if (index < 0 || index >= lista.length){
            throw new IllegalArgumentException("Valor del indice fuera de rando");
        }
        Integer eliminado = lista[index];
        System.arraycopy(lista,index+1,lista,index,lista.length-index-1);
        lista = Arrays.copyOf(lista,lista.length-1);
        return eliminado;
    }
    public Integer get(int index){
        if (index < 0 || index >= lista.length){
            throw new IllegalArgumentException("Valor del indice fuera de rando");
        }
        return lista[index];
    }

    public int search(Integer num){
        int index = -1;
        for (int i = 0; i < lista.length && index == -1; i++) {
            if (Objects.equals(lista[i], num)){
                index = i;
            }
        }
        return index;
    }

    public static Lista concatena(Lista l1,Lista l2){
        Lista resultado = new Lista();
        for (Integer num : l1.getLista()) {
            resultado.addFinal(num);
        }
        for (Integer num : l2.getLista()) {
            resultado.addFinal(num);
        }
        return resultado;
    }
    public void mostrarLista(){
        System.out.println(Arrays.toString(lista));
    }
}
