/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ilc19
 */
public class Conexion {
     //conecto miapp con la bbdd de miapp
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/appcitas?useSLL=false"
            +"&useTimezone=true&serverTimezone=UTC"
            +"&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER="root";
    private static final String JDBC_PASSWORD="1234";
    //Método para establecer la conexión
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    //Conjunto de Métodos de cierre
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }    
    public static void close(Statement stm) throws SQLException{
        stm.close();
    } 
    public static void close(PreparedStatement stm) throws SQLException{
        stm.close();
    }
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}
