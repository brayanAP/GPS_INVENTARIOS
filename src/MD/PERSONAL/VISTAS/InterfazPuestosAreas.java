/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD.PERSONAL.VISTAS;

import MD.GENERALES.VISTAS.interfazPrincipal;
import MDPERSONAL.CONTROLADORES.BDPERSONAL;
import MDPERSONAL.MODELOS.Area;
import MDPERSONAL.MODELOS.Puesto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanramon
 */
public class InterfazPuestosAreas extends javax.swing.JFrame {

  BDPERSONAL metodo =  new BDPERSONAL();
    DefaultTableModel modeloTablaPuestos = new DefaultTableModel();
    DefaultTableModel modeloTablaArea = new DefaultTableModel();
    ValidacionesPersonal valida =new ValidacionesPersonal();
//para mover la ventana
     int x=0;
     int y=0;
    public InterfazPuestosAreas() {
        initComponents();
        setLocationRelativeTo(null);
        
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
        /*CARGAR TABLA DE PUESTOS*/
          modeloTablaPuestos=(DefaultTableModel) tblPuestos.getModel();
       try {
            for(int i=0;i<modeloTablaPuestos.getRowCount();i++){
                modeloTablaPuestos.removeRow(i);
            }
            metodo.ConsultarPuestos(modeloTablaPuestos);

        } catch (SQLException ex) {
             
        }
       /*CARGAR TABLA DE AREAS*/
        modeloTablaArea=(DefaultTableModel) tblArea.getModel();
       try {
            for(int i=0;i<modeloTablaArea.getRowCount();i++){
                modeloTablaArea.removeRow(i);
            }
            metodo.ConsultarAreas(modeloTablaArea);

        } catch (SQLException ex) {
             
        }
      
        /*CARGAR CMBPuesto*/
        cargarCmbPuestos();
        /*CARGAR CMBPuesto*/
        /*cargar ARea*/
       cargarCmbAreas();
        /*Cargar area*/
    }
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMover = new javax.swing.JLabel();
        pnlFondo = new javax.swing.JPanel();
        btnActualizarPuestos = new javax.swing.JButton();
        btnLimpiarAre = new javax.swing.JButton();
        txtNombreArea = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcionArea = new javax.swing.JTextArea();
        lbld = new javax.swing.JLabel();
        btnRegistrarAre = new javax.swing.JButton();
        p2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPuestos = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblArea = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        btnActualizarAreas = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        p1 = new javax.swing.JLabel();
        p3 = new javax.swing.JLabel();
        btnRegistrarP = new javax.swing.JButton();
        txtSalario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombrePuesto = new javax.swing.JTextField();
        txtFolio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        p4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnLimpiarP = new javax.swing.JButton();
        lblInformacionB3 = new javax.swing.JLabel();
        p5 = new javax.swing.JLabel();
        lblInformacionB5 = new javax.swing.JLabel();
        btnEliminarPuesto = new javax.swing.JButton();
        cmbEliminarPuestos = new javax.swing.JComboBox<>();
        cmbEliminarArea = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        lbljohasijd = new javax.swing.JLabel();
        lbljohasijd1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(lblMover, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 650, 70));

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnActualizarPuestos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-actualizar.png"))); // NOI18N
        btnActualizarPuestos.setText("Actualizar Puestos");
        btnActualizarPuestos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizarPuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPuestosActionPerformed(evt);
            }
        });
        pnlFondo.add(btnActualizarPuestos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 180, 30));

        btnLimpiarAre.setText("Limpiar");
        btnLimpiarAre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiarAre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarAreActionPerformed(evt);
            }
        });
        pnlFondo.add(btnLimpiarAre, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 580, -1, -1));

        txtNombreArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreAreaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreAreaKeyReleased(evt);
            }
        });
        pnlFondo.add(txtNombreArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, 107, -1));

        jLabel5.setText("Area del puesto");
        pnlFondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, -1, -1));

        txtDescripcionArea.setColumns(20);
        txtDescripcionArea.setRows(5);
        txtDescripcionArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionAreaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcionArea);

        pnlFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 480, -1, -1));

        lbld.setText("Descripcion de lo que se labora en el area");
        pnlFondo.add(lbld, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, -1, -1));

        btnRegistrarAre.setText("Registrar Area");
        btnRegistrarAre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarAre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAreActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRegistrarAre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 580, -1, -1));

        p2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/verificacionV.png"))); // NOI18N
        pnlFondo.add(p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 30, 30));

        tblPuestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Puesto", "Folio", "Salario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblPuestos);

        pnlFondo.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 370, 260));

        tblArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Area", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblArea);

        pnlFondo.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 370, 260));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        pnlFondo.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 0, 680));

        btnActualizarAreas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-actualizar.png"))); // NOI18N
        btnActualizarAreas.setText("Actualizar Areas");
        btnActualizarAreas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizarAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarAreasActionPerformed(evt);
            }
        });
        pnlFondo.add(btnActualizarAreas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 180, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrarPnl.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        pnlFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, 30, 30));

        p1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/verificacionV.png"))); // NOI18N
        pnlFondo.add(p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 30, 30));

        p3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/verificacionV.png"))); // NOI18N
        pnlFondo.add(p3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 160, 30, 30));

        btnRegistrarP.setText("Registrar Puesto");
        btnRegistrarP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRegistrarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, -1, -1));

        txtSalario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSalarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSalarioKeyReleased(evt);
            }
        });
        pnlFondo.add(txtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 110, -1));

        jLabel3.setText("Salario");
        pnlFondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, -1, -1));

        txtNombrePuesto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombrePuestoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombrePuestoKeyReleased(evt);
            }
        });
        pnlFondo.add(txtNombrePuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 107, -1));

        txtFolio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFolioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFolioKeyReleased(evt);
            }
        });
        pnlFondo.add(txtFolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, 150, -1));

        jLabel2.setText("Folio del puesto");
        pnlFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 130, -1));

        p4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/verificacionV.png"))); // NOI18N
        pnlFondo.add(p4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 480, 30, 30));

        jLabel1.setText("Nombre del puesto");
        pnlFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, -1, -1));

        btnLimpiarP.setText("Limpiar");
        btnLimpiarP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarPActionPerformed(evt);
            }
        });
        pnlFondo.add(btnLimpiarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 280, -1, -1));

        lblInformacionB3.setBorder(javax.swing.BorderFactory.createTitledBorder("Puestos"));
        pnlFondo.add(lblInformacionB3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 380, 270));

        p5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/verificacionV.png"))); // NOI18N
        pnlFondo.add(p5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, 30, 30));

        lblInformacionB5.setBorder(javax.swing.BorderFactory.createTitledBorder("Areas"));
        pnlFondo.add(lblInformacionB5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 380, 300));

        btnEliminarPuesto.setText("Eliminar Puestos");
        btnEliminarPuesto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPuestoActionPerformed(evt);
            }
        });
        pnlFondo.add(btnEliminarPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, -1, -1));

        cmbEliminarPuestos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el Puesto" }));
        cmbEliminarPuestos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlFondo.add(cmbEliminarPuestos, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 140, 190, -1));

        cmbEliminarArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el Area" }));
        cmbEliminarArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlFondo.add(cmbEliminarArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 420, 200, -1));

        jButton2.setText("Eliminar Areas");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnlFondo.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 360, -1, -1));

        lbljohasijd.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlFondo.add(lbljohasijd, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 650, 700));

        lbljohasijd1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlFondo.add(lbljohasijd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 10, 410, 700));

        getContentPane().add(pnlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblMoverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMoverMousePressed
         //para poder arrastar la ventana
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_lblMoverMousePressed

public void cargarCmbPuestos(){
     try {
        ArrayList<String > puestosDisponibles = metodo.extraerPuestos();
        cmbEliminarPuestos.removeAllItems();
        cmbEliminarPuestos.addItem("Seleccione el puesto a eliminar");
        for(int i=0; i<puestosDisponibles.size();i++){
        cmbEliminarPuestos.addItem(puestosDisponibles.get(i));
          
                
        }
        
        } catch (SQLException ex) {
        Logger.getLogger(InterfazEliminarPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void cargarCmbAreas(){
     try {
        ArrayList<String > areasDisponibles = metodo.extraerAreas();
        cmbEliminarArea.removeAllItems();
        cmbEliminarArea.addItem("Seleccione el puesto a eliminar");
        for(int i=0; i<areasDisponibles.size();i++){
        cmbEliminarArea.addItem(areasDisponibles.get(i));
          
                
        }
        
        } catch (SQLException ex) {
        Logger.getLogger(InterfazEliminarPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void lblMoverMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMoverMouseDragged
         //Para mover la ventana
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_lblMoverMouseDragged
public void limpiarPuestos(){
     txtNombrePuesto.setText("");
        txtSalario.setText("");
        txtFolio.setText("");
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
}
    private void btnLimpiarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarPActionPerformed
       limpiarPuestos();
    }//GEN-LAST:event_btnLimpiarPActionPerformed

    private void txtFolioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFolioKeyReleased
        valida.validarFolio(txtFolio, p3);
    }//GEN-LAST:event_txtFolioKeyReleased

    private void txtFolioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFolioKeyPressed
        valida.validarFolio(txtFolio, p3);
    }//GEN-LAST:event_txtFolioKeyPressed

    private void txtNombrePuestoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePuestoKeyReleased
        valida.validarNombrePuesto(txtNombrePuesto,p1);
    }//GEN-LAST:event_txtNombrePuestoKeyReleased

    private void txtNombrePuestoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePuestoKeyPressed
        valida.validarNombrePuesto(txtNombrePuesto,p1);
    }//GEN-LAST:event_txtNombrePuestoKeyPressed

    private void txtSalarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalarioKeyReleased
        valida.validarSalario(txtSalario, p2);
    }//GEN-LAST:event_txtSalarioKeyReleased

    private void txtSalarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalarioKeyPressed
        valida.validarSalario(txtSalario, p2);
    }//GEN-LAST:event_txtSalarioKeyPressed

    private void btnRegistrarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPActionPerformed
        if(p1.isVisible()==true&&p2.isVisible()==true&&p3.isVisible()==true){
            Puesto puesto = new Puesto(txtFolio.getText(),txtNombrePuesto.getText(),Double.parseDouble(txtSalario.getText()));
            if(metodo.insertPuesto(puesto)){
                javax.swing.JOptionPane.showMessageDialog(null, "Puesto registrado con Exito");
                limpiarPuestos();
                }
                if(cmbEliminarPuestos.getSelectedIndex()==0){
                    cargarCmbPuestos();
                }else{
                   cargarCmbPuestos(); 
                }
        }else{
            showMessageDialog(this,"Por favor Verifica los campos");
        }

    }//GEN-LAST:event_btnRegistrarPActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked
