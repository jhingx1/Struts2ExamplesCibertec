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

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        
        //Para manipular los parametros
        ValueStack stack = ai.getStack();
        String s = stack.findString("user");
        if (s.length() != 0) {
            stack.set("user", s.toUpperCase());
            
            if(s.equalsIgnoreCase("Jean Huaringa")){
                stack.set("user","Jean Huaringa");
            }else{
                //stack.set("user","Acceso Restingido");
                return "AccesoRestingido";
            }
            
        }else {
            //stack.set("user", "DESCONOCIDO");
            return "AccesoRestingido";
        }
        
        return ai.invoke();
        
    }

}
