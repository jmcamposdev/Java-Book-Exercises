package unit11.Actividad02;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
    Escribe como una cadena, en el fichero binario cancionPirata.dat, la siguiente estrofa:
    Con diez cañones por banda,
    viento en popa a toda vela,
    no corta el mar, sino vuela
    un velero bergantín.
 */
public class Actividad2 {
    public static void main(String[] args) {
        File archivo = new File("src/unit11/Actividad02/cancionPirata.dat");
        String estrofa = """
                Con diez cañones por banda,
                viento en popa a toda vela,
                no corta el mar, sino vuela
                un velero bergantín.""";

        try (ObjectOutputStream oos = new ObjectOutputStream(new java.io.FileOutputStream(archivo))) {
            oos.writeObject(estrofa);
            System.out.println("Se ha escrito la estrofa en el fichero binario.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
