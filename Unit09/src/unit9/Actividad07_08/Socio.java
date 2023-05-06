package unit9.Actividad07_08;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
    Actividad 7
    Implementar la interfaz Comparable en la clase Socio par que por defecto se ordenen según los números de identificación - id - crecientes

    Actividad 8
    Cambiar la implementación de la clase Socio para que su criterio de ordenación natural sea por orden alfabético creciente de nombre
 */
public class Socio implements Comparable<Socio>{
    private int id;
    private String nombre;
    private LocalDate fechaNacimiento;

    public Socio(int id, String nombre, LocalDate fechaNacimiento){
        this.id = id;
        this.nombre = nombre;
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fechaNacimiento = LocalDate.parse(f.format(fechaNacimiento));
    }

    public int edad(){
        return LocalDate.now().getYear() - fechaNacimiento.getYear();
    }
//    Actividad 7
//    @Override
//    public int compareTo(Socio o) {
//        return this.id - o.id;
//    }

    // Actividad 8
    @Override
    public int compareTo(Socio o) {
        return this.nombre.compareTo(o.nombre);
    }
}
