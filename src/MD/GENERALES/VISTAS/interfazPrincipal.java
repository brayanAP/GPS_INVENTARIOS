package MD.GENERALES.VISTAS;
import java.awt.Image;
import java.awt.Toolkit;
import static javax.swing.JOptionPane.showConfirmDialog;
import MD.PERSONAL.VISTAS.*;
import MD.USUARIOSYPERMISOS.VISTAS.InterfazEliminarUsuarios;
import MD.USUARIOSYPERMISOS.VISTAS.InterfazRegistroUsuarios;
import MDINVENTARIOS.CONTROLADORES.*;
import MDINVENTARIOS.MODELOS.*;
import MDINVENTARIOS.VISTAS.*;
import MDPERSONAL.CONTROLADORES.*;
import MDUSUARIOS.CONTROLADORES.BDUSUARIOS;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableCellRenderer;
/**
 *
 * @author juanramon
 */
public class interfazPrincipal extends javax.swing.JFrame {
    /*VARIABLES INVENTARIOS*/
    public static boolean isAbiertoDetallesProducto = false;
    public static boolean isAbiertoNuevoProducto = false;
    public static boolean isAbiertoAsignacion = false;
    public static boolean isAbiertoMovimiento = false;
    /*VARIABLES INVENTARIOS*/

    //Instancias
    FuncionesInterfaces funcion=new FuncionesInterfaces();
    ControladorDeRoles rol=new ControladorDeRoles();
    interfazLogin usuario=new interfazLogin();
    BDPERSONAL metodo =  new BDPERSONAL();
    Reloj reloj=new Reloj();
    BDUSUARIOS metodoU =new BDUSUARIOS();
   //variables personal
     DefaultTableModel modeloTabla = new DefaultTableModel();
       DefaultTableModel modeloTablaUsuarios = new DefaultTableModel();
     
    //Avriables para poder mover la ventana
    int x=0;
    int y=0;
    int tipoUsuario;
//atrubutos

