
package controllers;

import java.util.Random;

/**
 *
 * @author HenryRomero
 */
public class LaberintoController {
    
    private final Random rnd = new Random();

    /**
     * Genera un laberinto aleatorio de tamaño dimension × dimension.
     *
     * @param dimension número de dimension
     */
    public String[][] generarLaberinto(int dimension, float porcen) {
        String[][] laberinto = new String[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                laberinto[i][j] = " ";
            }
        }
        
        
        int nroParedes = (int) ((dimension * dimension) * (porcen / 100.0f));

        int contador = 0;
        while (contador < nroParedes) {
            int fila = rnd.nextInt(dimension);
            int columna = rnd.nextInt(dimension);

            if (laberinto[fila][columna].equals(" ")) {
                laberinto[fila][columna] = "#";
                contador++;
            }
        }

        laberinto[1][0] = "E";
        laberinto[1][1] = " ";
        laberinto[dimension - 2][dimension - 1] = "S";
        laberinto[dimension - 2][dimension - 2] = " ";

        return laberinto;
    }

    public void verificarPorcentaje(String[][] laberinto, float porcenEsperado) {
        int paredes = 0;
        int total = laberinto.length * laberinto[0].length;

        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[0].length; j++) {
                if (laberinto[i][j].equals("#")) {
                    paredes++;
                }
            }
        }

        float porcentajeReal = (paredes * 100.0f) / total;

        System.out.printf("Esperado: %.2f%% - Generado: %.2f%% (%d paredes de %d celdas)\n",
                porcenEsperado, porcentajeReal, paredes, total);
    }
    
}
