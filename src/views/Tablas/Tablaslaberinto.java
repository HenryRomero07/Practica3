/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.Tablas;

import javax.swing.table.AbstractTableModel;



/**
 *
 * @author Usuario
 */
public class Tablaslaberinto extends AbstractTableModel{
    
    private String [][] laberintoQ;
    
   public void Tablaslaberinto(){
       
   }

    public String[][] getLaberinto() {
        return laberintoQ;
    }

    public void setLaberinto(String[][] laberintoQ) {
        this.laberintoQ = laberintoQ;
    }

    @Override
    public int getRowCount() {
        return laberintoQ.length;
        
    }

    @Override
    public int getColumnCount() {
        return laberintoQ[0].length;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return laberintoQ[rowIndex][columnIndex];
}

}
