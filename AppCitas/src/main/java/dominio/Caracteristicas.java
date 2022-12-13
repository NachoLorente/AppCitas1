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
public class Caracteristicas implements Serializable{
    private int idCaracteristicas;
    private int idUsuario;
    private String bio;
    private String trabajo;
    private String formacion;
    private String ciudad;
    private Integer estatura;
    private boolean alcohol;
    private boolean deporte;
    private boolean tabaco;
    private boolean hijos;
    private String fotos;
//CONSTRUCTOR:
    //vacio:
    public Caracteristicas() {
      
    }
    
    //Para Delete
//    public Caracteristicas(int idCaracteristicas) {
//        this.idCaracteristicas = idCaracteristicas;
//    }
    public Caracteristicas(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    //completo:
    public Caracteristicas(int idCaracteristicas, int idUsuario, String bio, String trabajo, String formacion, String ciudad, Integer estatura, boolean alcohol, boolean deporte, boolean tabaco, boolean hijos, String fotos) {
        this.idCaracteristicas = idCaracteristicas;
        this.idUsuario=idUsuario;
        this.bio = bio;
        this.trabajo = trabajo;
        this.formacion = formacion;
        this.ciudad = ciudad;
        this.estatura = estatura;
        this.alcohol = alcohol;
        this.deporte = deporte;
        this.tabaco = tabaco;
        this.hijos = hijos;
        this.fotos = fotos;
    }
    
    //con bio, ciudad, fotos por defecto
    public Caracteristicas(int idUsuario, String trabajo, String formacion, Integer estatura, boolean alcohol, boolean deporte, boolean tabaco, boolean hijos) {
        this.idUsuario = idUsuario;
        this.bio = " ";
        this.trabajo = trabajo;
        this.formacion = formacion;
        this.ciudad="Madrid";
        this.estatura = estatura;
        this.alcohol = alcohol;
        this.deporte = deporte;
        this.tabaco = tabaco;
        this.hijos = hijos;
        this.fotos=" ";
    }
  
    
    //con bio, ciudad, fotos por defecto sin idUsuario
    public Caracteristicas(String trabajo, String formacion, Integer estatura, boolean alcohol, boolean deporte, boolean tabaco, boolean hijos) {
        this.bio = " ";
        this.trabajo = trabajo;
        this.formacion = formacion;
        this.ciudad="Madrid";
        this.estatura = estatura;
        this.alcohol = alcohol;
        this.deporte = deporte;
        this.tabaco = tabaco;
        this.hijos = hijos;
        this.fotos=" ";
    }
    //Para los usuarios que ya tienen un perfil creado
    public Caracteristicas(String bio, String trabajo, String formacion, String ciudad, Integer estatura, boolean alcohol, boolean deporte, boolean tabaco, boolean hijos, String fotos) {
        this.bio = bio;
        this.trabajo = trabajo;
        this.formacion = formacion;
        this.ciudad = ciudad;
        this.estatura = estatura;
        this.alcohol = alcohol;
        this.deporte = deporte;
        this.tabaco = tabaco;
        this.hijos = hijos;
        this.fotos = fotos;
    }
    //Para usuarios que no tienen un perfil creado

    public Caracteristicas(int idUsuario, String bio, String trabajo, String formacion, String ciudad, Integer estatura, boolean alcohol, boolean deporte, boolean tabaco, boolean hijos, String fotos) {
        this.idUsuario = idUsuario;
        this.bio = bio;
        this.trabajo = trabajo;
        this.formacion = formacion;
        this.ciudad = ciudad;
        this.estatura = estatura;
        this.alcohol = alcohol;
        this.deporte = deporte;
        this.tabaco = tabaco;
        this.hijos = hijos;
        this.fotos = fotos;
    }
    
    
    
    
//GET & SET:
    public int getIdCaracteristicas() {
        return idCaracteristicas;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
    
    
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getFormacion() {
        return formacion;
    }

    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public boolean isAlcohol() {
        return alcohol;
    }

    public void setAlcohol(boolean alcohol) {
        this.alcohol = alcohol;
    }

    public boolean isDeporte() {
        return deporte;
    }

    public void setDeporte(boolean deporte) {
        this.deporte = deporte;
    }

    public boolean isTabaco() {
        return tabaco;
    }

    public void setTabaco(boolean tabaco) {
        this.tabaco = tabaco;
    }

    public boolean isHijos() {
        return hijos;
    }

    public void setHijos(boolean hijos) {
        this.hijos = hijos;
    }

    public String getFotos() {
        return fotos;
    }

    public void setFotos(String fotos) {
        this.fotos = fotos;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idCaracteristicas;
        hash = 79 * hash + this.idUsuario;
        hash = 79 * hash + Objects.hashCode(this.bio);
        hash = 79 * hash + Objects.hashCode(this.trabajo);
        hash = 79 * hash + Objects.hashCode(this.formacion);
        hash = 79 * hash + Objects.hashCode(this.ciudad);
        hash = 79 * hash + Objects.hashCode(this.estatura);
        hash = 79 * hash + (this.alcohol ? 1 : 0);
        hash = 79 * hash + (this.deporte ? 1 : 0);
        hash = 79 * hash + (this.tabaco ? 1 : 0);
        hash = 79 * hash + (this.hijos ? 1 : 0);
        hash = 79 * hash + Objects.hashCode(this.fotos);
        return hash;
    }

    //HASH & EQUALS:
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
        final Caracteristicas other = (Caracteristicas) obj;
        if (this.idCaracteristicas != other.idCaracteristicas) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.alcohol != other.alcohol) {
            return false;
        }
        if (this.deporte != other.deporte) {
            return false;
        }
        if (this.tabaco != other.tabaco) {
            return false;
        }
        if (this.hijos != other.hijos) {
            return false;
        }
        if (!Objects.equals(this.bio, other.bio)) {
            return false;
        }
        if (!Objects.equals(this.trabajo, other.trabajo)) {
            return false;
        }
        if (!Objects.equals(this.formacion, other.formacion)) {
            return false;
        }
        if (!Objects.equals(this.ciudad, other.ciudad)) {
            return false;
        }
        if (!Objects.equals(this.fotos, other.fotos)) {
            return false;
        }
        return Objects.equals(this.estatura, other.estatura);
    }

    //STRING:
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("idUsuario: ").append(idUsuario);
        sb.append("\n\tidCaracteristicas: ").append(idCaracteristicas);
        sb.append("\n\t bio: ").append(bio);
        sb.append("\n\t trabajo: ").append(trabajo);
        sb.append("\n\t formacion: ").append(formacion);
        sb.append("\n\t ciudad: ").append(ciudad);
        sb.append("\n\t estatura: ").append(estatura);
        sb.append("\n\t alcohol: ").append(alcohol);
        sb.append("\n\t deporte: ").append(deporte);
        sb.append("\n\t tabaco: ").append(tabaco);
        sb.append("\n\t hijos: ").append(hijos);
        sb.append("\n\t fotos: ").append(fotos);
        return sb.toString();
    }
}
