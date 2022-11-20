/*
 Conjunto de operaciones que voy a poder realizar sobre una persona (capa: acceso a datos)
 */

        
package datos;
//Importar la clase Usuario dentro de la carpeta dominio:
import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import dominio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author ilc19
 */
public class UsuarioDao implements IAccesoDatosUsuario {
    //Método para buscar personas
    private static final String SQL_SELECT="SELECT * FROM usuario";
    //Método para dar de alta
    private static final String SQL_INSERT="INSERT INTO usuario (nick,clave,correo,genero,interes,edad,longitud,latitud) value(?,?,?,?,?,?,?,?)";
    //Método para actualizar
    private static final String SQL_UPDATE="UPDATE usuario SET nick=?, clave=?, genero=?, interes=?, longitud=?, latitud=? WHERE idUsuario= ?";
    //Método para Borrar
   private static final String SQL_DELETE="DELETE FROM usuario where idUsuario=?";
    //Función que nos lista todas las personas de nuestro sistema
   
    public List<Usuario> seleccionar() throws SQLException{
    //LEER LA BBDD:
        //Inicializo mis variables
        Connection conn=null;
        PreparedStatement stmt=null;
        //para optener resultados
        ResultSet rs=null;
        Usuario usuario=null;
        //ArrayList que contiene todos los usuarios que estan dentro de la base de datos:
        List<Usuario>usuarios=new ArrayList<>();
        //1. Establecemos conexión:
        conn=getConnection();
        //2. Preparo mi instruccion para ejecutarla contra la bbdd
        stmt=conn.prepareStatement(SQL_SELECT);
        //3. Ejecuto la query
        rs=stmt.executeQuery();
        //Itero, de cada registro coge la infor para instanciarlos después
        while(rs.next()){
            //String nick, String correo, String clave, boolean genero, boolean interes, LocalDateTime fechaNacimiento, String ubicacion
            Integer idUsuario=rs.getInt("idUsuario");
            String nick=rs.getString("Nick");
            String clave=rs.getString("Clave");
            String correo=rs.getString("Correo");
            Boolean genero=rs.getBoolean("Genero");
            Boolean interes=rs.getBoolean("Interes");
            Integer edad=rs.getInt("Edad");
            Double longitud=rs.getDouble("longitud");
            Double latitud=rs.getDouble("latitud");
            
            //Instancia en el Arrays con la información recogida en la iteración
            usuarios.add(new Usuario(idUsuario,nick,clave,correo,genero,interes,edad,longitud,latitud));
        }
        close(rs);
        close(stmt);
        close(conn);
        return usuarios;   
    }
    
    //INSERTAR PERSONAS EN LA BBDD:
    //Función que inserta una persona en mi sistema, pasándole un objeto a través de un formulario:
   
    public int insertar(Usuario usuario){
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
            stmt.setString(1/*interrogante 1*/, usuario.getNick()/*recibo el atributo*/);
            stmt.setString(2/*interrogante 2*/, usuario.getClave()/*recibo el atributo*/);
            stmt.setString(3/*interrogante 3*/, usuario.getCorreo()/*recibo el atributo*/);
            stmt.setBoolean(4, usuario.isGenero());
            stmt.setBoolean(5, usuario.isInteres());
            stmt.setInt(6,usuario.getEdad());
            stmt.setDouble(7, usuario.getLongitud());
            stmt.setDouble(8, usuario.getLatitud());
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
    public int actualizar(Usuario usuario){
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
            //nick=?, clave=?, genero=?, interes=?, longitud=?, latitud=? WHERE idUsuario= ?
            stmt.setString(1/*interrogante 1*/, usuario.getNick()/*recibo el atributo*/);
            stmt.setString(2/*interrogante 3*/, usuario.getClave()/*recibo el atributo*/);
            stmt.setBoolean(3, usuario.isGenero());
            stmt.setBoolean(4, usuario.isInteres());
            stmt.setDouble(5, usuario.getLongitud());
            stmt.setDouble(6, usuario.getLatitud());
            stmt.setInt(7, usuario.getIdUsuario());
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
    public int borrar(Usuario usuario){
         //declaro e inicializo mis var
        Connection conn=null;
        PreparedStatement stmt=null;
        int eliminar=0;
     
        try {
            conn=getConnection();
            stmt=conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdUsuario());
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
