/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package paneles;

import ClasesUtilitarias.ArchivoUtilReportes;
import Objeto.Reportes;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.io.IOException;

/**
 *
 * @author josea
 */
public class ListaReportes extends javax.swing.JPanel {
    
    private ArchivoUtilReportes archivoUtilReportes = new ArchivoUtilReportes();
    
    /**
     * Creates new form ListaReportes
     */
    public ListaReportes() {
        initComponents();
        cargarReportes();
        
    }
    
    private void cargarReportes() {
        String[] reportes = Reportes.listaReportes();
        DefaultListModel<String> modelo = new DefaultListModel<>();
        
        for (String reporte : reportes) {
            modelo.addElement(reporte);
        }
        
        this.listaReportes.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaReportes = new javax.swing.JList<>();
        btnGuardar = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lista de Reportes Creados.");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(160, 20, 720, 100);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/survey_9104313.png"))); // NOI18N
        jLabel2.setText("jLabel1");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 10, 130, 120);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 140));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Reportes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 18), new java.awt.Color(0, 0, 255))); // NOI18N

        listaReportes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jScrollPane2.setViewportView(listaReportes);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(40, 20, 510, 480);

        btnGuardar.setBackground(new java.awt.Color(0, 0, 102));
        btnGuardar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/pdf_5200128.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });
        jPanel2.add(btnGuardar);
        btnGuardar.setBounds(630, 170, 310, 80);

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1090, 530));
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        this.btnGuardar.setBackground(Color.green);
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        this.btnGuardar.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        String reporteSeleccionado = this.listaReportes.getSelectedValue();
        
        if (reporteSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Seleccione un reporte para guardar.", "ADVERTENCIA", 2);
            return;
        }
        
        try {
            archivoUtilReportes.guardarReporte(reporteSeleccionado);
            JOptionPane.showMessageDialog(null, "Reporte guardado correctamente.", "Exito", 1);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el reporte.", "ERROR", 0);
        }
    }//GEN-LAST:event_btnGuardarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaReportes;
    // End of variables declaration//GEN-END:variables
}
