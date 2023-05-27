package unit15.jpa.Actividad24_Aplicacion;

import unit15.jpa.Actividad22_Aplicacion.Barco;

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
        
        String jpql = "SELECT b FROM Barco b WHERE SIZE(b.marineroCollection) >= 5";
        
        Query query = em.createQuery(jpql);
        List<Barco> barcos = query.getResultList();
        
        System.out.println("Barcos con 3 o más marineros");
        for(Barco b: barcos) {
              System.out.println(b);
           }
        }
    }

