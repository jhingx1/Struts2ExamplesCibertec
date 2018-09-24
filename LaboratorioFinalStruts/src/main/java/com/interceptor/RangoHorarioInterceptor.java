package com.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.Calendar;

/**
 *
 * @author Ludwig
 */
public class RangoHorarioInterceptor implements Interceptor{

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        Calendar c1 = Calendar.getInstance();
        Integer hora = c1.get(Calendar.HOUR_OF_DAY);
        if(hora>20){
            return "cerrado";
        }
        if(hora<3){
            return "cerrado";
        }
        return ai.invoke();
    }
    
}
