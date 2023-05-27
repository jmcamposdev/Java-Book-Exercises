package unit15.jpa.Actividad23_Aplicacion;

import unit15.jpa.Actividad22_Aplicacion.Barco;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Main {

    
    public static void main(String[] args) {        
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("barcosMarinerosPU");
        EntityManager em = emf.createEntityManager();
        System.out.println("Puesto: ");
        String puesto = new Scanner(System.in).nextLine();

        
        String jpql = "SELECT b FROM Barco b " +
                      "WHERE b IN (SELECT m.barco FROM Marinero m " + 
                                  "WHERE m.puesto = :puesto)";
        
        Query query = em.createQuery(jpql);
        query.setParameter("puesto", puesto);
        List<Barco> barcos = query.getResultList();
        
        System.out.println("Barcos con " + puesto);
        for(Barco b: barcos) {
              System.out.println(b);
           }
        }
    }

