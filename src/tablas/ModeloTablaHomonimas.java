package tablas;

import javax.swing.table.AbstractTableModel;

public class ModeloTablaHomonimas extends AbstractTableModel {
    private String[][] datos;
    private final String[] columnNames = {"1ra Casa", "Ancho", "Largo", "Pisos" , "2da Casa", "Ancho", "Largo", "Pisos"};

    public ModeloTablaHomonimas() {
        this.datos = new String[0][7]; 
    }

    @Override
    public int getRowCount() {
        return datos.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex >= 0 && rowIndex < datos.length && 
            columnIndex >= 0 && columnIndex < columnNames.length) {
            return datos[rowIndex][columnIndex];
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void setDatos(String[][] nuevosDatos) {
        this.datos = nuevosDatos != null ? nuevosDatos : new String[0][4];
        fireTableDataChanged(); // Notificar a la tabla que los datos cambiaron
    }

    public String[] getFila(int rowIndex) {
        return datos[rowIndex];
    }
}