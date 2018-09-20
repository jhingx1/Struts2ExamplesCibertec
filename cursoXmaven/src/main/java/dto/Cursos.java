package dto;

import java.sql.Date;
import java.sql.Time;

public class Cursos {
    
    private Integer idcursos;
    private String nombrecursos;
    private String descripcion;
    private Date fechainicio;
    private Date fechafin;
    private Time horaInicio;
    private String tipo;
    private Integer horas;
    private Integer idprofesores;

    public Cursos() {
    }

    public Integer getIdcursos() {
        return idcursos;
    }

    public void setIdcursos(Integer idcursos) {
        this.idcursos = idcursos;
    }

    public String getNombrecursos() {
        return nombrecursos;
    }

    public void setNombrecursos(String nombrecursos) {
        this.nombrecursos = nombrecursos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Integer getIdprofesor() {
        return idprofesores;
    }

    public void setIdprofesor(Integer idprofesores) {
        this.idprofesores = idprofesores;
    }
    
    
    
}
