package com.action;

import com.entity.Usuario;
import static com.opensymphony.xwork2.Action.LOGIN;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;

public class UsuarioAction extends ActionSupport {

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String inicio() {
        return LOGIN;
    }

    public String login() throws Exception {

        if (usuario.getUsername().equals("admin") && usuario.getPassword().equals("admin")) {

            Map sesion = ActionContext.getContext().getSession();

            sesion.put("usuario", getUsuario().getUsername());
            addActionMessage("Hola");
            return SUCCESS;
        } else {
            addActionError("Usuario o pasword incorrectos.");
            return LOGIN;
        }

    }
    
    public String irPrincipal(){
        return SUCCESS;
    }
    
    public String logout(){
        Map sesion = ActionContext.getContext().getSession();
        SessionMap sesionmap = (SessionMap)sesion;
        sesionmap.invalidate();
        
        return LOGIN;
    }

    @Override
    public void validate() {
        if(getUsuario()!=null){
            String user = getUsuario().getUsername();
            String password = getUsuario().getPassword();
            if(user == null || user.equals("")){
                addFieldError("usuario.username", "Ingrese usuario");
            }
            if(password==null || password.equals("")){
                addFieldError("usuario.password", "Ingrese contraseña");
            }
        }
    }
    
    
}
