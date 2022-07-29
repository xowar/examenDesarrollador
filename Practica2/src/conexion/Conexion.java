
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Conexion {
    public static void main(String[] args){
        String url="jdbc:mysql://localhost:3306/pruebas_dp";
        String user="root";
        String pass="password";
        try {
            //Pasamos los valores para crear la coneccion
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            //Consulta las tablas de la db
            ResultSet rs = st.executeQuery("show tables;");
            while(rs.next()){
                //Muestra las tablas encontradas por la consulta
                System.out.println(rs.getString(1));
            }
            System.out.println(rs.next());
            System.out.println("Conectado");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
