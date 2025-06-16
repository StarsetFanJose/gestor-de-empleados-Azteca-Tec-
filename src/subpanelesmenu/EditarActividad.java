/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package subpanelesmenu;

import java.util.*;
import ClasesUtilitarias.*;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author josea
 */
public class EditarActividad extends javax.swing.JPanel {

    /**
     * Creates new form EditarActividad
     */
    public EditarActividad() {
        initComponents();
        cargarDatos();
        cargarIDsCliente();
        cargarIDsEmpleado();
    }
    
    private void cargarDatos() {
        this.cboNombreActividad.addItem("-- Selecciona un Nombre --");
        List<String[]> datos = ArchivoUtilActividades.leerArchivo("actividades.txt");
        
        for (String[] fila : datos) 
            this.cboNombreActividad.addItem(fila[1]);
    }
    
    private void cargarIDsCliente() {
        this.cboIDsCliente.addItem("-- Selecciona un ID --");
        List<String[]> datos = ArchivoUtilClientes.leerArchivo("clientes.txt");
        
        for (String[] fila : datos) 
            this.cboIDsCliente.addItem(fila[0]);
    }
    
    private void cargarIDsEmpleado() {
        this.cboIDsEmpleado.addItem("-- Selecciona un ID --");
        List<String[]> datos = ArchivoUtilEmpleados.leerArchivo("empleados.txt");
        
        for (String[] fila : datos) 
            this.cboIDsEmpleado.addItem(fila[0]);
    }
    
    private void cargarDatosActividad() {
        if (this.cboNombreActividad.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(null, "Selecciona un numero de actividad", "INFO", 1);
            componentesCerrados();
            return;
        }
        
        componentesAbiertos();
        
        String actSeleccionado = (String) this.cboNombreActividad.getSelectedItem();
        List<String[]> datos = ArchivoUtilActividades.leerArchivo("actividades.txt");
        for (String[] fila : datos) {
            if (fila[1].equals(actSeleccionado)) {
                this.txtNumAct.setText(fila[0]);
                this.txtNomAct.setText(fila[1]);
                this.txtFechaInicio.setText(fila[2]);
                this.txtFechaFin.setText(fila[3]);
                this.cboEstatusAct.setSelectedItem(fila[4]);
                this.cboIDsCliente.setSelectedItem(fila[5]);
                this.txtApellidoCliente.setText(fila[6]);
                this.txtNombresCliente.setText(fila[7]);
                this.txtTelefonoCliente.setText(fila[8]);
                this.cboIDsEmpleado.setSelectedItem(fila[9]);
                this.txtApellidoEmpleado.setText(fila[10]);
                this.txtNombresEmpleado.setText(fila[11]);
                this.txtCurp.setText(fila[12]);
                this.txtArea.setText(fila[13]);
                this.txtPuesto.setText(fila[14]);
                break;
            }
        }
    }
    
    private void cargarDatosCliente() {
        if (this.cboIDsCliente.getSelectedIndex() <= 0) {
            configurarComponentesCliente();
            return;
        }
        
        actualizarComponentesClientes();
        
        String idSeleccionado = (String) this.cboIDsCliente.getSelectedItem();
        List<String[]> datos = ArchivoUtilClientes.leerArchivo("clientes.txt");
        for (String[] fila : datos) {
            if (fila[0].equals(idSeleccionado)) {
                this.txtApellidoCliente.setText(fila[1]);
                this.txtNombresCliente.setText(fila[2]);
                this.txtTelefonoCliente.setText(fila[4]);
                this.txtEstatusCliente.setText(fila[7]);
                if ("-- Inactivo --".equals(fila[7])) {
                    this.txtEstatusCliente.setForeground(Color.red);
                } else if ("-- Activo --".equals(fila[7])) {
                    this.txtEstatusCliente.setForeground(Color.green);
                } else {
                    this.txtEstatusCliente.setForeground(Color.black);
                }
                break;
            }
        }  
    }
    
