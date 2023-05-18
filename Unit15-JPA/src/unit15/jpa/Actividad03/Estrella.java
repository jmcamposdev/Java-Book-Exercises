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
    @Id // Indica que el atributo es la clave primaria
    @GeneratedValue // Indica que el valor de la clave primaria se genera automáticamente
    @Column(name = "id")
    private Long id;
    
    @Column(name = "duracion") // Indica que el atributo se corresponde con una columna de la tabla
    private double duracion;
    
    @Column(name = "intensidad") // Indica que el atributo se corresponde con una columna de la tabla
    private int intensidad;
    
    @Column(name = "verdoso") // Indica que el atributo se corresponde con una columna de la tabla
    private boolean verdoso;

    // Importante: los métodos get y set deben ser públicos para que JPA pueda acceder a ellos
    public Estrella() {
    }

    /**
     * Constructor de la clase Estrella
     * Devuelve una nueva instancia de la clase Estrella
     * La duración y la intensidad deben ser valores positivos
     * @param duracion Duración de la estrella fugaz en segundos
     * @param intensidad Intensidad de la estrella fugaz (de 1 a 100)
     * @param verdoso Indica si la luz que emitía la estrella fugaz era de color verdoso
     */
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