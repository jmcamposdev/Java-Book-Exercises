package unit13.Actividad31_Ampliacion;


import unit13.Functions.GetData;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/*
    Repite la Actividad Unidad 12 - Actividad 14, pero usando Stream para todos los listados
    Implementar una aplicación que simula el registro de las temperaturas a lo largo de un
    día, en una estación meteorológica. La aplicación mostrará un menu con las opciones;

    1. Nuevo Registro (que introduciremos manualmente, aunque se supone que, en el sistema original estaría controlando
    por el reloj)
    2. Listar Registros.
    3. Mostrar estadísticas (con los valores máximos, mínimo y promedia de las temperaturas registradas hasta el momento
    desde la primera lectura del dia.
    4 Salir.

    Al salir, los datos se grabarán en un fichero binario cuyo nombre estará compuesto por la cadena "registro" concatenada
    con la fecha del día en el formato "yyyyMMdd" y extension .dat.

    Cada registro constará de la temperatura en grados centígrados y la hora, que se leerá del sistema en el momento
    de la creación del registro.
 */
public class Actividad14 {
    public static void main(String[] args) {
        Set<Registro> temperaturas = new LinkedHashSet<>();
        int option;
        do {
            System.out.println("""
                    1. Nuevo Registro
                    2. Listar Registro
                    3. Mostrar Estadísticas
                    4. Salir""");
            option = GetData.getInt("Ingrese una opción: ",1,4);
            switch (option) {
                case 1 -> {
                    double temperatura = GetData.getDouble("Ingrese la Temperatura: ");
                    temperaturas.add(new Registro(temperatura));
                }
                case 2 -> temperaturas.forEach(System.out::println);
                case 3 -> {
                    System.out.println("Maxima: " +  Collections.max(temperaturas));
                    System.out.println("Mínima: " + Collections.min(temperaturas));
                    double suma = 0;
                    for (Registro r : temperaturas) {
                        suma += r.getTemperatura();
                    }

                    System.out.println("Media: " +  suma / temperaturas.size());
                }
            }
        } while (option != 4);

        String nombreArchivo = "src/unit12/Actividad14/registro";
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyyMMdd");
        nombreArchivo += LocalDate.now().format(f);

        try (ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            flujoSalida.writeObject(temperaturas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
