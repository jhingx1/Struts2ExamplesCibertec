/* */
package pe.edu.cibertec.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import java.util.Map;
import pe.edu.cibertec.model.Cliente;

/**
 *
 * @author JAdv100-VS
 */
public class ClienteAction extends ActionSupport{
    
    private Cliente cliente;
    private Map operadores;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Map getOperadores() {
        return operadores;
    }

    public void setOperadores(Map operadores) {
        this.operadores = operadores;
    }
    
 public String inicializar() throws Exception{
     
     //inicializa lista de operadores segun pais de cliente
     String pais="PERU";
     operadores=new HashMap();
     if(pais.equals("PERU")){
         operadores.put("01", "OPERADOR 1");
         operadores.put("02", "OPERADOR 2");
         operadores.put("03", "OPERADOR 3");
     }else{
         operadores.put("0F", "OPERADOR FORANEO");
     }
     return SUCCESS;
 }
    
    public String registrar() throws Exception{
        return SUCCESS;
    }
    
}
