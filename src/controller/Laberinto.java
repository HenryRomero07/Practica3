/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Random;


public class Laberinto {
    public class Controller_laberinto {
    private char[][] matriz;
    private int dimension;
    private int porcentajeMuros;

    public Controller_laberinto(int dimension) {
        this.dimension = dimension;
        this.porcentajeMuros = new Random().nextInt(21) + 40; 
        this.matriz = new char[dimension][dimension];
        generarLaberinto();
    }

    private void generarLaberinto() {
        inicializar();
        colocarMuros();
        establecerEntradaSalida();
    }

    private void inicializar() {
        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++)
                matriz[i][j] = ' ';
    }

    private void colocarMuros() {
        Random rand = new Random();
        int total = dimension * dimension;
        int muros = total * porcentajeMuros / 100;
        int colocados = 0;

        while (colocados < muros) {
            int fila = rand.nextInt(dimension);
            int col = rand.nextInt(dimension);

            if (matriz[fila][col] == ' ' && !esEntradaOSalida(fila, col)) {
                matriz[fila][col] = '#';
                colocados++;
            }
        }
    }

    private void establecerEntradaSalida() {
        matriz[0][0] = 'E';
        matriz[dimension - 1][dimension - 1] = 'S';
    }

    private boolean esEntradaOSalida(int f, int c) {
        return (f == 0 && c == 0) || (f == dimension - 1 && c == dimension - 1);
    }

    public void regenerar() {
        generarLaberinto();
    }

    public char[][] getMatriz() {
        return matriz;
    }

    public int getDimension() {
        return dimension;
    }

    public int getPorcentajeMuros() {
        return porcentajeMuros;
    }
}
}

    
  