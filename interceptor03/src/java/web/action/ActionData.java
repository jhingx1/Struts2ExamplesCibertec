package web.action;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

public class ActionData extends ActionSupport implements ServletRequestAware {

    private File archivo;//tipo archivo
    private String archivoContentType; //tipos de archivo
    private String archivoFileName;//nombre archivo

    private HttpServletRequest request;

    public ActionData() {
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public String getArchivoContentType() {
        return archivoContentType;
    }

    public void setArchivoContentType(String archivoContentType) {
        this.archivoContentType = archivoContentType;
    }

    public String getArchivoFileName() {
        return archivoFileName;
    }

    public void setArchivoFileName(String archivoFileName) {
        this.archivoFileName = archivoFileName;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String execute() throws Exception {
        try {
            //Para subir un archivo
            String path
                    = request.getSession().getServletContext().getRealPath("/");
            String fileName = this.getArchivoFileName();
            if (fileName == null || fileName.trim().length() == 0) {
                throw new IOException();
            }
            File fileToCreate = new File(path, fileName);
            FileUtils.copyFile(this.archivo, fileToCreate); // guarda en build/web
        } catch (IOException e) {
            addActionMessage("error en archivo");
            return INPUT;
        }
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

}
