package unit9.Actividad_16_Aplicacion;


import unit9.Actividad11.Lista;

public class SuperCola {
    private final Lista cola1;
    private final Lista cola2;

    public SuperCola() {
        cola1 = new Lista();
        cola2 = new Lista();
    }

    public void encolar1(int elemento) {
        cola1.insertarFinal(elemento);
    }

    public void encolar2(int elemento) {
        cola2.insertarFinal(elemento);
    }

    public Integer desencolar1() {
        Integer elemento = null;
        if (!cola1.estaVacia()) {
            elemento = (Integer) cola1.eliminar(0);
        } else if (!cola2.estaVacia()) {
            elemento = (Integer) cola2.eliminar(0);
        }
        return elemento;
    }

    public Integer desencolar2() {
        Integer elemento = null;
        if (!cola2.estaVacia()) {
            elemento = (Integer) cola2.eliminar(0);
        } else if (!cola1.estaVacia()) {
            elemento = (Integer) cola1.eliminar(0);
        }
        return elemento;
    }

    @Override
    public String toString() {
        return "Cola1: " + cola1 + "\nCola2: " + cola2 + "\n";
    }
}
