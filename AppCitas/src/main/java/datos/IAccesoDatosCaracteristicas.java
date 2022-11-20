/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import dominio.Caracteristicas;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ilc19
 */
public interface IAccesoDatosCaracteristicas {
    public List<Caracteristicas> seleccionar() throws SQLException;
    public int insertar(Caracteristicas caracteristica);
    public int actualizar(Caracteristicas caracteristica);
    public int borrar(Caracteristicas caracteristica);
    
}
