package web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;

public class ActionData extends ActionSupport implements Validateable {

    private String alumno;
    private Integer nota;
    
    private String nombre;
    private Integer monto;
    

    public ActionData() {
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }
    

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (getAlumno() != null){
            int lenalumno = getAlumno().trim().length();
            if (lenalumno == 0) {
                addFieldError("alumno", "ingrese nombre de Alumno");
            } else if ((lenalumno < 3) || (lenalumno > 50)) {
                addFieldError("alumno", "de [3, 50] caracteres.");
            }
            if (getNota() == null) {
                addFieldError("nota", "ingrese nota válida");
            } else if ((getNota() < 0) || (getNota() > 20)) {
                addFieldError("nota", "nota entre [0, 20]");
            }

            int lenNombre = getNombre().trim().length();
            if (lenNombre == 0) {
                addFieldError("nombre", "ingrese nombre");
            }
            if (getNota() == null) {
                addFieldError("monto", "ingrese monto válida");
            } else if ((getNota() < 0) || (getNota() > 20)) {
                addFieldError("monto", "montos entre [0, 20]");
            }
        }
        
    }

}
