
package conexion;

import java.sql.*;
import javax.swing.JOptionPane;





public class Conexion {

    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/pruebas_dp?autoReconnect=true&useSSL=false";
    private static final String user = "root";
    private static final String pass = "password";
    public Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Connection getConnection(){
         con = null;
         try {
            //Pasamos los valores para crear la coneccion
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException |SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage(), "conecion Realizada correctamente", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
    
    public void close(){
        try {
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al cerrar la conexcion", JOptionPane.ERROR_MESSAGE);
        }
    }

}
