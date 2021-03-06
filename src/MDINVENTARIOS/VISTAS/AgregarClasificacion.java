/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDINVENTARIOS.VISTAS;

import MDINVENTARIOS.CONTROLADORES.BDDInventarios;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author brula
 */
public class AgregarClasificacion extends javax.swing.JFrame {
    public static boolean isAbiertoDetallesClasificacion = false;
    /**
     * Creates new form AgregarClasificacion
     */
    public AgregarClasificacion() {
        this.setUndecorated(true);
        initComponents();
        cargarTabla();
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
        txtBuscarClasificacion = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClasificaciones = new javax.swing.JTable();
        btnNuevaClasificacion = new javax.swing.JButton();
        btnMostrarTodos = new javax.swing.JButton();
        btnSalirClasificacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Clasificaciones:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        txtBuscarClasificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarClasificacionKeyPressed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(255, 255, 204));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        tablaClasificaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaClasificaciones);

        btnNuevaClasificacion.setBackground(new java.awt.Color(255, 255, 204));
        btnNuevaClasificacion.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnNuevaClasificacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/guardar.png"))); // NOI18N
        btnNuevaClasificacion.setText("Nueva");
        btnNuevaClasificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevaClasificacionMouseClicked(evt);
            }
        });

        btnMostrarTodos.setBackground(new java.awt.Color(255, 255, 204));
        btnMostrarTodos.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnMostrarTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/actualizar.png"))); // NOI18N
        btnMostrarTodos.setText("Actualizar");
        btnMostrarTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMostrarTodosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBuscarClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(31, 31, 31)
                        .addComponent(btnMostrarTodos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNuevaClasificacion)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnNuevaClasificacion)
                    .addComponent(btnMostrarTodos))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSalirClasificacion.setBackground(new java.awt.Color(255, 255, 204));
        btnSalirClasificacion.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSalirClasificacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/salir.png"))); // NOI18N
        btnSalirClasificacion.setText("Salir");
        btnSalirClasificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirClasificacionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalirClasificacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalirClasificacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirClasificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirClasificacionMouseClicked

        dispose();
    }//GEN-LAST:event_btnSalirClasificacionMouseClicked

    private void btnNuevaClasificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevaClasificacionMouseClicked
        nuevaClasificacion vent = new nuevaClasificacion();
        vent.setLocationRelativeTo(null);
        vent.setVisible(true);
    }//GEN-LAST:event_btnNuevaClasificacionMouseClicked

    private void btnMostrarTodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarTodosMouseClicked
        cargarTabla();
        txtBuscarClasificacion.setText("");
    }//GEN-LAST:event_btnMostrarTodosMouseClicked

    private void txtBuscarClasificacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarClasificacionKeyPressed
        if(this.txtBuscarClasificacion.getText().length() >= 1) cargarTabla(this.txtBuscarClasificacion.getText());
    }//GEN-LAST:event_txtBuscarClasificacionKeyPressed

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        cargarTabla(this.txtBuscarClasificacion.getText());
    }//GEN-LAST:event_btnBuscarMouseClicked
    
    public boolean cargarTabla(){
        String[] columnas = new String[]{"Folio","Nombre","¿Genera Stock?","Trabajar"};

        final Class[] tiposColumnas = new Class[]{
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            JButton.class
    
        };

        ArrayList<String[]> arrayDatos = BDDInventarios.selectTablaClasificaciones();
        Object[][] temp = new Object[arrayDatos.size()][9];
        for(int x = 0; x < arrayDatos.size(); x++ ){
            String[] datos = arrayDatos.get(x);
            temp[x][0] = datos[0];
            temp[x][1] = datos[1];
            temp[x][2] = datos[2];
            temp[x][3] = new JButton("Detalles");
        }
        Object[][] datos = temp;

        // Defino el TableModel y le indico los datos y nombres de columnas
        tablaClasificaciones.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                columnas) {
            // Esta variable nos permite conocer de antemano los tipos de datos de cada columna, dentro del TableModel
            Class[] tipos = tiposColumnas;

            @Override
            public Class getColumnClass(int columnIndex) {
                // Este método es invocado por el CellRenderer para saber que dibujar en la celda,
                // observen que estamos retornando la clase que definimos de antemano.
                return tipos[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                // Sobrescribimos este método para evitar que la columna que contiene los botones sea editada.
                return !(this.getColumnClass(column).equals(JButton.class));
            }
        });

        // El objetivo de la siguiente línea es indicar el CellRenderer que será utilizado para dibujar el botón
            tablaClasificaciones.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }

        });
            
        tablaClasificaciones.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = tablaClasificaciones.rowAtPoint(e.getPoint());
                int columna = tablaClasificaciones.columnAtPoint(e.getPoint());

                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el botón, si tuviéramos más de un botón 
                 * por fila tendríamos que además preguntar por el contenido del botón o el nombre de la columna
                 */
                if (tablaClasificaciones.getModel().getColumnClass(columna).equals(JButton.class)) {
                    
                    /*ABRIR OTRO JFRAME*/
                    if(isAbiertoDetallesClasificacion == false){
                        detallesClasificacion vent = new detallesClasificacion(tablaClasificaciones.getModel().getValueAt(fila, 0).toString(),tablaClasificaciones.getModel().getValueAt(fila, 1).toString());
                        vent.setLocationRelativeTo(null);
                        vent.setVisible(true);
                        isAbiertoDetallesClasificacion = true;
                    }
                    
                }
            }

         
        });
        return true;
    }//cargarTablas
    
    public boolean cargarTabla(String texto){
        String[] columnas = new String[]{"Folio","Nombre","¿Genera Stock?","Trabajar"};

        final Class[] tiposColumnas = new Class[]{
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            JButton.class
    
        };

        ArrayList<String[]> arrayDatos = BDDInventarios.selectTablaClasificaciones(texto);
        Object[][] temp = new Object[arrayDatos.size()][9];
        for(int x = 0; x < arrayDatos.size(); x++ ){
            String[] datos = arrayDatos.get(x);
            temp[x][0] = datos[0];
            temp[x][1] = datos[1];
            temp[x][2] = datos[2];
            temp[x][3] = new JButton("Detalles");
        }
        Object[][] datos = temp;

        // Defino el TableModel y le indico los datos y nombres de columnas
        tablaClasificaciones.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                columnas) {
            // Esta variable nos permite conocer de antemano los tipos de datos de cada columna, dentro del TableModel
            Class[] tipos = tiposColumnas;

            @Override
            public Class getColumnClass(int columnIndex) {
                // Este método es invocado por el CellRenderer para saber que dibujar en la celda,
                // observen que estamos retornando la clase que definimos de antemano.
                return tipos[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                // Sobrescribimos este método para evitar que la columna que contiene los botones sea editada.
                return !(this.getColumnClass(column).equals(JButton.class));
            }
        });

        // El objetivo de la siguiente línea es indicar el CellRenderer que será utilizado para dibujar el botón
            tablaClasificaciones.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }

        });
            
        tablaClasificaciones.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = tablaClasificaciones.rowAtPoint(e.getPoint());
                int columna = tablaClasificaciones.columnAtPoint(e.getPoint());

                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el botón, si tuviéramos más de un botón 
                 * por fila tendríamos que además preguntar por el contenido del botón o el nombre de la columna
                 */
                if (tablaClasificaciones.getModel().getColumnClass(columna).equals(JButton.class)) {
                    
                    /*ABRIR OTRO JFRAME*/
                    if(isAbiertoDetallesClasificacion == false){
                        detallesClasificacion vent = new detallesClasificacion(tablaClasificaciones.getModel().getValueAt(fila, 0).toString(),tablaClasificaciones.getModel().getValueAt(fila, 1).toString());
                        vent.setLocationRelativeTo(null);
                        vent.setVisible(true);
                        isAbiertoDetallesClasificacion = true;
                    }
                    
                }
            }

         
        });
        return true;
    }//cargarTablas
    
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
            java.util.logging.Logger.getLogger(AgregarClasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarClasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarClasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarClasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarClasificacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnMostrarTodos;
    private javax.swing.JButton btnNuevaClasificacion;
    private javax.swing.JButton btnSalirClasificacion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaClasificaciones;
    private javax.swing.JTextField txtBuscarClasificacion;
    // End of variables declaration//GEN-END:variables
}
