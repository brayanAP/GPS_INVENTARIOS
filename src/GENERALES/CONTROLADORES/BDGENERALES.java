/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GENERALES.CONTROLADORES;

import static GENERALES.CONTROLADORES.BDD.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author juanramon
 */
public class BDGENERALES {
    
     public boolean loguear(String nom_usu,String con_usu){
        //crea Conexion a la BD
        Connection conn = connect();
        String contraseña="";
        boolean loguear=false;
         String h[]= new String[1];
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
           
            contraseña=h[0];
            if(contraseña.equals(con_usu)){
                
                loguear=true;
                
            }else
            {
                loguear=false;
                showMessageDialog(null,"Ingrese su contraseña correcta");
            }
            return loguear;
            
        }catch (SQLException e){
          System.err.println(e.getMessage());
          javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
          return false;
        }catch (NullPointerException e){
            showMessageDialog(null,"EL usuario que usted ingreso no se encuentra en el sistema");
        }
         return false;
    }//insertUsuario()
       
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
     
     
     
     
     
}
