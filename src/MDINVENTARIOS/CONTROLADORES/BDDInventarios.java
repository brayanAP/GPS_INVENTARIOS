package MDINVENTARIOS.CONTROLADORES;
import MDINVENTARIOS.MODELOS.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;

public class BDDInventarios extends GENERALES.CONTROLADORES.BDD{
    
    protected String insertProducto(Producto producto){
        String respuesta = "";
        Connection conn = connect();
        try{
            String query = "insert into productos (con_pro, subcat_pro, nom_pro, des_pro, mar_pro, mod_pro, ser_pro, col_pro, pla_pro, nomot_pro, fechcompra_pro, nofact_pro, imp_pro, obs_pro, stock_pro, stockmin_pro, km_pro, km_ser_pro, id_cla, id_sta)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            
            preparedStmt.setInt (1, producto.getCon_pro());
            preparedStmt.setString(2, producto.getSubcat_pro());
            preparedStmt.setString(3, producto.getNom_pro());
            preparedStmt.setString(4, producto.getDes_pro());
            preparedStmt.setString(5, producto.getMar_pro());
            preparedStmt.setString(6, producto.getMod_pro());
            preparedStmt.setString(7, producto.getSer_pro());
            preparedStmt.setString(8, producto.getCol_pro());
            preparedStmt.setString(9, producto.getPla_pro());
            preparedStmt.setString(10, producto.getNomot_pro());
            
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            java.sql.Date sql = null;
      
            try{
                Date parsed = format.parse(producto.getFechcompra_pro());
                sql = new java.sql.Date(parsed.getTime());
            }catch(ParseException e){ return "ERROR: "+ e.getMessage()+"\n";}
            
            preparedStmt.setDate(11, sql);
            preparedStmt.setString(12, producto.getNofact_pro());
            preparedStmt.setDouble(13, producto.getImp_pro());
            preparedStmt.setString(14, producto.getObs_pro());
            preparedStmt.setInt (15, producto.getStock_pro());
            preparedStmt.setInt (16, producto.getStockmin_pro());
            preparedStmt.setInt (17, producto.getKm_pro());
            preparedStmt.setInt (18, producto.getKm_ser_pro());
            preparedStmt.setInt (19, producto.getId_cla());
            preparedStmt.setInt (20, producto.getId_sta());
            preparedStmt.execute();
            conn.close();
            
        }catch (SQLException e){
            return "ERROR: "+ e.getMessage()+"\n";
        }
        return "OK";
    }//insertProducto()
    
    protected String updateProducto(Producto producto){
        String respuesta = "";
        Connection conn = connect();
        try{
            String query = "UPDATE productos SET nom_pro = ?, des_pro = ?, mar_pro = ?, mod_pro = ?, ser_pro = ?, col_pro = ?, stock_pro = ?, stockmin_pro = ?, pla_pro = ?, nomot_pro = ?, obs_pro = ?, km_pro = ?, km_ser_pro = ?, nofact_pro = ?, imp_pro = ?, con_pro = ?, subcat_pro = ?, id_cla = ?, id_sta = ?, fechcompra_pro = ? WHERE id_pro = ?";
            
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            
            preparedStmt.setString(1, producto.getNom_pro());
            preparedStmt.setString(2, producto.getDes_pro());
            preparedStmt.setString(3, producto.getMar_pro());
            preparedStmt.setString(4, producto.getMod_pro());
            preparedStmt.setString(5, producto.getSer_pro());
            preparedStmt.setString(6, producto.getCol_pro());
            preparedStmt.setInt (7, producto.getStock_pro());
            preparedStmt.setInt (8, producto.getStockmin_pro());
            preparedStmt.setString(9, producto.getPla_pro());
            preparedStmt.setString(10, producto.getNomot_pro());
            preparedStmt.setString(11, producto.getObs_pro());
            preparedStmt.setInt (12, producto.getKm_pro());
            preparedStmt.setInt (13, producto.getKm_ser_pro());
            preparedStmt.setString(14, producto.getNofact_pro());
            preparedStmt.setDouble(15, producto.getImp_pro());
            preparedStmt.setInt (16, producto.getCon_pro()); 
            preparedStmt.setString(17, producto.getSubcat_pro());
            preparedStmt.setInt (18, producto.getId_cla());
            preparedStmt.setInt (19, producto.getId_sta());
            
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            java.sql.Date sql = null;
      
            try{
                Date parsed = format.parse(producto.getFechcompra_pro());
                sql = new java.sql.Date(parsed.getTime());
            }catch(ParseException e){ return "ERROR: "+ e.getMessage()+"\n";}
            
            preparedStmt.setDate(20, sql);
            preparedStmt.setInt (21, producto.getId_pro());
            preparedStmt.executeUpdate();
            conn.close();
            
        }catch (SQLException e){
            javax.swing.JOptionPane.showMessageDialog(null, e);
            return "ERROR: "+ e.getMessage()+"\n";
        }
        return "OK";
    }//updateeProducto()
    
