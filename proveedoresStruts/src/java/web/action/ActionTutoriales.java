package web.action;

import com.opensymphony.xwork2.ActionSupport;
import dto.Tutoriales;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.impl.DaoTutorialesImpl;
import org.apache.struts2.ServletActionContext;
import dao.DaoTutoriales;

public class ActionTutoriales extends ActionSupport {

    private List<Tutoriales> list;
    private Tutoriales tutoriales;
    private String precio;

    public ActionTutoriales() {
    }

    // gettter y setter
    public List<Tutoriales> getList() {
        DaoTutoriales daoTutoriales = new DaoTutorialesImpl();
        list = daoTutoriales.tutorialesQry();

        return list;
    }

    public Tutoriales getTutoriales() {
        return tutoriales;
    }

    public void setTutoriales(Tutoriales tutoriales) {
        this.tutoriales = tutoriales;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    // gestiona CRUD
    public String tutorialesQry() {
        return SUCCESS;
    }

    public String tutorialesIns() {
        String error = valida();

        if (error == null) {
            DaoTutoriales daoTutoriales = new DaoTutorialesImpl();
            error = daoTutoriales.tutorialesIns(tutoriales);
        }

        HttpServletRequest request = ServletActionContext.getRequest();
        if (error == null) {
            request.getSession().removeAttribute("error");
            return SUCCESS;
        } else {
            request.getSession().setAttribute("error", error);
            return ERROR;
        }
    }

    public String tutorialesDel() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String ids = request.getParameter("ids");
        String error = null;

        String[] id = ids.split(",");
        List<Integer> list_id = new ArrayList<>();
        for (String ix : id) {
            try {
                Integer idtutorial = Integer.valueOf(ix);
                list_id.add(idtutorial);

            } catch (NumberFormatException e) {
                error = "Valor errado de idtutorial";
            }
        }

        if (error == null) {
            DaoTutoriales daoTutoriales = new DaoTutorialesImpl();
            error = daoTutoriales.tutorialesDel(list_id);
        }

        if (error == null) {
            request.getSession().removeAttribute("error");
            return SUCCESS;
        } else {
            request.getSession().setAttribute("error", error);
            return ERROR;
        }
    }

    public void tutorialesGet() {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String id = request.getParameter("id");

        DaoTutoriales daoTutoriales = new DaoTutorialesImpl();
        Tutoriales p = daoTutoriales.tutorialesGet(Integer.valueOf(id));

        if (p != null) {
            String result = p.getIdtutorial() + "+++"
                    + p.getTitulo() + "+++"
                    + p.getTipo() + "+++"
                    + p.getPrecio();

            try {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    out.print(result);
                }
            } catch (IOException ex) {
            }
        }
    }

    public String tutorialesUpd() {
        String error = valida();

        if (error == null) {
            DaoTutoriales daoTutoriales = new DaoTutorialesImpl();
            error = daoTutoriales.tutorialesUpd(tutoriales);
        }

        HttpServletRequest request = ServletActionContext.getRequest();
        if (error == null) {
            request.getSession().removeAttribute("error");
            return SUCCESS;
        } else {
            request.getSession().setAttribute("error", error);
            return ERROR;
        }
    }

    // apoyo
    private String valida() {
        String error = null;

        if (tutoriales.getTitulo().trim().length() == 0) {
            error = "Debe ingresar T&iacute;tulo de Producto";
        }

        if (error == null) {
            if (tutoriales.getTipo().trim().length() == 0) {
                error = "Debe ingresar Tipo de Producto";
            }
        }

        if (error == null) {
            try {
                tutoriales.setPrecio(Double.valueOf(precio));
            } catch (NumberFormatException e) {
                error = "Error en ingreso de Precio de Producto";
            }
        }

        return error;
    }
}
