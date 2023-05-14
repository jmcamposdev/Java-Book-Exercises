package unit15.jpa.Actividad08;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/*
    Mostrar los empleados que no trabajan en la oficina 11. Ordenar la consulta por el sueldo
    de forma descendente.
 */
public class Actividad8 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("empleadoPU");
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT e FROM Empleado e WHERE e.oficina <> 11 ORDER BY e.sueldo DESC";
        Query query = em.createQuery(jpql);
        List<Empleado> empleados = query.getResultList();

        if (empleados.isEmpty()) {
            System.out.println("No hay empleados que cumplan los requisitos.");
        } else {
            empleados.forEach(System.out::println);
        }
    }
}
