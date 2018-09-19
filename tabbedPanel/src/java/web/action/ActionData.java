package web.action;

import com.opensymphony.xwork2.ActionSupport;

public class ActionData extends ActionSupport {

    private String msg;

    public ActionData() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String mensaje1() {
        setMsg("Este es el mensaje 1.");
        return SUCCESS;
    }

    public String mensaje2() {
        setMsg("Este es el mensaje 2.");
        return SUCCESS;
    }

    public String mensaje3() {
        setMsg("Este es el mensaje 3.");
        return SUCCESS;
    }

}
