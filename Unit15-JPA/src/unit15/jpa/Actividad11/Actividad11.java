package unit15.jpa.Actividad11;

import javax.persistence.*;

/*
    Eliminar a todos los empleados cuyo sueldo es negativo (algo que sin duda es un dato erróneo en la base de datos).
 */
public class Actividad11 {
    public static void main(String[] args) {
        // Creamos el gestor de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("empleadoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // Creamos la consulta
        String jpql = "DELETE FROM Empleado e WHERE e.sueldo < 0";
        Query query = em.createQuery(jpql); // No se puede usar el método createNativeQuery() porque no es una consulta SQL

        // Ejecutamos la consulta
        tx.begin();
        int eliminados = query.executeUpdate(); // Devuelve el número de registros modificados
        tx.commit();

        // Mostramos el resultado
        System.out.printf("Se han eliminado %d empleados.", eliminados);

    }
}
