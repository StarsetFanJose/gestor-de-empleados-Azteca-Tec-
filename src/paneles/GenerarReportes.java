/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package paneles;

import ClasesUtilitarias.ArchivoUtilEmpleados;
import Objeto.Reportes;
import java.awt.Color;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author josea
 */
public class GenerarReportes extends javax.swing.JPanel {

    /**
     * Creates new form GenerarReportes
     */
    public GenerarReportes() {
        initComponents();
        configurarComponentes();
    }
    
    private void generarReporte() {
        String tipoReporte = (String) this.cboTipoReporte.getSelectedItem();
        List<String[]> datos = ArchivoUtilEmpleados.leerArchivo("empleados.txt");
        
        switch (tipoReporte) {
            case "-- Reporte General de Empleados --":
                if (Reportes.generarReportaGeneral(datos, "ReporteGeneral.pdf")) 
                    mostrarMensajeExito("Reporte General de Empleados generado.");
                break;
            case "-- Reporte de Empleados por Area --":
                String area =(String) this.cboArea.getSelectedItem();
                
                if ("-- Selecciona un Area de Empleo --".equals(area)) {
                    mostrarMensajeError("Debe seleccionar un area.");
                    return;
                }
                
                if (Reportes.generarReporteAreas(datos, area, "ReportePorArea.pdf")) 
                    mostrarMensajeExito("Reporte de Empleados por Area generado.");
                break;
            case "-- Reporte de Empleados con Salario >= --":                
                try {
                double salarioMin = Double.parseDouble(this.txtSalario.getText());
                if (Reportes.generarReporteSalario(datos, salarioMin, "ReportePorSalario.pdf"))
                    mostrarMensajeExito("Reporte de Empleados por Salario generado.");
            } catch (NumberFormatException e) {
                mostrarMensajeError("Debe de ingresar un salario valido.");
            }
                break;
            case "-- Reporte de Empleados por Estatus --":
                String estatus = (String) this.cboEstatus.getSelectedItem();
                
                if ("-- Selecciona un Estatus --".equals(estatus)) {
                    mostrarMensajeError("Debe Seleccionar un estatus.");
                    return;
                }
                
                if (Reportes.generarReportePorEstatus(datos, estatus, "ReportePorEstatus.pdf")) 
                    mostrarMensajeExito("Reporte de Empleados por Estatus generado.");
                break;
            case "-- Reporte de Empleados por Tiempo Trabajo >= --":
                try {
                int tiempoTrabajoMin = Integer.parseInt(this.txtTiempoTrabajo.getText());
                if (Reportes.generarReportePorTiempoTrabajo(datos, tiempoTrabajoMin, "ReportePorTiempoTrabajo.pdf")) 
                    mostrarMensajeExito("Reporte de Empleados por Tiempo Trabajo generado.");
            } catch (NumberFormatException e) {
                    mostrarMensajeError("Debe de ingresar un tiempo de trabajo valido.");
            }
                break;
            case "-- Reporte de Empleados por Fecha de Contrato --":
                String fechaContrato = this.txtFechaContrato.getText();
                if (fechaContrato.isEmpty()) {
                    mostrarMensajeError("Debe ingresar una fecha de contarto.");
                    return;
                }
                
                try {
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    formato.setLenient(false);
                    Date fecha = formato.parse(this.txtFechaContrato.getText());
                } catch (ParseException e) {
                    mostrarMensajeError("La fecha de contrato tiene un formato invalido. \nFormato Correcto: dd/MM/yyyy.");
                    return; 
                }
                
                if (Reportes.generarReportePorFechaContrato(datos, fechaContrato, "ReportePorFechaContrato.pdf"))
                    mostrarMensajeExito("Reporte por Fecha de Contrato generado");
                break;
            default:
                mostrarMensajeError("Debe de Seleccionar un tipo de reporte.");
        }
    }
    
