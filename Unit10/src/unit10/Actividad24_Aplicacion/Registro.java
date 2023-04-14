package unit10.Actividad24_Aplicacion;

import java.time.LocalDate;

public class Registro {
    private final LocalDate fecha;
    private final int temperaturaMaxima;
    private final int temperaturaMinima;

    public Registro(LocalDate fecha, int temperaturaMaxima, int temperaturaMinima) {
        if (temperaturaMinima > temperaturaMaxima) {
            throw new IllegalArgumentException("La temperatura Mínima no puede ser superior a la Máxima");
        }
        this.fecha = fecha;
        this.temperaturaMaxima = temperaturaMaxima;
        this.temperaturaMinima = temperaturaMinima;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public int getTemperaturaMinima() {
        return temperaturaMinima;
    }

    @Override
    public String toString() {
        return "Fecha: "+this.fecha+"\tMáxima: "+this.temperaturaMaxima+"\tMínima: "+this.getTemperaturaMinima();
    }
}
