/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package subpanelesmenu;

import javax.swing.JOptionPane;
import java.util.List;
import ClasesUtilitarias.*;
import Objeto.ReportesActividades;
import java.awt.Color;
import java.text.SimpleDateFormat;

/**
 *
 * @author josea
 */
public class ActividadesReportes extends javax.swing.JPanel {

    /**
     * Creates new form ActividadesReportes
     */
    public ActividadesReportes() {
        initComponents();
        configurarComponentes();
    }
    
    private void configurarComponentes() {
        this.txtNumAct.setEnabled(false);
        this.txtFechaInicio.setEnabled(false);
        this.txtFechaFin.setEnabled(false);
        this.cboEstatus.setEnabled(false);
        this.cboArea.setEnabled(false);
    }
    
    private void generarReportes() {
        String tipoReporte = (String) this.cboTipoReporte.getSelectedItem();
        List<String[]> datos = ArchivoUtilActividades.leerArchivo("actividades.txt");
        
        switch (tipoReporte) {
            case "-- Reporte General de Actividades --":
                if (ReportesActividades.generarReporteGeneral(datos, "ReporteGeneralAct.pdf")) 
                    mostrarMensajeExito("Reporte de Actividades general generado.");
                break;
            case "-- Reporte de Actividades por Numero de Actividad inicial --":
                try {
                int numActInicial = Integer.parseInt(this.txtNumAct.getText());
                if (ReportesActividades.generarReportePorNumeroDeActividad(datos, numActInicial, "ReporteNumActividadInicial.pdf")) 
                    mostrarMensajeExito("Reporte de Actividades por un Numero Inicial generado");
            } catch (NumberFormatException e) {
                     mostrarMensajeError("Debe de ingresar un numero de Actividad valido.");
            }
                break;
            case "-- Reporte de Actividades por Estatus --":
                String estatus = (String) this.cboEstatus.getSelectedItem();
                if ("-- Selecciona un Estatus --".equals(estatus)) {
                    mostrarMensajeError("Debe seleccionar un Estatus de Actividad.");
                    return;
                }
                
                if (ReportesActividades.generarReportePorEstatus(datos, estatus, "ReportePorEstatus.pdf")) 
                    mostrarMensajeExito("Reporte de Actividades por Estatus generado.");
                break;
            case "-- Reporte de Actividades por Fecha de Inicio --":
                String fechaInicio = this.txtFechaInicio.getText();
                if (fechaInicio.isEmpty()) {
                    mostrarMensajeError("Ingresa una fecha de inicio.");
                    return; 
                }
                
                if (!validarFecha(this.txtFechaInicio.getText())) {
                    return; 
                }
                
                if (ReportesActividades.generarReportePorFechaInicio(datos, fechaInicio, "ReportePorFechaInicio.pdf")) 
                    mostrarMensajeExito("Reporte de Actividades por Fecha de Inicio generado.");
                break;
            case "-- Reporte de Actividades por Fecha Aprox. de Fin --":
                String fechaFin = this.txtFechaFin.getText();
                if (fechaFin.isEmpty()) {
                    mostrarMensajeError("Ingresa una fecha Aprox. de fin.");
                    return; 
                }
                
                if (!validarFechaFin(this.txtFechaFin.getText())) {
                    return; 
                }
                
                if (ReportesActividades.generarReportePorFechaFin(datos, fechaFin, "ReportePorFechaFin.pdf")) 
                    mostrarMensajeExito("Reporte de Actividades por Fecha Aprox. de Fin generado.");
                break;
            case "-- Reporte de Actividades por Area de Empleo Corres. --":
                String area = (String) this.cboArea.getSelectedItem();
                
                if ("-- Selecciona un Area de Empleo --".equals(area)) {
                    mostrarMensajeError("Selecciona un Area de Empleo Especifico.");
                    return; 
                }
                
                if (ReportesActividades.generarReportePorArea(datos, area, "ReportePorAreaEmpleo.pdf"))
                    mostrarMensajeExito("Reporte de Actividades por Area de Empleo Correspondiente generado.");
                break;
            default:
                mostrarMensajeError("Selecciona un tipo de reporte por favor.");
        }
    }
    
