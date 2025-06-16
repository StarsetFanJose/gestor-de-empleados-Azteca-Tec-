/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesUtilitarias;

import java.awt.Desktop;
import java.io.*;
import java.util.*;
/**
 *
 * @author josea
 */
public class ArchivoUtilReportes {
    private final String rutaGuardados = "reportesGuardados.txt"; // Creamos archivo de donde se guardan los reportes
    private final String carpetaReportes = "reportes/"; // Especificamos la ruta de los reportes XD
    
    // Guardar un reporte en el archivo .txt
    
    public void guardarReporte(String nombreReporte) throws IOException {
        File archivoGuardados = new File(rutaGuardados);
        if (!archivoGuardados.exists()) {
            archivoGuardados.createNewFile();
        }
        
        try (FileWriter fw = new FileWriter(archivoGuardados, true)) {
            fw.write(nombreReporte + "\n");
        }
    }
    
    public boolean borrarReporte(String nombreReporte)throws IOException {
        File archivoGuardados = new File(rutaGuardados);
        if (!archivoGuardados.exists()) {
            throw new FileNotFoundException("El archivo de reportes guardados no existe.");
        }
        // Leer y filtrar los reportes XD
        List<String> reportes = cargarReportesGuardados();
        boolean encontrado = reportes.remove(nombreReporte);
        
        if (encontrado) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoGuardados))) {
                for (String reporte: reportes) {
                    bw.write(reporte);
                    bw.newLine();
                }
            }
            return true; // Borrado con exito
        } else {
            throw new FileNotFoundException("El reporte especificado no se encuentra en el archivo");
        }
    }
        // Cargar los reportes desde al archivo txt
    public List<String> cargarReportesGuardados() throws IOException {
        File archivoGuardados = new File(rutaGuardados);
        List<String> reportes = new ArrayList<>();
        
        if (archivoGuardados.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivoGuardados))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    reportes.add(linea);
                }
            }
        }
        return reportes;
    }
    
    // Abrir un reporte desde la carpeta "reportes/" XD
    
    public void abrirReporte(String nombreReporte) throws IOException {
        File archivoReporte = new File(carpetaReportes + nombreReporte);
        if (archivoReporte.exists()) 
            Desktop.getDesktop().open(archivoReporte);
        else 
            throw new FileNotFoundException("El archivo del reporte no se encontro XD.");
    }
    
    
}
