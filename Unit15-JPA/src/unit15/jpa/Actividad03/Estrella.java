package unit15.jpa.Actividad03;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Se quiere almacenar la información de toods los avistamientos de estrellas fugaces que ocurren en un observatorio.
 * De cada avistamiento interesa: la duración de la estrella fugaz (en segundos), la intensidad (de 1 a 100) y saber
 * si la luz que emitía la estrella fugaz era de color verdoso. Como no disponemos de nada que identifique a casa estrella
 * fugaz, debe ser JPA el encargado de asignarle un identificador a cada una.
 */
@Entity
@Table(name = "ESTRELLA")
public class Estrella  implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    @Column(name = "duracion")
    private double duracion;
    
    @Column(name = "intensidad")
    private int intensidad;
    
    @Column(name = "verdoso")
    private boolean verdoso;

    public Estrella() {
    }

    public Estrella(double duracion, int intensidad, boolean verdoso) {
        if (duracion < 0) throw new IllegalArgumentException("La duración no puede ser negativa");
        if (intensidad < 0 || intensidad > 100) throw new IllegalArgumentException("La intensidad debe estar entre 0 y 100");

        this.duracion = duracion;
        this.intensidad = intensidad;
        this.verdoso = verdoso;
    }

    public Long getId() {
        return id;
    }


    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        if (duracion < 0) throw new IllegalArgumentException("La duración no puede ser negativa");
        this.duracion = duracion;
    }

    public int getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(int intensidad) {
        if (intensidad < 0 || intensidad > 100) throw new IllegalArgumentException("La intensidad debe estar entre 0 y 100");
        this.intensidad = intensidad;
    }

    public boolean isVerdoso() {
        return verdoso;
    }

    public void setVerdoso(boolean verdoso) {
        this.verdoso = verdoso;
    }

    @Override
    public String toString() {
        return "Estrella{" + "id=" + id + ", duracion=" + duracion + ", intensidad=" + intensidad + ", verdoso=" + verdoso + '}';
    }

    
    

}