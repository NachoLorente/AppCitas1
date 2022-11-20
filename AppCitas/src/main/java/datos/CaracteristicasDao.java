/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;
//Importar la clase Caracteristicas dentro de la carpeta dominio:
import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import dominio.Caracteristicas;
//import dominio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
/**
 *
 * @author ilc19
 */
public class CaracteristicasDao implements IAccesoDatosCaracteristicas{
    //Método para buscar características
    private static final String SQL_SELECT="SELECT * FROM caracteristicas";
    //Método para dar de alta
    //idUsuario, bio, trabajo, formacion, ciudad, estatura, alcohol, deporte, tabaco, hijos, fotos
    private static final String SQL_INSERT="INSERT INTO caracteristicas (idUsuario,bio,trabajo,formacion,ciudad,estatura,alcohol,deporte,tabaco,hijos,fotos) value(?,?,?,?,?,?,?,?,?,?,?)";
    //Método para actualizar: 
    private static final String SQL_UPDATE="UPDATE caracteristicas SET bio=?, trabajo=?, formacion=?, ciudad=?, alcohol=?, deporte=?, tabaco=?, hijos=?, fotos=? WHERE idUsuario= ?";
    //Método para Borrar
    //private static final String SQL_DELETE="DELETE FROM caracteristicas where idCaracteristicas=?";
    private static final String SQL_DELETE="DELETE FROM caracteristicas where idUsuario=?";
    
    
    //Función que nos lista todas las personas de nuestro sistema
    public List<Caracteristicas> seleccionar() throws SQLException{
        //LEER LA BBDD:
        //Inicializo mis variables
        Connection conn=null;
        PreparedStatement stmt=null;
        //para optener resultados
        ResultSet rs=null;
        Caracteristicas caracteristica=null;
        List<Caracteristicas>caracteristicas=new ArrayList<>();
         //1. Establecemos conexión:
        conn=getConnection();
        //2. Preparo mi instruccion para ejecutarla contra la bbdd
        stmt=conn.prepareStatement(SQL_SELECT);
        //3. Ejecuto la query
        rs=stmt.executeQuery();
        //Itero, de cada registro coge la infor para instanciarlos después
        while(rs.next()){
            //idUsuario, bio, trabajo, formacion, ciudad, estatura, alcohol, deporte, tabaco, hijos, fotos
            Integer idCaracteristicas=rs.getInt("idCaracteristicas");
            Integer idUsuario=rs.getInt("idUsuario");
            String bio=rs.getString("Bio");
            String trabajo=rs.getString("Trabajo");
            String formacion=rs.getString("Formacion");
            String ciudad=rs.getString("Ciudad");
            Integer estatura=rs.getInt("Estatura");
            Boolean alcohol=rs.getBoolean("Alcohol");
            Boolean deporte=rs.getBoolean("Deporte");
            Boolean tabaco=rs.getBoolean("Tabaco");
            Boolean hijos=rs.getBoolean("Hijos");
            String fotos=rs.getString("fotos");
            //Instancia con la información recogida en la iteración
            caracteristicas.add(new Caracteristicas(idCaracteristicas,idUsuario,bio,trabajo,formacion,ciudad,estatura,alcohol,deporte,tabaco,hijos,fotos));
        }
        close(rs);
        close(stmt);
        close(conn);
        return caracteristicas; 
    }
    
    //INSERTAR PERSONAS EN LA BBDD:
    //Función que inserta una persona en mi sistema, pasándole un objeto a través de un formulario:
    public int insertar(Caracteristicas caracteristica){
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
            stmt.setInt(1/*interrogante 1*/, caracteristica.getIdUsuario()/*recibo el atributo*/);
            stmt.setString(2/*interrogante 2*/, caracteristica.getBio()/*recibo el atributo*/);
            stmt.setString(3/*interrogante 3*/, caracteristica.getTrabajo()/*recibo el atributo*/);
            stmt.setString(4, caracteristica.getFormacion());
            stmt.setString(5, caracteristica.getCiudad());
            stmt.setInt(6, caracteristica.getEstatura());
            stmt.setBoolean(7, caracteristica.isAlcohol());
            stmt.setBoolean(8, caracteristica.isDeporte());
            stmt.setBoolean(9, caracteristica.isTabaco());
            stmt.setBoolean(10, caracteristica.isHijos());
            stmt.setString(11, caracteristica.getFotos());
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
    
     //ACTUALIZAR DATOS:
    public int actualizar(Caracteristicas caracteristica){
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
            //bio=?, trabajo=?, formacion=?, ciudad=?, alcohol=?, deporte=?, tabaco=?, hijos=?, fotos=?, IdUsuario=?
            stmt.setString(1/*posición de inserción del atributo*/, caracteristica.getBio()/*recibo el atributo en esa posición*/);
            stmt.setString(2, caracteristica.getTrabajo());
            stmt.setString(3, caracteristica.getFormacion());
            stmt.setString(4, caracteristica.getCiudad());
            stmt.setBoolean(5, caracteristica.isAlcohol());
            stmt.setBoolean(6, caracteristica.isDeporte());
            stmt.setBoolean(7, caracteristica.isTabaco());
            stmt.setBoolean(8, caracteristica.isHijos());
            stmt.setString(9, caracteristica.getFotos());
            stmt.setInt(10,caracteristica.getIdUsuario());
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
    
     //BORRAR DATOS:
    public int borrar(Caracteristicas caracteristica){
         //declaro e inicializo mis var
        Connection conn=null;
        PreparedStatement stmt=null;
        int eliminar=0;
        try {
            conn=getConnection();
            stmt=conn.prepareStatement(SQL_DELETE);
//            stmt.setInt(1, caracteristica.getIdCaracteristicas());
            //Asignar los valores a los interrogantes de la consulta UPDATE:
            stmt.setInt(1, caracteristica.getIdUsuario());
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
