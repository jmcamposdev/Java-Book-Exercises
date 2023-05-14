package unit15.jpa.Actividad06;

import Funciones.GetData;
import unit15.jpa.Actividad02_Propuesta.Coche;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/*
    Para finalizar al gestión de los coches de la Actividad 5, escribir una última
    aplicación que permite eliminar un coche por su matrícula
 */
public class Actividad6 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cochePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Coche coche;
        String matricula;

        // Pedimos la matrícula del coche
        matricula = GetData.getString("Introduce la matrícula del coche: ");

        // Buscamos el coche
        coche = em.find(Coche.class, matricula);

        // Si existe el coche
        if (coche != null) {
            // Lo eliminamos
            System.out.println("Eliminando el coche con matrícula " + matricula + "...");
            tx.begin();
            em.remove(coche);
            tx.commit();
        } else { // Si no existe el coche
            System.out.println("No existe ningún coche con esa matrícula");
        }
    }
}
