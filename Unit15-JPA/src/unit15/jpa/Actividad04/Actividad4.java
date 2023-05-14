package unit15.jpa.Actividad04;

import Funciones.GetData;
import unit15.jpa.Actividad02_Propuesta.Coche;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/*
    Como ya disponemos de un programa que almacena los datos de un coche en la base de datos Actividad 2 Propuesta,
    diseñar una aplicación que mediante la matrícula recupere los datos de la BD y los muestre por pantalla.
 */
public class Actividad4 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cochePU");
        EntityManager em = emf.createEntityManager();

        Coche coche;
        String matricula;

        // Pedimos la matrícula del coche
        matricula = GetData.getString("Introduce la matrícula del coche");

        // Buscamos el coche en la base de datos
        coche = em.find(Coche.class, matricula);
        if (coche != null) {
            System.out.println(coche);
        } else {
            System.out.println("No se ha encontrado ningún coche con esa matrícula");
        }

        // Cerramos las conexiones
        em.close();
        emf.close();
    }
}
