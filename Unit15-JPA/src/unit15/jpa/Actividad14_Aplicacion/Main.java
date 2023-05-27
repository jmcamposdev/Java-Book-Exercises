package unit15.jpa.Actividad14_Aplicacion;

import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {

    public static void main(String[] args) {
        int opc;
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("gasolineraPU");
        EntityManager em = emf.createEntityManager();

        do {
            opc = menu();
            switch (opc) {
                case 1 -> repostajeNormal(em);
                case 2 -> repostajeFactura(em);
                case 3 -> verTodosRepostajes(em);
                case 4 -> importeTotal(em);
                case 5 -> llenadoDeposito(em);
                case 6 -> eliminarUltimoLlenado(em);
                case 7 -> verTodosLlenados(em);
            }
        } while (opc != 0);

    }

    public static int menu() {
        System.out.println("1. Repostaje normal.");
        System.out.println("2. Repostaje factura.");
        System.out.println("3. Ver todos los repostajes.");
        System.out.println("4. Importe total combustible vendido.");
        System.out.println("5. Llenado de depósito.");
        System.out.println("6. Eliminar último llenado de depósito.");
        System.out.println("7. Ver todos los llenado de depósito.");
        System.out.println("0. Salir");

        return new Scanner(System.in).nextInt();
    }

    public static void repostajeNormal(EntityManager em) {
        //Vamos a recoger la fecha y hora actual del sistema
        Date fechaHora = Calendar.getInstance().getTime();

        System.out.println("Importe: ");
        Double importe = new Scanner(System.in).useLocale(Locale.US).nextDouble();

        EntityTransaction tx = em.getTransaction();

        RepostajeNormal r = new RepostajeNormal(fechaHora, importe);

        tx.begin();
        em.persist(r);
        tx.commit();
    }

    public static void repostajeFactura(EntityManager em) {
        //Vamos a recoger la fecha y hora actual del sistema
        Date fechaHora = Calendar.getInstance().getTime();

        System.out.println("Importe: ");
        Double importe = new Scanner(System.in).useLocale(Locale.US).nextDouble();

        System.out.println("Dni cliente:");
        String dni = new Scanner(System.in).nextLine();
        System.out.println("Matrícula vehículo:");
        String matricula = new Scanner(System.in).nextLine();

        EntityTransaction tx = em.getTransaction();

        RepostajeFactura r = new RepostajeFactura(fechaHora, importe, dni, matricula);

        tx.begin();
        em.persist(r);
        tx.commit();
    }

    public static void verTodosRepostajes(EntityManager em) {
       Query query = em.createNamedQuery("RepostajeNormal.todos");
       List<RepostajeNormal> todos = query.getResultList();
       
       for(RepostajeNormal r: todos) {
          System.out.println(r);
       }
    }
    
    public static void importeTotal(EntityManager em) {
        Query query = em.createNamedQuery("RepostajeNormal.importeTotal");
        List<Object> importeTotal = query.getResultList();

        //la lista importeTotal tendrá un único objecto
        if (!importeTotal.isEmpty()) {
            System.out.println("Importe total: " + importeTotal.get(0) + " euros");
        }

    }

    public static void llenadoDeposito(EntityManager em) {

        System.out.println("Litros: ");
        Integer litros = new Scanner(System.in).nextInt();

        System.out.println("Tipo combustible:");
        String tipo = new Scanner(System.in).nextLine();
        System.out.println("Importe combustible:");
        Double importe = new Scanner(System.in).useLocale(Locale.US).nextDouble();

        EntityTransaction tx = em.getTransaction();

        LlenadoDeposito ll = new LlenadoDeposito(litros, tipo, importe);

        tx.begin();
        em.persist(ll);
        tx.commit();
    }

    public static void eliminarUltimoLlenado(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        Query query = em.createNamedQuery("LlenadoDeposito.ultimoId");
        List<Object> ids = query.getResultList();

        //la lista importeTotal tendrá un único objecto
        if (!ids.isEmpty()) {
            int ultimoId = (Integer)ids.get(0);
            
            String jpql = "DELETE FROM LlenadoDeposito ll " +
                    "WHERE ll.id = ?1";
            query = em.createQuery(jpql);
            query.setParameter(1, ultimoId);
            tx.begin();
            query.executeUpdate();
            tx.commit();
        }
    }
    
    public static void verTodosLlenados(EntityManager em) {
        String jpql = "SELECT ll FROM LlenadoDeposito ll";
        Query query = em.createQuery(jpql);
        List<LlenadoDeposito> todos = query.getResultList();

        for(LlenadoDeposito ll: todos) {
            System.out.println(ll);
        }

    }
}
