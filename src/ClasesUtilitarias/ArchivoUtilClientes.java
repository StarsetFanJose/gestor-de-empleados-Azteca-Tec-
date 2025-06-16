/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesUtilitarias;

import java.io.*;
import java.util.*;

/**
 *
 * @author josea
 */
public class ArchivoUtilClientes {
    
    public static List<String[]> leerArchivo(String rutaArchivo) {
        List<String[]> listaDatos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
           String linea;
           while ((linea = br.readLine()) != null) {
               listaDatos.add(linea.split(","));
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaDatos;
    }
    
    public static void escribirArchivo(String rutaArchivo, List<String[]> datos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (String[] registro : datos) {
                bw.write(String.join(",", registro));
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
