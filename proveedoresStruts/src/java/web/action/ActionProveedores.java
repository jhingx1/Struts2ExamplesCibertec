package web.action;

import com.opensymphony.xwork2.ActionSupport;
import dto.Proveedores;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.impl.DaoProveedoresImpl;
import org.apache.struts2.ServletActionContext;
import dao.DaoProveedores;

public class ActionProveedores extends ActionSupport {

    private List<Proveedores> list;
    private Proveedores proveedores;
    private String correo;
    private String telefono;

    public ActionProveedores() {
    }

    // gettter y setter
    public List<Proveedores> getList() {
        DaoProveedores daoProveedores = new DaoProveedoresImpl();
        list = daoProveedores.proveedoresQry();

        return list;
    }

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    // gestiona CRUD
    public String proveedoresQry() {
        return SUCCESS;
    }

    public String proveedoresIns() {
        String error = valida();

        if (error == null) {
            DaoProveedores daoProveedores = new DaoProveedoresImpl();
            error = daoProveedores.proveedoresIns(proveedores);
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

    public String proveedoresDel() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String ids = request.getParameter("ids");
        String error = null;

        String[] id = ids.split(",");
        List<Integer> list_id = new ArrayList<>();
        for (String ix : id) {
            try {
                Integer idproveedor = Integer.valueOf(ix);
                list_id.add(idproveedor);

            } catch (NumberFormatException e) {
                error = "Valor errado de idproveedor";
            }
        }

        if (error == null) {
            DaoProveedores daoProveedores = new DaoProveedoresImpl();
            error = daoProveedores.proveedoresDel(list_id);
        }

        if (error == null) {
            request.getSession().removeAttribute("error");
            return SUCCESS;
        } else {
            request.getSession().setAttribute("error", error);
            return ERROR;
        }
    }

    public void proveedoresGet() {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String id = request.getParameter("id");

        DaoProveedores daoProveedores = new DaoProveedoresImpl();
        Proveedores p = daoProveedores.proveedoresGet(Integer.valueOf(id));

        if (p != null) {
            String result = p.getIdproveedor() + "+++"
                    + p.getNombre() + "+++"
                    + p.getRuc() + "+++"
                    + p.getCorreo()+"+++"
                    +p.getTelefono();

            try {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    out.print(result);
                }
            } catch (IOException ex) {
            }
        }
    }

    public String proveedoresUpd() {
        String error = valida();

        if (error == null) {
            DaoProveedores daoProveedores = new DaoProveedoresImpl();
            error = daoProveedores.proveedoresUpd(proveedores);
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

        if (proveedores.getNombre().trim().length() == 0) {
            error = "Debe ingresar T&iacute;tulo de Producto";
        }

        if (error == null) {
            if (proveedores.getRuc().trim().length() == 0) {
                error = "Debe ingresar Ruc de Producto";
            }
        }

        if (error == null) {
            try {
                proveedores.setCorreo(correo);
            } catch (NumberFormatException e) {
                error = "Error en ingreso de Correo de Producto";
            }
        }
        
        if (error == null) {
            try {
                proveedores.setTelefono(telefono);
            } catch (NumberFormatException e) {
                error = "Error en ingreso de Correo de Producto";
            }
        }
                
        return error;
    }   
    
}
