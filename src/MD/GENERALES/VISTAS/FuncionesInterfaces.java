/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD.GENERALES.VISTAS;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Calendar;
import javax.swing.JLabel;

/**
 *
 * @author juanramon
 */
public class FuncionesInterfaces {
 
     public void goToURL(String URL){
           if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                try {
                    java.net.URI uri = new java.net.URI(URL);
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    
                             }
                        }
                     }  
      }//Abiri navegador
      
     public int saludoPorHora(JLabel saludo){
         Calendar c = Calendar.getInstance(); 
  
         int amOpm = c.get(Calendar.AM_PM);
         
         if(amOpm==0){
             saludo.setText("Buenos dias!!...");
         }else if(amOpm==1){
              saludo.setText("Buenas Tardes!!...");  
         }
         return 0;
     }
     
}
