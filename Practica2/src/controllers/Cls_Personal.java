
package controllers;
import java.sql.*;
import java.sql.PreparedStatement;
import conexion.Conexion;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;


/**
 *
 * @author madio
 */
public class Cls_Personal {
   
    private final String SQL_INSERT_PERSONS ="INSERT INTO persons (id,nombre,appaterno,apmaterno) values (?,?,?,?)";
    private final String SQL_INSERT_ADDRESES ="INSERT INTO addresses (id,calle,numero,colonia) values (?,?,?,?)";
    private final String SQL_INSERT_DISTRIBUTORS ="INSERT INTO distributors (id,fecharegistro) values (?,?)";
    //private final String SQL_SELECT = "SELECT * FROM persons";
    private DefaultTableModel DT;
    public ResultSet RS;
    private PreparedStatement PS;
    private  final Conexion con;
    private int res ;
    
    public Cls_Personal(){
        PS = null;
        con = new Conexion();
    }       
        
    public int insertDatosPersons(String id, String nombre, String appaterno, String apmaterno){
        try {
            PS = con.getConnection().prepareStatement(SQL_INSERT_PERSONS);
            PS.setString(1, id);
            PS.setString(2, nombre);
            PS.setString(3, appaterno);
            PS.setString(4, apmaterno);
            res = PS.executeUpdate();
            if (res > 0) {
                //JOptionPane.showMessageDialog(null, "Registro Guardado");
            }
        } catch (SQLException e) {
            System.err.println("Error al guardar los datos" + e.getMessage());
        } finally{
            PS = null;
            con.close();
        }
        return 0;
    }
    
    public int insertDatosAddresses(String id, String calle, String numero, String colonia){
        try {
            PS = con.getConnection().prepareStatement(SQL_INSERT_ADDRESES);
            PS.setString(1, id);
            PS.setString(2, calle);
            PS.setString(3, numero);
            PS.setString(4, colonia);
            res = PS.executeUpdate();
            if (res > 0) {
                //JOptionPane.showMessageDialog(null, "Registro Guardado");
            }
        } catch (SQLException e) {
            System.err.println("Error al guardar los datos" + e.getMessage());
        } finally{
            PS = null;
            con.close();
        }
        return 0;
    }
    
    public int insertDatosDistributors(String id){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
            Date fechaActual = new Date();
            PS = con.getConnection().prepareStatement(SQL_INSERT_DISTRIBUTORS);
            PS.setString(1, id);
            PS.setString(2, sdf.format(fechaActual));
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            }
        } catch (SQLException e) {
            System.err.println("Error al guardar los datos" + e.getMessage());
        } finally{
            PS = null;
            con.close();
        }
        return 0;
    }
    
    public void CompletarTabla(String table, JTable jtb_datos){
        String sql = "Select * from " + table;
        Statement st;
        Conexion con = new Conexion();
        Connection conexion = con.getConnection();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Ap Paterno");
        model.addColumn("Ap Materno");
        jtb_datos.setModel(model);
        
        String [] dato = new String[4];
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                dato[0] = rs.getString(1);
                dato[1] = rs.getString(2);
                dato[2] = rs.getString(3);
                dato[3] = rs.getString(4);
                model.addRow(dato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public void ConsultarRegistros(String id, JTable jtb_datos){
        String sql = "{call ListarDatosUnidos('"+id+"')}";
        Statement st;
        Conexion con = new Conexion();
        Connection conexion = con.getConnection();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre Completo");
        model.addColumn("Calle");
        model.addColumn("Numero de Casa");
        model.addColumn("Colonia");
        jtb_datos.setModel(model);
        String [] dato = new String[5];

        try {   
            st = conexion.createStatement();
            Connection conecta = con.getConnection();
            CallableStatement proc = conecta.prepareCall(sql);
            ResultSet rs = proc.executeQuery();
            

            while (rs.next()){
                dato[0] = rs.getString(1);
                dato[1] = rs.getString(2);
                dato[2] = rs.getString(3);
                dato[3] = rs.getString(4);
                dato[4] = rs.getString(5);
                model.addRow(dato);
            }
        } catch (SQLException e) {
            System.out.println("error");
        }
    }

}
