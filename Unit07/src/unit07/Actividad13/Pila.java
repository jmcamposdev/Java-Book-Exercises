package unit07.Actividad13;

import unit07.Actividad11_12.Lista;

/*
    7.13
    Una pila es una estructura de dinámica de datos donde los elementos se insertan
    (se apilan) y se retiran (se desapilan) siguiendo la norma de que el último que se apila será el
    primero en desapilarse, como ocurre con una pila de platos. Cuando vamos a retirar un plato de
    una pilaa a nadie se le ocurre tirar de uno de los de abajo; retiramos el que está encima de todos
    que fue el último en ser apilado. Se llama cima de la pila al último elemento apilado. Los métodos
    fundamentales de una pila son apilar() y desapilar()

    Implementar la clase Pila para números Integer, donde se usa una lista (un objeto de la clase Lista
    implementada en la Actividad 7.11) para guardar los elemento apilados;
 */
public class Pila {
    private Lista lista;

    public Pila(){
        lista = new Lista();
    }

    public void apilar(Integer num){
        lista.addFinal(num);
    }

    public Integer desapilar(){
        Integer numeroElminado = null;
        if (lista.numeroElementos()-1 != -1){
            numeroElminado = lista.removeInteger(lista.numeroElementos()-1);
        }
        return numeroElminado;
    }
}
