/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDINVENTARIOS.VISTAS;

import MD.GENERALES.VISTAS.interfazPrincipal;
import MDINVENTARIOS.CONTROLADORES.BDDInventarios;
import MDINVENTARIOS.CONTROLADORES.MDINVENTARIOS;
import MDINVENTARIOS.MODELOS.Clasificacion;
import MDINVENTARIOS.MODELOS.Foto;
import MDINVENTARIOS.MODELOS.Producto;
import MDINVENTARIOS.MODELOS.Status;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 *
 * @author brula
 */
public class nuevoProducto extends javax.swing.JFrame {
    private String rutaImagen = "";
    /**
     * Creates new form nuevoProducto
     */
    public nuevoProducto() {
        initComponents();
        this.cmbStatusPro.removeAll();
        
        ArrayList<Status> arraySta = BDDInventarios.selectStatus();
        for(int i = 0; i < arraySta.size(); i++){
            this.cmbStatusPro.addItem(arraySta.get(i).getNom_sta());
        }

        this.cmbClasificacionPro.removeAll();
        
        ArrayList<Clasificacion> arrayCla = BDDInventarios.selectClasificaciones();
        for(int i = 0; i < arrayCla.size(); i++){
            this.cmbClasificacionPro.addItem(arrayCla.get(i).getNom_clas());
        }
    }
    
