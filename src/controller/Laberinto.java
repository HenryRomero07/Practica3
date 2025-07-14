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
     * Genera un laberinto aleatorio de tamaño filas × columnas.
     * @param filas    número de filas  (mínimo 2)
     * @param columnas número de columnas (mínimo 2)
     */
    public String[][] generarLaberinto(Integer filas, Integer columnas) {

        laberinto = new Integer[filas][columnas];
        String [][] laberintonuevo = new String[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
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
        laberintonuevo[filas - 2][columnas - 1] = " ";         
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
        String[][]laberinto = m.generarLaberinto(25, 25);   
               for (String[] fila : laberinto) {
            for (String celda : fila) {
                System.out.print(celda + " ");  
            }
            System.out.println();
        }
    }
}

    
  