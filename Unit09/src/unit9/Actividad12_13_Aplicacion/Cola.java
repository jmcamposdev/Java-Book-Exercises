package unit9.Actividad12_13_Aplicacion;

public interface Cola {
    void encolar(String cad);
    String desencolar();
    default void encolarMultiple(String cad, int repeticiones){
        for (int i = 0; i < repeticiones; i++) {
            encolar(cad);
        }
    }
}
