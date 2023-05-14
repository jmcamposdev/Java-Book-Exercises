package unit15.jpa.Actividad02_Propuesta;

import Funciones.GetData;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/*
    Escribe una aplicación que pida por teclado los datos de un coche (matrícula, marca, modelo y
    número de plazas) y lo almacene en la base de datos.
 */
public class Actividad02 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cochePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Coche coche;
        String matricula, marca, modelo;
        int plazas;


        // Pedimos los datos del coche
        matricula = GetData.getString("Introduce la matrícula del coche");
        marca = GetData.getString("Introduce la marca del coche");
        modelo = GetData.getString("Introduce el modelo del coche");
        plazas = GetData.getInt("Introduce el número de plazas del coche", 1, 9);

        // Creamos el objeto coche
        coche = new Coche(matricula, marca, modelo, plazas);

        // Guardamos el coche en la base de datos
        tx.begin();
        em.persist(coche);
        tx.commit();

        // Cerramos las conexiones
        em.close();
        emf.close();

    }
}
