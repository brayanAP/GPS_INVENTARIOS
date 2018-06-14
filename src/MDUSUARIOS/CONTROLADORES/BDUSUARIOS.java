
package MDUSUARIOS.CONTROLADORES;

import MDPERSONAL.MODELOS.Personal;
import MDPERSONAL.MODELOS.Puesto;
import MDPERSONAL.MODELOS.TipoUsuario;
import MDPERSONAL.MODELOS.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;



public class BDUSUARIOS extends GENERALES.CONTROLADORES.BDD{
    
    public int tipoUsuario(){
        //crea Conexion a la BD
        Connection conn = connect();
        int tipUsuario=0;
        
        try{
            String query="";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.execute();
            
        }catch(SQLException e){
        
           }
        return tipUsuario;
    }
    public void llenadoConsultaUsuarios(DefaultTableModel tabla) throws SQLException{
        Object[] Datos = new Object[2];
        try{
            String consulta = "select nom_usu,id_tip from usuarios where id_usu=id_usu";
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

      public static ArrayList<Personal> selectPersonal(){
        Connection conn = connect();
        ArrayList<Personal> arrayPersonal = new ArrayList<Personal>();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM personal");
            int i = 0;
            while (rs.next()){
                arrayPersonal.add(i, new Personal(rs.getString("nom_per"),rs.getString("ape_pat_per"),
                    rs.getString("ape_mat_per"),rs.getString("calle_per"),rs.getString("num_per"),
                        rs.getString("col_per"),rs.getInt("cp_per"), rs.getString("tel_per"), 
                        rs.getString("fechnac_per"),rs.getString("curp_per"),rs.getString("rfc_per"), 
                        rs.getString("nolic_per"),rs.getString ("nocred_per"),rs.getInt("id_are"),rs.getInt("id_pue")));
                i++;
            }
            st.close();
        }catch (SQLException e){
          System.err.println(e.getMessage());
        }
        return arrayPersonal;
    }//selectClasificaciones()
       public boolean insertUsuario(Usuario usuario){
        Connection conn = connect();
        try{
            String query = "insert into usuarios (nom_usu,con_usu,id_per,id_tip)" + " values (?,?,?,?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, usuario.getNom_usu());
            preparedStmt.setString (2, usuario.getCon_usu());
            preparedStmt.setInt (3, usuario.getId_per());
            preparedStmt.setInt (4,usuario.getId_tip());
            
            
            preparedStmt.execute();
            conn.close();
            return true;
            
        }catch (SQLException e){
          System.err.println(e.getMessage());
          return false;
        }
 }//insertPuesto()
        public static ArrayList<TipoUsuario> selectTipUsuario(){
        Connection conn = connect();
        ArrayList<TipoUsuario> arrayTipUsu= new ArrayList<TipoUsuario>();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tipousu");
            int i = 0;
            while (rs.next()){
                arrayTipUsu.add(i, new TipoUsuario(rs.getString("nom_tip")));
                i++;
            }
            st.close();
        }catch (SQLException e){
          System.err.println(e.getMessage());
        }
        return arrayTipUsu;
    }//selectClasificaciones()
        
        
        
        
        public String obtenerIdUsuario (String nom_usu){
        String idUsuario = nom_usu;
        String expulsado="";
        Connection conn = connect();
        try{
            String consulta = "select id_usu from usuarios where nom_usu = '"+idUsuario+"'";
        PreparedStatement campos = conn.prepareStatement(consulta);
            ResultSet rs =  campos.executeQuery();
            while(rs.next()){
               expulsado=rs.getString("id_usu");
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
         public String obtenerTipUsu (String nom_usu){
        String nombre = nom_usu;
        String expulsado="";
        Connection conn = connect();
        try{
            String consulta = "select id_tip from usuarios where nom_usu = '"+nombre+"'";
        PreparedStatement campos = conn.prepareStatement(consulta);
            ResultSet rs =  campos.executeQuery();
            while(rs.next()){
               expulsado=rs.getString("id_tip");
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
   public boolean eliminarUsuario(String nom){
        String id= obtenerIdUsuario(nom);
        int tipo=Integer.parseInt(obtenerTipUsu(nom));
       if(tipo==0){
               showMessageDialog(null,"Este es un usuario ROOT del sistema, no se puede elimnar");
       }else{  
       
        Connection conn = connect();
        try{
            String query = "delete from usuarios where id_usu = "+ id;
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.execute();
        
            conn.close();
          
            //return true;
            return true;
        }catch (SQLException e){
          System.err.println(e.getMessage());
          javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
         
        }
       
       }
        return false;
       
    }//insertUsuario()
   
   public ArrayList<String> extraerUsuarios() throws SQLException {//Retornamos un ArrayList para tratarlo
    //en el JComboBox
    Connection conn = connect();
    String seleccion = "SELECT nom_usu as nombre from usuarios";
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
}
