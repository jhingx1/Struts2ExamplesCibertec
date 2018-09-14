package controllers;

import com.opensymphony.xwork2.ActionSupport;

public class HomeController extends ActionSupport{
    
    private Integer n1;
    private Integer n2;
    private String operacion;
    private Integer resultado;

    @Override
    public String execute() throws Exception {
        
        if(operacion.equals("+"))
            resultado = n1 + n2;
        else if(operacion.equals("-"))
            resultado = n1 - n2;
        else if(operacion.equals("*"))
            resultado = n1 * n2;
        else if(operacion.equals("/"))
            resultado = n1 / n2;
        
        return SUCCESS;
    }    
    
    public Integer getN1() {
        return n1;
    }

    public void setN1(Integer n1) {
        this.n1 = n1;
    }

    public Integer getN2() {
        return n2;
    }

    public void setN2(Integer n2) {
        this.n2 = n2;
    }

    public Integer getResultado() {
        return resultado;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }
       
}
