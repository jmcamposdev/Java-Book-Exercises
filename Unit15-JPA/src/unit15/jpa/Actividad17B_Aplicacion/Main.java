package unit15.jpa.Actividad17B_Aplicacion;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("PeriodistasPU");

        
        PeriodistaDAO dao = new PeriodistaDAO(emf);
        
        List<Periodista> todosPeriodistas = dao.findPeriodistaEntities();

       
        System.out.println("Periodistas sin artículos");
        for (Periodista p : todosPeriodistas) {
            if (p.getArticulos().isEmpty()) { 
                System.out.println(p);
            }
        }

        
       
        System.out.println("Periodistas con más de 2 artículos");
        for (Periodista p : todosPeriodistas) {
            if (p.getArticulos().size() > 2) { 
                System.out.println(p);
            }
        }
    }
}
