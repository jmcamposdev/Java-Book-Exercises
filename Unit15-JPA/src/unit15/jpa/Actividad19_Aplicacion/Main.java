package unit15.jpa.Actividad19_Aplicacion;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Main {

    
    public static void main(String[] args) {        
        List<Casa> casas;
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("HarryPotterPU");
        
        casas = cargaCasas(emf);

        
        int opc;

        do {
            opc = menu();
            switch (opc) {
                case 1 -> nuevoFan(emf, casas);
                case 2 -> nuevaCasa(emf, casas);
                case 3 -> cambiarFanCasa(emf, casas);
                case 4 -> todosFans(emf);
                case 5 -> fansXCasa(emf);
            }
        } while (opc != 9);

        emf.close();

    }

    static int menu() {
        System.out.println("1. Nuevo fan.");
        System.out.println("2. Nueva casa.");
        System.out.println("3. Cambiar fan de casa.");
        System.out.println("4. Ver todos los fans");
        System.out.println("5. Ver todos los fans de una casa");
        System.out.println("9. Salir.");

        return new Scanner(System.in).nextInt();
    }

 
    static List<Casa> cargaCasas(EntityManagerFactory emf) {
        CasaDAO dao = new CasaDAO(emf);
        
        List<Casa> aux =  dao.findCasaEntities(); //lista con todas las casas
        
        //si la lista está vacía, es señal que es la primera vez que se
        //ejecutael programa. Tendremos que crear las 4 casas principales.
        if (aux.isEmpty()) {
            aux.add(new Casa(1, "Gryffindor"));
            aux.add(new Casa(2, "Hufflepuff"));
            aux.add(new Casa(3, "Ravenclaw"));
            aux.add(new Casa(4, "Slytherin"));
            
            //tenemos que persistir las casas:
            for(Casa c: aux) {
                try {
                    dao.create(c);
                } catch (Exception ex) {
                    System.out.println("Error al crear casa.");
                }
            }   
        }
        
        return (aux);
    }
    
    
    
    static void nuevoFan(EntityManagerFactory emf, List<Casa> casas) {
        FanDAO dao = new FanDAO(emf);
        
        Fan fan;
        Casa casa;

        System.out.println("DNI:");
        String dni = new Scanner(System.in).nextLine();

        fan = dao.findFan(dni); //buscamos por si existe ya este fan

        if (fan != null) {
            System.out.println("Este fan ya existe.");
            System.out.println(fan);
        } else {
            System.out.println("Nombre:");
            String nombre = new Scanner(System.in).nextLine();

           
            
            do {
                mostrarCasas(casas);
                System.out.println("Número de casa:");
                int numero = new Scanner(System.in).nextInt();
                
                casa = buscaCasa(numero, casas);            
            } while (casa == null);

            
            fan = new Fan(dni, nombre, casa);

            try {
                dao.create(fan);
                System.out.println("Fan creado con éxito.");
            } catch (Exception ex) {
                System.out.println("Error al crear un fan.");
            }
        }
    }

   
    static void mostrarCasas(List<Casa> casas) {
        System.out.println("Estas son las casas disponibles:");
        for(Casa c: casas) {
            System.out.println(c);
        }
        System.out.println("--------------------------------");
    }
    
    
    

    static void nuevaCasa(EntityManagerFactory emf, List<Casa> casas) {
        CasaDAO dao = new CasaDAO(emf);
        Casa casa;

        System.out.println("Número de la casa:");
        Integer numCasa = new Scanner(System.in).nextInt();

        casa = buscaCasa(numCasa, casas);

        if (casa != null) {
            System.out.println("Esta casa ya existe.");
            System.out.println(casa);
        } else {
            System.out.println("Nombre:");
            String nombre = new Scanner(System.in).nextLine();
            
           
            casa = new Casa(numCasa, nombre);
            casas.add(casa);
            
            try {
                dao.create(casa);
            } catch (Exception ex) {
                System.out.println("Error al crear una casa.");
            }
        }
    }

    
    static Casa buscaCasa(int numero, List<Casa> lista) {
        Casa aux = new Casa(numero, "");
        
        int indice = lista.indexOf(aux);
        
        if (indice == -1) {
            aux = null;
        } else {
            aux = lista.get(indice);
        }
        
        return aux;
    }
    

    static void cambiarFanCasa(EntityManagerFactory emf, List<Casa> casas) {
        FanDAO dao = new FanDAO(emf);
        Casa nuevaCasa;
        
        System.out.println("DNI:");
        String dni = new Scanner(System.in).nextLine();
        
        //buscamos el fan
        Fan fan = dao.findFan(dni);
        
        if (fan == null) {
            System.out.println("No existe un fan con ese DNI.");
        } else {
            //mostramos los datos del fan
            System.out.println(fan);
            
            
            do {
                mostrarCasas(casas);
                System.out.println("Número de la nueva casa:");
                int numero = new Scanner(System.in).nextInt();
                
                nuevaCasa = buscaCasa(numero, casas);
                
            } while (nuevaCasa == null);
            
            
            fan.setCasa(nuevaCasa);
            
            try {
                
                dao.edit(fan);
            } catch (Exception ex) {
                System.out.println("Error al actualizar un fan");
            }
        }
        
    }

    static void todosFans(EntityManagerFactory emf) {
        FanDAO dao = new FanDAO(emf);

        List<Fan> todos = dao.findFanEntities();

        for (Fan e : todos) {
            System.out.println(e);
        }
    }

    private static void fansXCasa(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        
        System.out.println("Número de la casa:");
        int numeroCasa = new Scanner(System.in).nextInt();
        
        String jpql = "SELECT f FROM Fan f WHERE f.casa.numero = :num";
        Query query = em.createQuery(jpql);
        query.setParameter("num", numeroCasa);
        
        List<Fan> algunos = query.getResultList();
        
        for (Fan f: algunos) {
            System.out.println(f);
        }
    }
}
