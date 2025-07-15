package controller;

import java.util.Random;

public class Laberinto {

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

            
            if ((fila == 1 && columna == 0) || (fila == dimension - 2 && columna == dimension - 1)) {
                continue;
            }

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
