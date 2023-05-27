package codigo;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Main {

    
    public static void main(String[] args) {        
        
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("barcosMarinerosPU");
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT m FROM Marinero m WHERE m.barco IS null";
        Query query = em.createQuery(jpql);
        List<Marinero> marineros = query.getResultList();
        
        System.out.println("Marineros sin barco");
        for(Marinero m: marineros) {
              System.out.println(m);
           }
        }
    }

