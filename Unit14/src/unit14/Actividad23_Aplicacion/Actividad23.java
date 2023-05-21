package unit14.Actividad23_Aplicacion;

import unit14.Actividad15_Aplicacion.DAO.OficinaDAO;
import unit14.Actividad15_Aplicacion.Oficina;
import unit14.Funciones.GetData;

import java.util.ArrayList;

/*
    Crea un programa que permita modificar la ciudad e incrementar las ventas de una oficina
 */
public class Actividad23 {
    public static void main(String[] args) {
        OficinaDAO oficinaDAO = new OficinaDAO(); // Instancia de OficinaDAO
        ArrayList<Oficina> oficinas = (ArrayList<Oficina>) oficinaDAO.readAll(); // ArrayList de oficinas
        boolean salir = false; // Variable para salir del bucle

        while (!salir) {
            int index = getIndexOficina(oficinas); // Obtenemos el índice de la oficina
            if (index == oficinas.size()) { // Si el índice es igual al tamaño del ArrayList
                salir = true; // Salimos del bucle
            } else {
                Oficina oficina = oficinas.get(index); // Obtenemos la oficina
                // Mostramos la oficina
                System.out.println("Oficina: " + oficina);
                int option = GetData.getInt("1 - Modificar ciudad\n2 - Incrementar ventas\n3 - Salir\nIntroduce una opción: ", 1, 3); // Pedimos la opción
                switch (option) {
                    case 1 -> { // Si la opción es 1
                        String ciudad = GetData.getString("Introduce la nueva ciudad: "); // Pedimos la nueva ciudad
                        oficina.setCiudad(ciudad); // Modificamos la ciudad
                        oficinaDAO.update(oficina); // Actualizamos la oficina
                        System.out.println("Ciudad modificada correctamente");
                    }
                    case 2 -> { // Si la opción es 2
                        int ventas = GetData.getInt("Introduce el incremento de ventas: ", 1, Integer.MAX_VALUE); // Pedimos el incremento de ventas
                        oficina.setVentas(oficina.getVentas() + ventas); // Incrementamos las ventas
                        oficinaDAO.update(oficina); // Actualizamos la oficina
                        System.out.println("Ventas incrementadas correctamente");
                    }
                    case 3 -> salir = true; // Salimos del bucle
                }
            }
        }
    }

    private static int getIndexOficina(ArrayList<Oficina> oficinas) {
        mostrarOficinas(oficinas);
        System.out.println(oficinas.size()+1 + " - Salir");
        return GetData.getInt("Introduce el número de la oficina: ", 1, oficinas.size()+1) - 1;
    }

    private static void mostrarOficinas(ArrayList<Oficina> oficinas) {
        for (int i = 0; i < oficinas.size(); i++) {
            System.out.println((i+1) + " - " + oficinas.get(i));
        }
    }
}
