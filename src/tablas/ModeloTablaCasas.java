
package tablas;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HenryRomero
 */
public class ModeloTablaCasas extends AbstractTableModel {
    
    String [][] matrizCasas;
    String[] columnNames = {"Nombre", "Ancho", "Largo", "Nro de Pisos"};

    public void setMatrizCasas(String[][] matrizCasas) {
        this.matrizCasas = matrizCasas;
        fireTableDataChanged();
    }

    
    @Override
    public int getRowCount() {
        return (matrizCasas == null) ? 0 : matrizCasas.length; 
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return matrizCasas[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    
    
    
}
