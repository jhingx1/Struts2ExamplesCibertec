package web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;


public class UpperInterceptor implements Interceptor {

    @Override
    public void destroy() {
        
    }

    @Override
    public void init() {
        
    }
    //metodo para manejar los parametros.
    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        //Notas que no inpide que se valla al jsp welcome
        //no se lo esta inpidiendo.
        ValueStack stack = ai.getStack();
        String s = stack.findString("user");
        if (s.length() != 0) {
            //envia el nombre en mayusculas
            stack.set("user", s.toUpperCase());
        } else {
            //envia el usuaior DESCONOCIDO
            stack.set("user", "DESCONOCIDO");
        }
        return ai.invoke();
        
    }

}
