package unit07.Actividad07;

/*
    7.7

    Diseña la clase Texto que gestiona una cadena de caracteres con algunas características:
    - La cadena de caracteres tendrá una longitud máxima que se especifica en el constructor.
    - Permite añadir un carácter al principio o final, siempre y cuando no se exceda la longitud máxima,
      Es decir exista espacio suficiente.
    - Es necesario saber cuántas vocales (mayúsculas y minúsculas) hay en el texto;
    - Cada objeto de tipo Texto tiene que conocer la fecha en la que creó. Así como la fecha y hora de la
      última modificación efectuada.
    - Deberá existir un método que muestre la información que gestiona cada texto.
 */

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Texto {
    private String cadena;
    private final int LONGITUD_MAX;
    LocalDate fechaCreacion;
    LocalDateTime fechaModificacion;
    static final String VOCALES = "aeiouáéíóú";

    public Texto(int longitud_max) {
        this.cadena = "";
        LONGITUD_MAX = longitud_max;
        fechaCreacion = LocalDate.now();
        fechaModificacion = null;
    }

    public void addFinal(char c){
        if (cadena.length()+1 <= LONGITUD_MAX){
            cadena+=c;
            fechaModificacion = LocalDateTime.now();
        }
    }

    public void addFinal(String c){
        if (cadena.length()+1 <= LONGITUD_MAX){
            cadena+=c;
            fechaModificacion = LocalDateTime.now();
        }
    }

    public void addStart(char c){
        if (cadena.length()+1 <= LONGITUD_MAX){
            cadena = c + cadena;
            fechaModificacion = LocalDateTime.now();
        }
    }

    public void addStart(String c){
        if (cadena.length()+1 <= LONGITUD_MAX){
            cadena = c + cadena;
            fechaModificacion = LocalDateTime.now();
        }
    }

    public int numVocales(){
        int numVocales = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (esVocal(cadena.charAt(i))){
                numVocales++;
            }
        }
        return numVocales;
    }

    public boolean esVocal (char c){
        boolean esVocal = false;
        if (VOCALES.indexOf(c) != -1){
            esVocal = true;
        }
        return esVocal;
    }

    public void mostrarInformacion(){
        System.out.println("Se creo el: "+fechaCreacion);
        System.out.println("La ultima modificación es: "+fechaModificacion);
        System.out.println("La cadena es: "+cadena);
    }


}