    public void datosVehiculo(boolean valor){

        this.txtStockPro.setText("1");
        this.txtMinimoPro.setText("0");
        this.txtStockPro.setEditable(valor);
        this.txtMinimoPro.setEditable(valor);
        this.txtNoSeriePro.setEditable(valor);
        this.txtPlaca.setEditable(valor);
        this.txtNoMotor.setEditable(valor);
        this.txtKilometraje.setEditable(valor);
        this.txtKilometrajeServ.setEditable(valor);
        
        this.txtNoSeriePro.setText("");
        this.txtPlaca.setText("");
        this.txtNoMotor.setText("0");
        this.txtKilometraje.setText("0");
        this.txtKilometrajeServ.setText("0");
        
        this.txtStockPro.setEnabled(valor);
        this.txtMinimoPro.setEnabled(valor);
        this.txtStockPro.setEnabled(valor);
        this.txtMinimoPro.setEnabled(valor);
        this.txtNoSeriePro.setEnabled(valor);
        this.txtPlaca.setEnabled(valor);
        this.txtNoMotor.setEnabled(valor);
        this.txtKilometraje.setEnabled(valor);
        this.txtKilometrajeServ.setEnabled(valor);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblNombrePro = new javax.swing.JLabel();
        txtNombrePro = new javax.swing.JTextField();
        lblDescripcionPro = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcionPro = new javax.swing.JTextArea();
        lblMarcaPro = new javax.swing.JLabel();
        txtMarcaPro = new javax.swing.JTextField();
        lblModeloPro = new javax.swing.JLabel();
        txtModeloPro = new javax.swing.JTextField();
        lblNumSeriePro = new javax.swing.JLabel();
        txtNoSeriePro = new javax.swing.JTextField();
        txtColorPro = new javax.swing.JTextField();
        lblColorPro = new javax.swing.JLabel();
        lblStockPro = new javax.swing.JLabel();
        txtStockPro = new javax.swing.JTextField();
        lblMinimoPro = new javax.swing.JLabel();
        lblCaracteristicasProducto = new javax.swing.JLabel();
        txtMinimoPro = new javax.swing.JTextField();
        lblClasficPro = new javax.swing.JLabel();
        cmbStatusPro = new javax.swing.JComboBox<>();
        lblEstatusPro = new javax.swing.JLabel();
        cmbClasificacionPro = new javax.swing.JComboBox<>();
        lblObservPro = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservacionesPro = new javax.swing.JTextArea();
        lblNumIdentificacionPro = new javax.swing.JLabel();
        txtNoIdentificacionPro = new javax.swing.JTextField();
        lblSubCatPro = new javax.swing.JLabel();
        txtSubCategoriaPro = new javax.swing.JTextField();
        lblMarcoPro1 = new javax.swing.JLabel();
        lblMarcoPro2 = new javax.swing.JLabel();
        txtImportePro = new javax.swing.JTextField();
        txtFechaCompraPro = new javax.swing.JTextField();
        txtNoFacturaPro = new javax.swing.JTextField();
        lblNumFacturaPro = new javax.swing.JLabel();
        lblImportePro = new javax.swing.JLabel();
        lblFechaCompraPro = new javax.swing.JLabel();
        lblMarcoProAdquisiicion = new javax.swing.JLabel();
        panelDatosVehiculo = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNoMotor = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtKilometraje = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtKilometrajeServ = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        panImagen = new javax.swing.JPanel();
        btnImagen = new javax.swing.JButton();
        btnGuardar1 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseEntered(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombrePro.setText("Nombre:");
        jPanel1.add(lblNombrePro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        jPanel1.add(txtNombrePro, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 230, -1));

        lblDescripcionPro.setText("Descripción:");
        jPanel1.add(lblDescripcionPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtDescripcionPro.setColumns(20);
        txtDescripcionPro.setRows(5);
        jScrollPane2.setViewportView(txtDescripcionPro);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 420, 165));

        lblMarcaPro.setText("Marca:");
        jPanel1.add(lblMarcaPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));
        jPanel1.add(txtMarcaPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 220, -1));

        lblModeloPro.setText("Modelo:");
        jPanel1.add(lblModeloPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));
        jPanel1.add(txtModeloPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 220, -1));

        lblNumSeriePro.setText("No. Serie:");
        jPanel1.add(lblNumSeriePro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));
        jPanel1.add(txtNoSeriePro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 220, -1));
        jPanel1.add(txtColorPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 220, -1));

        lblColorPro.setText("Color:");
        jPanel1.add(lblColorPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        lblStockPro.setText("Stock:");
        jPanel1.add(lblStockPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        txtStockPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockProActionPerformed(evt);
            }
        });
        jPanel1.add(txtStockPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 220, -1));

        lblMinimoPro.setText("Mínimo:");
        jPanel1.add(lblMinimoPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, -1, -1));

        lblCaracteristicasProducto.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblCaracteristicasProducto.setForeground(new java.awt.Color(204, 204, 204));
        lblCaracteristicasProducto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCaracteristicasProducto.setText("Caracteristicas Especificas");
        jPanel1.add(lblCaracteristicasProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 420, -1));
        jPanel1.add(txtMinimoPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 490, 220, -1));

        lblClasficPro.setText("Clasificación:");
        jPanel1.add(lblClasficPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        cmbStatusPro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Status" }));
        cmbStatusPro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbStatusProFocusGained(evt);
            }
        });
        jPanel1.add(cmbStatusPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 250, 230, -1));

        lblEstatusPro.setText("Status:");
        jPanel1.add(lblEstatusPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, -1, -1));

        cmbClasificacionPro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una clasificación" }));
        cmbClasificacionPro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClasificacionProItemStateChanged(evt);
            }
        });
        cmbClasificacionPro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbClasificacionProFocusGained(evt);
            }
        });
        jPanel1.add(cmbClasificacionPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 230, -1));

        lblObservPro.setText("Observaciones:");
        jPanel1.add(lblObservPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, -1, -1));

        txtObservacionesPro.setColumns(20);
        txtObservacionesPro.setRows(5);
        jScrollPane3.setViewportView(txtObservacionesPro);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, 230, 110));

        lblNumIdentificacionPro.setText("No. Identificación:");
        jPanel1.add(lblNumIdentificacionPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, -1, -1));
        jPanel1.add(txtNoIdentificacionPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 410, 230, -1));

        lblSubCatPro.setText("Sub Categoría:");
        jPanel1.add(lblSubCatPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, -1, -1));
        jPanel1.add(txtSubCategoriaPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 450, 230, -1));

        lblMarcoPro1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Caracteristicas del Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel1.add(lblMarcoPro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 460, 330));

        lblMarcoPro2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Caracteristicas del Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel1.add(lblMarcoPro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 450, 520));
        jPanel1.add(txtImportePro, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 220, -1));
        jPanel1.add(txtFechaCompraPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 220, -1));
        jPanel1.add(txtNoFacturaPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, 220, -1));

        lblNumFacturaPro.setText("No. Factura:");
        jPanel1.add(lblNumFacturaPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, -1, -1));

        lblImportePro.setText("Importe:");
        jPanel1.add(lblImportePro, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, -1));

        lblFechaCompraPro.setText("Fecha de compra: ");
        jPanel1.add(lblFechaCompraPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, -1));

        lblMarcoProAdquisiicion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Adquisicion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel1.add(lblMarcoProAdquisiicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 460, 190));

        jTabbedPane1.addTab("Datos producto", jPanel1);

        jLabel9.setText("Placa:");

        jLabel10.setText("No. Motor:");

        jLabel18.setText("Kilometraje:");

        jLabel19.setText("Kilometraje serv.:");

        javax.swing.GroupLayout panelDatosVehiculoLayout = new javax.swing.GroupLayout(panelDatosVehiculo);
        panelDatosVehiculo.setLayout(panelDatosVehiculoLayout);
        panelDatosVehiculoLayout.setHorizontalGroup(
            panelDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosVehiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelDatosVehiculoLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosVehiculoLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosVehiculoLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(txtKilometrajeServ, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosVehiculoLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNoMotor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 703, Short.MAX_VALUE))
        );
        panelDatosVehiculoLayout.setVerticalGroup(
            panelDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosVehiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(panelDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNoMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(panelDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(panelDatosVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKilometrajeServ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Datos vehiculo", panelDatosVehiculo);

        panImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout panImagenLayout = new javax.swing.GroupLayout(panImagen);
        panImagen.setLayout(panImagenLayout);
        panImagenLayout.setHorizontalGroup(
            panImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 985, Short.MAX_VALUE)
        );
        panImagenLayout.setVerticalGroup(
            panImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );

        btnImagen.setText("Cargar Imagen");
        btnImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImagenMouseClicked(evt);
            }
        });
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnImagen)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(btnImagen)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cargar imagen", jPanel4);

        btnGuardar1.setBackground(new java.awt.Color(255, 255, 204));
        btnGuardar1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/guardar.png"))); // NOI18N
        btnGuardar1.setText("Guardar");
        btnGuardar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardar1MouseClicked(evt);
            }
        });
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 255, 204));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnGuardar1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtStockProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockProActionPerformed

    private void cmbStatusProFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbStatusProFocusGained

    }//GEN-LAST:event_cmbStatusProFocusGained

    private void cmbClasificacionProFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbClasificacionProFocusGained

    }//GEN-LAST:event_cmbClasificacionProFocusGained

    private void btnImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImagenMouseClicked
        String ruta = "";
        JFileChooser file=new JFileChooser();
        file.setDialogTitle("Cargar Imagen...");
        int seleccion = file.showSaveDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION){
            File imagen = file.getSelectedFile();
            ruta = imagen.getPath();
            rutaImagen = ruta;
            ImageIcon fot = new ImageIcon(ruta);
            Icon icono = new ImageIcon(fot.getImage().getScaledInstance(panImagen.getWidth(), panImagen.getHeight(), Image.SCALE_DEFAULT));
            JLabel etiqueta = new JLabel(icono);
            etiqueta.setSize(panImagen.getWidth(), panImagen.getHeight());
            panImagen.removeAll();
            panImagen.add(etiqueta).repaint();
        }
    }//GEN-LAST:event_btnImagenMouseClicked

    private void btnImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImagenActionPerformed

    private void jTabbedPane1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseEntered


    }//GEN-LAST:event_jTabbedPane1MouseEntered

    private void btnGuardar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardar1MouseClicked

        int con_pro;
        try{
            con_pro = Integer.parseInt(this.txtNoIdentificacionPro.getText());
        }catch(NumberFormatException e){
            con_pro = 0;
            txtNoIdentificacionPro.setText("0");
        }

        String subcat_pro = this.txtSubCategoriaPro.getText();
        String nom_pro = this.txtNombrePro.getText();
        String des_pro = this.txtDescripcionPro.getText();
        String mar_pro = this.txtMarcaPro.getText();
        String mod_pro = this.txtModeloPro.getText();
        String ser_pro = this.txtNoSeriePro.getText();
        String col_pro = this.txtColorPro.getText();
        String pla_pro = this.txtPlaca.getText().toUpperCase();
        String nomot_pro = this.txtNoMotor.getText();
        String fechcompra_pro = this.txtFechaCompraPro.getText();
        String nofact_pro = this.txtNoFacturaPro.getText();

        double imp_pro;
        try{
            imp_pro = Double.parseDouble(this.txtImportePro.getText());
        }catch(NumberFormatException e){
            imp_pro = 0;
            txtImportePro.setText("0");
        }

        if (imp_pro < 0){
            javax.swing.JOptionPane.showMessageDialog(this, "¡Opsss! No se permite que le importe sea un numero negativo.");
            return;
        }

        String obs_pro = this.txtObservacionesPro.getText();

        int stock_pro;
        try{
            stock_pro = Integer.parseInt(this.txtStockPro.getText());
        }catch(NumberFormatException e){
            stock_pro = 1;
            txtStockPro.setText("0");
        }

        int stockmin_pro;
        try{
            stockmin_pro =  Integer.parseInt(this.txtMinimoPro.getText());
        }catch(NumberFormatException e){
            stockmin_pro = 1;
            txtMinimoPro.setText("0");
        }

        if (stock_pro < 0 || stockmin_pro < 0){
            javax.swing.JOptionPane.showMessageDialog(this, "¡Opsss! No se permiten números negativos en los stocks.");
            return;
        }

        int km_pro;
        int km_ser_pro;

        try{
            km_pro =  Integer.parseInt(this.txtKilometraje.getText());
            km_ser_pro =  Integer.parseInt(this.txtKilometrajeServ.getText());
        }catch(NumberFormatException e){
            km_pro =  0;
            km_ser_pro =  0;
            txtKilometraje.setText("0");
            txtKilometrajeServ.setText("0");
        }

        //*FALTA VALIDAR LOS CMB*/
        if(this.cmbClasificacionPro.getSelectedIndex() == 0){
            javax.swing.JOptionPane.showMessageDialog(this, "¡Opsss! Seleccione una clasificación.");
            return;
        }

        if(this.cmbStatusPro.getSelectedIndex() == 0){
            javax.swing.JOptionPane.showMessageDialog(this, "¡Opsss! Seleccione un Status.");
            return;
        }
