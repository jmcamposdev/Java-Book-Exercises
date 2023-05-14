package unit15.jpa.Actividad12;

/*
   Mostrar todas las oficinas disponibles. Pedir al usuario que introduzca por consola el número
   de una oficina y mostrar la información de todos los empleados que trabajan en esa oficina.
 */

import Funciones.GetData;
import unit15.jpa.Actividad08.Empleado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Actividad12 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("empleadoPU");
        EntityManager em = emf.createEntityManager();
        String query = "SELECT DISTINCT e.oficina FROM Empleado e";
        Query q = em.createQuery(query);
        List<Integer> oficinas = q.getResultList();

        int contador = 1;
        for (Integer oficina : oficinas) {
            System.out.println(contador + ". " + oficina);
            contador++;
        }

        int oficinaElegida = GetData.getInt("Elige una oficina: ", 1, oficinas.size());
        query = "SELECT e FROM Empleado e WHERE e.oficina = :oficina";

        q = em.createQuery(query);
        q.setParameter("oficina", oficinas.get(oficinaElegida - 1));
        List<Empleado> empleados = q.getResultList();

        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }

    }
}
