package web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;
import dao.DaoAlumnos;
import dao.DaoCursos;
import dao.impl.DaoAlumnosImpl;
import dao.impl.DaoCursosImpl;
import dto.Alumnos;
import dto.Cursos;
import parainfo.convert.DeString;

public class CursosAction
        extends ActionSupport implements Validateable {

    private static final long serialVersionUID = 1L;

    private Cursos cursos;
    private List<Object[]> list;
    private List<Alumnos> cboAlumnos;

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

            HttpServletRequest request
                    = ServletActionContext.getRequest();
            request.setAttribute("msg", message);
        }

        return list;
    }

    public List<Alumnos> getCboAlumnos() {
        DaoAlumnos daoAlumnos = new DaoAlumnosImpl();
        cboAlumnos = daoAlumnos.alumnosQry();
        return cboAlumnos;
    }


    public String cursosIns() {
        DaoCursos daoCursos = new DaoCursosImpl();
        String result = daoCursos.cursosIns(cursos);

        if (result != null) {
            HttpServletRequest request
                    = ServletActionContext.getRequest();
            request.setAttribute("msg", result);
            return ERROR;
        } else {
            return SUCCESS;
        }
    }

    public String cursosDel() {
        HttpServletRequest request
                = ServletActionContext.getRequest();
        List<Integer> ids
                = DeString.ids(request.getParameter("ids"));

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
        HttpServletRequest request
                = ServletActionContext.getRequest();
        Integer idfrase
                = DeString.aInteger(request.getParameter("ids"));

        String result = null;
        if (idfrase != null) {
            DaoCursos daoCursos = new DaoCursosImpl();
            cursos = daoCursos.cursosGet(idfrase);

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
            HttpServletRequest request
                    = ServletActionContext.getRequest();
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
            if ((cursos.getProfesor()== null)
                    || (cursos.getProfesor().trim().length() == 0)) {
                addFieldError("cursos.profesor",
                        "Ingrese el nombre del Profesor");
            }

            if ((cursos.getAula()== null)
                    || (cursos.getAula().trim().length() == 0)) {
                addFieldError("cursos.aula",
                        "Ingrese el Aula de clase");
            }            
        }

    }

}
