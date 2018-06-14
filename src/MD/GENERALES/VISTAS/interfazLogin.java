package MD.GENERALES.VISTAS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import GENERALES.CONTROLADORES.BDGENERALES;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;


import MDPERSONAL.MODELOS.Usuario;
import static javax.swing.JOptionPane.showMessageDialog;


/**
 *
 * @author juanramon
 */
public class interfazLogin extends javax.swing.JFrame {
   //INTANCIAS
   Validaciones validacion=new Validaciones();
   BDGENERALES metodo = new BDGENERALES();
  
   //ATRIBUTOS 
     int x=0;
     int y=0;
     
     //Control de validacion
  
    /**
     * Creates new form ventanaLogin
     */
    public interfazLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
            //Ocultara las palomitas cuando se active la ventana
               lbl1.setVisible(false); 
               lbl2.setVisible(false);
           
    }

   


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        btnIniciar = new javax.swing.JButton();
        txtContraseña = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        lblContraseña = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        lblMover = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblIconLock = new javax.swing.JLabel();
        lblUsuarioLogin = new javax.swing.JLabel();
        lblSesion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lblEncabezado = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblFondo = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIniciar.setBackground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("Iniciar Sesion");
        btnIniciar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 100, 30));

        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyReleased(evt);
            }
        });
        getContentPane().add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 232, 120, 25));

        txtUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(102, 102, 102));
        txtUsuario.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtUsuarioCaretUpdate(evt);
            }
        });
        txtUsuario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtUsuarioMouseMoved(evt);
            }
        });
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusGained(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 120, 25));

        lblContraseña.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblContraseña.setForeground(new java.awt.Color(102, 102, 102));
        lblContraseña.setText("Contraseña");
        getContentPane().add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, -1, -1));

        lblUsuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(102, 102, 102));
        lblUsuario.setText("Usuario");
        getContentPane().add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        lblInfo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblInfo.setText("¿No tienes una cuenta?");
        lblInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblInfoMouseExited(evt);
            }
        });
        getContentPane().add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));

        lblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimizar.png"))); // NOI18N
        lblMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMinimizarMouseExited(evt);
            }
        });
        getContentPane().add(lblMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 30, 30));

        lblMover.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        lblMover.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblMoverMouseDragged(evt);
            }
        });
        lblMover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMoverMousePressed(evt);
            }
        });
        getContentPane().add(lblMover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 70));

        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCerrarMouseExited(evt);
            }
        });
        getContentPane().add(lblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 30, 30));

        lblIconLock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lock.png"))); // NOI18N
        getContentPane().add(lblIconLock, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 30, 40));

        lblUsuarioLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/man.png"))); // NOI18N
        getContentPane().add(lblUsuarioLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 130, 130));

        lblSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bienvenido.png"))); // NOI18N
        getContentPane().add(lblSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 280, 70));

        jLabel1.setText("Instituto Estatal Electoral de Nayarit");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuarioLogin2.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 30, 30));

        lbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/verificacionV.png"))); // NOI18N
        getContentPane().add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 20, 20));

        lbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/verificacionV.png"))); // NOI18N
        getContentPane().add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 20, 20));

        lblEncabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoIEEN.png"))); // NOI18N
        getContentPane().add(lblEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 60));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 30, 380));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoLogin2.png"))); // NOI18N
        lblFondo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
     System.exit(0);
             
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
    
        
      
    //Validara que los campos sean correctos antes de loguear
    if(lbl1.isVisible()&&lbl2.isVisible()==true){
      boolean encontrado=false;
      //Aqui se debe tomar el tipo de usuario y mandarlo ala ventana siguiente
     encontrado= metodo.loguear(txtUsuario.getText(),txtContraseña.getText());
     String usuario=txtUsuario.getText();
     if(encontrado==true){
          int permiso=Integer.parseInt(metodo.obtenerTipUsu(txtUsuario.getText()));
        
                  new interfazPrincipal(usuario,permiso).setVisible(true);
                   dispose();
     }
    }else{
        showMessageDialog(this,"Por favor ingresa datos correctos");

    }
     
    
    
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void lblCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseEntered
     lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelarSeleccionado.png"))); // NOI18N
      
    }//GEN-LAST:event_lblCerrarMouseEntered

    private void lblCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseExited
      lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
      
    }//GEN-LAST:event_lblCerrarMouseExited

    private void lblMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseEntered
       lblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimizarSeleccionado.png"))); // NOI18N
      
    }//GEN-LAST:event_lblMinimizarMouseEntered

    private void lblMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseExited
    lblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimizar.png"))); // NOI18N
    
    }//GEN-LAST:event_lblMinimizarMouseExited

    private void lblInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInfoMouseEntered
       lblInfo.setForeground(Color.BLUE);
     
    }//GEN-LAST:event_lblInfoMouseEntered

    private void lblInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInfoMouseExited
      lblInfo.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblInfoMouseExited

    private void lblInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInfoMouseClicked
     showMessageDialog(this,"Para obtener una cuenta en el sistema pongase"+"\n"+" en contacto con el Administrador del sistema");
    }//GEN-LAST:event_lblInfoMouseClicked

    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseClicked
    this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_lblMinimizarMouseClicked

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
    
       validacion.validarUsuario(txtUsuario,lbl1);
       
    
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
   validacion.validarUsuario(txtUsuario,lbl1);
        
        
    }//GEN-LAST:event_txtUsuarioKeyReleased

    private void txtContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyPressed
   validacion.validarPASS(txtContraseña,lbl2);
        
        
    }//GEN-LAST:event_txtContraseñaKeyPressed

    private void txtContraseñaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyReleased
validacion.validarPASS(txtContraseña,lbl2);
    }//GEN-LAST:event_txtContraseñaKeyReleased

    private void lblMoverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMoverMousePressed
        //para poder arrastar la ventana
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_lblMoverMousePressed

    private void lblMoverMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMoverMouseDragged
     //Para mover la ventana
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_lblMoverMouseDragged

    private void txtUsuarioCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtUsuarioCaretUpdate
     
    }//GEN-LAST:event_txtUsuarioCaretUpdate

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
     
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusGained
     validacion.validarUsuario(txtUsuario,lbl1);
    }//GEN-LAST:event_txtUsuarioFocusGained

    private void txtUsuarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMouseMoved
       validacion.validarUsuario(txtUsuario,lbl1);
    }//GEN-LAST:event_txtUsuarioMouseMoved

public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("img/login.png"));


        return retValue;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblIconLock;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JLabel lblMover;
    private javax.swing.JLabel lblSesion;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuarioLogin;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