    public interfazPrincipal(String usuario,int tipoUsuario) {
        
        initComponents();
         ////////////////////////////////////////////////////////////
       /////////// MANEJO DE LOS ROLES DE USUARIOS ///////////////
       //////////////////////////////////////////////////////////
       /////////////////////////////////////////////////////////
    
    
      switch(tipoUsuario){
                   
                     //Administrador del sistema
                     case 1:
                         modulosContenedor.addTab("Inventario",pnlFondoInventario);
                         modulosContenedor.addTab("Usuarios y Permisos",pnlFondoUsuariosPermisos);
                         rol.tipoAdministrador(modulosContenedor);
                         lblUsuario.setText(usuario);
                         lblPermisoTipo.setText("Administrador de Sistema");
                         lblPermiso1.setText("1) Modulo Inventario");
                         lblPermiso2.setText("2) Modulo usuarios y permisos");
                         lblPermiso3.setVisible(false);
                         break;
                    //Departamento de Administracion
                     case 2:
                           modulosContenedor.addTab("Personal",pnlFondoPersonal);
                            lblPermisoTipo.setText("Administrativo");
                            
                            rol.tipoAdministracion(modulosContenedor);
                            lblUsuario.setText(usuario);
                             lblPermiso1.setText("1) Modulo personal");
                             lblPermiso2.setVisible(false);
                             lblPermiso3.setVisible(false);
                           break;
                    //Auxiliar de almacen
                     case 3:
                         modulosContenedor.addTab("Inventario",pnlFondoInventario);
                          lblPermisoTipo.setText("Almacenista");
                          rol.tipoAlmacenista(modulosContenedor);
                           lblPermiso1.setText("1) Modulo inventario");
                         lblPermiso2.setVisible(false);
                             lblPermiso3.setVisible(false);
                           
                          lblUsuario.setText(usuario);
                         break;
                    //Secretari@
                     case 4:
                         modulosContenedor.addTab("Personal",pnlFondoPersonal);
                          lblPermisoTipo.setText("Secretari@");
                          rol.tipoSecretaria(modulosContenedor);
                           lblPermiso1.setText("1) Modulo personal");
                        lblPermiso2.setVisible(false);
                             lblPermiso3.setVisible(false);
                           
                          lblUsuario.setText(usuario);
                     //ESTE ES EL USUARIO ROOT
                     case 0:
                           modulosContenedor.addTab("Inventario",pnlFondoInventario);
                           modulosContenedor.addTab("Usuarios y Permisos",pnlFondoUsuariosPermisos);
                            lblPermiso1.setText("1) Modulo Personal");
                         lblPermiso2.setText("2) Modulo iventario");
                         lblPermiso3.setText("3) Modulo usuarios y permisos");
                           modulosContenedor.addTab("Personal",pnlFondoPersonal);
                           lblUsuario.setText(usuario);
                           lblUsuario.setForeground(Color.ORANGE);
                           lblPermisoTipo.setText("ROOT");
                         break;
                         
                 }
        tablaInventarios.setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        /*CARGAR TABLA INVENTARIOS Y LLENAR CB*/
       cargarTabla();
        this.cmbStatusPro1.removeAll();
        
        ArrayList<Status> arraySta = BDDInventarios.selectStatus();
        for(int i = 0; i < arraySta.size(); i++){
            this.cmbStatusPro1.addItem(arraySta.get(i).getNom_sta());
        }

        this.cmbClasificacionPro1.removeAll();
        
        ArrayList<Clasificacion> arrayCla = BDDInventarios.selectClasificaciones();
        for(int i = 0; i < arrayCla.size(); i++){
            this.cmbClasificacionPro1.addItem(arrayCla.get(i).getNom_clas());
        }
        
        /*CARGAR TABLA INVENTARIOS Y LLENAR CB*/
       
        /*CARGAR TABLA DE PERSONAL*/
           modeloTabla=(DefaultTableModel) tblConsultaPersonal.getModel();
       try {
            for(int i=0;i<modeloTabla.getRowCount();i++){
                modeloTabla.removeRow(i);
            }
            metodo.llenadoConsultaPersonal(modeloTabla);

        } catch (SQLException ex) {
             
        }
       /*CARGAR TABLA DE Usuarios*/
           modeloTablaUsuarios=(DefaultTableModel) tblUsuarios.getModel();
       try {
            for(int i=0;i<modeloTablaUsuarios.getRowCount();i++){
                modeloTablaUsuarios.removeRow(i);
            }
            metodoU.llenadoConsultaUsuarios(modeloTablaUsuarios);

        } catch (SQLException ex) {
             
        }
       /*CARGAR TABLA DE PERSONAL*/
        
       ///RELOJ
    
       /////////////////////////////////////////////////////////////
      
        
              
                 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        pnlFondo = new javax.swing.JPanel();
        lblLogoEncabezado = new javax.swing.JLabel();
        modulosContenedor = new javax.swing.JTabbedPane();
        pnlFondoBienvenida = new javax.swing.JPanel();
        pnlNotifica = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lblUsuario2 = new javax.swing.JLabel();
        lblSaludo = new javax.swing.JLabel();
        lblUsuario3 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblUsuario4 = new javax.swing.JLabel();
        lblPermisoTipo = new javax.swing.JLabel();
        lblPermiso1 = new javax.swing.JLabel();
        lblPermiso2 = new javax.swing.JLabel();
        lblPermiso3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblSesion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnlFondoPersonal = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnRegistrarPersonal = new javax.swing.JButton();
        btnPuestosAreasP = new javax.swing.JButton();
        btnRegistrarPersonal1 = new javax.swing.JButton();
        btnEliminarPersonal = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblConsultaPersonal = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        pnlFondoInventario = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnClasificaciones = new javax.swing.JButton();
        btnNuevoProducto = new javax.swing.JButton();
        btnAsignacion = new javax.swing.JButton();
        btnMovimientos = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtBusqueda = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        cmbClasificacionPro1 = new javax.swing.JComboBox<>();
        cmbStatusPro1 = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        btnStockMinimo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInventarios = new javax.swing.JTable();
        pnlFondoUsuariosPermisos = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnTiposUsuarios = new javax.swing.JButton();
        btnTiposUsuarios1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        lblCerrar = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        lblTextoLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlFondo.setBackground(new java.awt.Color(246, 246, 246));
        pnlFondo.setPreferredSize(new java.awt.Dimension(1280, 720));
        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogoEncabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoIEEN.png"))); // NOI18N
        lblLogoEncabezado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogoEncabezado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoEncabezadoMouseClicked(evt);
            }
        });
        pnlFondo.add(lblLogoEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, -1));

        modulosContenedor.setBackground(new java.awt.Color(255, 255, 255));
        modulosContenedor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        modulosContenedor.setForeground(new java.awt.Color(102, 102, 102));
        modulosContenedor.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        modulosContenedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        modulosContenedor.setOpaque(true);

        pnlFondoBienvenida.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondoBienvenida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlFondoBienvenida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlNotifica.setBackground(new java.awt.Color(255, 255, 255));
        pnlNotifica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlNotifica.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        pnlNotifica.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1070, -1));

        lblUsuario2.setBackground(new java.awt.Color(153, 153, 153));
        lblUsuario2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblUsuario2.setForeground(new java.awt.Color(153, 153, 153));
        lblUsuario2.setText("Permisos en:");
        pnlNotifica.add(lblUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 130, -1));

        lblSaludo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        pnlNotifica.add(lblSaludo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 560, 60));

        lblUsuario3.setBackground(new java.awt.Color(153, 153, 153));
        lblUsuario3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblUsuario3.setForeground(new java.awt.Color(153, 153, 153));
        lblUsuario3.setText("Usuario:");
        pnlNotifica.add(lblUsuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 80, -1));

        lblUsuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblUsuario.setText("Usuario");
        pnlNotifica.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 130, 30));

        lblUsuario4.setBackground(new java.awt.Color(153, 153, 153));
        lblUsuario4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblUsuario4.setForeground(new java.awt.Color(153, 153, 153));
        lblUsuario4.setText("Rol:");
        pnlNotifica.add(lblUsuario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 80, -1));

        lblPermisoTipo.setBackground(new java.awt.Color(153, 153, 153));
        lblPermisoTipo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPermisoTipo.setForeground(new java.awt.Color(153, 153, 153));
        lblPermisoTipo.setText("Tipo");
        pnlNotifica.add(lblPermisoTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 200, 30));

        lblPermiso1.setBackground(new java.awt.Color(153, 153, 153));
        lblPermiso1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPermiso1.setForeground(new java.awt.Color(153, 153, 153));
        lblPermiso1.setText("1) Modulo personal");
        pnlNotifica.add(lblPermiso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 250, 30));

        lblPermiso2.setBackground(new java.awt.Color(153, 153, 153));
        lblPermiso2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPermiso2.setForeground(new java.awt.Color(153, 153, 153));
        lblPermiso2.setText("2) Modulo Inventario");
        pnlNotifica.add(lblPermiso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 260, 30));

        lblPermiso3.setBackground(new java.awt.Color(153, 153, 153));
        lblPermiso3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPermiso3.setForeground(new java.awt.Color(153, 153, 153));
        lblPermiso3.setText("3) Modulo usuario y permisos");
        pnlNotifica.add(lblPermiso3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 260, 30));

        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlNotifica.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 1070, 150));

        pnlFondoBienvenida.add(pnlNotifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 67, 1070, 560));

        lblSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout.png"))); // NOI18N
        lblSesion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSesionMouseExited(evt);
            }
        });
        pnlFondoBienvenida.add(lblSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel1.setText("Cerrar Sesion");
        pnlFondoBienvenida.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        modulosContenedor.addTab("Bienvenido", pnlFondoBienvenida);

        pnlFondoPersonal.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondoPersonal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlFondoPersonal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pnlFondoPersonalFocusGained(evt);
            }
        });
        pnlFondoPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlFondoPersonalMouseClicked(evt);
            }
        });
        pnlFondoPersonal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnRegistrarPersonal.setBackground(new java.awt.Color(255, 252, 199));
        btnRegistrarPersonal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrarPersonal.setText("Registrar Personal");
        btnRegistrarPersonal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrarPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarPersonalMouseClicked(evt);
            }
        });
        btnRegistrarPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPersonalActionPerformed(evt);
            }
        });

        btnPuestosAreasP.setBackground(new java.awt.Color(255, 254, 187));
        btnPuestosAreasP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPuestosAreasP.setText("Puestos y Areas");
        btnPuestosAreasP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPuestosAreasP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPuestosAreasPMouseClicked(evt);
            }
        });
        btnPuestosAreasP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPuestosAreasPActionPerformed(evt);
            }
        });

        btnRegistrarPersonal1.setBackground(new java.awt.Color(254, 255, 193));
        btnRegistrarPersonal1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrarPersonal1.setText("Modificar Personal");
        btnRegistrarPersonal1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrarPersonal1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarPersonal1MouseClicked(evt);
            }
        });
        btnRegistrarPersonal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPersonal1ActionPerformed(evt);
            }
        });

        btnEliminarPersonal.setBackground(new java.awt.Color(251, 252, 197));
        btnEliminarPersonal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarPersonal.setText("Eliminar Personal");
        btnEliminarPersonal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEliminarPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarPersonalMouseClicked(evt);
            }
        });
        btnEliminarPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPersonalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(btnPuestosAreasP, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(btnRegistrarPersonal1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(btnEliminarPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrarPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(btnRegistrarPersonal1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPuestosAreasP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(427, Short.MAX_VALUE))
        );

        pnlFondoPersonal.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 6, 240, 650));

        tblConsultaPersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido Paterno", "Apellido Materno", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblConsultaPersonal);

        pnlFondoPersonal.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 850, 490));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-actualizar.png"))); // NOI18N
        jButton1.setText("Actualizar Datos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlFondoPersonal.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        modulosContenedor.addTab("Personal", pnlFondoPersonal);

        pnlFondoInventario.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondoInventario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnClasificaciones.setBackground(new java.awt.Color(255, 255, 204));
        btnClasificaciones.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClasificaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/clasificacion.png"))); // NOI18N
        btnClasificaciones.setText("Clasificaciones");
        btnClasificaciones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClasificaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClasificacionesMouseClicked(evt);
            }
        });
        btnClasificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClasificacionesActionPerformed(evt);
            }
        });

        btnNuevoProducto.setBackground(new java.awt.Color(255, 255, 204));
        btnNuevoProducto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNuevoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/agregar.png"))); // NOI18N
        btnNuevoProducto.setText("Nuevo Producto");
        btnNuevoProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevoProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoProductoMouseClicked(evt);
            }
        });
        btnNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProductoActionPerformed(evt);
            }
        });

        btnAsignacion.setBackground(new java.awt.Color(255, 255, 204));
        btnAsignacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAsignacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/asignar.png"))); // NOI18N
        btnAsignacion.setText("Nueva Asignación");
        btnAsignacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAsignacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAsignacionMouseClicked(evt);
            }
        });
        btnAsignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignacionActionPerformed(evt);
            }
        });

        btnMovimientos.setBackground(new java.awt.Color(255, 255, 204));
        btnMovimientos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/movimientos.png"))); // NOI18N
        btnMovimientos.setText("Movimientos");
        btnMovimientos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMovimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMovimientosMouseClicked(evt);
            }
        });
        btnMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimientosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClasificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevoProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAsignacion, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(btnMovimientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnClasificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNuevoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyPressed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(255, 255, 204));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/actualizar.png"))); // NOI18N
        btnRegresar.setText("Actualizar");
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
        });

        cmbClasificacionPro1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una clasificación" }));
        cmbClasificacionPro1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClasificacionPro1ItemStateChanged(evt);
            }
        });
        cmbClasificacionPro1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbClasificacionPro1FocusGained(evt);
            }
        });

        cmbStatusPro1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Status" }));
        cmbStatusPro1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbStatusPro1ItemStateChanged(evt);
            }
        });
        cmbStatusPro1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbStatusPro1FocusGained(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(255, 255, 204));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        btnStockMinimo.setBackground(new java.awt.Color(255, 255, 204));
        btnStockMinimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/stockmin.png"))); // NOI18N
        btnStockMinimo.setText("Stock Minimo");
        btnStockMinimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStockMinimoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbClasificacionPro1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbStatusPro1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(btnStockMinimo)
                .addGap(18, 18, 18)
                .addComponent(btnRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbClasificacionPro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStatusPro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnRegresar)
                    .addComponent(btnStockMinimo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaInventarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaInventarios);

        javax.swing.GroupLayout pnlFondoInventarioLayout = new javax.swing.GroupLayout(pnlFondoInventario);
        pnlFondoInventario.setLayout(pnlFondoInventarioLayout);
        pnlFondoInventarioLayout.setHorizontalGroup(
            pnlFondoInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlFondoInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        pnlFondoInventarioLayout.setVerticalGroup(
            pnlFondoInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFondoInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFondoInventarioLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)))
                .addContainerGap())
        );

        modulosContenedor.addTab("Inventario", pnlFondoInventario);

        pnlFondoUsuariosPermisos.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondoUsuariosPermisos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlFondoUsuariosPermisos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnTiposUsuarios.setBackground(new java.awt.Color(247, 255, 198));
        btnTiposUsuarios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTiposUsuarios.setText("Registrar Usuarios");
        btnTiposUsuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTiposUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTiposUsuariosMouseClicked(evt);
            }
        });
        btnTiposUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiposUsuariosActionPerformed(evt);
            }
        });

        btnTiposUsuarios1.setBackground(new java.awt.Color(251, 255, 200));
        btnTiposUsuarios1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTiposUsuarios1.setText("Eliminar Usuarios");
        btnTiposUsuarios1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTiposUsuarios1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTiposUsuarios1MouseClicked(evt);
            }
        });
        btnTiposUsuarios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiposUsuarios1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTiposUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addComponent(btnTiposUsuarios1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTiposUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTiposUsuarios1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(550, Short.MAX_VALUE))
        );

        pnlFondoUsuariosPermisos.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 6, 230, 650));

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre usuario", "Tipo de usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblUsuarios);

        pnlFondoUsuariosPermisos.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 620, 460));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-actualizar.png"))); // NOI18N
        jButton2.setText("Actualizar Datos");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnlFondoUsuariosPermisos.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));
        pnlFondoUsuariosPermisos.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 260, 320, 10));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DESCRIPCION DE LOS USUARIOS");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlFondoUsuariosPermisos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 90, 320, 40));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Tipo 4: Secretari@");
        pnlFondoUsuariosPermisos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 320, -1, -1));

        jLabel4.setText("Tiene acceso al modulo de personal");
        pnlFondoUsuariosPermisos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 340, -1, -1));

        jLabel5.setText("como al modulo de inventario");
        pnlFondoUsuariosPermisos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 180, -1, -1));
        pnlFondoUsuariosPermisos.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 200, 320, 10));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("TIpo 1: Administrador del sistema");
        pnlFondoUsuariosPermisos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 140, -1, -1));

        jLabel7.setText("Tiene acceso al modulo de Usuarios y Permisos");
        pnlFondoUsuariosPermisos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 160, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Tipo 2: Administrativo");
        pnlFondoUsuariosPermisos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 220, -1, -1));

        jLabel9.setText("Tiene acceso al modulo de personal");
        pnlFondoUsuariosPermisos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 240, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Tipo 3: Almacenista");
        pnlFondoUsuariosPermisos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 270, -1, -1));

        jLabel11.setText("Tiene acceso al modulo de inventario");
        pnlFondoUsuariosPermisos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 290, -1, -1));

        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlFondoUsuariosPermisos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 90, 320, 290));
        pnlFondoUsuariosPermisos.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 320, 320, 10));

        modulosContenedor.addTab("Usuarios y Permisos", pnlFondoUsuariosPermisos);

        pnlFondo.add(modulosContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1320, 700));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

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

        lblTextoLogo.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        lblTextoLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTextoLogo.setText("Instituto Estatal Electoral de Nayarit");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCerrar)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTextoLogo)
                .addContainerGap(1037, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(lblTextoLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlFondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 1316, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_lblMinimizarMouseClicked

    private void lblMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseEntered
        lblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MinimizarSeleccionado.png")));

    }//GEN-LAST:event_lblMinimizarMouseEntered

    private void lblMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseExited
        lblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Minimizar.png")));

    }//GEN-LAST:event_lblMinimizarMouseExited

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        int decision=showConfirmDialog(this,"¿Esta seguro que quiere salir del sistema?");
        if(decision==0){
            System.exit(0);
        }
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseEntered
        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CancelarSeleccionado.png")));
    }//GEN-LAST:event_lblCerrarMouseEntered

    private void lblCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseExited
        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cancelar.png")));

    }//GEN-LAST:event_lblCerrarMouseExited

    private void lblLogoEncabezadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoEncabezadoMouseClicked
         int decision=showConfirmDialog(this,"¿Quiere ingresar a la pagina del Instituto?");
        if(decision==0){
             funcion.goToURL("http://ieenayarit.org/");
        }else{
    
        }//IF
    }//GEN-LAST:event_lblLogoEncabezadoMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
     
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
     funcion.saludoPorHora(lblSaludo);
    }//GEN-LAST:event_formWindowActivated

    private void btnClasificacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClasificacionesMouseClicked
        AgregarClasificacion vent = new AgregarClasificacion();
        vent.setLocationRelativeTo(null);
        vent.setVisible(true);
    }//GEN-LAST:event_btnClasificacionesMouseClicked

    private void btnClasificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClasificacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClasificacionesActionPerformed

    private void txtBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyPressed
        if(txtBusqueda.getText().length() > 1) cargarTabla(this.txtBusqueda.getText());
    }//GEN-LAST:event_txtBusquedaKeyPressed

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        this.txtBusqueda.setText("");
        this.cmbClasificacionPro1.setSelectedIndex(0);
        this.cmbStatusPro1.setSelectedIndex(0);
        cargarTabla();
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void cmbClasificacionPro1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClasificacionPro1ItemStateChanged
        int eleccion = this.cmbClasificacionPro1.getSelectedIndex();
        int eleccion2 = this.cmbStatusPro1.getSelectedIndex();
        if (!(eleccion == 0 && eleccion2 == 0)){
            if(eleccion2 == 0) cargarTabla(this.cmbClasificacionPro1.getItemAt(eleccion), "");
            else cargarTabla(this.cmbClasificacionPro1.getItemAt(eleccion), this.cmbStatusPro1.getItemAt(eleccion2));
        }else{
            cargarTabla();
        }
    }//GEN-LAST:event_cmbClasificacionPro1ItemStateChanged

    private void cmbClasificacionPro1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbClasificacionPro1FocusGained

    }//GEN-LAST:event_cmbClasificacionPro1FocusGained

    private void cmbStatusPro1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbStatusPro1ItemStateChanged
        int eleccion = this.cmbClasificacionPro1.getSelectedIndex();
        int eleccion2 = this.cmbStatusPro1.getSelectedIndex();
        if (!(eleccion == 0 && eleccion2 == 0)){
            if(eleccion == 0) cargarTabla("", this.cmbStatusPro1.getItemAt(eleccion2));
            else cargarTabla(this.cmbClasificacionPro1.getItemAt(eleccion), this.cmbStatusPro1.getItemAt(eleccion2));
        }else{
            cargarTabla();
        }
    }//GEN-LAST:event_cmbStatusPro1ItemStateChanged

    private void cmbStatusPro1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbStatusPro1FocusGained

    }//GEN-LAST:event_cmbStatusPro1FocusGained

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        cargarTabla(this.txtBusqueda.getText());
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnStockMinimoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStockMinimoMouseClicked
        cargarTablaMinimo();
    }//GEN-LAST:event_btnStockMinimoMouseClicked

    private void btnNuevoProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoProductoMouseClicked
        if(isAbiertoNuevoProducto == false){
            nuevoProducto vent = new nuevoProducto();
            vent.setLocationRelativeTo(null);
            vent.setVisible(true);
            isAbiertoNuevoProducto = true;
        }
    }//GEN-LAST:event_btnNuevoProductoMouseClicked

    private void btnNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProductoActionPerformed
        
    }//GEN-LAST:event_btnNuevoProductoActionPerformed

    private void lblSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSesionMouseClicked
  int decision=showConfirmDialog(this,"¿Esta seguro que desea cerrar la sesion?");
      if(decision==0){
      
        new interfazLogin().setVisible(true);
        dispose();
           }
    }//GEN-LAST:event_lblSesionMouseClicked

    private void lblSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSesionMouseEntered
   lblSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoutSeleccionado.png")));
        
    }//GEN-LAST:event_lblSesionMouseEntered

    private void lblSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSesionMouseExited
   lblSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout.png")));

    }//GEN-LAST:event_lblSesionMouseExited

    private void btnTiposUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTiposUsuariosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTiposUsuariosMouseClicked

    private void btnTiposUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiposUsuariosActionPerformed
 new InterfazRegistroUsuarios().setVisible(true);        
    }//GEN-LAST:event_btnTiposUsuariosActionPerformed

    private void btnNuevoProducto1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoProducto1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoProducto1MouseClicked

    private void btnNuevoProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProducto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoProducto1ActionPerformed

    private void btnRegistrarPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarPersonalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarPersonalMouseClicked

    private void btnRegistrarPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPersonalActionPerformed
 new InterfazInsertarPersonal().setVisible(true);      
    }//GEN-LAST:event_btnRegistrarPersonalActionPerformed

    private void btnPuestosAreasPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPuestosAreasPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPuestosAreasPMouseClicked

    private void btnPuestosAreasPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPuestosAreasPActionPerformed
        new InterfazPuestosAreas().setVisible(true);
    }//GEN-LAST:event_btnPuestosAreasPActionPerformed

    private void pnlFondoPersonalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pnlFondoPersonalFocusGained
