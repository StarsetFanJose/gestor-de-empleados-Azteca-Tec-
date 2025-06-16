/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package paneles;

import ClasesUtilitarias.ArchivoUtilClientes;
import java.util.List;
import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author josea
 */
public class EditarCliente extends javax.swing.JPanel {

    /**
     * Creates new form EditarCliente
     */
    public EditarCliente() {
        initComponents();
        
        cargarIDs();
        
    }
    
    private void cargarIDs() {
        this.cboIDs.addItem("-- Selecciona un ID --");
        List<String[]> datos = ArchivoUtilClientes.leerArchivo("clientes.txt");
        
        for (String[] fila : datos) 
            this.cboIDs.addItem(fila[0]);
    }
    
    private void cargarDatos() {
        if (this.cboIDs.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(null, "Selecciona un ID primero para editar.", "ADVERTENCIA: Selecciona un ID", 2);
            configurraComponentes();
            return;
        }
        
        actualizarComponentes();
        
        String idSeleccionado = (String) this.cboIDs.getSelectedItem();
        List<String[]> datos = ArchivoUtilClientes.leerArchivo("clientes.txt");
        for (String[] fila : datos) {
            if (fila[0].equals(idSeleccionado)) {
                this.txtApellido.setText(fila[1]);
                this.txtNombres.setText(fila[2]);
                this.txtFechaRegistro.setText(fila[3]);
                this.txtTelefono.setText(fila[4]);
                this.txtEmail.setText(fila[5]);
                this.txtDireccion.setText(fila[6]);
                this.cboEstatus.setSelectedItem(fila[7]);
                break;
            }
        }
    }
    
    private void actualizarClientes() {
        String idSeleccionado = (String) this.cboIDs.getSelectedItem();
        if (idSeleccionado.equals("-- Selecciona un ID --")) {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar un ID para actualizar los datos.", "ADVERTENCIA: ID No seleccionado", 2);
            return;
        }
        
        if (!validarFecha(this.txtFechaRegistro.getText())) {
            JOptionPane.showMessageDialog(null, "La fecha de Registro tiene un formto incorrecto \nEl formato es dd/MM/yyyy.", "ADVERTENCIA: Error de formato", 2);
            return;
        }
        
        if (!validarTelefono()) {
            return;
        }
        
        if (!validarEmail()) {
            return;
        }
        
        List<String[]> datos = ArchivoUtilClientes.leerArchivo("clientes.txt");
        for (String[] fila : datos) {
            if (fila[0].equals(idSeleccionado)) {
                fila[1] = this.txtApellido.getText();
                fila[2] = this.txtNombres.getText();
                fila[3] = this.txtFechaRegistro.getText();
                fila[4] = this.txtTelefono.getText();
                fila[5] = this.txtEmail.getText();
                fila[6] = this.txtDireccion.getText();
                fila[7] = (String) this.cboEstatus.getSelectedItem();
                break;
            }
        }
        
        ArchivoUtilClientes.escribirArchivo("clientes.txt", datos);
        JOptionPane.showMessageDialog(null, "Datos del cliente actualizados correctamente.", "Exito", 1);
    }
    
    private boolean validarFecha(String fechaRegsitro) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.setLenient(false);
        
