/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.Random;

public class Laberinto {

    
    private int[][] laberinto;
    private final Random rnd = new Random();          

    /**
     * Genera un laberinto aleatorio de tamaño filas × columnas.
     * @param filas    número de filas  (mínimo 2)
     * @param columnas número de columnas (mínimo 2)
     * @param densidad valor entre 0 y 1 que indica la probabilidad de pared (≈ 0.30 recomendado)
     */
    public void generarLaberinto(int filas, int columnas, double densidad) {
        if (filas < 2 || columnas < 2)
            throw new IllegalArgumentException("El laberinto debe tener al menos 2×2 celdas.");

        laberinto = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                /* Asigna pared o camino según la densidad */
                laberinto[i][j] = rnd.nextDouble() < densidad ? 1 : 0;
            }
        }

       
        laberinto[0][0] = 0;                           
        laberinto[filas - 1][columnas - 1] = 0;        
    }

    
    public void imprimirLaberinto() {
        if (laberinto == null) {
            System.out.println("Aún no se ha generado el laberinto.");
            return;
        }

        for (int[] fila : laberinto) {
            for (int celda : fila) {
                System.out.print(celda == 1 ? "# " : "  ");  
            }
            System.out.println();
        }
    }
}
