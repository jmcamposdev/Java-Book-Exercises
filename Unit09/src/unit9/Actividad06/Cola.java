package unit9.Actividad06;

/*
    Implementar, en la interfaz Cola el método encolarMultiple(Integer nuevo, int repeticiones) que encole un mismo elemento varias veces seguidas
 */
public interface Cola {
    void encolar(Integer num);
    Integer desencolar();
    default void encolarMultiple(Integer nuevo, int repeticiones){
        for (int i = 0; i < repeticiones; i++) {
            encolar(nuevo);
        }
    }
}
