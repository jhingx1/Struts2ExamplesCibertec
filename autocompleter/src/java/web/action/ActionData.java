package web.action;

import com.opensymphony.xwork2.ActionSupport;

public class ActionData extends ActionSupport {
    
    private String select;

    public ActionData() {
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
