package unit15.jpa.Actividad10;

import javax.persistence.*;

/*
    Asignar a todos los empleados que trabajan de comercial un sueldo de 1500 euros.
 */
public class Actividad10 {
    public static void main(String[] args) {
        // Creamos el gestor de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("empleadoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // Creamos la consulta
        String jpql = "UPDATE Empleado e SET e.sueldo = 1500 WHERE e.puesto = 'Comercial'";
        Query query = em.createQuery(jpql); // No se puede usar el método createNativeQuery() porque no es una consulta SQL

        // Ejecutamos la consulta
        tx.begin();
        int modificados = query.executeUpdate(); // Devuelve el número de registros modificados
        tx.commit();

        // Mostramos el resultado
        System.out.printf("Se han modificado %d empleados.%n", modificados);
    }
}
