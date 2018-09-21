package web.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;
import dao.DaoProfesores;
import dao.DaoCursos;
import dao.impl.DaoProfesoresImpl;
import dao.impl.DaoCursosImpl;
import dto.Profesores;
import dto.Cursos;
import parainfo.convert.DeString;

public class CursosAction extends ActionSupport implements Validateable {
    private static final long serialVersionUID = 1L;	
    private Cursos cursos;
    private List<Object[]> list;
    private List<Profesores> cboProfesores;

    public CursosAction() {
    }

    // getter y setter
    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }

    public List<Object[]> getList() {
        DaoCursos daoCursos = new DaoCursosImpl();
        
        list = daoCursos.cursosQry();

        if (list == null) {
            String message = daoCursos.getMessage();

            HttpServletRequest request = 
                    ServletActionContext.getRequest();
            request.setAttribute("msg", message);
        }

        return list;
    }

    public List<Profesores> getCboProfesores() {
        DaoProfesores daoProfesores = new DaoProfesoresImpl();
        cboProfesores = daoProfesores.profesoresQry();
        
        return cboProfesores;
    }

    // gestiona CRUD - C
    public String cursosIns() {
        
    	DaoCursos daoCursos = new DaoCursosImpl();
        String result = daoCursos.cursosIns(cursos);

        if (result != null) {
            HttpServletRequest request = 
                    ServletActionContext.getRequest();
            request.setAttribute("msg", result);
            return ERROR;
        } else {
            return SUCCESS;
        }
    }

    public String cursosDel() {
        HttpServletRequest request = 
        		ServletActionContext.getRequest();
		List<Integer> ids = 
				DeString.ids(request.getParameter("ids"));

        String result;
        if (ids == null) {
            result = "Lista de ID(s) incorrecta";
        } else {
            DaoCursos daoCursos = new DaoCursosImpl();
            result = daoCursos.cursosDel(ids);
        }

        if (result == null) {
            request.getSession().removeAttribute("msg");
            return SUCCESS;
        } else {
            request.getSession().setAttribute("msg", result);
            return ERROR;
        }
    }

    public String cursosGet() {
        HttpServletRequest request = 
        		ServletActionContext.getRequest();
        Integer idcursos
                = DeString.aInteger(request.getParameter("idcursos"));

        String result = null;
        if (idcursos != null) {
            DaoCursos daoCursos = new DaoCursosImpl();
            cursos = daoCursos.cursosGet(idcursos);

            if (cursos == null) {
                result = daoCursos.getMessage();
            }
        } else {
            result = "ID incorrecto";
        }

        if (result == null) {
            request.getSession().removeAttribute("msg");
            return SUCCESS;
        } else {
            request.getSession().setAttribute("msg", result);
            return ERROR;
        }
    }
    
    public String cursosUpd() {
    	DaoCursos daoCursos = new DaoCursosImpl();
        String result = daoCursos.cursosUpd(cursos);

        if (result != null) {
            HttpServletRequest request = 
                    ServletActionContext.getRequest();
            request.setAttribute("msg", result);
            return ERROR;
        } else {
            return SUCCESS;
        }
    }

    // validaciones
    @Override
    public void validate() {
        if (cursos != null) {
            if ((cursos.getIdprofesores()== null)) {
                addFieldError("cursos.idprofesores",
                        "Seleccione Autor");
            }

            if ((cursos.getNombrecursos()== null)
                    || (cursos.getNombrecursos().trim().length() == 0)) {
                addFieldError("cursos.cursos",
                        "ingrese el Nombre del curso");
            }
        }
    }
}

