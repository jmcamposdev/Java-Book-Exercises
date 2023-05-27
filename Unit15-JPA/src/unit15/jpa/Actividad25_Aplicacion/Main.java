package unit15.jpa.Actividad25_Aplicacion;

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
        
        String jpql = "SELECT m.puesto, AVG(m.sueldo) FROM Marinero m " +
                      "GROUP BY m.puesto ORDER BY m.puesto";
        
        Query query = em.createQuery(jpql);
        List<Object[]> resultados = query.getResultList();
        
        System.out.println("Puesto y sueldo medio");
        for(Object[] x : resultados) {
              System.out.println(x[0] + ": " + x[1]);
           }
        }
    }

