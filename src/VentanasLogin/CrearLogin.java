/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VentanasLogin;

import Modelo.LoginManager;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.io.IOException;
import javax.swing.ImageIcon;


/**
 *
 * @author josea
 */
public class CrearLogin extends javax.swing.JFrame {
    
    private LoginManager manager = new LoginManager();
    

    /**
     * Creates new form CrearLogin
     */
    public CrearLogin() {
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Recursos/tribal - Editado.png")).getImage());
        
        addPlaceholderStyle(this.txtUsuario);
        addPlaceholderStyle(this.txtCorreo);
        addPlaceholderStyle(this.pswContraseña);
    }
    
    //Metodos para cambiar place holders
    public void addPlaceholderStyle(JTextField textField) {
        Font fuente = textField.getFont();
        fuente = fuente.deriveFont(Font.ITALIC);
        textField.setFont(fuente);
        textField.setForeground(Color.gray); //Este es el color de la fuente que va a tommar primeramente
    }
    
    public void removePlaceholderStyle(JTextField textField) {
        Font fuente = textField.getFont();
        fuente = fuente.deriveFont(Font.PLAIN | Font.BOLD);
        textField.setFont(fuente);
        textField.setForeground(Color.black);//Este ya es el color que tomara al darle click en el
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        pswContraseña = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        btnGuardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnnBorrar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Crear Login");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar.setBackground(new java.awt.Color(204, 0, 204));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/exit_icon_125291.png"))); // NOI18N
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegresarMouseExited(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 90));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/add-user_8802094.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(170, 10, 128, 130);

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Crear Usuario");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(110, 140, 260, 40);

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel4.setText("Borrar Usuario");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(200, 490, 100, 20);

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel5.setText("Rellena todos los espacios. despues dar click en \"Guardar\" para guardar");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 200, 470, 20);

        txtCorreo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtCorreo.setText("Correo/email .com");
        txtCorreo.setBorder(null);
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCorreoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });
        jPanel1.add(txtCorreo);
        txtCorreo.setBounds(10, 320, 400, 30);

        txtUsuario.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtUsuario.setText("Usuario");
        txtUsuario.setBorder(null);
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });
        jPanel1.add(txtUsuario);
        txtUsuario.setBounds(10, 250, 400, 30);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(10, 410, 280, 10);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(10, 280, 400, 20);

        pswContraseña.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        pswContraseña.setText("Contraseña");
        pswContraseña.setBorder(null);
        pswContraseña.setEchoChar('\u0000');
        pswContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pswContraseñaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pswContraseñaFocusLost(evt);
            }
        });
        jPanel1.add(pswContraseña);
        pswContraseña.setBounds(10, 380, 280, 30);

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(10, 350, 400, 20);

        btnGuardar.setBackground(new java.awt.Color(0, 0, 102));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/contact_user_add_user_new_user_icon_250756.png"))); // NOI18N
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
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(110, 430, 80, 60);

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel6.setText("tu Usuario");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 220, 80, 20);

        btnnBorrar.setBackground(new java.awt.Color(0, 0, 102));
        btnnBorrar.setForeground(new java.awt.Color(0, 0, 102));
        btnnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/1486503747-block-delete-person-remove-user_81250.png"))); // NOI18N
        btnnBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnnBorrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnnBorrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnnBorrarMouseExited(evt);
            }
        });
        jPanel1.add(btnnBorrar);
        btnnBorrar.setBounds(210, 430, 80, 60);

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel7.setText("Guardar");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(120, 490, 60, 20);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 500, 520));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/Fondo para la ventana crear usuario.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusGained
        if (this.txtUsuario.getText().equals("Usuario")) {
            this.txtUsuario.setText(null);
            this.txtUsuario.requestFocus();
            //Llamar al metodo remove
            removePlaceholderStyle(this.txtUsuario);
        }
    }//GEN-LAST:event_txtUsuarioFocusGained

    private void txtCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusGained
        if (this.txtCorreo.getText().equals("Correo/email .com")) {
            this.txtCorreo.setText(null);
            this.txtCorreo.requestFocus();
            //Llamar al metodo remove
            removePlaceholderStyle(this.txtCorreo);
        }
    }//GEN-LAST:event_txtCorreoFocusGained

    private void pswContraseñaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pswContraseñaFocusGained
        if (this.pswContraseña.getText().equals("Contraseña")) {
            this.pswContraseña.setText(null);
            this.pswContraseña.requestFocus();
            //Darle al password un formato de contraseña (EchoCjar)
            this.pswContraseña.setEchoChar('@');
            //Llamar al metodo remove
            removePlaceholderStyle(this.pswContraseña);
            
        }
    }//GEN-LAST:event_pswContraseñaFocusGained

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
        if (this.txtUsuario.getText().length() == 0) {
            //Llamar al metodo add cuando el cuadro de dialogo pierda el cursor
            addPlaceholderStyle(this.txtUsuario);
            this.txtUsuario.setText("Usuario");
        }
    }//GEN-LAST:event_txtUsuarioFocusLost

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        if (this.txtCorreo.getText().length() == 0) {
            //Llamar al metodo add cuando el cuadro de dialogo pierda el cursor
            addPlaceholderStyle(this.txtCorreo);
            this.txtCorreo.setText("Correo/email .com");
        }
    }//GEN-LAST:event_txtCorreoFocusLost

    private void pswContraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pswContraseñaFocusLost
        if (this.pswContraseña.getText().length() == 0) {
            //Llamar al metodo add
            addPlaceholderStyle(this.pswContraseña);
            this.pswContraseña.setText("Contraseña");
            this.pswContraseña.setEchoChar('\u0000');
            
        }
    }//GEN-LAST:event_pswContraseñaFocusLost

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        this.requestFocusInWindow();
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        this.btnGuardar.setBackground(Color.green);
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        this.btnGuardar.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnnBorrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnBorrarMouseEntered
        this.btnnBorrar.setBackground(Color.green);
    }//GEN-LAST:event_btnnBorrarMouseEntered

    private void btnnBorrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnBorrarMouseExited
        this.btnnBorrar.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_btnnBorrarMouseExited

    private void btnRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseEntered
        this.btnRegresar.setBackground(Color.red);
    }//GEN-LAST:event_btnRegresarMouseEntered

    private void btnRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseExited
        this.btnRegresar.setBackground(new Color(204, 0, 204));
    }//GEN-LAST:event_btnRegresarMouseExited

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        String usuario = this.txtUsuario.getText();
        String correo = this.txtCorreo.getText();
        String contraseña = new String(this.pswContraseña.getPassword());
        
        if (usuario.isEmpty() || correo.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, llena todos los espacios", "ADVERTENCIA: Campos Vacios", 2);
            return;
        }
        
        if (!esCorreoValido()) {
            return;
        }
        
        try {
            if (manager.crearUsuario(usuario, correo, contraseña)) {
                JOptionPane.showMessageDialog(null, "Usuario creado correctamente", "Exito", 1);
            } else {
                JOptionPane.showMessageDialog(null, "El usuario ya existe", "Usuario existente", 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnnBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnBorrarMouseClicked
        String usuario = this.txtUsuario.getText();
        
        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, escribe un usuario en el espacio correspondiente para borrar.", "ADVERTENCIA: Campo Vacio", 2);
            return;
        }
        
        try {
            if (manager.borrarUsuario(usuario)) {
                JOptionPane.showMessageDialog(null, "Usuario borrado corrrectamente", "Exito", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario No encontrado", "ERROR: No se Encuentra el Usuario", 0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnnBorrarMouseClicked

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        Login ventana = new Login();
        ventana.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnRegresarMouseClicked

    private boolean esCorreoValido() {
        String correo = this.txtCorreo.getText();
        String regex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        
        if (!correo.matches(regex)) {
            JOptionPane.showMessageDialog(null, "El formato de Email es invalido. \nEl formato correcto es: nombredeusuario@dominio.com", "ADVERTENCIA: Error de formato", 2);
            this.txtCorreo.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CrearLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnnBorrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPasswordField pswContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
