/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import dominio.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ilc19
 */
public interface IAccesoDatosUsuario {
    public List<Usuario> seleccionar() throws SQLException;
    public int insertar(Usuario usuario);
    public int actualizar(Usuario usuario);
    public int borrar(Usuario usuario);
    public List<Usuario> buscarGen(boolean inte, boolean gen, int idU) throws SQLException;
}
