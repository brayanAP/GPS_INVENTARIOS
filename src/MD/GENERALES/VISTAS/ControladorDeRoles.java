
package MD.GENERALES.VISTAS;

import javax.swing.JTabbedPane;


public class ControladorDeRoles {
    
    public static void ocultarModulosDefecto(JTabbedPane modulosContenedor){
        
           //Eliminara los modulos para el usuario por defecto
           modulosContenedor.removeTabAt(3);
           modulosContenedor.removeTabAt(2);
           modulosContenedor.removeTabAt(1);
    }
    public static void tipoAdministrador(JTabbedPane modulosContenedor){
        
           //Eliminara los modulos para el usuario por defecto
           modulosContenedor.removeTabAt(1);
          
    }
     public static void tipoAdministracion(JTabbedPane modulosContenedor){
        
           //Eliminara los modulos para el usuario por defecto
           modulosContenedor.removeTabAt(2);
           modulosContenedor.removeTabAt(1);
           
           
    }
      public static void tipoAlmacenista(JTabbedPane modulosContenedor){
        
           //Eliminara los modulos para el usuario por defecto
           modulosContenedor.removeTabAt(2);
           modulosContenedor.removeTabAt(1);
           
          
    }
      public static void tipoSecretaria(JTabbedPane modulosContenedor){
        
           //Eliminara los modulos para el usuario por defecto
           modulosContenedor.removeTabAt(2);
           modulosContenedor.removeTabAt(1);
           
           
    }
}
