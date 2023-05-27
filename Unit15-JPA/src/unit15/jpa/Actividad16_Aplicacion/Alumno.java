package unit15.jpa.Actividad16_Aplicacion;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Alumno implements Serializable {
    @Id
    private int num;
    private String nombre;
    private String tlf;
    
    @OneToOne(orphanRemoval = false)
    private Portatil portatil;

    
    public Alumno(int num, String nombre, String tlf, Portatil portatil) {
        this.num = num;
        this.nombre = nombre;
        this.tlf = tlf;
        this.portatil = portatil;
    }

    
    public Alumno() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public Portatil getPortatil() {
        return portatil;
    }

    public void setPortatil(Portatil portatil) {
        this.portatil = portatil;
    }

    @Override
    public String toString() {
        return "Alumno{" + "num=" + num + ", nombre=" + nombre + 
               ", tlf=" + tlf + ", portatil=" + portatil + '}';
    } 
}
