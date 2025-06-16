/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author josea
 */
public class Manual {
    
    
    public void abrirManual() {
        String ruta = "Manual//Manual de Usuario Gestor de Empresa..pdf";
        try {
            File doc = new File(ruta);
            if (doc.exists()) {
                Desktop.getDesktop().open(doc);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el archivo", "ERROR: archivo NO encontrado", 0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo", "ERRRO", 0);
        }
    }
}
