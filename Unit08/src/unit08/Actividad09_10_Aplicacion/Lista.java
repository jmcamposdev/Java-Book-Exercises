package unit08.Actividad09_10_Aplicacion;
/*
    Actividad 9
    Reimplementa la clase lista de la Actividad 11 de la Unitdad 7 sustituyendo el método
    mostrar() por el método toString() y sobreescribiendo el método toString() de la clase Object.

    Actividad 10
    Sobreescribe el método equals() para compararlas. Dos listas se considerarán iguales si tienen
    los mismos elementos (incluidas las repeticiones) en el mismo orden.

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lista lista1 = (Lista) o;

        return Arrays.equals(lista, lista1.lista);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(lista);
    }

    @Override
    public String toString() {
        return Arrays.toString(lista);
    }
}
