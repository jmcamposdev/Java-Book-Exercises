package unit15.jpa.Actividad17A_Aplicacion;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("PeriodistasPU");

        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT p FROM Periodista p WHERE p.articulos IS EMPTY";
        Query query = em.createQuery(jpql);

        System.out.println("Periodistas sin artículos");
        List<Periodista> lista = query.getResultList();
        for (Periodista a : lista) {
            System.out.println(a);
        }

        
        jpql = "SELECT p FROM Periodista p WHERE SIZE(p.articulos) > 2";
        query = em.createQuery(jpql);

        System.out.println("Periodista que tienen más de 2 artículos");
        lista = query.getResultList();

        for (Periodista p : lista) {
            System.out.println(p);
        }

    }
}
