/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Random;


public class Laberinto {
    private Integer[][] laberinto;
    private final Random rnd = new Random();          

    /**
     * Genera un laberinto aleatorio de tamaño dimension × dimension.
     * @param dimension    número de dimension  
     */
    public String[][] generarLaberinto(int dimension) {
        laberinto = new Integer[dimension][dimension];
        String [][] laberintonuevo = new String[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                laberinto[i][j] = rnd.nextInt(2);
            }
        }
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[0].length; j++) {
                if(laberinto [i][j] == 1){
                    laberintonuevo [i][j] = "#";
                }else{
                    laberintonuevo [i][j] = " ";
                }
                
            }
            
        }
   

        laberintonuevo[1][0] = " ";                           
        laberintonuevo[dimension - 2][dimension - 1] = " ";         
        return laberintonuevo;
    }
    
    

    
    public void imprimirLaberinto() {
        if (laberinto == null) {
            System.out.println("Aún no se ha generado el laberinto.");
            return;
        }

        for (Integer[] fila : laberinto) {
            for (Integer celda : fila) {
                System.out.print(celda == 1 ? "# " : "  ");  
            }
            System.out.println();
        }
    }

    /* --- Ejemplo de uso --- */
    public static void main(String[] args) {
        Laberinto m = new Laberinto();
        String[][]laberinto = m.generarLaberinto(15);   
               for (String[] fila : laberinto) {
            for (String celda : fila) {
                System.out.print(celda + " ");  
            }
            System.out.println();
        }
    }
}

    
  