package unit15.jpa.Actividad15_Aplicacion;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Taxi implements Serializable {
    @Id
    private String matricula;
    private Double precio;
    private int numPlazas;

    public Taxi(String matricula, Double precio, int numPlazas) {
        this.matricula = matricula;
        this.precio = precio;
        this.numPlazas = numPlazas;
    }

    public Taxi() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    @Override
    public String toString() {
        return "Taxi{" + "matricula=" + matricula + ", precio=" + 
                precio + ", numPlazas=" + numPlazas + '}';
    }
}
