package unit13.Actividad08;

import unit13.Actividad07.Calculos;

import java.util.Arrays;

/*
    Definir la interfaz Funcion2, donde se declara el método abstracto
        U operar (T a, V b),
    que admite dos parámetros, de tipo T y v respectivamente, y devuelve un resultado de tipo U.
    Implementar el método estático
        static <T, V, U> UlI operarTablas (TI] op1, VII op2, UlI resultado, Funcion<T, V, U> f)
    Al que se pasan dos tablas, op1 y op2, y devuelve otra tabla cuyos elementos son el resultado de operar
    los elementos correspondientes de op1 y op2 utilizando el método implementado en f.
    Añadir a Calculos el método producto (), que devuelve el producto de los dos valores reales que se le pasan como parámetros. Usar el método operar () para multiplicar los valores de dos tablas de tipo Double.
 */
public class Actividad8 {
    public static void main(String[] args) {
        Double[] op1 = {1., 2., 3., 4., 5.};
        Double[] op2 = {1., 2., 3., 4., 5.};
        Double[] resultado = operar(op1, op2, new Double[0], Calculos::producto);
        System.out.println(Arrays.toString(resultado));

        Double[] op3 = {1., 2., 3., 4., 5.};
        Double[] op4 = {1., 2., 3., 4., 5.};
        Double[] resultado2 = new Double[op3.length];
        resultado2 = operar(op3, op4, resultado2, (a, b) -> a*b);
        System.out.println(Arrays.toString(resultado2));
    }

    static <T, V, U> U[] operar (T[] op1, V[] op2, U[] resultado, Funcion2<T, V, U> f) {
        if (op1.length == op2.length) {
            resultado = Arrays.copyOf(resultado, op1.length);
            for (int i = 0; i < op1.length; i++) {
                resultado[i] = f.operar(op1[i], op2[i]);
            }
        } else {
            resultado = null;
        }
        return resultado;
    }
}
