package web.action;

import com.opensymphony.xwork2.ActionSupport;

public class RegistroUsuarioAction extends ActionSupport {

    private String username;
    private String password;

    @Override
    public String execute() {
        return SUCCESS;
    }
    
    //get and set
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

}
