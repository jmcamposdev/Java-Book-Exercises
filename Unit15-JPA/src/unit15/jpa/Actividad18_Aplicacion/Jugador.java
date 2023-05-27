
package unit15.jpa.Actividad18_Aplicacion;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Jugador implements Serializable {
    @Id
    @GeneratedValue
    private Integer nij;
    private String nombre;
    private Integer puntuacionMax;

    public Jugador(String nombre, Integer puntuacionMax) {
        this.nombre = nombre;
        this.puntuacionMax = puntuacionMax;
    }

    public Jugador() {
    }
    

    public Integer getNij() {
        return nij;
    }

    public void setNij(Integer nij) {
        this.nij = nij;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPuntuacionMax() {
        return puntuacionMax;
    }

    public void setPuntuacionMax(Integer puntuacionMax) {
        this.puntuacionMax = puntuacionMax;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nij=" + nij + ", nombre=" + nombre + 
               ", puntuacionMax=" + puntuacionMax + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jugador other = (Jugador) obj;
        if (!Objects.equals(this.nij, other.nij)) {
            return false;
        }
        return true;
    }
}
