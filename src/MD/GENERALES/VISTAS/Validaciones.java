
package MD.GENERALES.VISTAS;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Validaciones {
    
    
    //validara el campo de usuario
    public boolean validarUsuario(JTextField usuario,JLabel palomita){
        boolean validado=false;
        
        String entrada =usuario.getText();
       
        if(entrada.length()>5&&entrada.matches("[A-Z]*")){
            validado=true;
            palomita.setVisible(true);
            usuario.setForeground(Color.black);
             usuario.setText(usuario.getText().toUpperCase());
        }else{
            usuario.setForeground(Color.red);
            palomita.setVisible(false);
             validado=false;
             usuario.setText(usuario.getText().toUpperCase());
        }
        
       
        return validado;
    }//ValidarCampUsuario
    
    public boolean validarPASS(JPasswordField pass,JLabel palomita){
        boolean validado=false;
        
        String entrada =pass.getText();
       
        if(entrada.length()>5&&entrada.matches("[a-z_0-9_A-Z_Ñ_ñ]*")){
            validado=true;
             pass.setForeground(Color.black);
            palomita.setVisible(true);
           
        }else{
            pass.setForeground(Color.red);
            palomita.setVisible(false);
             validado=false;
        }
        
       
        return validado;
    }//ValidarCampUsuari
}
