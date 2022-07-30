
package conexion;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Conexion {
    
    String driver="com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/pruebas_dp?autoReconnect=true&useSSL=false";
    String user = "root";
    String pass = "password";
    Connection CN=null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Conexion(){
        CN = null;
    }
    
    public Connection getConnection(){
         try {
            //Pasamos los valores para crear la coneccion
            Class.forName(driver);
            CN = DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException |SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage(), "conecion Realizada correctamente", JOptionPane.ERROR_MESSAGE);
        }
        return CN;
    }
    
    public void close(){
        try {
            CN.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al cerrar la conexcion", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args){
         Conexion c=new  Conexion();
    }
}
