
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
                laberinto[fila][columna] = "_";
                contador++;
            }
        }
        generarCamino(laberinto, dimension);

        laberinto[1][0] = "E";
        laberinto[1][1] = " ";
        laberinto[dimension - 2][dimension - 1] = "S";
        laberinto[dimension - 2][dimension - 2] = " ";

        return laberinto;
    }
    
    
    
    //metodo para generar un camino 
private void generarCamino(String[][] laberinto, int dimension) {
    int filaActual = 1;
    int columnaActual = 0;
    int filaFinal = dimension - 2;
    int columnaFinal = dimension - 1;
    
    
    laberinto[filaActual][columnaActual] = " ";
    
    while (filaActual != filaFinal || columnaActual != columnaFinal) {
        boolean moverFila = rnd.nextBoolean();
        
        if (moverFila && filaActual != filaFinal) {
            
            
            if (filaActual < filaFinal) {
                filaActual++;
            } else {
                filaActual--;
            }
        } else if (columnaActual != columnaFinal) {
            
            
            if (columnaActual < columnaFinal) {
                columnaActual++;
            } else {
                columnaActual--;
            }
        } else {
            
            if (filaActual < filaFinal) {
                filaActual++;
            } else {
                filaActual--;
            }
        }
        
        
        laberinto[filaActual][columnaActual] = " ";
    }
}    
}
