package web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;
import dao.DaoAmigos;
import dao.impl.DaoAmigosImpl;
import dto.Amigos;
import parainfo.convert.DeString;

public class AutoresAction
        extends ActionSupport implements Validateable {

    private static final long serialVersionUID = 1L;

    private Amigos amigos;
    private List<Amigos> list;

    
    public AutoresAction() {
    }


    public Amigos getAmigos() {
        return amigos;
    }

    public void setAmigos(Amigos amigos) {
        this.amigos = amigos;
    }


    public List<Amigos> getList() {
        DaoAmigos daoAmigos = new DaoAmigosImpl();
        list = daoAmigos.amigosQry();

        if (list == null) {
            String message = daoAmigos.getMessage();

            HttpServletRequest request
                    = ServletActionContext.getRequest();
            request.setAttribute("msg", message);
        }

        return list;
    }

    // gestiona CRUD
    public String amigosIns() {
        DaoAmigos daoAmigos = new DaoAmigosImpl();
        String result = daoAmigos.amigosIns(amigos);

        if (result != null) {
            HttpServletRequest request
                    = ServletActionContext.getRequest();
            request.setAttribute("msg", result);
            return ERROR;
        } else {
            return SUCCESS;
        }
    }

    public String amigosDel() {
        HttpServletRequest request
                = ServletActionContext.getRequest();
        List<Integer> ids
                = DeString.ids(request.getParameter("ids"));

        String result;
        if (ids == null) {
            result = "Lista de ID(s) incorrecta";
        } else {
            DaoAmigos daoAmigos = new DaoAmigosImpl();
            result = daoAmigos.amigosDel(ids);
        }

        if (result == null) {
            request.getSession().removeAttribute("msg");
            return SUCCESS;
        } else {
            request.getSession().setAttribute("msg", result);
            return ERROR;
        }
    }

    public String amigosGet() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Integer ids
                = DeString.aInteger(request.getParameter("ids"));

        String result = null;
        if (ids != null) {
            DaoAmigos daoAmigos = new DaoAmigosImpl();
            amigos = daoAmigos.amigosGet(ids);

            if (amigos == null) {
                result = daoAmigos.getMessage();
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

    public String amigosUpd() {
        DaoAmigos daoAmigos = new DaoAmigosImpl();
        String result = daoAmigos.amigosUpd(amigos);

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
        
        if (amigos != null) {
            if ((amigos.getNombre()== null)
                    || (amigos.getNombre().trim().length() == 0)) {
                addFieldError("amigos.nombre", "Ingrese nombre");
            }
            if ((amigos.getCorreo()== null)
                    || (amigos.getCorreo().trim().length() == 0)) {
                addFieldError("amigos.correo", "Ingrese correo electronico");
            }
            if ((amigos.getTelefono()== null)
                    || ( amigos.getTelefono().trim().length() == 0)) {
                addFieldError("amigos.telefono", "Ingrese un telefono");
            }
            if ((amigos.getDireccion()== null)
                    || ( amigos.getDireccion().trim().length() == 0)) {
                addFieldError("amigos.direccion", "Ingrese su direccion");
            }
            if ((amigos.getNacimiento()== null)
                    || ( amigos.getNacimiento().toString().trim().length() == 0)) {
                addFieldError("amigos.nacimiento", "Ingrese Fecha de Nacimiento");
            }
        }
    }

}