    public static int buscarStock(int id){
        Connection conn = connect();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select stock_pro FROM productos WHERE id_pro = "+id);
            while (rs.next()){
                return rs.getInt("stock_pro");
            }
            st.close();
        }catch (SQLException e){return 0;}
        
        return 0;
    }//buscarStock
     
    public static boolean updateStockPro(int id, int cantidad){
        Connection conn = connect();
        try{
            String query = "UPDATE productos SET stock_pro = ?  WHERE id_pro = ?";
            
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, buscarStock(id) - cantidad);
            preparedStmt.setInt(2, id);
            
            preparedStmt.executeUpdate();
            conn.close();
            
        }catch (SQLException e){
            return false;
        }
        return true;
    }//updateeProducto()
    
    protected String insertMovimiento(Movimiento movimiento){
        Connection conn = connect();
        String respuesta = "";
        try{
            String query = "insert into movimientos (fec_mov, sta_mov, obs_mov, id_per)" + " values (?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
     
            
            preparedStmt.setString (1, movimiento.getFec_mov());
            preparedStmt.setBoolean(2, movimiento.getSta_mov());
            preparedStmt.setString(3, movimiento.getObs_mov());
            preparedStmt.setInt (4, movimiento.getId_per());
            preparedStmt.execute();
            conn.close();
        }catch (SQLException e){
            javax.swing.JOptionPane.showMessageDialog(null, e);
          return "ERROR: "+ e.getMessage()+"\n";
        }
        return "OK";
    }//insertMovimiento();
    
    public static String fechaActual(){
        Connection conn = connect();
        ArrayList<Clasificacion> arrayClasificaiones = new ArrayList<Clasificacion>();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select CURDATE() as Fecha");
            int i = 0;
            while (rs.next()){
                return rs.getDate("Fecha").toString();
            }
            st.close();
        }catch (SQLException e){
          System.err.println(e.getMessage());
        }
        return "";
    }//selectIdProducto()
    
    protected String insertAsignacion(Asignacion asignacion){
        String respuestan="";
        Connection conn = connect();
        try{
            String query = "insert into asignacion (id_mov, id_pro, can_asi)" + " values (?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt (1, asignacion.getId_mov());
            preparedStmt.setInt (2, asignacion.getId_pro());
            preparedStmt.setInt (3, asignacion.getCan_asi());
            preparedStmt.execute();
            conn.close();    
        }catch (SQLException e){
           javax.swing.JOptionPane.showMessageDialog(null, e);
          return "ERROR: "+ e.getMessage()+"\n";
        }
        return "OK";
    }//insertAsignacion()
    
    protected String insertClasificacion(Clasificacion clasificacion){
        Connection conn = connect();
        String respuesta = "";
        try{
            String query = "insert into clasificaciones (fol_clas, nom_clas, stock_clas)" + " values (?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
           
            preparedStmt.setString(1, clasificacion.getFol_clas());
            preparedStmt.setString(2, clasificacion.getNom_clas());
            preparedStmt.setBoolean (3, clasificacion.getStock_clas());
            preparedStmt.execute();
            conn.close();
            
        }catch (SQLException e){
          return "ERROR: "+ e.getMessage()+"\n";
        }
        return "OK";
    }//insertClasificacion()
    
    protected String updateClasificacion(Clasificacion clasificacion){
        Connection conn = connect();
        String respuesta = "";
        try{
            String query = "UPDATE clasificaciones SET fol_clas = ?, nom_clas = ?, stock_clas = ? WHERE id_clas = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
           
            preparedStmt.setString(1, clasificacion.getFol_clas());
            preparedStmt.setString(2, clasificacion.getNom_clas());
            preparedStmt.setBoolean (3, clasificacion.getStock_clas());
            preparedStmt.setInt(4, clasificacion.getId_clas());
            preparedStmt.executeUpdate();
            conn.close();
            
        }catch (SQLException e){
            javax.swing.JOptionPane.showMessageDialog(null, e);
          return "ERROR: "+ e.getMessage()+"\n";
        }
        return "OK";
    }//updateClasificacion()
    
    protected String insertFoto(Foto foto, String ruta){
        Connection conn = connect();
        String insert = "insert into fotos (fot_fot, id_pro) values(?,?)";
        FileInputStream fis = null;
        PreparedStatement ps = null;
        
        try {
            conn.setAutoCommit(false);
            File file = new File(ruta);
            fis = new FileInputStream(file);
            ps = conn.prepareStatement(insert);
            
            ps.setBinaryStream(1,fis,(int)file.length());
            ps.setInt(2, foto.getId_pro());
            ps.executeUpdate();
            conn.commit();
            
        } catch (FileNotFoundException | SQLException ex) {
            return "ERROR: "+ ex.getMessage()+"\n";
        }finally{
            try {
                ps.close();
                fis.close();
            }catch (IOException | SQLException ex) {
                return "ERROR: "+ ex.getMessage()+"\n";
            }
        }  
        return "OK";
    }//insertFoto()   
    
    protected String updateFoto(String ruta, int id_pro){
        Connection conn = connect();
        String insert = "UPDATE fotos SET fot_fot = ? WHERE id_pro = ?";
        FileInputStream fis = null;
        PreparedStatement ps = null;
        
        try {
            conn.setAutoCommit(false);
            File file = new File(ruta);
            fis = new FileInputStream(file);
            ps = conn.prepareStatement(insert);
            
            ps.setBinaryStream(1,fis,(int)file.length());
            ps.setInt(2, id_pro);
            ps.executeUpdate();
            conn.commit();
            
        } catch (FileNotFoundException | SQLException ex) {
            return "ERROR: "+ ex.getMessage()+"\n";
        }finally{
            try {
                ps.close();
                fis.close();
            }catch (IOException | SQLException ex) {
                return "ERROR: "+ ex.getMessage()+"\n";
            }
        }  
        return "OK";
    }//updateFoto()   
    
    public static ArrayList<Clasificacion> selectClasificaciones(){
        Connection conn = connect();
        ArrayList<Clasificacion> arrayClasificaiones = new ArrayList<Clasificacion>();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM clasificaciones");
            int i = 0;
            while (rs.next()){
                arrayClasificaiones.add(i, new Clasificacion(rs.getInt("id_clas"),rs.getString("fol_clas"),rs.getString("nom_clas"),rs.getBoolean("stock_clas")));
                i++;
            }
            st.close();
        }catch (SQLException e){
          System.err.println(e.getMessage());
        }
        return arrayClasificaiones;
    }//selectClasificaciones()
    
    public static int selectIdPro(String nombre, String numerofactura){
        Connection conn = connect();
        ArrayList<Clasificacion> arrayClasificaiones = new ArrayList<Clasificacion>();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id_pro FROM productos WHERE nom_pro = '"+nombre+"' && nofact_pro = '"+numerofactura+"' ;");
            int i = 0;
            while (rs.next()){
                return rs.getInt("id_pro");
            }
            st.close();
        }catch (SQLException e){
          System.err.println(e.getMessage());
        }
        return 0;
    }//selectIdProducto()
    
    public static int selectIdCLasificacion(String nombre){
        ArrayList<Clasificacion> arrayCla = BDDInventarios.selectClasificaciones();
        for(int i = 0; i < arrayCla.size(); i++){
            Clasificacion cla = arrayCla.get(i);
            if(cla.getNom_clas().equals(nombre)) return cla.getId_clas();
        }
        return 0;
    }//selectIdCLasifiaion
    
    public static ArrayList<Status> selectStatus(){
        Connection conn = connect();
        ArrayList<Status> arrayStatus = new ArrayList<Status>();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM status");
            int i = 0;
            while (rs.next()){
                arrayStatus.add(i, new Status(rs.getInt("id_sta"),rs.getString("nom_sta")));
                i++;
            }
            st.close();
        }catch (SQLException e){
          System.err.println(e.getMessage());
        }
        return arrayStatus;
    }//selectStatus()
    
    public static int selectIdStatus(String nombre){
        ArrayList<Status> arrayCla = BDDInventarios.selectStatus();
        for(int i = 0; i < arrayCla.size(); i++){
            Status cla = arrayCla.get(i);
            if(cla.getNom_sta().equals(nombre)) return cla.getId_sta();
        }
        return 0;
    }//selectIdStatus
    
    public static ArrayList<Foto> selectFotos(){
         Connection conn = connect();
         ArrayList<Foto> lista = new ArrayList<Foto>();
	try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM fotos"); 
            while (rs.next()){
		Blob blob = rs.getBlob("fot_fot");
		byte[] data = blob.getBytes(1, (int)blob.length());
		BufferedImage img = null;
		try {img = ImageIO.read(new ByteArrayInputStream(data));} catch (IOException ex) { }
		lista.add(new Foto(rs.getInt("id_fot"),img,rs.getInt("id_pro")));
            }
            rs.close();
	} catch (SQLException ex) {}
	return lista;
    }//selectFotos
    
    public static ArrayList<String[]> selectTablaInventarios(){
        Connection conn = connect();
        ArrayList<String[]> arrayDatos = new ArrayList<String[]>();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nom_clas, nom_pro,mar_pro,mod_pro,ser_pro,stock_pro,stockmin_pro, fechcompra_pro, nom_sta FROM productos p\n" +"INNER JOIN clasificaciones c ON c.id_clas = p.id_cla\n" +"INNER JOIN status s ON s.id_sta = p.id_sta;");
            int i = 0;
            while (rs.next()){
                String[] datos = {rs.getString("nom_clas"),rs.getString("nom_pro"),rs.getString("mar_pro"),rs.getString("mod_pro"),rs.getString("ser_pro"),rs.getInt("stock_pro")+"",rs.getInt("stockmin_pro")+"",rs.getDate("fechcompra_pro").toString(),rs.getString("nom_sta")};
                arrayDatos.add(i, datos);
                i++;
            }
            st.close();
        }catch (SQLException e){}
        
        return arrayDatos;
    }//selectTablaInventarios()
    
    public static ArrayList<String[]> selectTablaPersonas(){
        Connection conn = connect();
        ArrayList<String[]> arrayDatos = new ArrayList<String[]>();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nom_are, nom_pue, nom_per, ape_pat_per, ape_mat_per FROM personal p\n" +"INNER JOIN puestos pu ON p.id_pue = p.id_pue \n" +"INNER JOIN areas a ON a.id_are = p.id_are");
            int i = 0;
            while (rs.next()){
                String[] datos = {rs.getString("nom_are"),rs.getString("nom_pue"),rs.getString("nom_per"),rs.getString("ape_pat_per"),rs.getString("ape_mat_per")};
                arrayDatos.add(i, datos);
                i++;
            }
            st.close();
        }catch (SQLException e){}
        
        return arrayDatos;
    }//selectTablaPersonas()
    
    public static ArrayList<String[]> selectTablaPersonas(String texto){
        Connection conn = connect();
        ArrayList<String[]> arrayDatos = new ArrayList<String[]>();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nom_are, nom_pue, nom_per, ape_pat_per, ape_mat_per FROM personal p\n" +"INNER JOIN puestos pu ON p.id_pue = p.id_pue \n" +"INNER JOIN areas a ON a.id_are = p.id_are\n" +"WHERE nom_are LIKE '%"+texto+"%' OR nom_pue LIKE '%"+texto+"%' OR nom_per LIKE '%"+texto+"%' OR ape_pat_per LIKE '%"+texto+"%' OR ape_mat_per LIKE '%"+texto+"%'");
            int i = 0;
            while (rs.next()){
                String[] datos = {rs.getString("nom_are"),rs.getString("nom_pue"),rs.getString("nom_per"),rs.getString("ape_pat_per"),rs.getString("ape_mat_per")};
                arrayDatos.add(i, datos);
                i++;
            }
            st.close();
        }catch (SQLException e){}
        
        return arrayDatos;
    }//selectTablaPersonas()
    
    public static int buscarIdPersona(String nombre, String app, String apm){
        Connection conn = connect();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id_per FROM personal WHERE nom_per  = '"+nombre+"' AND ape_pat_per  = '"+app+"' AND ape_mat_per = '"+apm+"'");
            while (rs.next()){
                return rs.getInt("id_per");
            }
            st.close();
        }catch (SQLException e){return 0;}
        
        return 0;
    }//buscarIdPersona)
    
    public static int buscarIdMovimiento(String fecha, int id){
        Connection conn = connect();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id_mov FROM movimientos WHERE fec_mov = '"+fecha+"' AND id_per = "+id);
            while (rs.next()){
                return rs.getInt("id_mov");
            }
            st.close();
        }catch (SQLException e){return 0;}
        
        return 0;
    }//buscarIdMovimiento()
    
    public static ArrayList<String[]> selectTablaInventariosMinimo(){
        Connection conn = connect();
        ArrayList<String[]> arrayDatos = new ArrayList<String[]>();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nom_clas, nom_pro,mar_pro,mod_pro,ser_pro,stock_pro,stockmin_pro, fechcompra_pro, nom_sta FROM productos p\n" +
            "INNER JOIN clasificaciones c ON c.id_clas = p.id_cla\n" +
            "INNER JOIN status s ON s.id_sta = p.id_sta\n" +
            "WHERE stock_pro <= stockmin_pro");
            int i = 0;
            while (rs.next()){
                String[] datos = {rs.getString("nom_clas"),rs.getString("nom_pro"),rs.getString("mar_pro"),rs.getString("mod_pro"),rs.getString("ser_pro"),rs.getInt("stock_pro")+"",rs.getInt("stockmin_pro")+"",rs.getDate("fechcompra_pro").toString(),rs.getString("nom_sta")};
                arrayDatos.add(i, datos);
                i++;
            }
            st.close();
        }catch (SQLException e){}
        
        return arrayDatos;
    }//selectTablaInventarios()
    
    public static ArrayList<String[]> selectTablaInventarios(String clasificacion, String status){
        Connection conn = connect();
        ArrayList<String[]> arrayDatos = new ArrayList<String[]>();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nom_clas, nom_pro,mar_pro,mod_pro,ser_pro,stock_pro,stockmin_pro, fechcompra_pro, nom_sta FROM productos p\n" +
                                            "INNER JOIN clasificaciones c ON c.id_clas = p.id_cla\n" +
                                            "INNER JOIN status s ON s.id_sta = p.id_sta\n" +
                                            "WHERE nom_clas = '"+clasificacion+"' OR nom_sta = '"+status+"'");
            int i = 0;
            while (rs.next()){
                String[] datos = {rs.getString("nom_clas"),rs.getString("nom_pro"),rs.getString("mar_pro"),rs.getString("mod_pro"),rs.getString("ser_pro"),rs.getInt("stock_pro")+"",rs.getInt("stockmin_pro")+"",rs.getDate("fechcompra_pro").toString(),rs.getString("nom_sta")};
                arrayDatos.add(i, datos);
                i++;
            }
            st.close();
        }catch (SQLException e){}
        
        return arrayDatos;
    }//selectTablaInventarios()
    
    public static ArrayList<String[]> selectTablaInventarios(String texto){
        Connection conn = connect();
        ArrayList<String[]> arrayDatos = new ArrayList<String[]>();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nom_clas, nom_pro,mar_pro,mod_pro,ser_pro,stock_pro,stockmin_pro, fechcompra_pro, nom_sta FROM productos p\n" +
                                            "INNER JOIN clasificaciones c ON c.id_clas = p.id_cla\n" +
                                            "INNER JOIN status s ON s.id_sta = p.id_sta\n" +
                                            "WHERE nom_pro LIKE "+"'"+"%"+texto+"%"+"'"
                                            + "OR mar_pro LIKE "+"'"+"%"+texto+"%"+"'"
                                            + "OR  mod_pro LIKE "+"'"+"%"+texto+"%"+"'"
                                            + "OR subcat_pro LIKE "+"'"+"%"+texto+"%"+"'"
                                            + "OR ser_pro  LIKE "+"'"+"%"+texto+"%"+"'"
                                            + "OR col_pro LIKE "+"'"+"%"+texto+"%"+"'"
                                            + "OR fechcompra_pro LIKE "+"'"+"%"+texto+"%"+"'"
                                            + "OR nomot_pro LIKE "+"'"+"%"+texto+"%"+"'"
                                            + "OR pla_pro LIKE "+"'"+"%"+texto+"%"+"'"
                                            + "OR km_pro LIKE "+"'"+"%"+texto+"%"+"'"
                                            + "OR km_ser_pro LIKE "+"'"+"%"+texto+"%"+"'");
            int i = 0;
            while (rs.next()){
                String[] datos = {rs.getString("nom_clas"),rs.getString("nom_pro"),rs.getString("mar_pro"),rs.getString("mod_pro"),rs.getString("ser_pro"),rs.getInt("stock_pro")+"",rs.getInt("stockmin_pro")+"",rs.getDate("fechcompra_pro").toString(),rs.getString("nom_sta")};
                arrayDatos.add(i, datos);
                i++;
            }
            st.close();
        }catch (SQLException e){}
        
        return arrayDatos;
    }//selectTablaInventarios()
    
    public static Producto selectProductoFiltrado(String nombre, String marca, String modelo){
        Connection conn = connect();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM productos WHERE "+"nom_pro = "+"'"+nombre+"'"+" AND "+"mar_pro = "+"'"+marca+"'"+" AND "+"mod_pro = "+"'"+modelo+"'");
            int i = 0;
            while (rs.next()){
                return new Producto(rs.getInt("id_pro"), 
                                    rs.getInt("con_pro"), 
                                    rs.getString("subcat_pro"), 
                                    rs.getString("nom_pro"), 
                                    rs.getString("des_pro"), 
                                    rs.getString("mar_pro"), 
                                    rs.getString("mod_pro"),
                                    rs.getString("ser_pro"), 
                                    rs.getString("col_pro"), 
                                    rs.getString("pla_pro"), 
                                    rs.getString("nomot_pro"), 
                                    rs.getDate("fechcompra_pro").toString(), 
                                    rs.getString("nofact_pro"), 
                                    rs.getDouble("imp_pro"), 
                                    rs.getString("obs_pro"), 
                                    rs.getInt("stock_pro"), 
                                    rs.getInt("stockmin_pro"), 
                                    rs.getInt("km_pro"), 
                                    rs.getInt("km_ser_pro"), 
                                    rs.getInt("id_cla"), 
                                    rs.getInt("id_sta"));
            }
            st.close();
        }catch (SQLException e){return null;}
        return null;
    }//selectProductoFiltrado
    
    public static Clasificacion selectClasificacionFiltrada(String folio, String nombre){
        Connection conn = connect();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM clasificaciones WHERE fol_clas = '"+folio+"' AND nom_clas = '"+nombre+"'");
            int i = 0;
            while (rs.next()){
                return new Clasificacion(rs.getInt("id_clas"), rs.getString("fol_clas"), rs.getString("nom_clas"), rs.getBoolean("stock_clas"));
            }
            st.close();
        }catch (SQLException e){return null;}
        return null;
    }//selectClasificacionFiltrada
    
    public static Movimiento selectMovimientoFiltrado(int id){
        Connection conn = connect();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM movimientos WHERE id_mov ="+ id);
            int i = 0;
            while (rs.next()){
                return new Movimiento(0, rs.getString("fec_mov"), rs.getBoolean("sta_mov"), rs.getString("obs_mov"),rs.getInt("id_per"));
            }
            st.close();
        }catch (SQLException e){return null;}
        return null;
    }//selectClasificacionFiltrada
    
    public static ArrayList<String[]> selectTablaClasificaciones(){
        Connection conn = connect();
        ArrayList<String[]> arrayDatos = new ArrayList<String[]>();
        
        ArrayList<Clasificacion> arrayCla = selectClasificaciones();
        
        for(int i=0; i < arrayCla.size(); i++){
            Clasificacion temp = arrayCla.get(i);
            String gen;
            if (temp.getStock_clas()) gen = "Si";
            else gen = "No";
            String[] datos = {temp.getFol_clas(),temp.getNom_clas(),gen};
            arrayDatos.add(i, datos);
        }
          
        return arrayDatos;
    }//selectTablaClasificaciones
    
    public static ArrayList<String[]> selectTablaClasificaciones(String texto){
        Connection conn = connect();
        ArrayList<String[]> arrayDatos = new ArrayList<String[]>();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM clasificaciones WHERE fol_clas LIKE '%"+texto+"%' OR nom_clas LIKE '%"+texto+"%'");
            int i = 0;
            while (rs.next()){
                String stock;
                boolean temp = rs.getBoolean("stock_clas");
                
                if (temp) stock = "Si";
                else stock = "No";
                String[] datos = {rs.getString("fol_clas"),rs.getString("nom_clas"),stock};
                arrayDatos.add(i, datos);
                i++;
            }
            st.close();
        }catch (SQLException e){}
          
        return arrayDatos;
    }//selectTablaClasificaciones
        
    public static boolean deleteProducto(int id_pro){
        Connection conn = connect();
        
        try{
          String query = "DELETE FROM productos where id_pro = ?";
          PreparedStatement preparedStmt = conn.prepareStatement(query);
          preparedStmt.setInt(1, id_pro);
          preparedStmt.execute();
          conn.close();
          return true;
        }
        catch (SQLException e){javax.swing.JOptionPane.showMessageDialog(null, e);return false;}
    }//deleteProducto(int id_pro)
    
    public static boolean deleteClasificacion(int id_clas){
        Connection conn = connect();
        
        try{
          String query = "DELETE FROM clasificaciones where id_clas = ?";
          PreparedStatement preparedStmt = conn.prepareStatement(query);
          preparedStmt.setInt(1, id_clas);
          preparedStmt.execute();
          conn.close();
          return true;
        }
        catch (SQLException e){return false;}
    }//deleteClasificacion(int id_clas)
    
    public static boolean deleteFoto(int id_pro){
        Connection conn = connect();
        
        try{
          String query = "DELETE FROM fotos where id_pro = ?";
          PreparedStatement preparedStmt = conn.prepareStatement(query);
          preparedStmt.setInt(1, id_pro);
          preparedStmt.execute();
          conn.close();
          return true;
        }
        catch (Exception e){javax.swing.JOptionPane.showMessageDialog(null, e);return false;}
    }//deleteProducto(int id_pro)
    
    public static ArrayList<Producto> llenarListaProductos(){
        Connection conn = connect();
        ArrayList<Producto> arrayDatos = new ArrayList<Producto>();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM productos WHERE stock_pro >= stockmin_pro");
            int i = 0;
            while (rs.next()){
                Producto producto = new Producto(rs.getInt("id_pro"), 
                                    rs.getInt("con_pro"), 
                                    rs.getString("subcat_pro"), 
                                    rs.getString("nom_pro"), 
                                    rs.getString("des_pro"), 
                                    rs.getString("mar_pro"), 
                                    rs.getString("mod_pro"),
                                    rs.getString("ser_pro"), 
                                    rs.getString("col_pro"), 
                                    rs.getString("pla_pro"), 
                                    rs.getString("nomot_pro"), 
                                    rs.getDate("fechcompra_pro").toString(), 
                                    rs.getString("nofact_pro"), 
                                    rs.getDouble("imp_pro"), 
                                    rs.getString("obs_pro"), 
                                    rs.getInt("stock_pro"), 
                                    rs.getInt("stockmin_pro"), 
                                    rs.getInt("km_pro"), 
                                    rs.getInt("km_ser_pro"), 
                                    rs.getInt("id_cla"), 
                                    rs.getInt("id_sta"));
                arrayDatos.add(i, producto);
                i++;
            }
            st.close();
        }catch (SQLException e){}
        
        return arrayDatos;
    }//llenarListaProductos()
    
    public static int buscarIdProducto(String nombre, String marca, String modelo){
        Connection conn = connect();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id_pro FROM productos WHERE "+"nom_pro = "+"'"+nombre+"'"+" AND "+"mar_pro = "+"'"+marca+"'"+" AND "+"mod_pro = "+"'"+modelo+"'");
            int i = 0;
            while (rs.next()){
               return rs.getInt("id_pro");
            }
            st.close();
        }catch (SQLException e){ return 0;}
        
        return 0;
    }//llenarListaProductos()
    
    public static ArrayList<String[]> selectTablaInventarioss(String clasificacion){
        Connection conn = connect();
        ArrayList<String[]> arrayDatos = new ArrayList<String[]>();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nom_clas, nom_pro,mar_pro,mod_pro,ser_pro,stock_pro,stockmin_pro, fechcompra_pro, nom_sta FROM productos p\n" +
                                            "INNER JOIN clasificaciones c ON c.id_clas = p.id_cla\n" +
                                            "INNER JOIN status s ON s.id_sta = p.id_sta\n" +
                                            "WHERE nom_clas = '"+clasificacion+"'");
            int i = 0;
            while (rs.next()){
                String[] datos = {rs.getString("nom_clas"),rs.getString("nom_pro"),rs.getString("mar_pro"),rs.getString("mod_pro"),rs.getString("ser_pro"),rs.getInt("stock_pro")+"",rs.getInt("stockmin_pro")+"",rs.getDate("fechcompra_pro").toString(),rs.getString("nom_sta")};
                arrayDatos.add(i, datos);
                i++;
            }
            st.close();
        }catch (SQLException e){}
        
        return arrayDatos;
    }//selectTablaInventarios()
    
    public static ArrayList<String[]> selectTablaMovimientos(){
        Connection conn = connect();
        ArrayList<String[]> arrayDatos = new ArrayList<String[]>();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id_mov, fec_mov, CONCAT(p.nom_per,' ',p.ape_pat_per,' ',p.ape_mat_per) as nombre, sta_mov FROM movimientos m\n" +"INNER JOIN personal p ON p.id_per = m.id_per");
            int i = 0;
            while (rs.next()){
                String status = "";
                boolean temp = rs.getBoolean("sta_mov");
                if (temp) status = "A";
                else status = "N";
                String[] datos = {rs.getInt("id_mov")+"",rs.getString("fec_mov"),rs.getString("nombre"), status};
                arrayDatos.add(i, datos);
                i++;
            }
            st.close();
        }catch (SQLException e){}
        
        return arrayDatos;
    }//selectTablaMovimientios()
    
    public static String selectNombrePersonaMovimiento(int id){
        Connection conn = connect();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT CONCAT(nom_per,' ',ape_pat_per,' ',ape_mat_per) as nombre FROM personal WHERE id_per ="+ id);
            int i = 0;
            while (rs.next()){
                return rs.getString("nombre");
            }
            st.close();
        }catch (SQLException e){ javax.swing.JOptionPane.showMessageDialog(null, e);return null;}
        return null;
    }//selectClasificacionFiltrada
    
    public static ArrayList<String> selectProductosAsignadosMovimiento(int id){
        Connection conn = connect();
        ArrayList<String> arrayTemp = new ArrayList<String>();
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT CONCAT(p.nom_pro,'/',p.mar_pro,'/',p.mod_pro, '/', a.can_asi) as producto FROM asignacion a\n" +"INNER JOIN movimientos m ON m.id_mov = a.id_mov\n" +"INNER JOIN productos p ON p.id_pro = a.id_pro WHERE a.id_mov = "+ id);
            int i = 0;
            while (rs.next()){
                arrayTemp.add(i, rs.getString("producto"));
            }
            st.close();
        }catch (SQLException e){ javax.swing.JOptionPane.showMessageDialog(null, e);return null;}
        return arrayTemp;
    }//selectClasificacionFiltrada

    public static boolean deleteProductoAsignado(int id_mov, int id_pro){
        Connection conn = connect();
        
        try{
          String query = "DELETE FROM asignacion where id_mov = ? AND id_pro = ?";
          PreparedStatement preparedStmt = conn.prepareStatement(query);
          preparedStmt.setInt(1, id_mov);
          preparedStmt.setInt(2, id_pro);
          preparedStmt.execute();
          conn.close();
          return true;
        }
        catch (SQLException e){javax.swing.JOptionPane.showMessageDialog(null, e);return false;}
    }//deleteClasificacion(int id_clas)
    
    public static Producto selectProducto(int id){
        Connection conn = connect();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM productos WHERE id_pro = "+id);
            int i = 0;
            while (rs.next()){
                return new Producto(rs.getInt("id_pro"), 
                                    rs.getInt("con_pro"), 
                                    rs.getString("subcat_pro"), 
                                    rs.getString("nom_pro"), 
                                    rs.getString("des_pro"), 
                                    rs.getString("mar_pro"), 
                                    rs.getString("mod_pro"),
                                    rs.getString("ser_pro"), 
                                    rs.getString("col_pro"), 
                                    rs.getString("pla_pro"), 
                                    rs.getString("nomot_pro"), 
                                    rs.getDate("fechcompra_pro").toString(), 
                                    rs.getString("nofact_pro"), 
                                    rs.getDouble("imp_pro"), 
                                    rs.getString("obs_pro"), 
                                    rs.getInt("stock_pro"), 
                                    rs.getInt("stockmin_pro"), 
                                    rs.getInt("km_pro"), 
                                    rs.getInt("km_ser_pro"), 
                                    rs.getInt("id_cla"), 
                                    rs.getInt("id_sta"));
            }
            st.close();
        }catch (SQLException e){return null;}
        return null;
    }//selectProductoFiltrado
    
    public static boolean updateCantidadProductoAsignado(int id_mov,int id_pro, int cantidad){
        Connection conn = connect();
        
        Producto pro = selectProducto(id_pro);
        
        int stock = pro.getStock();
        
        if (cantidad > stock){
            return false;
        }
        try{
            String query = "UPDATE asignacion SET can_asi = ?  WHERE id_mov = ? AND id_pro = ?";
            
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, cantidad);
            preparedStmt.setInt(2, id_mov);
            preparedStmt.setInt(3, id_pro);
            
            
            preparedStmt.executeUpdate();
            conn.close();
            
        }catch (SQLException e){
            return false;
        }
        return true;
    }//updateeProducto()
    
    public static boolean deleteMovimiento(int id_mov){
        Connection conn = connect();
        
        try{
          String query = "DELETE FROM movimientos WHERE id_mov = ?";
          PreparedStatement preparedStmt = conn.prepareStatement(query);
          preparedStmt.setInt(1, id_mov);
          preparedStmt.execute();
          conn.close();
          return true;
        }
        catch (SQLException e){javax.swing.JOptionPane.showMessageDialog(null, e);return false;}
    }//deleteClasificacion(int id_clas)
    
    public static boolean updateDatosMovimiento(int id_mov,String obs, boolean sta){
        Connection conn = connect();
      
        try{
            String query = "UPDATE movimientos SET obs_mov = ?, sta_mov = ?  WHERE id_mov = ?";
            
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, obs);
            preparedStmt.setBoolean(2, sta);
            preparedStmt.setInt(3, id_mov);
            
            
            preparedStmt.executeUpdate();
            conn.close();
            
        }catch (SQLException e){
            javax.swing.JOptionPane.showMessageDialog(null, e);
            return false;
        }
        return true;
    }//updateeProducto()
    
}//class
