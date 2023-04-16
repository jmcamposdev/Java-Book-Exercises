package unit11.Actividad09;

import java.time.LocalDateTime;

public class Registro implements java.io.Serializable {
    private double temperatura;
    private LocalDateTime fecha;

    public Registro(double temperatura) {
        this.temperatura = temperatura;
        this.fecha = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Registro: " + temperatura + "ºC, " + fecha;
    }
}
