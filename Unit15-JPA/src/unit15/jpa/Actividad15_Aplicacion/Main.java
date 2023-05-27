package unit15.jpa.Actividad15_Aplicacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("taxistasPU");
        int opc;
        do {
            System.out.println("1. Alta nuevo taxista.");
            System.out.println("2. Alta nuevo taxi.");
            System.out.println("3. Comienzo jornada taxista.");
            System.out.println("4. Fin jornada taxista.");
            System.out.println("5. Información de un taxista y su taxi.");
            System.out.println("6. Mostrar taxistas trabajando.");
            System.out.println("7. Mostrar taxistas fuera de servicio.");
            System.out.println("9. Salir");
            opc = new Scanner(System.in).nextInt();

            switch (opc) {
                case 1 -> nuevoTaxista(emf);
                case 2 -> nuevoTaxi(emf);
                case 3 -> comienzoJornadaTaxista(emf);
                case 4 -> finJornada(emf);
                case 5 -> informacionTaxistaTaxi(emf);
                case 6 -> taxistasTrabajando(emf);
                case 7 -> taxistasFueraServicio(emf);
            }
        } while (opc != 9);

        emf.close();
    }

    
    static void nuevoTaxista(EntityManagerFactory emf) {
        TaxistaDAO dao = new TaxistaDAO(emf);

        System.out.println("DNI: ");
        String dni = new Scanner(System.in).nextLine();

       
        if (dao.findTaxista(dni) != null) {
            System.out.println("Ese taxista ya existe.");
        } else {
            
            System.out.println("Nombre: ");
            String nombre = new Scanner(System.in).nextLine();

            System.out.println("Fecha (aaaa/mm/dd): ");
            String fechaTexto = new Scanner(System.in).nextLine();

            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            Date fechaNacimiento=null;  
           try {
              fechaNacimiento = format.parse(fechaTexto);
           } catch (ParseException ex) {
              System.out.println("Formato de fecha incorrecto");
           }
            Taxista taxista = new Taxista(dni, nombre, fechaNacimiento);
            
            try {
                dao.create(taxista);
            } catch (Exception ex) {
                System.out.println("Error al insertar taxista");
            }
        }
    }

    
    static void nuevoTaxi(EntityManagerFactory emf) {
        TaxiDAO dao = new TaxiDAO(emf);

        System.out.println("Matricula: ");
        String matricula = new Scanner(System.in).nextLine();

        if (dao.findTaxi(matricula) != null) { //buscamos el taxi
            System.out.println("Ese taxi ya existe.");
        } else {
            
            System.out.println("Precio: ");
            Double precio = new Scanner(System.in).useLocale(Locale.US).nextDouble();

            System.out.println("Número de plazas: ");
            int plazas = new Scanner(System.in).nextInt();

           
            Taxi taxi = new Taxi(matricula, precio, plazas);
            try {
                dao.create(taxi);
            } catch (Exception ex) {
                System.out.println("Error al insertar taxi.");
            }
        }
    }

    
    static void informacionTaxistaTaxi(EntityManagerFactory emf) {
        TaxistaDAO dao = new TaxistaDAO(emf);

        System.out.println("Dni:");
        String dni = new Scanner(System.in).nextLine();

        Taxista taxista = dao.findTaxista(dni);

        if (taxista == null) {
            System.out.println("El taxista no existe");
        } else {
           
            Taxi taxi = taxista.getTaxi();

            //mostramos
            System.out.println(taxista);
            if (taxi != null) {
                
                System.out.println(taxi);
            } else {
               
                System.out.println("Fuera de servicio: sin taxi asignado.");
            }
        }
    }

    
    static void taxistasTrabajando(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        Query query = em.createNamedQuery("Taxista.trabajando");
        List<Taxista> trabajando = query.getResultList();

        for (Taxista t : trabajando) {
            System.out.println(t + " --> " + t.getTaxi());
        }

        em.close();
    }

    
    static void taxistasFueraServicio(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        Query query = em.createNamedQuery("Taxista.fueraServicio");
        List<Taxista> trabajando = query.getResultList();

        for (Taxista t : trabajando) {
            System.out.println(t);
        }

        em.close();
    }

    
    static void comienzoJornadaTaxista(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        TaxistaDAO taxistaDAO = new TaxistaDAO(emf);
        TaxiDAO taxiDAO = new TaxiDAO(emf);

        System.out.println("Taxistas fuera de servicio");
        taxistasFueraServicio(emf);
        
        System.out.println("DNI:");
        String dni = new Scanner(System.in).nextLine();

        Taxista taxista = taxistaDAO.findTaxista(dni);

        if (taxista == null) {
            System.out.println("Ese taxista no existe");
        } else {
            
            if (taxista.getTaxi() != null) {
                System.out.println("El taxista ya está trabajando.");
            } else {
                
                String jpql = "SELECT taxi FROM Taxi taxi WHERE taxi NOT IN ("
                        + "SELECT taxista.taxi FROM Taxista taxista WHERE taxista.taxi IS NOT NULL)";

                Query query = em.createQuery(jpql);

                List<Taxi> aparcados = query.getResultList();

                System.out.println("Taxis disponibles:");
                for (Taxi t : aparcados) {
                    System.out.println(t);
                }

                System.out.println("Matrícula:");
                String matricula = new Scanner(System.in).nextLine();
                
                Taxi taxi = taxiDAO.findTaxi(matricula);
                taxista.setTaxi(taxi); 
                try {
                    taxistaDAO.edit(taxista); 
                } catch (Exception ex) {
                    System.out.println("Error al actualizar la BD.");
                    System.out.println("Coche asignado");
                }
            }
        }
    }

    
    static void finJornada(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        TaxistaDAO taxistaDAO = new TaxistaDAO(emf);
        TaxiDAO taxiDAO = new TaxiDAO(emf);

        System.out.println("Taxistas trabajando.");
        taxistasTrabajando(emf);
        System.out.println("DNI:");
        String dni = new Scanner(System.in).nextLine();

        Taxista taxista = taxistaDAO.findTaxista(dni);

        if (taxista == null) {
            System.out.println("Ese taxista no existe");
        } else {
            //vamos a comprobar si ya está trabajando
            if (taxista.getTaxi() == null) {
                System.out.println("El taxista NO está trabajando.");
            } else {
                //Vamos a poner a nulo la relación que tiene con el taxi
                taxista.setTaxi(null);
                try {
                    taxistaDAO.edit(taxista); //actualizamos la BD
                } catch (Exception ex) {
                    System.out.println("Error al actualizar la BD.");
                }
                System.out.println("Taxista fuera de servicio");
            }
        }
    }
}
