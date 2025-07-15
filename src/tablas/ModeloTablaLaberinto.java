/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablas;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class ModeloTablaLaberinto extends AbstractTableModel{
    
    private String [][] laberintoQ;
    
   public ModeloTablaLaberinto(){
       
   }

    public String[][] getLaberinto() {
        return laberintoQ;
        
    }

    public void setLaberinto(String[][] laberintoQ) {
        this.laberintoQ = laberintoQ;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return laberintoQ.length;
        
    }

    @Override
    public int getColumnCount() {
        return laberintoQ != null && laberintoQ.length > 0 ? laberintoQ[0].length : 0;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return laberintoQ[rowIndex][columnIndex];
}

}
    