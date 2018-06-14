package GENERALES.CONTROLADORES;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class BDD {
    private final static String url = "jdbc:mysql://localhost:3306/ieenayarit";
    private final static String user = "root";
    private final static String pass = "12345";
    private static Connection connection;
        
    protected static Connection connect(){
        try{
            connection = (Connection) DriverManager.getConnection(url,user,pass);
        }catch(SQLException e){
           
              showMessageDialog(null,"La base de datos no esta disponible por que:"+"\n"+e.getMessage());
              
              System.exit(0);
        }
        return connection;
    }//connect()
  
}//class