public void ActualizarTablaAreas(){
     try {
            int filas=modeloTablaArea.getRowCount();
            for(int i=0;filas>i;i++){
                modeloTablaArea.removeRow(0);
            }
            if(modeloTablaArea.getRowCount()==0){
                metodo.ConsultarAreas(modeloTablaArea);
                showMessageDialog(this,"Datos Actualizados");
            }else{
                showMessageDialog(this,"No fue posible actualizar los datos");
            }
        } catch (SQLException ex) {
            Logger.getLogger(interfazPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    private void btnActualizarAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarAreasActionPerformed
      ActualizarTablaAreas();
    }//GEN-LAST:event_btnActualizarAreasActionPerformed

    private void btnRegistrarAreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAreActionPerformed
        if(p4.isVisible()==true&&p5.isVisible()==true){
            Area area=new Area(txtNombreArea.getText(),txtDescripcionArea.getText());
            if(metodo.insertarArea(area)){
                showMessageDialog(this,"Area registrada con exito");
                 limpiarAreas();
                 if(cmbEliminarArea.getSelectedIndex()==0){
                   cargarCmbAreas();
                }else{
                    cargarCmbAreas();
                }
            }
        }else{
            showMessageDialog(this,"Por favor verifica los campos");
        }
    }//GEN-LAST:event_btnRegistrarAreActionPerformed

    private void txtDescripcionAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionAreaKeyPressed
        valida.validarDescripcionArea(txtDescripcionArea, p4);
    }//GEN-LAST:event_txtDescripcionAreaKeyPressed

    private void txtNombreAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreAreaKeyReleased
        valida.validarNombreArea(txtNombreArea,p5);
    }//GEN-LAST:event_txtNombreAreaKeyReleased

    private void txtNombreAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreAreaKeyPressed
        valida.validarNombreArea(txtNombreArea,p5);
    }//GEN-LAST:event_txtNombreAreaKeyPressed

    public void limpiarAreas(){
         txtNombreArea.setText("");
        txtDescripcionArea.setText("");
        p4.setVisible(false);
        p5.setVisible(false);

    }
    private void btnLimpiarAreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarAreActionPerformed
       limpiarAreas();
    }//GEN-LAST:event_btnLimpiarAreActionPerformed
