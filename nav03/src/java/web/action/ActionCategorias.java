package web.action;

import com.opensymphony.xwork2.ActionSupport;

public class ActionCategorias extends ActionSupport {

    private String msg;

    public ActionCategorias() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String categoriasIns() {
        setMsg("categoriasIns");
        return SUCCESS;
    }

    public String categoriasDel() {
        setMsg("categoriasDel");
        return SUCCESS;
    }

    public String categoriasUpd() {
        setMsg("categoriasUpd");
        return SUCCESS;
    }

}
