package unit08.Actividad04;

import java.util.Arrays;

/*
    8.4
    Crear la clase abstracta Instrumento que almacena una tabla de las notas musicales de
    una melodia (dentro de una misma octava). El método add() añade nuevas notas musicales. La
    clase también dispone del método abstracto interpretar() que en cada subclase que herede de
    Instrumento, mostrará por consola las notas musicales según las interprete.
    Utilizar enum para definir las notas musicales
 */
public abstract class Instrumento {
    protected Notas[] melodia;

    public Instrumento(){
        melodia = new Notas[0];
    }
    public void add(Notas nota){
        this.melodia = Arrays.copyOf(melodia,melodia.length+1);
        this.melodia[melodia.length-1] = nota;
    }

    abstract void interpretar();
}
