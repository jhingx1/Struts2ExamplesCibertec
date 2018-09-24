/* */
package pe.edu.cibertec.model;

import java.io.Serializable;

/**
 *
 * @author JAdv100-VS
 */
public class Cliente implements Serializable{
    
    private Integer codigo;
    private String nombre;
    private String apellido;
    private Character genero;
    private String profesion;
    private String numeroMovil;
    private String operadorMovil;
    private Boolean publicidad;
    private String correo;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getNumeroMovil() {
        return numeroMovil;
    }

    public void setNumeroMovil(String numeroMovil) {
        this.numeroMovil = numeroMovil;
    }

    public String getOperadorMovil() {
        return operadorMovil;
    }

    public void setOperadorMovil(String operadorMovil) {
        this.operadorMovil = operadorMovil;
    }

    public Boolean getPublicidad() {
        return publicidad;
    }

    public void setPublicidad(Boolean publicidad) {
        this.publicidad = publicidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}
