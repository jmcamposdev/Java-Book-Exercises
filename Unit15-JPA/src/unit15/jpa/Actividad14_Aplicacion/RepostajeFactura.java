package unit15.jpa.Actividad14_Aplicacion;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class RepostajeFactura extends RepostajeNormal {
    protected String dni;
    protected String matricula;

    public RepostajeFactura(Date fechaHora, Double importe, String dni, String matricula) {
        super(fechaHora, importe);
        this.dni = dni;
        this.matricula = matricula;
    }

    public RepostajeFactura() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "RepostajeFactura{" + "id=" + id + ", fechaHora=" + fechaHora + 
               ", importe=" + importe +", dni=" + dni +", matricula=" + matricula + '}';
    }
}
