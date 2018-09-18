package web.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;

public class ActionData extends ActionSupport {

    private Date fecha;

    public ActionData() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

}
