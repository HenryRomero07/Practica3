package controllers;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author HenryRomero
 */
public class MatrizController {

    /**
     * Solicitar al usuario: (a) Ingresar dos numeros enteros para contruir una
     * matriz de cualquier longitud (MxN) (b) Presentar el arreglo creado al
     * usuario en una ventana con tablas (c) Que operacion desea realizar sobre
     * la matriz: - Eliminar cualquier número que ingrese el usuario o eliminar
     * los que son primos. - Actualizar tabla despues de cada operacion. -
     * cuando se elimine un dato se debera actualizar con un - o * o cualquier
     * caracter.
     */
    /**
     * Metodos a utilizar: 
     *      Metodo para contruir una matriz de MxN dimensiones: 
     *          - Datos de entrada: m (filas) y n (columnas) - datos de salida: Matriz generada de MxN dimensiones
     *
     *      Metodo para reemplazar el numero elegido por el usuario:
     *          - Datos de entrada: matriz generada por el metodo para contruir
     *          - Datos de salida: matriz con el numero elegido por el usuario reemplazados por un -
     * 
     *      Metodo para reemplazar los numeros primos que se encuentran en la matriz:
     *          - Datos de entrada: matriz generada por el metodo para contruir
     *          - Datos de salida: matriz con los numeros primos reemplazados por un *
     */
    
    private String[][] matriz;

    public void setMatriz(String[][] matriz) {
        this.matriz = matriz;
    }

    public String[][] getMatriz() {
        return this.matriz;
    }

    private Random ra = new Random();

    //metodo para generar la matriz de M x N dimensiones
    public String[][] generarMatrizMxN(String Mrows, String Ncolumns) {

        String[][] matrizMxN = null;
        Integer rowM = Integer.parseInt(Mrows);
        Integer columnsM = Integer.parseInt(Ncolumns);

        String[][] matriz = new String[rowM][columnsM];
        Integer random;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {

                random = ra.nextInt(21);
                matriz[i][j] = random.toString();

            }
        }

        matrizMxN = matriz;

        return matrizMxN;
    }

    //Metodo para reemplazar el elemento de la matriz elegido por el usuario 
    public String[][] matrizNum(String[][] matriz, String num) {
        String[][] matrizNueva = null;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (!matriz[i][j].equals(num)) {
                } else {
                    matriz[i][j] = "-";
                }

            }
        }

        matrizNueva = matriz;

        return matrizNueva;
    }

    //Metodo para reemplazar numeros primos del 1 al 20 
    public String[][] matrizNumPrimo(String[][] matrizE) {
        String[][] matrizPrimos = null;

        Integer[] numsprimos = {2, 3, 5, 7, 11, 13, 17, 19};

        for (int i = 0; i < matrizE.length; i++) {
            for (int j = 0; j < matrizE[0].length; j++) {

                for (Integer numsprimo : numsprimos) {
                    if (matrizE[i][j].equals(numsprimo.toString())) {
                        matrizE[i][j] = "*";
                    }
                }

            }
        }

        matrizPrimos = matrizE;

        return matrizPrimos;
    }

}
