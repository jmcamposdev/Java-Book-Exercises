package unit08.Actividad05;

import unit08.Actividad04.Instrumento;
import unit08.Actividad04.Notas;

public class Piano extends Instrumento {

    public Piano(){
        super();
    }
    @Override
    public void interpretar() {
        for (Notas nota: melodia) {
            System.out.println(nota);
        }
    }
}