    private void cargarDatosEmpleado() {
        if (this.cboIDsEmpleado.getSelectedIndex() <= 0) {
            configurarComponentesEmpleado();
            return;
        }
        
        actualizarComponentesEmpleado();
        
        String idSeleccionado = (String) this.cboIDsEmpleado.getSelectedItem();
        List<String[]>  datos = ArchivoUtilEmpleados.leerArchivo("empleados.txt");
        for (String[] fila : datos) {
            if (fila[0].equals(idSeleccionado)) {
                this.txtApellidoEmpleado.setText(fila[1]);
                this.txtNombresEmpleado.setText(fila[2]);
                this.txtCurp.setText(fila[5]);
                this.txtArea.setText(fila[9]);
                this.txtPuesto.setText(fila[10]);
                this.txtEstatusEmpleado.setText(fila[11]);
                if ("-- Inactivo --".equals(fila[11]) || "-- En Capacitacion --".equals(fila[11])) {
                    this.txtEstatusEmpleado.setForeground(Color.red);
                } else if ("-- Activo --".equals(fila[11])) {
                    this.txtEstatusEmpleado.setForeground(Color.green);
                } else {
                    this.txtEstatusEmpleado.setForeground(Color.black);
                }
                break;
            }
        }
    }
    
    private void actualizarActividad() {
        String actSeleccionado = (String) this.cboNombreActividad.getSelectedItem();
        
        if (actSeleccionado.equals("-- Selecciona un Nombre --")) {
            JOptionPane.showMessageDialog(null, "Debe elegir un nombre de actividad para actualizar.", "ADVEERTENCIA: No hay seleccion de actividad.", 2);
            return;
        }
        
        if (!validarFechas(this.txtFechaInicio.getText(), this.txtFechaFin.getText())) {
            return;
        }
        
        if (!validarEstatus()) {
            return;
        }
        
        List<String[]> datos = ArchivoUtilActividades.leerArchivo("actividades.txt");
        for (String[] fila : datos) {
            if (fila[1].equals(actSeleccionado)) {
                fila[0] = String.valueOf(Integer.parseInt(this.txtNumAct.getText()));
                fila[1] = this.txtNomAct.getText();
                fila[2] = this.txtFechaInicio.getText();
                fila[3] = this.txtFechaFin.getText();
                fila[4] = (String) this.cboEstatusAct.getSelectedItem();
                fila[5] = (String) this.cboIDsCliente.getSelectedItem();
                fila[6] = this.txtApellidoCliente.getText();
                fila[7] = this.txtNombresCliente.getText();
                fila[8] = this.txtTelefonoCliente.getText();
                fila[9] = (String) this.cboIDsEmpleado.getSelectedItem();
                fila[10] = this.txtApellidoEmpleado.getText();
                fila[11] = this.txtNombresEmpleado.getText();
                fila[12] = this.txtCurp.getText();
                fila[13] = this.txtArea.getText();
                fila[14] = this.txtPuesto.getText();
                break;
            }
        }
        
        ArchivoUtilActividades.escribirArchivo("actividades.txt", datos);
        JOptionPane.showMessageDialog(null, "Datos de la actividad actualizados correctamente.", "Exito", 1);
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
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboNombreActividad = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFechaFin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNumAct = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPuesto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFechaInicio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboEstatusAct = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboIDsCliente = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtNomAct = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTelefonoCliente = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCurp = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtApellidoCliente = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtNombresCliente = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtArea = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtApellidoEmpleado = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtNombresEmpleado = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        cboIDsEmpleado = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        txtEstatusEmpleado = new javax.swing.JTextField();
        txtEstatusCliente = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setLayout(null);

        jLabel20.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 24)); // NOI18N
        jLabel20.setText("Editar Datos de Actividad:");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(70, 20, 480, 40);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/editar act.png"))); // NOI18N
        jPanel1.add(jLabel21);
        jLabel21.setBounds(10, 10, 70, 60);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 80));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        jLabel1.setText("Selecciona el nombre de la actividad para editar sus datos y actualizarlo:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 10, 810, 30);

        cboNombreActividad.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        cboNombreActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNombreActividadActionPerformed(evt);
            }
        });
        jPanel2.add(cboNombreActividad);
        cboNombreActividad.setBounds(820, 10, 260, 30);

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel2.setText("Datos basicos de la actividad:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 310, 260, 30);

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel3.setText("Telefono:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 260, 70, 30);

        txtFechaFin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jPanel2.add(txtFechaFin);
        txtFechaFin.setBounds(920, 90, 100, 30);

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel4.setText("Numero de Act:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 90, 110, 30);

        txtNumAct.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jPanel2.add(txtNumAct);
        txtNumAct.setBounds(120, 90, 64, 30);

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel5.setText("Nombre de la Act:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(190, 90, 130, 30);

        txtPuesto.setEditable(false);
        txtPuesto.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jPanel2.add(txtPuesto);
        txtPuesto.setBounds(660, 380, 240, 30);

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel6.setText("Fecha de Inicio:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(560, 90, 110, 30);

        txtFechaInicio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jPanel2.add(txtFechaInicio);
        txtFechaInicio.setBounds(670, 90, 100, 30);

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel7.setText("Fecha Aprox. de Fin:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(780, 90, 140, 30);

        cboEstatusAct.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        cboEstatusAct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecciona un Estatus --", "-- Planificacion --", "-- En Ejecucion --", "-- Pausada --", "-- Completada --", "-- Cancelada --", "-- En Revision --" }));
        jPanel2.add(cboEstatusAct);
        cboEstatusAct.setBounds(130, 130, 280, 30);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(10, 300, 1070, 10);

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel8.setText("Estatus de la Act:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 130, 130, 30);

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel9.setText("Datos basicos de la actividad:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(10, 50, 260, 30);

        cboIDsCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboIDsClienteActionPerformed(evt);
            }
        });
        jPanel2.add(cboIDsCliente);
        cboIDsCliente.setBounds(80, 220, 230, 30);

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel10.setText("Area:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(310, 390, 60, 20);

        txtNomAct.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jPanel2.add(txtNomAct);
        txtNomAct.setBounds(310, 90, 240, 30);

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel11.setText("Puesto:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(600, 380, 70, 30);

        txtTelefonoCliente.setEditable(false);
        txtTelefonoCliente.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jPanel2.add(txtTelefonoCliente);
        txtTelefonoCliente.setBounds(80, 260, 240, 30);

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel12.setText("Nombres:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(620, 340, 70, 30);

        txtCurp.setEditable(false);
        txtCurp.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jPanel2.add(txtCurp);
        txtCurp.setBounds(60, 380, 240, 30);

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel13.setText("Datos basicos de la actividad:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(10, 190, 260, 30);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(10, 180, 1070, 10);

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel14.setText("ID Cliente:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(10, 220, 90, 30);

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel15.setText("Apellido:");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(320, 220, 70, 30);

        txtApellidoCliente.setEditable(false);
        txtApellidoCliente.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jPanel2.add(txtApellidoCliente);
        txtApellidoCliente.setBounds(380, 220, 240, 30);

        jLabel16.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel16.setText("Nombres:");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(630, 220, 70, 30);

        txtNombresCliente.setEditable(false);
        txtNombresCliente.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jPanel2.add(txtNombresCliente);
        txtNombresCliente.setBounds(700, 220, 240, 30);

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel17.setText("ID Empleado:");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(10, 350, 90, 20);

        txtArea.setEditable(false);
        txtArea.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jPanel2.add(txtArea);
        txtArea.setBounds(350, 380, 240, 30);

        jLabel18.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel18.setText("CURP:");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(10, 390, 60, 20);

        txtApellidoEmpleado.setEditable(false);
        txtApellidoEmpleado.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jPanel2.add(txtApellidoEmpleado);
        txtApellidoEmpleado.setBounds(370, 340, 240, 30);

        jLabel19.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel19.setText("Apellido:");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(310, 340, 70, 30);

        txtNombresEmpleado.setEditable(false);
        txtNombresEmpleado.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jPanel2.add(txtNombresEmpleado);
        txtNombresEmpleado.setBounds(690, 340, 240, 30);

        btnLimpiar.setBackground(new java.awt.Color(0, 0, 153));
        btnLimpiar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/backspace_10023704.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
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
        btnLimpiar.setBounds(730, 420, 330, 60);

        btnActualizar.setBackground(new java.awt.Color(0, 0, 153));
        btnActualizar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/systemsoftwareupdate_94333.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnActualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnActualizarMouseExited(evt);
            }
        });
        jPanel2.add(btnActualizar);
        btnActualizar.setBounds(380, 420, 330, 60);

        cboIDsEmpleado.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        cboIDsEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboIDsEmpleadoActionPerformed(evt);
            }
        });
        jPanel2.add(cboIDsEmpleado);
        cboIDsEmpleado.setBounds(100, 340, 200, 30);

        jLabel22.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel22.setText("Estatus:");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(340, 270, 80, 20);

        txtEstatusEmpleado.setEditable(false);
        txtEstatusEmpleado.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jPanel2.add(txtEstatusEmpleado);
        txtEstatusEmpleado.setBounds(70, 420, 210, 30);

        txtEstatusCliente.setEditable(false);
        txtEstatusCliente.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jPanel2.add(txtEstatusCliente);
        txtEstatusCliente.setBounds(400, 260, 210, 30);

        jLabel23.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel23.setText("Estatus:");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(10, 430, 80, 20);

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1090, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseEntered
        this.btnActualizar.setBackground(Color.green);
    }//GEN-LAST:event_btnActualizarMouseEntered

    private void btnActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseExited
        this.btnActualizar.setBackground(new Color(0, 0, 153));
    }//GEN-LAST:event_btnActualizarMouseExited

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        if (validarFormulario()) 
            actualizarActividad();
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void cboNombreActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNombreActividadActionPerformed
        cargarDatosActividad();
    }//GEN-LAST:event_cboNombreActividadActionPerformed

    private void btnLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseEntered
        this.btnLimpiar.setBackground(Color.red);
    }//GEN-LAST:event_btnLimpiarMouseEntered

    private void btnLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseExited
        this.btnLimpiar.setBackground(new Color(0, 0, 153));
    }//GEN-LAST:event_btnLimpiarMouseExited

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void cboIDsClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboIDsClienteActionPerformed
        cargarDatosCliente();
    }//GEN-LAST:event_cboIDsClienteActionPerformed

    private void cboIDsEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboIDsEmpleadoActionPerformed
        cargarDatosEmpleado();
    }//GEN-LAST:event_cboIDsEmpleadoActionPerformed

    private boolean validarFechas(String fechaInicio, String fechaFin) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.setLenient(false);
        
        try {
            formatoFecha.parse(fechaInicio);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "La fecha de Inicio tiene un formato invalido. \nEl formato correcto es dd/MM/yyyy.", "ADVERTENCIA: Formato incorrecto", 2);
            this.txtFechaInicio.requestFocus();
            return false;
        }
        
        try {
            formatoFecha.parse(fechaFin);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "La fecha de Fin tiene un formato invalido. \nEl formato correcto es dd/MM/yyyy.", "ADVERTENCIA: Formato incorrecto", 2);
            this.txtFechaFin.requestFocus();
            return false;
        }
        return true;
    }
    
    private boolean validarTextField(JTextField textField, String mensaje) {
        if (textField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, mensaje);
            textField.requestFocus();
            return false;
        }
        return true;
    }
    
    private boolean validarComboBox(JComboBox<String> comboBox, String mensaje) {
        if (comboBox.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, mensaje);
            comboBox.requestFocus();
            return false;
        }
        return true;
    }
    
    private boolean validarFormulario() {
        if (!validarTextField(this.txtNumAct, "El campo Num. de Actividad esta vacio.")) return false;
        if (!validarTextField(this.txtNomAct, "El campo Nombre de Actividad esta vacio.")) return false;
        if (!validarTextField(this.txtFechaInicio, "El campo Fecha de Inicio esta vacio.")) return false;
        if (!validarTextField(this.txtFechaFin, "El campo Fecha Apor. de Fin esta vacio.")) return false;
        if (!validarTextField(this.txtApellidoCliente, "El campo Apellido en el cliente esta vacio.")) return false;
        if (!validarTextField(this.txtNombresCliente, "El campo Nombre en el cliente esta vacio.")) return false;
        if (!validarTextField(this.txtTelefonoCliente, "El campo Telefono en el cliente esta vacio.")) return false;
        if (!validarTextField(this.txtApellidoEmpleado, "El campo Apellido en el Empleado esta vacio.")) return false;
        if (!validarTextField(this.txtNombresEmpleado, "El campo Nombre en el Empleado esta vacio.")) return false;
        if (!validarTextField(this.txtCurp, "El campo Curp en el Empleado esta vacio.")) return false;
        if (!validarTextField(this.txtArea, "El campo Area de Empleo esta vacio.")) return false;
        if (!validarTextField(this.txtPuesto, "El campo Puesto de Empleo esta vacio.")) return false;
        
        if (!validarComboBox(this.cboEstatusAct, "Debe seleccionar un Estatus de la Actividad.")) return false;
        if (!validarComboBox(this.cboIDsCliente, "Debe seleccionar un ID de Cliente.")) return false;
        if (!validarComboBox(this.cboIDsEmpleado, "Debe seleccionar un ID de Empleado.")) return false;
        return true;
    }
    
    private boolean validarEstatus() {
        String estatusCliente = this.txtEstatusCliente.getText();
        String estatusEmpleado = this.txtEstatusEmpleado.getText();
        
        if (estatusCliente.equals("-- Inactivo --")) {
            JOptionPane.showMessageDialog(null, "El estatus del cliente es inactivo no puedes actualizar la actividad. \nCambia el estatus del cliente en Editar Cliente", "ERROR: Cliente Inactivo", 0);
            return false;
        }
        
        if (estatusEmpleado.equals("-- Inactivo --") || estatusEmpleado.equals("-- En Capacitacion --")) {
            JOptionPane.showMessageDialog(null, "El estatus del empleado es inactivo o en capacitacion no puedes actualizar la actividad. \nCambia el estatus del cliente en Editar Empleado en el Menu Gestor de Empresa", "ERROR: Empleado inactivo o en capacitacion", 0);
            return false;
        }
        
        return true;
    }
    
    
    private void componentesCerrados() {
       this.txtNumAct.setEnabled(false);
       this.txtNomAct.setEnabled(false);
       this.txtFechaInicio.setEnabled(false);
       this.txtFechaFin.setEnabled(false);
       this.cboEstatusAct.setEnabled(false);
       this.cboIDsCliente.setEnabled(false);
       this.cboIDsEmpleado.setEnabled(false);
    }
    
    private void componentesAbiertos() {
       this.txtNumAct.setEnabled(true);
       this.txtNomAct.setEnabled(true);
       this.txtFechaInicio.setEnabled(true);
       this.txtFechaFin.setEnabled(true);
       this.cboEstatusAct.setEnabled(true);
       this.cboIDsCliente.setEnabled(true);
       this.cboIDsEmpleado.setEnabled(true);
    }
    
    private void configurarComponentesCliente() {
        this.txtApellidoCliente.setEnabled(false);
        this.txtNombresCliente.setEnabled(false);
        this.txtTelefonoCliente.setEnabled(false);
        this.txtEstatusCliente.setEnabled(false);
    }
    
    private void configurarComponentesEmpleado() {
        this.txtApellidoEmpleado.setEnabled(false);
        this.txtNombresEmpleado.setEnabled(false);
        this.txtCurp.setEnabled(false);
        this.txtArea.setEnabled(false);
        this.txtPuesto.setEnabled(false);
        this.txtEstatusEmpleado.setEnabled(false);
    }
    
    private void actualizarComponentesClientes() {
        this.txtApellidoCliente.setEnabled(true);
        this.txtNombresCliente.setEnabled(true);
        this.txtTelefonoCliente.setEnabled(true);
        this.txtEstatusCliente.setEnabled(true);
    }
    
    private void actualizarComponentesEmpleado() {
        this.txtApellidoEmpleado.setEnabled(true);
        this.txtNombresEmpleado.setEnabled(true);
        this.txtCurp.setEnabled(true);
        this.txtArea.setEnabled(true);
        this.txtPuesto.setEnabled(true);
        this.txtEstatusEmpleado.setEnabled(true);
    }
    
    private void limpiarCampos() {
        this.cboNombreActividad.setSelectedItem("-- Selecciona un Nombre --");
        this.txtNumAct.setText(null);
        this.txtNomAct.setText(null);
        this.txtFechaInicio.setText(null);
        this.txtFechaFin.setText(null);
        this.cboEstatusAct.setSelectedItem("-- Selecciona un Estatus --");
        this.cboIDsCliente.setSelectedItem("-- Selecciona un ID --");
        this.cboIDsEmpleado.setSelectedItem("-- Selecciona un ID --");
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cboEstatusAct;
    private javax.swing.JComboBox<String> cboIDsCliente;
    private javax.swing.JComboBox<String> cboIDsEmpleado;
    private javax.swing.JComboBox<String> cboNombreActividad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtApellidoCliente;
    private javax.swing.JTextField txtApellidoEmpleado;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtCurp;
    private javax.swing.JTextField txtEstatusCliente;
    private javax.swing.JTextField txtEstatusEmpleado;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtNomAct;
    private javax.swing.JTextField txtNombresCliente;
    private javax.swing.JTextField txtNombresEmpleado;
    private javax.swing.JTextField txtNumAct;
    private javax.swing.JTextField txtPuesto;
    private javax.swing.JTextField txtTelefonoCliente;
    // End of variables declaration//GEN-END:variables
}
