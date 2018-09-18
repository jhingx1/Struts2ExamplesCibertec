package dto;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Tiempos {

    private Integer idtiempo;
    private Date fecha;
    private Time hora;
    private Timestamp fechahora;

    public Tiempos() {
    }

    public Integer getIdtiempo() {
        return idtiempo;
    }

    public void setIdtiempo(Integer idtiempo) {
        this.idtiempo = idtiempo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Timestamp getFechahora() {
        return fechahora;
    }

    public void setFechahora(Timestamp fechahora) {
        this.fechahora = fechahora;
    }
}

