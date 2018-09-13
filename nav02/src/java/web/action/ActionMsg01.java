package web.action;

import com.opensymphony.xwork2.ActionSupport;

public class ActionMsg01 extends ActionSupport {

    private String msg;

    public ActionMsg01() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String execute() throws Exception {
        setMsg("Bienvenido a Struts<sup>2</sup>");
        return SUCCESS;
    }

}
