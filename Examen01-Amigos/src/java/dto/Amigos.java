
package dto;

import java.util.Date;


public class Amigos {
    private Integer idamigo;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    private Date nacimiento;

    public Integer getIdamigo() {
        return idamigo;
    }

    public void setIdamigo(Integer idamigo) {
        this.idamigo = idamigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }
    
}