    private void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Exito", 1);
    }
    
    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "ADVERTENCIA", 2);
    }
    
    private void configurarComponentes() {
        this.cboArea.setEnabled(false);
        this.cboEstatus.setEnabled(false);
        this.txtFechaContrato.setEnabled(false);
        this.txtSalario.setEnabled(false);
        this.txtTiempoTrabajo.setEnabled(false);
    }
    
    private void actualizarComponentes() {
        String seleccion = (String) this.cboTipoReporte.getSelectedItem();
        
        switch (seleccion) {
            case "-- Reporte General de Empleados --":
                this.cboArea.setEnabled(false);
                this.cboEstatus.setEnabled(false);
                this.txtFechaContrato.setEnabled(false);
                this.txtSalario.setEnabled(false);
                this.txtTiempoTrabajo.setEnabled(false);
                this.lblinfo.setForeground(Color.black);
                this.lblinfo.setText("Reporte General no necesitas ingresar datos.");
                break;
            case "-- Reporte de Empleados por Area --":
                this.cboArea.setEnabled(true);
                this.cboArea.requestFocus();
                this.cboEstatus.setEnabled(false);
                this.txtFechaContrato.setEnabled(false);
                this.txtSalario.setEnabled(false);
                this.txtTiempoTrabajo.setEnabled(false);
                this.lblinfo.setForeground(Color.black);
                this.lblinfo.setText("Selecciona un area en especifico.");
                break;
            case "-- Reporte de Empleados con Salario >= --":
                this.txtSalario.setEnabled(true);
                this.txtSalario.requestFocus();
                this.cboArea.setEnabled(false);
                this.cboEstatus.setEnabled(false);
                this.txtFechaContrato.setEnabled(false);
                this.txtTiempoTrabajo.setEnabled(false);
                this.lblinfo.setForeground(Color.black);
                this.lblinfo.setText("Especifique el salario minimo.");
                break;
            case "-- Reporte de Empleados por Estatus --":
                this.cboEstatus.setEnabled(true);
                this.cboEstatus.requestFocus();
                this.cboArea.setEnabled(false);
                this.txtFechaContrato.setEnabled(false);
                this.txtSalario.setEnabled(false);
                this.txtTiempoTrabajo.setEnabled(false);
                this.lblinfo.setForeground(Color.black);
                this.lblinfo.setText("Seleccione un estatus en especifico");
                break;
            case "-- Reporte de Empleados por Tiempo Trabajo >= --":
                this.txtTiempoTrabajo.setEnabled(true);
                this.txtTiempoTrabajo.requestFocus();
                this.cboArea.setEnabled(false);
                this.cboEstatus.setEnabled(false);
                this.txtFechaContrato.setEnabled(false);
                this.txtSalario.setEnabled(false);
                this.lblinfo.setForeground(Color.black);
                this.lblinfo.setText("Ingrese el tiempo de trabajo min.");
                break;
            case "-- Reporte de Empleados por Fecha de Contrato --":
                this.txtFechaContrato.setEnabled(true);
                this.txtFechaContrato.requestFocus();
                this.cboArea.setEnabled(false);
                this.cboEstatus.setEnabled(false);
                this.txtSalario.setEnabled(false);
                this.txtTiempoTrabajo.setEnabled(false);
                this.lblinfo.setForeground(Color.black);
                this.lblinfo.setText("Ingrese una fecha de contrato");
                break;
            default:
                this.cboArea.setEnabled(false);
                this.cboEstatus.setEnabled(false);
                this.txtFechaContrato.setEnabled(false);
                this.txtSalario.setEnabled(false);
                this.txtTiempoTrabajo.setEnabled(false);
                this.lblinfo.setForeground(Color.red);
                this.lblinfo.setText("Elije un tipo de reporte.");
                break;
        }
    }
    
    private void limpiar() {
        this.txtSalario.setText(null);
        this.txtFechaContrato.setText(null);
        this.txtTiempoTrabajo.setText(null);
        this.cboArea.setSelectedItem("-- Selecciona un Area de Empleo --");
        this.cboEstatus.setSelectedItem("-- Selecciona un Estatus --");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboTipoReporte = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnGenerarReporte = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtFechaContrato = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        cboEstatus = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cboArea = new javax.swing.JComboBox<>();
        txtTiempoTrabajo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblinfo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/Icono Generar Reportes grande.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 10, 130, 130);

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Generar Reportes");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(170, 40, 500, 80);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 160));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel1.setText("Estatus:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 260, 110, 40);

        cboTipoReporte.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        cboTipoReporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecciona un Tipo de Reporte --", "-- Reporte General de Empleados --", "-- Reporte de Empleados por Area --", "-- Reporte de Empleados con Salario >= --", "-- Reporte de Empleados por Estatus --", "-- Reporte de Empleados por Tiempo Trabajo >= --", "-- Reporte de Empleados por Fecha de Contrato --" }));
        cboTipoReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoReporteActionPerformed(evt);
            }
        });
        jPanel2.add(cboTipoReporte);
        cboTipoReporte.setBounds(490, 20, 590, 40);

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel4.setText("Elije un tipo de reporte para generarlo.");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 20, 470, 40);

        btnGenerarReporte.setBackground(new java.awt.Color(0, 0, 102));
        btnGenerarReporte.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        btnGenerarReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/Icono Generar Reportes grande.png"))); // NOI18N
        btnGenerarReporte.setText("Generar Reporte");
        btnGenerarReporte.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnGenerarReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGenerarReporteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGenerarReporteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGenerarReporteMouseExited(evt);
            }
        });
        jPanel2.add(btnGenerarReporte);
        btnGenerarReporte.setBounds(520, 360, 520, 140);

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel5.setText("Fecha de Contrato:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(500, 80, 230, 40);

        txtFechaContrato.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jPanel2.add(txtFechaContrato);
        txtFechaContrato.setBounds(740, 80, 300, 40);

        btnLimpiar.setBackground(new java.awt.Color(0, 0, 102));
        btnLimpiar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/broom_2376996.png"))); // NOI18N
        btnLimpiar.setText("Limpiar datos");
        btnLimpiar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseExited(evt);
            }
        });
        jPanel2.add(btnLimpiar);
        btnLimpiar.setBounds(30, 390, 450, 100);

        cboEstatus.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        cboEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecciona un Estatus --", "-- Activo --", "-- Inactivo --", "-- En Capacitacion --" }));
        jPanel2.add(cboEstatus);
        cboEstatus.setBounds(110, 260, 330, 40);

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel7.setText("Salario:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 80, 140, 40);

        txtSalario.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jPanel2.add(txtSalario);
        txtSalario.setBounds(110, 80, 300, 40);

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel8.setText("Area de Empleo:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 200, 210, 40);

        cboArea.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        cboArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecciona un Area de Empleo --", "-- Marketing --", "-- Desarrollador en software --", "-- Electronica --", "-- Limpieza --", "-- Seguridad --" }));
        jPanel2.add(cboArea);
        cboArea.setBounds(210, 200, 380, 40);

        txtTiempoTrabajo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jPanel2.add(txtTiempoTrabajo);
        txtTiempoTrabajo.setBounds(210, 140, 300, 40);

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel6.setText("Tiempo Trabajo:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(10, 140, 210, 40);

        lblinfo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblinfo.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 204)));
        jPanel2.add(lblinfo);
        lblinfo.setBounds(630, 250, 370, 50);

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 1090, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarReporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarReporteMouseEntered
        this.btnGenerarReporte.setBackground(Color.green);
    }//GEN-LAST:event_btnGenerarReporteMouseEntered

    private void btnGenerarReporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarReporteMouseExited
        this.btnGenerarReporte.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_btnGenerarReporteMouseExited

    private void btnGenerarReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarReporteMouseClicked
        generarReporte();
    }//GEN-LAST:event_btnGenerarReporteMouseClicked

    private void btnLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseEntered
        this.btnLimpiar.setBackground(Color.red);
    }//GEN-LAST:event_btnLimpiarMouseEntered

    private void btnLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseExited
        this.btnLimpiar.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_btnLimpiarMouseExited

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        limpiar();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void cboTipoReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoReporteActionPerformed
        actualizarComponentes();
    }//GEN-LAST:event_cboTipoReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cboArea;
    private javax.swing.JComboBox<String> cboEstatus;
    private javax.swing.JComboBox<String> cboTipoReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblinfo;
    private javax.swing.JTextField txtFechaContrato;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtTiempoTrabajo;
    // End of variables declaration//GEN-END:variables
}
