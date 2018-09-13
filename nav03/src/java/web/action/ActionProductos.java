
package web.action;

import com.opensymphony.xwork2.ActionSupport;

public class ActionProductos extends ActionSupport{
    
    private String msg2;

    public ActionProductos() {
    }

    public String getMsg2() {
        return msg2;
    }

    public void setMsg2(String msg2) {
        this.msg2 = msg2;
    }

    public String produtosIns() {
        setMsg2("productosIns");
        return SUCCESS;
    }
    
    public String produtosDel() {
        setMsg2("productosDel");
        return SUCCESS;
    }
    
    public String produtosUpd() {
        setMsg2("productosUpd");
        return SUCCESS;
    }
    
    
}
