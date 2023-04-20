package unit12.Actividad26_Aplicacion;

import unit12.Actividad23_Aplicacion.Cola;

/*
    Utilizando colecciones, implementa la clase Supercola, que tiene como atributos dos colas para enteros,
    en las que se encola y desencola por separado.
    Sin embargo, si una de las colas queda vacía, al llamar a su método desencolar (),
    se desencola de la otra mientras tenga elementos.
    Solo cuando las dos colas estén vacías, cualquier llamada a desencolar devolverá nu1l. Escribe un programa con el menú:
    1. Encolar en colal.
    2. Encolar en cola2.
    3. Desencolar de colal.
    4. Desencolar de cola2.
    5. Salir.
    Después de cada operación se mostrará el estado de las dos colas para seguir su evolución.
 */
public class SuperCola <T>{
    Cola<T> cola1 = new Cola<>();
    Cola<T> cola2 = new Cola<>();

    public void encolarCola1 (T numero) {
        cola1.encolar(numero);
    }
    public void encolarCola2 (T numero) {
        cola2.encolar(numero);
    }
    public T desencolarCola1 () {
        T objeto = null;
        if (!cola1.estaVacia()) {
            objeto = cola1.desencolar();
        } else if (!cola2.estaVacia()) {
            objeto = cola2.desencolar();
        }
        return objeto;
    }
    public T desencolarCola2 () {
        T objeto = null;
        if (!cola2.estaVacia()) {
            objeto = cola2.desencolar();
        } else if (!cola1.estaVacia()) {
            objeto = cola1.desencolar();
        }
        return objeto;
    }

}
