 package MDPERSONAL.CONTROLADORES;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class BDDPersonal extends GENERALES.CONTROLADORES.BDD {
    
    public String h[]= new String[1];
    public String contraseña="";
    public String id_per ="";
    public String cadena="";
    
  public boolean selectUsuario(String nom_usu,String con_usu){
        //crea Conexion a la BD
        Connection conn = connect();
        try{
            String query = 
                    "select nom_usu,con_usu from usuarios where "
                    + "nom_usu='"+nom_usu+"'"+" and con_usu='"+con_usu+"'";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.execute();
            
            ResultSet resultado = (ResultSet) preparedStmt.executeQuery("select con_usu from usuarios where "
                    + "nom_usu='"+nom_usu+"'");
            while(resultado.next()){
                h[0]=resultado.getString(1);
            }
            
            conn.close();
            javax.swing.JOptionPane.showMessageDialog(null,h[0]);
            contraseña=h[0];
            return true;
            
        }catch (SQLException e){
          System.err.println(e.getMessage());
          javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
          return false;
        }
    }//insertUsuario()
    public void extraerPersonaUsuario(String nom_usu,String con_usu){
        
        Connection conn = connect();
        try{
            String query = 
                    "select nom_usu,con_usu from usuarios where "
                    + "nom_usu='"+nom_usu+"'"+" and con_usu='"+con_usu+"'";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.execute();
            
            ResultSet resultado = (ResultSet) preparedStmt.executeQuery("select id_per from usuarios where "
                    + "nom_usu='"+nom_usu+"'");
            while(resultado.next()){
                h[0]=resultado.getString(1);
            }
            
            conn.close();
            javax.swing.JOptionPane.showMessageDialog(null,h[0]);
            id_per=h[0];
            //return true;
            
        }catch (SQLException e){
          System.err.println(e.getMessage());
          javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
          //return false;
        }
    }//insertUsuario()
 public String extraerPermisosUsuario(String usuario){
        
        Connection conn = connect();
        try{
            String query = 
                    "select alt_per,baj_per,con_per,modif_per,id_mod from permisos_usu where "
                    + "id_per='"+usuario+"'";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.execute();
            
            ResultSet resultado = (ResultSet) preparedStmt.executeQuery( "select alt_per,baj_per,con_per,modif_per,id_mod from permisos_usu where "
                    + "id_per='"+usuario+"'");
            
            conn.close();
            
        }catch (SQLException e){
          System.err.println(e.getMessage());
          javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
          //return false;
        }
        return cadena;
    }//insertUsuario()
 public static void main(String ar[]){
     
 }
}//class