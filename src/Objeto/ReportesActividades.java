/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objeto;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author josea
 */
public class ReportesActividades {
    
    private static final String RUTA_REPORTES = "reportesGestor2//ReportesActividades/";
    
    public static void inicializarCarpeta() {
        File carpeta = new File(RUTA_REPORTES);
        if (!carpeta.exists()) 
            carpeta.mkdirs();
    }
    
    public static boolean generarReporteGeneral(List<String[]> datos, String nombreArchivo) {
        try {
            inicializarCarpeta();
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(RUTA_REPORTES + nombreArchivo));
            documento.open();
            documento.add(new Paragraph("Reporte de Actividades general", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
            documento.add(new Paragraph(""));
            
            PdfPTable tabla = new PdfPTable(7);
            tabla.addCell("Num. Act");
            tabla.addCell("Nombre Act");
            tabla.addCell("Fecha I.");
            tabla.addCell("Fecha F.");
            tabla.addCell("Estatus");
            tabla.addCell("Area Corres.");
            tabla.addCell("Puesto Corres.");
            
            for (String[] fila : datos) {
                tabla.addCell(fila[0]);
                tabla.addCell(fila[1]);
                tabla.addCell(fila[2]);
                tabla.addCell(fila[3]);
                tabla.addCell(fila[4]);
                tabla.addCell(fila[13]);
                tabla.addCell(fila[14]);
            }
            
            documento.add(tabla);
            documento.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean generarReportePorNumeroDeActividad(List<String[]>  datos, int numActMin, String nombreArchivo) {
        try {
            inicializarCarpeta();
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(RUTA_REPORTES + nombreArchivo));
            documento.open();
            documento.add(new Paragraph("Reporte de Actividades por un numero de actividad incial: " + "Desde la actividad numero:" + numActMin, 
            FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
            documento.add(new Paragraph(""));
            
            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("Num. Act");
            tabla.addCell("Nombre Act");
            tabla.addCell("Fechia I.");
            tabla.addCell("Fecha F.");
            tabla.addCell("Apellido Cliente");
            tabla.addCell("Area Corres.");
            
            for (String[] fila : datos) {
                int numAct = Integer.parseInt(fila[0]);
                
                if (numAct >= numActMin) {
                    tabla.addCell(fila[0]);
                    tabla.addCell(fila[1]);
                    tabla.addCell(fila[2]);
                    tabla.addCell(fila[3]);
                    tabla.addCell(fila[6]);
                    tabla.addCell(fila[13]);
                }
            }
            
            documento.add(tabla);
            documento.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean generarReportePorEstatus(List<String[]> datos, String estatus, String nombreArchivo) {
        try {
            inicializarCarpeta();
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(RUTA_REPORTES + nombreArchivo));
            documento.open();
            documento.add(new Paragraph("Reporte de Actividades por estatus: " + estatus, FontFactory.getFont(FontFactory.HELVETICA_BOLD,
                    18)));
            documento.add(new Paragraph(""));
            
            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("Num de Act");
            tabla.addCell("Nombre Act");
            tabla.addCell("Fecha I.");
            tabla.addCell("Fecha F.");
            tabla.addCell("Estatus");
            tabla.addCell("Area Corres.");
            
            for (String[] fila : datos) {
                if (fila[4].equals(estatus)) {
                    tabla.addCell(fila[0]);
                    tabla.addCell(fila[1]);
                    tabla.addCell(fila[2]);
                    tabla.addCell(fila[3]);
                    tabla.addCell(fila[4]);
                    tabla.addCell(fila[13]);
                }
            }
            
            documento.add(tabla);
            documento.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean generarReportePorFechaInicio(List<String[]> datos, String fechaInicio, String nombreArchivo) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false);
            formato.parse(fechaInicio);
            inicializarCarpeta();
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(RUTA_REPORTES + nombreArchivo));
            documento.open();
            documento.add(new Paragraph("Reporte de Actividades por Fecha Inicio: " + fechaInicio, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18l)));
            documento.add(new Paragraph(" "));
            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("Num. Act");
            tabla.addCell("Nombre Act");
            tabla.addCell("Fecha Inicio");
            tabla.addCell("Estatus");
            tabla.addCell("Area Corres.");
            tabla.addCell("Puesto Corres.");
            
            boolean hayDatos = false;
            for (String[] fila : datos) {
                if (fila[2].trim().equals(fechaInicio)) {
                    tabla.addCell(fila[0]);
                    tabla.addCell(fila[1]);
                    tabla.addCell(fila[2]);
                    tabla.addCell(fila[4]);
                    tabla.addCell(fila[13]);
                    tabla.addCell(fila[14]);
                    hayDatos = true;
                }
            }
            
            if (!hayDatos) {
                documento.add(new Paragraph("No se encontrarron actividades con la fecha de Inicio ingresda: " + fechaInicio));
            } else {
                documento.add(tabla);
            }
            documento.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean generarReportePorFechaFin(List<String[]> datos, String fechaFin, String nombreArchivo) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false);
            formato.parse(fechaFin);
            inicializarCarpeta();
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(RUTA_REPORTES + nombreArchivo));
            documento.open();
            documento.add(new Paragraph("Reporte de Actividades por Fecha Aprox. de Fin: " + fechaFin, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18l)));
            documento.add(new Paragraph(" "));
            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("Num. Act");
            tabla.addCell("Nombre Act");
            tabla.addCell("Fecha Aprox. Fin");
            tabla.addCell("Estatus");
            tabla.addCell("Area Corres.");
            tabla.addCell("Puesto Corres.");
            
            boolean hayDatos = false;
            for (String[] fila : datos) {
                if (fila[3].trim().equals(fechaFin)) {
                    tabla.addCell(fila[0]);
                    tabla.addCell(fila[1]);
                    tabla.addCell(fila[3]);
                    tabla.addCell(fila[4]);
                    tabla.addCell(fila[13]);
                    tabla.addCell(fila[14]);
                    hayDatos = true;
                }
            }
            
            if (!hayDatos) {
                documento.add(new Paragraph("No se encontrarron actividades con la fecha de Inicio ingresda: " + fechaFin));
            } else {
                documento.add(tabla);
            }
            documento.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean generarReportePorArea(List<String[]> datos, String area, String nombreArchivo) {
        try {
            inicializarCarpeta();
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(RUTA_REPORTES + nombreArchivo));
            documento.open();
            documento.add(new Paragraph("Reporte de Actividades por Area Correspondiente: " + area, 
            FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
            documento.add(new Paragraph(""));
            
            PdfPTable tabla = new PdfPTable(7);
            tabla.addCell("Num. Act");
            tabla.addCell("Nombre Act");
            tabla.addCell("Fecha I.");
            tabla.addCell("Fecha F.");
            tabla.addCell("Estatus");
            tabla.addCell("Area Corres.");
            tabla.addCell("Puesto Corres.");
            
            for (String[] fila : datos) {
                if (fila[13].equals(area)) {
                    tabla.addCell(fila[0]);
                    tabla.addCell(fila[1]);
                    tabla.addCell(fila[2]);
                    tabla.addCell(fila[3]);
                    tabla.addCell(fila[4]);
                    tabla.addCell(fila[13]);
                    tabla.addCell(fila[14]);
                }
            }
            
            documento.add(tabla);
            documento.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static String[]listaReportes() {
        inicializarCarpeta();
        File carpeta = new File(RUTA_REPORTES);
        return carpeta.list((dir, name) -> name.endsWith(".pdf"));
    }
    
    public static boolean eliminarReporte(String nombreArchivo) {
        File archivo = new File(RUTA_REPORTES + nombreArchivo);
        return archivo.exists() && archivo.delete();
    }
    
}
