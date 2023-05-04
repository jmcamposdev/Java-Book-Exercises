package unit07.Actividad23_Aplicacion;
import java.util.Arrays;

/*
    Implementa la clase Pila para números Integer, usando directamente una tabla para, guardar los elementos apilados.
 */
public class Pila {
    private Integer[] lista;

    public Pila(){
        lista = new Integer[0];
    }

    public void apilar(Integer num){
        lista = Arrays.copyOf(lista, lista.length+1);
        lista[lista.length-1] = num;
    }

    public Integer desapilar(){
        Integer numeroElminado = null;
        if (lista.length != 0) {
            numeroElminado = lista[lista.length-1];
            lista = Arrays.copyOf(lista, lista.length-1);
        }
        return numeroElminado;
    }
}

