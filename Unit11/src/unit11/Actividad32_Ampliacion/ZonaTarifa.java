package unit11.Actividad32_Ampliacion;

import java.io.Serializable;

public enum ZonaTarifa implements Serializable {
    ZONA_A(0.10),
    ZONA_B(0.15),
    ZONA_C(0.20),
    ZONA_D(0.25),
    ZONA_E(0.30);

    private final double costo;

    ZonaTarifa(double costo) {
        this.costo = costo;
    }

    public double getCoste() {
        return costo;
    }
}
