/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDINVENTARIOS.VISTAS;

import MDINVENTARIOS.CONTROLADORES.BDDInventarios;
import MDINVENTARIOS.CONTROLADORES.MDINVENTARIOS;
import MDINVENTARIOS.MODELOS.Asignacion;
import MDINVENTARIOS.MODELOS.Movimiento;
import MDINVENTARIOS.MODELOS.Producto;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author brula
 */
public class realizarAsignacion extends javax.swing.JFrame {
    
    private ArrayList<Producto> productosSelec;

    /**
     * Creates new form realizarAsignacion
     */
    public realizarAsignacion(ArrayList<Producto> productosSelec) {
        initComponents();
        this.productosSelec = productosSelec;
        cargarTabla();
        llenarListaSeleccionados();
    }
    
    
    public boolean cargarTabla(){
        // Esta lista contiene los nombres que se mostrarán en el encabezado de cada columna de la grilla
        String[] columnas = new String[]{"Area","Puesto","Nombre","Apellido paterno","Apellido materno",""};

        // Estos son los tipos de datos de cada columna de la lista
        final Class[] tiposColumnas = new Class[]{
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            JButton.class // <- noten que aquí se especifica que la última columna es un botón
        };

        // Agrego los registros que contendrá la grilla.
        // Observen que el último campo es un botón
        ArrayList<String[]> arrayDatos = BDDInventarios.selectTablaPersonas();
        Object[][] temp = new Object[arrayDatos.size()][9];
        for(int x = 0; x < arrayDatos.size(); x++ ){
            String[] datos = arrayDatos.get(x);
            //temp[x][0] = datos[0];
            temp[x][0] = datos[0];
            temp[x][1] = datos[1];
            temp[x][2] = datos[2];
            temp[x][3] = datos[3];
            temp[x][4] = datos[4];
            temp[x][5] = new JButton("Asignar");
        }
        Object[][] datos = temp;

        // Defino el TableModel y le indico los datos y nombres de columnas
        tablaPersonal.setModel(new javax.swing.table.DefaultTableModel(
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
            tablaPersonal.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }

        });

