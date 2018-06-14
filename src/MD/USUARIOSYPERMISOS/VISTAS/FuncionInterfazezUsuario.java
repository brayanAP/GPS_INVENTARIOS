/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD.USUARIOSYPERMISOS.VISTAS;

/**
 *
 * @author juanramon
 */
import javax.swing.*;
public class FuncionInterfazezUsuario {
 
    
    public static void descripcionTipoUsuario(JComboBox cmb,JTextPane txtDescripcion){
        
        if(cmb.getSelectedIndex()==0){
            txtDescripcion.setText("");
            txtDescripcion.setText("Este tipo de usuario tiene acceso al"
                    + " inventario y Usuarios del sistema"
                    + " se recomienda que utilize este tipo "
                    + " para un administrador del sistema");
        }
        if(cmb.getSelectedIndex()==1){
            txtDescripcion.setText("");
            txtDescripcion.setText("Este tipo de usuario tiene acceso al"
                    + " Personal, se recomienta que utilize este tipo para "
                    + " el area administrativa");
        }
          if(cmb.getSelectedIndex()==2){
            txtDescripcion.setText("");
            txtDescripcion.setText("Este tipo de usuario tiene acceso al"
                    + " al inventario, se recomienda que utilize este tipo"
                    + " para el Almacenista");
        }
         if(cmb.getSelectedIndex()==3){
                txtDescripcion.setText("");
            txtDescripcion.setText("Este tipo de usuario tiene acceso al"
                    + " personal, se recomienda que utilize este tipo "
                    + " para el Secretari@");
        }
    }
}
