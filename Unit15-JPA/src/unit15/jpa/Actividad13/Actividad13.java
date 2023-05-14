package unit15.jpa.Actividad13;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/*
    Es necesario conocer cuantos empleados desarrollan su trabajo en cada uno de los puestos disponibles
    en la empresa: comerciante, gerente, informáticos, etc, Crea una consulta con nombre
    para obtener dicha información. El informe debe tener el aspecto:
    Gerente: 3 empleados
    Comerciante: 2 empleados
    Informático: 1 empleado
 */
public class Actividad13 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("empleadoPU");
        EntityManager em = emf.createEntityManager();

        Query Query = em.createNamedQuery("Empleado.NumeroEmpleadoXPuestos");
        List<Object[]> lista = Query.getResultList();

        if (lista.isEmpty()) {
            System.out.println("No hay empleados");
        } else {
            for (Object[] o : lista) {
                System.out.printf("%s: %d empleados\n", o[0], o[1]);
            }
        }

    }
}

