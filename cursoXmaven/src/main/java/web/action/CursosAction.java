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
    private Cursos frases;
    private List<Object[]> list;
    private List<Profesores> cboProfesores;

    public CursosAction() {
    }

    // getter y setter
    public Cursos getCursos() {
        return frases;
    }

    public void setCursos(Cursos frases) {
        this.frases = frases;
    }

    public List<Object[]> getList() {
        DaoCursos daoCursos = new DaoCursosImpl();
        list = daoCursos.frasesQry();

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
        cboProfesores = daoProfesores.autoresQry();
        
        return cboProfesores;
    }

    // gestiona CRUD
    public String frasesIns() {
    	DaoCursos daoCursos = new DaoCursosImpl();
        String result = daoCursos.frasesIns(frases);

        if (result != null) {
            HttpServletRequest request = 
                    ServletActionContext.getRequest();
            request.setAttribute("msg", result);
            return ERROR;
        } else {
            return SUCCESS;
        }
    }

    public String frasesDel() {
        HttpServletRequest request = 
        		ServletActionContext.getRequest();
		List<Integer> ids = 
				DeString.ids(request.getParameter("ids"));

        String result;
        if (ids == null) {
            result = "Lista de ID(s) incorrecta";
        } else {
            DaoCursos daoCursos = new DaoCursosImpl();
            result = daoCursos.frasesDel(ids);
        }

        if (result == null) {
            request.getSession().removeAttribute("msg");
            return SUCCESS;
        } else {
            request.getSession().setAttribute("msg", result);
            return ERROR;
        }
    }

    public String frasesGet() {
        HttpServletRequest request = 
        		ServletActionContext.getRequest();
        Integer idfrase
                = DeString.aInteger(request.getParameter("idfrase"));

        String result = null;
        if (idfrase != null) {
            DaoCursos daoCursos = new DaoCursosImpl();
            frases = daoCursos.frasesGet(idfrase);

            if (frases == null) {
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
    
    public String frasesUpd() {
    	DaoCursos daoCursos = new DaoCursosImpl();
        String result = daoCursos.frasesUpd(frases);

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
        if (frases != null) {
            if ((frases.getIdautor() == null)) {
                addFieldError("frases.idautor",
                        "Seleccione Autor");
            }

            if ((frases.getFrase() == null)
                    || (frases.getFrase().trim().length() == 0)) {
                addFieldError("frases.frase",
                        "ingrese Frase Célebre");
            }
        }
    }
}

