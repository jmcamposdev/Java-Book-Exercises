package unit11.Actividad26_Ampliacion;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Registro implements Serializable {
    private static final DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final double tempMax;
    private final double tempMin;
    private final LocalDate fecha;

    public Registro(double tempMax, double tempMin, LocalDate fecha) {
        if (tempMax < tempMin) {
            throw new IllegalArgumentException("La temperatura máxima no puede ser menor que la mínima.");
        }

        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.fecha = fecha;
    }

    public double getTempMax() {
        return tempMax;
    }

    public double getTempMin() {
        return tempMin;
    }

    @Override
    public String toString() {
        return String.format("%s\t%.2f\t\t\t%.2f\t\t\t%.2f", formateador.format(fecha), tempMax, tempMin, tempMax - tempMin);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Registro registro = (Registro) o;

        return fecha.equals(registro.fecha);
    }

    @Override
    public int hashCode() {
        return fecha.hashCode();
    }

}
