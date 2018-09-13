package web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;
import dto.Curso;
import dto.FormaPago;
import dto.Local;
import dto.Turno;
import java.util.ArrayList;
import java.util.List;

public class ActionData extends ActionSupport implements Validateable{
   
    //Curso
    private Integer curso; //select
    private List<Curso> cboCursos; //Añadir Data al select
    
    public List<Curso> getCboCursos() {
        cboCursos = new ArrayList<>();
        cboCursos.add(new Curso(1, "Lenguaje Java"));
        cboCursos.add(new Curso(2, "Lenguaje PHP"));
        cboCursos.add(new Curso(3, "Lenguaje Python"));        
        return cboCursos;
    }
    
    //Local
    private Integer local; //select
    private List<Local> cboLocal; //Añadir Data al select
    
    public List<Local> getCboLocal() {
        cboLocal = new ArrayList<>();
        cboLocal.add(new Local(1, "Miraflores"));
        cboLocal.add(new Local(2, "Surco"));
        cboLocal.add(new Local(3, "Arequipa"));        
        return cboLocal;
    }
    
    //Turno
    private Integer turno; //radio   
    private List<Turno> cboTurno;
    
    public List<Turno> getCboTurno() {
        cboTurno = new ArrayList<>();
        cboTurno.add(new Turno(0, "Mañana"));
        cboTurno.add(new Turno(1, "Tarde"));
        cboTurno.add(new Turno(2, "Noche"));        
        return cboTurno;
    }

    //Forma de Pago
    private List<Integer> formaPago;
    private List<FormaPago> cboFormaPago;
    
    public List<FormaPago> getCboFormaPago() {
        cboFormaPago = new ArrayList<>();
        cboFormaPago.add(new FormaPago(0, "Contado"));
        cboFormaPago.add(new FormaPago(1, "Credito"));              
        return cboFormaPago;
    }
    
    public List<Integer> getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(List<Integer> formaPago) {
        this.formaPago = formaPago;
    }
    
    public Integer getTurno() {
        return turno;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }
    
    public Integer getLocal() {
        return local;
    }

    public void setLocal(Integer local) {
        this.local = local;
    }
    //Alumno    
    private String alumno;
    //Total pago
    private Integer totalPago;

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }    

    public Integer getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(Integer totalPago) {
        this.totalPago = totalPago;
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }
   //Metodo principal
    @Override
    public String execute() throws Exception {
        
        return SUCCESS;
    }
    
    @Override
    public void validate() {
        if (getAlumno() != null){
            int lenAlumno = getAlumno().trim().length();
            if(lenAlumno == 0){
                addFieldError("alumno", "Ingrese Nombre Alumno");
            }else if((lenAlumno < 3) || (lenAlumno > 50)){
                addFieldError("alumno","Nombre ");
            }
        }
        //Ckbox
        if (getFormaPago() != null){
            if(getFormaPago().size() == 0){
                addFieldError("formaPago", "Seleccione Forma de Pago");
            }            
        }
        //
        if(getTotalPago() != null){
//            addFieldError("totalPago", "Ingrese Total a Pagar");
//            if(getTotalPago() == 0){
//                
//            }
              if(getTotalPago() == 0){
                  addFieldError("totalPago", "Ingrese Total a Pagar");
              }              
            
        }else{
            setTotalPago(0);
        }
        
    }
    
}
