package dto;

import java.sql.Timestamp;

public class Profesores {

    private Integer idprofesores;
    private String nombreprofesores;
    private String carrera;
    private Timestamp fechahoraingreso;
    private String tipocontrato;

    public Profesores() {
    }

    public Integer getIdprofesores() {
        return idprofesores;
    }

    public void setIdprofesores(Integer idprofesores) {
        this.idprofesores = idprofesores;
    }

    public String getNombreprofesores() {
        return nombreprofesores;
    }

    public void setNombreprofesores(String nombreprofesores) {
        this.nombreprofesores = nombreprofesores;
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
