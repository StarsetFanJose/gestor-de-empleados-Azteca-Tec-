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
public class Reportes {
    
    private static final String RUTA_REPORTES = "reportes/";
    
    // Metodo para inicializar los reportes.
    
    public static void inicializarCarpeta() {
        File carpeta = new File(RUTA_REPORTES);
        if (!carpeta.exists()) 
            carpeta.mkdirs();
    }
    
    // Metodo para generar el pdf desde el programa XD
    public static boolean generarReportaGeneral(List<String[]> datos, String nombreArchivo) {
        try {
            inicializarCarpeta();
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(RUTA_REPORTES + nombreArchivo));
            documento.open();
            //Titulo del reporte en este caso
            documento.add(new Paragraph("Reporte General de Empleadoa", FontFactory.getFont(FontFactory.HELVETICA_BOLD , 18)));
            documento.add(new Paragraph("")); // Espacio
            
            PdfPTable tabla = new PdfPTable(6); // Numero de Columnas XD
            tabla.addCell("ID");
            tabla.addCell("Apellido");
            tabla.addCell("Nombres");
            tabla.addCell("Fecha Nac.");
            tabla.addCell("Area");
            tabla.addCell("Salario");
            
            // Agregar Datos a la tabla XD
            for (String[] fila : datos) {
                tabla.addCell(fila[0]); // ID
                tabla.addCell(fila[1]); // Apellido
                tabla.addCell(fila[2]); // Nombres
                tabla.addCell(fila[3]); // Fecha de Nacimiento
                tabla.addCell(fila[9]); // Area
                tabla.addCell(fila[8]); // Salario
            }
            
            documento.add(tabla);
            documento.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean generarReporteAreas(List<String[]> datos, String area, String nombreArchhivo) {
        try {
            inicializarCarpeta();
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(RUTA_REPORTES + nombreArchhivo));
            documento.open();
            // Titulo
            documento.add(new Paragraph("Reporte de Empleados por Area: " + area, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
            documento.add(new Paragraph("")); // Espacio XD
            //Tabla
            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("ID");
            tabla.addCell("Apellido");
            tabla.addCell("Nombres");
            tabla.addCell("Fecha Nac.");
            tabla.addCell("Area");
            tabla.addCell("Salario");
            
            // Agregar datos a las columnas
            for (String[] fila : datos) {
                if (fila[9].equals(area)) {
                    tabla.addCell(fila[0]); // ID
                    tabla.addCell(fila[1]); // Apellido
                    tabla.addCell(fila[2]); // Nombres
                    tabla.addCell(fila[3]); // Fecha de Nacimiento
                    tabla.addCell(fila[9]); // Area
                    tabla.addCell(fila[8]); // Salario
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
    
    public static boolean generarReporteSalario(List<String[]> datos, double salarioMin, String nombreArchivo) {
        try {
            inicializarCarpeta();
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(RUTA_REPORTES + nombreArchivo));
            documento.open();
            // Titulo
            documento.add(new Paragraph("Reporte de Empleados con Salario >= " + salarioMin, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
            documento.add(new Paragraph(""));
            
            //Tabla
            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("ID");
            tabla.addCell("Apellido");
            tabla.addCell("Nombres");
            tabla.addCell("Fecha Nac.");
            tabla.addCell("Area");
            tabla.addCell("Salario");
            
            // Agregar datos a la tabla XD.
            for (String[] fila : datos) {
                double salario = Double.parseDouble(fila[8]); // Fila del salario.
                if (salario >= salarioMin) {
                    tabla.addCell(fila[0]); // ID
                tabla.addCell(fila[1]); // Apellido
                tabla.addCell(fila[2]); // Nombres
                tabla.addCell(fila[3]); // Fecha de Nacimiento
                tabla.addCell(fila[9]); // Area
                tabla.addCell(fila[8]); // Salario
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
            documento.add(new Paragraph("Reporte de Empleados por Estatus; " + estatus, FontFactory.getFont(FontFactory.HELVETICA_BOLD
            , 18)));
            documento.add(new Paragraph(""));
            
            PdfPTable tabla = new PdfPTable(7);
            
            tabla.addCell("ID");
            tabla.addCell("Apellido");
            tabla.addCell("Nombres");
            tabla.addCell("Fecha Nac.");
            tabla.addCell("Area");
            tabla.addCell("Estatus");
            tabla.addCell("Salario");
            
            for (String[] fila : datos) {
                if (fila[11].equals(estatus)) {
                    tabla.addCell(fila[0]);
                    tabla.addCell(fila[1]);
                    tabla.addCell(fila[2]);
                    tabla.addCell(fila[3]);
                    tabla.addCell(fila[9]);
                    tabla.addCell(fila[11]);
                    tabla.addCell(fila[8]);
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
    
    public static boolean generarReportePorTiempoTrabajo(List<String[]> datos, int tiempoTrabajoMin, String nombreArchivo) {
        try {
            inicializarCarpeta();
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(RUTA_REPORTES + nombreArchivo));
            documento.open();
            documento.add(new Paragraph("Reporte de Empleados por Tiempo de Trabajo Minimo; " + tiempoTrabajoMin + "Semanas.", 
            FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
            documento.add(new Paragraph(""));
            
            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("ID");
            tabla.addCell("Apellido");
            tabla.addCell("Nombres");
            tabla.addCell("Fecha Nac.");
            tabla.addCell("Tiempo Trabajo");
            tabla.addCell("Salario");
            
            for (String[] fila : datos) {
                int tiempoTrabajo = Integer.parseInt(fila[6]);
                
                if (tiempoTrabajo >= tiempoTrabajoMin) {
                    tabla.addCell(fila[0]);
                    tabla.addCell(fila[1]);
                    tabla.addCell(fila[2]);
                    tabla.addCell(fila[3]);
                    tabla.addCell(fila[6]);
                    tabla.addCell(fila[8]);
                }
            }
            documento.add(tabla);
            documento.close();
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean generarReportePorFechaContrato(List<String[]> datos, String fechaContrato, String nombreArchivo) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false); // Evita fechas invalidas XD
            formato.parse(fechaContrato); // Valida la fecha ingresada
            inicializarCarpeta();
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(RUTA_REPORTES + nombreArchivo));
            documento.open();
            // Encabezado (Titulo) del reporte
            documento.add(new Paragraph("Reporte de Empleados por fecha de Contrato: " + fechaContrato, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
            documento.add(new Paragraph(" "));
            // Tabla con colummnas
            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("ID");
            tabla.addCell("Apellido");
            tabla.addCell("Nombres");
            tabla.addCell("Fecha Nac.");
            tabla.addCell("Fecha Contrato");
            tabla.addCell("Salario");
            
            //Filtrar empleados por fecha de contrato y  agregarlo a la tabla XD
            boolean hayDatos = false; // Verificae si se encuntrarn empleados.
            
            for (String[] fila : datos) {
                if (fila[4].trim().equals(fechaContrato)) {
                    tabla.addCell(fila[0]);
                    tabla.addCell(fila[1]);
                    tabla.addCell(fila[2]);
                    tabla.addCell(fila[3]);
                    tabla.addCell(fila[4]);
                    tabla.addCell(fila[8]);
                    hayDatos = true;
                }
            }
            
            if (!hayDatos) {
                documento.add(new Paragraph("No se encontraron empleados con la fecha de contrato ingresada: " + fechaContrato));
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
    // Metodo para listar estos reportes XD
    public static String[]listaReportes() {
        inicializarCarpeta();
        File carpeta = new File(RUTA_REPORTES);
        return carpeta.list((dir, name) -> name.endsWith(".pdf")); //Filtra solo archivos pdf
    }
    
    // Metodo para eliminar reportes XD
    public static boolean eliminarReportes(String nombreArchivo) {
        File archivo = new File(RUTA_REPORTES + nombreArchivo);
        return archivo.exists() && archivo.delete();
    }
}