    private void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Exito", 1);
    }
    
    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "ADVERTENCIA", 2);
    }
    
    private void actualizarComponentes() {
        String seleccion =(String) this.cboTipoReporte.getSelectedItem();
        
        switch (seleccion) {
            case "-- Reporte General de Actividades --":
                this.txtNumAct.setEnabled(false);
                this.cboEstatus.setEnabled(false);
                this.txtFechaInicio.setEnabled(false);
                this.txtFechaFin.setEnabled(false);
                this.cboArea.setEnabled(false);
                this.lblInfo.setForeground(Color.black);
                this.lblInfo.setText("Reporte General no necesitas llenar datos.");
                break;
            case "-- Reporte de Actividades por Numero de Actividad inicial --":
                this.txtNumAct.setEnabled(true);
                this.cboEstatus.setEnabled(false);
                this.txtFechaInicio.setEnabled(false);
                this.txtFechaFin.setEnabled(false);
                this.cboArea.setEnabled(false);
                this.lblInfo.setForeground(Color.black);
                this.lblInfo.setText("Ingresa un numero de Actividad Inicial.");
                break;
            case "-- Reporte de Actividades por Estatus --":
                this.txtNumAct.setEnabled(false);
                this.cboEstatus.setEnabled(true);
                this.txtFechaInicio.setEnabled(false);
                this.txtFechaFin.setEnabled(false);
                this.cboArea.setEnabled(false);
                this.lblInfo.setForeground(Color.black);
                this.lblInfo.setText("Selecciona el Estatus en especifico.");
                break;
            case "-- Reporte de Actividades por Fecha de Inicio --":
                this.txtNumAct.setEnabled(false);
                this.cboEstatus.setEnabled(false);
                this.txtFechaInicio.setEnabled(true);
                this.txtFechaFin.setEnabled(false);
                this.cboArea.setEnabled(false);
                this.lblInfo.setForeground(Color.black);
                this.lblInfo.setText("Ingresa una fecha de inicio en especifico.");
                break;
            case "-- Reporte de Actividades por Fecha Aprox. de Fin --":
                this.txtNumAct.setEnabled(false);
                this.cboEstatus.setEnabled(false);
                this.txtFechaInicio.setEnabled(false);
                this.txtFechaFin.setEnabled(true);
                this.cboArea.setEnabled(false);
                this.lblInfo.setForeground(Color.black);
                this.lblInfo.setText("Ingresa una Fecha Aprox. de Fin en especifico.");
                break;
            case "-- Reporte de Actividades por Area de Empleo Corres. --":
                this.txtNumAct.setEnabled(true);
                this.cboEstatus.setEnabled(false);
                this.txtFechaInicio.setEnabled(false);
                this.txtFechaFin.setEnabled(false);
                this.cboArea.setEnabled(true);
                this.lblInfo.setForeground(Color.black);
                this.lblInfo.setText("Selecciona un Area de Empleo en especifico.");
                break;
            default:
                this.txtNumAct.setEnabled(false);
                this.cboEstatus.setEnabled(false);
                this.txtFechaInicio.setEnabled(false);
                this.txtFechaFin.setEnabled(false);
                this.cboArea.setEnabled(false);
                this.lblInfo.setForeground(Color.red);
                this.lblInfo.setText("Elije un Tipo de Reporte.");
                break;
        }
    }
    
    private void limpiar() {
        this.txtNumAct.setText(null);
        this.cboTipoReporte.setSelectedItem("-- Selecciona un Tipo de Reporte --");
        this.cboEstatus.setSelectedItem("-- Selecciona un Estatus --");
        this.txtFechaInicio.setText(null);
        this.txtFechaFin.setText(null);
        this.cboArea.setSelectedItem("-- Selecciona un Area de Empleo --");
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
        jLabel3 = new javax.swing.JLabel();
        cboEstatus = new javax.swing.JComboBox<>();
        cboTipoReporte = new javax.swing.JComboBox<>();
        btnLimpiar = new javax.swing.JButton();
        btnGenerar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFechaFin = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cboArea = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtNumAct = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFechaInicio = new javax.swing.JTextField();
        lblInfo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/reportes actividades.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 80, 70);

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reportes de Actividades.");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(110, 30, 330, 40);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 90));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        jLabel3.setText("Selecciona un Tipo de Reporte en el Combo Box para generarlo:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 10, 650, 40);

        cboEstatus.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        cboEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecciona un Estatus --", "-- Planificacion --", "-- En Ejecucion --", "-- Pausada --", "-- Completada --", "-- Cancelada --", "-- En Revision --" }));
        jPanel2.add(cboEstatus);
        cboEstatus.setBounds(280, 100, 290, 30);

        cboTipoReporte.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        cboTipoReporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecciona un Tipo de Reporte --", "-- Reporte General de Actividades --", "-- Reporte de Actividades por Numero de Actividad inicial --", "-- Reporte de Actividades por Estatus --", "-- Reporte de Actividades por Fecha de Inicio --", "-- Reporte de Actividades por Fecha Aprox. de Fin --", "-- Reporte de Actividades por Area de Empleo Corres. --" }));
        cboTipoReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoReporteActionPerformed(evt);
            }
        });
        jPanel2.add(cboTipoReporte);
        cboTipoReporte.setBounds(660, 10, 420, 40);

        btnLimpiar.setBackground(new java.awt.Color(0, 0, 153));
        btnLimpiar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/broom_2376996.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLimpiarMousePressed(evt);
            }
        });
        jPanel2.add(btnLimpiar);
        btnLimpiar.setBounds(470, 290, 330, 90);

        btnGenerar.setBackground(new java.awt.Color(0, 0, 153));
        btnGenerar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        btnGenerar.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerar.setText("Generar");
        btnGenerar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnGenerar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGenerarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGenerarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGenerarMouseExited(evt);
            }
        });
        jPanel2.add(btnGenerar);
        btnGenerar.setBounds(120, 290, 330, 90);

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel4.setText("Ingresa la Fecha Aprox. de Fin:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 180, 230, 30);

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setText("Selecciona el Area de Empleo:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 220, 230, 30);

        txtFechaFin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jPanel2.add(txtFechaFin);
        txtFechaFin.setBounds(240, 180, 140, 30);

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setText("Ingresa el numero de Actividad Inicial:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(10, 60, 280, 30);

        cboArea.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        cboArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecciona un Area de Empleo --", "-- Marketing --", "-- Desarrollador en software --", "-- Electronica --", "-- Limpieza --", "-- Seguridad --" }));
        jPanel2.add(cboArea);
        cboArea.setBounds(230, 220, 320, 30);

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel7.setText("Selecciona el Estatus de la Actividad:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 100, 280, 30);

        txtNumAct.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jPanel2.add(txtNumAct);
        txtNumAct.setBounds(290, 60, 90, 30);

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel8.setText("Ingresa la Fecha de Inicio:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 140, 210, 30);

        txtFechaInicio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jPanel2.add(txtFechaInicio);
        txtFechaInicio.setBounds(210, 140, 140, 30);

        lblInfo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lblInfo.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 153)));
        jPanel2.add(lblInfo);
        lblInfo.setBounds(570, 220, 500, 50);

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1090, 440));
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarMouseExited
        this.btnGenerar.setBackground(new Color(0, 0, 153));
    }//GEN-LAST:event_btnGenerarMouseExited

    private void btnGenerarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarMouseEntered
        this.btnGenerar.setBackground(Color.green);
    }//GEN-LAST:event_btnGenerarMouseEntered

    private void btnGenerarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarMouseClicked
        generarReportes();
    }//GEN-LAST:event_btnGenerarMouseClicked

    private void cboTipoReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoReporteActionPerformed
        actualizarComponentes();
    }//GEN-LAST:event_cboTipoReporteActionPerformed

    private void btnLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseEntered
        this.btnLimpiar.setBackground(Color.red);
    }//GEN-LAST:event_btnLimpiarMouseEntered

    private void btnLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseExited
        this.btnLimpiar.setBackground(new Color(0, 0, 153));
    }//GEN-LAST:event_btnLimpiarMouseExited

    private void btnLimpiarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMousePressed
        limpiar();
    }//GEN-LAST:event_btnLimpiarMousePressed

    private boolean validarFecha(String fechaInicio) {
        SimpleDateFormat fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
        fechaFormato.setLenient(false);
        
        try {
            fechaFormato.parse(fechaInicio);
        } catch (Exception e) {
            mostrarMensajeError("Ingresa un formato de fecha valido,, \nEl formato de fecha correcto es dd/MM/yyyy.");
            this.txtFechaInicio.requestFocus();
            return false;
        }
        
        return true;
    }
    
    private boolean validarFechaFin(String fechaFin) {
        SimpleDateFormat fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
        fechaFormato.setLenient(false);
        
        try {
            fechaFormato.parse(fechaFin);
        } catch (Exception e) {
            mostrarMensajeError("Ingresa un formato de fecha valido,, \nEl formato de fecha correcto es dd/MM/yyyy.");
            this.txtFechaFin.requestFocus();
            return false;
        }
        
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
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
    private javax.swing.JLabel lblInfo;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtNumAct;
    // End of variables declaration//GEN-END:variables
}
