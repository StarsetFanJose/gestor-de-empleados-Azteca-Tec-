/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesUtilitarias;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josea
 */
public class ArchivoUtilReportesActividades {
    private final String rutaGuardados = "reportesGuardadosGestor2//reportesActividadesGuardados.txt";
    private final String carpetaReportes = "reportesGestor2//ReportesActividades/";
    
    public void guardarReporte(String nombreReporte)throws IOException {
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
            throw new FileNotFoundException("El archivo de reportes cliente no existe.");
        }
        
        List<String> reportes = cargarReportesGuardados();
        boolean encontrado = reportes.remove(nombreReporte);
        
        if (encontrado) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoGuardados))) {
                for (String reporte : reportes) {
                    bw.write(reporte);
                    bw.newLine();
                }
            }
            return true;
        } else {
            throw new FileNotFoundException("El reporte especificado no se encunetra en el archivo");
        }
    }
    
    public List<String> cargarReportesGuardados()throws IOException {
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
    
    public void abrirReporte(String nombreReporte)throws IOException {
        File archivoReportes = new File(carpetaReportes + nombreReporte);
        if (archivoReportes.exists()) {
            Desktop.getDesktop().open(archivoReportes);
        } else {
            throw new FileNotFoundException("El archivo del reporte no se encontro");
        }
    }
}
