package unit9.Actividad20_24_Aplicacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
    Actividad 20
    Implementar la interfaz Comparable en la clase Socio para que el criterio de ordenación natural sea de menor a mayor edad

    Actividad 21
    Repetir la Actividad 20 para que se ordene por edades y su dos socios tienen la misma edad, vaya antes el que tenga un número de socio menor

    Actividad 22
    Repetir la Actividad 21 con un criterio que ordene por fechas de nacimiento

    Actividad 23
    Definir una clase comparadores que ordene los socios por orden alfabético de nombres.

    Actividad 24
    Repetir la Actividad 23 con un orden alfabético de nombre invertido
 */
public class Socio implements Comparable<Socio>{
    private int id;
    private String nombre;
    private LocalDate fechaNacimiento;

    public Socio(int id, String nombre, LocalDate fechaNacimiento){
        this.id = id;
        this.nombre = nombre;
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fechaNacimiento = fechaNacimiento;
    }

    public int edad(){
        return LocalDate.now().getYear() - fechaNacimiento.getYear();
    }

    public String getNombre() {
        return this.nombre;
    }


//    Actividad 20
//    @Override
//    public int compareTo(Socio o) {
//        return this.edad() - o.edad();
//    }

//    Actividad 21
//    @Override
//    public int compareTo(Socio o) {
//        int resultado = this.edad() - o.edad();
//        if (resultado == 0) {
//            resultado = this.id - o.id;
//        }
//        return resultado;
//    }

    // Actividad 22
    @Override
    public int compareTo(Socio o) {
        int resultado = this.fechaNacimiento.compareTo(o.fechaNacimiento);
        if (resultado == 0) {
            resultado = this.id - o.id;
        }
        return resultado;
    }

    @Override
    public String toString() {
        return id + " " + nombre + " " + fechaNacimiento;
    }
}