///Corregir

    }//GEN-LAST:event_pnlFondoPersonalFocusGained

    private void pnlFondoPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlFondoPersonalMouseClicked
   
    }//GEN-LAST:event_pnlFondoPersonalMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  
          
        try {
           int filas=modeloTabla.getRowCount();
          for(int i=0;filas>i;i++){
                modeloTabla.removeRow(0);
          }
          if(modeloTabla.getRowCount()==0){
            metodo.llenadoConsultaPersonal(modeloTabla);
            showMessageDialog(this,"Datos Actualizados");
          }else{
              showMessageDialog(this,"No fue posible actualizar la tabla");
          }
        } catch (SQLException ex) {
            Logger.getLogger(interfazPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
      
           
           

     
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAsignacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsignacionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAsignacionMouseClicked

    private void btnAsignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignacionActionPerformed
        if(isAbiertoAsignacion == false){
            nuevaAsignacion vent = new nuevaAsignacion();
            vent.setLocationRelativeTo(null);
            vent.setVisible(true);
            isAbiertoAsignacion = true;
        }
    }//GEN-LAST:event_btnAsignacionActionPerformed

    private void btnMovimientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMovimientosMouseClicked
        if(isAbiertoMovimiento == false){
            ventanaMovimientos vent = new ventanaMovimientos();
            vent.setLocationRelativeTo(null);
            vent.setVisible(true);
            isAbiertoMovimiento = true;
        }
    }//GEN-LAST:event_btnMovimientosMouseClicked

    private void btnMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimientosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMovimientosActionPerformed

    private void btnRegistrarPersonal1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarPersonal1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarPersonal1MouseClicked

    private void btnRegistrarPersonal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPersonal1ActionPerformed
     new InterfazModificarPersonal().setVisible(true);
    }//GEN-LAST:event_btnRegistrarPersonal1ActionPerformed

    private void btnEliminarPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarPersonalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarPersonalMouseClicked

    private void btnEliminarPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPersonalActionPerformed
        new InterfazEliminarPersonal().setVisible(true);
    }//GEN-LAST:event_btnEliminarPersonalActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
         //para poder arrastar la ventana
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
     //Para mover la ventana
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void btnTiposUsuarios1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTiposUsuarios1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTiposUsuarios1MouseClicked

    private void btnTiposUsuarios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiposUsuarios1ActionPerformed
      new InterfazEliminarUsuarios().setVisible(true);
    }//GEN-LAST:event_btnTiposUsuarios1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        actualizarUsuarios();
    }//GEN-LAST:event_jButton2ActionPerformed
   public void actualizarUsuarios(){
    try {
            int filas=modeloTablaUsuarios.getRowCount();
            for(int i=0;filas>i;i++){
                modeloTablaUsuarios.removeRow(0);
            }
            if(modeloTablaUsuarios.getRowCount()==0){
               metodoU.llenadoConsultaUsuarios(modeloTablaUsuarios);
                showMessageDialog(this,"Datos Actualizados");
            }else{
                showMessageDialog(this,"No fue posible actualizar los datos");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfazEliminarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public boolean cargarTabla(){
        // Esta lista contiene los nombres que se mostrarán en el encabezado de cada columna de la grilla
        String[] columnas = new String[]{"Clasificación","Nombre","Marca","Modelo","Serie","Stock","Stock Min.","Fecha de compra","Status"};

        // Estos son los tipos de datos de cada columna de la lista
        final Class[] tiposColumnas = new Class[]{
            java.lang.String.class,
            java.lang.String.class,
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
            temp[x][0] = datos[0];
            temp[x][1] = datos[1];
            temp[x][2] = datos[2];
            temp[x][3] = datos[3];
            temp[x][4] = datos[4];
            temp[x][5] = datos[5];
            temp[x][6] = datos[6];
            temp[x][7] = datos[7];
            temp[x][8] = new JButton("Detalles");
        }
        Object[][] datos = temp;

        // Defino el TableModel y le indico los datos y nombres de columnas
        tablaInventarios.setModel(new javax.swing.table.DefaultTableModel(
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
            tablaInventarios.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }

        });

        /**
         * Por último, agregamos un listener que nos permita saber cuando fue pulsada la celda que contiene el botón.
         */
        tablaInventarios.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = tablaInventarios.rowAtPoint(e.getPoint());
                int columna = tablaInventarios.columnAtPoint(e.getPoint());

                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el botón, si tuviéramos más de un botón 
                 * por fila tendríamos que además preguntar por el contenido del botón o el nombre de la columna
                 */
                if (tablaInventarios.getModel().getColumnClass(columna).equals(JButton.class)) {
                    
                    /*ABRIR OTRO JFRAME*/
                    if(isAbiertoDetallesProducto == false){
                        ventanaDatosProducto vent = new ventanaDatosProducto(tablaInventarios.getModel().getValueAt(fila, 1).toString(),tablaInventarios.getModel().getValueAt(fila, 2).toString(),tablaInventarios.getModel().getValueAt(fila, 3).toString());
                        vent.setLocationRelativeTo(null);
                        vent.setVisible(true);
                        isAbiertoDetallesProducto = true;
                    }
                    
                }
            }

         
        });
        return true;
    }//cargarTablas
    
    public boolean cargarTablaMinimo(){
        // Esta lista contiene los nombres que se mostrarán en el encabezado de cada columna de la grilla
        String[] columnas = new String[]{"Clasificación","Nombre","Marca","Modelo","Serie","Stock","Stock Min.","Fecha de compra","Status"};

        // Estos son los tipos de datos de cada columna de la lista
        final Class[] tiposColumnas = new Class[]{
            java.lang.String.class,
            java.lang.String.class,
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
        ArrayList<String[]> arrayDatos = BDDInventarios.selectTablaInventariosMinimo();
        Object[][] temp = new Object[arrayDatos.size()][9];
        for(int x = 0; x < arrayDatos.size(); x++ ){
            String[] datos = arrayDatos.get(x);
            temp[x][0] = datos[0];
            temp[x][1] = datos[1];
            temp[x][2] = datos[2];
            temp[x][3] = datos[3];
            temp[x][4] = datos[4];
            temp[x][5] = datos[5];
            temp[x][6] = datos[6];
            temp[x][7] = datos[7];
            temp[x][8] = new JButton("Detalles");
        }
        Object[][] datos = temp;

        // Defino el TableModel y le indico los datos y nombres de columnas
        tablaInventarios.setModel(new javax.swing.table.DefaultTableModel(
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
            tablaInventarios.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }

        });

        /**
         * Por último, agregamos un listener que nos permita saber cuando fue pulsada la celda que contiene el botón.
         */
        tablaInventarios.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = tablaInventarios.rowAtPoint(e.getPoint());
                int columna = tablaInventarios.columnAtPoint(e.getPoint());

                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el botón, si tuviéramos más de un botón 
                 * por fila tendríamos que además preguntar por el contenido del botón o el nombre de la columna
                 */
                if (tablaInventarios.getModel().getColumnClass(columna).equals(JButton.class)) {
                    
                    /*ABRIR OTRO JFRAME*/
                    if(isAbiertoDetallesProducto == false){
                        ventanaDatosProducto vent = new ventanaDatosProducto(tablaInventarios.getModel().getValueAt(fila, 1).toString(),tablaInventarios.getModel().getValueAt(fila, 2).toString(),tablaInventarios.getModel().getValueAt(fila, 3).toString());
                        vent.setLocationRelativeTo(null);
                        vent.setVisible(true);
                        isAbiertoDetallesProducto = true;
                    }
                    
                }
            }

         
        });
        return true;
    }//cargarTablas
    
    public boolean cargarTabla(String clasificacion, String status){
        // Esta lista contiene los nombres que se mostrarán en el encabezado de cada columna de la grilla
        String[] columnas = new String[]{"Clasificación","Nombre","Marca","Modelo","Serie","Stock","Stock Min.","Fecha de compra","Status"};

        // Estos son los tipos de datos de cada columna de la lista
        final Class[] tiposColumnas = new Class[]{
            java.lang.String.class,
            java.lang.String.class,
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
        ArrayList<String[]> arrayDatos = BDDInventarios.selectTablaInventarios(clasificacion,status);
        Object[][] temp = new Object[arrayDatos.size()][9];
        for(int x = 0; x < arrayDatos.size(); x++ ){
            String[] datos = arrayDatos.get(x);
            temp[x][0] = datos[0];
            temp[x][1] = datos[1];
            temp[x][2] = datos[2];
            temp[x][3] = datos[3];
            temp[x][4] = datos[4];
            temp[x][5] = datos[5];
            temp[x][6] = datos[6];
            temp[x][7] = datos[7];
            temp[x][8] = new JButton("Detalles");
        }
        Object[][] datos = temp;

        // Defino el TableModel y le indico los datos y nombres de columnas
        tablaInventarios.setModel(new javax.swing.table.DefaultTableModel(
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
            tablaInventarios.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }

        });

        /**
         * Por último, agregamos un listener que nos permita saber cuando fue pulsada la celda que contiene el botón.
         */
        tablaInventarios.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = tablaInventarios.rowAtPoint(e.getPoint());
                int columna = tablaInventarios.columnAtPoint(e.getPoint());

                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el botón, si tuviéramos más de un botón 
                 * por fila tendríamos que además preguntar por el contenido del botón o el nombre de la columna
                 */
                if (tablaInventarios.getModel().getColumnClass(columna).equals(JButton.class)) {
                    
                    /*ABRIR OTRO JFRAME*/
                    if(isAbiertoDetallesProducto == false){
                        ventanaDatosProducto vent = new ventanaDatosProducto(tablaInventarios.getModel().getValueAt(fila, 1).toString(),tablaInventarios.getModel().getValueAt(fila, 2).toString(),tablaInventarios.getModel().getValueAt(fila, 3).toString());
                        vent.setLocationRelativeTo(null);
                        vent.setVisible(true);
                        isAbiertoDetallesProducto = true;
                    }
                    
                }
            }

         
        });
        return true;
    }//cargarTablas
    
     public boolean cargarTabla(String texto){
        // Esta lista contiene los nombres que se mostrarán en el encabezado de cada columna de la grilla
        String[] columnas = new String[]{"Clasificación","Nombre","Marca","Modelo","Serie","Stock","Stock Min.","Fecha de compra","Status"};

        // Estos son los tipos de datos de cada columna de la lista
        final Class[] tiposColumnas = new Class[]{
            java.lang.String.class,
            java.lang.String.class,
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
            temp[x][0] = datos[0];
            temp[x][1] = datos[1];
            temp[x][2] = datos[2];
            temp[x][3] = datos[3];
            temp[x][4] = datos[4];
            temp[x][5] = datos[5];
            temp[x][6] = datos[6];
            temp[x][7] = datos[7];
            temp[x][8] = new JButton("Detalles");
        }
        Object[][] datos = temp;

        // Defino el TableModel y le indico los datos y nombres de columnas
        tablaInventarios.setModel(new javax.swing.table.DefaultTableModel(
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
            tablaInventarios.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }

        });

        /**
         * Por último, agregamos un listener que nos permita saber cuando fue pulsada la celda que contiene el botón.
         */
        tablaInventarios.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = tablaInventarios.rowAtPoint(e.getPoint());
                int columna = tablaInventarios.columnAtPoint(e.getPoint());

                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el botón, si tuviéramos más de un botón 
                 * por fila tendríamos que además preguntar por el contenido del botón o el nombre de la columna
                 */
                if (tablaInventarios.getModel().getColumnClass(columna).equals(JButton.class)) {
                    
                    /*ABRIR OTRO JFRAME*/
                    if(isAbiertoDetallesProducto == false){
                        ventanaDatosProducto vent = new ventanaDatosProducto(tablaInventarios.getModel().getValueAt(fila, 1).toString(),tablaInventarios.getModel().getValueAt(fila, 2).toString(),tablaInventarios.getModel().getValueAt(fila, 3).toString());
                        vent.setLocationRelativeTo(null);
                        vent.setVisible(true);
                        isAbiertoDetallesProducto = true;
                    }
                    
                }
            }

         
        });
        return true;
    }//cargarTablas
    
     //Cargar Icono del Jframe
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("img/casa.png"));


        return retValue;
    }
    
    
    public static void main (String ar[]){
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
            java.util.logging.Logger.getLogger(interfazInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfazInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfazInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfazInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfazPrincipal("",1).setVisible(true);
            }
        });
}

    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignacion;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnClasificaciones;
    private javax.swing.JButton btnEliminarPersonal;
    private javax.swing.JButton btnMovimientos;
    private javax.swing.JButton btnNuevoProducto;
    private javax.swing.JButton btnPuestosAreasP;
    private javax.swing.JButton btnRegistrarPersonal;
    private javax.swing.JButton btnRegistrarPersonal1;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnStockMinimo;
    private javax.swing.JButton btnTiposUsuarios;
    private javax.swing.JButton btnTiposUsuarios1;
    private javax.swing.JComboBox<String> cmbClasificacionPro1;
    private javax.swing.JComboBox<String> cmbStatusPro1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblLogoEncabezado;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JLabel lblPermiso1;
    private javax.swing.JLabel lblPermiso2;
    private javax.swing.JLabel lblPermiso3;
    private javax.swing.JLabel lblPermisoTipo;
    private javax.swing.JLabel lblSaludo;
    private javax.swing.JLabel lblSesion;
    private javax.swing.JLabel lblTextoLogo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario2;
    private javax.swing.JLabel lblUsuario3;
    private javax.swing.JLabel lblUsuario4;
    private javax.swing.JTabbedPane modulosContenedor;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlFondoBienvenida;
    private javax.swing.JPanel pnlFondoInventario;
    private javax.swing.JPanel pnlFondoPersonal;
    private javax.swing.JPanel pnlFondoUsuariosPermisos;
    private javax.swing.JPanel pnlNotifica;
    private javax.swing.JTable tablaInventarios;
    private javax.swing.JTable tblConsultaPersonal;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
