package unit15.jpa.Actividad08;

import javax.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue
    @Column(name = "dni")
    private String dni;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "sueldo")
    private double sueldo;
    @Column(name = "oficina")
    private int oficina;
    @Column(name = "puesto")
    private String puesto;

    public Empleado() {
    }

    public Empleado(String dni, String nombre, double sueldo, int oficina, String puesto) {
        this.dni = dni;
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.oficina = oficina;
        this.puesto = puesto;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public int getOficina() {
        return oficina;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void setOficina(int oficina) {
        this.oficina = oficina;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", sueldo=" + sueldo +
                ", oficina=" + oficina +
                ", puesto='" + puesto + '\'' +
                '}';
    }

}
