
package controller;

import java.util.Random;
import javax.swing.JOptionPane;
import views.Tablas.Tablaslaberinto;


public class Laberinto {
    
    private Integer[][] laberinto;
    
    private final Random rnd = new Random();          

    /**
     * Genera un laberinto aleatorio de tamaño dimension × dimension.
     * @param dimension    número de dimension  
     */
    public String[][] generarLaberinto(int dimension, int porcen) {
        laberinto = new Integer[dimension][dimension];
        String [][] laberintonuevo = new String[dimension][dimension];
        int cont = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                laberinto[i][j] = rnd.nextInt(2);
                //contador de unos y ceros
                if (laberinto[i][j] == 1) {
                    cont++;
                }else 
                    continue;
                
            }
        }
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[0].length; j++) {
                if(laberinto [i][j] == 1){
                    laberintonuevo [i][j] = "#";
                    
                }else {
                    laberintonuevo [i][j] = " ";
                }
                
            }
            
        }
   

        laberintonuevo[1][0] = "E";                           
        laberintonuevo[dimension - 2][dimension - 1] = "S"; 

        if(verificacionPorcentaje(laberintonuevo, porcen)){
        return laberintonuevo;
        }else 
        return null;
    }
    
    public Boolean verificacionPorcentaje(String[][] matriz, int porcen){
        Boolean estado = false; 
        int cont = 0;
        
        for (String[] strings : matriz) {
            for (String string : strings) {
                if ("1".equals(string)) {
                    cont++;
                }
            }
        }
        
        int porcentaje ;
        porcen = porcen /100;
        porcentaje = (matriz.length * matriz.length) * porcen;
        
        if(porcentaje == cont){
            estado = true;
        }
            
        return estado;
    }
    
    
  
   

    
    

    /* --- Ejemplo de uso --- */
//    public static void main(String[] args) {
//        Laberinto m = new Laberinto();
//        String[][]laberinto = m.generarLaberinto(15);   
//               for (String[] fila : laberinto) {
//            for (String celda : fila) {
//                System.out.print(celda + " ");  
//            }
//            System.out.println();
//        }
//               Tablaslaberinto mt = new Tablaslaberinto();
//               mt.setLaberinto(m.generarLaberinto(5));
//               String[][] nuevaMatriz = m.generarLaberinto(10);
//               System.out.println("Columnas de la nueva matriz: " + nuevaMatriz[0].length);
//
//    }
}

    
  