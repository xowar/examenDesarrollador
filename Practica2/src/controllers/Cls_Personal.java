
package controllers;
import java.sql.PreparedStatement;
import conexion.Conexion;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author madio
 */
public class Cls_Personal {
   
    private final String SQL_INSERT_PERSONS ="INSERT INTO persons (id,nombre,appaterno,apmaterno) values (?,?,?,?)";
    private final String SQL_INSERT_ADDRESES ="INSERT INTO addresses (id,calle,numero,colonia) values (?,?,?,?)";
    private final String SQL_INSERT_DISTRIBUTORS ="INSERT INTO distributors (id,fecharegistro) values (?,?)";

    private PreparedStatement PS;
    private  final Conexion CN;
    
    public Cls_Personal(){
        PS = null;
        CN = new Conexion();
    }
    
    public int insertDatosPersons(String id, String nombre, String appaterno, String apmaterno){
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_PERSONS);
            PS.setString(1, id);
            PS.setString(2, nombre);
            PS.setString(3, appaterno);
            PS.setString(4, apmaterno);
            int res = PS.executeUpdate();
            if (res > 0) {
                //JOptionPane.showMessageDialog(null, "Registro Guardado");
            }
        } catch (SQLException e) {
            System.err.println("Error al guardar los datos" + e.getMessage());
        } finally{
            PS = null;
            CN.close();
        }
        return 0;
    }
    
    public int insertDatosAddresses(String id, String calle, String numero, String colonia){
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_ADDRESES);
            PS.setString(1, id);
            PS.setString(2, calle);
            PS.setString(3, numero);
            PS.setString(4, colonia);
            int res = PS.executeUpdate();
            if (res > 0) {
                //JOptionPane.showMessageDialog(null, "Registro Guardado");
            }
        } catch (SQLException e) {
            System.err.println("Error al guardar los datos" + e.getMessage());
        } finally{
            PS = null;
            CN.close();
        }
        return 0;
    }
    
    public int insertDatosDistributors(String id){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
            Date fechaActual = new Date();

           
            PS = CN.getConnection().prepareStatement(SQL_INSERT_DISTRIBUTORS);
            PS.setString(1, id);
            PS.setString(2, sdf.format(fechaActual));
            int res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            }
        } catch (SQLException e) {
            System.err.println("Error al guardar los datos" + e.getMessage());
        } finally{
            PS = null;
            CN.close();
        }
        return 0;
    }
        
    
    
}
