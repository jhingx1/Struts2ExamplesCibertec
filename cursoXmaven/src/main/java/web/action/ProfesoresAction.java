package web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;
import dao.DaoProfesores;
import dao.impl.DaoProfesoresImpl;
import dto.Profesores;
import parainfo.convert.DeString;

public class ProfesoresAction 
	extends ActionSupport implements Validateable {

	private static final long serialVersionUID = 1L;

	private Profesores profesores;
	private List<Profesores> list;

	public ProfesoresAction() {
	}

	// getter y setter
	public Profesores getProfesores() {
		return profesores;
	}

	public void setProfesores(Profesores profesores) {
		this.profesores = profesores;
	}

	public List<Profesores> getList() {
		DaoProfesores daoProfesores = new DaoProfesoresImpl();
		list = daoProfesores.profesoresQry();

		if (list == null) {
			String message = daoProfesores.getMessage();

			HttpServletRequest request = 
					ServletActionContext.getRequest();
			request.setAttribute("msg", message);
		}

		return list;
	}

	// gestiona CRUD
	public String profesoresIns() {
		DaoProfesores daoProfesores = new DaoProfesoresImpl();
		String result = daoProfesores.profesoresIns(profesores);

		if (result != null) {
			HttpServletRequest request = 
					ServletActionContext.getRequest();
			request.setAttribute("msg", result);
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	public String profesoresDel() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Integer> ids = DeString.ids(request.getParameter("ids"));

		String result;
		if (ids == null) {
			result = "Lista de ID(s) incorrecta";
		} else {
			DaoProfesores daoProfesores = new DaoProfesoresImpl();
			result = daoProfesores.profesoresDel(ids);
		}

		if (result == null) {
			request.getSession().removeAttribute("msg");
			return SUCCESS;
		} else {
			request.getSession().setAttribute("msg", result);
			return ERROR;
		}
	}

	public String profesoresGet() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer idprofesores = 
				DeString.aInteger(request.getParameter("idprofesores"));

		String result = null;
		if (idprofesores != null) {
			DaoProfesores daoProfesores = new DaoProfesoresImpl();
			profesores = daoProfesores.profesoresGet(idprofesores);

			if (profesores == null) {
				result = daoProfesores.getMessage();
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

	public String profesoresUpd() {
		DaoProfesores daoProfesores = new DaoProfesoresImpl();
		String result = daoProfesores.profesoresUpd(profesores);

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
		if (profesores != null) {
			if ((profesores.getNombreprofesores()== null) 
					|| (profesores.getNombreprofesores().trim().length() == 0)) {
				addFieldError("profesores.autor", "Ingrese nombre de Autor");
			}
		}
	}
}


