package web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

public class ActionData extends ActionSupport{

    private String alumno;
    private Integer nota;        
    private String correo;
    
    //Ruta para validadion por anotaciones 
    //https://struts.apache.org/core-developers/annotations.html#validation-annotations
    
    public ActionData() {
    }

    public String getAlumno() {
        return alumno;
    }
    
    //Para validar con anotaciones.
    @RequiredStringValidator(message = "Debe ingresar Alumno", trim = true)
    @StringLengthFieldValidator(message = "Entre [3, 50] caracteres",
            trim = true, minLength = "3", maxLength = "50")
    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public Integer getNota() {
        return nota;
    }
    //Anotaciones para Integer
    @RequiredFieldValidator(message = "Debe ingresar nota")
    @IntRangeFieldValidator(message = "Entre [0, 20]", min = "0", max = "20") 
    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getCorreo() {
        return correo;
    }
    //Anotaciones para String
    @RequiredStringValidator(message = "Debe ingresar un Correo", trim = true)
    @EmailValidator(message = "Ingresar un Correo Correcto", key = "i18n.key", shortCircuit = true)
    public void setCorreo(String correo) {
        this.correo = correo;
    }    
    
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    
}
