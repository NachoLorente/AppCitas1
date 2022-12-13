/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author ilc19
 */
public class Premium implements Serializable{
    private int idPremium;
    private int idUsuario;
    private Date fechaAlta;
    private Date fechaBaja;
    private double precio;
    //con todo:
    public Premium(int idPremium, int idUsuario, Date fechaAlta, Date fechaBaja, double precio) {
        this.idPremium = idPremium;
        this.idUsuario = idUsuario;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.precio = precio;
        
    }
    //vacio:
    public Premium() {
    }
    //con precio por defecto:
    public Premium(int idUsuario, Date fechaAlta, Date fechaBaja) {
        this.idUsuario = idUsuario;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.precio=12.95;
    }
    //para los update:
    public Premium(int idUsuario, Date fechaAlta, Date fechaBaja, double precio) {
        this.idUsuario = idUsuario;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.precio = precio;
    }
    //para los deletel:

    public Premium(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    //GET & SET:
    public int getIdPremium() {
        return idPremium;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    //HashCode & Equals
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.idPremium;
        hash = 13 * hash + this.idUsuario;
        hash = 13 * hash + Objects.hashCode(this.fechaAlta);
        hash = 13 * hash + Objects.hashCode(this.fechaBaja);
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Premium other = (Premium) obj;
        if (this.idPremium != other.idPremium) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (!Objects.equals(this.fechaAlta, other.fechaAlta)) {
            return false;
        }
        return Objects.equals(this.fechaBaja, other.fechaBaja);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("idUsuario: ").append(idUsuario);
        sb.append("\n\tidPremium: ").append(idPremium);
        sb.append("\n\tAlta-Baja: ").append(fechaAlta);
        sb.append(" a ").append(fechaBaja);
        sb.append("\n\tprecio: ").append(precio);
        sb.append("€");
        return sb.toString();
    }
    
}
