package unit15.jpa.Actividad01_02;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
    Actividad 1
    Escribir la clase Alumno con los atributos: número de alumnos (que identificará cada
    uno de los alumnos), nombre, dirección y nota media. Convertir dicha clase en una Entidad

    Actividad 2
    Modificar la Clase Alumno para que JPA se encargue de asignar un número distinto a cada alumno.
 */

@Entity
public class Alumno implements java.io.Serializable {
    @Id // Indica que el atributo es la clave primaria
    @GeneratedValue // Indica que el valor de la clave primaria se genera automáticamente
    private int numero;
    private String nombre;
    private String direccion;
    private double notaMedia;

    public Alumno() {
    }

    // No es necesario el atributo número en el constructor, ya que JPA se encarga de asignarle un valor
    public Alumno(String nombre, String direccion, double notaMedia) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.notaMedia = notaMedia;
    }

    // Importante: los métodos get y set deben ser públicos para que JPA pueda acceder a ellos
    // No es necesario el método setNumero, ya que JPA se encarga de asignarle un valor
    public int getNumero() {
        return numero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public double getNotaMedia() {
        return this.notaMedia;
    }

    @Override
    public String toString() {
        return "Alumno{" + "numero=" + numero + ", nombre=" + nombre + ", direccion=" + direccion + ", notaMedia=" + notaMedia + '}';
    }
}
