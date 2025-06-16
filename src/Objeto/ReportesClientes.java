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
public class ReportesClientes {
    
    private static final String RUTA_REPORTES = "reportesGestor2//ReportesClientes/";
    
    public static void inicializarCarpeta() {
        File carpeta = new File(RUTA_REPORTES);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
    }
    
    public static boolean generarReporteGeneral(List<String[]> datos, String nombreArchivo) {
        try {
            inicializarCarpeta();
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(RUTA_REPORTES + nombreArchivo));
            documento.open();
            documento.add(new Paragraph("Reporte de Clientes General", FontFactory.getFont(FontFactory.HELVETICA_BOLD
            , 18)));
            documento.add(new Paragraph(""));
            
            PdfPTable tabla = new PdfPTable(7);
            tabla.addCell("ID");
            tabla.addCell("Apellido");
            tabla.addCell("Nombres");
            tabla.addCell("Fecha Regis.");
            tabla.addCell("Telefono");
            tabla.addCell("Correo");
            tabla.addCell("Estatus");
            
            for (String[] fila : datos) {
                tabla.addCell(fila[0]);
                tabla.addCell(fila[1]);
                tabla.addCell(fila[2]);
                tabla.addCell(fila[3]);
                tabla.addCell(fila[4]);
                tabla.addCell(fila[5]);
                tabla.addCell(fila[7]);
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
            documento.add(new Paragraph("Reporte de Clientes por Estatus:" + estatus, FontFactory.getFont(FontFactory
            .HELVETICA_BOLD, 18)));
            documento.add(new Paragraph(""));
            
            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("ID");
            tabla.addCell("Apellido");
            tabla.addCell("Nombres");
            tabla.addCell("Fecha Regis.");
            tabla.addCell("Telefono");
            tabla.addCell("Estatus");
            
            for (String[] fila : datos) {
                if (fila[7].equals(estatus)) {
                    tabla.addCell(fila[0]);
                    tabla.addCell(fila[1]);
                    tabla.addCell(fila[2]);
                    tabla.addCell(fila[3]);
                    tabla.addCell(fila[4]);
                    tabla.addCell(fila[7]);
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
    
    public static boolean generarReportePorFechaRegistro(List<String[]> datos, String fechaRegsitro, String nombreArchivo) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false); // Evita fechas invalidas XD.
            formato.parse(fechaRegsitro);
            inicializarCarpeta();
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(RUTA_REPORTES + nombreArchivo));
            documento.open();
            documento.add(new Paragraph("Reporte de Clientes por fecha de Registro: " + fechaRegsitro, 
            FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
            documento.add(new Paragraph(" "));
            
            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("ID");
            tabla.addCell("Apellido");
            tabla.addCell("Nombres");
            tabla.addCell("Fecha Registro");
            tabla.addCell("Telefono");
            tabla.addCell("Estatus");
            
            boolean hayDatos = false;
            for (String[] fila : datos) {
                if (fila[3].trim().equals(fechaRegsitro)) {
                    tabla.addCell(fila[0]);
                    tabla.addCell(fila[1]);
                    tabla.addCell(fila[2]);
                    tabla.addCell(fila[3]);
                    tabla.addCell(fila[4]);
                    tabla.addCell(fila[7]);
                    hayDatos = true;
                }
            }
            
            if (!hayDatos) {
                documento.add(new Paragraph("No se encontraronn clientes con la Fecha de Registroo ingresada: " + fechaRegsitro));
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
    
    public static String[]listaReportes() {
        inicializarCarpeta();
        File carpeta = new File(RUTA_REPORTES);
        return carpeta.list((dir, name) -> name.endsWith(".pdf"));
    }
    
    public static boolean eliminarReportes(String nombreArchivo) {
        File archivo = new File(RUTA_REPORTES + nombreArchivo);
        return archivo.exists() && archivo.delete();
    } 
}
