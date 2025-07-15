
package Renderer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Renderer personalizado para pintar las celdas del laberinto
 */
public class LaberintoCellRenderer extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        // Obtener el componente base
        Component c = super.getTableCellRendererComponent(table, value, 
                isSelected, hasFocus, row, column);
        
        // Configurar como JLabel para poder cambiar colores
        JLabel label = (JLabel) c;
        
        // Centrar el texto
        label.setHorizontalAlignment(JLabel.CENTER);
        
        // Configurar colores según el tipo de celda
        if (value != null) {
            String contenido = value.toString();
            
            switch (contenido) {
                case "_":  // Paredes
                    label.setBackground(Color.BLACK);
                    label.setForeground(Color.BLACK);
                    label.setText("█"); // Carácter sólido
                    break;
                    
                case "E":  // Entrada
                    label.setBackground(Color.GREEN);
                    label.setForeground(Color.WHITE);
                    label.setText("E");
                    break;
                    
                case "S":  // Salida
                    label.setBackground(Color.RED);
                    label.setForeground(Color.WHITE);
                    label.setText("S");
                    break;
                    
                case " ":  // Espacios vacíos (camino)
                default:
                    label.setBackground(Color.WHITE);
                    label.setForeground(Color.BLACK);
                    label.setText(" ");
                    break;
            }
        }
        
        // Asegurar que el fondo sea opaco
        label.setOpaque(true);
        
        return label;
    }
}