/*
        if(!MDINVENTARIOS.validarFechaFormato(fechcompra_pro)){
            javax.swing.JOptionPane.showMessageDialog(this, "¡Opsss! Fecha con formato incorrecto. El formato correcto es:  EJEM. 2017/12/31");
            return;
        }
*/
        int id_cla = BDDInventarios.selectIdCLasificacion((String)this.cmbClasificacionPro.getSelectedItem());
        int id_sta = BDDInventarios.selectIdStatus((String)this.cmbStatusPro.getSelectedItem());

        Producto produto = new Producto(0, con_pro, subcat_pro, nom_pro, des_pro, mar_pro, mod_pro, ser_pro, col_pro, pla_pro, nomot_pro, fechcompra_pro, nofact_pro, imp_pro, obs_pro, stock_pro, stockmin_pro, km_pro, km_ser_pro, id_cla, id_sta);

        MDINVENTARIOS mdinv = new MDINVENTARIOS();
        String  res = mdinv.nuevoProducto(produto);
        if(res.equals("Producto guardado con éxito.")){
            javax.swing.JOptionPane.showMessageDialog(this, res);
            if(rutaImagen != ""){
                int idpro = BDDInventarios.selectIdPro(nom_pro, nofact_pro);
                Foto foto = new Foto(0, null, idpro);
                String ft = mdinv.nuevaFoto(foto, rutaImagen);
                javax.swing.JOptionPane.showMessageDialog(this, ft);
                rutaImagen = "";
            }

            txtNoIdentificacionPro.setText("");
            txtSubCategoriaPro.setText("");
            txtNombrePro.setText("");
            txtDescripcionPro.setText("");
            txtMarcaPro.setText("");
            txtModeloPro.setText("");
            txtNoSeriePro.setText("");
            txtColorPro.setText("");
            txtPlaca.setText("");
            txtNoMotor.setText("");
            txtFechaCompraPro.setText("");
            txtNoFacturaPro.setText("");
            txtImportePro.setText("");
            txtObservacionesPro.setText("");
            txtStockPro.setText("");
            txtMinimoPro.setText("");
            txtKilometraje.setText("");
            txtKilometrajeServ.setText("");
            this.cmbClasificacionPro.setSelectedIndex(0);
            this.cmbStatusPro.setSelectedIndex(0);

        }

    }//GEN-LAST:event_btnGuardar1MouseClicked

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        interfazPrincipal.isAbiertoNuevoProducto = false;
        dispose();
    }//GEN-LAST:event_btnSalirMouseClicked

    private void cmbClasificacionProItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClasificacionProItemStateChanged
        if(this.cmbClasificacionPro.getSelectedItem().toString().trim().equals("VEHICULOS") || this.cmbClasificacionPro.getSelectedItem().toString().trim().equals("AUTOMOVILES") || this.cmbClasificacionPro.getSelectedItem().toString().trim().equals("COCHES") || this.cmbClasificacionPro.getSelectedItem().toString().trim().equals("CAMIONETAS") || this.cmbClasificacionPro.getSelectedItem().toString().trim().equals("AUTOS") || this.cmbClasificacionPro.getSelectedItem().toString().trim().equals("CARROS")) this.datosVehiculo(false);
        else this.datosVehiculo(true);
    }//GEN-LAST:event_cmbClasificacionProItemStateChanged

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
            java.util.logging.Logger.getLogger(nuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevoProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnImagen;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbClasificacionPro;
    private javax.swing.JComboBox<String> cmbStatusPro;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCaracteristicasProducto;
    private javax.swing.JLabel lblClasficPro;
    private javax.swing.JLabel lblColorPro;
    private javax.swing.JLabel lblDescripcionPro;
    private javax.swing.JLabel lblEstatusPro;
    private javax.swing.JLabel lblFechaCompraPro;
    private javax.swing.JLabel lblImportePro;
    private javax.swing.JLabel lblMarcaPro;
    private javax.swing.JLabel lblMarcoPro1;
    private javax.swing.JLabel lblMarcoPro2;
    private javax.swing.JLabel lblMarcoProAdquisiicion;
    private javax.swing.JLabel lblMinimoPro;
    private javax.swing.JLabel lblModeloPro;
    private javax.swing.JLabel lblNombrePro;
    private javax.swing.JLabel lblNumFacturaPro;
    private javax.swing.JLabel lblNumIdentificacionPro;
    private javax.swing.JLabel lblNumSeriePro;
    private javax.swing.JLabel lblObservPro;
    private javax.swing.JLabel lblStockPro;
    private javax.swing.JLabel lblSubCatPro;
    private javax.swing.JPanel panImagen;
    private javax.swing.JPanel panelDatosVehiculo;
    private javax.swing.JTextField txtColorPro;
    private javax.swing.JTextArea txtDescripcionPro;
    private javax.swing.JTextField txtFechaCompraPro;
    private javax.swing.JTextField txtImportePro;
    private javax.swing.JTextField txtKilometraje;
    private javax.swing.JTextField txtKilometrajeServ;
    private javax.swing.JTextField txtMarcaPro;
    private javax.swing.JTextField txtMinimoPro;
    private javax.swing.JTextField txtModeloPro;
    private javax.swing.JTextField txtNoFacturaPro;
    private javax.swing.JTextField txtNoIdentificacionPro;
    private javax.swing.JTextField txtNoMotor;
    private javax.swing.JTextField txtNoSeriePro;
    private javax.swing.JTextField txtNombrePro;
    private javax.swing.JTextArea txtObservacionesPro;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtStockPro;
    private javax.swing.JTextField txtSubCategoriaPro;
    // End of variables declaration//GEN-END:variables
}
