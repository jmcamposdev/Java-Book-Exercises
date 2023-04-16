package unit11.Actividad27_Ampliacion;

public enum Deportes {
    NATACION ("Natación"),
    REMO ("Remo"),
    VELA ("Vela"),
    WATERPOLO ("Waterpolo");

    private String deporte;
    Deportes(String deporte) {
        this.deporte = deporte;
    }

    public String getDeporte() {
        return deporte;
    }
}
