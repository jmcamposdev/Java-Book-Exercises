package unit15.jpa.Actividad21_Aplicacion;

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
        Query query = em.createNamedQuery("Barco.findAll");
        List<Barco> barcos = query.getResultList();
        
        for(Barco b: barcos) {
           System.out.println(b);
           Collection<Marinero> marineros = b.getMarineroCollection();
           for(Marinero m: marineros) {
              System.out.println("\t" + m);
           }
           
        }
    }
}
