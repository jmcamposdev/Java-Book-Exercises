package unit15.jpa.Actividad16_Aplicacion;

import unit15.jpa.Actividad07.exceptions.NonexistentEntityException;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("institutoPU");
        int opc;
        do {
            System.out.println("1. Matrícula de alumno.");
            System.out.println("2. Baja de alumno.");
            System.out.println("3. Alta de portátil.");
            System.out.println("4. Portátil de un alumno.");
            System.out.println("5. Alumno que usa un portátil.");
            System.out.println("6. Ver todos los alumnos.");
            System.out.println("9. Salir");
            opc = new Scanner(System.in).nextInt();

            switch (opc) {
                case 1 -> matriculaAlumno(emf);
                case 2 -> bajaAlumno(emf);
                case 3 -> altaPortatil(emf);
                case 4 -> portatilXAlumno(emf);
                case 5 -> alumnoXPortatil(emf);
                case 6 -> todosAlumnos(emf);
            }
        } while (opc != 9);

        emf.close();
    }

    
    static void matriculaAlumno(EntityManagerFactory emf) {
        AlumnoDAO dao = new AlumnoDAO(emf);

        System.out.println("Número del alumno: ");
        int num = new Scanner(System.in).nextInt();

        
        if (dao.findAlumno(num) != null) {
            System.out.println("Ese alumno ya está matriculado.");
        } else {
           
            System.out.println("Nombre: ");
            String nombre = new Scanner(System.in).nextLine();

            System.out.println("Teléfono: ");
            String tlf = new Scanner(System.in).nextLine();

            Portatil portatil = portatilLibre(emf);

            
            Alumno alumno = new Alumno(num, nombre, tlf, portatil);
            try {
                dao.create(alumno);
            } catch (Exception ex) {
                System.out.println("Error al insertar el alumno.");
            }
        }
    }

    static Portatil portatilLibre(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        Portatil aux;

        String jpql = "SELECT p FROM Portatil p " + 
                      "WHERE p NOT IN (SELECT a.portatil FROM Alumno a)";
        Query query = em.createQuery(jpql);

        List<Portatil> libres = query.getResultList();

        //El siguiente do-while tiene el problema que si no existen portátiles
        //libres, se queda en un bucle infinito. Ya que la única forma de salir
        //es dando el id de un portátil libre (pero no existe).
        //NOTA: Se deja al alumno que soluciones esto.
        do {
            System.out.println("Portátiles disponibles:");
            libres.forEach(p -> {
               System.out.println(p);
           });

            System.out.println("Id del portátil:");
            int id = new Scanner(System.in).nextInt();

            aux = em.find(Portatil.class, id);
        } while (aux == null
                || (aux != null && aux.getAlumno() != null));

        return aux;
    }

    static void bajaAlumno(EntityManagerFactory emf) {
        AlumnoDAO dao = new AlumnoDAO(emf);

        System.out.println("Número del alumno: ");
        int num = new Scanner(System.in).nextInt();

       
        if (dao.findAlumno(num) == null) {
            System.out.println("Ese alumno no existe.");
        } else {

            try {
                dao.destroy(num);
            } catch (NonexistentEntityException ex) {
                System.out.println("Error al borrar el alumno.");
            }
        }
    }

   
    static void altaPortatil(EntityManagerFactory emf) {
        PortatilDAO dao = new PortatilDAO(emf);

        System.out.println("Número del portátil: ");
        int id = new Scanner(System.in).nextInt();

        
        if (dao.findPortatil(id) != null) {
            System.out.println("Este id de portátil ya está siendo usado.");
        } else {
            
            System.out.println("Marca: ");
            String marca = new Scanner(System.in).nextLine();

            System.out.println("Modelo: ");
            String modelo = new Scanner(System.in).nextLine();

            
            Portatil p = new Portatil(id, marca, modelo);
            try {
                dao.create(p);
            } catch (Exception ex) {
                System.out.println("Error al insertar un portátil.");
            }
        }
    }

    
    static void portatilXAlumno(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        AlumnoDAO dao = new AlumnoDAO(emf);

        System.out.println("Número del alumno:");
        int num = new Scanner(System.in).nextInt();

        Alumno a = dao.findAlumno(num);

        if (a == null) {
            System.out.println("El alumno no existe.");
        } else {
           
            System.out.println(a.getPortatil()); 
        }

        em.close();
    }

   
    static void alumnoXPortatil(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        PortatilDAO dao = new PortatilDAO(emf);

        System.out.println("Número identificador del portátil:");
        int id = new Scanner(System.in).nextInt();

        Portatil p = dao.findPortatil(id);

        if (p == null) {
            System.out.println("El portátil no existe.");
        } else {
            System.out.println(p.getAlumno()); 
        }

        em.close();
    }

    static void todosAlumnos(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT a FROM Alumno a";
        Query query = em.createQuery(jpql);

        List<Alumno> todos = query.getResultList();

       
       todos.forEach(a -> {
          System.out.println(a);
       });
        em.close();
    }
}