        try {
            formatoFecha.parse(fechaRegsitro);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La Fecha de Registro tiene un formato incorrecto. \n El formato"
                    + "correcto es dd/MM/yyyy.", "ADVERTENCIA: Error de Formato.", 2);
            this.txtFechaRegistro.requestFocus();
            return false;
        }
        return true;
    }
    
    private boolean validarTelefono() {
        String telefono = this.txtTelefono.getText();
        // Expresion regurlar del formato 011 52 xx xxxx-xxxx.
        String regex = "^011 52 \\d{2} \\d{4}-\\d{4}$";
        
        if (!telefono.matches(regex)) {
            JOptionPane.showMessageDialog(null, "El formato de Telefono es invalido. \nEl formato esperado es: 011 52 xx xxxx-xxxx", "ADVERTENCIA: Error de Formato", 2);
            this.txtTelefono.requestFocus();
            return false;
        }
        return true;
    }
    
    private boolean validarEmail() {
        String email = this.txtEmail.getText();
        String regex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        
        if (!email.matches(regex)) {
            JOptionPane.showMessageDialog(null, "El formato de Email es invalido. \nEl formato correcto es: nombredeusuario@dominio.com", "ADVERTENCIA: Error de formato", 2);
            this.txtEmail.requestFocus();
            return false;
        }
        return true;
    }
    
     private void limpiar() {
        this.txtApellido.setText(null);
        this.txtNombres.setText(null);
        this.txtFechaRegistro.setText(null);
        this.txtTelefono.setText(null);
        this.txtEmail.setText(null);
        this.txtDireccion.setText(null);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboIDs = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtFechaRegistro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cboEstatus = new javax.swing.JComboBox<>();
        btnLimpiar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Editar Datos del Cliente.");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(170, 30, 640, 70);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/discussion_7017999.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 10, 140, 120);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 140));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel3.setText("Fecha de Registro:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(720, 80, 150, 30);

        cboIDs.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        cboIDs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboIDsActionPerformed(evt);
            }
        });
        jPanel2.add(cboIDs);
        cboIDs.setBounds(770, 20, 300, 40);

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        jLabel4.setText("Selecciona un ID de un en el siguiente combo Box para editar datos:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 20, 770, 30);

        txtFechaRegistro.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jPanel2.add(txtFechaRegistro);
        txtFechaRegistro.setBounds(870, 80, 170, 30);

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel5.setText("Direccion:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(620, 130, 80, 30);

        txtTelefono.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jPanel2.add(txtTelefono);
        txtTelefono.setBounds(80, 130, 200, 30);

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel6.setText("Nombres:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(360, 80, 80, 30);

        txtDireccion.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jPanel2.add(txtDireccion);
        txtDireccion.setBounds(700, 130, 270, 30);

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel7.setText("Apellido:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 80, 80, 30);

        txtApellido.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jPanel2.add(txtApellido);
        txtApellido.setBounds(80, 80, 270, 30);

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel8.setText("Estatus:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 180, 90, 30);

        txtNombres.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jPanel2.add(txtNombres);
        txtNombres.setBounds(440, 80, 270, 30);

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel9.setText("Email:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(290, 130, 80, 30);

        txtEmail.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jPanel2.add(txtEmail);
        txtEmail.setBounds(340, 130, 270, 30);

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel10.setText("Telefono:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 130, 80, 30);

        cboEstatus.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        cboEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecciona un Estatus --", "-- Activo --", "-- Inactivo --" }));
        jPanel2.add(cboEstatus);
        cboEstatus.setBounds(80, 180, 240, 30);

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
        btnLimpiar.setBounds(480, 320, 400, 90);

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
        btnActualizar.setBounds(60, 320, 400, 90);

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1090, 530));
    }// </editor-fold>//GEN-END:initComponents

    private void cboIDsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboIDsActionPerformed
        cargarDatos();
    }//GEN-LAST:event_cboIDsActionPerformed

    private void btnActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseEntered
        this.btnActualizar.setBackground(Color.green);
    }//GEN-LAST:event_btnActualizarMouseEntered

    private void btnActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseExited
        this.btnActualizar.setBackground(new Color(0, 0, 153));
    }//GEN-LAST:event_btnActualizarMouseExited

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        if (validarFormulario()) 
            actualizarClientes();
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void btnLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseEntered
        this.btnLimpiar.setBackground(Color.red);
    }//GEN-LAST:event_btnLimpiarMouseEntered

    private void btnLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseExited
        this.btnLimpiar.setBackground(new Color(0, 0, 153));
    }//GEN-LAST:event_btnLimpiarMouseExited

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        limpiar();
    }//GEN-LAST:event_btnLimpiarMouseClicked


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
        if (!validarTextField(this.txtApellido, "El campo Apellido esta vacio.")) return false;
        if (!validarTextField(this.txtNombres, "El campo Nombres esta vacio")) return false;
        if (!validarTextField(this.txtFechaRegistro, "El campo Fecha de Contrato esta vacio.")) return false;
        if (!validarTextField(this.txtTelefono, "El campo Telefono esta vacio")) return false;
        if (!validarTextField(this.txtEmail, "El campo Email esta vacio.")) return false;
        if (!validarTextField(this.txtDireccion, "El campo Direccion esta vacio")) return false;
        
        if (!validarComboBox(this.cboEstatus, "No has seleccionado el Estatus del Cliente.")) return false;
        
        return true;
    }
    
    private void configurraComponentes() {
        this.txtApellido.setEnabled(false);
        this.txtNombres.setEnabled(false);
        this.txtFechaRegistro.setEnabled(false);
        this.txtTelefono.setEnabled(false);
        this.txtEmail.setEnabled(false);
        this.txtDireccion.setEnabled(false);
        this.cboEstatus.setEnabled(false);
    }
    
    private void actualizarComponentes() {
        this.txtApellido.setEnabled(true);
        this.txtNombres.setEnabled(true);
        this.txtFechaRegistro.setEnabled(true);
        this.txtTelefono.setEnabled(true);
        this.txtEmail.setEnabled(true);
        this.txtDireccion.setEnabled(true);
        this.cboEstatus.setEnabled(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cboEstatus;
    private javax.swing.JComboBox<String> cboIDs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFechaRegistro;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
