package tablas;

import javax.swing.table.AbstractTableModel;

public class ModeloTablaMatrizMxN extends AbstractTableModel {

    private String[][] data;
    
    public void setData(String[][] newData) {
    this.data = newData != null ? newData : new String[0][0];
    fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return (data != null) ? data.length : 0;
    }

    @Override
    public int getColumnCount() {
        return (data != null && data.length > 0) ? data[0].length : 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (data == null || rowIndex < 0 || columnIndex < 0
                || rowIndex >= data.length || columnIndex >= data[0].length) {
            return "";
        }
        return data[rowIndex][columnIndex];
    }
}
