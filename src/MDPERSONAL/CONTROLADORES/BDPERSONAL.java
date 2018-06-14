/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDPERSONAL.CONTROLADORES;

import MDPERSONAL.MODELOS.Area;
import MDPERSONAL.MODELOS.Personal;
import MDPERSONAL.MODELOS.Puesto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanramon
 */
public class BDPERSONAL extends GENERALES.CONTROLADORES.BDD {
    
    public void insertarPersonal(Personal persona){
        
     Connection conn = connect();    
        try{
         
       
           
            String query = "insert into personal (nom_per,ape_pat_per,ape_mat_per,"
                    + "calle_per,num_per,col_per,cp_per,tel_per,fechnac_per,curp_per,rfc_per,"
                    + "nolic_per,nocred_per,id_are,id_pue)" + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement preparedStmt = conn.prepareStatement(query);
           
            preparedStmt.setString (1,persona.getNom_per());
            preparedStmt.setString (2,persona.getApe_pat_per());
            preparedStmt.setString (3,persona.getApe_mat_per());
            preparedStmt.setString (4,persona.getCalle_per());
            preparedStmt.setString (5,persona.getNum_per());
            preparedStmt.setString (6,persona.getCol_per());
            preparedStmt.setInt    (7,persona.getCp_per());
            preparedStmt.setString (8,persona.getTel_per());
            preparedStmt.setString (9,persona.getFechnac_per());
            preparedStmt.setString (10,persona.getCurp_per());
            preparedStmt.setString (11,persona.getRfc_per());
            preparedStmt.setString (12,persona.getNolic_per());
            preparedStmt.setString (13,persona.getNocred_per());
            preparedStmt.setInt (14,persona.getId_are());
            preparedStmt.setInt (15,persona.getId_pue());
            
            preparedStmt.execute();
          
            showMessageDialog(null,"Datos registrados con exito");
           
            //Se cierra la conexion
            conn.close();
        }catch(SQLException e){
            showMessageDialog(null,"No fue posible registrar un nuevo empleado"+"\n"+"Debido a:"+e.getMessage());
        }
            
        
    }
     public void llenadoConsultaPersonal(DefaultTableModel tabla) throws SQLException{
        Object[] Datos = new Object[4];
        try{
            String consulta = "select nom_per,ape_pat_per,ape_mat_per,tel_per from personal where id_per=id_per";
        Connection conn = connect();
        PreparedStatement campos = conn.prepareStatement(consulta);
            ResultSet rs =  campos.executeQuery();
            while(rs.next()){
                for(int i=0;i<4;i++){
                    Datos[i]= rs.getObject(i+1);
                    
                }
                if(Datos!=null){
                tabla.addRow(Datos);
                }
            }
            rs.close();
            conn.close();
            //return true;
            
        }catch (SQLException e){
          System.err.println(e.getMessage());
          javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
          //return false;
          //return false;
        }
        
    }
      public void llenadoConsultaPersonalCurp(DefaultTableModel tabla) throws SQLException{
        Object[] Datos = new Object[4];
        try{
            String consulta = "select nom_per,ape_pat_per,ape_mat_per,curp_per from personal where id_per=id_per";
        Connection conn = connect();
        PreparedStatement campos = conn.prepareStatement(consulta);
            ResultSet rs =  campos.executeQuery();
            while(rs.next()){
                for(int i=0;i<4;i++){
                    Datos[i]= rs.getObject(i+1);
                    
                }
                if(Datos!=null){
                tabla.addRow(Datos);
                }
            }
            rs.close();
            conn.close();
            //return true;
            
        }catch (SQLException e){
          System.err.println(e.getMessage());
          javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
          //return false;
          //return false;
        }
        
    }
        public static ArrayList<Area> selectArea(){
        Connection conn = connect();
        ArrayList<Area> arrayClasificaiones = new ArrayList<Area>();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM areas");
            int i = 0;
            while (rs.next()){
                arrayClasificaiones.add(i, new Area(rs.getString("nom_are"),rs.getString("des_are")));
                i++;
            }
            st.close();
        }catch (SQLException e){
          System.err.println(e.getMessage());
        }
        return arrayClasificaiones;
    }//selectClasificaciones()
    public static ArrayList<Puesto> selectPuesto(){
        Connection conn = connect();
        ArrayList<Puesto> arrayPuesto = new ArrayList<Puesto>();
        
        try{            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM puestos");
            int i = 0;
            while (rs.next()){
                arrayPuesto.add(i, new Puesto(rs.getString("fol_pue"),rs.getString("nom_pue"),rs.getDouble("sal_pue")));
                i++;
            }
            st.close();
        }catch (SQLException e){
          System.err.println(e.getMessage());
        }
        return arrayPuesto;
    }//selectClasi
        
      public boolean insertPuesto(Puesto puesto){
        Connection conn = connect();
        try{
            String query = "insert into puestos (fol_pue,nom_pue,sal_pue)" + " values (?, ?,?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, puesto.getFol_pue());
            preparedStmt.setString (2, puesto.getNom_pue());
            preparedStmt.setDouble (3, puesto.getSal_pue());
            
            
            preparedStmt.execute();
            conn.close();
            return true;
            
        }catch (SQLException e){
          System.err.println(e.getMessage());
          return false;
        }
 }//insertPuesto()
        public void ConsultarPuestos(DefaultTableModel tabla) throws SQLException{
        Object[] Datos = new Object[3];
        try{
            String consulta = "select nom_pue,fol_pue,sal_pue from puestos where id_pue=id_pue";
        Connection conn = connect();
        PreparedStatement campos = conn.prepareStatement(consulta);
            ResultSet rs =  campos.executeQuery();
            while(rs.next()){
                for(int i=0;i<3;i++){
                    Datos[i]= rs.getObject(i+1);
                    
                }
                if(Datos!=null){
                tabla.addRow(Datos);
                }
            }
            rs.close();
            conn.close();
            //return true;
            
        }catch (SQLException e){
          System.err.println(e.getMessage());
          javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
          //return false;
          //return false;
        }
}
          public boolean insertarArea(Area Area){
        Connection conn = connect();
        try{
            String query = "insert into areas (nom_are,des_are)" + " values (?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1,Area.getNom_are() );
            preparedStmt.setString (2,Area.getDes_are());
       
            
            
            preparedStmt.execute();
            conn.close();
            return true;
            
        }catch (SQLException e){
          showMessageDialog(null,e.getMessage());
          return false;
        }
 }//insertPuesto()
            public void ConsultarAreas(DefaultTableModel tabla) throws SQLException{
        Object[] Datos = new Object[2];
        try{
            String consulta = "select nom_are,des_are from areas where id_are=id_are";
        Connection conn = connect();
        PreparedStatement campos = conn.prepareStatement(consulta);
            ResultSet rs =  campos.executeQuery();
            while(rs.next()){
                for(int i=0;i<2;i++){
                    Datos[i]= rs.getObject(i+1);
                    
                }
                if(Datos!=null){
                tabla.addRow(Datos);
                }
            }
            rs.close();
            conn.close();
            //return true;
            
        }catch (SQLException e){
          System.err.println(e.getMessage());
          javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
          //return false;
          //return false;
        }
}
            
      
         public String obtenerIdPer (String nom_per){
        String[] h = nom_per.split(",");
        String expulsado="";
        Connection conn = connect();
        try{
            String consulta = "select id_per from personal where nom_per = '"+h[0]+"'";
        PreparedStatement campos = conn.prepareStatement(consulta);
            ResultSet rs =  campos.executeQuery();
            while(rs.next()){
               expulsado=rs.getString("id_per");
            }
            rs.close();
            conn.close();
           
                     //return true;
            
        }catch (SQLException e){
          System.err.println(e.getMessage());
          javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
          //return false;
        }
        return expulsado;  
        
    }
      public ArrayList<String> extraerPersonal() throws SQLException {//Retornamos un ArrayList para tratarlo
    //en el JComboBox
    Connection conn = connect();
    String seleccion = "SELECT concat_ws(',',nom_per,ape_pat_per) as nombre from personal";
    PreparedStatement ps = conn.prepareStatement(seleccion);
    ArrayList<String> personal = new ArrayList<String>();
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
    personal.add(rs.getString("nombre"));//nombre es el campo de la base de datos
    //Metemos el resultado de la tabla en el ArrayList
    //javax.swing.JOptionPane.showMessageDialog(null,rs.getString("nombre"));
    }
    return personal;
    }
    public boolean eliminarPersonal(String nom){
        String id= obtenerIdPer(nom);
        Connection conn = connect();
        try{
            String query = "delete from personal where id_per = "+ id;
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.execute();
        
            conn.close();
                       //return true;
            return true;
        }catch (SQLException e){
          System.err.println(e.getMessage());
          javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
          return false;
        }
    }//insertUsuario()
     
    
  public String obtenerIdPuesto (String nom_pue){
        String puesto = nom_pue;
        String expulsado="";
        Connection conn = connect();
        try{
            String consulta = "select id_pue from puestos where nom_pue = '"+puesto+"'";
        PreparedStatement campos = conn.prepareStatement(consulta);
            ResultSet rs =  campos.executeQuery();
            while(rs.next()){
               expulsado=rs.getString("id_pue");
            }
            rs.close();
            conn.close();
           
                     //return true;
            
        }catch (SQLException e){
          System.err.println(e.getMessage());
          javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
          //return false;
        }
        return expulsado;  
        
    }
   public boolean eliminarPuesto(String nom){
        String id= obtenerIdPuesto(nom);
        Connection conn = connect();
        try{
            String query = "delete from puestos where id_pue = "+ id;
            String eliminaPuestoPersonal="UPDATE personal SET id_pue=null where id_pue="+id;
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            PreparedStatement elimnaPuestoPer=conn.prepareStatement(eliminaPuestoPersonal);
            preparedStmt.execute();
            elimnaPuestoPer.execute();
            showMessageDialog(null,"El puesto vinculado al personal a sido elimnado"+"\n"+
                   " tenga en cuenta que debera asignar un puesto al personal perteneciente"
                    + " a este puesto.");
            conn.close();
          
            //return true;
            return true;
        }catch (SQLException e){
          System.err.println(e.getMessage());
          javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
          return false;
        }
    }//insertUsuario()
   public ArrayList<String> extraerPuestos() throws SQLException {//Retornamos un ArrayList para tratarlo
    //en el JComboBox
    Connection conn = connect();
    String seleccion = "SELECT nom_pue as nombre from puestos";
    PreparedStatement ps = conn.prepareStatement(seleccion);
    ArrayList<String> puestos = new ArrayList<String>();
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
    puestos.add(rs.getString("nombre"));//nombre es el campo de la base de datos
    //Metemos el resultado de la tabla en el ArrayList
    //javax.swing.JOptionPane.showMessageDialog(null,rs.getString("nombre"));
    }
    return puestos;
    }
   
   public String obtenerIdArea (String nom_are){
        String area = nom_are;
        String expulsado="";
        Connection conn = connect();
        try{
            String consulta = "select id_are from areas where nom_are = '"+area+"'";
        PreparedStatement campos = conn.prepareStatement(consulta);
            ResultSet rs =  campos.executeQuery();
            while(rs.next()){
               expulsado=rs.getString("id_are");
            }
            rs.close();
            conn.close();
           
                     //return true;
            
        }catch (SQLException e){
          System.err.println(e.getMessage());
          javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
          //return false;
        }
        return expulsado;  
        
    }
   public boolean eliminarArea(String nom){
        String id= obtenerIdArea(nom);
        Connection conn = connect();
        try{
            String query = "delete from areas where id_are = "+ id;
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.execute();
        
            conn.close();
          
            //return true;
            return true;
        }catch (SQLException e){
          System.err.println(e.getMessage());
          javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
          return false;
        }
    }//insertUsuario()
   public ArrayList<String> extraerAreas() throws SQLException {//Retornamos un ArrayList para tratarlo
    //en el JComboBox
    Connection conn = connect();
    String seleccion = "SELECT nom_are as nombre from areas";
    PreparedStatement ps = conn.prepareStatement(seleccion);
    ArrayList<String> area = new ArrayList<String>();
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
    area.add(rs.getString("nombre"));//nombre es el campo de la base de datos
    //Metemos el resultado de la tabla en el ArrayList
    //javax.swing.JOptionPane.showMessageDialog(null,rs.getString("nombre"));
    }
    return area;
    }
    public void llenarJTextP(JTextField d1,JTextField d2,JTextField d3,JTextField d4,
            JTextField d5,JTextField d6,JTextField d7,JTextField d8,JTextField d9,JTextField d10,
            JTextField d11,JTextField d12,JTextField d13,JComboBox cmbNomberP){
         String idPersona=obtenerIdPer(cmbNomberP.getSelectedItem().toString());
        String respuesta = "";
        Connection conn = connect();
        try{
            String query = "select nom_per,ape_pat_per,ape_mat_per,calle_per,num_per,col_per, cp_per,tel_per"
                    + ",fechnac_per,curp_per,rfc_per,nolic_per,nocred_per from personal where id_per="+idPersona;  
                   
      
            //NOTA REALIZAR UN QUERY POR CADA CAMPO QUE SE QUIERA SER MODIFICADO
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
             while(rs.next()){
            d1.setText(rs.getString("nom_per"));
            d2.setText(rs.getString("ape_pat_per"));
            d3.setText(rs.getString("ape_mat_per"));
            d4.setText(rs.getString("calle_per"));
            d5.setText(rs.getString("num_per"));
            d6.setText(rs.getString("col_per"));
            d7.setText(rs.getString("cp_per"));
            d8.setText(rs.getString("tel_per"));
            d9.setText(rs.getString("fechnac_per"));
            d10.setText(rs.getString("curp_per"));
             d11.setText(rs.getString("rfc_per"));
          d12.setText(rs.getString("nolic_per"));
          d13.setText(rs.getString("nocred_per"));
             }
                        
            preparedStmt.execute();
            conn.close();
            
          
            
        }catch (SQLException e){
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
          
        }

    }//updateeProducto()
    
  
    public String modificarPersonal(Personal persona,JComboBox cmbNomberP,JComboBox cmbArea,JComboBox cmbPuesto ){
        String respuesta = "";
       String idPersona=obtenerIdPer(cmbNomberP.getSelectedItem().toString());
       String idArea=obtenerIdArea(cmbArea.getSelectedItem().toString());
       String idPuesto=obtenerIdPuesto(cmbPuesto.getSelectedItem().toString());
        Connection conn = connect();
        try{
            String query = "UPDATE personal SET "
                    + "nom_per = ?, "
                    + "ape_pat_per = ?, "
                    + "ape_mat_per = ?, "
                    + "calle_per = ?, "
                    + "num_per = ?, "
                    + "col_per = ?, "
                    + "cp_per = ?, "
                    + "tel_per = ?, "
                    + "fechnac_per = ?, "
                    + "curp_per = ?, "
                    + "rfc_per = ?, "
                    + "nolic_per = ?, "
                    + "nocred_per = ?, "
                    + "id_are = ?, "
                    + "id_pue = ? "
                    + " WHERE id_per ="+idPersona;
          
            PreparedStatement preparedStmt = conn.prepareStatement(query);
           
            preparedStmt.setString(1, persona.getNom_per());
            preparedStmt.setString(2, persona.getApe_pat_per());
            preparedStmt.setString(3,persona.getApe_mat_per());
            preparedStmt.setString(4, persona.getCalle_per());
            preparedStmt.setString(5, persona.getNum_per());
            preparedStmt.setString(6, persona.getCol_per());
            preparedStmt.setInt(7, persona.getCp_per());
            preparedStmt.setString(8,persona.getTel_per());
            preparedStmt.setString(9, persona.getFechnac_per());
            preparedStmt.setString(10, persona.getCurp_per());
            preparedStmt.setString(11, persona.getRfc_per());
            preparedStmt.setString(12, persona.getNolic_per());
            preparedStmt.setString(13, persona.getNocred_per());
            
            //Hacer un metodo para calcular el id del cmb
            preparedStmt.setInt(14, Integer.parseInt(idArea));
            preparedStmt.setInt(15, Integer.parseInt(idPuesto));
            
            
            preparedStmt.executeUpdate();
            showMessageDialog(null,"Persona modificada con exito");
            conn.close();
            
          
            
        }catch (SQLException e){
            javax.swing.JOptionPane.showMessageDialog(null, e);
            return "ERROR: "+ e.getMessage()+"\n";
        }
        return "OK";
    }//updateeProducto()

}