public void ActualizarTablaPuestos(){
     try {
            int filas=modeloTablaPuestos.getRowCount();
            for(int i=0;filas>i;i++){
                modeloTablaPuestos.removeRow(0);
            }
            if(modeloTablaPuestos.getRowCount()==0){
                metodo.ConsultarPuestos(modeloTablaPuestos);
                showMessageDialog(this,"Datos Actualizados");
            }else{
                showMessageDialog(this,"No fue posible actualizar los datos");
            }
        } catch (SQLException ex) {
            Logger.getLogger(interfazPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    private void btnActualizarPuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPuestosActionPerformed
       ActualizarTablaPuestos();

    }//GEN-LAST:event_btnActualizarPuestosActionPerformed

    private void btnEliminarPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPuestoActionPerformed
        try{
            if(cmbEliminarPuestos.getSelectedIndex()==0){
                showMessageDialog(this,"Por favor seleccione un puesto a eliminar");
            }else{
                int decision=showConfirmDialog(this,"¿Esta seguro que desea eliminar este puesto?");
        if(decision==0){
            if(metodo.eliminarPuesto(cmbEliminarPuestos.getSelectedItem().toString())){
                javax.swing.JOptionPane.showMessageDialog(null, "has eliminado el puesto");
                
             cargarCmbPuestos();
              ActualizarTablaPuestos();
            }
             }
            }
        }catch(Exception e){}
    }//GEN-LAST:event_btnEliminarPuestoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      try{
            if(cmbEliminarArea.getSelectedIndex()==0){
                showMessageDialog(this,"Por favor seleccione el Area a eliminar");
            }else{
                int decision=showConfirmDialog(this,"¿Esta seguro que desea eliminar esta Area?");
        if(decision==0){
            if(metodo.eliminarArea(cmbEliminarArea.getSelectedItem().toString())){
                javax.swing.JOptionPane.showMessageDialog(null, "has eliminado el Area");
                
              cargarCmbAreas();
              ActualizarTablaAreas();
            }
             }
            }
        }catch(Exception e){}
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazPuestosAreas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazPuestosAreas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazPuestosAreas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazPuestosAreas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazPuestosAreas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarAreas;
    private javax.swing.JButton btnActualizarPuestos;
    private javax.swing.JButton btnEliminarPuesto;
    private javax.swing.JButton btnLimpiarAre;
    private javax.swing.JButton btnLimpiarP;
    private javax.swing.JButton btnRegistrarAre;
    private javax.swing.JButton btnRegistrarP;
    private javax.swing.JComboBox<String> cmbEliminarArea;
    private javax.swing.JComboBox<String> cmbEliminarPuestos;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblInformacionB3;
    private javax.swing.JLabel lblInformacionB5;
    private javax.swing.JLabel lblMover;
    private javax.swing.JLabel lbld;
    private javax.swing.JLabel lbljohasijd;
    private javax.swing.JLabel lbljohasijd1;
    private javax.swing.JLabel p1;
    private javax.swing.JLabel p2;
    private javax.swing.JLabel p3;
    private javax.swing.JLabel p4;
    private javax.swing.JLabel p5;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JTable tblArea;
    private javax.swing.JTable tblPuestos;
    private javax.swing.JTextArea txtDescripcionArea;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtNombreArea;
    private javax.swing.JTextField txtNombrePuesto;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables
}