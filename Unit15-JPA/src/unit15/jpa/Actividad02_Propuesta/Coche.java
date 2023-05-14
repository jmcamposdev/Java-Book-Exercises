package unit15.jpa.Actividad02_Propuesta;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coche implements java.io.Serializable{
    @Id
    private String matricula;
    private String marca;
    private String modelo;
    private int plazas;

    public Coche() {
    }

    public Coche(String matricula, String marca, String modelo, int plazas) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.plazas = plazas;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public int getPlazas() {
        return this.plazas;
    }

    @Override
    public String toString() {
        return "Coche{" + "matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", plazas=" + plazas + '}';
    }

}
