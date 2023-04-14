package unit10.Actividad16_Aplicacion;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

/*
    Un libro de firmas es útil para recoger los nombres de todas las personas que han pasado por un determinado lugar.
    Crea una aplicación que permita mostrar el libro de firmas e insertar un nuevo nombre (comprobando que no se encuentre repetido).
    Llamaremos al fichero firmas.txt.
*/
public class Actividad16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file = new File("./src/unit10/Actividad16_Aplicacion/firmas.txt");
        HashSet<String> nombres = new HashSet<>();
        if (getNombresFirmas(file,nombres)) {
            System.out.println("Intruccion: \nPara salir del programa ingresa \"0\"");
            String userInput = "";
            while (!userInput.equals("0")) {
                System.out.print("Ingresa un nombre: ");
                userInput = sc.nextLine();
                if (userInput.isBlank()) {
                    System.out.println("Valor no válido");
                } else {
                    if (nombres.add(userInput)) {
                        if (añadirNombre(file,userInput)) {
                            System.out.println("Se ha añadido el nombre");
                        } else {
                            System.out.println("No se ha podido añadir el nombre");
                        }
                        
                    } else {
                        System.out.println("Ese nombre ya existe");
                    }
                }
            }
        } else {
            System.out.println("No existe el fichero");
        }

    }

    public static boolean getNombresFirmas (File file, HashSet<String> nombres) {
        boolean datosObtenidos = true;
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String cad;
                while ((cad = br.readLine()) != null) {
                    nombres.add(cad);
                }
            } catch (IOException e) {
                datosObtenidos = false;
            }
        } else {
            datosObtenidos = false;
        }
        return datosObtenidos;
    }

    public static boolean añadirNombre (File file, String nombre) {
        boolean nombreAñadido = true;
        if (file.exists()) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(file,true))){
                pw.println(nombre);
            } catch (IOException e) {
                nombreAñadido = false;
            }
        }
        return nombreAñadido;
    }
}
