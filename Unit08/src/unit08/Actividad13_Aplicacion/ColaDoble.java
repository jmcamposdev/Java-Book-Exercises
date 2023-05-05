package unit08.Actividad13_Aplicacion;

import unit08.Actividad12_Aplicacion.Cola;

/*
    Diseña la clase ColaDoble que hereda de Cola para enteros, añadiendo los siguientes métodos:
        • void encolarPrincipio(Cola elemento) que encola un elemento al principio
        • Integer desencolarFinal() que desencola un elemento del final

 */
public class ColaDoble extends Cola {
    public ColaDoble(){
        super();
    }

    public void encolarPrincipio(Cola elemento){
        for (int i = 0; i < elemento.numeroElementos(); i++) {
            super.addStart(elemento.get(i));
        }
    }

    public Integer desencolarFinal(){
        Integer numeroEliminado = null;
        if (super.numeroElementos()-1 != -1){
            numeroEliminado = super.removeInteger(super.numeroElementos()-1);
        }
        return numeroEliminado;
    }
}
