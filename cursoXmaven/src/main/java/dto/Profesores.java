package dto;

import java.sql.Timestamp;

public class Profesores {

    private Integer idprofesor;
    private String nombreprofesor;
    private String carrera;
    private Timestamp fechahoraingreso;
    private String tipocontrato;

    public Profesores() {
    }

    public Integer getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(Integer idprofesor) {
        this.idprofesor = idprofesor;
    }

    public String getNombreprofesor() {
        return nombreprofesor;
    }

    public void setNombreprofesor(String nombreprofesor) {
        this.nombreprofesor = nombreprofesor;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Timestamp getFechahoraingreso() {
        return fechahoraingreso;
    }

    public void setFechahoraingreso(Timestamp fechahoraingreso) {
        this.fechahoraingreso = fechahoraingreso;
    }

    public String getTipocontrato() {
        return tipocontrato;
    }

    public void setTipocontrato(String tipocontrato) {
        this.tipocontrato = tipocontrato;
    }

    
    
}
