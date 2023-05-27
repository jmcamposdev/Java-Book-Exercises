package unit15.jpa.Actividad18_Aplicacion;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import codigo.exceptions.NonexistentEntityException;


public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("PetancaPU");

        EquipoDAO eqDAO = new EquipoDAO(emf);
        JugadorDAO juDAO = new JugadorDAO(emf);

        int opc;
        do {
            menu();
            opc = new Scanner(System.in).nextInt();

            switch (opc) {
                case 1:
                    nuevoEquipo(eqDAO);
                    break;
                case 2:
                    bajaEquipo(eqDAO);
                    break;
                case 3:
                    altaJugador(juDAO);
                    break;
                case 4:
                    asignacionJugador(eqDAO, juDAO);
                    break;
                case 5:
                    mostrarEquipo(eqDAO);
                    break;
                case 6:
                    mostrarTodosEquipos(eqDAO);
                    break;
                case 7:
                    mostrarTodosJugadores(juDAO);
                    break;
            }
        } while (opc != 9);
    }

    private static void menu() {
        System.out.println("1. Nuevo equipo.");
        System.out.println("2. Baja equipo.");
        System.out.println("3. Alta de jugador.");
        System.out.println("4. Asignación de un jugador a un equipo.");
        System.out.println("5. Mostrar un equipo.");
        System.out.println("6. Mostrar todos los equipos.");
        System.out.println("7. Mostras todos los jugadores.");
        System.out.println("9. Salir.");
    }

    
    static void nuevoEquipo(EquipoDAO eqDAO) {
        System.out.println("Nombre: ");
        String nombre = new Scanner(System.in).nextLine();

        Equipo e = new Equipo(nombre); 
        try {
            eqDAO.create(e); 
        } catch (Exception ex) {
            System.out.println("Error al insertar un equipo");
        }
    }

    
    static void bajaEquipo(EquipoDAO eqDAO) {
        System.out.println("NIE a borrar:");
        Integer nie = new Scanner(System.in).nextInt();

        try {
            eqDAO.destroy(nie);
        } catch (NonexistentEntityException ex) {
            System.out.println("Error al borrar un equipo");
        }
    }

    
    static void altaJugador(JugadorDAO juDAO) {
        System.out.println("Nombre: ");
        String nombre = new Scanner(System.in).nextLine();
        System.out.println("Puntuación máxima:");
        Integer puntuacion = new Scanner(System.in).nextInt();

        Jugador j = new Jugador(nombre, puntuacion); 
        try {
            juDAO.create(j); 
        } catch (Exception ex) {
            System.out.println("Error al insertar un jugador.");
        }
    }

   
    private static void asignacionJugador(EquipoDAO eqDAO, JugadorDAO juDAO) {
        Equipo equipoActual = null, equipoDestino = null;
        Jugador jugador;

        System.out.println("NIJ del jugador:");
        Integer nij = new Scanner(System.in).nextInt();

       
        jugador = juDAO.findJugador(nij);

        if (jugador == null) {
            System.out.println("El jugador no existe.");
        } else {

            System.out.println("NIE del equipo destino del jugador:");
            Integer nie = new Scanner(System.in).nextInt();

            
            equipoDestino = eqDAO.findEquipo(nie);

            if (equipoDestino == null) {
                System.out.println("El equipo destino no existe.");
            } else {
                //vamos a comprobarel número de jugadores del equipo
                int numJugadores = equipoDestino.getJugadores().size();

                if (numJugadores == 5) {
                    System.out.println("El equipo ya tiene 5 jugadores.");
                } else {
                    
                    String jpql = "SELECT e FROM Equipo e "
                            + "WHERE :jugador MEMBER OF e.jugadores";

                    Query query = eqDAO.getEntityManager().createQuery(jpql);
                    query.setParameter("jugador", jugador);
                    List<Equipo> aux = query.getResultList();

                    
                    if (aux.size() == 1) {
                        equipoActual = aux.get(0);

                        equipoActual.quitaJugador(jugador); 
                    }

                    
                    equipoDestino.addJugador(jugador);

                   
                    try {
                        if (equipoActual != null) {
                            eqDAO.edit(equipoActual);
                        }
                        eqDAO.edit(equipoDestino);
                    } catch (Exception ex) {
                        System.out.println("Error al modificar un periodista.");
                    }
                }
            }
        }
    }

    
    private static void mostrarEquipo(EquipoDAO eqDAO) {
        System.out.println("NIE:");
        Integer nie = new Scanner(System.in).nextInt();

        Equipo e = eqDAO.findEquipo(nie);
        if (e == null) {
            System.out.println("El equipo no existe.");
        } else {
            System.out.println(e); 
            List<Jugador> lista = e.getJugadores(); 

            for (Jugador a : lista) {
                System.out.println(a);
            }
        }
    }

    
    private static void mostrarTodosEquipos(EquipoDAO eqDAO) {
       
        List<Equipo> lista = eqDAO.findEquipoEntities();

        for (Equipo e : lista) {
            System.out.println(e);
        }
    }

   
    private static void mostrarTodosJugadores(JugadorDAO juDAO) {
        
        List<Jugador> lista = juDAO.findJugadorEntities();

        for (Jugador j : lista) {
            System.out.println(j);
        }
    }
}
