package unit15.jpa.Actividad15_Aplicacion;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;


@Entity
@NamedQueries({
        @NamedQuery(name="Taxista.trabajando",
                    query="SELECT t FROM Taxista t WHERE t.taxi IS NOT NULL"),
        @NamedQuery(name="Taxista.fueraServicio",
                    query="SELECT t FROM Taxista t WHERE t.taxi IS NULL")
})
public class Taxista implements Serializable {
    @Id
    private String dni;
    private String nombre;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecNac; //los campos de fecha hay que anotarlos con @Temporal
    
    @OneToOne(orphanRemoval = false)
    private Taxi taxi;
    
    public Taxista() {
    }

    public Taxista(String dni, String nombre, Date fecNac) {
        this.dni = dni;
        this.nombre = nombre;
        this.fecNac = fecNac;
    }
    

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    public Taxi getTaxi() {
        return taxi;
    }

    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }

    
    @Override
    public String toString() {
        return "Taxista{" + "dni=" + dni + ", nombre=" + nombre + 
               ", fecNac=" + fecNac + '}';
    }
}
