
package web.action;

import com.opensymphony.xwork2.ActionSupport;

public class ActionMsg02 extends ActionSupport{
    private String msg2;

    public String getMsg2() {
        return msg2;
    }

    public void setMsg2(String msg2) {
        this.msg2 = msg2;
    }
    @Override
    public String execute() throws Exception {
        setMsg2("Me voy a Struts<sup>2</sup>");
        return SUCCESS;
    }
}
