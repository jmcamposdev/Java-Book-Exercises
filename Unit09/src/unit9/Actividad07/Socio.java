package unit9.Actividad07;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
    Implementar la interfaz Comparable en la clase Socio par que por defecto se ordenen según los números de identificación - id - crecientes
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

    @Override
    public int compareTo(Socio o) {
        return this.id - o.id;
    }
}
