/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import dominio.Premium;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ilc19
 */
public interface IAccesoDatosPremium {
    public List<Premium> seleccionar() throws SQLException;
    public int insertar(Premium premium);
    public int actualizar(Premium premium);
    public int borrar(Premium premium);
}
