package web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.io.FileInputStream;
import java.io.IOException;

public class EnMantenimientoInterceptor implements Interceptor {

    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        //valida que el archivo este en la siguiente ruta.
        try (FileInputStream fis = new FileInputStream("c:/temp/estado.txt")) {
            byte[] data = new byte[fis.available()];
            fis.read(data);
            String acceso = new String(data);
            if (acceso.equals("en mantenimiento")) {
                return "cerrado";
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ai.invoke();
    }

}
