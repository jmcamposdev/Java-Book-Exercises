package unit15.jpa.Actividad19_Aplicacion;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Fan implements Serializable {
    private String nombre;
    @Id
    private String dni;
    @ManyToOne
    private Casa casa;

    public Fan() {
    }

    public Fan(String nombre, String dni, Casa casa) {
        this.nombre = nombre;
        this.dni = dni;
        this.casa = casa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
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
        final Fan other = (Fan) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fan{" + "nombre=" + nombre + ", dni=" + dni + 
                ", casa=" + casa + '}';
    }
}
