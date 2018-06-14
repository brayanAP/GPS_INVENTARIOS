
package MDINVENTARIOS.VISTAS;

import MD.GENERALES.VISTAS.interfazPrincipal;
import MDINVENTARIOS.CONTROLADORES.BDDInventarios;
import MDINVENTARIOS.MODELOS.Clasificacion;
import MDINVENTARIOS.MODELOS.Producto;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author brula
 */
public class nuevaAsignacion extends javax.swing.JFrame {
    
    ArrayList<Producto> productosSelec;

    /**
     * Creates new form nuevaAsignacion
     */
    public nuevaAsignacion() {
        initComponents();
       
        productosSelec = new ArrayList<Producto>();
        this.cmbClasificacion.removeAll();
        
        ArrayList<Clasificacion> arrayCla = BDDInventarios.selectClasificaciones();
        for(int i = 0; i < arrayCla.size(); i++){
            this.cmbClasificacion.addItem(arrayCla.get(i).getNom_clas());
        }
        
        cargarTabla();
    }
    
    public boolean cargarTabla(){
        // Esta lista contiene los nombres que se mostrarán en el encabezado de cada columna de la grilla
        String[] columnas = new String[]{"Nombre","Marca","Modelo","Serie","Stock","Stock Min.",""};

        // Estos son los tipos de datos de cada columna de la lista
        final Class[] tiposColumnas = new Class[]{
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            JButton.class // <- noten que aquí se especifica que la última columna es un botón
        };

        // Agrego los registros que contendrá la grilla.
        // Observen que el último campo es un botón
        ArrayList<String[]> arrayDatos = BDDInventarios.selectTablaInventarios();
        Object[][] temp = new Object[arrayDatos.size()][9];
        for(int x = 0; x < arrayDatos.size(); x++ ){
            String[] datos = arrayDatos.get(x);
            //temp[x][0] = datos[0];
            temp[x][0] = datos[1];
            temp[x][1] = datos[2];
            temp[x][2] = datos[3];
            temp[x][3] = datos[4];
            temp[x][4] = datos[5];
            temp[x][5] = datos[6];
            temp[x][6] = new JButton("Agregar");
        }
        Object[][] datos = temp;

        // Defino el TableModel y le indico los datos y nombres de columnas
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
            tablaProductos.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }

        });

        /**
         * Por último, agregamos un listener que nos permita saber cuando fue pulsada la celda que contiene el botón.
         */
        tablaProductos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = tablaProductos.rowAtPoint(e.getPoint());
                int columna = tablaProductos.columnAtPoint(e.getPoint());

                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el botón, si tuviéramos más de un botón 
                 * por fila tendríamos que además preguntar por el contenido del botón o el nombre de la columna
                 */
                if (tablaProductos.getModel().getColumnClass(columna).equals(JButton.class)) {
                    int cantidad = 0;
                    
                    if(buscarSeleccionado(tablaProductos.getModel().getValueAt(fila, 0).toString(),tablaProductos.getModel().getValueAt(fila, 1).toString(),tablaProductos.getModel().getValueAt(fila, 2).toString())){
                        try{
                            cantidad = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("¿Qué cantidad?"));
                            if (cantidad < 0) cantidad = 1;
                            
                            if (Integer.parseInt(tablaProductos.getModel().getValueAt(fila, 4).toString()) != 0){
                                if (Integer.parseInt(tablaProductos.getModel().getValueAt(fila, 4).toString()) > cantidad) cantidad = 1;
                                else{
                                    javax.swing.JOptionPane.showMessageDialog(null, "Producto sin stock.");
                                    return;
                                }
                            }else{
                                javax.swing.JOptionPane.showMessageDialog(null, "Producto sin stock.");
                                return;
                            }
                            
                        }catch(NumberFormatException ee){
                              if (Integer.parseInt(tablaProductos.getModel().getValueAt(fila, 4).toString()) != 0) cantidad = 1;
                              else{
                                  javax.swing.JOptionPane.showMessageDialog(null, "Producto sin stock.");
                                  return;
                              }
                        }

                        productosSelec.add(new Producto(tablaProductos.getModel().getValueAt(fila, 0).toString(),tablaProductos.getModel().getValueAt(fila, 1).toString(),tablaProductos.getModel().getValueAt(fila, 2).toString(),cantidad,Integer.parseInt(tablaProductos.getModel().getValueAt(fila, 4).toString())));
                        llenarListaSeleccionados();   
                    }else{
                        javax.swing.JOptionPane.showMessageDialog(null, "Producto ya seleccionado.");
                    }
                    
                }
            }

         
        });
        return true;
    }//cargarTablas
    
    public boolean cargarTabla(String texto){
        // Esta lista contiene los nombres que se mostrarán en el encabezado de cada columna de la grilla
        String[] columnas = new String[]{"Nombre","Marca","Modelo","Serie","Stock","Stock Min.",""};

        // Estos son los tipos de datos de cada columna de la lista
        final Class[] tiposColumnas = new Class[]{
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            JButton.class // <- noten que aquí se especifica que la última columna es un botón
        };

        // Agrego los registros que contendrá la grilla.
        // Observen que el último campo es un botón
        ArrayList<String[]> arrayDatos = BDDInventarios.selectTablaInventarios(texto);
        Object[][] temp = new Object[arrayDatos.size()][9];
        for(int x = 0; x < arrayDatos.size(); x++ ){
            String[] datos = arrayDatos.get(x);
            //temp[x][0] = datos[0];
            temp[x][0] = datos[1];
            temp[x][1] = datos[2];
            temp[x][2] = datos[3];
            temp[x][3] = datos[4];
            temp[x][4] = datos[5];
            temp[x][5] = datos[6];
            temp[x][6] = new JButton("Agregar");
        }
        Object[][] datos = temp;

        // Defino el TableModel y le indico los datos y nombres de columnas
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
            tablaProductos.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }

        });

        /**
         * Por último, agregamos un listener que nos permita saber cuando fue pulsada la celda que contiene el botón.
         */
        tablaProductos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = tablaProductos.rowAtPoint(e.getPoint());
                int columna = tablaProductos.columnAtPoint(e.getPoint());

                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el botón, si tuviéramos más de un botón 
                 * por fila tendríamos que además preguntar por el contenido del botón o el nombre de la columna
                 */
                if (tablaProductos.getModel().getColumnClass(columna).equals(JButton.class)) {
                    int cantidad = 0;
                    
                    if(buscarSeleccionado(tablaProductos.getModel().getValueAt(fila, 0).toString(),tablaProductos.getModel().getValueAt(fila, 1).toString(),tablaProductos.getModel().getValueAt(fila, 2).toString())){
                        try{
                            cantidad = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("¿Qué cantidad?"));
                            if (cantidad < 0) cantidad = 1;
                            
                            if (Integer.parseInt(tablaProductos.getModel().getValueAt(fila, 4).toString()) != 0){
                                if (Integer.parseInt(tablaProductos.getModel().getValueAt(fila, 4).toString()) > cantidad) cantidad = 1;
                                else{
                                    javax.swing.JOptionPane.showMessageDialog(null, "Producto sin stock.");
                                    return;
                                }
                            }else{
                                javax.swing.JOptionPane.showMessageDialog(null, "Producto sin stock.");
                                return;
                            }
                            
                        }catch(NumberFormatException ee){
                              if (Integer.parseInt(tablaProductos.getModel().getValueAt(fila, 4).toString()) != 0) cantidad = 1;
                              else{
                                  javax.swing.JOptionPane.showMessageDialog(null, "Producto sin stock.");
                                  return;
                              }
                        }

                        productosSelec.add(new Producto(tablaProductos.getModel().getValueAt(fila, 0).toString(),tablaProductos.getModel().getValueAt(fila, 1).toString(),tablaProductos.getModel().getValueAt(fila, 2).toString(),cantidad,Integer.parseInt(tablaProductos.getModel().getValueAt(fila, 4).toString())));
                        llenarListaSeleccionados();   
                    }else{
                        javax.swing.JOptionPane.showMessageDialog(null, "Producto ya seleccionado.");
                    }
                    
                }
            }

         
        });
        return true;
    }//cargarTablas
    
    public boolean cargarTablaa(String clasificacion){
        // Esta lista contiene los nombres que se mostrarán en el encabezado de cada columna de la grilla
        String[] columnas = new String[]{"Nombre","Marca","Modelo","Serie","Stock","Stock Min.",""};

        // Estos son los tipos de datos de cada columna de la lista
        final Class[] tiposColumnas = new Class[]{
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            JButton.class // <- noten que aquí se especifica que la última columna es un botón
        };

        // Agrego los registros que contendrá la grilla.
        // Observen que el último campo es un botón
        ArrayList<String[]> arrayDatos = BDDInventarios.selectTablaInventarioss(clasificacion);
        Object[][] temp = new Object[arrayDatos.size()][9];
        for(int x = 0; x < arrayDatos.size(); x++ ){
            String[] datos = arrayDatos.get(x);
            //temp[x][0] = datos[0];
            temp[x][0] = datos[1];
            temp[x][1] = datos[2];
            temp[x][2] = datos[3];
            temp[x][3] = datos[4];
            temp[x][4] = datos[5];
            temp[x][5] = datos[6];
            temp[x][6] = new JButton("Agregar");
        }
        Object[][] datos = temp;

        // Defino el TableModel y le indico los datos y nombres de columnas
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
            tablaProductos.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }

        });

        /**
         * Por último, agregamos un listener que nos permita saber cuando fue pulsada la celda que contiene el botón.
         */
        tablaProductos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = tablaProductos.rowAtPoint(e.getPoint());
                int columna = tablaProductos.columnAtPoint(e.getPoint());

                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el botón, si tuviéramos más de un botón 
                 * por fila tendríamos que además preguntar por el contenido del botón o el nombre de la columna
                 */
                if (tablaProductos.getModel().getColumnClass(columna).equals(JButton.class)) {
                    int cantidad = 0;
                    
                    if(buscarSeleccionado(tablaProductos.getModel().getValueAt(fila, 0).toString(),tablaProductos.getModel().getValueAt(fila, 1).toString(),tablaProductos.getModel().getValueAt(fila, 2).toString())){
                        try{
                            cantidad = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("¿Qué cantidad?"));
                            if (cantidad < 0) cantidad = 1;
                            
                            if (Integer.parseInt(tablaProductos.getModel().getValueAt(fila, 4).toString()) != 0){
                                if (Integer.parseInt(tablaProductos.getModel().getValueAt(fila, 4).toString()) > cantidad) cantidad = 1;
                                else{
                                    javax.swing.JOptionPane.showMessageDialog(null, "Producto sin stock.");
                                    return;
                                }
                            }else{
                                javax.swing.JOptionPane.showMessageDialog(null, "Producto sin stock.");
                                return;
                            }
                            
                        }catch(NumberFormatException ee){
                              if (Integer.parseInt(tablaProductos.getModel().getValueAt(fila, 4).toString()) != 0) cantidad = 1;
                              else{
                                  javax.swing.JOptionPane.showMessageDialog(null, "Producto sin stock.");
                                  return;
                              }
                        }

                        productosSelec.add(new Producto(tablaProductos.getModel().getValueAt(fila, 0).toString(),tablaProductos.getModel().getValueAt(fila, 1).toString(),tablaProductos.getModel().getValueAt(fila, 2).toString(),cantidad,Integer.parseInt(tablaProductos.getModel().getValueAt(fila, 4).toString())));
                        llenarListaSeleccionados();   
                    }else{
                        javax.swing.JOptionPane.showMessageDialog(null, "Producto ya seleccionado.");
                    }
                    
                }
            }

         
        });
        return true;
    }//cargarTablas
    
    
    public boolean buscarSeleccionado(String nombre, String marca, String modelo){
        for(int i= 0; i < this.productosSelec.size(); i++){
            if (this.productosSelec.get(i).getNom_pro().trim().equals(nombre) && this.productosSelec.get(i).getMar_pro().trim().equals(marca) && this.productosSelec.get(i).getMod_pro().trim().equals(modelo)){
                return false;
            }
        }
        return true;
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
        cmbClasificacion = new javax.swing.JComboBox<>();
        txtBuscarProducto = new javax.swing.JTextField();
        btnTodos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaSeleccionados = new javax.swing.JList<>();
        btnQuitar = new javax.swing.JButton();
        btnEditarCantidad = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        cmbClasificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar por Clasificación" }));
        cmbClasificacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClasificacionItemStateChanged(evt);
            }
        });

        txtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarProductoKeyPressed(evt);
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
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });

        tablaProductos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaProductos.setAlignmentY(1.0F);
        tablaProductos.setMinimumSize(new java.awt.Dimension(60, 100));
        tablaProductos.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(tablaProductos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTodos)
                        .addGap(0, 143, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTodos))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tomados:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        listaSeleccionados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        listaSeleccionados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaSeleccionados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaSeleccionadosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listaSeleccionados);

        btnQuitar.setBackground(new java.awt.Color(255, 255, 204));
        btnQuitar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/quitar.png"))); // NOI18N
        btnQuitar.setText("Quitar Producto");
        btnQuitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuitarMouseClicked(evt);
            }
        });

        btnEditarCantidad.setBackground(new java.awt.Color(255, 255, 204));
        btnEditarCantidad.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnEditarCantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/editar.png"))); // NOI18N
        btnEditarCantidad.setText("Editar Cantidad");
        btnEditarCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarCantidadMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnEditarCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQuitar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuitar)
                    .addComponent(btnEditarCantidad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        btnGuardar.setBackground(new java.awt.Color(255, 255, 204));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/nuevaasigna.png"))); // NOI18N
        btnGuardar.setText("ASIGNAR");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTodosActionPerformed

    private void listaSeleccionadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaSeleccionadosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listaSeleccionadosMouseClicked

    private void btnQuitarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuitarMouseClicked
      
        try {
            DefaultListModel modeloLista = (DefaultListModel)listaSeleccionados.getModel();
            int index =  this.listaSeleccionados.getSelectedIndex();
            String datos = (String) modeloLista.getElementAt(index);

            String[] temp = datos.split(" - ");
            String nombre = temp[0].substring(7, temp[0].length()).trim();
            String marca = temp[1].substring(6, temp[1].length()).trim();
            String modelo = temp[2].substring(7, temp[2].length()).trim();

            for(int i= 0; i < this.productosSelec.size(); i++){
                if (this.productosSelec.get(i).getNom_pro().equals(nombre) && this.productosSelec.get(i).getMar_pro().equals(marca) && this.productosSelec.get(i).getMod_pro().equals(modelo)){
                    productosSelec.remove(i);
                    break;
                }
            }
            llenarListaSeleccionados();
            
        }catch(Exception ee){
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione un producto.");
        }
    }//GEN-LAST:event_btnQuitarMouseClicked

    private void btnEditarCantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarCantidadMouseClicked
        try {
            DefaultListModel modeloLista = (DefaultListModel)listaSeleccionados.getModel();
            int index =  this.listaSeleccionados.getSelectedIndex();
            String datos = (String) modeloLista.getElementAt(index);

            String[] temp = datos.split(" - ");
            String nombre = temp[0].substring(7, temp[0].length()).trim();
            String marca = temp[1].substring(6, temp[1].length()).trim();
            String modelo = temp[2].substring(7, temp[2].length()).trim();

            for(int i= 0; i < this.productosSelec.size(); i++){
                if (this.productosSelec.get(i).getNom_pro().equals(nombre) && this.productosSelec.get(i).getMar_pro().equals(marca) && this.productosSelec.get(i).getMod_pro().equals(modelo)){
                    int cantidad;
                    try{
                        cantidad = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("¿Qué cantidad?"));
                        if (cantidad < 0) cantidad = 1;
                    }catch(NumberFormatException ee){
                            cantidad = 1;
                    }
                    
                    if(cantidad > productosSelec.get(i).getStock()){
                        javax.swing.JOptionPane.showMessageDialog(null, "Producto sin stock.");
                        cantidad = 0;
                    }else{
                        productosSelec.get(i).setCantidad(cantidad);
                    }
                    break;
                }
            }
            llenarListaSeleccionados();
            
        }catch(Exception ee){
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione un producto.");
        }
    }//GEN-LAST:event_btnEditarCantidadMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        interfazPrincipal.isAbiertoAsignacion = false;
        dispose();
        
    }//GEN-LAST:event_btnSalirMouseClicked

    private void cmbClasificacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClasificacionItemStateChanged
        int eleccion = this.cmbClasificacion.getSelectedIndex();
        if (!(eleccion == 0)){
           cargarTablaa(this.cmbClasificacion.getItemAt(eleccion));
        }else{
            cargarTabla();
        }
    }//GEN-LAST:event_cmbClasificacionItemStateChanged

    private void btnTodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTodosMouseClicked
        cargarTabla();
        cmbClasificacion.setSelectedIndex(0);
        txtBuscarProducto.setText("");
    }//GEN-LAST:event_btnTodosMouseClicked

    private void txtBuscarProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyPressed
        if(txtBuscarProducto.getText().length() > 1) cargarTabla(this.txtBuscarProducto.getText());
    }//GEN-LAST:event_txtBuscarProductoKeyPressed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        int decision=showConfirmDialog(this,"¿Está seguro que quiere asignar los productos?");
        if(decision==0){
            if(productosSelec.size() > 0){
                realizarAsignacion vent = new realizarAsignacion(productosSelec);
                vent.setLocationRelativeTo(null);
                vent.setVisible(true);
                this.dispose();
            }else{
                javax.swing.JOptionPane.showMessageDialog(this, "No ha tomado ningún producto.");
            }
        }//DECISION
            
        
    }//GEN-LAST:event_btnGuardarMouseClicked

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
            java.util.logging.Logger.getLogger(nuevaAsignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nuevaAsignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nuevaAsignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nuevaAsignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevaAsignacion().setVisible(true);
            }
        });
    }
    

    
  
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarCantidad;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTodos;
    private javax.swing.JComboBox<String> cmbClasificacion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listaSeleccionados;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtBuscarProducto;
    // End of variables declaration//GEN-END:variables
}
