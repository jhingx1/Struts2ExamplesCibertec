package web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.Calendar;

public class RangoHoraInterceptor implements Interceptor { //implementamos Interceptor, son tres metodos.

    @Override
    public void destroy() {
        
    }

    @Override
    public void init() {
        
    }

    //implementamos este metodo que es el mas comun.
    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        //validamos que el sistema este en un rango de hora.
        Calendar c1 = Calendar.getInstance();
        Integer hora = c1.get(Calendar.HOUR_OF_DAY);
        if (hora > 15) {//si la hora es mayor a 20 hrs retorna cerrado            
            return "cerrado";  //cerrado es una pagina jsp, con el mensaje que se quiere
        }
        if (hora < 8) {
            return "cerrado";
        }
        //si no ingresa a ninguna opcion pasa el interceptor
        //y lee las demas etiquetas de struts.xml
        return ai.invoke(); 
        
    }

}
