package unit08.Actividad04;

public enum Notas {
    DO ("Do"),
    RE ("Re"),
    MI ("Mi"),
    FA ("Fa"),
    SOL ("Sol"),
    LA ("La"),
    SI ("Si");

    private final String nota;

    private Notas(String nota){
        this.nota = nota;
    }

    @Override
    public String toString() {
        return this.nota;
    }
}
