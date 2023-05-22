package unit14.Actividad25_Ampliacion;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import unit14.Actividad15_Aplicacion.Empleado;

/**
 *
 * @author deifont
 */
public class ModeloListaEmpleados extends AbstractTableModel{
    public final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    private ArrayList<Empleado> listaEmpleados;
        private final String [] nombresColumnas = {"Nombre", "Edad", "Puesto", "Contrato"};
    
    public ModeloListaEmpleados(){
        this.listaEmpleados = new ArrayList<>();
    }
    
    public void añadirEmpleado(Empleado e){
        this.listaEmpleados.add(e);
        this.fireTableDataChanged();
    }
    public boolean eliminarEmpleado (int index) {
        boolean empleadoEliminada = false;
        if (index >= 0 && index < listaEmpleados.size()) {
            listaEmpleados.remove(index);
            empleadoEliminada = true;
        }
        return empleadoEliminada;
    }
    
    public Empleado getEmpleado(int index) {
        Empleado empleado = null;
        if (index >= 0 && index < listaEmpleados.size()) {
            empleado = new Empleado(listaEmpleados.get(index));
        }
        return empleado;
    }
    
    public void updateRow (int row) {
        this.fireTableRowsUpdated(row, row);
    }
    
    
    @Override
    public String getColumnName(int index){
        return this.nombresColumnas[index];
    }
    
    @Override
    public int getRowCount() {
        return this.listaEmpleados.size();
    }

    @Override
    public int getColumnCount() {
        return nombresColumnas.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Empleado c = listaEmpleados.get(row);
        Object value = null;
        switch(column){
            case 0 -> value = c.getNombre();
            case 1 -> value = c.getEdad();
            case 2 -> value = c.getPuesto();
            case 3 -> value = FORMATTER.format(c.getContrato());
        }
        return value;
    }
    
}
