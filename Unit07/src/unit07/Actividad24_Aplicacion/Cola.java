package unit07.Actividad24_Aplicacion;

import unit07.Actividad11_12.Lista;

/*
    Repite la Actividad 22 pero usando una lista para guardar los elementos en vez de una tabla.
 */
public class Cola {
    private Lista lista;

    public Cola(){
        lista = new Lista();
    }

    public void encolar(Integer num){
        lista.addFinal(num);
    }

    public Integer desencolar(){
        Integer numeroElminado = null;
        if (lista.numeroElementos()-1 != -1){
            numeroElminado = lista.removeInteger(0);
        }
        return numeroElminado;
    }
}
