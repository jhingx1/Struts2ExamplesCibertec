package web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

public class ActionData extends ActionSupport {

    private String usuario;
    private String password;

    public ActionData() {
    }

    public String getUsuario() {
        return usuario;
    }

    @RequiredStringValidator(key = "valida.usuario", trim = true)
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    @RequiredStringValidator(key = "valida.password", trim = true)
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String execute() throws Exception {
        
        //validaciones de usuario.
        if (getUsuario().compareTo("admin") == 0 && getPassword().compareTo("123") == 0) {
            return SUCCESS;
        } else {
            return INPUT;
        }
    }

}
