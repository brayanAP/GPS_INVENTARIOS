/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD.PERSONAL.VISTAS;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ValidacionesPersonal {
    //Para validar si un dato es numerico
     public static boolean isNumeric(String str) {
        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
    }
     
 public static void validarNombre(JTextField txtNombreP, JLabel p1){
     if(txtNombreP.getText()==null||txtNombreP.getText().length()<3||isNumeric(txtNombreP.getText())||txtNombreP.getText().matches("[a-zA-Z_0-9_ ]*")==false){
         txtNombreP.setForeground(Color.red);
          p1.setVisible(false);
     }else{
        txtNombreP.setForeground(Color.black);
     
         p1.setVisible(true);
         
     }
 }
      public static void validarApPat(JTextField txtApePat, JLabel p2){
     if(txtApePat.getText()==null||txtApePat.getText().length()<3||isNumeric(txtApePat.getText())==true||txtApePat.getText().matches("[a-zA-Z_0-9_ ]*")==false){
         txtApePat.setForeground(Color.red);
          p2.setVisible(false);
     }else{
        txtApePat.setForeground(Color.black);
     
         p2.setVisible(true);
         
     }
 }
  public static void validarApMat(JTextField txtApeMat, JLabel p3){
     if(txtApeMat.getText()==null||txtApeMat.getText().length()<3||isNumeric(txtApeMat.getText())==true||txtApeMat.getText().matches("[a-zA-Z_0-9_ ]*")==false){
         txtApeMat.setForeground(Color.red);
          p3.setVisible(false);
     }else{
        txtApeMat.setForeground(Color.black);
     
         p3.setVisible(true);
         
     }
     
 }
public static void validarFechaNacP(JTextField txtFechaNacP,JLabel p4){
  if(txtFechaNacP.getText().length()==4){
      String año=txtFechaNacP.getText();
      txtFechaNacP.setText(año+"-");
  }
    if(txtFechaNacP.getText().length()==7){
      String mes=txtFechaNacP.getText();
      txtFechaNacP.setText(mes+"-");
  }
    if(txtFechaNacP.getText()==null||txtFechaNacP.getText().length()<9||txtFechaNacP.getText().length()>10||txtFechaNacP.getText().matches("[0-9_-]*")==false){
        
       txtFechaNacP.setForeground(Color.red);
       p4.setVisible(false);
    }else
    {
       txtFechaNacP.setForeground(Color.black);
       p4.setVisible(true); 
    }
}
public static void validarCol(JTextField txtDato, JLabel p5){
     if(txtDato.getText()==null||txtDato.getText().length()<3||isNumeric(txtDato.getText())==true||txtDato.getText().matches("[a-zA-Z_0-9_ ]*")==false){
         txtDato.setForeground(Color.red);
          p5.setVisible(false);
     }else{
        txtDato.setForeground(Color.black);
     
         p5.setVisible(true);
         
     }
     
 }
public static void validarCalle(JTextField txtDato, JLabel p6){
     if(txtDato.getText()==null||txtDato.getText().length()<3||isNumeric(txtDato.getText())==true||txtDato.getText().matches("[A-Z_a-z_ ]*")==false){
         txtDato.setForeground(Color.red);
          p6.setVisible(false);
     }else{
        txtDato.setForeground(Color.black);
     
         p6.setVisible(true);
         
     }
     
 }
public static void validarNumCalle(JTextField txtDato, JLabel p7){
    try{
       
        
     if(txtDato.getText()==null||isNumeric(txtDato.getText())==false||Integer.parseInt(txtDato.getText())<=0||Integer.parseInt(txtDato.getText())>=100000){
         txtDato.setForeground(Color.red);
          p7.setVisible(false);
     }else{
        txtDato.setForeground(Color.black);
     
         p7.setVisible(true);
         
     }
    }catch(NumberFormatException e){
      txtDato.setForeground(Color.red);
          p7.setVisible(false);
        
    }
     
 }
public static void validarCodigoP(JTextField txtDato, JLabel p7){
    try{
       
        
     if(txtDato.getText()==null||isNumeric(txtDato.getText())==false||Integer.parseInt(txtDato.getText())<=0||Integer.parseInt(txtDato.getText())>=100000){
         txtDato.setForeground(Color.red);
          p7.setVisible(false);
     }else{
        txtDato.setForeground(Color.black);
     
         p7.setVisible(true);
         
     }
    }catch(NumberFormatException e){
      txtDato.setForeground(Color.red);
          p7.setVisible(false);
        
    }
     
 }
public static void validarTel(JTextField txtDato, JLabel p9){
  
       try{
        
     if(txtDato.getText()==null||txtDato.getText().length()>10||isNumeric(txtDato.getText())==false||Long.parseLong(txtDato.getText())<=0||txtDato.getText().length()<10){
         txtDato.setForeground(Color.red);
          p9.setVisible(false);
     }else{
        txtDato.setForeground(Color.black);
     
         p9.setVisible(true);
         
     }
       }catch(NumberFormatException e){
         txtDato.setForeground(Color.red);
          p9.setVisible(false);   
       }
     
 }
public static void validarCurp(JTextField txtDato, JLabel p10){
  
       try{
        
     if(txtDato.getText()==null||txtDato.getText().length()>18||txtDato.getText().length()<18||txtDato.getText().matches("[A-Z_0-9]*")==false||txtDato.getText().matches("[_]*")==true){
         txtDato.setText(txtDato.getText().toUpperCase());
         txtDato.setForeground(Color.red);
          p10.setVisible(false);
     }else{
        
        txtDato.setForeground(Color.black);
     
         p10.setVisible(true);
         
     }
       }catch(NumberFormatException e){
         txtDato.setForeground(Color.red);
          p10.setVisible(false);   
       }
     
 }
public static void validarRFC(JTextField txtDato, JLabel p11){
  
       try{
        
     if(txtDato.getText()==null||txtDato.getText().length()>13||txtDato.getText().length()<=11||txtDato.getText().matches("[A-Z_0-9]*")==false||txtDato.getText().matches("[_]*")==true){
         txtDato.setForeground(Color.red);
           txtDato.setText(txtDato.getText().toUpperCase());
          p11.setVisible(false);
     }else{
        txtDato.setForeground(Color.black);
     
         p11.setVisible(true);
         
     }
       }catch(NumberFormatException e){
         txtDato.setForeground(Color.red);
          p11.setVisible(false);   
       }
     
 }
public static void validarLicM(JTextField txtDato, JLabel p12){
  
       try{
        
     if(txtDato.getText()==null||txtDato.getText().length()>10||txtDato.getText().length()<10||txtDato.getText().matches("[A-Z_0-9]*")==false||txtDato.getText().matches("[_]*")==true){
          txtDato.setText(txtDato.getText().toUpperCase());
         txtDato.setForeground(Color.red);
          p12.setVisible(false);
     }else{
        txtDato.setForeground(Color.black);
     
         p12.setVisible(true);
         
     }
       }catch(NumberFormatException e){
         txtDato.setForeground(Color.red);
          p12.setVisible(false);   
       }
     
 }
public static void validarClaveElector(JTextField txtDato, JLabel p13){
  
       try{
        
     if(txtDato.getText()==null||txtDato.getText().length()>18||txtDato.getText().length()<18||txtDato.getText().matches("[A-Z_0-9]*")==false||txtDato.getText().matches("[_]*")==true){
         txtDato.setText(txtDato.getText().toUpperCase());
         txtDato.setForeground(Color.red);
          p13.setVisible(false);
     }else{
        txtDato.setForeground(Color.black);
     
         p13.setVisible(true);
         
     }
       }catch(NumberFormatException e){
         txtDato.setForeground(Color.red);
          p13.setVisible(false);   
       }
     
 }
public static void validarCmbArea(JComboBox cmbArea,JLabel p14){
    
    if(cmbArea.getSelectedIndex()==0 ){
     
        p14.setVisible(false);
    }else{p14.setVisible(true);}
   
}
public void validarCmbPuesto(JComboBox cmbPuesto, JLabel p15){
   if(cmbPuesto.getSelectedIndex()==0){
    
    p15.setVisible(false);
    }else{p15.setVisible(true);}  
}

/*______________________________________________________-----

VALIDACIONES PARA LA INTERFAZ DE PUESTOS
_______________________________________________________
*/
public void validarNombrePuesto(JTextField txtDato,JLabel p1){
     try{
        
     if(txtDato.getText()==null||txtDato.getText().matches("[A-Z_ ]*")==false||txtDato.getText().matches("[_]*")==true){
         txtDato.setText(txtDato.getText().toUpperCase());
         txtDato.setForeground(Color.red);
          p1.setVisible(false);
     }else{
        txtDato.setForeground(Color.black);
     
         p1.setVisible(true);
         
     }
       }catch(NumberFormatException e){
         txtDato.setForeground(Color.red);
          p1.setVisible(false);   
       }
}
public void validarFolio(JTextField txtDato,JLabel p1){
     try{
        
     if(txtDato.getText()==null||txtDato.getText().matches("[A-Z_0-9]*")==false||txtDato.getText().matches("[_]*")==true){
         txtDato.setText(txtDato.getText().toUpperCase());
         txtDato.setForeground(Color.red);
          p1.setVisible(false);
     }else{
        txtDato.setForeground(Color.black);
     
         p1.setVisible(true);
         
     }
       }catch(NumberFormatException e){
         txtDato.setForeground(Color.red);
          p1.setVisible(false);   
       }
}
public void validarSalario(JTextField txtDato,JLabel p1){
     try{
        double salario= Double.parseDouble(txtDato.getText());
        txtDato.setForeground(Color.black);
     
         p1.setVisible(true);
        }catch(NumberFormatException e){
         txtDato.setForeground(Color.red);
          p1.setVisible(false);   
       }
}
public void validarNombreArea(JTextField txtDato,JLabel p1){
     try{
        
     if(txtDato.getText()==null||txtDato.getText().matches("[0-9]*")==true||txtDato.getText().matches("[A-Z_ ]*")==false||txtDato.getText().matches("[_]*")==true){
         txtDato.setText(txtDato.getText().toUpperCase());
         txtDato.setForeground(Color.red);
          p1.setVisible(false);
     }else{
        txtDato.setForeground(Color.black);
     
         p1.setVisible(true);
         
     }
       }catch(NumberFormatException e){
         txtDato.setForeground(Color.red);
          p1.setVisible(false);   
       }
}
public void validarDescripcionArea(JTextArea txtDato,JLabel p1){
     try{
        
     if(txtDato.getText()==null||txtDato.getText().matches("[0-9]*")==true||txtDato.getText().matches("[_]*")==true||txtDato.getText().length()<10){
         txtDato.setForeground(Color.red);
          p1.setVisible(false);
     }else{
        txtDato.setForeground(Color.black);
     
         p1.setVisible(true);
         
     }
       }catch(NumberFormatException e){
         txtDato.setForeground(Color.red);
          p1.setVisible(false);   
       }
}

}