        /**
         * Por último, agregamos un listener que nos permita saber cuando fue pulsada la celda que contiene el botón.
         */
        tablaPersonal.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = tablaPersonal.rowAtPoint(e.getPoint());
                int columna = tablaPersonal.columnAtPoint(e.getPoint());

                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el botón, si tuviéramos más de un botón 
                 * por fila tendríamos que además preguntar por el contenido del botón o el nombre de la columna
                 */
                if (tablaPersonal.getModel().getColumnClass(columna).equals(JButton.class)) {
                   /*ASIGNAR*/   
                   int id_per = BDDInventarios.buscarIdPersona(tablaPersonal.getModel().getValueAt(fila, 2).toString(),tablaPersonal.getModel().getValueAt(fila, 3).toString(),tablaPersonal.getModel().getValueAt(fila, 4).toString());
                   
                   if (id_per != 0){
                       Movimiento movimiento = new Movimiento(0, BDDInventarios.fechaActual(), true, "", id_per);
                       
                       MDINVENTARIOS trabajar = new MDINVENTARIOS();
                       String respuesta = trabajar.nuevoMovimiento(movimiento);
                       
                       javax.swing.JOptionPane.showMessageDialog(null, respuesta);
                       if(respuesta.equals("Movimiento guardado con éxito.")){
                           int id_mov = BDDInventarios.buscarIdMovimiento(BDDInventarios.fechaActual(), id_per);
                           
                           if (id_mov != 0){
                               for(int i=0; i < productosSelec.size(); i++){
                                   Producto pro = BDDInventarios.selectProductoFiltrado(productosSelec.get(i).getNom_pro(),productosSelec.get(i).getMar_pro(),productosSelec.get(i).getMod_pro());
                                   Asignacion temp = new Asignacion(0, id_mov, pro.getId_pro(), productosSelec.get(i).getCantidad());
                                   if(trabajar.nuevaAsignacion(temp).equals("Asignación guardada con éxito.")){
                                       BDDInventarios.updateStockPro(pro.getId_pro(), productosSelec.get(i).getCantidad());
                                   }
                               }
                               javax.swing.JOptionPane.showMessageDialog(null, "Asignación guardada con éxito.");
                               dispose();
                           }else{
                               javax.swing.JOptionPane.showMessageDialog(null, "No se encontro el nuevo movimiento.");
                           }
                       }else{
                           javax.swing.JOptionPane.showMessageDialog(null, "No se pudo crear el nuevo movimiento.");
                       }
                       
                   }else{
                       javax.swing.JOptionPane.showMessageDialog(null, "Ocurrió algo, no se pudo realizar la asignación.");
                   }
                }
            }

         
        });
        return true;
    }//cargarTablas
    
    public boolean cargarTabla(String texto){
        // Esta lista contiene los nombres que se mostrarán en el encabezado de cada columna de la grilla
        String[] columnas = new String[]{"Area","Puesto","Nombre","Apellido paterno","Apellido materno",""};

        // Estos son los tipos de datos de cada columna de la lista
        final Class[] tiposColumnas = new Class[]{
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            JButton.class // <- noten que aquí se especifica que la última columna es un botón
        };

        // Agrego los registros que contendrá la grilla.
        // Observen que el último campo es un botón
        ArrayList<String[]> arrayDatos = BDDInventarios.selectTablaPersonas(texto);
        Object[][] temp = new Object[arrayDatos.size()][9];
        for(int x = 0; x < arrayDatos.size(); x++ ){
            String[] datos = arrayDatos.get(x);
            //temp[x][0] = datos[0];
            temp[x][0] = datos[0];
            temp[x][1] = datos[1];
            temp[x][2] = datos[2];
            temp[x][3] = datos[3];
            temp[x][4] = datos[4];
            temp[x][5] = new JButton("Asignar");
        }
        Object[][] datos = temp;

        // Defino el TableModel y le indico los datos y nombres de columnas
        tablaPersonal.setModel(new javax.swing.table.DefaultTableModel(
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
            tablaPersonal.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }

        });

        /**
         * Por último, agregamos un listener que nos permita saber cuando fue pulsada la celda que contiene el botón.
         */
        tablaPersonal.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = tablaPersonal.rowAtPoint(e.getPoint());
                int columna = tablaPersonal.columnAtPoint(e.getPoint());

                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el botón, si tuviéramos más de un botón 
                 * por fila tendríamos que además preguntar por el contenido del botón o el nombre de la columna
                 */
                if (tablaPersonal.getModel().getColumnClass(columna).equals(JButton.class)) {
                    /*ASIGNAR*/   
                   int id_per = BDDInventarios.buscarIdPersona(tablaPersonal.getModel().getValueAt(fila, 2).toString(),tablaPersonal.getModel().getValueAt(fila, 3).toString(),tablaPersonal.getModel().getValueAt(fila, 4).toString());
                   
                   if (id_per != 0){
                       Movimiento movimiento = new Movimiento(0, BDDInventarios.fechaActual(), true, "", id_per);
                       
                       MDINVENTARIOS trabajar = new MDINVENTARIOS();
                       String respuesta = trabajar.nuevoMovimiento(movimiento);
                       
                       javax.swing.JOptionPane.showMessageDialog(null, respuesta);
                       if(respuesta.equals("Movimiento guardado con éxito.")){
                           int id_mov = BDDInventarios.buscarIdMovimiento(BDDInventarios.fechaActual(), id_per);
                           
                           if (id_mov != 0){
                               for(int i=0; i < productosSelec.size(); i++){
                                   Producto pro = BDDInventarios.selectProductoFiltrado(productosSelec.get(i).getNom_pro(),productosSelec.get(i).getMar_pro(),productosSelec.get(i).getMod_pro());
                                   Asignacion temp = new Asignacion(0, id_mov, pro.getId_pro(), productosSelec.get(i).getCantidad());
                                   if(trabajar.nuevaAsignacion(temp).equals("Asignación guardada con éxito.")){
                                       BDDInventarios.updateStockPro(pro.getId_pro(), productosSelec.get(i).getCantidad());
                                   }
                               }
                               javax.swing.JOptionPane.showMessageDialog(null, "Asignación guardada con éxito.");
                               dispose();
                           }else{
                               javax.swing.JOptionPane.showMessageDialog(null, "No se encontro el nuevo movimiento.");
                           }
                       }else{
                           javax.swing.JOptionPane.showMessageDialog(null, "No se pudo crear el nuevo movimiento.");
                       }
                       
                   }else{
                       javax.swing.JOptionPane.showMessageDialog(null, "Ocurrió algo, no se pudo realizar la asignación.");
                   }
                }
            }

         
        });
        return true;
    }//cargarTablas
    
    public void llenarListaSeleccionados(){
        DefaultListModel modelo = new DefaultListModel();
        ArrayList<Producto> arrayProductos = this.productosSelec;
        for(int i = 0; i < arrayProductos.size(); i++){
            ///////////////////*AGREGAR BUSQUEDA DE  PRODUCTOS QUE YA FUERON SELECCIONADOS*/
            Producto temp = arrayProductos.get(i);
            modelo.addElement("Nombre: "+temp.getNom_pro()+" - "+"Marca: "+temp.getMar_pro()+" - "+"Modelo: "+temp.getMod_pro()+" - "+"Cuantos: "+temp.getCantidad());
        }
        this.listaSeleccionados.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaSeleccionados = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnTodos = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaPersonal = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        listaSeleccionados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listaSeleccionados);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personal:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        txtBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarMouseClicked(evt);
            }
        });
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        btnTodos.setBackground(new java.awt.Color(255, 255, 204));
        btnTodos.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/actualizar.png"))); // NOI18N
        btnTodos.setText("Actualizar");
        btnTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTodosMouseClicked(evt);
            }
        });

        tablaPersonal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tablaPersonal);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTodos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTodos))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                .addContainerGap())
        );

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnTodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTodosMouseClicked
        cargarTabla();
        txtBuscar.setText("");
    }//GEN-LAST:event_btnTodosMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        int decision=showConfirmDialog(this,"¿Esta seguro que desea salir?");
        if(decision==0){
            dispose();
        }//DECISION
    }//GEN-LAST:event_btnSalirMouseClicked

    private void txtBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarMouseClicked
        
    }//GEN-LAST:event_txtBuscarMouseClicked

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if(txtBuscar.getText().length() > 1) cargarTabla(this.txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTodos;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listaSeleccionados;
    private javax.swing.JTable tablaPersonal;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
