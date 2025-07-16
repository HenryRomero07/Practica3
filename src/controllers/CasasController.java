
package controllers;

import controllers.Utiles;
import java.io.IOException;


/**
 *
 * @author HenryRomero
 */
public class CasasController {
    
    /**Guardar los Datos de una casa en un archivo con sus dimensiones y nro de pisos, ingrese 10 casas en el archivo
     * luego listelas en un arreglo y verifique cuales de ellos son Homonimas (Casas diferentes que tienen exactamente 
     * las mismas dimensiones y nro de pisos)
     */
    
    /**
     * Metodos a realizar: 
     *  - Metodo para guardar las casas
     *      > datos de entrada: nombre de casa, ancho, largo, nro de pisos
     *      > datos de salida: proporcionara los datos al archivo en Data
     * 
     *  - Metodo para listar las casas y devolver el arreglo  
     *      > datos de entrada: datos recogidos del archivo .txt en Data
     *      > datos de salida: devuelve un array con los datos recogidos del archivo data
     * 
     *  - Metodo para verificar casas Homonimas
     *      > datos de entrada: array del metodo listar()
     *      > datos de salida: valor booleano, indicando que casas son homonimas
     * 
     *  - Metodo para cargar los datos de las casas homonimas en la tabla de la vista
     *      > datos de entrada: array del metodo listar()
     */
    
    private Utiles u = new Utiles();
    String name_file = "casas.txt";

    
    
    //Metodo para guardar casas
    
    public boolean guardarCasa(String casa, Float ancho, Float largo, int nro_pisos) {
        String data = casa + "\t" + ancho  + "\t" + largo  + "\t" + nro_pisos + "\n";
        try {
            u.save(data, name_file);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    // Metodo para Listar Casas 
    
    public String[][] listarCasas() throws IOException {
        
        String[][] allData = u.listAll(name_file);
        
        return allData; 
        
    }
    
    
    //Metodo para verificar Casas Homonimas
    public String[][] verificarCasasHomonimas() throws IOException {
    String[][] matriz = u.listAll(name_file);
    // Contador de Homonimos
    int cont = 0;
    for (int i = 0; i < matriz.length; i++) {
        for (int j = i + 1; j < matriz.length; j++) {
            if (matriz[i][1].equals(matriz[j][1]) &&  // Ancho
                matriz[i][2].equals(matriz[j][2]) &&  // Largo
                matriz[i][3].equals(matriz[j][3])) {  // Nro_Pisos
                cont++;
            }
        }
    }
    
    String[][] homonimas = new String[cont][2];
    int index = 0;
    
    for (int i = 0; i < matriz.length; i++) {
        for (int j = i + 1; j < matriz.length; j++) {
            if (matriz[i][1].equals(matriz[j][1]) && 
                matriz[i][2].equals(matriz[j][2]) && 
                matriz[i][3].equals(matriz[j][3])) {
                
                homonimas[index][0] = matriz[i][0]; // Nombre casa 1
                homonimas[index][1] = matriz[j][0]; // Nombre casa 2
                index++;
            }
        }
    }
    
    return homonimas;
}
    
    
    //Metodo para obtener los datos de las casas homonimas para la tabla
public String[][] obtenerCasasHomonimasParaTabla() throws IOException {
    String[][] todasCasas = listarCasas();
    String[][] parejasHomonimas = verificarCasasHomonimas();
    
    
    String[][] resultado = new String[parejasHomonimas.length][8];
    
    for (int i = 0; i < parejasHomonimas.length; i++) {
        String nombreCasa1 = parejasHomonimas[i][0];
        String nombreCasa2 = parejasHomonimas[i][1];
        
        
        String[] datosCasa1 = buscarDatosCasa(nombreCasa1, todasCasas);
        String[] datosCasa2 = buscarDatosCasa(nombreCasa2, todasCasas);
        
        
        resultado[i][0] = datosCasa1[0]; // Nombre Casa 1
        resultado[i][1] = datosCasa1[1]; // Ancho Casa 1
        resultado[i][2] = datosCasa1[2]; // Largo Casa 1
        resultado[i][3] = datosCasa1[3]; // Pisos Casa 1
        resultado[i][4] = datosCasa2[0]; // Nombre Casa 2
        resultado[i][5] = datosCasa2[1]; // Ancho Casa 2
        resultado[i][6] = datosCasa2[2]; // Largo Casa 2
        resultado[i][7] = datosCasa2[3]; // Pisos Casa 2
    }
    
    return resultado;
}

// Metodo para buscar los datos de las casas homonimas
private String[] buscarDatosCasa(String nombreCasa, String[][] todasCasas) {
    for (String[] casa : todasCasas) {
        if (casa[0].equals(nombreCasa)) {
            return casa;
        }
    }
    return new String[]{"", "", "", ""}; 
} 
  
    
}
