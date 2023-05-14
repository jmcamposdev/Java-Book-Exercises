package unit15.jpa.Actividad09;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Objects;

/*
    Mostrar para cada oficina el sueldo máximo, mínimo y medio de sus empleados
 */
public class Actividad9 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("empleadoPU");
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT e.oficina, MAX(e.sueldo), MIN(e.sueldo), AVG(e.sueldo) FROM Empleado e GROUP BY e.oficina";
        List<Objects[]> oficinas = em.createQuery(jpql).getResultList();

        if (oficinas.isEmpty()) {
            System.out.println("No hay oficinas.");
        } else {
            for (Object[] oficina : oficinas) {
                System.out.printf("Oficina: %d%n", oficina[0]);
                System.out.printf("Sueldo máximo: %.2f%n", oficina[1]);
                System.out.printf("Sueldo mínimo: %.2f%n", oficina[2]);
                System.out.printf("Sueldo medio: %.2f%n", oficina[3]);
                System.out.println();
            }
        }
    }
}
