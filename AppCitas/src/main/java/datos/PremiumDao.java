/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

/**
 *
 * @author ilc19
 */
import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import dominio.Premium;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class PremiumDao implements IAccesoDatosPremium{
    //Método para buscar características
    private static final String SQL_SELECT="SELECT * FROM premium";
    //Método para dar de alta
    //int idPremium, int idUsuario, Date fechaAlta, Date fechaBaja, double precio
    private static final String SQL_INSERT="INSERT INTO premium (idUsuario, fechaAlta, fechaBaja, precio) value(?,?,?,?)";
    //Método para actualizar: 
    private static final String SQL_UPDATE="UPDATE premium SET fechaBaja=?, precio=? WHERE idUsuario= ?";
    //Método para Borrar
    //private static final String SQL_DELETE="DELETE FROM caracteristicas where idCaracteristicas=?";
    private static final String SQL_DELETE="DELETE FROM premium where idUsuario=?";
    
    
    
    @Override
    //Función que nos lista todas las personas de nuestro sistema
    public List<Premium> seleccionar() throws SQLException{
        //LEER LA BBDD:
        //Inicializo mis variables
        Connection conn=null;
        PreparedStatement stmt=null;
        //para optener resultados
        ResultSet rs=null;
        Premium Premium=null;
        List<Premium>premium=new ArrayList<>();
         //1. Establecemos conexión:
        conn=getConnection();
        //2. Preparo mi instruccion para ejecutarla contra la bbdd
        stmt=conn.prepareStatement(SQL_SELECT);
        //3. Ejecuto la query
        rs=stmt.executeQuery();
        //Itero, de cada registro coge la infor para instanciarlos después
        while(rs.next()){
            //int idPremium, int idUsuario, Date fechaAlta, Date fechaBaja, double precio
            Integer idPremium=rs.getInt("idPremium");
            Integer idUsuario=rs.getInt("idUsuario");
            Date fechaAlta=rs.getDate("fechaAlta");
            Date fechaBaja=rs.getDate("fechaBaja");
            Double precio=rs.getDouble("precio");
            //Instancia con la información recogida en la iteración
            premium.add(new Premium(idPremium,idUsuario,fechaAlta,fechaBaja,precio));
        }
        close(rs);
        close(stmt);
        close(conn);
        return premium; 
    }
    @Override
    //INSERTAR PERSONAS EN LA BBDD:
    //Función que inserta una persona en mi sistema, pasándole un objeto a través de un formulario:
    public int insertar(Premium premium){
         //declaro e inicializo mis var
        Connection conn=null;
        PreparedStatement stmt=null;
        int registro=0;
        try {
            //1. Establecemos conexión:
            conn=getConnection();
            //2. Preparo mi instruccion para ejecutarla contra la bbdd
            stmt=conn.prepareStatement(SQL_INSERT);
            //Asignar los valores a los interrogantes de la consulta:
//          idUsuario, fechaAlta, fechaBaja, precio
            stmt.setInt(1/*interrogante 1*/, premium.getIdUsuario()/*recibo el atributo*/);
            stmt.setDate(2, premium.getFechaAlta());
            stmt.setDate(3, premium.getFechaBaja());
            stmt.setDouble(4, premium.getPrecio());
            //3. Ejecuto la query
            registro=stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);        
            }     
        }
        return registro;
    }
    @Override
     //ACTUALIZAR DATOS:
    public int actualizar(Premium premium){
        //declaro e inicializo mis var
        Connection conn=null;
        PreparedStatement stmt=null;
        
        int actualizacion=0;
        
        try {
            //1. Establecemos conexión:
            conn=getConnection();
            //2. Preparo mi instruccion para ejecutarla contra la bbdd
            stmt=conn.prepareStatement(SQL_UPDATE);
            //Asignar los valores a los interrogantes de la consulta UPDATE:
            //fechaAlta=?, fechaBaja=?, precio=?, IdUsuario=?
            stmt.setDate(1, premium.getFechaBaja());
            stmt.setDouble(2, premium.getPrecio());
            stmt.setInt(3, premium.getIdUsuario());
            //3. Ejecuto la query
            actualizacion=stmt.executeUpdate();
        //Excepción
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return actualizacion;
    }
    @Override
 //BORRAR DATOS:
    public int borrar(Premium premium){
         //declaro e inicializo mis var
        Connection conn=null;
        PreparedStatement stmt=null;
        int eliminar=0;
        try {
            conn=getConnection();
            stmt=conn.prepareStatement(SQL_DELETE);
            //Asignar los valores a los interrogantes de la consulta UPDATE:
            stmt.setInt(1, premium.getIdUsuario());
            //3. Ejecuto la query
            eliminar=stmt.executeUpdate();
        //Excepción
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return eliminar;
    }
}
