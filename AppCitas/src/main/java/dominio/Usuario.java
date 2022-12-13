/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ilc19
 */
public class Usuario implements Serializable{
   //VARIABLES:
    private int idUsuario;
    private String nick;
    private String clave;
    private String correo;
    private boolean genero;
    private boolean interes;
    private int edad;
    private Double longitud;
    private Double latitud;
    //CONSTRUCTORES:
    //VACIO:
    public Usuario() {
        
    }
    //para el administrador:
    public Usuario(String nick, String clave, String correo) {
        this.nick = nick;
        this.clave = clave;
        this.correo = correo;
    }
    
    //con todos los atributos:
    public Usuario(int idUsuario, String nick, String clave, String correo, boolean genero, boolean interes, int edad, Double longitud, Double latitud) {
        this.idUsuario=idUsuario;
        this.nick = nick;
        this.correo = correo;
        this.clave = clave;
        this.genero = genero;
        this.interes = interes;
        this.edad = edad;
        this.longitud = longitud;
        this.latitud=latitud;
    }
    
    //sin identidicador:
    public Usuario(String nick, String clave, String correo, boolean genero, boolean interes, int edad, Double longitud, Double latitud) {
        this.nick = nick;
        this.clave = clave;
        this.correo = correo;
        this.genero = genero;
        this.interes = interes;
        this.edad = edad;
        this.longitud = longitud;
        this.latitud = latitud;
    }
    
    //¿con solo identificador?:
    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    //solo correo:
    public Usuario(String correo) {
        this.correo = correo;
    }
    
    //con fecha y ubicación por defecto
    public Usuario(int idUsuario, String nick, String clave, String correo, boolean genero, boolean interes) {
        this.idUsuario= idUsuario;
        this.nick = nick;
        this.correo = correo;
        this.clave = clave;
        this.genero = genero;
        this.interes = interes;
        this.edad= 32;
        this.longitud=this.longitud=40.4165;
        this.latitud=this.latitud=-3.7025;
    }
    //para el SEARCH genero:
    public Usuario(String nick, boolean interes, int edad, Double longitud, Double latitud) {
        this.nick = nick;
        this.interes = interes;
        this.edad = edad;
        this.longitud = longitud;
        this.latitud = latitud;
    }
    
    
    //GET & SET:

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public boolean isInteres() {
        return interes;
    }

    public void setInteres(boolean interes) {
        this.interes = interes;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }
    
    //EQUAL & HASHCODE:

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.correo);
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.correo, other.correo);
    }  

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n identificador: ").append(idUsuario);
        sb.append("\n\t nick: ").append(nick);
        sb.append("\n\t clave: ").append(clave);
        sb.append("\n\t correo: ").append(correo);
        sb.append("\n\t genero: ").append(genero);
        sb.append("\n\t interes: ").append(interes);
        sb.append("\n\t Edad: ").append(edad);
        sb.append("\n\t longitud: ").append(longitud);
        sb.append("\n\t latitud: ").append(latitud);
        return sb.toString();
    }
}
