package unit15.jpa.Actividad05;

import Funciones.GetData;
import unit15.jpa.Actividad02_Propuesta.Coche;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/*
    Continuar con la gestión de los coches de la Actividad propuesta 2 y la Actividad 4,
    permitir modificar sus datos (excepto la matrícula).
 */
public class Actividad5 {
    private static final int OPCION_MARCA = 1;
    private static final int OPCION_MODELO = 2;
    private static final int OPCION_PLAZAS = 3;
    private static final int OPCION_SALIR = 4;
    public static void main(String[] args) {
        // Creamos las conexiones
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cochePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Coche coche;
        boolean salir = false;
        int opcion;

        // Pedimos la matrícula del coche
        do {
            coche = em.find(Coche.class, GetData.getString("Introduce la matrícula del coche: "));
            if (coche == null) { // Si no existe el coche
                System.out.println("No existe ningún coche con esa matrícula");
            }
        } while (coche == null); // Mientras no exista el coche

        // Modificamos los datos del coche
        while (!salir) { // Mientras no queramos salir
            mostrarMenu(); // Mostramos el menú
            opcion = GetData.getInt("Introduce una opción: ", 1, 4); // Pedimos una opción

            switch (opcion) { // Según la opción
                case OPCION_MARCA -> // Si queremos modificar la marca
                        coche.setMarca(GetData.getString("Introduce la nueva marca: "));
                case OPCION_MODELO -> // Si queremos modificar el modelo
                        coche.setModelo(GetData.getString("Introduce el nuevo modelo: "));
                case OPCION_PLAZAS -> // Si queremos modificar el número de plazas
                        coche.setPlazas(GetData.getInt("Introduce el nuevo número de plazas: ", 1, 9));
                case OPCION_SALIR -> // Si queremos salir
                        salir = true;
            }
        }

        // Guardamos los cambios en la base de datos
        tx.begin(); // Iniciamos la transacción
        em.merge(coche); // Guardamos los cambios
        tx.commit(); // Confirmamos los cambios

        // Cerramos las conexiones
        em.close();
        emf.close();
    }

    private static void mostrarMenu() {
        System.out.println("""
                1. Modificar marca
                2. Modificar modelo
                3. Modificar número de plazas
                4. Salir""");
    }
}
