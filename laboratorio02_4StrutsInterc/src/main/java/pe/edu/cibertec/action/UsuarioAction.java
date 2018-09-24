/* */
package pe.edu.cibertec.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import pe.edu.cibertec.model.Usuario;

/**
 *
 * @author JAdv100-VS
 */
public class UsuarioAction extends ActionSupport {

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String login() throws Exception {

        if (usuario.getUsername().equals("pepe") && usuario.getPassword().equals("123")) {

            //obtenemos sesion
            Map sesion = ActionContext.getContext().getSession();

            //guardamos objetos en sesion
            sesion.put("usuario", getUsuario().getUsername());

            addActionMessage("Usted tiene nuevos mensajes (2)."
                    + "Revisar su buzón de correos");

            return SUCCESS;

        } else {
            addActionError("Credenciales incorrectas");
            return LOGIN;
        }

    }

    public String logout() throws Exception {

        //obtenemos sesison
        Map sesion = ActionContext.getContext().getSession();
        SessionMap sessionMap = (SessionMap) sesion;
        sessionMap.invalidate();

        return LOGIN;

    }
}
