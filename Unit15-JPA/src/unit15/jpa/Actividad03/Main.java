package unit15.jpa.Actividad03;

import javax.persistence.*;


// Prueba del Funcionamiento de JPA
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("estrellas");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Estrella estrella = new Estrella(10.0, 100, false);
        System.out.println(estrella);
        em.persist(estrella);

        tx.commit();

        em.close();
        emf.close();
    }
}
