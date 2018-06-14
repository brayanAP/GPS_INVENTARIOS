/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD.USUARIOSYPERMISOS.VISTAS;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author juanramon
 */
public class Validaciones {
    
    public static void validarNombreUsuario(JTextField txtDato,JLabel p){
        if(txtDato.getText()==null||txtDato.getText().length()<6||txtDato.getText().length()>10||txtDato.getText().matches("[A-Z]*")==false){
            txtDato.setText(txtDato.getText().toUpperCase());
            
            txtDato.setForeground(Color.red);
            p.setVisible(false);
        }else{
           
                    
        txtDato.setForeground(Color.black);
            p.setVisible(true);
            
        }
    }
}
